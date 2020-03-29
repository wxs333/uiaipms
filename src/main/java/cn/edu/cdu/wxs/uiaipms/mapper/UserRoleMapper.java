package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.UserRoleForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户角色数据层
 *
 * @author WXS
 * @date 2020/1/13
 */
@Mapper
public interface UserRoleMapper extends CommonMapper<UserRoleForm> {

    /**
     * 新增
     *
     * @param form 表单
     * @return 影响行数
     */
    int insertBatch(@Param("form") UserRoleForm form);

    /**
     * 回收角色
     *
     * @param form 表单
     * @return 影响行数
     */
    int updateLogicDeleteFlag(@Param("form") UserRoleForm form);
}
