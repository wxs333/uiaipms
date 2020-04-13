package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.StockOutLogForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.StockOutLogService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 物品出库记录 数据控制层
 *
 * @author WXS
 * @date 2020/3/10
 */
@RestController
@RequestMapping("api/out")
public class StockOutLogApiController extends BaseController {

    @Autowired
    private StockOutLogService service;

    /**
     * 列表
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("list")
    public JsonResult<IPage<StockOutLogForm>> list(Page<StockOutLogForm> page) {
        return jsonResult("0", service.getAllApplied(page));
    }

    /**
     * 新增
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("add")
    public JsonResult<String> add(StockOutLogForm form) {
        // 参数设置
        form.setStoId(SystemUtils.getUuid());
        LocalDateTime dateTime = LocalDateTime.now();
        form.setUpdateTime(dateTime);
        form.setCreateTime(dateTime);
        if (service.add(form)) {
            return jsonResult("申请成功，请等待管理员审批");
        }
        return jsonResult("发生系统错误，请联系管理员");
    }

    /**
     * 分页获取所有未审批的物品申请记录
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("apply")
    public JsonResult<IPage<StockOutLogForm>> apply(Page<StockOutLogForm> page) {
        return jsonResult("0", service.getAllNotApplied(page));
    }

    /**
     * 审批
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("agree")
    public JsonResult<String> agree(StockOutLogForm form) {
        // 获取session里的用户ID
        String adminId = "e7a185e5074741b385d3615d41a92038";
        form.setUpdateTime(LocalDateTime.now());
        form.setAdminId(adminId);
        if (service.modifyById(form)) {
            return jsonResult("审批成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "发生错误，请联系系统管理员");
    }

    /**
     * 统计每日出库量
     *
     * @param date 日期
     * @return json
     */
    @GetMapping("statistics")
    public JsonResult<Map<String, List>> statistics(String date) {
        // 处理时间参数字符串
        LocalDate localDate = SystemUtils.stringToLocalDate(date);
        // 获取开始日期
        LocalDateTime start = SystemUtils.getStartOfDay(localDate);
        // 获取结束日期
        LocalDateTime end = SystemUtils.getEndOfDay(localDate);
        // 获取数据
        Map<String, List> data = SystemUtils.formatMap(service.getBetweenStartAndEnd(start, end), "goodsName", "total");
        return jsonResult(data);
    }
}
