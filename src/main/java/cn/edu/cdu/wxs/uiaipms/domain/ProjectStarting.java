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
 * 项目立项表
 * </p>
 *
 * @author WXS
 * @since 2020-03-13
 */
@Setter
@Getter
@TableName("project_starting")
public class ProjectStarting implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "ps_id", type = IdType.INPUT)
    private String psId;

    /**
     * 立项人id
     */
    @TableField("tutor_id")
    private String tutorId;

    /**
     * 项目id
     */
    @TableField("pro_id")
    private String proId;

    /**
     * 开始资金
     */
    @TableField("money")
    private BigDecimal money;

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
     * 逻辑删除 0 可用 1 逻辑删除
     */
    @TableField("logic_delete_flag")
    private Integer logicDeleteFlag;

}
