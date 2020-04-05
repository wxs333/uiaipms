package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.Admin;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 管理员表单
 *
 * @author WXS
 * @date 2020/1/14
 */
@Getter
@Setter
@TableName("admin")
public class AdminForm extends Admin {
    /**
     * 标识
     */
    private String mark;
    /**
     * json字符串
     */
    private String data;
}
