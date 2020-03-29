package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.TutorForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 导师的服务层
 *
 * @author WXS
 * @date 2020/1/13
 */
public interface TutorService extends BaseService<TutorForm> {
    /**
     * 根据用户名获取密码
     *
     * @param username 用户名
     * @return 密码
     */
    String getPasswordByUsername(String username);

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return 用户
     */
    TutorForm getByUsername(String username);

    /**
     * 分页获取所有导师信息
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<TutorForm> getAllByPage(Page<TutorForm> page);

    /**
     * 获取所有
     *
     * @param page 分页
     * @return 集合
     */
    IPage<TutorForm> getAllToList(Page<TutorForm> page);

    /**
     * 根据ID获取
     *
     * @param id id
     * @return 数据
     */
    TutorForm getOneById(String id);

    /**
     * 修改信息
     *
     * @param form 表单
     * @return true 成功 false 失败
     */
    boolean update(TutorForm form);

    /**
     * 跟id获取学院id
     *
     * @param id 导师id
     * @return 学院id
     */
    String getFacIdById(String id);
}
