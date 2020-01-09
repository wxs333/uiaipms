package cn.edu.cdu.wxs.uiaipms.form;

import lombok.Getter;
import lombok.Setter;

/**
 * 登录表单
 *
 * @author WXS
 * @date 2020/1/9
 */
@Getter
@Setter
public class LoginForm {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色
     */
    private Integer role;
    /**
     * 验证码
     */
    private String code;
}
