package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.mapper.PermissionMapper;
import cn.edu.cdu.wxs.uiaipms.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * 权限的服务层
 *
 * @author WXS
 * @date 2020/1/13
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    /**
     * mapper层对象
     */
    @Autowired
    private PermissionMapper mapper;

    @Override
    public Set<String> selectAllByRoleCode(Set<String> roles) {
        return mapper.selectAllByRoleCode(roles);
    }
}
