package cn.edu.cdu.wxs.uiaipms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 物品
 * </p>
 *
 * @author WXS
 * @since 2020-02-10
 */
@Getter
@Setter
@TableName("goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "goods_id", type = IdType.INPUT)
    private String goodsId;

    /**
     * 名称
     */
    @TableField(value = "goods_name", jdbcType = JdbcType.VARCHAR)
    private String goodsName;

    /**
     * 数量
     */
    @TableField(value = "goods_num", jdbcType = JdbcType.INTEGER)
    private Integer goodsNum;

    /**
     * 单位
     */
    @TableField(value = "unit_id", jdbcType = JdbcType.VARCHAR)
    private String unitId;

    /**
     * 型号
     */
    @TableField(value = "goods_model", jdbcType = JdbcType.VARCHAR)
    private String goodsModel;

    /**
     * 单价
     */
    @TableField(value = "goods_price", jdbcType = JdbcType.DECIMAL)
    private BigDecimal goodsPrice;

    /**
     * 品牌
     */
    @TableField(value = "goods_brand", jdbcType = JdbcType.VARCHAR)
    private String goodsBrand;

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
