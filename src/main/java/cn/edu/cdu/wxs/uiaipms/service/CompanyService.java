package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.domain.Company;
import cn.edu.cdu.wxs.uiaipms.form.CompanyForm;

/**
 * 企业的服务层
 * @author WXS
 * @date 2020/1/13
 */
public interface CompanyService extends BaseService<Company> {
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
    CompanyForm getByUsername(String username);
}
