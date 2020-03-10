package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.StockOutLogForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 库存记录 业务层接口
 *
 * @author WXS
 * @date 2020/2/17
 */
public interface StockLogService extends BaseService<StockOutLogForm> {

    /**
     * 分页获取所有的记录
     *
     * @param page 分页
     * @param type 类型
     * @return 分页集合
     */
    IPage<StockOutLogForm> getAll(Page<StockOutLogForm> page, String type);
}
