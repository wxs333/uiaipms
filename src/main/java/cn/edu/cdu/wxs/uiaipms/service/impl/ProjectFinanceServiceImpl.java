package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.domain.SysInfo;
import cn.edu.cdu.wxs.uiaipms.form.ProjectFinanceForm;
import cn.edu.cdu.wxs.uiaipms.mapper.ProjectFinanceMapper;
import cn.edu.cdu.wxs.uiaipms.service.ProjectFinanceService;
import cn.edu.cdu.wxs.uiaipms.service.SysInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 项目拨款财务记录 服务实现类
 * </p>
 *
 * @author WXS
 * @since 2020-03-17
 */
@Service
public class ProjectFinanceServiceImpl extends BaseServiceImpl<ProjectFinanceForm> implements ProjectFinanceService {

    @Autowired
    private ProjectFinanceMapper mapper;
    @Autowired
    private SysInfoService sysInfoService;

    @Override
    public BaseMapper<ProjectFinanceForm> getMapper() {
        return mapper;
    }

    @Override
    public IPage<ProjectFinanceForm> getAllNotDeal(Page<ProjectFinanceForm> page) {
        return mapper.selectAllNotDeal(page);
    }

    @Override
    public IPage<ProjectFinanceForm> getAllDealed(Page<ProjectFinanceForm> page) {
        return mapper.selectAllDealed(page);
    }

    @Override
    public int getCount(int deal) {
        return mapper.selectCount(deal);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean modifyById(ProjectFinanceForm domain) {
        // 未同意
        if (StringUtils.isEmpty(domain.getAgree())) {
            return super.modifyById(domain);
        }
        // 同意
        SysInfo info = new SysInfo();
        info.setUpdateTime(domain.getUpdateTime());
        info.setSysCount(domain.getPfAmount());
        info.setSysId(GlobalConstant.MONEY_ID);
        return super.modifyById(domain) && sysInfoService.modifyById(info);
    }
}
