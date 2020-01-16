package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 出入库记录
 *
 * @author WXS
 */
@Setter
@Getter
public class StockLog {
    /**
     * ID
     */
    private String stoId;

    /**
     * 管理员
     */
    private String adminId;

    /**
     * 类型
     */
    private Integer stoType;

    /**
     * 货物
     */
    private String goodsId;

    /**
     * 数量
     */
    private Integer goodsNum;

    /**
     * 工作室
     */
    private String studId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 逻辑删除字段
     */
    private Integer logicDeleteFlag;
}