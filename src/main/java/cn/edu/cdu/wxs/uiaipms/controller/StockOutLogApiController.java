package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.form.StockOutLogForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.StockOutLogService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * 物品出库记录 数据控制层
 * @author WXS
 * @date 2020/3/10
 */
@RestController
@RequestMapping("api/out")
public class StockOutLogApiController extends BaseController {

    @Autowired
    private StockOutLogService service;

    /**
     * 新增
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
}
