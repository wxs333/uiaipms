package cn.edu.cdu.wxs.uiaipms.form;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.edu.cdu.wxs.uiaipms.domain.ProjectReview;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 项目审核表 表单
 *
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
    @Excel(name = "项目名称", width = 30)
    private String proName;
    /**
     * 项目文档地址
     */
    private String proLocation;
    /**
     * 项目文档名
     */
    private String wordName;
    /**
     * 导师名称
     */
    @Excel(name = "审核导师", orderNum = "1")
    private String tutorName;
    /**
     * 学生姓名
     */
    private String stuName;
}
