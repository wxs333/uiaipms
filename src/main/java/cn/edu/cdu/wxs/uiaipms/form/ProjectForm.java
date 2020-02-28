package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.Project;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 项目 表单
 * @author WXS
 * @date 2020/2/27
 */
@Getter
@Setter
@TableName("project")
public class ProjectForm extends Project {
}
