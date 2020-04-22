package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.CompanyForm;
import cn.edu.cdu.wxs.uiaipms.form.StudioForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.CompanyService;
import cn.edu.cdu.wxs.uiaipms.service.ExcelService;
import cn.edu.cdu.wxs.uiaipms.service.FtpService;
import cn.edu.cdu.wxs.uiaipms.service.StudioService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    private ExcelService<CompanyForm> excelService;
    @Autowired
    private FtpService ftpService;

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

    /**
     * 入驻申请文档上传
     *
     * @param file 文件
     * @return json
     */
    @PostMapping("upload")
    public Map<String, String> upload(MultipartFile file) {
        Map<String, String> map = new HashMap<>(4);
        try {
            String fileName = SystemUtils.getNotRepeatingFilename(Objects.requireNonNull(file.getOriginalFilename()));
            if (ftpService.upload(GlobalConstant.FTP_COMPANY_WORD_DIRECTORY, fileName, file.getInputStream())) {
                map.put("location", GlobalConstant.FTP_COMPANY_WORD_DIRECTORY + fileName);
                map.put("wordName", file.getOriginalFilename());
                map.put("code", "200");
                map.put("msg", "word文档上传成功");
            }
        } catch (Exception e) {
            map.put("msg", "word文档上传失败");
            map.put("code", "0");
        }
        return map;
    }

    /**
     * 企业入驻
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("register")
    public JsonResult<String> register(CompanyForm form) {
        form.setComId(SystemUtils.getUuid());
        form.setCreateTime(LocalDateTime.now());
        form.setPassword(SystemUtils.md5(form.getPassword(), form.getUsername()));
        form.setBan(1);

        if (service.add(form)) {
            return jsonResult("申请成功，请等待管理员审批");
        }
        return jsonResult(GlobalConstant.FAILURE, "申请失败");
    }

    /**
     * 分页获取未注册的账号信息
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("getNotRegister")
    public JsonResult<IPage<CompanyForm>> getNotRegister(Page<CompanyForm> page) {
        return jsonResult("0", service.getNotRegister(page));
    }

    /**
     * 申请历史记录
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("getByPage")
    public JsonResult<IPage<CompanyForm>> getByPage(Page<CompanyForm> page) {
        return jsonResult("0", service.getByPage(page));
    }

    /**
     * 企业注册信息导出
     *
     * @param response 响应
     */
    @GetMapping("registerExport")
    public void registerExport(HttpServletResponse response) {
        // 获取数据
        List<CompanyForm> data = service.exportData();

        String title = "企业入驻已审批记录";
        excelService.export(title, title, data, CompanyForm.class, response);

    }
}
