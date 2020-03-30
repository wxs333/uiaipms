package cn.edu.cdu.wxs.uiaipms.service;

import java.util.Map;

/**
 * 基础的服务层，提供一些公用的服务
 *
 * @author WXS
 * @date 2020/1/9
 */
public interface BaseService<T> {
    /**
     * 新增
     *
     * @param domain 实体
     * @return true 成功，false 失败
     */
    boolean add(T domain);

    /**
     * 根据ID修改
     *
     * @param domain 实体
     * @return true 成功，false 失败
     */
    boolean modifyById(T domain);


    /**
     * 根据角色获取用户的表名以及ID列名
     *
     * @param role 角色
     * @return 集合
     */
    Map<String, Object> getTableNameAndIdColByRole(String role);

}
