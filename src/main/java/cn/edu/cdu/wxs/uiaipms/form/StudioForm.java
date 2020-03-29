package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.Studio;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 工作室 表单
 *
 * @author WXS
 * @date 2020/2/15
 */
@Getter
@Setter
@TableName("studio")
public class StudioForm extends Studio {
    /**
     * 企业名
     */
    private String comName;
    /**
     * 企业负责人
     */
    private String comPeople;
}
