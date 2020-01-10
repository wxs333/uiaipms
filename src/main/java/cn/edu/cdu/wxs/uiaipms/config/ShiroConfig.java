package cn.edu.cdu.wxs.uiaipms.config;

import cn.edu.cdu.wxs.uiaipms.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro 的配置类
 *
 * @author WXS
 * @date 2020/1/10
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     * @param securityManager securityManager
     * @return ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        // 资源访问控制
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/api/user/code", "anon");
        map.put("/api/**", "authc");
        map.put("/user/**", "authc");
        map.put("/**", "anon");
        filterFactoryBean.setFilterChainDefinitionMap(map);
        // 路径控制
        filterFactoryBean.setSuccessUrl("/user/home");
        filterFactoryBean.setLoginUrl("/user/index");
        filterFactoryBean.setUnauthorizedUrl("/user/login");
        return filterFactoryBean;
    }
    /**
     * 创建DefaultWebSecurityManager(web程序，Java 程序创建DefaultSecurityManager)
     * @param realm 自定义realm
     * @return DefaultWebSecurityManager
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }
    /**
     * 创建realm
     * @return realm
     */
    @Bean("userRealm")
    public UserRealm getRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher hashedCredentialsMatcher){
        UserRealm realm = new UserRealm();
        realm.setCredentialsMatcher(hashedCredentialsMatcher);
        return realm;
    }

    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }
}
