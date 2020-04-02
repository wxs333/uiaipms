package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.form.ProjectApprovalForm;
import cn.edu.cdu.wxs.uiaipms.form.ProjectForm;
import cn.edu.cdu.wxs.uiaipms.mapper.ProjectApprovalMapper;
import cn.edu.cdu.wxs.uiaipms.mapper.ProjectMapper;
import cn.edu.cdu.wxs.uiaipms.service.ProjectApprovalService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author WXS
 * @date 2020/2/28
 */
@Service
public class ProjectApprovalServiceImpl extends BaseServiceImpl<ProjectApprovalForm> implements ProjectApprovalService {

    @Autowired
    private ProjectApprovalMapper mapper;


    @Override
    public BaseMapper<ProjectApprovalForm> getMapper() {
        return mapper;
    }

    @Override
    public IPage<ProjectApprovalForm> getByTutorId(Page<ProjectApprovalForm> page, String tutorId) {
        return mapper.selectByTutorId(page, tutorId);
    }

}
