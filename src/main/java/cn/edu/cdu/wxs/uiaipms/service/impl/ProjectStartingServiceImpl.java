package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.form.ProjectStartingForm;
import cn.edu.cdu.wxs.uiaipms.mapper.ProjectStartingMapper;
import cn.edu.cdu.wxs.uiaipms.service.ProjectStartingService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 项目立项表 业务实现类
 *
 * @author WXS
 * @date 2020/4/2
 */
@Service
public class ProjectStartingServiceImpl extends BaseServiceImpl<ProjectStartingForm> implements ProjectStartingService {

    @Autowired
    private ProjectStartingMapper mapper;

    @Override
    public BaseMapper<ProjectStartingForm> getMapper() {
        return mapper;
    }

    @Override
    public IPage<ProjectStartingForm> getByFacId(Page<ProjectStartingForm> page, String facId) {
        return mapper.selectByFacId(page, facId);
    }
}
