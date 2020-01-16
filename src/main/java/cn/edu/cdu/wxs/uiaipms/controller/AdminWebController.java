package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 管理员 视图控制器
 * @author WXS
 * @date 2020/1/14
 */
@Controller
@RequestMapping("admin")
public class AdminWebController {
    /**
     * 权限分配主页面
     * @return 视图
     */
    @GetMapping("authority")
    public String authority() {
        return "admin/authority";
    }

    /**
     * 角色分配页面
     * @return 视图
     */
    @GetMapping("grantRole")
    public ModelAndView grantAuthority(String mark, String username) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("mark", mark);
        modelAndView.addObject("username", username);
        modelAndView.setViewName("admin/grant_role");

        return modelAndView;
    }
}
