package cn.edu.cdu.wxs.uiaipms.form;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.edu.cdu.wxs.uiaipms.domain.ProjectStarting;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 项目立项表 表单
 *
 * @author WXS
 * @date 2020/3/13
 */
@Setter
@Getter
@TableName("project_starting")
public class ProjectStartingForm extends ProjectStarting {
    /**
     * 项目名称
     */
    @Excel(name = "项目名称", orderNum = "1", width = 30)
    private String proName;
    /**
     * 项目文档路径
     */
    private String proLocation;
    /**
     * 项目文档名
     */
    private String wordName;
    /**
     * 学生名字
     */
    @Excel(name = "申请人", width = 30)
    private String stuName;
    /**
     * 审核导师名字
     */
    @Excel(name = "审核导师", orderNum = "4", width = 30)
    private String prTutor;
    /**
     * 审核时间
     */
    @Excel(name = "审核时间", orderNum = "5", width = 30)
    private LocalDateTime prTime;
    /**
     * 立项导师名
     */
    @Excel(name = "立项导师", orderNum = "7", width = 30)
    private String psTutor;
    /**
     * 审批导师名
     */
    @Excel(name = "审批导师", orderNum = "2", width = 30)
    private String paTutor;
    /**
     * 审批时间
     */
    @Excel(name = "审批时间", orderNum = "3", width = 30)
    private LocalDateTime paTime;
}
