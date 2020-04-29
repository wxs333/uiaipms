package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.BuyFundsApplyForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.BuyFundsApplyService;
import cn.edu.cdu.wxs.uiaipms.service.ExcelService;
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
 * 采购资金申请 数据控制类
 *
 * @author WXS
 * @date 2020/3/19
 */
@RestController
@RequestMapping("api/bf")
public class BuyFundsApplyApiController extends BaseController {

    @Autowired
    private BuyFundsApplyService service;
    @Autowired
    private ExcelService<BuyFundsApplyForm> excelService;

    /**
     * 新增
     *
     * @param form 表单
     * @param userId 用户ID
     * @return json
     */
    @PostMapping("add")
    public JsonResult<String> add(BuyFundsApplyForm form, String userId) {
        // 补充数据
        form.setBfaId(SystemUtils.getUuid());
        form.setApplyUserId(userId);
        form.setCreateTime(LocalDateTime.now());
        form.setUpdateTime(LocalDateTime.now());

        if (service.add(form)) {
            return jsonResult("申请成功，请等待管理员审批");
        }
        return jsonResult(GlobalConstant.FAILURE, GlobalConstant.FAILURE_MSG);
    }

    /**
     * 未处理记录列表
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("listNoDeal")
    public JsonResult<IPage<BuyFundsApplyForm>> listNoDeal(Page<BuyFundsApplyForm> page) {
        return jsonResult("0", service.getPageNoDeal(page));
    }

    /**
     * 已处理处理记录列表
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("listDeal")
    public JsonResult<IPage<BuyFundsApplyForm>> listDeal(Page<BuyFundsApplyForm> page) {
        return jsonResult("0", service.getPageDeal(page));
    }

    /**
     * 审批
     *
     * @param form 表单
     * @param userId 用户ID
     * @return json
     */
    @PostMapping("update")
    public JsonResult<String> update(BuyFundsApplyForm form, String userId) {
        form.setDealUserId(userId);
        if (service.modifyById(form)) {
            return jsonResult("审批成功");
        }
        return jsonResult(GlobalConstant.FAILURE, GlobalConstant.FAILURE_MSG);
    }

    /**
     * 拨款记录导出
     *
     * @param response 响应
     */
    @GetMapping("export")
    public void export(HttpServletResponse response) {
        // 获取数据
        List<BuyFundsApplyForm> exportData = service.getExportData();
        String name = "采购拨款";
        // 导出
        excelService.export(name, name, exportData, BuyFundsApplyForm.class, response);
    }

    /**
     * 获取资金申请列表
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("applyList")
    public JsonResult<IPage<BuyFundsApplyForm>> applyList(Page<BuyFundsApplyForm> page) {
        return jsonResult("0", service.getApplyList(page));
    }

    /**
     * 统计
     *
     * @param date 日期
     * @return json
     */
    @GetMapping("statistics")
    public JsonResult<Map<String, List>> statistics(String date) {
        LocalDate localDate = SystemUtils.stringToLocalDate(date);
        // 获取数据
        return jsonResult("");
    }

}
