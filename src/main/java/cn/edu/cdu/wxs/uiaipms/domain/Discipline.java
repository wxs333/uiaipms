package cn.edu.cdu.wxs.uiaipms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;

/**
 * <p>
 * 系
 * </p>
 *
 * @author WXS
 * @since 2020-02-10
 */
@Getter
@Setter
@TableName("discipline")
public class Discipline implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "disc_id", type = IdType.INPUT)
    private String discId;

    /**
     * 系的名称
     */
    @TableField(value = "disc_name", jdbcType = JdbcType.VARCHAR)
    private String discName;

    /**
     * 学院ID
     */
    @TableField(value = "fac_id", jdbcType = JdbcType.VARCHAR)
    private String facId;


}
