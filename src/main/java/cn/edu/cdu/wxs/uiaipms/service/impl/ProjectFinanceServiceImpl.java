package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.form.ProjectFinanceForm;
import cn.edu.cdu.wxs.uiaipms.mapper.ProjectFinanceMapper;
import cn.edu.cdu.wxs.uiaipms.service.ProjectFinanceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 项目拨款财务记录 服务实现类
 * </p>
 *
 * @author WXS
 * @since 2020-03-17
 */
@Service
public class ProjectFinanceServiceImpl extends BaseServiceImpl<ProjectFinanceForm> implements ProjectFinanceService {

    @Autowired
    private ProjectFinanceMapper mapper;

    @Override
    public BaseMapper<ProjectFinanceForm> getMapper() {
        return mapper;
    }

    @Override
    public IPage<ProjectFinanceForm> getAllNotDeal(Page<ProjectFinanceForm> page) {
        return mapper.selectAllNotDeal(page);
    }

    @Override
    public IPage<ProjectFinanceForm> getAllDealed(Page<ProjectFinanceForm> page) {
        return mapper.selectAllDealed(page);
    }

    @Override
    public int getCount(int deal) {
        return mapper.selectCount(deal);
    }
}
