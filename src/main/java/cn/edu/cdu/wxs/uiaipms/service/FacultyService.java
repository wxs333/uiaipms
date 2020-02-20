package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.domain.Faculty;

import java.util.List;

/**
 * 学院 服务层
 * @author WXS
 * @date 2020/2/10
 */
public interface FacultyService {

    /**
     * 获取所有学院信息
     * @return 集合
     */
    List<Faculty> getAll();
}
