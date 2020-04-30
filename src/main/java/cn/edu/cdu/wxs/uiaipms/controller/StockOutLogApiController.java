package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.StockOutLogForm;
import cn.edu.cdu.wxs.uiaipms.model.StatisticsModel;
import cn.edu.cdu.wxs.uiaipms.model.TreeMapModel;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.StockOutLogService;
import cn.edu.cdu.wxs.uiaipms.utils.DateUtils;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

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
     * @param form   表单
     * @param userId 用户ID
     * @return json
     */
    @PostMapping("agree")
    public JsonResult<String> agree(StockOutLogForm form, String userId) {
        form.setUpdateTime(LocalDateTime.now());
        form.setAdminId(userId);
        if (service.modifyById(form)) {
            return jsonResult("审批成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "发生错误，请联系系统管理员");
    }

    /**
     * 统计
     *
     * @param rangeDate 范围日期
     * @return json
     */
    @GetMapping("statistics")
    public JsonResult<List<TreeMapModel>> statistics(String rangeDate) {
        String[] dates = DateUtils.dealRangeDate(rangeDate);
        // 获取数据
        List<StatisticsModel> statisticsData = service.statisticsData(dates[0], dates[1]);

        // 无数据
        if (ObjectUtils.isEmpty(statisticsData)) {
            return jsonResult(GlobalConstant.FAILURE, "当前日期无数据");
        }

        // 处理数据
        List<TreeMapModel> data = SystemUtils.dealStatisticsData(statisticsData);
        return jsonResult(data);
    }
}
