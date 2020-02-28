package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.ProjectForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 项目 业务层接口
 *
 * @author WXS
 * @date 2020/2/27
 */
public interface ProjectService extends BaseService<ProjectForm> {
    /**
     * 查询学院所有未审批的项目
     *
     * @param page  分页
     * @param facId 学院ID
     * @return 分页集合
     */
    IPage<ProjectForm> getByFacId(Page<ProjectForm> page, String facId);
}
