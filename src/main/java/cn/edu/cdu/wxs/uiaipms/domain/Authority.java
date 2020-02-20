package cn.edu.cdu.wxs.uiaipms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 角色所拥有的权限
 * </p>
 *
 * @author WXS
 * @since 2020-02-10
 */
@Getter
@Setter
@TableName("authority")
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "auth_id", type = IdType.INPUT)
    private String authId;

    /**
     * 角色id
     */
    @TableField(value = "role_id", jdbcType = JdbcType.VARCHAR)
    private String roleId;

    /**
     * 权限ID
     */
    @TableField(value = "per_id", jdbcType = JdbcType.VARCHAR)
    private String perId;

    /**
     * 权限的描述
     */
    @TableField(value = "auth_desc", jdbcType = JdbcType.VARCHAR)
    private String authDesc;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", jdbcType = JdbcType.TIMESTAMP)
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", jdbcType = JdbcType.TIMESTAMP)
    private LocalDateTime createTime;

    /**
     * 逻辑删除字段
     */
    @TableField(value = "logic_delete_flag", jdbcType = JdbcType.INTEGER)
    private Integer logicDeleteFlag;


}
