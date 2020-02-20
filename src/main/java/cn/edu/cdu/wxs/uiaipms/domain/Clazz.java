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
 * 班级
 * </p>
 *
 * @author WXS
 * @since 2020-02-10
 */
@Getter
@Setter
@TableName("clazz")
public class Clazz implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "clazz_id", type = IdType.INPUT)
    private String clazzId;

    /**
     * 班级名称
     */
    @TableField(value = "clazz_name", jdbcType = JdbcType.VARCHAR)
    private String clazzName;

    /**
     * 所属系ID
     */
    @TableField(value = "disc_id", jdbcType = JdbcType.INTEGER)
    private String discId;


}
