package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.StockIntoLogForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.Map;

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
     * 查询一段时间内的入库统计
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 集合
     */
    @MapKey("goodsName")
    Map<String, Map<String, Object>> selectBetweenStartAndEnd(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
