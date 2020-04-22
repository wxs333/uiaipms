package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;

/**
 * 企业用户 视图控制层
 *
 * @author WXS
 * @date 2020/3/7
 */
@Controller
@RequestMapping("com")
public class CompanyWebController {

    /**
     * 视图前缀
     */
    private static final String PREFIX = "company/";

    /**
     * 设备申请
     *
     * @return 视图
     */
    @RequestMapping("apply")
    public String apply() {
        return PREFIX + "goods_apply";
    }

    /**
     * 我管理的工作室
     *
     * @return 视图
     */
    @RequestMapping("myStudio")
    public String myStudio() {
        return PREFIX + "my_studio";
    }

    /**
     * 物品申请页面
     *
     * @return 视图
     */
    @GetMapping("goodsApply")
    public ModelAndView goodsApply(@NotNull String studId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studId", studId);
        modelAndView.setViewName(PREFIX + "goods_apply");
        return modelAndView;
    }

    /**
     * 查看设备详情页面
     *
     * @param studId 工作室
     * @return 视图
     */
    @GetMapping("details")
    public ModelAndView details(@NotNull String studId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studId", studId);
        modelAndView.setViewName(PREFIX + "goods_details");
        return modelAndView;
    }

    /**
     * 基本资料
     *
     * @return 视图
     */
    @GetMapping("info")
    public String info() {
        return PREFIX + "info";
    }

    /**
     * 工作室申请
     *
     * @return 视图
     */
    @GetMapping("studioApply")
    public String studioApply() {
        return PREFIX + "studio_apply";
    }
}
