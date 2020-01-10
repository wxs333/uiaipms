package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.UserColumn;
import cn.edu.cdu.wxs.uiaipms.domain.User;
import cn.edu.cdu.wxs.uiaipms.mapper.UserMapper;
import cn.edu.cdu.wxs.uiaipms.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务层接口的实现类
 *
 * @author WXS
 * @date 2020/1/10
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    /**
     * mapper 对象
     * @return
     */
    @Autowired
    private UserMapper mapper;

    @Override
    public BaseMapper<User> getMapper() {
        return mapper;
    }

    @Override
    public User getByUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq(UserColumn.USERNAME, username);
        return mapper.selectOne(wrapper);
    }
}
