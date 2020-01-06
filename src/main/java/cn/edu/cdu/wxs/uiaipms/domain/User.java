package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 所有用户的抽象父类
 *
 * @author WXS
 * @date 2019/12/24
 */
@Getter
@Setter
public class User extends LogicDeleteEntity {
    /**
     * id
     */
    private Integer id;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 角色
     */
    private Integer role;
    /**
     * 手机号
     */
    private String phone;

}
