package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.ProjectFinanceForm;
import cn.edu.cdu.wxs.uiaipms.model.StatisticsModel;
import cn.edu.cdu.wxs.uiaipms.model.TreeMapModel;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.ExcelService;
import cn.edu.cdu.wxs.uiaipms.service.ProjectFinanceService;
import cn.edu.cdu.wxs.uiaipms.service.SysInfoService;
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

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 项目拨款财务记录 数据控制类
 *
 * @author WXS
 * @date 2020/3/17
 */
@RestController
@RequestMapping("api/pf")
public class ProjectFinanceApiController extends BaseController {

    @Autowired
    private ProjectFinanceService service;
    @Autowired
    private ExcelService<ProjectFinanceForm> excelService;
    @Autowired
    private SysInfoService sysInfoService;

    /**
     * 新增
     *
     * @param form   表单
     * @param userId 用户ID
     * @return json
     */
    @PostMapping("add")
    public JsonResult<String> add(ProjectFinanceForm form, String userId) {
        // 参数设置
        form.setPfId(SystemUtils.getUuid());
        form.setCreateTime(LocalDateTime.now());
        form.setUserId(userId);

        if (sysInfoService.getSysMoney().compareTo(form.getPfAmount()) < 0) {
            return jsonResult(GlobalConstant.FAILURE, "申请金额大于财务金额");
        }
        if (service.add(form)) {
            return jsonResult("申请发送成功，请等待管理员审批");
        }
        return jsonResult(GlobalConstant.FAILURE, GlobalConstant.FAILURE_MSG);
    }

    /**
     * 分页获取未处理的记录
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("notDeal")
    public JsonResult<IPage<ProjectFinanceForm>> notDeal(Page<ProjectFinanceForm> page) {
        return jsonResult("0", service.getAllNotDeal(page));
    }

    /**
     * 分页获取已处理处理的记录
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("deal")
    public JsonResult<IPage<ProjectFinanceForm>> deal(Page<ProjectFinanceForm> page) {
        return jsonResult("0", service.getAllDealed(page));
    }

    /**
     * 更新
     *
     * @param form   表单
     * @param userId 用户ID
     * @return json
     */
    @PostMapping("update")
    public JsonResult<String> update(ProjectFinanceForm form, String userId) {
        form.setUpdateTime(LocalDateTime.now());
        form.setUserId(null);
        form.setAdminId(userId);

        String flag = service.approve(form);

        if (GlobalConstant.ERROR.equals(flag)) {
            return jsonResult(GlobalConstant.FAILURE, "该项目已经结题");
        }
        if (GlobalConstant.SUCCESS.equals(flag)) {
            return jsonResult("审批成功");
        }

        return jsonResult(GlobalConstant.FAILURE, GlobalConstant.FAILURE_MSG);
    }

    /**
     * 数据导出
     *
     * @param response 响应
     */
    @GetMapping("export")
    public void export(HttpServletResponse response) {
        // 获取已处理的记录总数
        int total = service.getCount(0);
        // 获取数据
        Page<ProjectFinanceForm> page = new Page<>(0, total);
        List<ProjectFinanceForm> data = service.getAllDealed(page).getRecords();
        excelService.export("项目拨款申请记录", "项目拨款申请记录", data, ProjectFinanceForm.class, response);
    }

    /**
     * 查询某个项目的历史申请记录
     *
     * @param page  分页
     * @param proId 项目id
     * @return json
     */
    @GetMapping("history")
    public JsonResult<IPage<ProjectFinanceForm>> history(Page<ProjectFinanceForm> page, String proId) {
        return jsonResult("0", service.getByProId(page, proId));
    }

    /**
     * 统计
     *
     * @param rangeDate 日期
     * @return json
     */
    @GetMapping("statistics")
    public JsonResult<List<TreeMapModel>> statistics(String rangeDate) {
        String[] dates = DateUtils.dealRangeDate(rangeDate);
        // 获取数据
        List<StatisticsModel> statisticsData = service.getBetweenStartAndEnd(dates[0], dates[1]);

        // 无数据
        if (ObjectUtils.isEmpty(statisticsData)) {
            return jsonResult(GlobalConstant.FAILURE, "当前日期无数据");
        }

        // 处理数据
        List<TreeMapModel> data = SystemUtils.dealStatisticsData(statisticsData);
        return jsonResult(data);
    }
}
