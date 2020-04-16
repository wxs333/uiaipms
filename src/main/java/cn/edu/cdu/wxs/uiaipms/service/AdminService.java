package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.AdminForm;
import cn.edu.cdu.wxs.uiaipms.form.RealmFrom;

/**
 * 管理员服务层
 *
 * @author WXS
 * @date 2020/1/13
 */
public interface AdminService extends BaseService<AdminForm> {
    /**
     * 根据用户名获取密码和状态
     *
     * @param username 用户名
     * @return 表单
     */
    RealmFrom getPasswordByUsername(String username);

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return 用户
     */
    AdminForm getByUsername(String username);

    /**
     * 获取基本信息
     * @param id id
     * @return 信息
     */
    AdminForm getInfo(String id);

}
