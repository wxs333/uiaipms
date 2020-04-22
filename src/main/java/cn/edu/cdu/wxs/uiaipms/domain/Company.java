package cn.edu.cdu.wxs.uiaipms.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
    @Excel(name = "企业", width = 30)
    private String comName;
    /**
     * 用户名
     */
    @TableField(value = "username", jdbcType = JdbcType.VARCHAR)
    @Excel(name = "账号", orderNum = "1", width = 30)
    private String username;
    /**
     * 联系方式
     */
    @TableField(value = "phone", jdbcType = JdbcType.VARCHAR)
    @Excel(name = "手机号码", orderNum = "3", width = 30)
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
    @Excel(name = "园区负责人", orderNum = "2", width = 30)
    private String comPeople;
    /**
     * 照片地址
     */
    @TableField(value = "image", jdbcType = JdbcType.VARCHAR)
    private String image;
    /**
     * 0 启用 1 禁用 默认 1
     */
    @TableField(value = "ban", jdbcType = JdbcType.INTEGER)
    @Excel(name = "账号状态", orderNum = "4", replace = {"可用_0","禁用_1"}, width = 30)
    private Integer ban;
    /**
     * 入驻时文档名称
     */
    @TableField(value = "word_name", jdbcType = JdbcType.VARCHAR)
    private String wordName;
    /**
     * 文档存储地址
     */
    @TableField(value = "location", jdbcType = JdbcType.VARCHAR)
    private String location;
    /**
     * 0 审批通过 1 审批不通过 默认 1
     */
    @TableField(value = "agree", jdbcType = JdbcType.INTEGER)
    @Excel(name = "审批结果", orderNum = "5", replace = {"通过_0","未通过_1"}, width = 30)
    private Integer agree;
    /**
     * 更新时间
     */
    @TableField(value = "update_time", jdbcType = JdbcType.TIMESTAMP)
    @Excel(name = "处理时间", orderNum = "7", width = 30)
    private LocalDateTime updateTime;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", jdbcType = JdbcType.TIMESTAMP)
    @Excel(name = "申请时间", orderNum = "6", width = 30)
    private LocalDateTime createTime;
    /**
     * 逻辑删除字段
     */
    @TableField(value = "logic_delete_flag", jdbcType = JdbcType.INTEGER)
    private Integer logicDeleteFlag;


}
