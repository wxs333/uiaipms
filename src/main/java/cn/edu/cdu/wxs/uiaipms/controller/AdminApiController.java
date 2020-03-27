package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.domain.Clazz;
import cn.edu.cdu.wxs.uiaipms.domain.Discipline;
import cn.edu.cdu.wxs.uiaipms.domain.Faculty;
import cn.edu.cdu.wxs.uiaipms.form.UserRoleForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.*;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员 数据控制层
 *
 * @author WXS
 * @date 2020/1/15
 */
@RestController
@RequestMapping("api/admin")
public class AdminApiController extends BaseController {

    @Autowired
    private AdminService service;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private DisciplineService disciplineService;
    @Autowired
    private TutorService tutorService;

    private static final String MARK_TUTOR = "tutor";

    /**
     * 获取选择用户没有的角色
     *
     * @param mark   标识
     * @param userId 用户id
     * @return json
     */
    @GetMapping("getRoles")
    public JsonResult<Map<String, List>> getRoles(String mark, String userId) {
        Map<String, List> data = new HashMap<>(2);
        data.put("notHave", roleService.getListRole());
        data.put("have", roleService.getListIdByUserId(mark, userId));
        return jsonResult(data);
    }

    /**
     * 给用户授予角色
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("authority")
    public JsonResult<String> authority(UserRoleForm form) {
        // 获取选择角色的ID
        form.setChoose(parseJson(form.getData()));
        if (userRoleService.authority(form)) {
            return jsonResult("角色授予成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "角色授予失败");
    }

    /**
     * 回收用户角色
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("revoke")
    public JsonResult<String> revoke(UserRoleForm form) {
        // 获取选择角色的ID
        form.setChoose(parseJson(form.getData()));
        if (userRoleService.revoke(form)) {
            return jsonResult("角色收回成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "角色收回失败");
    }

    /**
     * 角色授予与回收辅助解析json字符串
     *
     * @param json json字符串
     * @return 集合
     */
    private Map<String, String> parseJson(String json) {
        JSONArray roles = JSONObject.parseArray(json);
        // 数据集合 roleId-id
        Map<String, String> choose = new HashMap<>(roles.size());
        for (int i = 0; i < roles.size(); i++) {
            String value = (String) roles.getJSONObject(i).get("value");
            choose.put(value, SystemUtils.getUuid());
        }
        return choose;
    }

    /**
     * 获取所有学院
     *
     * @return json
     */
    @GetMapping("getFaculty")
    public JsonResult<List<Faculty>> getFaculty() {
        return jsonResult(facultyService.getAll());
    }

    /**
     * 获取所有系
     *
     * @return json
     */
    @GetMapping("getDiscipline")
    public JsonResult<List<Discipline>> getDiscipline() {
        return jsonResult(disciplineService.getAll());
    }

    /**
     * 获取某个系所有的班级
     *
     * @param discId 系别ID
     * @return json
     */
    @GetMapping("getClazz")
    public JsonResult<List<Clazz>> getClazz(String discId) {
        return jsonResult(clazzService.getAllByDiscId(discId));
    }

    /**
     * 禁用账号
     *
     * @param mark 标识
     * @param id   ID
     * @return json
     */
    @PostMapping("ban")
    public JsonResult<String> ban(String mark, String id) {
        return null;
    }
}
