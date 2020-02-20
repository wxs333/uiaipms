package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.domain.Discipline;
import cn.edu.cdu.wxs.uiaipms.mapper.DisciplineMapper;
import cn.edu.cdu.wxs.uiaipms.service.DisciplineService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系 服务层实现类
 * @author WXS
 * @date 2020/2/11
 */
@Service
public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    private DisciplineMapper mapper;

    @Override
    public List<Discipline> getAll() {
        QueryWrapper<Discipline> wrapper = new QueryWrapper<>();
        wrapper.select("disc_id", "disc_name");
        return mapper.selectList(wrapper);
    }
}
