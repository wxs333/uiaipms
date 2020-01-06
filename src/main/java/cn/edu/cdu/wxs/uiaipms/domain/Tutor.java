package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 导师
 *
 * @author WXS
 * @date 2019/12/26
 */
@Getter
@Setter
public class Tutor extends User {
    /**
     * 学院
     */
    private Integer facultyId;
}
