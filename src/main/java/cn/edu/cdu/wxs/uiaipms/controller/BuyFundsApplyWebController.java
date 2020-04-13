package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;

/**
 * 采购资金申请 视图控制类
 *
 * @author WXS
 * @date 2020/3/19
 */
@RequestMapping("bf")
@Controller
public class BuyFundsApplyWebController {

    /**
     * 前缀
     */
    private static final String PREFIX = "buy_funds_apply/";

    /**
     * 申请页面
     *
     * @return 视图
     */
    @GetMapping("apply")
    public String apply() {
        return PREFIX + "apply";
    }

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
     * 采购资金申请审批页面
     *
     * @param bfaId 记录id
     * @return 视图
     */
    @GetMapping("sp")
    public ModelAndView sp(@NotNull String bfaId, @NotNull String applyMount) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("bfaId", bfaId);
        modelAndView.addObject("applyMount", applyMount);
        modelAndView.setViewName(PREFIX + "sp");
        return modelAndView;
    }

    /**
     * 统计页面
     * @return 视图
     */
    @GetMapping("statistics")
    public String statistics() {
        return PREFIX + "statistics";
    }
}
