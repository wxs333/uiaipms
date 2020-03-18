package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.ProjectReview;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 项目审核表 表单
 * @author WXS
 * @date 2020/3/13
 */
@Setter
@Getter
@TableName("project_review")
public class ProjectReviewForm extends ProjectReview {
    /**
     * 项目名称
     */
    private String proName;
    /**
     * 项目描述
     */
    private String proDesc;
    /**
     * 导师名称
     */
    private String tutorName;
    /**
     * 审批理由
     */
    private String paReason;
    /**
     * 项目id
     */
    private String proId;
}
