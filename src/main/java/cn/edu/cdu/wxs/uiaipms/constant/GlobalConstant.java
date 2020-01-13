package cn.edu.cdu.wxs.uiaipms.constant;

/**
 * 全局常量
 *
 * @author WXS
 * @date 2019/12/25
 */
public class GlobalConstant {

    private GlobalConstant(){}

    /**
     * 请求成功状态码
     */
    public static final String SUCCESS = "success";
    /**
     * 请求失败状态码
     */
    public static final String FAILURE = "failure";
    /**
     * 默认每页条数
     */
    public static final int PAGE_SIZE = 10;
    /**
     * 默认查询页码
     */
    public static final int PAGR_NUM = 1;

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
}
