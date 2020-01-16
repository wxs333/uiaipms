package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.domain.UserRole;
import cn.edu.cdu.wxs.uiaipms.form.UserRoleForm;
import cn.edu.cdu.wxs.uiaipms.mapper.UserRoleMapper;
import cn.edu.cdu.wxs.uiaipms.service.UserRoleService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * 用户角色表业务层实现类
 *
 * @author WXS
 * @date 2020/1/13
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper mapper;

    @Override
    public BaseMapper<UserRole> getMapper() {
        return mapper;
    }

    @Override
    public boolean authority(UserRoleForm form) {
        Map<String, Object> map = getTableNameAndIdColByRole(form.getMark());
        // 获取授权用户ID
        String userId = mapper.getIdByUsername(form.getUsername(),(String)map.get(GlobalConstant.TABLE_NAME), (String) map.get(GlobalConstant.ID_COL));

        form.setUrId(SystemUtils.getUuid());
        form.setUserId(userId);
        Date date = new Date();
        form.setCreateTime(date);
        form.setUpdateTime(date);
        form.setUrWho((Integer) map.get(GlobalConstant.ROLE_TYPE));

        return SystemUtils.gtTheZero(mapper.insert(form));
    }
}
