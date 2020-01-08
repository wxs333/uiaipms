package cn.edu.cdu.wxs.uiaipms.result;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import lombok.Getter;
import lombok.Setter;

/**
 * 构造json格式
 *
 * @author WXS
 * @date 2020/1/6
 */
@Getter
@Setter
public class JsonResult<T> {
    /**
     * 状态码
     */
    private String code;
    /**
     * 消息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 构造方法
     */
    private JsonResult() {
        this(GlobalConstant.SUCCESS);
    }

    /**
     * 构造方法
     *
     * @param code 状态码
     */
    private JsonResult(String code) {
        this(code, null);
    }

    /**
     * 构造方法
     *
     * @param code    数据状态
     * @param message 消息提示
     */
    private JsonResult(String code, String message) {
        this(code, message, null);
    }

    /**
     * 构造方法
     *
     * @param code    数据状态
     * @param message 消息提示
     * @param data    数据
     */
    private JsonResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 构造json格式
     *
     * @param <T> 返回数据的泛型
     * @return json
     */
    public static <T> JsonResult<T> jsonResult() {
        return jsonResult(GlobalConstant.SUCCESS, null);
    }

    /**
     * 构造json格式
     *
     * @param message 返回的消息
     * @param <T>     返回数据的泛型
     * @return json
     */
    public static <T> JsonResult<T> jsonResult(String message) {
        return jsonResult(GlobalConstant.SUCCESS, message);
    }

    /**
     * 构造json格式
     *
     * @param data 返回数据
     * @param <T>  返回数据的泛型
     * @return json
     */
    public static <T> JsonResult<T> jsonResult(T data) {
        return jsonResult(GlobalConstant.SUCCESS, "", data);
    }

    /**
     * 构造json格式
     *
     * @param code    状态码
     * @param message 返回的消息
     * @param <T>     返回数据的泛型
     * @return json
     */
    public static <T> JsonResult<T> jsonResult(String code, String message) {
        return jsonResult(code, message, null);
    }

    /**
     * 构造json格式
     *
     * @param code    状态码
     * @param message 返回的消息
     * @param data    返回数据
     * @param <T>     返回数据的泛型
     * @return json
     */
    public static <T> JsonResult<T> jsonResult(String code, String message, T data) {
        return new JsonResult<>(code, message, data);
    }

}
