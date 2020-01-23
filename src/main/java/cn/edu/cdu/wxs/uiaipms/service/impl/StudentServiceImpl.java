package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.StudentColumn;
import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.domain.Student;
import cn.edu.cdu.wxs.uiaipms.domain.UserRole;
import cn.edu.cdu.wxs.uiaipms.form.StudentForm;
import cn.edu.cdu.wxs.uiaipms.mapper.StudentMapper;
import cn.edu.cdu.wxs.uiaipms.mapper.UserRoleMapper;
import cn.edu.cdu.wxs.uiaipms.service.StudentService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;

/**
 * 学生的服务层实现类
 *
 * @author WXS
 * @date 2020/1/11
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService {
    /**
     * mapper对象
     */
    @Autowired
    private StudentMapper mapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 学生的角色ID
     */
    private static final String STUDENT_ROLE_ID = "10a258b4defc4f5db4847b09ce883f73";

    @Override
    public BaseMapper<Student> getMapper() {
        return mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public String getPasswordByUsername(String username) {
        return mapper.selectPasswordByUsername(username, StudentColumn.STUDENT_TABLE);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean register(StudentForm form) {
        // 设置角色
        UserRole userRole = new UserRole();
        Date date = new Date();
        userRole.setUrId(SystemUtils.getUuid());
        userRole.setRoleId(STUDENT_ROLE_ID);
        userRole.setUserId(form.getStuId());
        userRole.setUrWho(GlobalConstant.LOGIN_ROLE_STUDENT);
        userRole.setCreateTime(date);
        userRole.setUpdateTime(date);

        return add(form) && SystemUtils.gtTheZero(userRoleMapper.insert(userRole));
    }

    @Override
    public boolean isExistByUsernameOrStuNo(String username, String stuNo) {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.eq(GlobalConstant.USERNAME, username)
                .or()
                .eq(StudentColumn.STU_NO, stuNo);
        return !ObjectUtils.isEmpty(mapper.selectOne(wrapper));
    }

    @Override
    public StudentForm getByUsername(String username) {
        return mapper.getByUsername(username);
    }

    @Override
    public IPage<StudentForm> getAll(Page<StudentForm> page) {
        return mapper.selectAll(page);
    }

    @Override
    public IPage<StudentForm> getAllToList(Page<StudentForm> page) {
        return mapper.selectAllInfo(page);
    }
}
