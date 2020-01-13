package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.CompantColumn;
import cn.edu.cdu.wxs.uiaipms.domain.Company;
import cn.edu.cdu.wxs.uiaipms.mapper.CompanyMapper;
import cn.edu.cdu.wxs.uiaipms.service.CompanyService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
        return mapper.selectPasswordByUsername(username, CompantColumn.COMPANY_TABLE);
    }
}
