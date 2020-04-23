package cn.edu.cdu.wxs.uiaipms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 项目审核表 视图控制器
 * </p>
 *
 * @author WXS
 * @since 2020-03-13
 */
@Controller
@RequestMapping("/pr")
public class ProjectReviewWebController {
    /**
     * 前缀
     */
    private static final String PREFIX = "pro_sh/";

    /**
     * 列表
     *
     * @param model  数据模型
     * @param userId 用户id
     * @return 视图
     */
    @GetMapping("list")
    public String list(Model model, String userId) {
        model.addAttribute("userId", userId);
        return PREFIX + "list";
    }

    /**
     * 项目审核
     *
     * @param prId    审批记录id
     * @param proName 项目名
     * @return 视图
     */
    @GetMapping("sh")
    public ModelAndView sh(@NotNull String prId, @NotNull String proName, String userId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("prId", prId);
        modelAndView.addObject("proName", proName);
        modelAndView.addObject("userId", userId);
        modelAndView.setViewName(PREFIX + "sh");
        return modelAndView;
    }

    /**
     * 个人审核历史记录
     * @param model  数据模型
     * @param userId 用户id
     * @return 视图
     */
    @GetMapping("history")
    public String history(Model model, String userId) {
        model.addAttribute("userId", userId);
        return PREFIX + "history";
    }


}

