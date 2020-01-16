package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.Student;
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
public class StudentForm extends Student {
    /**
     * ID
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
}
