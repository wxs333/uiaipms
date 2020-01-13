package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * 角色的数据层
 *
 * @author WXS
 * @date 2020/1/12
 */
@Mapper
public interface RoleMapper extends CommonMapper<Role> {

    /**
     * 根据用户名查询用户所有角色与权限
     * @param username 用户名
     * @param tableName 表名
     * @param idCol ID字段名
     * @return 集合
     */
    Set<String> selectAllByUsername(@Param("username") String username, @Param("tableName") String tableName, @Param("idCol") String idCol, @Param("who") int who);
}
