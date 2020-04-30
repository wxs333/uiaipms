package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.StockOutLogForm;
import cn.edu.cdu.wxs.uiaipms.model.StatisticsModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 出库记录 数据层
 *
 * @author WXS
 * @date 2020/2/17
 */
@Mapper
public interface StockOutLogMapper extends BaseMapper<StockOutLogForm> {
    /**
     * 分页获取所有已审批的记录
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<StockOutLogForm> selectAllApplied(Page<StockOutLogForm> page);

    /**
     * 分页获取所有未审批的记录
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<StockOutLogForm> selectAllNotApplied(Page<StockOutLogForm> page);

    /**
     * 查询一段时间内的出库统计
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 集合
     */
    List<StatisticsModel> selectBetweenStartAndEnd(@Param("start") String start, @Param("end") String end);

}
