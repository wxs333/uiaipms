package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.form.StockOutLogForm;
import cn.edu.cdu.wxs.uiaipms.mapper.GoodsMapper;
import cn.edu.cdu.wxs.uiaipms.mapper.StockOutLogMapper;
import cn.edu.cdu.wxs.uiaipms.model.StatisticsModel;
import cn.edu.cdu.wxs.uiaipms.service.StockOutLogService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 出库记录 业务层实现类
 *
 * @author WXS
 * @date 2020/3/10
 */
@Service
public class StockOutLogServiceImpl extends BaseServiceImpl<StockOutLogForm> implements StockOutLogService {

    @Autowired
    private StockOutLogMapper mapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public BaseMapper<StockOutLogForm> getMapper() {
        return mapper;
    }

    @Override
    public IPage<StockOutLogForm> getAllApplied(Page<StockOutLogForm> page) {
        return mapper.selectAllApplied(page);
    }

    @Override
    public IPage<StockOutLogForm> getAllNotApplied(Page<StockOutLogForm> page) {
        return mapper.selectAllNotApplied(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean modifyById(StockOutLogForm domain) {
        if (domain.getAgree() == 0) {
            return super.modifyById(domain) &&
                    SystemUtils.gtTheZero(goodsMapper.reduceGoodsNum(domain.getApplyNum(), domain.getGoodsId()));
        }
        return super.modifyById(domain);
    }

    @Override
    public List<StatisticsModel> statisticsData(String start, String end) {
        return mapper.selectBetweenStartAndEnd(start, end);
    }
}
