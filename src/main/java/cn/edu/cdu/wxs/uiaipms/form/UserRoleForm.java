package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.UserRole;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * 用户角色表单
 *
 * @author WXS
 * @date 2020/1/16
 */
@Getter
@Setter
@ToString
@TableName("user_role")
public class UserRoleForm extends UserRole {
    /**
     * 选择的角色
     */
    private Map<String, String> choose;

    private String mark;

    private String userId;

    private String data;

    private List<String> roleIds;

}
