package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.ProjectFinanceForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.ExcelService;
import cn.edu.cdu.wxs.uiaipms.service.ProjectFinanceService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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

    /**
     * 新增
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("add")
    public JsonResult<String> add(ProjectFinanceForm form) {
        // 参数设置
        form.setPfId(SystemUtils.getUuid());
        form.setCreateTime(LocalDateTime.now());
        String tutorId = "e80f275768a24d9e855bf5595a6e1f33";
        form.setUserId(tutorId);

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
     * @param form 表单
     * @return json
     */
    @PostMapping("update")
    public JsonResult<String> update(ProjectFinanceForm form) {
        form.setUpdateTime(LocalDateTime.now());
        String adminId = "1447df502e6b4a5fa2b148be4bf03ec4";
        form.setAdminId(adminId);

        if (service.modifyById(form)) {
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
        excelService.export("项目拨款记录", "项目拨款记录", data, ProjectFinanceForm.class, response);
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
     * @param date 日期
     * @return json
     */
    @GetMapping("statistics")
    public JsonResult<Map<String, List>> statistics(String date) {
        // 处理日期字符串
        LocalDate localDate = SystemUtils.stringToLocalDate(date);
        // 获取数据
        Map<String, Map<String, Object>> data = service.getBetweenStartAndEnd(SystemUtils.getStartOfDay(localDate), SystemUtils.getEndOfDay(localDate));
        return jsonResult(SystemUtils.formatMap(data, "proName", "total"));
    }
}
