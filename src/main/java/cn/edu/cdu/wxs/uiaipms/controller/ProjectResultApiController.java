package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.ProjectResultForm;
import cn.edu.cdu.wxs.uiaipms.model.ProjectResultModel;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.ProjectResultService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 项目成果 数据控制类
 *
 * @author WXS
 * @date 2020/5/8
 */
@RestController
@RequestMapping("api/res")
public class ProjectResultApiController extends BaseController {

    @Autowired
    private ProjectResultService service;

    /**
     * 新增
     *
     * @return json
     */
    @RequestMapping("add")
    public JsonResult<String> add(ProjectResultForm form) {
        form.setCreateTime(LocalDateTime.now());
        form.setPrId(SystemUtils.getUuid());

        if (service.add(form)) {
            return jsonResult("结题成功");
        }

        return jsonResult(GlobalConstant.FAILURE, "发生系统错误");
    }

    /**
     * 成果展示数据
     *
     * @param date 范围日期
     * @return json
     */
    @GetMapping("show")
    public JsonResult<Map<String, List>> show(String date) {
        // 拆分
        String[] dates = SystemUtils.splitDate(date, "~");
        String end = SystemUtils.getMaxOfDay(dates[1]);
        System.out.println(end);
        // 获取数据
        List<ProjectResultModel> data = service.getData(dates[0], end);
        // 处理
        Map<String, List> res = SystemUtils.deal(data);
        return jsonResult(res);
    }
}
