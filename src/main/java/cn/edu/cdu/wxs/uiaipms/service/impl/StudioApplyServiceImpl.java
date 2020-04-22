package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.form.StudioApplyForm;
import cn.edu.cdu.wxs.uiaipms.form.StudioForm;
import cn.edu.cdu.wxs.uiaipms.mapper.StudioApplyMapper;
import cn.edu.cdu.wxs.uiaipms.service.StudioApplyService;
import cn.edu.cdu.wxs.uiaipms.service.StudioService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;


/**
 * 工作室申请记录 业务层实现类
 *
 * @author WXS
 * @date 2020/4/22
 */
@Service
public class StudioApplyServiceImpl extends BaseServiceImpl<StudioApplyForm> implements StudioApplyService {

    @Autowired
    private StudioApplyMapper mapper;
    @Autowired
    private StudioService studioService;

    @Override
    public BaseMapper<StudioApplyForm> getMapper() {
        return mapper;
    }

    @Override
    public IPage<StudioApplyForm> getByPage(Page<StudioApplyForm> page) {
        return mapper.selectByPage(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean applyApproval(StudioApplyForm form) {
        form.setUpdateTime(LocalDateTime.now());
        // 同意
        if (!ObjectUtils.isEmpty(form.getAgree())) {
            // 为工作室设置其所属企业
            StudioForm studioForm = new StudioForm();
            studioForm.setComId(form.getComId());
            studioForm.setUpdateTime(form.getUpdateTime());
            studioForm.setStudId(form.getStudId());
            form.setComId(null);

            return modifyById(form) && studioService.modifyById(studioForm);
        }
        form.setComId(null);
        return modifyById(form);
    }
}
