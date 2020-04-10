package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.CompanyForm;
import cn.edu.cdu.wxs.uiaipms.form.StudioForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.CompanyService;
import cn.edu.cdu.wxs.uiaipms.service.ExcelService;
import cn.edu.cdu.wxs.uiaipms.service.StudioService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 企业用户 数据控制层
 *
 * @author WXS
 * @date 2020/1/19
 */
@RestController
@RequestMapping("api/com")
public class CompanyApiController extends BaseController {

    @Autowired
    private CompanyService service;
    @Autowired
    private StudioService studioService;
    @Autowired
    private ExcelService<StudioForm> excelService;

    /**
     * 分页获取所有信息
     *
     * @param page 分页
     * @return 分页集合
     */
    @GetMapping("list")
    public JsonResult<IPage<CompanyForm>> list(Page<CompanyForm> page) {
        return jsonResult("0", service.getAllInfo(page));
    }

    /**
     * 根据ID获取
     *
     * @param id ID
     * @return json
     */
    @GetMapping("getOne")
    public JsonResult<CompanyForm> getOne(String id) {
        return jsonResult(service.getOne(id));
    }

    /**
     * 修改
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("update")
    public JsonResult<String> update(CompanyForm form) {
        form.setUpdateTime(LocalDateTime.now());
        if (service.update(form)) {
            return jsonResult("修改成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "修改失败");
    }

    /**
     * 分页获取当前登录企业用户所有的工作室
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("getAllStudio")
    public JsonResult<IPage<StudioForm>> getAllStudio(Page<StudioForm> page) {
        // 获取当前登录企业用户的ID
        String comId = "19ccb469b89b4c59a7ff1ad559f9b53a";
        return jsonResult("0", studioService.getAllByComId(page, comId));
    }

    /**
     * 数据导出
     *
     * @param response 响应
     */
    @GetMapping("export")
    public void export(HttpServletResponse response) {
        // 获取当前登录企业用户的ID
        String comId = "19ccb469b89b4c59a7ff1ad559f9b53a";
        // 获取数据
        List<StudioForm> list = studioService.getList(comId);
        // 数据导出
        excelService.export("工作室", "我的工作室", list, StudioForm.class, response);
    }

    /**
     * 获取基本信息
     *
     * @param session 会话
     * @return json
     */
    @GetMapping("info")
    public JsonResult<CompanyForm> info(HttpSession session) {
        String id = SystemUtils.getUserId(session);
        return jsonResult(service.getOne(id));
    }
}
