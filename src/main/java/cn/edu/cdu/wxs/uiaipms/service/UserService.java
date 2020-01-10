package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.domain.User;

/**
 * 用户服务层接口
 *
 * @author WXS
 * @date 2020/1/10
 */
public interface UserService extends BaseService<User> {

    /**
     * 根据用户名获取
     * @param username 用户名
     * @return 实体
     */
    User getByUsername(String username);
}
