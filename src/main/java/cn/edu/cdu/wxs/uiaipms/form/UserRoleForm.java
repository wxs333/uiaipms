package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.UserRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户角色表单
 * @author WXS
 * @date 2020/1/16
 */
@Getter
@Setter
@ToString
public class UserRoleForm extends UserRole {
    private String mark;
    private String username;

    private String value;
    private String title;

}
