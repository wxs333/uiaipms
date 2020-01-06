package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.form.LoginForm;
import cn.edu.cdu.wxs.uiaipms.utils.CodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * 处理用户请求，包括管理员，导师，学生
 *
 * @author WXS
 * @date 2019/12/16
 */
@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger log = Logger.getLogger("my---------UserController");

    @PostMapping(value = "login", name = "登录")
    @ResponseBody
    public String userLogin(LoginForm form){
        log.info(form.toString());
        return "s";
    }

    @GetMapping(value = "code", name = "验证码")
    public void produceCode(HttpSession session, HttpServletResponse response) {
        try {
            String code = CodeUtils.getCode(100, 28, "jpeg", response.getOutputStream());
            log.warning(code);
            // 保存到session里
            session.setAttribute("code", code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
