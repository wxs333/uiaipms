package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.AdminColumn;
import cn.edu.cdu.wxs.uiaipms.domain.Admin;
import cn.edu.cdu.wxs.uiaipms.mapper.AdminMapper;
import cn.edu.cdu.wxs.uiaipms.service.AdminService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WXS
 * @date 2020/1/13
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {
    /**
     * mapper对象
     */
    @Autowired
    private AdminMapper mapper;

    @Override
    public BaseMapper<Admin> getMapper() {
        return mapper;
    }

    @Override
    public String getPasswordByUsername(String username) {
        return mapper.selectPasswordByUsername(username, AdminColumn.ADMIN_TABLE);
    }
}
