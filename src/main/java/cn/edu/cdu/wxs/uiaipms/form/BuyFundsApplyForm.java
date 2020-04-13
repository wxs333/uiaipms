package cn.edu.cdu.wxs.uiaipms.form;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.edu.cdu.wxs.uiaipms.domain.BuyFundsApply;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 采购资金申请 表单
 *
 * @author WXS
 * @date 2020/3/19
 */
@Getter
@Setter
@TableName("buy_funds_apply")
public class BuyFundsApplyForm extends BuyFundsApply {
    /**
     * 申请人姓名
     */
    @Excel(name = "申请人", width = 30)
    private String applyUserName;
    /**
     * 处理人姓名
     */
    @Excel(name = "处理人", orderNum = "4", width = 30)
    private String dealUserName;
    /**
     * 某天某个人拨款总金额
     */
    private BigDecimal total;
}
