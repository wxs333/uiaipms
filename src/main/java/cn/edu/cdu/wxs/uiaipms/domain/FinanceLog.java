package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 财务记录
 *
 * @author WXS
 */
@Setter
@Getter
public class FinanceLog {
    /**
     * ID
     */
    private Integer finId;

    /**
     * 管理员
     */
    private Integer adminId;

    /**
     * 申请人
     */
    private Integer userId;

    /**
     * 金额
     */
    private Long finAmount;

    /**
     * 申请原因
     */
    private String finReason;

    /**
     * 项目
     */
    private Integer proId;

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