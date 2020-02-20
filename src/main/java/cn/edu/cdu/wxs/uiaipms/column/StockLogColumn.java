package cn.edu.cdu.wxs.uiaipms.column;

/**
 * 库存记录 字段映射
 *
 * @author WXS
 * @date 2020/2/17
 */
public class StockLogColumn {
    /**
     * id
     */
    public static final String STO_ID = "sto_id";
    /**
     * 处理管理员ID
     */
    public static final String ADMIN_ID = "admin_id";
    /**
     * 类型 0 出库 1 入库
     */
    public static final String STO_TYPE = "sto_type";
    /**
     * 货物
     */
    public static final String GOODS_ID = "goods_id";
    /**
     * 数量
     */
    public static final String GOODS_NUM = "goods_num";
    /**
     * 工作室
     */
    public static final String STUD_ID = "stud_id";
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
}
