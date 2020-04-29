package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.StockIntoLogForm;
import cn.edu.cdu.wxs.uiaipms.model.TreeMapModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * 出库记录 业务层接口
 *
 * @author WXS
 * @date 2020/2/17
 */
public interface StockIntoLogService extends BaseService<StockIntoLogForm> {
    /**
     * 分页获取所有的记录
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<StockIntoLogForm> getAll(Page<StockIntoLogForm> page);

    /**
     * 查询一段时间内的入库统计
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 集合
     */
    List<TreeMapModel> getBetweenStartAndEnd(String start, String end);

    /**
     * 获取一点时间内入库的总量
     * @param start 开始时间
     * @param end 结束时间
     * @return 总量
     */
    int getSumBetweenStartAndEnd(String start, String end);

    /**
     * 获取每一天的统计数据
     * @param map 时间集合
     * @return 集合
     */
    Map<String, List<TreeMapModel>> getStatisticsData(Map<String, String> map);

    /**
     * 获取每天的入库总量
     * @param map 时间集合
     * @return 集合
     */
    List<Integer> getSumEveryDay(Map<String, String> map);
}
