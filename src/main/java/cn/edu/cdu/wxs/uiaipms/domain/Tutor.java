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
 * 导师
 * </p>
 *
 * @author WXS
 * @since 2020-04-05
 */
@Getter
@Setter
@TableName("tutor")
public class Tutor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "tutor_id", type = IdType.INPUT)
    private String tutorId;

    /**
     * 导师姓名
     */
    @TableField("tutor_name")
    private String tutorName;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 账号
     */
    @TableField("username")
    private String username;

    /**
     * 学院id
     */
    @TableField("faculty_id")
    private String facultyId;

    /**
     * 0 启用 1 禁用
     */
    @TableField("ban")
    private Integer ban;

    /**
     * 照片地址
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
