package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.StockIntoLog;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 库存入库记录 表单
 *
 * @author WXS
 * @date 2020/3/11
 */
@Getter
@Setter
@TableName("stock_into_log")
public class StockIntoLogForm extends StockIntoLog {
    /**
     * 处理人姓名
     */
    private String adminName;
    /**
     * 货物名
     */
    private String goodsName;
    /**
     * 品牌
     */
    private String goodsBrand;
    /**
     * 型号
     */
    private String goodsModel;
    /**
     * 价格
     */
    private BigDecimal goodsPrice;
}
