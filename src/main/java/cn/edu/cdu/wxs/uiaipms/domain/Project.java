package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 项目
 *
 * @author WXS
 */
@Setter
@Getter
public class Project {
    /**
     * id
     */
    private Integer proId;

    /**
     * 名称
     */
    private String proName;

    /**
     * 申请学生ID
     */
    private Integer stuId;

    /**
     * 项目材料路径
     */
    private String proLocation;

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