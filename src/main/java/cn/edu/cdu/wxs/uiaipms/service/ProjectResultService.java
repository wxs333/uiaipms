package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.ProjectResultForm;
import cn.edu.cdu.wxs.uiaipms.model.ProjectResultModel;

import java.util.List;

/**
 * <p>
 *  项目成果 服务类
 * </p>
 *
 * @author WXS
 * @since 2020-05-08
 */
public interface ProjectResultService extends BaseService<ProjectResultForm> {

    /**
     * 获取展示数据
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 集合
     */
    List<ProjectResultModel> getData(String start, String end);

}
