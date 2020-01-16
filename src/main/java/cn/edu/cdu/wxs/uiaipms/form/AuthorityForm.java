package cn.edu.cdu.wxs.uiaipms.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 授权参数接受表单
 * @author WXS
 * @date 2020/1/16
 */
@Getter
@Setter
@ToString
public class AuthorityForm {

    private String mark;
    private String username;
    private List<UserRoleForm> data;
}
