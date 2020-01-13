package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.column.AdminColumn;
import cn.edu.cdu.wxs.uiaipms.column.CompantColumn;
import cn.edu.cdu.wxs.uiaipms.column.StudentColumn;
import cn.edu.cdu.wxs.uiaipms.column.TutorColumn;
import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.LoginForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.AdminService;
import cn.edu.cdu.wxs.uiaipms.service.CompanyService;
import cn.edu.cdu.wxs.uiaipms.service.StudentService;
import cn.edu.cdu.wxs.uiaipms.service.TutorService;
import cn.edu.cdu.wxs.uiaipms.utils.CodeUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * 处理用户登录请求
 *
 * @author WXS
 * @date 2019/12/16
 */
@RestController
@RequestMapping("api/user")
public class UserLoginController extends BaseController {

    /**
     * 日志
     */
    private static final Logger log = Logger.getLogger("UserController");
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
     * session里的用户
     */
    private static final String SESSION_USER = "user";
    /**
     * session里的角色
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
                session.setAttribute(SESSION_USER, adminService.getByUsername(username, AdminColumn.ADMIN_ID));
                break;
            case "tutor":
                session.setAttribute(SESSION_USER, tutorService.getByUsername(username, TutorColumn.TUTOR_ID));
                break;
            case "student":
                session.setAttribute(SESSION_USER, studentService.getByUsername(username, StudentColumn.STU_ID));
                break;
            case "company":
                session.setAttribute(SESSION_USER, companyService.getByUsername(username, CompantColumn.COM_ID));
                break;
            default:
                break;
        }
    }

}
