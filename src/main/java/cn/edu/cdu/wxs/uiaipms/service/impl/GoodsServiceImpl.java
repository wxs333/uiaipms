package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.GoodsColumn;
import cn.edu.cdu.wxs.uiaipms.form.GoodsForm;
import cn.edu.cdu.wxs.uiaipms.mapper.GoodsMapper;
import cn.edu.cdu.wxs.uiaipms.service.GoodsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<GoodsForm> getAllGoods() {
        QueryWrapper<GoodsForm> wrapper = new QueryWrapper<>();
        wrapper.select(GoodsColumn.GOODS_ID, GoodsColumn.GOODS_NAME, GoodsColumn.GOODS_NUM);
        return mapper.selectList(wrapper);
    }
}
