package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;

/**
 * 工作室 视图控制器
 *
 * @author WXS
 * @date 2020/2/15
 */
@Controller
@RequestMapping("stud")
public class StudioWebController {
    /**
     * 前缀
     */
    private static final String PREFIX = "studio/";

    /**
     * 工作室管理主页
     *
     * @param userId 用户ID
     * @return 视图
     */
    @GetMapping("list")
    public ModelAndView list(String userId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userId", userId);
        modelAndView.setViewName(PREFIX + "studio");
        return modelAndView;
    }

    /**
     * 新增页面
     *
     * @return 视图
     */
    @GetMapping("add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(PREFIX + "/add_studio");
        return modelAndView;
    }

    /**
     * 修改页面
     *
     * @return 视图
     */
    @GetMapping("update")
    public ModelAndView update(@NotNull String id) {
        System.err.println(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", id);
        modelAndView.setViewName(PREFIX + "update_studio");
        return modelAndView;
    }

    /**
     * 回收工作室
     *
     * @return 视图
     */
    @GetMapping("revoke")
    public String revoke() {
        return PREFIX + "revoke";
    }

}
