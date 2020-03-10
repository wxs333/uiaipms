package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.StockOutLogForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 出库记录 数据层
 * @author WXS
 * @date 2020/2/17
 */
@Mapper
public interface StockOutLogMapper extends BaseMapper<StockOutLogForm> {
    /**
     * 分页获取所有的记录
     * @param page 分页
     * @param type 类型
     * @return 分页集合
     */
    IPage<StockOutLogForm> selectAll(@Param("page") Page<StockOutLogForm> page, @Param("type") String type);


}
