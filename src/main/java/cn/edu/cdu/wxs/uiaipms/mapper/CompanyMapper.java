package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.CompanyForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 企业的数据层
 *
 * @author WXS
 * @date 2020/1/13
 */
public interface CompanyMapper extends CommonMapper<CompanyForm> {
    /**
     * 分页获取所有信息
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<CompanyForm> selectAllInfo(Page<CompanyForm> page);
}
