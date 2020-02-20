package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.StudioForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.time.LocalDateTime;

/**
 * 工作室 业务层接口
 *
 * @author WXS
 * @date 2020/2/15
 */
public interface StudioService extends BaseService<StudioForm> {
    /**
     * 查询所有
     *
     * @param page 分页
     * @return 集合
     */
    IPage<StudioForm> getAll(Page<StudioForm> page);

    /**
     * 根据ID获取
     *
     * @param studId ID
     * @return 实体
     */
    StudioForm getById(String studId);

    /**
     * 修改禁用状态
     *
     * @param ban    禁用状态
     * @param studId ID
     * @param updateTime 修改时间
     * @return true 成功 false 失败
     */
    boolean updateBan(String ban, String studId, LocalDateTime updateTime);
}
