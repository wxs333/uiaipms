package cn.edu.cdu.wxs.uiaipms.column;

/**
 * 入库记录 字段映射
 *
 * @author WXS
 * @date 2020/3/11
 */
public class StockIntoLogColumn {
    /**
     * ID
     */
    public static final String STO_ID = "sto_id";
    /**
     * 管理员ID
     */
    public static final String ADMIN_ID = "admin_id";
    /**
     * 物品
     */
    public static final String GOODS_ID = "goods_id";
    /**
     * 数量
     */
    public static final String GOODS_NUM = "goods_num";
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

    private StockIntoLogColumn() {
    }
}
