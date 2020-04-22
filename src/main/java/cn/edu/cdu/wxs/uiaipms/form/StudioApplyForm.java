package cn.edu.cdu.wxs.uiaipms.form;

import cn.edu.cdu.wxs.uiaipms.domain.StudioApply;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 工作室申请记录 表单
 * @author WXS
 * @date 2020/4/22
 */
@Getter
@Setter
@TableName("studio_apply")
public class StudioApplyForm extends StudioApply {
}
