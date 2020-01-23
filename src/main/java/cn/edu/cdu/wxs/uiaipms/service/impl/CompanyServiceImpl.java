package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.CompanyColumn;
import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.domain.Company;
import cn.edu.cdu.wxs.uiaipms.form.CompanyForm;
import cn.edu.cdu.wxs.uiaipms.mapper.CompanyMapper;
import cn.edu.cdu.wxs.uiaipms.service.CompanyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WXS
 * @date 2020/1/13
 */
@Service
public class CompanyServiceImpl extends BaseServiceImpl<Company> implements CompanyService {
    @Autowired
    private CompanyMapper mapper;

    @Override
    public BaseMapper<Company> getMapper() {
        return mapper;
    }

    @Override
    public String getPasswordByUsername(String username) {
        return mapper.selectPasswordByUsername(username, CompanyColumn.COMPANY_TABLE);
    }

    @Override
    public CompanyForm getByUsername(String username) {
        return mapper.getByUsername(username);
    }

    @Override
    public IPage<CompanyForm> getAllInfo(Page<CompanyForm> page) {
       return mapper.selectAllInfo(page);
    }
}
