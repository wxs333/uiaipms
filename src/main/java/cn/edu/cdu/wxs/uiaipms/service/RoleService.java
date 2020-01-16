package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.domain.Role;

import java.util.List;
import java.util.Set;

/**
 * 角色的服务层
 *
 * @author WXS
 * @date 2020/1/12
 */
public interface RoleService extends BaseService<Role> {
    /**
     * 根据用户ID查询用户所有角色与权限
     *
     * @param username  用户名
     * @param tableName 表名
     * @param idCol     ID字段名
     * @param who       用户的类别
     * @return 集合
     */
    Set<String> selectAllByUsername(String username, String tableName, String idCol, int who);

    /**
     * 获取所有角色
     *
     * @return 集合
     */
    List<Role> getListRole();

    /**
     * 获取用户的角色编码
     *
     * @param role     角色
     * @param username 用户名
     * @return 集合
     */
    Set<String> getRoleByUsername(String role, String username);

    /**
     * 获取用户的角色ID
     * @param role 角色
     * @param username 用户名
     * @return 集合
     */
    List<String> getListIdByUsername(String role, String username);
}
