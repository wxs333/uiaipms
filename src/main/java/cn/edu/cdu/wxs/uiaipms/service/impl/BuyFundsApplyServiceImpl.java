package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.domain.SysInfo;
import cn.edu.cdu.wxs.uiaipms.form.BuyFundsApplyForm;
import cn.edu.cdu.wxs.uiaipms.mapper.BuyFundsApplyMapper;
import cn.edu.cdu.wxs.uiaipms.service.BuyFundsApplyService;
import cn.edu.cdu.wxs.uiaipms.service.SysInfoService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 采购资金申请 业务实现类
 *
 * @author WXS
 * @date 2020/3/19
 */
@Service
public class BuyFundsApplyServiceImpl extends BaseServiceImpl<BuyFundsApplyForm> implements BuyFundsApplyService {

    @Autowired
    private BuyFundsApplyMapper mapper;
    @Autowired
    private SysInfoService infoService;

    @Override
    public BaseMapper<BuyFundsApplyForm> getMapper() {
        return mapper;
    }

    @Override
    public IPage<BuyFundsApplyForm> getPageNoDeal(Page<BuyFundsApplyForm> page) {
        return mapper.selectPageNoDeal(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean modifyById(BuyFundsApplyForm domain) {
        // 设置参数
        domain.setUpdateTime(LocalDateTime.now());
        // 不同意
        if (StringUtils.isEmpty(domain.getBfaAgree())) {
            return super.modifyById(domain);
        }
        // 创建SysInfo
        SysInfo info = new SysInfo();
        info.setSysId(GlobalConstant.MONEY_ID);
        info.setUpdateTime(LocalDateTime.now());
        info.setSysCount(domain.getApplyMount());
        // 记录审批信息完善，财务总额减少
        return super.modifyById(domain) && infoService.modifyById(info);
    }

    @Override
    public IPage<BuyFundsApplyForm> getPageDeal(Page<BuyFundsApplyForm> page) {
        return mapper.selectPageDeal(page);
    }

    @Override
    public List<BuyFundsApplyForm> getExportData() {
        return mapper.selectExportData();
    }

    @Override
    public IPage<BuyFundsApplyForm> getApplyList(Page<BuyFundsApplyForm> page) {
        return mapper.selectApplyList(page);
    }

    @Override
    public Map<String, Map<String, Object>> getBetweenStartAndEnd(LocalDateTime start, LocalDateTime end) {
        return mapper.selectBetweenStartAndEnd(start, end);
    }
}
