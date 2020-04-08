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

    /**
     * 分页获取某个学生申报的项目
     *
     * @param page  分页
     * @param stuId 学生id
     * @return 分页集合
     */
    IPage<ProjectForm> getByStuId(Page<ProjectForm> page, String stuId);

    /**
     * 重新申报项目
     *
     * @param form     新项目表单
     * @param odlProId 旧项目id
     * @return true 成功 false 失败
     */
    boolean afresh(ProjectForm form, String odlProId);
}
