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
 * 学生
 * </p>
 *
 * @author WXS
 * @since 2020-02-10
 */
@Getter
@Setter
@TableName("student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "stu_id", type = IdType.INPUT)
    private String stuId;

    /**
     * 姓名
     */
    @TableField(value = "stu_name",jdbcType = JdbcType.VARCHAR)
    private String stuName;

    /**
     * 学号
     */
    @TableField(value = "stu_no", jdbcType = JdbcType.VARCHAR)
    private String stuNo;

    /**
     * 银行卡号
     */
    @TableField(value = "bank_card", jdbcType = JdbcType.VARCHAR)
    private String bankCard;

    /**
     * 联系地址
     */
    @TableField(value = "address",jdbcType = JdbcType.VARCHAR)
    private String address;

    /**
     * 登录名
     */
    @TableField(value = "username",jdbcType = JdbcType.VARCHAR)
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password",jdbcType = JdbcType.VARCHAR)
    private String password;

    /**
     * 手机号
     */
    @TableField(value = "phone",jdbcType = JdbcType.VARCHAR)
    private String phone;

    /**
     * 班级
     */
    @TableField(value = "clazz_id",jdbcType = JdbcType.VARCHAR)
    private String clazzId;

    /**
     * 图片路径
     */
    @TableField(value = "image",jdbcType = JdbcType.VARCHAR)
    private String image;

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
