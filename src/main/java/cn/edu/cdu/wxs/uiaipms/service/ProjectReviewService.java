package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.ProjectReviewForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author WXS
 * @date 2020/3/13
 */
public interface ProjectReviewService extends BaseService<ProjectReviewForm> {

    /**
     * 分页查询导师的审核记录
     *
     * @param page    分页
     * @param tutorId 导师id
     * @return 分页集合
     */
    IPage<ProjectReviewForm> getByTutorId(Page<ProjectReviewForm> page, String tutorId);

    /**
     * 获取某个学院所有待审核的项目
     * @param page 分页
     * @param facId 学院id
     * @return 分页集合
     */
    IPage<ProjectReviewForm> getByFacId(Page<ProjectReviewForm> page, String facId);
}
