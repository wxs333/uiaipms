package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.BuyFundsApplyForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.BuyFundsApplyService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

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

    /**
     * 新增
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("add")
    public JsonResult<String> add(BuyFundsApplyForm form) {
        // 补充数据
        form.setBfaId(SystemUtils.getUuid());
        String userId = "e7a185e5074741b385d3615d41a92038";
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
     * @return json
     */
    @PostMapping("update")
    public JsonResult<String> update(BuyFundsApplyForm form) {
        String adminId = "883a51f8cae347048e45a785b8f87a0e";
        form.setDealUserId(adminId);
        if (service.modifyById(form)) {
            return jsonResult("审批成功");
        }
        return jsonResult(GlobalConstant.FAILURE, GlobalConstant.FAILURE_MSG);
    }


}
