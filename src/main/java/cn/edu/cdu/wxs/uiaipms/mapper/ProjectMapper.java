package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.ProjectForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * 项目 数据层接口
 *
 * @author WXS
 * @date 2020/2/27
 */
public interface ProjectMapper extends CommonMapper<ProjectForm> {

    /**
     * 查询学院所有未审批的项目
     *
     * @param page  分页
     * @param facId 学院ID
     * @return 分页集合
     */
    IPage<ProjectForm> selectByFacId(Page<ProjectForm> page, @Param("facId") String facId);

    /**
     * 分页获取某个学生申报的项目
     * @param page 分页
     * @param stuId 学生id
     * @return 分页集合
     */
    IPage<ProjectForm> selectByStuId(Page<ProjectForm> page, @Param("stuId") String stuId);
}
