package cn.edu.cdu.wxs.uiaipms.realm;

import cn.edu.cdu.wxs.uiaipms.column.AdminColumn;
import cn.edu.cdu.wxs.uiaipms.column.CompantColumn;
import cn.edu.cdu.wxs.uiaipms.column.StudentColumn;
import cn.edu.cdu.wxs.uiaipms.column.TutorColumn;
import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.Set;

/**
 * 自定义的Realm
 *
 * @author WXS
 * @date 2020/1/10
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private StudentService studentService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private TutorService tutorService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取所有角色
        Set<String> roles = getRoleByUsername();
        // 获取所有权限
        Set<String> pers = permissionService.selectAllByRoleCode(roles);
        // 授权
        info.setRoles(roles);
        info.setStringPermissions(pers);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        // 数据库查询
        String username = (String) usernamePasswordToken.getPrincipal();
        String[] strs = username.split("-");
        String password = getPasswordByRoleAndUsername(strs[1], strs[0]);

        if (ObjectUtils.isEmpty(password)){
            throw new UnknownAccountException();
        }

        return new SimpleAuthenticationInfo(strs[0], password, ByteSource.Util.bytes(strs[0]), getName());
    }

    /**
     * 根据角色和用户获取密码
     * @param role 角色
     * @param username 用户名
     * @return 密码
     */
    private String getPasswordByRoleAndUsername(String role, String username) {
        String password = null;
        switch (role){
            case "admin":
                password = adminService.getPasswordByUsername(username);
                break;
            case "tutor":
                password = tutorService.getPasswordByUsername(username);
                break;
            case "student":
                password = studentService.getPasswordByUsername(username);
                break;
            case "company":
                password = companyService.getPasswordByUsername(username);
                break;
            default:
                break;
        }
        return password;
    }

    /**
     * 查询用户的角色
     * @return 集合
     */
    private Set<String> getRoleByUsername(){
        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        Set<String> roles = null;
        // 获取用户名
        String username = (String) currentUser.getPrincipal();
        // 获取登录角色
        String role = (String) currentUser.getSession().getAttribute("role");
        switch (role){
            case "admin":
                roles = roleService.selectAllByUsername(username, AdminColumn.ADMIN_TABLE, AdminColumn.ADMIN_ID, GlobalConstant.LOGIN_ROLE_ADMIN);
                break;
            case "tutor":
                roles = roleService.selectAllByUsername(username, TutorColumn.TUTOR_TABLE, TutorColumn.TUTOR_ID, GlobalConstant.LOGIN_ROLE_TUTOR);
                break;
            case "student":
                roles =  roleService.selectAllByUsername(username, StudentColumn.STUDENT_TABLE, StudentColumn.STU_ID, GlobalConstant.LOGIN_ROLE_STUDENT);
                break;
            case "company":
                roles = roleService.selectAllByUsername(username, CompantColumn.COMPANY_TABLE, CompantColumn.COM_ID, GlobalConstant.LOGIN_ROLE_COMPANY);
                break;
            default:
                break;
        }
        return roles;
    }

}
