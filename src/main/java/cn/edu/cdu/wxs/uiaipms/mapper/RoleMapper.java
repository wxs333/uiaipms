package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.RoleForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 角色的数据层
 *
 * @author WXS
 * @date 2020/1/12
 */
@Mapper
public interface RoleMapper extends CommonMapper<RoleForm> {

    /**
     * 根据用户名查询用户所有角色与权限
     *
     * @param username  用户名
     * @param tableName 表名
     * @param idCol     ID字段名
     * @param who       记录type
     * @return 集合
     */
    Set<String> selectAllByUsername(@Param("username") String username, @Param("tableName") String tableName, @Param("idCol") String idCol, @Param("who") int who);

    /**
     * 获取用户的角色ID
     *
     * @param tableName 用户表
     * @param userId  用户id
     * @param idCol     ID列
     * @param who       记录type
     * @return 集合
     */
    List<String> getListIdByUsername(@Param("tableName") String tableName, @Param("userId") String userId, @Param("idCol") String idCol, @Param("who") int who);
}
