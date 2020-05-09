package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.ProjectResultForm;
import cn.edu.cdu.wxs.uiaipms.model.ProjectResultModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目成果 数据访问类
 *
 * @author WXS
 * @date 2020/5/8
 */
@Mapper
public interface ProjectResultMapper extends BaseMapper<ProjectResultForm> {

    /**
     * 获取展示数据
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 集合
     */
    List<ProjectResultModel> selectData(@Param("start") String start, @Param("end") String end);
}
