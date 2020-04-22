package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.form.StudioApplyForm;
import cn.edu.cdu.wxs.uiaipms.mapper.StudioApplyMapper;
import cn.edu.cdu.wxs.uiaipms.service.StudioApplyService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 工作室申请记录 业务层实现类
 * @author WXS
 * @date 2020/4/22
 */
@Service
public class StudioApplyServiceImpl extends BaseServiceImpl<StudioApplyForm> implements StudioApplyService {

    @Autowired
    private StudioApplyMapper mapper;

    @Override
    public BaseMapper<StudioApplyForm> getMapper() {
        return mapper;
    }
}
