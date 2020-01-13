package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

/**
 * 导师
 *
 * @author WXS
 * @date 2020/1/10
 */
@Getter
@Setter
public class Tutor {
    /**
     * id
     */
    private Integer tutorId;
    /**
     * 姓名
     */
    private String tutorName;
    /**
     * 登录名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 学院ID
     */
    private Integer facultyId;
    /**
     * 角色
     */
    private Set<Role> roles;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 逻辑删除字段
     */
    private Integer logicDeleteFlag;
}
