package cn.edu.cdu.wxs.uiaipms.constant;

/**
 * 全局常量
 *
 * @author WXS
 * @date 2019/12/25
 */
public class GlobalConstant {

    private GlobalConstant() {
    }

    /**
     * 请求成功状态码
     */
    public static final String SUCCESS = "success";
    /**
     * 请求失败状态码
     */
    public static final String FAILURE = "failure";
    /**
     * 登录角色-学生
     */
    public static final int LOGIN_ROLE_STUDENT = 3;
    /**
     * 登录角色-管理员
     */
    public static final int LOGIN_ROLE_ADMIN = 1;
    /**
     * 登录角色-导师
     */
    public static final int LOGIN_ROLE_TUTOR = 2;
    /**
     * 登录角色-企业
     */
    public static final int LOGIN_ROLE_COMPANY = 4;

    /**
     * 用户名
     */
    public static final String USERNAME = "username";
    /**
     * 手机号码
     */
    public static final String PHONE = "phone";
    /**
     * 创建时间
     */
    public static final String CREATE_TIME = "create_time";
    /**
     * 更新时间
     */
    public static final String UPDATE_TIME = "update_time";

    /**
     * 逻辑删除字段
     */
    public static final String LOGIC_DELETE_FLAG = "logic_delete_flag";

    public static final String TABLE_NAME = "tableName";
    public static final String ID_COL = "idCol";
    public static final String ROLE_TYPE = "roleType";
}
