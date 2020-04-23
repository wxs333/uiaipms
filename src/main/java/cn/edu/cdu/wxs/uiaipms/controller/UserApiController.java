package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.exception.AccountUnavailableException;
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
import org.springframework.util.StringUtils;
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
 * 处理用户通用请求
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
     * 邮件服务类
     */
    @Autowired
    private EmailService emailService;
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
        } catch (AccountUnavailableException e) {
            return jsonResult(GlobalConstant.FAILURE, "该账号已被禁用");
        } catch (Exception e1) {
            return jsonResult(GlobalConstant.FAILURE, "账号或密码错误");
        }
        // 将用户信息放入session
        String userId = putUserToSession(session, form.getRole(), form.getUsername());
        return jsonResult(GlobalConstant.SUCCESS, "登录成功", userId + "-" + form.getRole());
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
     * @param session  会话
     * @param userId   用户ID
     */
    @GetMapping("headImg")
    public void headImg(HttpServletResponse response, HttpSession session, String userId) {
        String path = SystemUtils.getImageFromSession(session, userId);
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
     * @param session       会话
     * @param userId        用户id
     */
    @PostMapping("uploadHeadImg")
    public Map<String, Object> uploadHeadImg(@RequestParam("file") MultipartFile multipartFile,
                                             HttpSession session, String userId) {
        Map<String, Object> map = new HashMap<>(2);
        try {
            String filename = SystemUtils.getNotRepeatingFilename(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            if (ftpService.upload(GlobalConstant.FTP_HEAD_IMG_DIRECTORY, filename, multipartFile.getInputStream())) {
                // 获取当前登录用户的类型
                String username = SystemUtils.getUsernameFromSession(session, userId);
                String type = (String) session.getAttribute(username + "-role");
                // 修改用户图片的路径
                updateImg(session, type, GlobalConstant.FTP_HEAD_IMG_DIRECTORY + filename, userId);
                map.put("msg", "头像修改成功");
                map.put("code", "200");
            }
        } catch (Exception e) {
            e.printStackTrace();
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
     * 发送邮件
     *
     * @param email 邮箱
     * @return json
     */
    @GetMapping("sendEmail")
    public JsonResult<String> sendEmail(String email) {
        String code = emailService.sendVerCodeEmail(email);
        if (!StringUtils.isEmpty(code)) {
            return jsonResult(GlobalConstant.SUCCESS, "验证码发送成功", code);
        }
        return jsonResult(GlobalConstant.FAILURE, "验证码发送失败， 请稍后再试");
    }

    /**
     * 找回密码
     *
     * @param password 新密码
     * @param userId   用户id
     * @return json
     */
    @PostMapping("updatePassword")
    public JsonResult<String> updatePassword(String password, String username, HttpSession session, String userId) {
        System.out.println(userId);
        if (StringUtils.isEmpty(username)) {
            username = SystemUtils.getUsernameFromSession(session, userId);
        }
        boolean result = false;
        if (adminService.isUsernameExist(username)) {
            AdminForm adminForm = new AdminForm();
            adminForm.setPassword(SystemUtils.md5(password, username));
            adminForm.setUpdateTime(LocalDateTime.now());
            result = adminService.updatePasswordByUsername(adminForm, username);
        } else if (studentService.isUsernameExist(username)) {
            StudentForm studentForm = new StudentForm();
            studentForm.setPassword(SystemUtils.md5(password, username));
            studentForm.setUpdateTime(LocalDateTime.now());
            result = studentService.updatePasswordByUsername(studentForm, username);
        } else if (tutorService.isUsernameExist(username)) {
            TutorForm tutorForm = new TutorForm();
            tutorForm.setPassword(SystemUtils.md5(password, username));
            tutorForm.setUpdateTime(LocalDateTime.now());
            result = tutorService.updatePasswordByUsername(tutorForm, username);
        } else if (companyService.isUsernameExist(username)) {
            CompanyForm companyForm = new CompanyForm();
            companyForm.setPassword(SystemUtils.md5(password, username));
            companyForm.setUpdateTime(LocalDateTime.now());
            result = companyService.updatePasswordByUsername(companyForm, username);
        }
        if (result) {
            return jsonResult("修改密码成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "账号不存在");
    }

    /**
     * 获取当点登录用户的昵称和角色
     *
     * @param session 会话
     * @param userId  用户ID
     * @return json
     */
    @GetMapping("getNickname")
    public JsonResult<String> getNicknameAndRole(HttpSession session, String userId) {

        return jsonResult(((Map<String, String>) session.getAttribute(userId)).get(GlobalConstant.USER_NICKNAME));
    }

    /**
     * 将登录用户放入session里
     *
     * @param session  session
     * @param role     角色
     * @param username 用户名
     * @return userId
     */
    private String putUserToSession(HttpSession session, String role, String username) {
        String userId = "";
        Map<String, String> sessionMap = new HashMap<>(5);
        session.setAttribute(username + "-role", role);
        switch (role) {
            case "admin":
                AdminForm adminForm = adminService.getByUsername(username);
                userId = adminForm.getAdminId();
                sessionMap.put(GlobalConstant.USER_ID, adminForm.getAdminId());
                sessionMap.put(GlobalConstant.USER_NICKNAME, adminForm.getNickname());
                sessionMap.put(GlobalConstant.USER_IMAGE, adminForm.getImage());
                sessionMap.put(GlobalConstant.USERNAME, adminForm.getUsername());
                break;
            case "tutor":
                TutorForm tutorForm = tutorService.getByUsername(username);
                userId = tutorForm.getTutorId();
                sessionMap.put(GlobalConstant.USER_ID, tutorForm.getTutorId());
                sessionMap.put(GlobalConstant.USER_NICKNAME, tutorForm.getNickname());
                sessionMap.put(GlobalConstant.USER_IMAGE, tutorForm.getImage());
                sessionMap.put(GlobalConstant.USERNAME, tutorForm.getUsername());
                break;
            case "student":
                StudentForm studentForm = studentService.getByUsername(username);
                userId = studentForm.getStuId();
                sessionMap.put(GlobalConstant.USER_ID, studentForm.getStuId());
                sessionMap.put(GlobalConstant.USER_NICKNAME, studentForm.getNickname());
                sessionMap.put(GlobalConstant.USER_IMAGE, studentForm.getImage());
                sessionMap.put(GlobalConstant.USERNAME, studentForm.getUsername());
                break;
            case "company":
                CompanyForm companyForm = companyService.getByUsername(username);
                userId = companyForm.getComId();
                sessionMap.put(GlobalConstant.USER_ID, companyForm.getComId());
                sessionMap.put(GlobalConstant.USER_NICKNAME, companyForm.getComName());
                sessionMap.put(GlobalConstant.USER_IMAGE, companyForm.getImage());
                sessionMap.put(GlobalConstant.USERNAME, companyForm.getUsername());
                break;
            default:
                break;
        }
        session.setAttribute(userId, sessionMap);
        return userId;
    }

    /**
     * 修改用户的头像路径
     *
     * @param session 会话
     * @param type    用户类别
     * @param url     路径
     * @param userId  用户id
     */
    private void updateImg(HttpSession session, String type, String url, String userId) {
        // 修改session里的图片路劲
        SystemUtils.reset(session, "", url, userId);
        switch (type) {
            case "admin":
                AdminForm adminForm = new AdminForm();
                adminForm.setAdminId(userId);
                adminForm.setImage(url);
                adminForm.setUpdateTime(LocalDateTime.now());
                adminService.modifyById(adminForm);
                break;
            case "tutor":
                TutorForm tutorForm = new TutorForm();
                tutorForm.setTutorId(userId);
                tutorForm.setImage(url);
                tutorForm.setUpdateTime(LocalDateTime.now());
                tutorService.modifyById(tutorForm);
                break;
            case "student":
                StudentForm studentForm = new StudentForm();
                studentForm.setStuId(userId);
                studentForm.setImage(url);
                studentForm.setUpdateTime(LocalDateTime.now());
                studentService.modifyById(studentForm);
                break;
            case "company":
                CompanyForm companyForm = new CompanyForm();
                companyForm.setComId(userId);
                companyForm.setImage(url);
                companyForm.setUpdateTime(LocalDateTime.now());
                companyService.modifyById(companyForm);
                break;
            default:
                break;
        }
    }

}
