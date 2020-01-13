package cn.edu.cdu.wxs.uiaipms.service;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * 权限的服务层
 *
 * @author WXS
 * @date 2020/1/13
 */
public interface PermissionService {
    /**
     * 根据角色查询权限
     * @param roles 角色集合
     * @return 集合
     */
    Set<String> selectAllByRoleCode(@Param("roles") Set<String> roles);
}
