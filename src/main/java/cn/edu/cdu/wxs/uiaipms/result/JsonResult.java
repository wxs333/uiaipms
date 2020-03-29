package cn.edu.cdu.wxs.uiaipms.result;

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
     *
     * @param data 数据
     */
    public JsonResult(T data) {

        this.data = data;
    }

    /**
     * 构造方法
     *
     * @param code    数据状态
     * @param message 消息提示
     * @param data    数据
     */
    public JsonResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
