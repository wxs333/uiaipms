package cn.edu.cdu.wxs.uiaipms.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 角色
 *
 * @author WXS
 */
@Setter
@Getter
@ToString
@TableName("role")
public class Role {
    /**
     * id
     */
    private String roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 编码
     */
    private String roleCode;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 逻辑删除字段
     */
    private Integer logicDeleteFlag;
}