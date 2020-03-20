package cn.edu.cdu.wxs.uiaipms.domain;

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
 * 采购报销
 * </p>
 *
 * @author WXS
 * @since 2020-03-19
 */
@Setter
@Getter
@TableName("buy_wipe_out")
public class BuyWipeOut implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "bwo_id", type = IdType.INPUT)
    private String bwoId;

    /**
     * 处理人id
     */
    @TableField("deal_user_id")
    private String dealUserId;

    /**
     * 处理结果说明
     */
    @TableField("bwo_reason")
    private String bwoReason;

    /**
     * 报销金额
     */
    @TableField("bwo_amount")
    private BigDecimal bwoAmount;

    /**
     * 报销人id
     */
    @TableField("bwo_user_id")
    private String bwoUserId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 逻辑删除字段
     */
    @TableField("logic_delete_flag")
    private Integer logicDeleteFlag;


    public static final String BWO_ID = "bwo_id";

    public static final String DEAL_USER_ID = "deal_user_id";

    public static final String BWO_REASON = "bwo_reason";

    public static final String BWO_AMOUNT = "bwo_amount";

    public static final String BWO_USER_ID = "bwo_user_id";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String LOGIC_DELETE_FLAG = "logic_delete_flag";

}
