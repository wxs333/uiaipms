package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.ProjectApprovalForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.ProjectApprovalService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 分页查询某个导师已审批的项目
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("getPersonal")
    public JsonResult<IPage<ProjectApprovalForm>> getPersonal(Page<ProjectApprovalForm> page) {
        // 获取当前登录导师的ID
        String tutorId = "66c38cfebcac46649d071058f2eb7fd1";
        return jsonResult("0", service.getByTutorId(page, tutorId));
    }


    /**
     * 修改
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("update")
    public JsonResult<String> update(ProjectApprovalForm form) {
        // 获取当前登录导师的ID
        String tutorId = "66c38cfebcac46649d071058f2eb7fd1";
        // 参数设置
        form.setUpdateTime(LocalDateTime.now());
        form.setTutorId(tutorId);
        if (service.modifyById(form)) {
            return jsonResult("审批成功");
        }
        return jsonResult(GlobalConstant.FAILURE, GlobalConstant.FAILURE_MSG);
    }
}
