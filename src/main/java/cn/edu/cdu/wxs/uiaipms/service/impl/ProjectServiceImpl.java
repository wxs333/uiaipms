package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.form.ProjectForm;
import cn.edu.cdu.wxs.uiaipms.mapper.ProjectMapper;
import cn.edu.cdu.wxs.uiaipms.service.ProjectService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public BaseMapper<ProjectForm> getMapper() {
        return mapper;
    }
}
