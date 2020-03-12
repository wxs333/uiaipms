package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.StockOutLogForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 出库记录 业务层接口
 * @author WXS
 * @date 2020/3/10
 */
public interface StockOutLogService extends BaseService<StockOutLogForm> {
    /**
     * 分页获取所有已审批的记录
     * @param page 分页
     * @return 分页集合
     */
    IPage<StockOutLogForm> getAllApplied(Page<StockOutLogForm> page);

    /**
     * 分页获取所有未审批的记录
     * @param page 分页
     * @return 分页集合
     */
    IPage<StockOutLogForm> getAllNotApplied(Page<StockOutLogForm> page);
}
