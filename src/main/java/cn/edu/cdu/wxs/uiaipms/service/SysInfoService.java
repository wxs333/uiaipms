package cn.edu.cdu.wxs.uiaipms.service;

import cn.edu.cdu.wxs.uiaipms.domain.SysInfo;

import java.math.BigDecimal;

/**
 * 系统信息 业务接口类
 *
 * @author WXS
 * @date 2020/3/19
 */
public interface SysInfoService extends BaseService<SysInfo> {

    /**
     * 获取园区的资金
     *
     * @return 资金总额
     */
    BigDecimal getSysMoney();
}
