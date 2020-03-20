package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.form.BuyFundsApplyForm;
import cn.edu.cdu.wxs.uiaipms.mapper.BuyFundsApplyMapper;
import cn.edu.cdu.wxs.uiaipms.service.BuyFundsApplyService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public BaseMapper<BuyFundsApplyForm> getMapper() {
        return mapper;
    }
}
