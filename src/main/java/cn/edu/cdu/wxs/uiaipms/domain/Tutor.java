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

    private static final long serialVersionUID = 1L;

    @TableId(value = "tutor_id", type = IdType.INPUT)
    private String tutorId;

    @TableField(value = "tutor_name",jdbcType = JdbcType.VARCHAR)
    private String tutorName;

    @TableField(value = "phone",jdbcType = JdbcType.VARCHAR)
    private String phone;

    @TableField(value = "password",jdbcType = JdbcType.VARCHAR)
    private String password;

    @TableField(value = "username",jdbcType = JdbcType.VARCHAR)
    private String username;

    @TableField(value = "faculty_id",jdbcType = JdbcType.VARCHAR)
    private String facultyId;

    @TableField(value = "update_time",jdbcType = JdbcType.TIMESTAMP)
    private LocalDateTime updateTime;

    @TableField(value = "create_time",jdbcType = JdbcType.TIMESTAMP)
    private LocalDateTime createTime;

    @TableField(value = "logic_delete_flag",jdbcType = JdbcType.INTEGER)
    private Integer logicDeleteFlag;


}
