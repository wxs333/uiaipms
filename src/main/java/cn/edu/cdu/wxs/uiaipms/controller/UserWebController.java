package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于访问视图的controller
 *
 * @author WXS
 * @date 2020/1/9
 */
@RequestMapping("user")
@Controller
public class UserWebController {

    /**
     * 主页
     *
     * @return 视图
     */
    @GetMapping("home")
    public String home() {
        return "home/home";
    }

    /**
     * 首页
     *
     * @return 视图
     */
    @GetMapping("index")
    public String index() {
        return "index";
    }

    /**
     * 默认页面
     *
     * @return 视图
     */
    @GetMapping("default")
    public String defaultPage() {
        return "home/default";
    }

    /**
     * 学生注册页面
     *
     * @return 视图
     */
    @GetMapping("stuRegister")
    public String stuRegister() {
        return "register/stu_register";
    }
    /**
     * 学生注册页面
     *
     * @return 视图
     */
    @GetMapping("comRegister")
    public String comRegister() {
        return "register/com_register";
    }

    /**
     * 修改头像页面
     *
     * @return 视图
     */
    @GetMapping("img")
    public String img() {
        return "user/img";
    }

    /**
     * 找回密码
     *
     * @return 视图
     */
    @GetMapping("findPassword")
    public String findPassword() {
        return "user/find_password";
    }

    /**
     * 修改密码
     *
     * @return 视图
     */
    @GetMapping("password")
    public String password() {
        return "user/update_password";
    }


}
