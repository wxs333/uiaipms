package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.GoodsForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 物品 数据层
 * @author WXS
 * @date 2020/2/17
 */
@Mapper
public interface GoodsMapper extends BaseMapper<GoodsForm> {

    /**
     * 根据表单查询ID
     * @param form 表单
     * @return 个数
     */
    String selectByForm(@Param("form") GoodsForm form);

    /**
     * 增加物品数量
     * @param form 表单
     * @return 影响行数
     */
    int addGoodsNum(@Param("form") GoodsForm form);

    /**
     * 减少物品数量
     * @param num 减少量
     * @param id id
     * @return 影响行数
     */
    int reduceGoodsNum(@Param("num") Integer num, @Param("id") String id);

    /**
     * 获取工作室的所有设备
     * @param studId 工作室id
     * @return 集合
     */
    List<GoodsForm> selectGoodsByStudId(@Param("studId") String studId);
}
