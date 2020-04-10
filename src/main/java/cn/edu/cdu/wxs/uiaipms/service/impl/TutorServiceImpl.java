package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.TutorColumn;
import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.domain.Tutor;
import cn.edu.cdu.wxs.uiaipms.form.TutorForm;
import cn.edu.cdu.wxs.uiaipms.mapper.TutorMapper;
import cn.edu.cdu.wxs.uiaipms.service.TutorService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 导师的服务层实现类
 *
 * @author WXS
 * @date 2020/1/13
 */
@Service
public class TutorServiceImpl extends BaseServiceImpl<TutorForm> implements TutorService {

    @Autowired
    private TutorMapper mapper;

    @Override
    public BaseMapper<TutorForm> getMapper() {
        return mapper;
    }

    @Override
    public String getPasswordByUsername(String username) {
        return mapper.selectPasswordByUsername(username, TutorColumn.TUTOR_TABLE);
    }

    @Override
    public TutorForm getByUsername(String username) {
        QueryWrapper<TutorForm> wrapper = new QueryWrapper<>();
        wrapper.select(TutorColumn.TUTOR_ID, TutorColumn.NICKNAME, TutorColumn.IMAGE)
                .eq(TutorColumn.LOGIC_DELETE_FLAG, 0)
                .eq(TutorColumn.USERNAME, username);
        return mapper.selectOne(wrapper);
    }

    @Override
    public IPage<TutorForm> getAllByPage(Page<TutorForm> page) {
        return mapper.selectAll(page);
    }

    @Override
    public IPage<TutorForm> getAllToList(Page<TutorForm> page) {
        return mapper.selectAllInfo(page);
    }

    @Override
    public TutorForm getOneById(String id) {
        QueryWrapper<TutorForm> wrapper = new QueryWrapper<>();
        wrapper.select(TutorColumn.TUTOR_ID, TutorColumn.TUTOR_NAME, GlobalConstant.USERNAME, TutorColumn.FACULTY_ID, GlobalConstant.PHONE)
                .eq(TutorColumn.TUTOR_ID, id);
        return mapper.selectOne(wrapper);
    }

    @Override
    public boolean update(TutorForm form) {
        return SystemUtils.gtTheZero(mapper.updateById(form));
    }

    @Override
    public String getFacIdById(String id) {
        QueryWrapper<TutorForm> wrapper = new QueryWrapper<>();
        wrapper.select(TutorColumn.FACULTY_ID)
                .eq(TutorColumn.TUTOR_ID, id);
        return mapper.selectOne(wrapper).getFacultyId();
    }

    @Override
    public TutorForm getInfo(String id) {
        QueryWrapper<TutorForm> wrapper = new QueryWrapper<>();
        wrapper.select(TutorColumn.TUTOR_ID, TutorColumn.TUTOR_NAME, TutorColumn.NICKNAME, TutorColumn.USERNAME,
                TutorColumn.PHONE)
                .eq(TutorColumn.TUTOR_ID, id);
        return mapper.selectOne(wrapper);
    }
}
