package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.ProjectApproval;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author WXS
 * @date 2020/2/28
 */
@Getter
@Setter
@TableName("project_approval")
public class ProjectApprovalForm extends ProjectApproval {
    /**
     * 项目标题
     */
    private String proName;
    /**
     * 项目描述
     */
    private String proDesc;
    /**
     * 项目材料地址
     */
    private String proLocation;
    /**
     * 项目文档名称
     */
    private String wordName;
    /**
     * 审批人信息
     */
    private String tutorName;
    /**
     * 学生姓名
     */
    private String stuName;
}
