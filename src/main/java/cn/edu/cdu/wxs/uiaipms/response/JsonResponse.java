package cn.edu.cdu.wxs.uiaipms.response;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;

/**
 * Json类型的响应
 *
 * @author WXS
 * @date 2019/12/25
 */
public class JsonResponse<T> {
    /**
     * 响应码
     */
    private String code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    /**
     * 默认构造
     */
    public JsonResponse() {
        this(GlobalConstant.SUCCESS);
    }

    /**
     * 构造json格式
     *
     * @param code 状态码
     */
    public JsonResponse(String code) {
        this(code, null);
    }

    /**
     * 构造json格式
     *
     * @param code    状态码
     * @param message 消息
     */
    public JsonResponse(String code, String message) {
        this(code, message, null);
    }

    /**
     * 构造json格式
     *
     * @param code    状态码
     * @param message 消息
     * @param data    数据
     */
    public JsonResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
