package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 企业用户
 *
 * @author WXS
 * @date 2020/1/10
 */
@Getter
@Setter
public class Company {
    /**
     * ID
     */
    private String comId;
    /**
     * 企业名称
     */
    private String comName;
    /**
     * 负责人
     */
    private String comPeople;
    /**
     * 登录名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 联系方式
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
