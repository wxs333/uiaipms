package cn.edu.cdu.wxs.uiaipms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 项目立项表 视图控制器
 * </p>
 *
 * @author WXS
 * @since 2020-03-13
 */
@Controller
@RequestMapping("/ps")
public class ProjectStartingWebController {
    /**
     * 前缀
     */
    private static final String PREFIX = "pro_lx/";

    /**
     * 列表
     *
     * @param model  数据模型
     * @param userId 用户ID
     * @return 视图
     */
    @GetMapping("list")
    public String list(Model model, String userId) {
        model.addAttribute("userId", userId);
        return PREFIX + "list";
    }

    /**
     * 资金申请
     *
     * @param proId  项目id
     * @param userId 用户ID
     * @return 视图
     */
    @GetMapping("apply")
    public ModelAndView apply(@NotNull String proId, String userId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("proId", proId);
        modelAndView.addObject("userId", userId);
        modelAndView.setViewName(PREFIX + "apply");
        return modelAndView;
    }

    /**
     * 申请记录
     *
     * @param proId 项目id
     * @return 视图
     */
    @GetMapping("finHistory")
    public ModelAndView finHistory(@NotNull String proId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("proId", proId);
        modelAndView.setViewName(PREFIX + "fin_history");
        return modelAndView;
    }

    /**
     * 项目结题
     *
     * @param psId    立项记录id
     * @param proId   项目id
     * @param userId  用户ID
     * @param proName 项目名
     * @return 视图
     */
    @GetMapping("end")
    public ModelAndView end(String psId, String proId, String userId, String proName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("psId", psId);
        modelAndView.addObject("proId", proId);
        modelAndView.addObject("userId", userId);
        modelAndView.addObject("proName", proName);
        modelAndView.setViewName(PREFIX + "end");
        return modelAndView;
    }
}

