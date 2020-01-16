package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.domain.UserRole;
import cn.edu.cdu.wxs.uiaipms.form.UserRoleForm;

/**
 * 用户角色表业务层接口
 * @author WXS
 * @date 2020/1/13
 */
public interface UserRoleService extends BaseService<UserRole> {

    /**
     * 授权
     * @param form 表单
     * @return true 成功 false 失败
     */
    boolean authority(UserRoleForm form);
}
