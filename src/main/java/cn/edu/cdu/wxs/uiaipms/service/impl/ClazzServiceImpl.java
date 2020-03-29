package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.domain.Clazz;
import cn.edu.cdu.wxs.uiaipms.mapper.ClazzMapper;
import cn.edu.cdu.wxs.uiaipms.service.ClazzService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 班级 业务层实现类
 *
 * @author WXS
 * @date 2020/1/27
 */
@Service
public class ClazzServiceImpl extends BaseServiceImpl<Clazz> implements ClazzService {

    @Autowired
    private ClazzMapper mapper;
    /**
     * 系别ID列
     */
    private static final String DISC_ID = "disc_id";

    @Override
    public BaseMapper<Clazz> getMapper() {
        return mapper;
    }

    @Override
    public List<Clazz> getAllByDiscId(String discId) {
        QueryWrapper<Clazz> wrapper = new QueryWrapper<>();
        wrapper.eq(DISC_ID, discId);
        return mapper.selectList(wrapper);
    }
}
