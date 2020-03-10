package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.form.StockOutLogForm;
import cn.edu.cdu.wxs.uiaipms.mapper.StockOutLogMapper;
import cn.edu.cdu.wxs.uiaipms.service.StockLogService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 库存记录 业务层实现类
 *
 * @author WXS
 * @date 2020/2/17
 */
@Service
public class StockLogServiceImpl extends BaseServiceImpl<StockOutLogForm> implements StockLogService {

    @Autowired
    private StockOutLogMapper mapper;

    @Override
    public BaseMapper<StockOutLogForm> getMapper() {
        return mapper;
    }

    @Override
    public IPage<StockOutLogForm> getAll(Page<StockOutLogForm> page, String type) {
        return mapper.selectAll(page, type);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(StockOutLogForm domain) {
        // 填充数据
        domain.setStoId(SystemUtils.getUuid());
        return false;
    }
}
