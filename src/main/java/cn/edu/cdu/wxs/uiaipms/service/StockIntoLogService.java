package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.StockIntoLogForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 库存记录 业务层接口
 *
 * @author WXS
 * @date 2020/2/17
 */
public interface StockIntoLogService extends BaseService<StockIntoLogForm> {
    /**
     * 分页获取所有的记录
     * @param page 分页
     * @return 分页集合
     */
    IPage<StockIntoLogForm> getAll(Page<StockIntoLogForm> page);
}
