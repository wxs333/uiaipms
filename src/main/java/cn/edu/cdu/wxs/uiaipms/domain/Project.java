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
 * 项目
 * </p>
 *
 * @author WXS
 * @since 2020-02-10
 */
@Getter
@Setter
@TableName("project")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "pro_id", type = IdType.INPUT)
    private String proId;

    /**
     * 名称
     */
    @TableField(value = "pro_name", jdbcType = JdbcType.VARCHAR)
    private String proName;

    /**
     * 申请学生ID
     */
    @TableField(value = "stu_id", jdbcType = JdbcType.VARCHAR)
    private String stuId;

    /**
     * 项目材料路径
     */
    @TableField(value = "pro_location", jdbcType = JdbcType.VARCHAR)
    private String proLocation;
    /**
     * 本地文件名
     */
    @TableField(value = "word_name", jdbcType = JdbcType.VARCHAR)
    private String wordName;
    /**
     * 项目描述
     */
    @TableField(value = "pro_desc", jdbcType = JdbcType.VARCHAR)
    private String proDesc;

    /**
     * 是否成功结题 0 成功 1失败
     */
    @TableField("success")
    private String success;

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
