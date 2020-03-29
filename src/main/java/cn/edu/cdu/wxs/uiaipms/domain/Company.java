package cn.edu.cdu.wxs.uiaipms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 企业
 * </p>
 *
 * @author WXS
 * @since 2020-02-10
 */
@Getter
@Setter
@TableName("company")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(value = "com_id", type = IdType.INPUT)
    private String comId;
    /**
     * 企业名
     */
    @TableField(value = "com_name", jdbcType = JdbcType.VARCHAR)
    private String comName;
    /**
     * 用户名
     */
    @TableField(value = "username", jdbcType = JdbcType.VARCHAR)
    private String username;
    /**
     * 联系方式
     */
    @TableField(value = "phone", jdbcType = JdbcType.VARCHAR)
    private String phone;
    /**
     * 密码
     */
    @TableField(value = "password", jdbcType = JdbcType.VARCHAR)
    private String password;
    /**
     * 负责人
     */
    @TableField(value = "com_people", jdbcType = JdbcType.VARCHAR)
    private String comPeople;
    /**
     * 照片地址
     */
    @TableField(value = "image", jdbcType = JdbcType.VARCHAR)
    private String image;
    /**
     * 更新时间
     */
    @TableField(value = "update_time", jdbcType = JdbcType.TIMESTAMP)
    private LocalDateTime updateTime;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", jdbcType = JdbcType.TIMESTAMP)
    private LocalDateTime createTime;
    /**
     * 逻辑删除字段
     */
    @TableField(value = "logic_delete_flag", jdbcType = JdbcType.INTEGER)
    private Integer logicDeleteFlag;


}
