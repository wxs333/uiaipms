package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.form.StudentForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * 学生的服务层
 *
 * @author WXS
 * @date 2020/1/11
 */
public interface StudentService extends BaseService<StudentForm> {
    /**
     * 根据用户名获取密码
     * @param username 用户名
     * @return 密码
     */
    String getPasswordByUsername(String username);

    /**
     * 注册学生
     * @param form 表单
     * @return true 成功 false 失败
     */
    boolean register(StudentForm form);

    /**
     * 根据用户名或学号查询学生是否存在
     * @param username 用户名
     * @param stuNo 学号
     * @return true 存在 false 不存在
     */
    boolean isExistByUsernameOrStuNo(String username, String stuNo);

    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @return 学生
     */
    StudentForm getByUsername(String username);

    /**
     * 分页获取所有
     * @param page 分页
     * @return 分有集合
     */
    IPage<StudentForm> getAll(Page<StudentForm> page);

    /**
     * 分页获取所有信息
     * @param page 分页
     * @return 分页集合
     */
    IPage<StudentForm> getAllToList(Page<StudentForm> page);

    /**
     * 根据ID获取学生
     * @param id ID
     * @return 学生
     */
    StudentForm getOneById(String id);

    /**
     * 修改
     * @param form 表单
     * @return true 成功 false 失败
     */
    boolean update(StudentForm form);

    /**
     * 头像上传
     * @param multipartFile 头像
     * @param dir 本地路径
     * @return 消息
     */
    String imgUpload(MultipartFile multipartFile, String dir);

    /**
     * 修改信息，带头像
     * @param form 表单
     * @return true 成功 false 失败
     */
    boolean updateInfo(StudentForm form);

    /**
     * 获取学生基本信息
     * @param stuId ID
     * @return 实体
     */
    StudentForm getInfo(String stuId);
}
