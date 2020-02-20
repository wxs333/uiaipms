package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.StudentForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.StudentService;
import cn.edu.cdu.wxs.uiaipms.service.UserRoleService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.logging.Logger;

/**
 * 学生 数据控制层
 *
 * @author WXS
 * @date 2020/1/13
 */
@RestController
@RequestMapping("api/stu")
public class StudentApiController extends BaseController {
    private Logger logger = Logger.getLogger("StudentApiController");

    /**
     * 业务层对象
     */
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserRoleService userRoleService;

    /**
     * 学生注册
     *
     * @param form 表单
     * @return json
     */
    @RequestMapping("register")
    public JsonResult<String> register(StudentForm form) {
        // 用户名，学号重复检测
        if (!studentService.isExistByUsernameOrStuNo(form.getUsername(), form.getStuNo())) {
            // 参数设置
            LocalDateTime date = LocalDateTime.now();
            form.setUpdateTime(date);
            form.setCreateTime(date);
            form.setStuId(SystemUtils.getUuid());
            form.setPassword(SystemUtils.md5(form.getPassword(), form.getUsername()));

            if (studentService.register(form)) {
                return jsonResult("注册成功");

            }
            return jsonResult(GlobalConstant.FAILURE, "注册失败");
        }

        return jsonResult(GlobalConstant.FAILURE, "用户名或学号重复");
    }

    /**
     * 获取所有
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("getAll")
    public JsonResult<IPage<StudentForm>> getAll(Page<StudentForm> page) {
        return jsonResult("0", studentService.getAll(page));
    }

    /**
     * 分页获取所有信息
     *
     * @param page 分页
     * @return 分页集合
     */
    @GetMapping("list")
    public JsonResult<IPage<StudentForm>> list(Page<StudentForm> page) {
        return jsonResult("0", studentService.getAllToList(page));
    }

    /**
     * 修改
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("update")
    public JsonResult<String> update(StudentForm form) {
        if (studentService.update(form)) {
            return jsonResult("修改成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "修改失败");

    }

    /**
     * 根据ID获取学生信息
     *
     * @param id ID
     * @return json
     */
    @GetMapping("getOne")
    public JsonResult<StudentForm> getOne(String id) {
        return jsonResult(studentService.getOneById(id));
    }

    /**
     * 头像上传
     *
     * @param multipartFile 头像图片
     */
    @PostMapping("imgUpload")
    public JsonResult<String> imgUpload(@RequestParam("filePath") MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            return jsonResult(GlobalConstant.FAILURE, "文件不存在");
        }
        // 本地上传目录
        String dir = "src/main/resources/static/img/head_portrait";
        if (GlobalConstant.SUCCESS.equals(studentService.imgUpload(multipartFile, dir))) {
            return jsonResult("");
        }
        return jsonResult(GlobalConstant.FAILURE, "头像上传失败");
    }

    @PostMapping("updateInfo")
    public JsonResult<String> updateInfo(StudentForm form) {
        if (studentService.updateInfo(form)) {
            return jsonResult("修改成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "修改失败");
    }

    /**
     * 获取学生基本信息
     *
     * @return json
     */
    @GetMapping("info")
    public JsonResult<StudentForm> info(HttpSession session) {
        // 获取当前用户的ID
        String id = ((StudentForm) session.getAttribute("user")).getId();
        return jsonResult(studentService.getInfo(id));
    }
}
