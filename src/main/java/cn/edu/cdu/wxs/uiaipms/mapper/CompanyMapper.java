package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.domain.Company;
import cn.edu.cdu.wxs.uiaipms.form.CompanyForm;
import org.apache.ibatis.annotations.Param;

/**
 * 企业的数据层
 * @author WXS
 * @date 2020/1/13
 */
public interface CompanyMapper extends CommonMapper<Company> {
    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @return 用户
     */
    CompanyForm getByUsername(@Param("username") String username);
}
