package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.AdminColumn;
import cn.edu.cdu.wxs.uiaipms.column.CompanyColumn;
import cn.edu.cdu.wxs.uiaipms.column.StudentColumn;
import cn.edu.cdu.wxs.uiaipms.column.TutorColumn;
import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.service.BaseService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * 基础的服务层实现类
 *
 * @author WXS
 * @date 2020/1/10
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    /**
     * 获取mapper对象
     *
     * @return mapper对象
     */
    public abstract BaseMapper<T> getMapper();


    @Override
    public boolean add(T domain) {
        return SystemUtils.gtTheZero(getMapper().insert(domain));
    }

    @Override
    public boolean modifyById(T domain) {
        return false;
    }

    @Override
    public T getById(String idCol, int id) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        wrapper.eq(idCol, id)
                .eq(GlobalConstant.LOGIC_DELETE_FLAG, 0);

        return getMapper().selectOne(wrapper);
    }

    @Override
    public Map<String, Object> getTableNameAndIdColByRole(String role) {
        Map<String, Object> map = new HashMap<>(2);
        switch (role) {
            case "admin":
                map.put(GlobalConstant.TABLE_NAME, AdminColumn.ADMIN_TABLE);
                map.put(GlobalConstant.ID_COL, AdminColumn.ADMIN_ID);
                map.put(GlobalConstant.ROLE_TYPE, GlobalConstant.LOGIN_ROLE_ADMIN);
                break;
            case "tutor":
                map.put(GlobalConstant.TABLE_NAME, TutorColumn.TUTOR_TABLE);
                map.put(GlobalConstant.ID_COL, TutorColumn.TUTOR_ID);
                map.put(GlobalConstant.ROLE_TYPE, GlobalConstant.LOGIN_ROLE_TUTOR);
                break;
            case "student":
                map.put(GlobalConstant.TABLE_NAME, StudentColumn.STUDENT_TABLE);
                map.put(GlobalConstant.ID_COL, StudentColumn.STU_ID);
                map.put(GlobalConstant.ROLE_TYPE, GlobalConstant.LOGIN_ROLE_STUDENT);
                break;
            case "company":
                map.put(GlobalConstant.TABLE_NAME, CompanyColumn.COMPANY_TABLE);
                map.put(GlobalConstant.ID_COL, CompanyColumn.COM_ID);
                map.put(GlobalConstant.ROLE_TYPE, GlobalConstant.LOGIN_ROLE_COMPANY);
                break;
            default:
                break;
        }
        return map;
    }
}
