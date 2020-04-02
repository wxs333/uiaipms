package cn.edu.cdu.wxs.uiaipms.form;

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
    private String stuName;
    /**
     * 审核导师名字
     */
    private String prTutor;
    /**
     * 审核时间
     */
    private LocalDateTime prTime;
    /**
     * 立项导师名
     */
    private String psTutor;
}
