package cn.edu.cdu.wxs.uiaipms.column;

/**
 * 物品表字段
 *
 * @author WXS
 * @date 2020/3/10
 */
public class GoodsColumn {
    /**
     * ID
     */
    public static final String GOODS_ID = "goods_id";
    /**
     * 名称
     */
    public static final String GOODS_NAME = "goods_name";
    /**
     * 剩余数量
     */
    public static final String GOODS_NUM = "goods_num";
    /**
     * 单位ID
     */
    public static final String UNIT_ID = "unit_id";
    /**
     * 型号
     */
    public static final String GOODS_MODEL = "goods_model";
    /**
     * 品牌
     */
    public static final String GOODS_BRAND = "goods_brand";
    /**
     * 更新时间
     */
    public static final String UPDATE_TIME = "update_time";
    /**
     * 创建时间
     */
    public static final String CREATE_TIME = "create_time";
    /**
     * 逻辑删除字段
     */
    public static final String LOGIC_DELETE_FLAG = "logic_delete_flag";

    /**
     * 默认构造，禁止实例化
     */
    private GoodsColumn() {
    }
}
