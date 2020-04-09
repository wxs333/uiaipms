package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.ProjectStartingForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 项目立项表 Mapper 接口
 * </p>
 *
 * @author WXS
 * @since 2020-03-13
 */
@Mapper
public interface ProjectStartingMapper extends BaseMapper<ProjectStartingForm> {

    /**
     * 查询某个学院的可立项的项目
     *
     * @param page  分页
     * @param facId 学院id
     * @return 分页集合
     */
    IPage<ProjectStartingForm> selectByFacId(Page<ProjectStartingForm> page, @Param("facId") String facId);

    /**
     * 获取某个学院可导出的数据
     * @param facId 学院id
     * @return 集合
     */
    List<ProjectStartingForm> selectExportData(@Param("facId") String facId);
}
