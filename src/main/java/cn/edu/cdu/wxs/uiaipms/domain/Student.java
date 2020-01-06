package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 学生
 *
 * @author WXS
 * @date 2019/12/24
 */
@Getter
@Setter
public class Student extends User {
    /**
     * 学号
     */
    private String studentNum;
    /**
     * 班级
     */
    private Integer clazzId;
    /**
     * 银行卡号
     */
    private String bankCard;
}
