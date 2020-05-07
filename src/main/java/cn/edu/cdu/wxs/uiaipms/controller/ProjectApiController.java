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
import org.springframework.util.StringUtils;
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
    private FtpService ftpService;
    @Autowired
    private TutorService tutorService;

    /**
     * 项目申报
     *
     * @param form   表单数据
     * @param userId 用户ID
     * @return json
     */
    @PostMapping("add")
    public JsonResult<String> add(ProjectForm form, String userId) {
        // 设置参数
        LocalDateTime dateTime = LocalDateTime.now();
        form.setUpdateTime(dateTime);
        form.setCreateTime(dateTime);
        form.setStuId(userId);
        form.setProId(SystemUtils.getUuid());
        // 新增
        return projectService.add(form) ? jsonResult("申报成功，等待导师审批") : jsonResult("发生错误，申报失败");
    }

    /**
     * 分页获取某个学院为审批的项目
     *
     * @param page   分页
     * @param userId 用户ID
     * @return json
     */
    @GetMapping("listNoDeal")
    public JsonResult<IPage<ProjectForm>> listNoDeal(Page<ProjectForm> page, String userId) {
        String facId = tutorService.getFacIdById(userId);

        return jsonResult("0", projectService.getByFacId(page, facId));
    }

    /**
     * 项目文档上传
     *
     * @param file 文件
     * @return json
     */
    @PostMapping("uploadWord")
    public Map<String, Object> uploadWord(MultipartFile file, String oldPath) {
        Map<String, Object> map = new HashMap<>(4);
        try {
            String filename = SystemUtils.getNotRepeatingFilename(Objects.requireNonNull(file.getOriginalFilename()));
            // 删除旧项目文档
            if (!StringUtils.isEmpty(oldPath)) {
                ftpService.remove(oldPath);
            }
            if (ftpService.upload(GlobalConstant.FTP_WORD_DIRECTORY, filename, file.getInputStream())) {
                // 修改项目信息
                map.put("proLocation", GlobalConstant.FTP_WORD_DIRECTORY + filename);
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
     * 分页获取某个学生申报的项目
     *
     * @param page   分页
     * @param userId 用户ID
     * @return json
     */
    @GetMapping("getPersonalPro")
    public JsonResult<IPage<ProjectForm>> getPersonalPro(Page<ProjectForm> page, String userId) {
        return jsonResult("0", projectService.getByStuId(page, userId));
    }


    /**
     * 项目重新申报
     *
     * @param form     表单
     * @param oldProId 需要重新申报项目的id
     * @param userId   用户ID
     * @return json
     */
    @PostMapping("afresh")
    public JsonResult<String> afresh(ProjectForm form, String oldProId, String userId) {
        // 参数设置
        form.setProId(SystemUtils.getUuid());
        form.setCreateTime(LocalDateTime.now());
        form.setUpdateTime(LocalDateTime.now());
        form.setStuId(userId);

        return projectService.afresh(form, oldProId) ? jsonResult("重新申报成功，等待导师审批") : jsonResult("发生错误，重新申报失败");
    }
}
