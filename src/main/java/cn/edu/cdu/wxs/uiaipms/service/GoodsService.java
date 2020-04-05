package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.GoodsForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 物品 业务层接口
 *
 * @author WXS
 * @date 2020/2/17
 */
public interface GoodsService extends BaseService<GoodsForm> {
    /**
     * 获取所有物品的ID，名称
     *
     * @return 集合
     */
    List<GoodsForm> getAllGoods();

    /**
     * 新增
     *
     * @param form    表单
     * @param adminId 管理员
     * @return true 成功 false 失败
     */
    boolean add(GoodsForm form, String adminId);

    /**
     * 查询ID
     *
     * @param form 表单
     * @return ID
     */
    String getId(GoodsForm form);

    /**
     * 根据ID获取
     *
     * @param id ID
     * @return 实体
     */
    GoodsForm getById(String id);

    /**
     * 获取工作室的所有设备
     *
     * @param studId 工作室id
     * @return 集合
     */
    List<GoodsForm> getGoodsByStudId(String studId);

    /**
     * 分页获取所有物品
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<GoodsForm> getByPage(Page<GoodsForm> page);

    /**
     * 获取所有物品
     *
     * @return 集合
     */
    List<GoodsForm> getList();

    /**
     * 获取某个工作室的设备及其数量
     *
     * @param studId 工作室id
     * @return 集合
     */
    List<GoodsForm> getGoodsAndNumByStudId(String studId);

    /**
     * 根据id获取剩余数量
     * @param id id
     * @return 剩余数量
     */
    int getNumById(String id);

}
