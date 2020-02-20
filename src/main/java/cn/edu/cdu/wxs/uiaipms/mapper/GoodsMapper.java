package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.GoodsForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 物品 数据层
 * @author WXS
 * @date 2020/2/17
 */
@Mapper
public interface GoodsMapper extends BaseMapper<GoodsForm> {
}
