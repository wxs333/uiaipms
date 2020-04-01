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
     * 注册页面
     *
     * @return 视图
     */
    @GetMapping("register")
    public String registerHtml() {
        return "register/register";
    }

    /**
     * 修改头像页面
     * @return 视图
     */
    @GetMapping("img")
    public String img() {
        return "user/img";
    }

    @GetMapping("findPassword")
    public String findPassword() {
        return "user/find_password";
    }
}
