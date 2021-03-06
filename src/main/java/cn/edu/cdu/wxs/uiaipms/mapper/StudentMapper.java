package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.StudentForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * StudentMapper interface
 *
 * @author WXS
 * @date 2020/1/11
 */
@Mapper
public interface StudentMapper extends CommonMapper<StudentForm> {
    /**
     * 分页获取学生ID，姓名，用户名
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<StudentForm> selectAll(Page<StudentForm> page);

    /**
     * 分页获取所有信息
     *
     * @param page 分页
     * @return 分页集合
     */
    IPage<StudentForm> selectAllInfo(Page<StudentForm> page);

    /**
     * 根据ID查询学生
     *
     * @param id ID
     * @return 学生
     */
    StudentForm selectOneById(@Param("id") String id);
}
