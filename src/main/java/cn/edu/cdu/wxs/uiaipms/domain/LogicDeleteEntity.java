package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 逻辑删除
 *
 * @author WXS
 * @date 2019/12/28
 */
@Getter
@Setter
public class LogicDeleteEntity {
    /**
     * 逻辑删除字段，1 逻辑删除 0 未逻辑删除
     */
    private Integer logicDeleteFlag;

}
