package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 学生
 *
 * @author WXS
 * @date 2020/1/10
 */
@Getter
@Setter
public class Student {
    /**
     * id
     */
    private String stuId;
    /**
     * 姓名
     */
    private String stuName;
    /**
     * 学号
     */
    private String stuNo;
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
