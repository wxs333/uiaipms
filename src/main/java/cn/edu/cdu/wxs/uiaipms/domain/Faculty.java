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
 * 学院
 * </p>
 *
 * @author WXS
 * @since 2020-02-10
 */
@Getter
@Setter
@TableName("faculty")
public class Faculty implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "fac_id", type = IdType.INPUT)
    private String facId;

    /**
     * 学院名称
     */
    @TableField(value = "fac_name", jdbcType = JdbcType.VARCHAR)
    private String facName;

    /**
     * 简称
     */
    @TableField(value = "fac_short_name", jdbcType = JdbcType.VARCHAR)
    private String facShortName;


}
