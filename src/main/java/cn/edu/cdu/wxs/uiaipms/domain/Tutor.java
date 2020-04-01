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
 * 导师
 * </p>
 *
 * @author WXS
 * @since 2020-02-10
 */
@Getter
@Setter
@TableName("tutor")
public class Tutor implements Serializable {
    /**
     * id
     */
    @TableId(value = "tutor_id", type = IdType.INPUT)
    private String tutorId;
    /**
     * 导师姓名
     */
    @TableField(value = "tutor_name", jdbcType = JdbcType.VARCHAR)
    private String tutorName;
    /**
     * 手机号
     */
    @TableField(value = "phone", jdbcType = JdbcType.VARCHAR)
    private String phone;
    /**
     * 密码
     */
    @TableField(value = "password", jdbcType = JdbcType.VARCHAR)
    private String password;
    /**
     * 账号
     */
    @TableField(value = "username", jdbcType = JdbcType.VARCHAR)
    private String username;
    /**
     * 学院id
     */
    @TableField(value = "faculty_id", jdbcType = JdbcType.VARCHAR)
    private String facultyId;
    /**
     * 照片地址
     */
    @TableField(value = "image", jdbcType = JdbcType.VARCHAR)
    private String image;
    /**
     * 0 启用 1 禁用
     */
    @TableField(value = "ban", jdbcType = JdbcType.INTEGER)
    private Integer ban;
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
