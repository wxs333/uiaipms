package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.ProjectApprovalForm;
import cn.edu.cdu.wxs.uiaipms.form.ProjectReviewForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author WXS
 * @date 2020/3/13
 */
public interface ProjectReviewService extends BaseService<ProjectReviewForm> {

    /**
     * 新增审核记录，修改审批记录
     *
     * @param reviewForm   审核表单
     * @param approvalForm 审批表单
     * @return true 成功 false 失败
     */
    boolean add(ProjectReviewForm reviewForm, ProjectApprovalForm approvalForm);

    /**
     * 分页查询导师的审核记录
     *
     * @param page    分页
     * @param tutorId 导师id
     * @return 分页集合
     */
    IPage<ProjectReviewForm> getByTutorId(Page<ProjectReviewForm> page, String tutorId);

    /**
     * 分页查询所有通过审核的项目
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<ProjectReviewForm> getReviewed(Page<ProjectReviewForm> page);
}
