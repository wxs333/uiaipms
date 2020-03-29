package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.TutorForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
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
 * 导师 数据控制层
 *
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
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("getAll")
    public JsonResult<IPage<TutorForm>> getAll(Page<TutorForm> page) {
        return jsonResult("0", tutorService.getAllByPage(page));
    }

    /**
     * 分页获取所有信息
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("list")
    public JsonResult<IPage<TutorForm>> list(Page<TutorForm> page) {
        return jsonResult("0", tutorService.getAllToList(page));
    }

    /**
     * 修改信息
     *
     * @param form 信息
     * @return json
     */
    @PostMapping("update")
    public JsonResult<String> update(TutorForm form) {
        form.setUpdateTime(LocalDateTime.now());
        if (tutorService.update(form)) {
            return jsonResult("修改成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "修改失败");
    }

    /**
     * 根据ID获取导师信息
     *
     * @param id ID
     * @return json
     */
    @GetMapping("getOne")
    public JsonResult<TutorForm> getOne(String id) {
        return jsonResult(tutorService.getOneById(id));
    }
}
