package cn.edu.cdu.wxs.uiaipms.form;

import lombok.Getter;
import lombok.Setter;

/**
 * 处理权限认证的表单
 * @author WXS
 * @date 2020/4/16
 */
@Getter
@Setter
public class RealmFrom {
    /**
     * 密码
     */
    private String password;
    /**
     * 状态
     */
    private Integer ban;
}
