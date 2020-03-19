package cn.edu.cdu.wxs.uiaipms.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
    @Excel(name = "审核理由", orderNum = "2", width = 30)
    private String reason;
    /**
     * 是否立项 0 是 1 否，默认 1
     */
    @TableField("lx")
    @Excel(name = "立项", orderNum = "4", replace = {"已立项_0", "未立项_1"})
    private String lx;

    /**
     * 立项时间
     */
    @TableField("lx_time")
    @Excel(name = "立项时间", orderNum = "5", width = 22, format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lxTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @Excel(name = "审核时间", orderNum = "3", width = 22, format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 逻辑删除 0 可用 1 逻辑删除
     */
    @TableField("logic_delete_flag")
    private Integer logicDeleteFlag;

}
