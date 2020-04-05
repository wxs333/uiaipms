package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.Student;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 学生表单
 *
 * @author WXS
 * @date 2020/1/13
 */
@Getter
@Setter
@TableName("student")
public class StudentForm extends Student {
    /**
     * 班级名称
     */
    private String clazzName;
    /**
     * 学院ID
     */
    private String facId;
    /**
     * 系别ID
     */
    private String discId;
}
