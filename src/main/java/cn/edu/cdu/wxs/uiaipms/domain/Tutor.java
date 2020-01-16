package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 导师
 *
 * @author WXS
 * @date 2020/1/10
 */
@Getter
@Setter
public class Tutor implements Serializable {
    /**
     * id
     */
    private String tutorId;
    /**
     * 姓名
     */
    private String tutorName;
    /**
     * 登录名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 学院ID
     */
    private String facultyId;
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
