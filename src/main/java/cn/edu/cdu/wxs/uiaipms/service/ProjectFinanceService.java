package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.ProjectFinanceForm;
import cn.edu.cdu.wxs.uiaipms.model.StatisticsModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * <p>
 * 项目拨款财务记录 服务类
 * </p>
 *
 * @author WXS
 * @since 2020-03-17
 */
public interface ProjectFinanceService extends BaseService<ProjectFinanceForm> {
    /**
     * 分页获取没有处理的记录
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<ProjectFinanceForm> getAllNotDeal(Page<ProjectFinanceForm> page);

    /**
     * 分页获取已处理的记录
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<ProjectFinanceForm> getAllDealed(Page<ProjectFinanceForm> page);

    /**
     * 根据deal标识获取数量
     *
     * @param deal 0 已处理 1 未处理
     * @return json
     */
    int getCount(int deal);

    /**
     * 根据项目id获取
     * @param page 分页
     * @param proId 项目id
     * @return 分页集合
     */
    IPage<ProjectFinanceForm> getByProId(Page<ProjectFinanceForm> page, String proId);

    /**
     * 获取一段时间内的拨款统计
     * @param start 开始时间
     * @param end 结束时间
     * @return 集合
     */
    List<StatisticsModel> getBetweenStartAndEnd(String start, String end);

}
