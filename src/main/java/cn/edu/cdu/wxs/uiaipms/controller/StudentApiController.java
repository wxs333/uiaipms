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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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
            Date date = new Date();
            form.setUpdateTime(date);
            form.setCreateTime(date);
            String id = SystemUtils.getUuid();
            form.setStuId(id);
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
     * @param page 分页
     * @return json
     */
    @GetMapping("getAll")
    public JsonResult<IPage<StudentForm>> getAll(Page<StudentForm> page) {
        return jsonResult("0", studentService.getAll(page));
    }

    /**
     * 分页获取所有信息
     * @param page 分页
     * @return 分页集合
     */
    @GetMapping("list")
    public JsonResult<IPage<StudentForm>> list(Page<StudentForm> page) {
        return jsonResult("0", studentService.getAllToList(page));
    }
}
