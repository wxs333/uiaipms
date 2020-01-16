package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.TutorColumn;
import cn.edu.cdu.wxs.uiaipms.domain.Tutor;
import cn.edu.cdu.wxs.uiaipms.form.TutorForm;
import cn.edu.cdu.wxs.uiaipms.mapper.TutorMapper;
import cn.edu.cdu.wxs.uiaipms.service.TutorService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 导师的服务层实现类
 * @author WXS
 * @date 2020/1/13
 */
@Service
public class TutorServiceImpl extends BaseServiceImpl<Tutor> implements TutorService {

    @Autowired
    private TutorMapper mapper;

    @Override
    public BaseMapper<Tutor> getMapper() {
        return mapper;
    }

    @Override
    public String getPasswordByUsername(String username) {
        return mapper.selectPasswordByUsername(username, TutorColumn.TUTOR_TABLE);
    }

    @Override
    public TutorForm getByUsername(String username) {
        return mapper.getByUsername(username);
    }

    @Override
    public IPage<TutorForm> getAllByPage(Page<TutorForm> page) {
        return mapper.selectAll(page);
    }
}
