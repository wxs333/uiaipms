package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.ProjectStartingForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 项目立项表 业务接口类
 * @author WXS
 * @date 2020/4/2
 */
public interface ProjectStartingService extends BaseService<ProjectStartingForm> {

    /**
     * 查询某个学院的可立项的项目
     * @param page 分页
     * @param facId 学院id
     * @return 分页集合
     */
    IPage<ProjectStartingForm> getByFacId(Page<ProjectStartingForm> page,String facId);
}
