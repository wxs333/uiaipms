package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.BuyFundsApplyForm;
import cn.edu.cdu.wxs.uiaipms.model.StatisticsModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 查询需要导出的数据
     *
     * @return 集合
     */
    List<BuyFundsApplyForm> selectExportData();

    /**
     * 分页查询所有申请
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<BuyFundsApplyForm> selectApplyList(Page<BuyFundsApplyForm> page);

    /**
     * 获取库存拨款
     * @param start 开始时间
     * @param end 结束时间
     * @return 集合
     */
    List<StatisticsModel> selectBetweenStartAndEnd(@Param("start") String start, @Param("end") String end);
}
