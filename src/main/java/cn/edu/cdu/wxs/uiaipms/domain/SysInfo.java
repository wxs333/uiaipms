package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 系统信息
 *
 * @author WXS
 */
@Setter
@Getter
public class SysInfo {
    /**
     * ID
     */
    private String sysId;

    /**
     * 名称
     */
    private String sysParam;

    /**
     * 数量
     */
    private Float sysConut;

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