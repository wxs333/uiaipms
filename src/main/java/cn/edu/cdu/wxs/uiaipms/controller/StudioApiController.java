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
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author WXS
 * @date 2020/2/15
 */
@RestController
@RequestMapping("/api/stud")
public class StudioApiController extends BaseController {

    @Autowired
    private StudioService studioService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ExcelService<StudioForm> excelService;

    /**
     * 查询所有
     *
     * @return json
     */
    @GetMapping("list")
    public JsonResult<IPage<StudioForm>> list(Page<StudioForm> page) {
        return jsonResult("0", studioService.getAll(page));
    }

    /**
     * 获取所有企业
     *
     * @return json
     */
    @GetMapping("getCompany")
    public JsonResult<List<CompanyForm>> getCompany() {
        return jsonResult(companyService.getAll());
    }

    /**
     * 新增
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("add")
    public JsonResult<String> add(StudioForm form) {
        // 设置ID
        form.setStudId(SystemUtils.getUuid());
        // 设置创建时间和更新时间
        LocalDateTime dateTime = LocalDateTime.now();
        form.setCreateTime(dateTime);
        form.setUpdateTime(dateTime);
        if (studioService.add(form)) {
            return jsonResult("添加成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "添加失败");
    }

    /**
     * 根据ID获取
     *
     * @param studId ID
     * @return json
     */
    @GetMapping("getOne")
    public JsonResult<StudioForm> getOne(String studId) {
        return jsonResult(studioService.getById(studId));
    }

    /**
     * 修改
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("update")
    public JsonResult<String> update(StudioForm form) {
        form.setUpdateTime(LocalDateTime.now());
        if (studioService.modifyById(form)) {
            return jsonResult("修改成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "修改失败");
    }

    /**
     * 修改禁用状态
     *
     * @param ban    禁用状态
     * @param studId ID
     * @return json
     */
    @PostMapping("updateBan")
    public JsonResult<String> updateBan(String ban, String studId) {
        String status = "1".equals(ban) ? "禁用" : "启用";
        if (studioService.updateBan(ban, studId, LocalDateTime.now())) {
            return jsonResult(status + "成功");
        }
        return jsonResult(GlobalConstant.FAILURE, status + "失败");
    }

    /**
     * 导出企业的工作室信息
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
     * 获取填充select框的数据
     *
     * @return json
     */
    @GetMapping("getSelect")
    public JsonResult<List<StudioForm>> getSelect() {
        return jsonResult(studioService.getIdAndAddressAndRoomNo());
    }

}
