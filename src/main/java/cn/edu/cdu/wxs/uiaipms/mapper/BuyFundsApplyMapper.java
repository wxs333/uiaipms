package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.BuyFundsApplyForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 采购资金申请 数据访问类
 *
 * @author WXS
 * @date 2020/3/19
 */
public interface BuyFundsApplyMapper extends BaseMapper<BuyFundsApplyForm> {
    /**
     * 分页获取未处理的申请记录
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<BuyFundsApplyForm> selectPageNoDeal(Page<BuyFundsApplyForm> page);

    /**
     * 分页获取已处理的申请记录
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<BuyFundsApplyForm> selectPageDeal(Page<BuyFundsApplyForm> page);
}
