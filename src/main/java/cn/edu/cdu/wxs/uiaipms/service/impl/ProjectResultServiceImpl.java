package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.form.ProjectForm;
import cn.edu.cdu.wxs.uiaipms.form.ProjectResultForm;
import cn.edu.cdu.wxs.uiaipms.form.ProjectStartingForm;
import cn.edu.cdu.wxs.uiaipms.mapper.ProjectResultMapper;
import cn.edu.cdu.wxs.uiaipms.model.ProjectResultModel;
import cn.edu.cdu.wxs.uiaipms.service.ProjectResultService;
import cn.edu.cdu.wxs.uiaipms.service.ProjectService;
import cn.edu.cdu.wxs.uiaipms.service.ProjectStartingService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 项目成果 业务实现类
 *
 * @author WXS
 * @date 2020/5/8
 */
@Service
public class ProjectResultServiceImpl extends BaseServiceImpl<ProjectResultForm> implements ProjectResultService {

    @Autowired
    private ProjectResultMapper mapper;
    @Autowired
    private ProjectStartingService startingService;
    @Autowired
    private ProjectService projectService;

    @Override
    public BaseMapper<ProjectResultForm> getMapper() {
        return mapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(ProjectResultForm domain) {
        // 修改立项表
        ProjectStartingForm startingForm = new ProjectStartingForm();
        startingForm.setPsId(domain.getPsId());
        startingForm.setEnd("0");
        startingForm.setUpdateTime(LocalDateTime.now());
        // 修改项目表
        ProjectForm projectForm = new ProjectForm();
        projectForm.setSuccess(domain.getSuccess().toString());
        projectForm.setProId(domain.getProId());
        projectForm.setUpdateTime(LocalDateTime.now());

        domain.setPsId(null);
        return super.add(domain) && startingService.modifyById(startingForm) && projectService.modifyById(projectForm);
    }

    @Override
    public List<ProjectResultModel> getData(String start, String end) {
        return mapper.selectData(start, end);
    }
}
