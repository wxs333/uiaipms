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
     * 列表
     *
     * @return 视图
     */
    @GetMapping("list")
    public String list() {
        return "stock/stock_log";
    }

    /**
     * 入库
     *
     * @return 视图
     */
    @GetMapping("into")
    public String into() {
        return "stock/into";
    }

    /**
     * 出库
     *
     * @return 视图
     */
    @GetMapping("out")
    public String out() {
        return "stock/out";
    }
}
