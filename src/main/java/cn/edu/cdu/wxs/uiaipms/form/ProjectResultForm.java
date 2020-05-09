package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.ProjectResult;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 项目成果
 *
 * @author WXS
 * @date 2020/5/8
 */
@Getter
@Setter
@TableName("project_result")
public class ProjectResultForm extends ProjectResult {
    /**
     * 立项记录id
     */
    private String psId;
}
