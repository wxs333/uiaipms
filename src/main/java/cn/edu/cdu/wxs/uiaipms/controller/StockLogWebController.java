package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
     * 库存管理
     *
     * @param model  数据模型
     * @param userId 用户id
     * @return 视图
     */
    @GetMapping("list")
    public String list(Model model, String userId) {
        model.addAttribute("userId", userId);
        return PREFIX + "stock";
    }

    /**
     * 采购资金申请记录
     *
     * @return 视图
     */
    @GetMapping("applyList")
    public String log() {
        return PREFIX + "apply_list";
    }

    /**
     * 入库
     *
     * @param model  数据模型
     * @param userId 用户id
     * @return 视图
     */
    @GetMapping("into")
    public String into(Model model, String userId) {
        model.addAttribute("userId", userId);
        return PREFIX + "into";
    }

    /**
     * 出库审批列表
     *
     * @param model  数据模型
     * @param userId 用户id
     * @return 视图
     */
    @GetMapping("out_list")
    public String out(Model model, String userId) {
        model.addAttribute("userId", userId);
        return PREFIX + "out_list";
    }

    /**
     * 库存记录统计
     *
     * @return 视图
     */
    @GetMapping("statistics")
    public String statistics() {
        return PREFIX + "stock_statistics";
    }
}
