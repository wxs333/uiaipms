package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.StudioApplyForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.StudioApplyService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * 工作室申请记录 数据控制类
 *
 * @author WXS
 * @date 2020/4/22
 */
@RequestMapping("api/sa")
@RestController
public class StudioApplyApiController extends BaseController {

    @Autowired
    private StudioApplyService service;

    /**
     * 新增
     *
     * @param form    表单
     * @param session 会话
     * @return json
     */
    @PostMapping("add")
    public JsonResult<String> add(StudioApplyForm form, HttpSession session) {
        form.setApplyComId((String) session.getAttribute(GlobalConstant.USER_ID));
        form.setCreateTime(LocalDateTime.now());
        form.setSaId(SystemUtils.getUuid());

        if (service.add(form)) {
            return jsonResult("申请成功，请等待管理员审批");
        }

        return jsonResult(GlobalConstant.FAILURE, "申请失败");
    }

    /**
     * 列表
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("list")
    public JsonResult<IPage<StudioApplyForm>> list(Page<StudioApplyForm> page) {
        return jsonResult("0",service.getByPage(page));
    }

    /**
     * 审批
     * @param form 表单
     * @return json
     */
    @PostMapping("sp")
    public JsonResult<String> sp(StudioApplyForm form, HttpSession session) {
        form.setDealUserId((String)session.getAttribute(GlobalConstant.USER_ID));

        if (service.applyApproval(form)) {
            return jsonResult("审批成功");
        }

        return jsonResult(GlobalConstant.FAILURE, "审批失败");
    }

}
