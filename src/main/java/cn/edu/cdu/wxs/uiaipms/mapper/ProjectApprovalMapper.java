package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.ProjectApprovalForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 项目审批记录 数据层接口
 *
 * @author WXS
 * @date 2020/2/28
 */
@Mapper
public interface ProjectApprovalMapper extends CommonMapper<ProjectApprovalForm> {

    /**
     * 分页查询某个导师已审批的项目
     *
     * @param page    分页
     * @param tutorId 导师ID
     * @return 分页集合
     */
    IPage<ProjectApprovalForm> selectByTutorId(Page<ProjectApprovalForm> page, @Param("tutorId") String tutorId);

    /**
     * 分页获取
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<ProjectApprovalForm> selectByPage(Page<ProjectApprovalForm> page);
}
