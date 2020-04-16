package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.RealmFrom;
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
     *
     * @param id        ID
     * @param tableName 表名
     * @param idCol     id列字段名
     * @return 影响行数
     */
    int logicDeleteById(@Param("id") int id, @Param("tableName") String tableName, @Param("idCol") String idCol);

    /**
     * 根据用户名查询密码和状态
     *
     * @param username  用户名
     * @param tableName 表名
     * @return 密码
     */
    RealmFrom selectPasswordByUsername(@Param("username") String username, @Param("tableName") String tableName);

    /**
     * 根据用户名获取ID
     *
     * @param username  用户名
     * @param tableName 表名
     * @param idCol     ID列名
     * @return ID
     */
    String getIdByUsername(@Param("username") String username, @Param("tableName") String tableName, @Param("idCol") String idCol);

}
