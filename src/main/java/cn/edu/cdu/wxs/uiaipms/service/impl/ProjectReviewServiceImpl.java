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

import java.util.List;

/**
 * @author WXS
 * @date 2020/3/13
 */
@Service
public class ProjectReviewServiceImpl extends BaseServiceImpl<ProjectReviewForm> implements ProjectReviewService {

    @Autowired
    private ProjectReviewMapper mapper;

    @Override
    public BaseMapper<ProjectReviewForm> getMapper() {
        return mapper;
    }


    @Override
    public IPage<ProjectReviewForm> getByTutorId(Page<ProjectReviewForm> page, String tutorId) {
        return mapper.selectByTutorId(page, tutorId);
    }


    @Override
    public IPage<ProjectReviewForm> getByFacId(Page<ProjectReviewForm> page, String facId) {
        return mapper.selectByFacId(page, facId);
    }
}
