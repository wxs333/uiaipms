package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.form.StockIntoLogForm;
import cn.edu.cdu.wxs.uiaipms.form.StockOutLogForm;
import cn.edu.cdu.wxs.uiaipms.mapper.StockIntoLogMapper;
import cn.edu.cdu.wxs.uiaipms.mapper.StockOutLogMapper;
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
    public List<TreeMapModel> getBetweenStartAndEnd(String start, String end) {
        return mapper.selectBetweenStartAndEnd(start, end);
    }

    @Override
    public int getSumBetweenStartAndEnd(String start, String end) {
        String data = mapper.selectSumBetweenStartAndEnd(start, end);

        return StringUtils.isEmpty(data) ? 0 : Integer.parseInt(data);
    }

    @Override
    public Map<String, List<TreeMapModel>> getStatisticsData(Map<String, String> map) {
        Map<String, List<TreeMapModel>> data = new TreeMap<>();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            data.put(next.getKey(), getBetweenStartAndEnd(next.getKey(), next.getValue()));
        }
        return data;
    }

    @Override
    public List<Integer> getSumEveryDay(Map<String, String> map) {
        List<Integer> sum = new LinkedList<>();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            sum.add(getSumBetweenStartAndEnd(next.getKey(), next.getValue()));
        }
        return sum;
    }
}
