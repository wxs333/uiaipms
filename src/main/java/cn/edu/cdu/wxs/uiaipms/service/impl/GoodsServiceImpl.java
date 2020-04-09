package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.GoodsColumn;
import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.GoodsForm;
import cn.edu.cdu.wxs.uiaipms.form.StockIntoLogForm;
import cn.edu.cdu.wxs.uiaipms.mapper.GoodsMapper;
import cn.edu.cdu.wxs.uiaipms.mapper.StockIntoLogMapper;
import cn.edu.cdu.wxs.uiaipms.service.GoodsService;
import cn.edu.cdu.wxs.uiaipms.service.StockIntoLogService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
 * @author WXS
 * @date 2020/2/17
 */
@Service
public class GoodsServiceImpl extends BaseServiceImpl<GoodsForm> implements GoodsService {
    @Autowired
    private GoodsMapper mapper;
    @Autowired
    private StockIntoLogService stockIntoLogService;

    @Override
    public BaseMapper<GoodsForm> getMapper() {
        return mapper;
    }

    @Override
    public List<GoodsForm> getAllGoods() {
        QueryWrapper<GoodsForm> wrapper = new QueryWrapper<>();
        wrapper.select(GoodsColumn.GOODS_ID, GoodsColumn.GOODS_NAME)
                .eq(GoodsColumn.LOGIC_DELETE_FLAG, 0)
                .eq(GoodsColumn.BAN, 0);
        return mapper.selectList(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(GoodsForm form, String adminId) {
        // 判断物品是否已存在，名称、品牌、型号一样就判定相同
        String goodsId = getId(form);
        // 无论物品是否存在，都会新增入库记录
        StockIntoLogForm intoLogForm = new StockIntoLogForm();
        intoLogForm.setCreateTime(LocalDateTime.now());
        intoLogForm.setUpdateTime(LocalDateTime.now());
        intoLogForm.setGoodsNum(form.getGoodsNum());
        intoLogForm.setPrice(form.getPrice());
        intoLogForm.setAdminId(adminId);
        intoLogForm.setStoId(SystemUtils.getUuid());
        form.setPrice(null);
        // 不存在
        if (StringUtils.isEmpty(goodsId)) {
            goodsId = SystemUtils.getUuid();
            intoLogForm.setGoodsId(goodsId);
            // 设置物品表单参数
            form.setGoodsId(goodsId);
            form.setUpdateTime(LocalDateTime.now());
            form.setCreateTime(LocalDateTime.now());

            return add(form) && stockIntoLogService.add(intoLogForm);
        }
        // 存在
        intoLogForm.setGoodsId(goodsId);
        form.setGoodsId(goodsId);
        form.setUpdateTime(LocalDateTime.now());
        form.setGoodsNum(getNumById(goodsId) + form.getGoodsNum());
        return modifyById(form) && stockIntoLogService.add(intoLogForm);
    }

    @Override
    public String getId(GoodsForm form) {
        return mapper.selectByForm(form);
    }

    @Override
    public GoodsForm getById(String id) {
        QueryWrapper<GoodsForm> wrapper = new QueryWrapper<>();
        wrapper.select(GoodsColumn.GOODS_ID, GoodsColumn.GOODS_NAME, GoodsColumn.GOODS_BRAND, GoodsColumn.GOODS_MODEL, GoodsColumn.GOODS_NUM
                , GoodsColumn.UNIT_ID)
                .eq(GoodsColumn.GOODS_ID, id);
        return mapper.selectOne(wrapper);
    }

    @Override
    public List<GoodsForm> getGoodsByStudId(String studId) {
        return mapper.selectGoodsByStudId(studId);
    }

    @Override
    public IPage<GoodsForm> getByPage(Page<GoodsForm> page) {
        return mapper.selectByPage(page);
    }

    @Override
    public List<GoodsForm> getGoodsAndNumByStudId(String studId) {
        return mapper.selectGoodsAndNumByStudId(studId);
    }

    @Override
    public int getNumById(String id) {
        QueryWrapper<GoodsForm> wrapper = new QueryWrapper<>();
        wrapper.select(GoodsColumn.GOODS_NUM)
                .eq(GoodsColumn.GOODS_ID, id);
        return mapper.selectOne(wrapper).getGoodsNum();
    }

    @Override
    public int getCount() {
        return mapper.selectCount();
    }
}
