package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.CompanyColumn;
import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.CompanyForm;
import cn.edu.cdu.wxs.uiaipms.form.RealmFrom;
import cn.edu.cdu.wxs.uiaipms.mapper.CompanyMapper;
import cn.edu.cdu.wxs.uiaipms.service.CompanyService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WXS
 * @date 2020/1/13
 */
@Service
public class CompanyServiceImpl extends BaseServiceImpl<CompanyForm> implements CompanyService {
    @Autowired
    private CompanyMapper mapper;

    @Override
    public BaseMapper<CompanyForm> getMapper() {
        return mapper;
    }

    @Override
    public RealmFrom getPasswordByUsername(String username) {
        return mapper.selectPasswordByUsername(username, CompanyColumn.COMPANY_TABLE);
    }

    @Override
    public CompanyForm getByUsername(String username) {
        QueryWrapper<CompanyForm> wrapper = new QueryWrapper<>();
        wrapper.select(CompanyColumn.COM_ID, CompanyColumn.COM_NAME, CompanyColumn.IMAGE, CompanyColumn.USERNAME)
                .eq(CompanyColumn.LOGIC_DELETE_FLAG, 0)
                .eq(CompanyColumn.USERNAME, username);
        return mapper.selectOne(wrapper);
    }

    @Override
    public IPage<CompanyForm> getAllInfo(Page<CompanyForm> page) {
        return mapper.selectAllInfo(page);
    }

    @Override
    public CompanyForm getOne(String id) {
        QueryWrapper<CompanyForm> wrapper = new QueryWrapper<>();
        wrapper.select(CompanyColumn.COM_ID, CompanyColumn.COM_NAME, GlobalConstant.USERNAME,
                GlobalConstant.PHONE, CompanyColumn.COM_PEOPLE)
                .eq(CompanyColumn.COM_ID, id);
        return mapper.selectOne(wrapper);
    }

    @Override
    public boolean update(CompanyForm form) {
        return SystemUtils.gtTheZero(mapper.updateById(form));
    }

    @Override
    public List<CompanyForm> getAll() {
        QueryWrapper<CompanyForm> wrapper = new QueryWrapper<>();
        wrapper.select(CompanyColumn.COM_ID, CompanyColumn.COM_NAME);
        return mapper.selectList(wrapper);
    }

    @Override
    public IPage<CompanyForm> getNotRegister(Page<CompanyForm> page) {
        QueryWrapper<CompanyForm> wrapper = new QueryWrapper<>();
        wrapper.select(CompanyColumn.COM_ID, CompanyColumn.COM_NAME, CompanyColumn.USERNAME, CompanyColumn.COM_PEOPLE, CompanyColumn.PHONE
                , CompanyColumn.WORD_NAME, CompanyColumn.LOCATION, CompanyColumn.CREATE_TIME)
                .isNull(CompanyColumn.IMAGE)
                .isNull(CompanyColumn.UPDATE_TIME);
        return mapper.selectPage(page, wrapper);
    }

    @Override
    public IPage<CompanyForm> getByPage(Page<CompanyForm> page) {
        QueryWrapper<CompanyForm> wrapper = new QueryWrapper<>();
        wrapper.select(CompanyColumn.LOCATION, CompanyColumn.COM_NAME, CompanyColumn.USERNAME, CompanyColumn.COM_PEOPLE,
                CompanyColumn.PHONE, CompanyColumn.WORD_NAME, CompanyColumn.AGREE, CompanyColumn.CREATE_TIME, CompanyColumn.UPDATE_TIME)
                .isNotNull(CompanyColumn.UPDATE_TIME);
        return mapper.selectPage(page, wrapper);
    }

    @Override
    public List<CompanyForm> exportData() {
        QueryWrapper<CompanyForm> wrapper = new QueryWrapper<>();
        wrapper.select(CompanyColumn.COM_NAME, CompanyColumn.USERNAME, CompanyColumn.COM_PEOPLE,
                CompanyColumn.PHONE, CompanyColumn.BAN, CompanyColumn.AGREE, CompanyColumn.CREATE_TIME, CompanyColumn.UPDATE_TIME)
                .isNotNull(CompanyColumn.UPDATE_TIME);
        return mapper.selectList(wrapper);
    }

    @Override
    public boolean isExistComNameAndUsername(String comName, String username) {
        QueryWrapper<CompanyForm> wrapper = new QueryWrapper<>();
        wrapper.select(CompanyColumn.COM_ID)
                .eq(CompanyColumn.COM_NAME, comName)
                .or()
                .eq(CompanyColumn.USERNAME, username);
        return SystemUtils.gtTheZero(mapper.selectList(wrapper).size());
    }
}
