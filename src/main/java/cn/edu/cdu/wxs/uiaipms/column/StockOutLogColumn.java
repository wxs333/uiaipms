package cn.edu.cdu.wxs.uiaipms.column;

/**
 * 出库记录 字段映射
 *
 * @author WXS
 * @date 2020/3/11
 */
public class StockOutLogColumn {
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
     * 申请数量
     */
    public static final String APPLY_NUM = "apply_num";
    /**
     * 工作室
     */
    public static final String STUD_ID = "stud_id";
    /**
     * 是否同意 0 同意 1不同意
     */
    public static final String AGREE = "agree";
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

    private StockOutLogColumn() {
    }
}
