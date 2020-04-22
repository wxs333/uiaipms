package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.AdminColumn;
import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.AdminForm;
import cn.edu.cdu.wxs.uiaipms.form.CompanyForm;
import cn.edu.cdu.wxs.uiaipms.form.RealmFrom;
import cn.edu.cdu.wxs.uiaipms.form.UserRoleForm;
import cn.edu.cdu.wxs.uiaipms.mapper.AdminMapper;
import cn.edu.cdu.wxs.uiaipms.service.AdminService;
import cn.edu.cdu.wxs.uiaipms.service.CompanyService;
import cn.edu.cdu.wxs.uiaipms.service.UserRoleService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private CompanyService companyService;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public BaseMapper<AdminForm> getMapper() {
        return mapper;
    }

    @Override
    public RealmFrom getPasswordByUsername(String username) {
        return mapper.selectPasswordByUsername(username, AdminColumn.ADMIN_TABLE);
    }

    @Override
    public AdminForm getByUsername(String username) {
        QueryWrapper<AdminForm> wrapper = new QueryWrapper<>();
        wrapper.select(AdminColumn.ADMIN_ID, AdminColumn.NICKNAME, AdminColumn.IMAGE, AdminColumn.USERNAME)
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean registerSp(Integer agree, String id) {
        CompanyForm form = new CompanyForm();
        form.setUpdateTime(LocalDateTime.now());
        form.setComId(id);
        // 同意，修改审批状态，新增一条用户角色信息
        if (agree == 0) {
            form.setAgree(agree);
            form.setBan(agree);
            form.setImage(GlobalConstant.DEFAULT_IMAGE);

            UserRoleForm userRoleForm = new UserRoleForm();
            userRoleForm.setUrId(SystemUtils.getUuid());
            userRoleForm.setRoleId(GlobalConstant.COMPANY_ROLE_ID);
            userRoleForm.setUserId(form.getComId());
            userRoleForm.setUpdateTime(LocalDateTime.now());
            userRoleForm.setCreateTime(LocalDateTime.now());
            userRoleForm.setUrWho(GlobalConstant.LOGIN_ROLE_COMPANY);
            return companyService.modifyById(form) && userRoleService.add(userRoleForm);
        }
        return companyService.modifyById(form);
    }
}
