package cn.edu.cdu.wxs.uiaipms.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 统计 模型
 * @author WXS
 * @date 2020/4/30
 */
@Getter
@Setter
public class StatisticsModel {
    /**
     * 统计-名称
     */
    private String name;
    /**
     * 统计-日期
     */
    private String date;
    /**
     * 统计-数量
     */
    private Integer num;

}
