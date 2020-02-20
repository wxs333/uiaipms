package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.domain.UserRole;
import cn.edu.cdu.wxs.uiaipms.form.UserRoleForm;
import cn.edu.cdu.wxs.uiaipms.mapper.UserRoleMapper;
import cn.edu.cdu.wxs.uiaipms.service.UserRoleService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

/**
 * 用户角色表业务层实现类
 *
 * @author WXS
 * @date 2020/1/13
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleForm> implements UserRoleService {

    @Autowired
    private UserRoleMapper mapper;

    @Override
    public BaseMapper<UserRoleForm> getMapper() {
        return mapper;
    }

    @Override
    public boolean authority(UserRoleForm form) {
        Map<String, Object> map = getTableNameAndIdColByRole(form.getMark());

        form.setUserId(form.getUserId());
        LocalDateTime date = LocalDateTime.now();
        form.setCreateTime(date);
        form.setUpdateTime(date);
        form.setUrWho((Integer) map.get(GlobalConstant.ROLE_TYPE));

        return SystemUtils.gtTheZero(mapper.insertBatch(form));
    }

    @Override
    public boolean revoke(UserRoleForm form) {
        return SystemUtils.gtTheZero(mapper.updateLogicDeleteFlag(form));
    }

}
