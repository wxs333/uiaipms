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
 * 用户的角色
 * </p>
 *
 * @author WXS
 * @since 2020-02-10
 */
@Getter
@Setter
@TableName("user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "ur_id", type = IdType.INPUT)
    private String urId;

    /**
     * 角色
     */
    @TableField(value = "role_id",jdbcType = JdbcType.VARCHAR)
    private String roleId;

    /**
     * 用户
     */
    @TableField(value = "user_id",jdbcType = JdbcType.VARCHAR)
    private String userId;

    /**
     * 用户类型
     */
    @TableField(value = "ur_who",jdbcType = JdbcType.INTEGER)
    private Integer urWho;

    /**
     * 更新时间
     */
    @TableField(value = "update_time",jdbcType = JdbcType.TIMESTAMP)
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",jdbcType = JdbcType.TIMESTAMP)
    private LocalDateTime createTime;

    /**
     * 逻辑删除字段
     */
    @TableField(value = "logic_delete_flag",jdbcType = JdbcType.INTEGER)
    private Integer logicDeleteFlag;


}
