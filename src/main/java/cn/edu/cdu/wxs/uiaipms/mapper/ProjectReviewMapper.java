package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.ProjectReviewForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 项目审核表 Mapper 接口
 * </p>
 *
 * @author WXS
 * @since 2020-03-13
 */
@Mapper
public interface ProjectReviewMapper extends BaseMapper<ProjectReviewForm> {

    /**
     * 分页查询导师的审核记录
     *
     * @param page    分页
     * @param tutorId 导师id
     * @return 分页集合
     */
    IPage<ProjectReviewForm> selectByTutorId(@Param("page") Page<ProjectReviewForm> page, @Param("tutorId") String tutorId);

    /**
     * 获取某个学院所有待审核的项目
     *
     * @param page  分页
     * @param facId 学院id
     * @return 分页集合
     */
    IPage<ProjectReviewForm> selectByFacId(Page<ProjectReviewForm> page, @Param("facId") String facId);
}
