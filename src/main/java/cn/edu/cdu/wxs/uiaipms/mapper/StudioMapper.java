package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.StudioForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 工作室 数据层
 *
 * @author WXS
 * @date 2020/2/15
 */
@Mapper
public interface StudioMapper extends CommonMapper<StudioForm> {

    /**
     * 修改禁用状态
     *
     * @param ban        禁用状态
     * @param studId     ID
     * @param updateTime 修改时间
     * @return 影响行数
     */
    int updateBan(@Param("ban") String ban, @Param("studId") String studId, @Param("updateTime") LocalDateTime updateTime);

    /**
     * 获取所有未禁用未使用工作室的id，地址，房间号
     *
     * @return 集合
     */
    List<StudioForm> selectIdAndAddressAndRoomNo();
}
