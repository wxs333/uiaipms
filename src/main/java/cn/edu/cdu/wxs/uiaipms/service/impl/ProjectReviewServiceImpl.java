package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.form.ProjectApprovalForm;
import cn.edu.cdu.wxs.uiaipms.form.ProjectReviewForm;
import cn.edu.cdu.wxs.uiaipms.form.ProjectStartingForm;
import cn.edu.cdu.wxs.uiaipms.mapper.ProjectApprovalMapper;
import cn.edu.cdu.wxs.uiaipms.mapper.ProjectReviewMapper;
import cn.edu.cdu.wxs.uiaipms.mapper.ProjectStartingMapper;
import cn.edu.cdu.wxs.uiaipms.service.ProjectReviewService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author WXS
 * @date 2020/3/13
 */
@Service
public class ProjectReviewServiceImpl extends BaseServiceImpl<ProjectReviewForm> implements ProjectReviewService {

    @Autowired
    private ProjectReviewMapper mapper;
    @Autowired
    private ProjectApprovalMapper approvalMapper;
    @Autowired
    private ProjectStartingMapper startingMapper;

    @Override
    public BaseMapper<ProjectReviewForm> getMapper() {
        return mapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(ProjectReviewForm reviewForm, ProjectApprovalForm approvalForm) {
        return super.add(reviewForm) && SystemUtils.gtTheZero(approvalMapper.updateById(approvalForm));
    }

    @Override
    public IPage<ProjectReviewForm> getByTutorId(Page<ProjectReviewForm> page, String tutorId) {
        return mapper.selectByTutorId(page, tutorId);
    }

    @Override
    public IPage<ProjectReviewForm> getReviewed(Page<ProjectReviewForm> page) {
        return mapper.selectReviewed(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean projectStarting(ProjectReviewForm form) {
        // 立项记录表单
        ProjectStartingForm startingForm = new ProjectStartingForm();
        startingForm.setPsId(SystemUtils.getUuid());
        startingForm.setCreateTime(form.getUpdateTime());
        startingForm.setUpdateTime(form.getUpdateTime());
        startingForm.setTutorId(form.getTutorId());
        startingForm.setPrId(form.getPrId());

        form.setTutorId(null);
        return modifyById(form) && SystemUtils.gtTheZero(startingMapper.insert(startingForm));
    }
}
