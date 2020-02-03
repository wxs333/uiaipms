package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 学院
 * @author WXS
 * @date 2020/1/27
 */
@Setter
@Getter
public class Faculty {
    /**
     * ID
     */
    private String facId;
    /**
     * 名称
     */
    private String facName;
    /**
     * 简称
     */
    private String facShortName;
}
