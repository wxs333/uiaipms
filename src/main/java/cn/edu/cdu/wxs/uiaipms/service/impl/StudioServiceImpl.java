package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.StudioColumn;
import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
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
import java.util.List;


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
        QueryWrapper<StudioForm> wrapper = new QueryWrapper<>();
        wrapper.select(StudioColumn.STUD_ID, StudioColumn.STUD_ADDRESS, StudioColumn.STUD_ROOM_NO, StudioColumn.STUD_AREA,
                StudioColumn.UPDATE_TIME, StudioColumn.CREATE_TIME, StudioColumn.BAN);
        return mapper.selectPage(page, wrapper);
    }

    @Override
    public StudioForm getById(String studId) {
        QueryWrapper<StudioForm> wrapper = new QueryWrapper<>();
        wrapper.select(StudioColumn.STUD_ID, StudioColumn.STUD_ADDRESS, StudioColumn.STUD_AREA, StudioColumn.STUD_ROOM_NO)
                .eq(StudioColumn.STUD_ID, studId);
        return mapper.selectOne(wrapper);
    }

    @Override
    public boolean updateBan(String ban, String studId, LocalDateTime updateTime) {
        return SystemUtils.gtTheZero(mapper.updateBan(ban, studId, updateTime));
    }

    @Override
    public IPage<StudioForm> getAllByComId(Page<StudioForm> page, String comId) {
        return mapper.selectPage(page, tableData(comId));
    }

    @Override
    public List<StudioForm> getList(String comId) {
        return mapper.selectList(tableData(comId));
    }

    /**
     * 企业用户工作室表格数据
     *
     * @param comId 企业ID
     * @return 查询
     */
    private QueryWrapper<StudioForm> tableData(String comId) {
        QueryWrapper<StudioForm> wrapper = new QueryWrapper<>();
        wrapper.select(StudioColumn.STUD_ID, StudioColumn.STUD_ADDRESS, StudioColumn.STUD_ROOM_NO, StudioColumn.BAN,
                StudioColumn.STUD_NUM, StudioColumn.STUD_AREA, GlobalConstant.CREATE_TIME, GlobalConstant.UPDATE_TIME)
                .eq(StudioColumn.COM_ID, comId)
                .eq(GlobalConstant.LOGIC_DELETE_FLAG, 0);
        return wrapper;
    }

    @Override
    public List<StudioForm> getIdAndAddressAndRoomNo() {
        return mapper.selectIdAndAddressAndRoomNo();
    }

    @Override
    public IPage<StudioForm> getHaveComId(Page<StudioForm> page) {
        return mapper.selectHaveComId(page);
    }

    @Override
    public boolean revoke(String id) {
        return SystemUtils.gtTheZero(mapper.updateComIdIsNullById(id));
    }
}
