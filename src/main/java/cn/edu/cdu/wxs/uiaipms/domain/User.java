package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 用户
 *
 * @author WXS
 * @date 2020/1/10
 */
@Getter
@Setter
public class User {
    /**
     * id
     */
    private Integer userId;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 学号
     */
    private String no;
    /**
     * 银行卡号
     */
    private String bankCard;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 登录名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 班级
     */
    private Integer clazzId;
    /**
     * 手机号
     */
    private String phone;
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
