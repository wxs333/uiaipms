package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.domain.Student;

/**
 * 学生的服务层
 *
 * @author WXS
 * @date 2020/1/11
 */
public interface StudentService extends BaseService<Student> {
    /**
     * 根据用户名获取密码
     * @param username 用户名
     * @return 密码
     */
    String getPasswordByUsername(String username);

}
