package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.SysInfoColumn;
import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.domain.SysInfo;
import cn.edu.cdu.wxs.uiaipms.mapper.SysInfoMapper;
import cn.edu.cdu.wxs.uiaipms.service.SysInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 系统信息 业务实现类
 * @author WXS
 * @date 2020/3/19
 */
@Service
public class SysInfoServiceImpl extends BaseServiceImpl<SysInfo> implements SysInfoService {

    @Autowired
    private SysInfoMapper mapper;

    @Override
    public BaseMapper<SysInfo> getMapper() {
        return mapper;
    }

    @Override
    public BigDecimal getSysMoney() {
        QueryWrapper<SysInfo> wrapper = new QueryWrapper<>();
        wrapper.select(SysInfoColumn.SYS_COUNT)
                .eq(SysInfoColumn.SYS_ID, GlobalConstant.MONEY_ID);
        return mapper.selectOne(wrapper).getSysCount();
    }

    @Override
    public boolean modifyById(SysInfo domain) {
        domain.setSysCount(getSysMoney().subtract(domain.getSysCount()));
        return super.modifyById(domain);
    }
}
