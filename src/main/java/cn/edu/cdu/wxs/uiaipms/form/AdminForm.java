package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.Admin;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 管理员表单
 * @author WXS
 * @date 2020/1/14
 */
@Getter
@Setter
@ToString
public class AdminForm extends Admin {
    /**
     * ID
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 标识
     */
    private String mark;
    /**
     * json字符串
     */
    private String data;
}
