package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.BuyFundsApplyForm;
import cn.edu.cdu.wxs.uiaipms.model.StatisticsModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 采购资金申请 业务接口类
 *
 * @author WXS
 * @date 2020/3/19
 */
public interface BuyFundsApplyService extends BaseService<BuyFundsApplyForm> {
    /**
     * 分页获取未处理的申请记录
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<BuyFundsApplyForm> getPageNoDeal(Page<BuyFundsApplyForm> page);

    /**
     * 分页获取已处理的申请记录
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<BuyFundsApplyForm> getPageDeal(Page<BuyFundsApplyForm> page);

    /**
     * 查询需要导出的数据
     *
     * @return 集合
     */
    List<BuyFundsApplyForm> getExportData();

    /**
     * 分页查询所有申请
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<BuyFundsApplyForm> getApplyList(Page<BuyFundsApplyForm> page);

    /**
     * 获取一段时间内的拨款统计
     * @param start 开始时间
     * @param end 结束时间
     * @return 集合
     */
    List<StatisticsModel> getBetweenStartAndEnd(String start, String end);
}
