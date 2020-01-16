package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.domain.Admin;
import cn.edu.cdu.wxs.uiaipms.form.AdminForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 管理员的数据层
 * @author WXS
 * @date 2020/1/13
 */
@Mapper
public interface AdminMapper extends CommonMapper<Admin> {
    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @return 用户
     */
    AdminForm getByUsername(@Param("username") String username);
}
