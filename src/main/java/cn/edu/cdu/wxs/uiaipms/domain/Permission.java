package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 允许的操作
 *
 * @author WXS
 */
@Setter
@Getter
public class Permission {
    /**
     * id
     */
    private Integer perId;

    /**
     * 权限的名称
     */
    private String perName;

    /**
     * 编码
     */
    private String perCode;

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