package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.ProjectStartingForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.ExcelService;
import cn.edu.cdu.wxs.uiaipms.service.ProjectStartingService;
import cn.edu.cdu.wxs.uiaipms.service.TutorService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 项目立项表 数据控制器
 *
 * @author WXS
 * @date 2020/3/13
 */
@RequestMapping("api/ps")
@RestController
public class ProjectStartingApiController extends BaseController {

    @Autowired
    private ProjectStartingService service;
    @Autowired
    private TutorService tutorService;
    @Autowired
    private ExcelService<ProjectStartingForm> excelService;

    /**
     * 列表
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("list")
    public JsonResult<IPage<ProjectStartingForm>> list(Page<ProjectStartingForm> page) {
        // 当前登录导师的id
        String id = "e80f275768a24d9e855bf5595a6e1f33";
        // 获取导师的学院id
        String facId = tutorService.getFacIdById(id);

        return jsonResult("0", service.getByFacId(page, facId));
    }

    /**
     * 项目立项
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("lx")
    public JsonResult<String> lx(ProjectStartingForm form) {
        // 当前登录导师的id
        String id = "66c38cfebcac46649d071058f2eb7fd1";
        // 参数设置
        form.setTutorId(id);
        form.setUpdateTime(LocalDateTime.now());

        if (service.modifyById(form)) {
            return jsonResult("立项成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "立项失败");
    }

    /**
     * 数据导出
     * @param response 响应
     */
    @GetMapping("export")
    public void export(HttpServletResponse response) {
        // 当前登录导师的id
        String id = "e80f275768a24d9e855bf5595a6e1f33";
        // 获取导师的学院id
        String facId = tutorService.getFacIdById(id);
        // 获取数据
        List<ProjectStartingForm> data = service.getExportData(facId);
        // 导出
        excelService.export("项目", "项目", data, ProjectStartingForm.class, response);
    }
}
