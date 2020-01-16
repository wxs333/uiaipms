package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.domain.Admin;
import cn.edu.cdu.wxs.uiaipms.form.AdminForm;

/**
 * 管理员服务层
 * @author WXS
 * @date 2020/1/13
 */
public interface AdminService extends BaseService<Admin> {
    /**
     * 根据用户名获取密码
     * @param username 用户名
     * @return 密码
     */
    String getPasswordByUsername(String username);

    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @return 用户
     */
    AdminForm getByUsername(String username);
}
