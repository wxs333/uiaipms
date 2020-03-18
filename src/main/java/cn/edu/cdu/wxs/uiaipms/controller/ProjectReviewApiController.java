package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.ProjectApprovalForm;
import cn.edu.cdu.wxs.uiaipms.form.ProjectReviewForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.ProjectReviewService;
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
 * 项目审核表 数据控制器
 *
 * @author WXS
 * @date 2020/3/13
 */
@RequestMapping("api/pr")
@RestController
public class ProjectReviewApiController extends BaseController {

    @Autowired
    private ProjectReviewService service;

    @PostMapping("add")
    public JsonResult<String> add(ProjectReviewForm form) {
        // 参数设置
        form.setPrId(SystemUtils.getUuid());
        LocalDateTime now = LocalDateTime.now();
        form.setCreateTime(now);
        form.setUpdateTime(now);
        String tutorId = "e80f275768a24d9e855bf5595a6e1f33";
        form.setTutorId(tutorId);
        form.setReview(0);
        form.setProName(null);
        // 修改审批记录
        ProjectApprovalForm approvalForm = new ProjectApprovalForm();
        approvalForm.setPaId(form.getPaId());
        approvalForm.setUpdateTime(now);
        approvalForm.setReview(1);

        if (service.add(form, approvalForm)) {
            return jsonResult("审批成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "发生未知错误，操作失败");
    }

    /**
     * 分页获取个人审核历史记录
     * @param page 分页
     * @return json
     */
    @GetMapping("personal")
    public JsonResult<IPage<ProjectReviewForm>> personal(Page<ProjectReviewForm> page) {
        // 当前登录用户id
        String tutorId = "e80f275768a24d9e855bf5595a6e1f33";
        return jsonResult("0", service.getByTutorId(page, tutorId));
    }

    /**
     * 分页获取通过审核的项目
     * @param page 分页
     * @return json
     */
    @GetMapping("starting")
    public JsonResult<IPage<ProjectReviewForm>> starting(Page<ProjectReviewForm> page) {
        return jsonResult("0", service.getReviewed(page));
    }

    /**
     * 更新
     * @param form 表单
     * @return json
     */
    @PostMapping("lx")
    public JsonResult<String> update(ProjectReviewForm form) {
        form.setUpdateTime(LocalDateTime.now());
        form.setLxTime(LocalDateTime.now());
        String tutorId = "e80f275768a24d9e855bf5595a6e1f33";
        form.setTutorId(tutorId);
        if (service.projectStarting(form)) {
            return jsonResult("成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "失败");
    }
}
