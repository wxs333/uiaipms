package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.ProjectReviewForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.ExcelService;
import cn.edu.cdu.wxs.uiaipms.service.ProjectReviewService;
import cn.edu.cdu.wxs.uiaipms.service.TutorService;
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
    @Autowired
    private ExcelService<ProjectReviewForm> excelService;
    @Autowired
    private TutorService tutorService;

    /**
     * 分页获取未处理的审核记录
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("listNotDeal")
    public JsonResult<IPage<ProjectReviewForm>> listNotDeal(Page<ProjectReviewForm> page) {
        // 获取当前登录导师的ID
        String tutorId = "66c38cfebcac46649d071058f2eb7fd1";
        // 获取当前登录导师的学院id
        String facId = tutorService.getFacIdById(tutorId);

        return jsonResult("0", service.getByFacId(page, facId));
    }

    /**
     * 分页获取个人审核历史记录
     *
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
     * 修改
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("update")
    public JsonResult<String> update(ProjectReviewForm form) {
        // 当前登录用户id
        String tutorId = "e80f275768a24d9e855bf5595a6e1f33";
        // 参数设置
        form.setTutorId(tutorId);
        form.setUpdateTime(LocalDateTime.now());
        if (service.modifyById(form)) {
            return jsonResult("审核成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "审核失败");
    }
}
