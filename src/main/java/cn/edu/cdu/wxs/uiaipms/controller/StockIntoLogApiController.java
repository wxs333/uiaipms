package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.domain.Unit;
import cn.edu.cdu.wxs.uiaipms.form.StockIntoLogForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.StockIntoLogService;
import cn.edu.cdu.wxs.uiaipms.service.UnitService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
     * @param date 日期
     * @return json
     */
    @GetMapping("statistics")
    public JsonResult<Map<String, List>> statistics(String date) {
        // 处理时间参数字符串
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parse = StringUtils.isEmpty(date) ? LocalDate.now() : LocalDate.parse(date, formatter);

        // 获取数据
        Map<String, List> data = SystemUtils.formatMap(service.getBetweenStartAndEnd(SystemUtils.getStartOfDay(parse), SystemUtils.getEndOfDay(parse)));
        return jsonResult(data);
    }

}
