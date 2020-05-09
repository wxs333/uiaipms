package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.domain.SysInfo;
import cn.edu.cdu.wxs.uiaipms.form.ProjectFinanceForm;
import cn.edu.cdu.wxs.uiaipms.mapper.ProjectFinanceMapper;
import cn.edu.cdu.wxs.uiaipms.model.StatisticsModel;
import cn.edu.cdu.wxs.uiaipms.service.ProjectFinanceService;
import cn.edu.cdu.wxs.uiaipms.service.ProjectService;
import cn.edu.cdu.wxs.uiaipms.service.SysInfoService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

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
    @Autowired
    private ProjectService projectService;

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
    public String approve(ProjectFinanceForm form) {
        boolean flag;
        // 如果项目已经结题，就删除该记录
        if (!StringUtils.isEmpty(projectService.getSuccessByProId(form.getProId()))) {
            ProjectFinanceForm financeForm = new ProjectFinanceForm();
            financeForm.setPfId(form.getPfId());
            financeForm.setLogicDeleteFlag(1);
            financeForm.setUpdateTime(LocalDateTime.now());
            super.modifyById(financeForm);
            return GlobalConstant.ERROR;
        }
        // 未同意
        if (StringUtils.isEmpty(form.getAgree())) {
            flag = super.modifyById(form);
        }
        // 同意，减少财务金额
        SysInfo info = new SysInfo();
        info.setUpdateTime(form.getUpdateTime());
        info.setSysCount(form.getPfAmount());
        info.setSysId(GlobalConstant.MONEY_ID);
        flag = super.modifyById(form) && sysInfoService.modifyById(info);

        if (flag) {
            return GlobalConstant.SUCCESS;
        }

        return GlobalConstant.FAILURE;
    }

    @Override
    public IPage<ProjectFinanceForm> getByProId(Page<ProjectFinanceForm> page, String proId) {
        return mapper.selectByProId(page, proId);
    }

    @Override
    public List<StatisticsModel> getBetweenStartAndEnd(String start, String end) {
        return mapper.selectBetweenStartAndEnd(start, end);
    }
}
