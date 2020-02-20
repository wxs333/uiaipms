package cn.edu.cdu.wxs.uiaipms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 库存出入库记录
 * </p>
 *
 * @author WXS
 * @since 2020-02-10
 */
@Getter
@Setter
public class StockLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "sto_id", type = IdType.INPUT)
    private String stoId;

    /**
     * 管理员
     */
    @TableField(value = "admin_id",jdbcType = JdbcType.VARCHAR)
    private String adminId;

    /**
     * 类型
     */
    @TableField(value = "sto_type", jdbcType = JdbcType.VARCHAR)
    private String stoType;

    /**
     * 货物
     */
    @TableField(value = "goods_id", jdbcType = JdbcType.VARCHAR)
    private String goodsId;

    /**
     * 数量
     */
    @TableField(value = "goods_num",jdbcType = JdbcType.INTEGER)
    private Integer goodsNum;

    /**
     * 工作室
     */
    @TableField(value = "stud_id", jdbcType = JdbcType.VARCHAR)
    private String studId;

    /**
     * 更新时间
     */
    @TableField(value = "update_time",jdbcType = JdbcType.TIMESTAMP)
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",jdbcType = JdbcType.TIMESTAMP)
    private LocalDateTime createTime;

    /**
     * 逻辑删除字段
     */
    @TableField(value = "logic_delete_flag",jdbcType = JdbcType.INTEGER)
    private Integer logicDeleteFlag;


}
