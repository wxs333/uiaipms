package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
