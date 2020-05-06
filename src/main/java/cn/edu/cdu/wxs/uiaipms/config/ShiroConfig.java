package cn.edu.cdu.wxs.uiaipms.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import cn.edu.cdu.wxs.uiaipms.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
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
     *
     * @param securityManager securityManager
     * @return ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        // 资源访问控制
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/logout", "logout");
        map.put("/static/**", "anon");
        map.put("/api/stu/clazz", "anon");
        map.put("/api/stu/register", "anon");
        map.put("/api/com/register", "anon");
        map.put("/api/com/upload", "anon");
        map.put("/api/user/code", "anon");
        map.put("/api/user/headImg", "anon");
        map.put("/api/user/login", "anon");
        map.put("/api/user/sendEmail", "anon");
        map.put("/api/user/updatePassword", "anon");
        map.put("/user/stuRegister", "anon");
        map.put("/user/comRegister", "anon");
        map.put("/user/findPassword", "anon");
        map.put("/**", "authc");
        filterFactoryBean.setFilterChainDefinitionMap(map);
        // 路径控制
        filterFactoryBean.setSuccessUrl("/user/home");
        filterFactoryBean.setLoginUrl("/user/index");
        filterFactoryBean.setUnauthorizedUrl("/user/index");
        return filterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager(web程序，Java 程序创建DefaultSecurityManager)
     *
     * @return DefaultWebSecurityManager
     */
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getRealm());
        securityManager.setCacheManager(ehCacheManager());
        return securityManager;
    }


    /**
     * 创建realm
     *
     * @return realm
     */
    @Bean("userRealm")
    public UserRealm getRealm() {
        UserRealm realm = new UserRealm();
        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        return realm;
    }


    /**
     * 密码加密
     *
     * @return HashedCredentialsMatcher
     */
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

    /**
     * 页面上使用shiro标签
     *
     * @return ShiroDialect
     */
    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    /**
     * shiro缓存管理器
     *
     * @return 缓存管理器
     */
    @Bean(name = "ehCacheManager")
    public EhCacheManager ehCacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
        return cacheManager;
    }
}
