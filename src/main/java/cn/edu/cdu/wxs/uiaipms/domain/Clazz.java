package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 班级
 *
 * @author WXS
 * @date 2019/12/26
 */
@Getter
@Setter
public class Clazz {
    /**
     * id
     */
    private Integer id;
    /**
     * 班级名称
     */
    private String clazzName;
    /**
     * 专业
     */
    private Integer disciplineId;
}
