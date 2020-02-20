package cn.edu.cdu.wxs.uiaipms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 财务记录
 * </p>
 *
 * @author WXS
 * @since 2020-02-10
 */
@Getter
@Setter
@TableName("finance_log")
public class FinanceLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "fin_id", type = IdType.INPUT)
    private String finId;

    /**
     * 管理员
     */
    @TableField(value = "admin_id", jdbcType = JdbcType.VARCHAR)
    private String adminId;

    /**
     * 申请人
     */
    @TableField(value = "user_id", jdbcType = JdbcType.VARCHAR)
    private String userId;

    /**
     * 金额
     */
    @TableField(value = "fin_amount", jdbcType = JdbcType.DECIMAL)
    private BigDecimal finAmount;

    /**
     * 申请原因
     */
    @TableField(value = "fin_reason", jdbcType = JdbcType.VARCHAR)
    private String finReason;

    /**
     * 项目
     */
    @TableField(value = "pro_id", jdbcType = JdbcType.VARCHAR)
    private String proId;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", jdbcType = JdbcType.TIMESTAMP)
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", jdbcType = JdbcType.TIMESTAMP)
    private LocalDateTime createTime;

    /**
     * 逻辑删除字段
     */
    @TableField(value = "logic_delete_flag", jdbcType = JdbcType.INTEGER)
    private Integer logicDeleteFlag;


}
