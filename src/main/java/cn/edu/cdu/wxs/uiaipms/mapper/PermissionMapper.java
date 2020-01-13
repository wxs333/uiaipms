package cn.edu.cdu.wxs.uiaipms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * 权限的数据层
 *
 * @author WXS
 * @date 2020/1/12
 */
@Mapper
public interface PermissionMapper {

    /**
     * 根据角色查询权限
     * @param roles 角色集合
     * @return 集合
     */
    Set<String> selectAllByRoleCode(@Param("roles") Set<String> roles);
}
