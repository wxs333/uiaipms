package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.Tutor;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 导师表单
 *
 * @author WXS
 * @date 2020/1/14
 */
@Getter
@Setter
@TableName("tutor")
public class TutorForm extends Tutor {
    /**
     * 学院名称
     */
    private String facultyName;


}
