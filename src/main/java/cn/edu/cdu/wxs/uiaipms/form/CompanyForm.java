package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.Company;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 企业表单
 * @author WXS
 * @date 2020/1/14
 */
@Getter
@Setter
@ToString
public class CompanyForm extends Company {
    /**
     * ID
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
}
