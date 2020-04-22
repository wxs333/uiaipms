package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.form.StudioApplyForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author WXS
 * @date 2020/4/22
 */
@Mapper
public interface StudioApplyMapper extends BaseMapper<StudioApplyForm> {

    /**
     * 分页查询
     * @param page 分页
     * @return 分页集合
     */
    IPage<StudioApplyForm> selectByPage(Page<StudioApplyForm> page);
}
