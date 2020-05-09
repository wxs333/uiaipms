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
 *    项目成果
 * </p>
 *
 * @author WXS
 * @since 2020-05-08
 */
@Getter
@Setter
@TableName("project_result")
public class ProjectResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "pr_id", type = IdType.INPUT)
    private String prId;

    /**
     * 项目id
     */
    @TableField("pro_id")
    private String proId;

    /**
     * 结题人id
     */
    @TableField("tutor_id")
    private String tutorId;

    /**
     * 是否成功结题，0 成功 1 失败
     */
    @TableField("success")
    private Integer success;

    /**
     * 结题说明
     */
    @TableField("reason")
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
    private LocalDateTime createTime;

    /**
     * 逻辑删除字段
     */
    @TableField("logic_delete_flag")
    private Integer logicDeleteFlag;

}
