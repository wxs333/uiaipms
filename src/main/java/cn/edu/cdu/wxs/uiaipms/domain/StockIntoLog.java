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
 * 库存入库记录
 * </p>
 *
 * @author WXS
 * @since 2020-03-10
 */
@Getter
@Setter
@TableName("stock_into_log")
public class StockIntoLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "sto_id", type = IdType.INPUT)
    private String stoId;

    /**
     * 管理员
     */
    @TableField("admin_id")
    private String adminId;

    /**
     * 货物
     */
    @TableField("goods_id")
    private String goodsId;

    /**
     * 数量
     */
    @TableField("goods_num")
    private Integer goodsNum;

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
