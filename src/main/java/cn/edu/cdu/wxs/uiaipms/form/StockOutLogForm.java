package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.StockOutLog;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 库存记录 表单
 *
 * @author WXS
 * @date 2020/2/17
 */
@Getter
@Setter
@TableName("stock_out_log")
public class StockOutLogForm extends StockOutLog {
    /**
     * 操作人
     */
    private String adminName;
    /**
     * 货物名
     */
    private String goodsName;
    /**
     * 申请人地址
     */
    private String address;
    /**
     * 型号
     */
    private String goodsModel;
    /**
     * 品牌
     */
    private String goodsBrand;

}
