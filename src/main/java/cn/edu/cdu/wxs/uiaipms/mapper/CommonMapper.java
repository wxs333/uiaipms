package cn.edu.cdu.wxs.uiaipms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 公共的mapper，实现一些通用的操作
 *
 * @author WXS
 * @date 2020/1/11
 */
public interface CommonMapper<T> extends BaseMapper<T> {

    /**
     * 逻辑删除
     * @param id ID
     * @param tableName 表名
     * @param idCol id列字段名
     * @return 影响行数
     */
    int logicDeleteById(@Param("id") int id, @Param("tableName") String tableName, @Param("idCol") String idCol);

    /**
     * 根据用户名查询密码
     * @param username 用户名
     * @param tableName 表名
     * @return 密码
     */
    String selectPasswordByUsername(@Param("username") String username, @Param("tableName") String tableName);

}
