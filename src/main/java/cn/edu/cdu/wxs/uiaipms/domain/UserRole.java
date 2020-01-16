package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 用户角色中间表
 * @author WXS
 * @date 2020/1/13
 */
@Getter
@Setter
@ToString
public class UserRole {
    /**
     * ID
     */
    private String urId;
    /**
     * 角色ID
     */
    private String roleId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户类型
     */
    private Integer urWho;
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
