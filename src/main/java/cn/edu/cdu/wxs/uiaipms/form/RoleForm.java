package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.Role;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色表单
 *
 * @author WXS
 * @date 2020/1/13
 */
@Getter
@Setter
@TableName("role")
public class RoleForm extends Role {
}
