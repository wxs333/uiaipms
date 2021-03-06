package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;

/**
 * 项目 视图控制器
 *
 * @author WXS
 * @date 2020/2/25
 */
@Controller
@RequestMapping("pro")
public class ProjectWebController {
    /**
     * 视图前缀
     */
    private static final String PREFIX = "project/";

    /**
     * 项目申报
     *
     * @param model  数据模型
     * @param userId 用户ID
     * @return 视图
     */
    @GetMapping("sb")
    public String sb(Model model, String userId) {
        model.addAttribute("userId", userId);
        return PREFIX + "project_sb";
    }

    /**
     * 项目审批列表
     *
     * @param model  数据模型
     * @param userId 用户ID
     * @return 视图
     */
    @GetMapping("sp")
    public String sp(Model model, String userId) {
        model.addAttribute("userId", userId);
        return PREFIX + "project_sp";
    }

    /**
     * 审批项目页面
     *
     * @param paId 项目对应审批记录ID
     * @return 视图
     */
    @GetMapping("doSp")
    public ModelAndView doSp(@NotNull String paId, @NotNull String proName, String userId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("paId", paId);
        modelAndView.addObject("proName", proName);
        modelAndView.addObject("userId", userId);
        modelAndView.setViewName(PREFIX + "sp");
        return modelAndView;
    }
}
