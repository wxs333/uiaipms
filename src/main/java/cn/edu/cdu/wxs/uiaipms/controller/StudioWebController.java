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
     * 工作室管理主页
     *
     * @return 视图
     */
    @GetMapping("list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studio/studio");
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
        modelAndView.setViewName("studio/add_studio");
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
        modelAndView.setViewName("studio/update_studio");
        return modelAndView;
    }
}
