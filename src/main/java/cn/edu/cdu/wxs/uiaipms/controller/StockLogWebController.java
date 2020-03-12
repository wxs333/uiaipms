package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 库存记录 视图控制层
 *
 * @author WXS
 * @date 2020/2/17
 */
@RequestMapping("sto")
@Controller
public class StockLogWebController {
    /**
     * 前缀
     */
    private static final String PREFIX = "stock/";

    /**
     * 列表
     *
     * @return 视图
     */
    @GetMapping("list")
    public String list() {
        return PREFIX + "stock_log";
    }

    /**
     * 入库
     *
     * @return 视图
     */
    @GetMapping("into")
    public String into() {
        return PREFIX + "into";
    }

    /**
     * 出库审批列表
     *
     * @return 视图
     */
    @GetMapping("out_list")
    public String out() {
        return PREFIX + "out_list";
    }
}
