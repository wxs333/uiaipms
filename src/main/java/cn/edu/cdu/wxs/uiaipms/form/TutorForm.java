package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.Tutor;
import lombok.Getter;
import lombok.Setter;

/**
 * 导师表单
 * @author WXS
 * @date 2020/1/14
 */
@Getter
@Setter
public class TutorForm extends Tutor {
    /**
     * ID
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 学院名称
     */
    private String facultyName;


}
