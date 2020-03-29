package cn.edu.cdu.wxs.uiaipms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 项目审批记录
 * </p>
 *
 * @author WXS
 * @since 2020-02-10
 */
@Getter
@Setter
@TableName("project_approval")
public class ProjectApproval implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "pa_id", type = IdType.INPUT)
    private String paId;

    /**
     * 项目ID
     */
    @TableField(value = "pro_id", jdbcType = JdbcType.VARCHAR)
    private String proId;

    /**
     * 审批导师ID
     */
    @TableField(value = "tutor_id", jdbcType = JdbcType.VARCHAR)
    private String tutorId;

    /**
     * 是否通过标记
     */
    @TableField(value = "approval_flag", jdbcType = JdbcType.INTEGER)
    private Integer approvalFlag;

    /**
     * 原因
     */
    @TableField(value = "reason", jdbcType = JdbcType.VARCHAR)
    private String reason;

    /**
     * 是否审核 0 未审核 1 已审核，默认 0
     */
    @TableField(value = "review")
    private Integer review;

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
