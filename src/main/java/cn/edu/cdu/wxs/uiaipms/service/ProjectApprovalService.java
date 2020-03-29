package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.ProjectApprovalForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 项目审批记录 业务层接口
 *
 * @author WXS
 * @date 2020/2/28
 */
public interface ProjectApprovalService extends BaseService<ProjectApprovalForm> {

    /**
     * 分页查询某个导师已审批的项目
     *
     * @param page    分页
     * @param tutorId 导师ID
     * @return 分页集合
     */
    IPage<ProjectApprovalForm> getByTutorId(Page<ProjectApprovalForm> page, String tutorId);

    /**
     * 分页获取
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<ProjectApprovalForm> getByPage(Page<ProjectApprovalForm> page);
}
