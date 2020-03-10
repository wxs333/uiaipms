package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.form.StockOutLogForm;
import cn.edu.cdu.wxs.uiaipms.mapper.StockOutLogMapper;
import cn.edu.cdu.wxs.uiaipms.service.StockOutLogService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 出库记录 业务层实现类
 * @author WXS
 * @date 2020/3/10
 */
@Service
public class StockOutLogServiceImpl extends BaseServiceImpl<StockOutLogForm> implements StockOutLogService {

    @Autowired
    private StockOutLogMapper mapper;

    @Override
    public BaseMapper<StockOutLogForm> getMapper() {
        return mapper;
    }
}
