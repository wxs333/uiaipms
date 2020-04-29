package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.StockIntoLogForm;
import cn.edu.cdu.wxs.uiaipms.model.TreeMapModel;
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
public interface StockIntoLogMapper extends BaseMapper<StockIntoLogForm> {
    /**
     * 分页获取所有的记录
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<StockIntoLogForm> selectAll(Page<StockIntoLogForm> page);

    /**
     * 查询每一天的入库数据
     * @param start 开始时间
     * @param end 结束时间
     * @return 集合
     */
    List<TreeMapModel> selectBetweenStartAndEnd(@Param("start") String start, @Param("end") String end);

    /**
     * 获取一段时间内入库的总量
     * @param start 开始时间
     * @param end 结束时间
     * @return 总量
     */
    String selectSumBetweenStartAndEnd(@Param("start") String start, @Param("end") String end);
}
