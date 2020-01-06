package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 专业
 *
 * @author WXS
 * @date 2019/12/26
 */
@Getter
@Setter
public class Discipline {
    /**
     * id
     */
    private Integer id;
    /**
     * 专业名称
     */
    private String disciplineName;
    /**
     * 学院
     */
    private Integer facultyId;
}
