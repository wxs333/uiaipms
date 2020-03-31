package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.domain.Company;
import cn.edu.cdu.wxs.uiaipms.form.*;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.*;
import cn.edu.cdu.wxs.uiaipms.utils.CodeUtils;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 处理用户登录请求
 *
 * @author WXS
 * @date 2019/12/16
 */
@RestController
@RequestMapping("api/user")
public class UserApiController extends BaseController {

    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(UserWebController.class);
    /**
     * 学生服务层
     */
    @Autowired
    private StudentService studentService;
    /**
     * 管理员服务层
     */
    @Autowired
    private AdminService adminService;
    /**
     * 导师服务层
     */
    @Autowired
    private TutorService tutorService;
    /**
     * 企业服务层
     */
    @Autowired
    private CompanyService companyService;
    /**
     * ftp服务层
     */
    @Autowired
    private FtpService ftpService;
    /**
     * session里的用户
     */
    private static final String SESSION_USER = "user";
    /**
     * session里的验证码
     */
    private static final String SESSION_CODE = "code";

    /**
     * 用户登录
     *
     * @param form 表单数据
     * @return json
     */
    @PostMapping(value = "login", name = "登录")
    public JsonResult<String> userLogin(LoginForm form, HttpSession session) {
        log.info(form.toString());
        // 验证码验证
        String code = (String) session.getAttribute(SESSION_CODE);
        session.removeAttribute(SESSION_CODE);
        if (!CodeUtils.compare(code, form.getCode())) {
            return jsonResult(GlobalConstant.FAILURE, "验证码错误");
        }
        // 封装用户名和密码
        UsernamePasswordToken token = new UsernamePasswordToken(form.getUsername() + "-" + form.getRole(), form.getPassword());
        // 获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        try {
            // 执行登录验证
            currentUser.login(token);
        } catch (Exception e) {
            return jsonResult(GlobalConstant.FAILURE, "账号或密码错误");
        }
        // 将用户信息放入session
        putUserToSession(session, form.getRole(), form.getUsername());
        return jsonResult("登陆成功");
    }

    /**
     * 产生验证码
     *
     * @param session  会话
     * @param response 响应
     */
    @GetMapping(value = "code", name = "验证码")
    public void produceCode(HttpSession session, HttpServletResponse response) {
        String code = null;
        try {
            code = CodeUtils.getCode(100, 28, "jpeg", response.getOutputStream());
        } catch (IOException e) {
            log.info("生产验证码错误！");
        }
        log.info(code);
        // 保存到session里
        if (!ObjectUtils.isEmpty(code)) {
            session.setAttribute(SESSION_CODE, code);
        }
    }

    /**
     * 头像显示
     *
     * @param response 响应
     */
    @GetMapping("headImg")
    public void headImg(HttpServletResponse response, HttpSession session) {
        String role = (String) session.getAttribute("role");
        String path = null;
        switch (role) {
            case "admin":
                path = ((AdminForm) session.getAttribute(SESSION_USER)).getImage();
                break;
            case "tutor":
                path = ((TutorForm) session.getAttribute(SESSION_USER)).getImage();
                break;
            case "student":
                path = ((StudentForm) session.getAttribute(SESSION_USER)).getImage();
                break;
            case "company":
                path = ((Company) session.getAttribute(SESSION_USER)).getImage();
                break;
            default:
                break;
        }
        try {
            ftpService.download(path, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 头像上传
     *
     * @param multipartFile 文头像件
     */
    @PostMapping("uploadHeadImg")
    public Map<String, Object> uploadHeadImg(@RequestParam("file") MultipartFile multipartFile,
                                             HttpSession session) {
        Map<String, Object> map = new HashMap<>(2);
        try {
            String filename = SystemUtils.getNotRepeatingFilename(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            if (ftpService.upload(GlobalConstant.FTP_HEAD_IMG_DIRECTORY, filename, multipartFile.getInputStream())) {
                // 获取当前登录用户的类型
                String type = (String) session.getAttribute("role");
                // 修改用户图片的路径
                updateImg(session, type, GlobalConstant.FTP_HEAD_IMG_DIRECTORY + filename);
                map.put("msg", "头像修改成功");
                map.put("code", "200");
            }
        } catch (Exception e) {
            map.put("msg", "头像修改失败");
            map.put("code", "0");
        }
        return map;
    }

    /**
     * 在线预览Word文档
     *
     * @param response 响应
     * @param filePath 文件路径
     */
    @GetMapping("previewWord")
    public void previewWord(HttpServletResponse response, String filePath) {
        // 获取文件的输入流
        InputStream inputStream = ftpService.download(filePath);
        // 将Word文档转换未pdf文件
        IConverter converter = LocalConverter.builder().build();
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            boolean result = converter.convert(inputStream)
                    .as(DocumentType.DOCX)
                    .to(outputStream)
                    .as(DocumentType.PDF)
                    .execute();
            if (!result) {
                log.info("文档转换失败");
            }
            outputStream.flush();
        } catch (IOException e) {
            log.info("文档转换失败");
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                log.info("outputStream关闭失败：" + e.getMessage());
            }
        }

    }

    /**
     * 将登录用户放入session里
     *
     * @param session  session
     * @param role     角色
     * @param username 用户名
     */
    private void putUserToSession(HttpSession session, String role, String username) {
        session.setAttribute("role", role);
        switch (role) {
            case "admin":
                session.setAttribute(SESSION_USER, adminService.getByUsername(username));
                break;
            case "tutor":
                session.setAttribute(SESSION_USER, tutorService.getByUsername(username));
                break;
            case "student":
                session.setAttribute(SESSION_USER, studentService.getByUsername(username));
                break;
            case "company":
                session.setAttribute(SESSION_USER, companyService.getByUsername(username));
                break;
            default:
                break;
        }
    }

    /**
     * 修改用户的头像路径
     *
     * @param session 会话
     * @param type    用户类别
     * @param url     路径
     */
    private void updateImg(HttpSession session, String type, String url) {
        Object user = session.getAttribute(SESSION_USER);
        switch (type) {
            case "admin":
                AdminForm adminForm = new AdminForm();
                adminForm.setAdminId(((AdminForm) user).getId());
                adminForm.setImage(url);
                adminForm.setUpdateTime(LocalDateTime.now());
                adminService.modifyById(adminForm);
                break;
            case "tutor":
                TutorForm tutorForm = new TutorForm();
                tutorForm.setTutorId(((TutorForm) user).getId());
                tutorForm.setImage(url);
                tutorForm.setUpdateTime(LocalDateTime.now());
                tutorService.modifyById(tutorForm);
                break;
            case "student":
                StudentForm studentForm = new StudentForm();
                studentForm.setStuId(((StudentForm) user).getId());
                studentForm.setImage(url);
                studentForm.setUpdateTime(LocalDateTime.now());
                studentService.modifyById(studentForm);
                break;
            case "company":
                CompanyForm companyForm = new CompanyForm();
                companyForm.setComId(((CompanyForm) user).getId());
                companyForm.setImage(url);
                companyForm.setUpdateTime(LocalDateTime.now());
                companyService.modifyById(companyForm);
                break;
            default:
                break;
        }
    }

}
