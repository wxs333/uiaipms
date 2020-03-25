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
 * 采购资金申请
 * </p>
 *
 * @author WXS
 * @since 2020-03-19
 */
@Getter
@Setter
@TableName("buy_funds_apply")
public class BuyFundsApply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "bfa_id", type = IdType.INPUT)
    private String bfaId;

    /**
     * 处理人id
     */
    @TableField("deal_user_id")
    private String dealUserId;

    /**
     * 是否处理 0 已处理 1 没处理 默认 1
     */
    @TableField("deal")
    private Integer deal;

    /**
     * 是否同意 0 同意 1 不同意 默认 1
     */
    @TableField("bfa_agree")
    @Excel(name = "是否同意", orderNum = "4", replace = {"是_0","否_1"})
    private Integer bfaAgree;

    /**
     * 处理结果说明
     */
    @TableField("bfa_reason")
    private String bfaReason;

    /**
     * 申请人id
     */
    @TableField("apply_user_id")
    private String applyUserId;

    /**
     * 申请理由
     */
    @TableField("apply_reason")
    private String applyReason;

    /**
     * 申请金额
     */
    @TableField("apply_mount")
    @Excel(name = "申请金额(单位：元)", orderNum = "1", width = 18)
    private BigDecimal applyMount;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @Excel(name = "申请时间", orderNum = "2", width = 22)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @Excel(name = "处理时间", orderNum = "5", width = 22)
    private LocalDateTime updateTime;

    /**
     * 逻辑删除字段
     */
    @TableField("logic_delete_flag")
    private Integer logicDeleteFlag;


    public static final String BFA_ID = "bfa_id";

    public static final String DEAL_USER_ID = "deal_user_id";

    public static final String DEAL = "deal";

    public static final String BFA_AGREE = "bfa_agree";

    public static final String BFA_REASON = "bfa_reason";

    public static final String APPLY_USER_ID = "apply_user_id";

    public static final String APPLY_REASON = "apply_reason";

    public static final String APPLY_MOUNT = "apply_mount";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String LOGIC_DELETE_FLAG = "logic_delete_flag";

}
