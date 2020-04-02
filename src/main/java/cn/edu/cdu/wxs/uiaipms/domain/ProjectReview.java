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
     * 项目id
     */
    @TableField("pro_id")
    private String proId;

    /**
     * 是否通过审核 0 通过 1 未通过， 默认 1
     */
    @TableField("pass_flag")
    private Integer passFlag;

    /**
     * 审核意见
     */
    @TableField("reason")
    @Excel(name = "审核理由", orderNum = "2", width = 30)
    private String reason;

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
