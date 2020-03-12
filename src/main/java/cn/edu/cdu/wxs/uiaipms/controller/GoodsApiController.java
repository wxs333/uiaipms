package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.GoodsForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 物品 数据控制层
 *
 * @author WXS
 * @date 2020/3/10
 */
@RestController
@RequestMapping("api/goods")
public class GoodsApiController extends BaseController {

    @Autowired
    private GoodsService service;

    /**
     * 获取所有物品的ID，名称，剩余数量
     *
     * @return json
     */
    @GetMapping("getAllGoods")
    public JsonResult<List<GoodsForm>> getAllGoods() {
        return jsonResult(service.getAllGoods());
    }

    /**
     * 入库
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("add")
    public JsonResult<String> add(GoodsForm form) {
        String adminId = "e7a185e5074741b385d3615d41a92038";
        if (service.add(form, adminId)) {
            return jsonResult("入库成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "入库失败");
    }

    /**
     * 根据ID获取货物信息
     *
     * @param id ID
     * @return json
     */
    @GetMapping("getOne")
    public JsonResult<GoodsForm> getOne(@NotNull String id) {
        return jsonResult(service.getById(id));
    }

    /**
     * 查看设备
     *
     * @param studId 工作室id
     * @return json
     */
    @GetMapping("seeGoods")
    public JsonResult<List<GoodsForm>> seeGoods(@NotNull String studId) {
        return jsonResult("0", service.getGoodsByStudId(studId));
    }
}
