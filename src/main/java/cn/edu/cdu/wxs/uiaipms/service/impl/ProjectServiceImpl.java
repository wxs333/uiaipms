package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.ProjectColumn;
import cn.edu.cdu.wxs.uiaipms.form.ProjectApprovalForm;
import cn.edu.cdu.wxs.uiaipms.form.ProjectForm;
import cn.edu.cdu.wxs.uiaipms.form.ProjectReviewForm;
import cn.edu.cdu.wxs.uiaipms.form.ProjectStartingForm;
import cn.edu.cdu.wxs.uiaipms.mapper.ProjectMapper;
import cn.edu.cdu.wxs.uiaipms.service.ProjectApprovalService;
import cn.edu.cdu.wxs.uiaipms.service.ProjectReviewService;
import cn.edu.cdu.wxs.uiaipms.service.ProjectService;
import cn.edu.cdu.wxs.uiaipms.service.ProjectStartingService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * 项目 业务层实现类
 *
 * @author WXS
 * @date 2020/2/27
 */
@Service
public class ProjectServiceImpl extends BaseServiceImpl<ProjectForm> implements ProjectService {

    @Autowired
    private ProjectMapper mapper;
    @Autowired
    private ProjectApprovalService approvalService;
    @Autowired
    private ProjectReviewService reviewService;
    @Autowired
    private ProjectStartingService startingService;

    @Override
    public BaseMapper<ProjectForm> getMapper() {
        return mapper;
    }

    @Override
    public IPage<ProjectForm> getByFacId(Page<ProjectForm> page, String facId) {
        return mapper.selectByFacId(page, facId);
    }

    /**
     * 重写add方法，申报项目时，会自动添加项目审批、审核、立项记录
     *
     * @param domain 表单
     * @return true 成功 false 失败
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(ProjectForm domain) {
        // 创建审批表单
        ProjectApprovalForm approvalForm = new ProjectApprovalForm();
        approvalForm.setPaId(SystemUtils.getUuid());
        approvalForm.setCreateTime(domain.getCreateTime());
        approvalForm.setProId(domain.getProId());
        // 创建审核表单
        ProjectReviewForm reviewForm = new ProjectReviewForm();
        reviewForm.setPrId(SystemUtils.getUuid());
        reviewForm.setCreateTime(domain.getCreateTime());
        reviewForm.setProId(domain.getProId());
        // 创建立项表单
        ProjectStartingForm startingForm = new ProjectStartingForm();
        startingForm.setPsId(SystemUtils.getUuid());
        startingForm.setCreateTime(domain.getCreateTime());
        startingForm.setProId(domain.getProId());
        // 新增
        return super.add(domain) && approvalService.add(approvalForm)
                && reviewService.add(reviewForm) && startingService.add(startingForm);
    }

    @Override
    public IPage<ProjectForm> getByStuId(Page<ProjectForm> page, String stuId) {
        return mapper.selectByStuId(page, stuId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean afresh(ProjectForm form, String odlProId) {
        // 修改表单
        ProjectForm updateForm = new ProjectForm();
        updateForm.setUpdateTime(form.getUpdateTime());
        updateForm.setProId(odlProId);
        updateForm.setLogicDeleteFlag(1);
        // 新增一条项目记录，旧项目逻辑删除
        return add(form) && modifyById(updateForm);
    }
}
