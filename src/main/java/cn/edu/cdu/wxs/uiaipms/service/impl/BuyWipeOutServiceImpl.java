package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.form.BuyWipeOutForm;
import cn.edu.cdu.wxs.uiaipms.mapper.BuyWipeOutMapper;
import cn.edu.cdu.wxs.uiaipms.service.BaseService;
import cn.edu.cdu.wxs.uiaipms.service.BuyWipeOutService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 采购报销 业务实现类
 * @author WXS
 * @date 2020/3/19
 */
@Service
public class BuyWipeOutServiceImpl extends BaseServiceImpl<BuyWipeOutForm> implements BuyWipeOutService {

    @Autowired
    private BuyWipeOutMapper mapper;

    @Override
    public BaseMapper<BuyWipeOutForm> getMapper() {
        return mapper;
    }
}
