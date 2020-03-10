package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.form.GoodsForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
