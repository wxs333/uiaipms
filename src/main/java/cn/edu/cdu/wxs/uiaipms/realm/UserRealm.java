package cn.edu.cdu.wxs.uiaipms.realm;

import cn.edu.cdu.wxs.uiaipms.domain.User;
import cn.edu.cdu.wxs.uiaipms.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

/**
 * 自定义的Realm
 *
 * @author WXS
 * @date 2020/1/10
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService service;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        // 数据库查询
        String username = (String) usernamePasswordToken.getPrincipal();
        User user = service.getByUsername(username);

        if (ObjectUtils.isEmpty(user)) {
            throw new UnknownAccountException();
        }

        return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(username), getName());
    }
}
