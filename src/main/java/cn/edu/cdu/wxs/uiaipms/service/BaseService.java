package cn.edu.cdu.wxs.uiaipms.service;

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
     * 根据ID获取
     * @param idCol ID的数据库字段名
     * @param id ID
     * @return 实体
     */
    T getById(String idCol, int id);

    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @param idCol ID列字段名
     * @return 用户
     */
    T getByUsername(String username, String idCol);

}
