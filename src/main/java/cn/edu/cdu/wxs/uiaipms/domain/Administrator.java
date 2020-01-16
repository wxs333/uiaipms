package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

/**
 * 管理员
 *
 * @author WXS
 */
@Getter
@Setter
public class Administrator {
    /**
     * id
     */
    private String adminId;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 登录名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

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

    /**
     * 角色
     */
    private Set<Role> roles;

}