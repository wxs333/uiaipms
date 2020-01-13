package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.domain.Tutor;

/**
 * 导师的服务层
 * @author WXS
 * @date 2020/1/13
 */
public interface TutorService extends BaseService<Tutor> {
    /**
     * 根据用户名获取密码
     * @param username 用户名
     * @return 密码
     */
    String getPasswordByUsername(String username);
}
