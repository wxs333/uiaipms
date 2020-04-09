package cn.edu.cdu.wxs.uiaipms.controller;


import org.springframework.stereotype.Controller;
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
     * @return 视图
     */
    @GetMapping("list")
    public String list() {
        return PREFIX + "list";
    }

    /**
     * 资金申请
     *
     * @param proId 项目id
     * @return 视图
     */
    @GetMapping("apply")
    public ModelAndView apply(@NotNull String proId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("proId", proId);
        modelAndView.setViewName(PREFIX + "apply");
        return modelAndView;
    }

    @GetMapping("finHistory")
    public ModelAndView finHistory(@NotNull String proId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("proId", proId);
        modelAndView.setViewName(PREFIX + "fin_history");
        return modelAndView;
    }
}

