package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.Goods;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 物品 表单
 * @author WXS
 * @date 2020/2/17
 */
@Getter
@Setter
@TableName("goods")
public class GoodsForm extends Goods {
    /**
     * 单位名称
     */
    private String unitName;
}
