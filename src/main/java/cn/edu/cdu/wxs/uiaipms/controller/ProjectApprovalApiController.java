package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.form.ProjectApprovalForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.ProjectApprovalService;
import cn.edu.cdu.wxs.uiaipms.service.ProjectService;
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

/**
 * 项目审批记录 数据控制层
 *
 * @author WXS
 * @date 2020/2/28
 */
@RestController
@RequestMapping("api/pa")
public class ProjectApprovalApiController extends BaseController {

    @Autowired
    private ProjectApprovalService service;
    @Autowired
    private ProjectService projectService;

    /**
     * 新增项目审批记录
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("add")
    public JsonResult<String> add(ProjectApprovalForm form) {
        // 参数设置
        form.setPaId(SystemUtils.getUuid());
        form.setApprovalFlag(ObjectUtils.isEmpty(form.getApprovalFlag()) ? 0 : 1);
        LocalDateTime dateTime = LocalDateTime.now();
        form.setCreateTime(dateTime);
        form.setUpdateTime(dateTime);
        form.setTutorId("e80f275768a24d9e855bf5595a6e1f33");
        form.setProName(null);
        return service.add(form) ? jsonResult("审批成功") : jsonResult("发生未知错误，操作失败");
    }

    /**
     * 分页查询某个导师已审批的项目
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("getAppred")
    public JsonResult<IPage<ProjectApprovalForm>> getAppred(Page<ProjectApprovalForm> page) {
        // 获取当前登录导师的ID
        String tutorId = "e80f275768a24d9e855bf5595a6e1f33";
        return jsonResult("0", service.getByTutorId(page, tutorId));
    }
}