package cn.edu.cdu.wxs.uiaipms.form;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.edu.cdu.wxs.uiaipms.domain.ProjectFinance;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author WXS
 * @date 2020/3/17
 */
@Setter
@Getter
@TableName("project_finance")
public class ProjectFinanceForm extends ProjectFinance {
    /**
     * 项目名称
     */
    @Excel(name = "项目", width = 30)
    private String proName;
    /**
     * 导师名称
     */
    @Excel(name = "申请人", orderNum = "1", width = 30)
    private String tutorName;
    /**
     * 处理人名字
     */
    @Excel(name = "处理人", orderNum = "5", width = 30)
    private String adminName;
}
