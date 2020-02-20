package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.Student;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 学生表单
 * @author WXS
 * @date 2020/1/13
 */
@Getter
@Setter
@ToString
@TableName("student")
public class StudentForm extends Student {
    /**
     * ID
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
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
