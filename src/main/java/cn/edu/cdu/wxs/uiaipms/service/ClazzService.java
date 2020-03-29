package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.domain.Clazz;

import java.util.List;

/**
 * 班级 业务层
 *
 * @author WXS
 * @date 2020/1/27
 */
public interface ClazzService extends BaseService<Clazz> {

    /**
     * 获取所有班级
     *
     * @param discId 系别ID
     * @return 集合
     */
    List<Clazz> getAllByDiscId(String discId);

}
