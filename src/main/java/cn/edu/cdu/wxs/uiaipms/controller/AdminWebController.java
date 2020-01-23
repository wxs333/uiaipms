package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;

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
    public ModelAndView grantAuthority(String mark, String userId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("mark", mark);
        modelAndView.addObject("userId", userId);
        modelAndView.setViewName("admin/grant_role");

        return modelAndView;
    }

    /**
     * 成员管理页面
     * @return 视图
     */
    @GetMapping("member")
    public ModelAndView member() {
        ModelAndView model = new ModelAndView();
        model.setViewName("admin/member");
        return model;
    }

    /**
     * 成员修改视图
     * @param mark 标识
     * @param id ID
     * @return 视图
     */
    @GetMapping("update")
    public ModelAndView update(@NotNull String mark, @NotNull String id) {
        ModelAndView model = new ModelAndView();
        model.addObject("id", id);
        switch (mark) {
            case "student":
                model.setViewName("admin/update_student");
                break;
            case "tutor":
                model.setViewName("admin/update_tutor");
                break;
            case "company":
                model.setViewName("admin/update_company");
                break;
            default:
                break;
        }
        return model;
    }
}
