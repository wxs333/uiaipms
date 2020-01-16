package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;

/**
 * BaseController class
 *
 * @author WXS
 * @date 2020/1/9
 */
public class BaseController {

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
     * @param code 状态码
     * @param data 返回的数据
     * @param <T>  返回数据的泛型
     * @return json
     */
    public static <T> JsonResult<T> jsonResult(String code, T data) {
        return jsonResult(code, null, data);
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
