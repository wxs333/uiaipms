package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.utils.CodeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("api/user")
public class UserApiController {

    private static final Logger log = Logger.getLogger("UserController");
    /**
     * 登录成功
     */
    private static final String LOGIN_SUCCESS = "登陆成功";
    /**
     * 验证码
     */
    private static final String CODE = "code";

    /**
     * 用户登录
     * @param form 表单数据
     * @return json
     */
    @PostMapping(value = "login", name = "登录")
    public JsonResult<String> userLogin(LoginForm form){
        log.info(form.toString());
        return JsonResult.jsonResult(LOGIN_SUCCESS);
    }

    @GetMapping(value = "code", name = "验证码")
    public void produceCode(HttpSession session, HttpServletResponse response) {
        try {
            String code = CodeUtils.getCode(100, 28, "jpeg", response.getOutputStream());
            log.warning(code);
            // 保存到session里
            session.setAttribute(CODE, code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
