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
    @Excel(name = "名称")
    private String goodsName;

    /**
     * 数量
     */
    @TableField(value = "goods_num", jdbcType = JdbcType.INTEGER)
    @Excel(name = "数量", orderNum = "4")
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
    @Excel(name = "型号", orderNum = "2")
    private String goodsModel;

    /**
     * 单价
     */
    @TableField(value = "goods_price", jdbcType = JdbcType.DECIMAL)
    @Excel(name = "单价", orderNum = "3")
    private BigDecimal goodsPrice;

    /**
     * 品牌
     */
    @TableField(value = "goods_brand", jdbcType = JdbcType.VARCHAR)
    @Excel(name = "品牌", orderNum = "1")
    private String goodsBrand;
    /**
     * 状态 0 可申请 1 已下架
     */
    @TableField(value = "ban", jdbcType = JdbcType.INTEGER)
    @Excel(name = "状态", replace = {"正常_0", "已下架_1"}, orderNum = "6")
    private Integer ban;
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
