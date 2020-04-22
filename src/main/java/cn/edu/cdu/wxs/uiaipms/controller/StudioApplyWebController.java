package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 工作室申请记录 视图控制类
 *
 * @author WXS
 * @date 2020/4/22
 */
@RequestMapping("sa")
@Controller
public class StudioApplyWebController {

    /**
     * 前缀
     */
    private static final String PREFIX = "studio_apply/";

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
     * 审批
     *
     * @return 视图
     */
    @GetMapping("sp")
    public ModelAndView sp(String id, String comId, String studId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(PREFIX + "sp");
        modelAndView.addObject("id", id);
        modelAndView.addObject("comId", comId);
        modelAndView.addObject("studId", studId);
        return modelAndView;
    }
}
