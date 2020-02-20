package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.domain.Discipline;

import java.util.List;

/**
 * 系 服务层接口
 *
 * @author WXS
 * @date 2020/2/11
 */
public interface DisciplineService {

    /**
     * 根据学院ID获取系
     *
     * @return 集合
     */
    List<Discipline> getAll();
}
