package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

/**系别
 * @author WXS
 * @date 2020/1/27
 */
@Getter
@Setter
public class Discipline {
    /**
     * ID
     */
    private String discId;
    /**
     * 系名
     */
    private String discName;
    /**
     * 学院
     */
    private String facId;
}
