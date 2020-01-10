package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.LoginForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.UserService;
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
     * 用户的服务层
     */
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param form 表单数据
     * @return json
     */
    @PostMapping(value = "login", name = "登录")
    public JsonResult<String> userLogin(LoginForm form, HttpSession session){
        // 验证码验证
        String code = (String) session.getAttribute("code");
        if (!CodeUtils.compare(code, form.getCode())) {
            return jsonResult(GlobalConstant.FAILURE,"验证码错误");
        }
        // 封装用户名和密码
        UsernamePasswordToken token = new UsernamePasswordToken(form.getUsername(), form.getPassword());
        // 获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        try {
            // 执行登录验证
            currentUser.login(token);
        } catch (Exception e) {
            return jsonResult(GlobalConstant.FAILURE,"账号或密码错误");
        }
        // 将用户信息放入session
        session.setAttribute("user",userService.getByUsername(form.getUsername()));
        return jsonResult("登陆成功");
    }

    /**
     * 产生验证码
     * @param session 会话
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
            session.setAttribute("code", code);
        }
    }

}
