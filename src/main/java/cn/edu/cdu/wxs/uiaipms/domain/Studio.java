package cn.edu.cdu.wxs.uiaipms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 工作室
 *
 * @author WXS
 */
@Setter
@Getter
public class Studio {
    /**
     * id
     */
    private String studId;

    /**
     * 地址
     */
    private String studAdress;

    /**
     * 房间号
     */
    private String studRoomNo;

    /**
     * 占地面积
     */
    private Integer studArea;

    /**
     * 所属企业ID
     */
    private String comId;

    /**
     * 人数
     */
    private Integer studNum;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 逻辑删除字段
     */
    private Integer logicDeleteFlag;


}