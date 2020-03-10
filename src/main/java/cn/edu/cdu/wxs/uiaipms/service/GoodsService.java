package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.GoodsForm;

import java.util.List;

/**
 * 物品 业务层接口
 * @author WXS
 * @date 2020/2/17
 */
public interface GoodsService extends BaseService<GoodsForm> {
    /**
     * 获取所有物品的ID，名称，剩余数量
     * @return 集合
     */
    List<GoodsForm> getAllGoods();
}
