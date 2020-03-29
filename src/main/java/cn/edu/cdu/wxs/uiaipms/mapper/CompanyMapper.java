package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.CompanyForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * 企业的数据层
 *
 * @author WXS
 * @date 2020/1/13
 */
public interface CompanyMapper extends CommonMapper<CompanyForm> {
    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return 用户
     */
    CompanyForm getByUsername(@Param("username") String username);

    /**
     * 分页获取所有信息
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<CompanyForm> selectAllInfo(Page<CompanyForm> page);
}
