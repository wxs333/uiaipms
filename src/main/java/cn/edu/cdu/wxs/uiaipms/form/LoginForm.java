package cn.edu.cdu.wxs.uiaipms.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * LoginForm class
 *
 * @author WXS
 * @date 2019/12/16
 */
@Getter
@Setter
@ToString
public class LoginForm {

    @Getter
    @Setter
    private String username;
    private String password;
    private Integer role;
    private String code;
}
