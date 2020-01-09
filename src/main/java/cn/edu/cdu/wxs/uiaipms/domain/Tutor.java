package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 导师
 *
 * @author WXS
 */
@Setter
@Getter
public class Tutor {
    /**
     * id
     */
    private Integer tutorId;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 登录名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 学院ID
     */
    private Integer facId;

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