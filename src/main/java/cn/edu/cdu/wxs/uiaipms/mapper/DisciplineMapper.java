package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.domain.Discipline;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系 数据层
 * @author WXS
 * @date 2020/2/11
 */
@Mapper
public interface DisciplineMapper extends CommonMapper<Discipline> {
    /**
     * 根据学院ID获取系
     * @param facId 学院ID
     * @return 集合
     */
    List<Discipline> selectByFacId(@Param("facId") String facId);
}
