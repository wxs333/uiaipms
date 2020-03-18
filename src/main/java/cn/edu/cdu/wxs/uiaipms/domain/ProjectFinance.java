package cn.edu.cdu.wxs.uiaipms.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 项目拨款财务记录
 * </p>
 *
 * @author WXS
 * @since 2020-03-17
 */
@Setter
@Getter
@TableName("project_finance")
public class ProjectFinance implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "pf_id", type = IdType.INPUT)
    private String pfId;

    /**
     * 处理人
     */
    @TableField("admin_id")
    private String adminId;

    /**
     * 申请人
     */
    @TableField("user_id")
    private String userId;

    /**
     * 金额
     */
    @TableField("pf_amount")
    @Excel(name = "申请金额", orderNum = "2")
    private BigDecimal pfAmount;

    /**
     * 申请原因
     */
    @TableField("apply_reason")
    @Excel(name = "申请理由", orderNum = "3", width = 30)
    private String applyReason;

    /**
     * 项目
     */
    @TableField("pro_id")
    private String proId;

    /**
     * 是否处理 0 已处理 1未处理 默认 1
     */
    @TableField("deal")
    private String deal;
    /**
     * 是否同意 0 同意 1 不同意 默认 1
     */
    @TableField("agree")
    @Excel(name = "处理结果", orderNum = "6", replace = {"同意_0", "驳回_1"})
    private String agree;
    /**
     * 同意与否的原因
     */
    @TableField("review_reason")
    @Excel(name = "理由", orderNum = "7", width = 30)
    private String reviewReason;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @Excel(name = "处理时间", orderNum = "8", width = 22, exportFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @Excel(name = "申请时间", orderNum = "4", width = 22, exportFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 逻辑删除字段
     */
    @TableField("logic_delete_flag")
    private Integer logicDeleteFlag;

}
