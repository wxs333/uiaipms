package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.mapper.RoleMapper;
import cn.edu.cdu.wxs.uiaipms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * RoleServiceImpl class
 *
 * @author WXS
 * @date 2020/1/12
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper mapper;

    @Override
    public Set<String> selectAllByUsername(String username, String tableName, String idCol, int who) {
        return mapper.selectAllByUsername(username, tableName, idCol, who);
    }
}
