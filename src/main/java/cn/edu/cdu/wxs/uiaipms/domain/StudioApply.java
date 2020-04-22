package cn.edu.cdu.wxs.uiaipms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *  工作室申请记录
 * </p>
 *
 * @author WXS
 * @since 2020-04-22
 */
@Getter
@Setter
@TableName("studio_apply")
public class StudioApply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "sa_id", type = IdType.INPUT)
    private String saId;

    /**
     * 工作室id
     */
    @TableField(value = "stud_id")
    private String studId;

    /**
     * 申请企业d
     */
    @TableField("apply_com_id")
    private String applyComId;

    /**
     * 处理人id
     */
    @TableField("deal_user_id")
    private String dealUserId;

    /**
     * 申请理由
     */
    @TableField("apply_reason")
    private String applyReason;

    /**
     * 处理结果说明
     */
    @TableField("sa_reason")
    private String saReason;

    /**
     * 处理结果 0 同意 1不同意 默认1
     */
    @TableField("agree")
    private Integer agree;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 逻辑删除字段
     */
    @TableField("logic_delete_flag")
    private Integer logicDeleteFlag;

}
