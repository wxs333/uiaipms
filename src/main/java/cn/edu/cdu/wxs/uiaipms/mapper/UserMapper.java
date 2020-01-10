package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * UserMapper interface
 *
 * @author WXS
 * @date 2020/1/10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据ID进行逻辑删除
     * @param id ID
     * @return 影响行数
     */
    int deleteByStuId(@Param("id") int id);

    /**
     * 根据用户名获取密码
     * @param username
     * @return
     */
    String selectPasswordByUsername(@Param("username") String username);
}
