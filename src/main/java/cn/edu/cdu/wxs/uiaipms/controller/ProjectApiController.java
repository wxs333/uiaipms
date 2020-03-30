package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.ProjectForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.FtpService;
import cn.edu.cdu.wxs.uiaipms.service.ProjectService;
import cn.edu.cdu.wxs.uiaipms.service.TutorService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    @Autowired
    private TutorService tutorService;
    @Autowired
    private FtpService ftpService;

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
        // 从session里获取当前登录导师ID
        String tutorId = "e80f275768a24d9e855bf5595a6e1f33";
        // 获取导师的学院id
        String facId = tutorService.getFacIdById(tutorId);
        return jsonResult("0", projectService.getByFacId(page, facId));
    }

    /**
     * 项目文档上传
     * @param file 文件
     * @return json
     */
    @PostMapping("uploadWord")
    public Map<String, Object> uploadWord(MultipartFile file) {
        Map<String, Object> map = new HashMap<>(3);
        try {
            String filename = SystemUtils.getNotRepeatingFilename(Objects.requireNonNull(file.getOriginalFilename()));
            if (ftpService.upload(GlobalConstant.FTP_WORD_DIRECTORY, filename, file.getInputStream())) {
                // 修改项目信息
                map.put("proLocation", GlobalConstant.FTP_WORD_DIRECTORY + filename);
                map.put("wordName", file.getOriginalFilename());
                map.put("code", "200");
            }
        } catch (Exception e) {
            map.put("msg", "word文档上传失败");
            map.put("code", "0");
        }
        return map;
    }
}
