package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.service.BaseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 基础的服务层实现类
 *
 * @author WXS
 * @date 2020/1/10
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    /**
     * 获取mapper对象
     *
     * @return mapper对象
     */
    public abstract BaseMapper<T> getMapper();

    @Override
    public boolean add(T domain) {
        return false;
    }

    @Override
    public boolean modifyById(T domain) {
        return false;
    }

    @Override
    public T getById(String idCol, int id) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.eq(idCol, id);
        return getMapper().selectOne(wrapper);
    }

    @Override
    public T getByUsername(String username, String idCol) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.select(idCol, "username")
                .eq("username", username);
        return getMapper().selectOne(wrapper);
    }
}