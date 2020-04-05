package cn.edu.cdu.wxs.uiaipms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 学生
 * </p>
 *
 * @author WXS
 * @since 2020-04-05
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
    @TableField("stu_name")
    private String stuName;

    /**
     * 学号
     */
    @TableField("stu_no")
    private String stuNo;

    /**
     * 联系地址
     */
    @TableField("address")
    private String address;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 登录名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 班级
     */
    @TableField("clazz_id")
    private String clazzId;

    /**
     * 0 启用 1 禁用
     */
    @TableField("ban")
    private Integer ban;

    /**
     * 照片路径
     */
    @TableField("image")
    private String image;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 逻辑删除字段
     */
    @TableField("logic_delete_flag")
    private Integer logicDeleteFlag;

}
