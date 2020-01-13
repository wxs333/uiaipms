package cn.edu.cdu.wxs.uiaipms.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
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
    @RequestMapping("home")
    @RequiresRoles("*")
    public String home() {
        return "home";
    }

    /**
     * 首页
     *
     * @return 视图
     */
    @RequestMapping("index")
    public String index() {
        return "index";
    }

    /**
     * 默认页面
     * @return 视图
     */
    @RequestMapping("default")
    public String defaultPage() {
        return "default";
    }
}