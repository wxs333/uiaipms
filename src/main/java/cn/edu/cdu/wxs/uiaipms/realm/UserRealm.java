package cn.edu.cdu.wxs.uiaipms.realm;

import cn.edu.cdu.wxs.uiaipms.exception.AccountUnavailableException;
import cn.edu.cdu.wxs.uiaipms.form.RealmFrom;
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

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 开启授权缓存
        setAuthorizationCachingEnabled(true);
        setAuthorizationCacheName("authorizationCache");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        // 获取用户名
        String username = (String) currentUser.getPrincipal();
        // 获取登录角色
        String role = (String) currentUser.getSession().getAttribute(username + "-role");
        // 获取所有角色
        Set<String> roles = roleService.getRoleByUsername(role, username);
        info.setRoles(roles);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        // 数据库查询
        String username = (String) usernamePasswordToken.getPrincipal();
        String[] strs = username.split("-");
        RealmFrom from = getPasswordByRoleAndUsername(strs[1], strs[0]);

        if (ObjectUtils.isEmpty(from)) {
            throw new UnknownAccountException();
        }
        if (from.getBan() == 1) {
            throw new AccountUnavailableException();
        }

        return new SimpleAuthenticationInfo(strs[0], from.getPassword(), ByteSource.Util.bytes(strs[0]), getName() + strs[0]);
    }

    /**
     * 根据角色和用户获取密码
     *
     * @param role     角色
     * @param username 用户名
     * @return 密码
     */
    private RealmFrom getPasswordByRoleAndUsername(String role, String username) {
        switch (role) {
            case "admin":
                return adminService.getPasswordByUsername(username);
            case "tutor":
                return tutorService.getPasswordByUsername(username);
            case "student":
                return studentService.getPasswordByUsername(username);
            case "company":
                return companyService.getPasswordByUsername(username);
            default:
                break;
        }
        return null;
    }

}
