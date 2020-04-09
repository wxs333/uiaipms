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
     * 是否立项 0 是 1否 默认 1
     */
    @TableField("lx_flag")
    @Excel(name = "是否立项", orderNum = "6", replace = {"已立项_0", "未立项_1"}, width = 30)
    private Integer lxFlag;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @Excel(name = "立项时间", orderNum = "8", width = 30)
    private LocalDateTime updateTime;

    /**
     * 逻辑删除 0 可用 1 逻辑删除
     */
    @TableField("logic_delete_flag")
    private Integer logicDeleteFlag;

}
