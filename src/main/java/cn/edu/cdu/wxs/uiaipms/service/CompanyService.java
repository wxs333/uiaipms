package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.domain.Company;
import cn.edu.cdu.wxs.uiaipms.form.CompanyForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

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

    /**
     * 分页获取所有信息
     * @param page 分页
     * @return 分页集合
     */
    IPage<CompanyForm> getAllInfo(Page<CompanyForm> page);

}
