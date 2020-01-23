package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.domain.Tutor;
import cn.edu.cdu.wxs.uiaipms.form.TutorForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 导师的服务层
 * @author WXS
 * @date 2020/1/13
 */
public interface TutorService extends BaseService<Tutor> {
    /**
     * 根据用户名获取密码
     * @param username 用户名
     * @return 密码
     */
    String getPasswordByUsername(String username);

    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @return 用户
     */
    TutorForm getByUsername(String username);

    /**
     * 分页获取所有导师信息
     * @param page 分页
     * @return 分页集合
     */
    IPage<TutorForm> getAllByPage(Page<TutorForm> page);

    /**
     * 获取所有
     * @param page 分页
     * @return 集合
     */
    IPage<TutorForm> getAllToList(Page<TutorForm> page);
}
