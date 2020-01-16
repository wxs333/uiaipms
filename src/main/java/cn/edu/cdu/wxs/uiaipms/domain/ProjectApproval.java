package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 项目审批记录
 *
 * @author WXS
 */
@Setter
@Getter
public class ProjectApproval {
    /**
     * id
     */
    private String paId;

    /**
     * 项目ID
     */
    private String proId;

    /**
     * 审批导师ID
     */
    private String tutorId;

    /**
     * 是否通过标记
     */
    private Integer approvalFlag;

    /**
     * 原因
     */
    private String reason;

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