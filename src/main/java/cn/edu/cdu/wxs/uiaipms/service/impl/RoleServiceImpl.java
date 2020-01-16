package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.*;
import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.domain.Role;
import cn.edu.cdu.wxs.uiaipms.form.RoleForm;
import cn.edu.cdu.wxs.uiaipms.mapper.RoleMapper;
import cn.edu.cdu.wxs.uiaipms.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * RoleServiceImpl class
 *
 * @author WXS
 * @date 2020/1/12
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleMapper mapper;



    @Override
    public BaseMapper<Role> getMapper() {
        return mapper;
    }

    @Override
    public Set<String> selectAllByUsername(String username, String tableName, String idCol, int who) {
        return mapper.selectAllByUsername(username, tableName, idCol, who);
    }

    @Override
    public List<Role> getListRole() {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.select(RoleColumn.ROLE_ID, RoleColumn.ROLE_NAME)
                .eq(GlobalConstant.LOGIC_DELETE_FLAG, 0);
        return mapper.selectList(wrapper);
    }

    @Override
    public Set<String> getRoleByUsername(String role, String username) {
        Map<String, Object> map = getTableNameAndIdColByRole(role);
        return selectAllByUsername(username, (String) map.get(GlobalConstant.TABLE_NAME), (String) map.get(GlobalConstant.ID_COL), (Integer) map.get(GlobalConstant.ROLE_TYPE));
    }

    @Override
    public List<String> getListIdByUsername(String role, String username) {
        Map<String, Object> map = getTableNameAndIdColByRole(role);
        return mapper.getListIdByUsername((String) map.get(GlobalConstant.TABLE_NAME), username, (String) map.get(GlobalConstant.ID_COL), (Integer) map.get(GlobalConstant.ROLE_TYPE));
    }

}
