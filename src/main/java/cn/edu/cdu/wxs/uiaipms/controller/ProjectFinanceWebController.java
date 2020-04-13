package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;

/**
 * 项目拨款记录 视图控制类
 *
 * @author WXS
 * @date 2020/3/18
 */
@RequestMapping("pf")
@Controller
public class ProjectFinanceWebController {
    /**
     * 视图前缀
     */
    private static final String PREFIX = "pro_finance/";

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
     * 项目资金申请审批
     *
     * @return 视图
     */
    @GetMapping("sp")
    public ModelAndView sp(@NotNull String pfId, @NotNull String proName, @NotNull String pfAmount) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pfId", pfId);
        modelAndView.addObject("proName", proName);
        modelAndView.addObject("pfAmount", pfAmount);
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
