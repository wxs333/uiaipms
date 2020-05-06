package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.CompanyForm;
import cn.edu.cdu.wxs.uiaipms.form.RealmFrom;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 企业的服务层
 *
 * @author WXS
 * @date 2020/1/13
 */
public interface CompanyService extends BaseService<CompanyForm> {
    /**
     * 根据用户名获取密码和状态
     *
     * @param username 用户名
     * @return 密码
     */
    RealmFrom getPasswordByUsername(String username);

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return 用户
     */
    CompanyForm getByUsername(String username);

    /**
     * 分页获取所有信息
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<CompanyForm> getAllInfo(Page<CompanyForm> page);

    /**
     * 根据ID获取
     *
     * @param id ID
     * @return json
     */
    CompanyForm getOne(String id);

    /**
     * 修改
     *
     * @param form 表单
     * @return true 成功 false 失败
     */
    boolean update(CompanyForm form);

    /**
     * 获取所有企业
     *
     * @return 集合
     */
    List<CompanyForm> getAll();

    /**
     * 分页获取未注册的账号信息
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<CompanyForm> getNotRegister(Page<CompanyForm> page);

    /**
     * 申请历史记录
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<CompanyForm> getByPage(Page<CompanyForm> page);

    /**
     * 企业注册信息导出数据
     *
     * @return 集合
     */
    List<CompanyForm> exportData();


    /**
     * 判断企业名或者账号是否存在
     *
     * @param comName  企业名
     * @param username 账号
     * @return true 存在 false 不存在
     */
    boolean isExistComNameAndUsername(String comName, String username);

}
