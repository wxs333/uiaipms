package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.form.ProjectForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.ProjectService;
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
 * 项目 数据控制器
 *
 * @author WXS
 * @date 2020/2/25
 */
@RestController
@RequestMapping("api/pro")
public class ProjectApiController extends BaseController {

    @Autowired
    private ProjectService projectService;

    /**
     * 项目申报
     *
     * @param form 表单数据
     * @return json
     */
    @PostMapping("add")
    public JsonResult<String> add(ProjectForm form) {
        // 设置参数
        LocalDateTime dateTime = LocalDateTime.now();
        form.setUpdateTime(dateTime);
        form.setCreateTime(dateTime);
        form.setStuId("fb832302c2484467afaf1d01715ee2c4");
        form.setProId(SystemUtils.getUuid());
        form.setProLocation("test");
        // 新增
        return projectService.add(form) ? jsonResult("申报成功，等待导师审批") : jsonResult("发生错误，申报失败");
    }

    /**
     * 获取未审批的项目
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("getNoAppr")
    public JsonResult<IPage<ProjectForm>> getNoAppr(Page<ProjectForm> page) {
        // 从session里获取当前登录导师的学院ID
        String facId = "af6d4fea76c742fea432e482c391911b";
        return jsonResult("0", projectService.getByFacId(page, facId));
    }
}
