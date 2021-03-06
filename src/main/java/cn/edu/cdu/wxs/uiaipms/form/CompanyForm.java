package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.Company;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 企业表单
 *
 * @author WXS
 * @date 2020/1/14
 */
@Getter
@Setter
@ToString
@TableName("company")
public class CompanyForm extends Company {
}
