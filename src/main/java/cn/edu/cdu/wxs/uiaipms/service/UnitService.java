package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.domain.Unit;

import java.util.List;

/**
 * 单位 业务层接口
 *
 * @author WXS
 * @date 2020/2/17
 */
public interface UnitService {

    /**
     * 获取所有单位
     *
     * @return 集合
     */
    List<Unit> getAll();
}
