package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.form.GoodsForm;
import cn.edu.cdu.wxs.uiaipms.mapper.GoodsMapper;
import cn.edu.cdu.wxs.uiaipms.service.GoodsService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WXS
 * @date 2020/2/17
 */
@Service
public class GoodsServiceImpl extends BaseServiceImpl<GoodsForm> implements GoodsService {
    @Autowired
    private GoodsMapper mapper;

    @Override
    public BaseMapper<GoodsForm> getMapper() {
        return mapper;
    }
}
