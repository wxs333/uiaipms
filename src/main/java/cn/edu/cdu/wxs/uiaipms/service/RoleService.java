package cn.edu.cdu.wxs.uiaipms.service;

import java.util.Set;

/**
 * 角色的服务层
 *
 * @author WXS
 * @date 2020/1/12
 */
public interface RoleService {
    /**
     * 根据用户ID查询用户所有角色与权限
     *
     * @param username  用户名
     * @param tableName 表名
     * @param idCol     ID字段名
     * @return 集合
     */
    Set<String> selectAllByUsername(String username, String tableName, String idCol, int who);
}
