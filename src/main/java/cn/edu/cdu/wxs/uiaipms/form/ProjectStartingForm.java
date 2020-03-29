package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.ProjectStarting;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

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
}
