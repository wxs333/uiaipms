package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

/**
 * 角色
 *
 * @author WXS
 */
@Setter
@Getter
public class Role {
    /**
     * id
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 编码
     */
    private String roleCode;

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
     * 权限
     */
    private Set<String> permission;
}