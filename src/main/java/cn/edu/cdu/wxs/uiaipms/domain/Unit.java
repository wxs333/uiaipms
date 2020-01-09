package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 计量单位
 *
 * @author WXS
 */
@Setter
@Getter
public class Unit {
    /**
     * ID
     */
    private Integer unitId;

    /**
     * 名称
     */
    private String unitName;
}