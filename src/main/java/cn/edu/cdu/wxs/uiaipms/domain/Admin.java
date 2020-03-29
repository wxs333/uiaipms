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
 * 管理员
 *
 * @author WXS
 * @date 2020/1/10
 */
@Getter
@Setter
@TableName("admin")
public class Admin implements Serializable {
    /**
     * id
     */
    @TableId(value = "admin_id", type = IdType.INPUT)
    private String adminId;
    /**
     * 姓名
     */
    @TableField(value = "admin_name", jdbcType = JdbcType.VARCHAR)
    private String adminName;
    /**
     * 登录名
     */
    @TableField(value = "username", jdbcType = JdbcType.VARCHAR)
    private String username;
    /**
     * 密码
     */
    @TableField(value = "password", jdbcType = JdbcType.VARCHAR)
    private String password;
    /**
     * 手机号
     */
    @TableField(value = "phone", jdbcType = JdbcType.VARCHAR)
    private String phone;
    /**
     * 照片地址
     */
    @TableField(value = "image", jdbcType = JdbcType.VARCHAR)
    private String image;
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
