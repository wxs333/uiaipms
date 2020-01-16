package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.domain.UserRole;
import cn.edu.cdu.wxs.uiaipms.form.UserRoleForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户角色数据层
 * @author WXS
 * @date 2020/1/13
 */
@Mapper
public interface UserRoleMapper extends CommonMapper<UserRole> {

    /**
     * 回收权限
     * @param username 用户名
     * @param tableName 表名
     * @param idCol ID列名
     * @return 影响行数
     */
    int updateByUsername(@Param("username") String username, @Param("tableName") String tableName, @Param("idCol") String idCol);

    /**
     * 新增
     * @param form 表单
     * @return 影响行数
     */
    int insert(@Param("form") UserRoleForm form);
}
