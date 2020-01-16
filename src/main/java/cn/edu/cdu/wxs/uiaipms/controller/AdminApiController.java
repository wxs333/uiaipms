package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.form.AuthorityForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.AdminService;
import cn.edu.cdu.wxs.uiaipms.service.RoleService;
import cn.edu.cdu.wxs.uiaipms.service.UserRoleService;
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

    private static final String MARK_TUTOR = "tutor";

    /**
     * 获取选择用户没有的角色
     * @param mark 标识
     * @param username 用户名
     * @return json
     */
    @GetMapping("getRoles")
    public JsonResult<Map<String, List>> getRoles(String mark, String username) {
        Map<String, List> data = new HashMap<>(2);

        data.put("notHave", roleService.getListRole());
        data.put("have", roleService.getListIdByUsername(mark, username));

        return jsonResult(data);
    }

    @PostMapping("authority")
    public JsonResult<String> authority(AuthorityForm form) {
        System.out.println("sss");
        System.out.println(form);
//        if (userRoleService.authority(form)) {
//            return jsonResult("授权成功");
//        }

        return jsonResult("授权失败");
    }
}
