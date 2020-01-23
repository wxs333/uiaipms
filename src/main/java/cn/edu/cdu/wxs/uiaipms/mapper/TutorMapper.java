package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.domain.Tutor;
import cn.edu.cdu.wxs.uiaipms.form.TutorForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 导师的数据层
 * @author WXS
 * @date 2020/1/13
 */
@Mapper
public interface TutorMapper extends CommonMapper<Tutor> {
    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @return 用户
     */
    TutorForm getByUsername(@Param("username") String username);

    /**
     * 分页查询所有导师信息
     * @param page 分页
     * @return 分页集合
     */
    IPage<TutorForm> selectAll(Page<TutorForm> page);

    /**
     * 分页获取所有信息
     * @param page 分页
     * @return 分页集合
     */
    IPage<TutorForm> selectAllInfo(Page<TutorForm> page);
}
