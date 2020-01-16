package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 物品
 *
 * @author WXS
 */
@Setter
@Getter
public class Goods {
    /**
     * ID
     */
    private String goodsId;

    /**
     * 名称
     */
    private String goodsName;

    /**
     * 数量
     */
    private Integer goodsNum;

    /**
     * 单位
     */
    private String unitId;

    /**
     * 型号
     */
    private String goodsModel;

    /**
     * 品牌
     */
    private String goodsBrand;

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