package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.form.TutorForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.TutorService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 导师 数据控制层
 * @author WXS
 * @date 2020/1/14
 */
@RestController
@RequestMapping("api/tutor")
public class TutorApiController extends BaseController {

    @Autowired
    private TutorService tutorService;

    /**
     * 分页获取导师信息
     * @param ipage 分页
     * @return json
     */
    @GetMapping("getAll")
    public JsonResult<IPage<TutorForm>> getAll(Page<TutorForm> ipage) {
        return jsonResult("0",tutorService.getAllByPage(ipage));
    }
}