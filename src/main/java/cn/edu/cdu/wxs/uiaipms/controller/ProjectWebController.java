package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
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
     * @return 视图
     */
    @GetMapping("sb")
    public String sb() {
        return PREFIX + "project_sb";
    }

    /**
     * 项目审批列表
     *
     * @return 视图
     */
    @GetMapping("sp")
    public String sp() {
        return PREFIX + "project_sp";
    }

    /**
     * 审批项目页面
     *
     * @param proId 项目ID
     * @return 视图
     */
    @GetMapping("doSp")
    public ModelAndView doSp(@NotNull String proId, @NotNull String proName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("proId", proId);
        modelAndView.addObject("proName", proName);
        modelAndView.setViewName(PREFIX + "sp");
        return modelAndView;
    }
}
