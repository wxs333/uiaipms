package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.form.StockIntoLogForm;
import cn.edu.cdu.wxs.uiaipms.form.StockOutLogForm;
import cn.edu.cdu.wxs.uiaipms.mapper.StockIntoLogMapper;
import cn.edu.cdu.wxs.uiaipms.mapper.StockOutLogMapper;
import cn.edu.cdu.wxs.uiaipms.model.StatisticsModel;
import cn.edu.cdu.wxs.uiaipms.model.TreeMapModel;
import cn.edu.cdu.wxs.uiaipms.service.StockIntoLogService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 库存出库记录 业务层实现类
 *
 * @author WXS
 * @date 2020/2/17
 */
@Service
public class StockIntoLogServiceImpl extends BaseServiceImpl<StockIntoLogForm> implements StockIntoLogService {

    @Autowired
    private StockIntoLogMapper mapper;

    @Override
    public BaseMapper<StockIntoLogForm> getMapper() {
        return mapper;
    }

    @Override
    public IPage<StockIntoLogForm> getAll(Page<StockIntoLogForm> page) {
        return mapper.selectAll(page);
    }

    @Override
    public List<StatisticsModel> getStatisticsData(String start, String end) {
        return mapper.selectBetweenStartAndEnd(start, end);
    }
}
