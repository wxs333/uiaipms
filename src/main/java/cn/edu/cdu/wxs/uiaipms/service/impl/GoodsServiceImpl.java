package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.GoodsColumn;
import cn.edu.cdu.wxs.uiaipms.form.GoodsForm;
import cn.edu.cdu.wxs.uiaipms.form.StockIntoLogForm;
import cn.edu.cdu.wxs.uiaipms.mapper.GoodsMapper;
import cn.edu.cdu.wxs.uiaipms.mapper.StockIntoLogMapper;
import cn.edu.cdu.wxs.uiaipms.service.GoodsService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author WXS
 * @date 2020/2/17
 */
@Service
public class GoodsServiceImpl extends BaseServiceImpl<GoodsForm> implements GoodsService {
    @Autowired
    private GoodsMapper mapper;
    @Autowired
    private StockIntoLogMapper stockIntoLogMapper;

    @Override
    public BaseMapper<GoodsForm> getMapper() {
        return mapper;
    }

    @Override
    public List<GoodsForm> getAllGoods() {
        QueryWrapper<GoodsForm> wrapper = new QueryWrapper<>();
        wrapper.select(GoodsColumn.GOODS_ID, GoodsColumn.GOODS_NAME);
        return mapper.selectList(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(GoodsForm form, String adminId) {
        String goodsId = getId(form);
        LocalDateTime dateTime = LocalDateTime.now();
        // 新增一条入库记录
        StockIntoLogForm stock = new StockIntoLogForm();
        stock.setStoId(SystemUtils.getUuid());
        stock.setAdminId(adminId);
        stock.setUpdateTime(dateTime);
        stock.setCreateTime(dateTime);
        stock.setGoodsNum(form.getGoodsNum());
        // 物品已存在
        if (!StringUtils.isEmpty(goodsId)) {
            form.setGoodsId(goodsId);
            form.setUpdateTime(dateTime);

            stock.setGoodsId(goodsId);

            return SystemUtils.gtTheZero(mapper.addGoodsNum(form))
                    && SystemUtils.gtTheZero(stockIntoLogMapper.insert(stock));
        } else {
            // 设置参数
            goodsId = SystemUtils.getUuid();
            form.setGoodsId(goodsId);
            form.setUpdateTime(dateTime);
            form.setCreateTime(dateTime);

            stock.setGoodsId(goodsId);

            return SystemUtils.gtTheZero(mapper.insert(form))
                    && SystemUtils.gtTheZero(stockIntoLogMapper.insert(stock));
        }
    }

    @Override
    public String getId(GoodsForm form) {
        return mapper.selectByForm(form);
    }

    @Override
    public GoodsForm getById(String id) {
        QueryWrapper<GoodsForm> wrapper = new QueryWrapper<>();
        wrapper.select(GoodsColumn.GOODS_BRAND, GoodsColumn.GOODS_MODEL, GoodsColumn.GOODS_NUM)
                .eq(GoodsColumn.GOODS_ID, id);
        return mapper.selectOne(wrapper);
    }

    @Override
    public List<GoodsForm> getGoodsByStudId(String studId) {
        return mapper.selectGoodsByStudId(studId);
    }
}
