package cn.edu.cdu.wxs.uiaipms.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
 * 工作室
 * </p>
 *
 * @author WXS
 * @since 2020-02-10
 */
@Getter
@Setter
@TableName("studio")
public class Studio implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "stud_id", type = IdType.INPUT)
    private String studId;

    /**
     * 地址
     */
    @TableField(value = "stud_address",jdbcType = JdbcType.VARCHAR)
    @Excel(name = "地址")
    private String studAddress;

    /**
     * 房间号
     */
    @TableField(value = "stud_room_no",jdbcType = JdbcType.VARCHAR)
    @Excel(name = "房间号")
    private String studRoomNo;

    /**
     * 占地面积
     */
    @TableField(value = "stud_area",jdbcType = JdbcType.FLOAT)
    @Excel(name = "占地面积(m^2)")
    private Float studArea;

    /**
     * 所属企业ID
     */
    @TableField(value = "com_id",jdbcType = JdbcType.VARCHAR)
    private String comId;

    /**
     * 人数
     */
    @TableField(value = "stud_num",jdbcType = JdbcType.INTEGER)
    @Excel(name = "人数")
    private Integer studNum;
    /**
     * 是否禁用，0 禁用 1 启用
     */
    @TableField(value = "ban",jdbcType = JdbcType.INTEGER)
    @Excel(name = "禁用", replace = {"禁用_0","可用_1"})
    private Integer ban;

    /**
     * 更新时间
     */
    @TableField(value = "update_time",jdbcType = JdbcType.TIMESTAMP)
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", jdbcType = JdbcType.TIMESTAMP)
    private LocalDateTime createTime;

    /**
     * 逻辑删除字段
     */
    @TableField(value = "logic_delete_flag",jdbcType = JdbcType.INTEGER)
    private Integer logicDeleteFlag;


}
