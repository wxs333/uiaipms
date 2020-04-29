package cn.edu.cdu.wxs.uiaipms.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * treeMap 模型
 * @author WXS
 * @date 2020/4/29
 */
@Getter
@Setter
public class TreeMapModel {

    /**
     * 名称
     */
    private String name;
    /**
     * 数值
     */
    private Integer value;
    /**
     * 子项
     */
    private List<TreeMapModel> children;
}
