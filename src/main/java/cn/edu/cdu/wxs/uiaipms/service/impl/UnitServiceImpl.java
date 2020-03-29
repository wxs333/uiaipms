package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.domain.Unit;
import cn.edu.cdu.wxs.uiaipms.mapper.UnitMapper;
import cn.edu.cdu.wxs.uiaipms.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 单位 业务层实现类
 *
 * @author WXS
 * @date 2020/2/17
 */
@Service
public class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitMapper mapper;

    @Override
    public List<Unit> getAll() {
        return mapper.selectList(null);
    }
}
