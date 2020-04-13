package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.ProjectFinanceForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * <p>
 * 项目拨款财务记录 Mapper 接口
 * </p>
 *
 * @author WXS
 * @since 2020-03-17
 */
@Mapper
public interface ProjectFinanceMapper extends BaseMapper<ProjectFinanceForm> {

    /**
     * 分页获取没有处理的记录
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<ProjectFinanceForm> selectAllNotDeal(Page<ProjectFinanceForm> page);

    /**
     * 分页获取已处理的记录
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<ProjectFinanceForm> selectAllDealed(Page<ProjectFinanceForm> page);

    /**
     * 根据deal标识获取数量
     *
     * @param deal 0 已处理 1 未处理
     * @return json
     */
    int selectCount(@Param("deal") int deal);

    /**
     * 根据项目id获取
     * @param page 分页
     * @param proId 项目id
     * @return 分页集合
     */
    IPage<ProjectFinanceForm> selectByProId(Page<ProjectFinanceForm> page, @Param("proId") String proId);

    /**
     * 获取一段时间内的拨款统计
     * @param start 开始时间
     * @param end 结束时间
     * @return 集合
     */
    @MapKey("pro_name")
    Map<String, Map<String, Object>> selectBetweenStartAndEnd(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
