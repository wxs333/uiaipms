package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.domain.Unit;
import cn.edu.cdu.wxs.uiaipms.form.StockOutLogForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.StockLogService;
import cn.edu.cdu.wxs.uiaipms.service.UnitService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 库存记录 数据控制层
 *
 * @author WXS
 * @date 2020/2/17
 */
@RestController
@RequestMapping("api/sto")
public class StockLogApiController extends BaseController {

    @Autowired
    private StockLogService stockLogService;
    @Autowired
    private UnitService unitService;

    /**
     * 列表
     *
     * @param page 分页
     * @param type 类型
     * @return json
     */
    @GetMapping("list")
    public JsonResult<IPage<StockOutLogForm>> list(Page<StockOutLogForm> page, String type) {
        return jsonResult("0", stockLogService.getAll(page, type));
    }

    /**
     * 获取所有单位
     * @return json
     */
    @GetMapping("getUnit")
    public JsonResult<List<Unit>> getUnit() {
        return jsonResult(unitService.getAll());
    }

    /**
     * 新增
     * @param form
     * @return
     */
    @PostMapping("add")
    public JsonResult<String> add(StockOutLogForm form) {
        if (stockLogService.add(form)) {
            return jsonResult("入库成功");
        }
        return jsonResult(GlobalConstant.FAILURE,"入库失败");
    }
}
