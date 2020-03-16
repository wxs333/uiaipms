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
 * 项目审核表
 * </p>
 *
 * @author WXS
 * @since 2020-03-13
 */
@Setter
@Getter
@TableName("project_review")
public class ProjectReview implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "pr_id", type = IdType.INPUT)
    private String prId;

    /**
     * 审核人id
     */
    @TableField("tutor_id")
    private String tutorId;

    /**
     * 项目审批记录id
     */
    @TableField("pa_id")
    private String paId;

    /**
     * 是否通过审核 0 通过 1 未通过
     */
    @TableField("review")
    private Integer review;

    /**
     * 审核意见
     */
    @TableField("reason")
    private String reason;
    /**
     * 是否立项 0 是 1 否，默认 1
     */
    @TableField("starting")
    private String starting;

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
     * 逻辑删除 0 可用 1 逻辑删除
     */
    @TableField("logic_delete_flag")
    private Integer logicDeleteFlag;

}
