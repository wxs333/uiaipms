package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.domain.Faculty;
import cn.edu.cdu.wxs.uiaipms.mapper.FacultyMapper;
import cn.edu.cdu.wxs.uiaipms.service.FacultyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学院 服务层实现类
 *
 * @author WXS
 * @date 2020/2/10
 */
@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyMapper mapper;

    @Override
    public List<Faculty> getAll() {
        return mapper.selectList(new QueryWrapper<>());
    }
}
