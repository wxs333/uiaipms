package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.AdminColumn;
import cn.edu.cdu.wxs.uiaipms.column.TutorColumn;
import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.domain.Admin;
import cn.edu.cdu.wxs.uiaipms.domain.Tutor;
import cn.edu.cdu.wxs.uiaipms.form.AdminForm;
import cn.edu.cdu.wxs.uiaipms.form.StudentForm;
import cn.edu.cdu.wxs.uiaipms.mapper.AdminMapper;
import cn.edu.cdu.wxs.uiaipms.mapper.StudentMapper;
import cn.edu.cdu.wxs.uiaipms.mapper.TutorMapper;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.AdminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author WXS
 * @date 2020/1/13
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl<AdminForm> implements AdminService {
    /**
     * mapper对象
     */
    @Autowired
    private AdminMapper mapper;

    @Override
    public BaseMapper<AdminForm> getMapper() {
        return mapper;
    }

    @Override
    public String getPasswordByUsername(String username) {
        return mapper.selectPasswordByUsername(username, AdminColumn.ADMIN_TABLE);
    }

    @Override
    public AdminForm getByUsername(String username) {
        QueryWrapper<AdminForm> wrapper = new QueryWrapper<>();
        wrapper.select(AdminColumn.ADMIN_ID, AdminColumn.NICKNAME, AdminColumn.IMAGE)
                .eq(AdminColumn.LOGIC_DELETE_FLAG, 0)
                .eq(AdminColumn.USERNAME, username);
        return mapper.selectOne(wrapper);
    }

    @Override
    public AdminForm getInfo(String id) {
        QueryWrapper<AdminForm> wrapper = new QueryWrapper<>();
        wrapper.select(AdminColumn.ADMIN_ID, AdminColumn.ADMIN_NAME, AdminColumn.NICKNAME,
                AdminColumn.USERNAME, AdminColumn.PHONE)
                .eq(AdminColumn.ADMIN_ID, id);
        return mapper.selectOne(wrapper);
    }
}
