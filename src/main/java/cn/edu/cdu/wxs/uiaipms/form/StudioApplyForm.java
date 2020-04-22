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
    /**
     *工作室地址
     */
    private String studAddress;
    /**
     * 房间号
     */
    private String studRoomNo;
    /**
     * 申请企业
     */
    private String comName;
    /**
     * 申请企业id
     */
    private String comId;
}
