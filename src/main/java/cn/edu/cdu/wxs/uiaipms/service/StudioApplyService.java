package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.StudioApplyForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 工作室申请记录 业务层接口
 *
 * @author WXS
 * @date 2020/4/22
 */
public interface StudioApplyService extends BaseService<StudioApplyForm> {

    /**
     * 分页查询
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<StudioApplyForm> getByPage(Page<StudioApplyForm> page);

    /**
     * 申请审批
     * @param form 表单
     * @return true 成功 false 失败
     */
    boolean applyApproval(StudioApplyForm form);
}
