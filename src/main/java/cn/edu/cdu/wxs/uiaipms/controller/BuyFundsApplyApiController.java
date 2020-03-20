package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.BuyFundsApplyForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.BuyFundsApplyService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
}
