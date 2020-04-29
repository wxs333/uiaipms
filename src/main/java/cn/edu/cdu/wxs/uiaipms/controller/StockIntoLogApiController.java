package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.domain.Unit;
import cn.edu.cdu.wxs.uiaipms.form.StockIntoLogForm;
import cn.edu.cdu.wxs.uiaipms.model.TreeMapModel;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.StockIntoLogService;
import cn.edu.cdu.wxs.uiaipms.service.UnitService;
import cn.edu.cdu.wxs.uiaipms.utils.DateUtils;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 库存入库记录 数据控制层
 *
 * @author WXS
 * @date 2020/2/17
 */
@RestController
@RequestMapping("api/into")
public class StockIntoLogApiController extends BaseController {

    @Autowired
    private StockIntoLogService service;
    @Autowired
    private UnitService unitService;

    /**
     * 列表
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("list")
    public JsonResult<IPage<StockIntoLogForm>> list(Page<StockIntoLogForm> page) {
        return jsonResult("0", service.getAll(page));
    }

    /**
     * 获取所有单位
     *
     * @return json
     */
    @GetMapping("unit")
    public JsonResult<List<Unit>> unit() {
        return jsonResult(unitService.getAll());
    }

    /**
     * 统计每日入库量
     *
     * @param rangeDate 范围日期
     * @return json
     */
    @GetMapping("statistics")
    public JsonResult<List<TreeMapModel>> statistics(String rangeDate) {
        Map<String, String> day = DateUtils.getStartAndEndOfDay(rangeDate);
        // 获取每天的总量
        List<Integer> sum = service.getSumEveryDay(day);
        // 获取每天入库物品及其数量
        Map<String, List<TreeMapModel>> data = service.getStatisticsData(day);
        // 处理数据
        List<TreeMapModel> format = SystemUtils.format(sum, data);
        return jsonResult(format);
    }

}
