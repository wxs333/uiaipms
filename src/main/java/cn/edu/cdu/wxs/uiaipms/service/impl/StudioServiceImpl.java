package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.StudioColumn;
import cn.edu.cdu.wxs.uiaipms.form.StudioForm;
import cn.edu.cdu.wxs.uiaipms.mapper.StudioMapper;
import cn.edu.cdu.wxs.uiaipms.service.StudioService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 工作室 业务层实现类
 *
 * @author WXS
 * @date 2020/2/15
 */
@Service
public class StudioServiceImpl extends BaseServiceImpl<StudioForm> implements StudioService {
    @Autowired
    private StudioMapper mapper;

    @Override
    public BaseMapper<StudioForm> getMapper() {
        return mapper;
    }

    @Override
    public IPage<StudioForm> getAll(Page<StudioForm> page) {
        return mapper.selectAll(page);
    }

    @Override
    public StudioForm getById(String studId) {
        QueryWrapper<StudioForm> wrapper = new QueryWrapper<>();
        wrapper.select(StudioColumn.STUD_ID, StudioColumn.STUD_ADDRESS, StudioColumn.STUD_AREA,
                StudioColumn.STUD_NUM, StudioColumn.STUD_ROOM_NO, StudioColumn.COM_ID)
                .eq(StudioColumn.STUD_ID, studId);
        return mapper.selectOne(wrapper);
    }

    @Override
    public boolean updateBan(String ban, String studId, LocalDateTime updateTime) {
        return SystemUtils.gtTheZero(mapper.updateBan(ban, studId, updateTime));
    }
}
