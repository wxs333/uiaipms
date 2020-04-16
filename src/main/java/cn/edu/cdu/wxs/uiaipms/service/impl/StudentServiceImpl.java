package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.StudentColumn;
import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.RealmFrom;
import cn.edu.cdu.wxs.uiaipms.form.StudentForm;
import cn.edu.cdu.wxs.uiaipms.form.UserRoleForm;
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

import java.time.LocalDateTime;

/**
 * 学生的服务层实现类
 *
 * @author WXS
 * @date 2020/1/11
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentForm> implements StudentService {
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
    public BaseMapper<StudentForm> getMapper() {
        return mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public RealmFrom getPasswordByUsername(String username) {
        return mapper.selectPasswordByUsername(username, StudentColumn.STUDENT_TABLE);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean register(StudentForm form) {
        // 设置角色
        UserRoleForm userRole = new UserRoleForm();
        userRole.setUrId(SystemUtils.getUuid());
        userRole.setRoleId(STUDENT_ROLE_ID);
        userRole.setUserId(form.getStuId());
        userRole.setUrWho(GlobalConstant.LOGIN_ROLE_STUDENT);
        userRole.setCreateTime(form.getCreateTime());
        userRole.setUpdateTime(form.getUpdateTime());

        return add(form) && SystemUtils.gtTheZero(userRoleMapper.insert(userRole));
    }

    @Override
    public boolean isExistByUsernameOrStuNo(String username, String stuNo) {
        QueryWrapper<StudentForm> wrapper = new QueryWrapper<>();
        wrapper.select(StudentColumn.STU_ID)
                .eq(GlobalConstant.USERNAME, username)
                .or()
                .eq(StudentColumn.STU_NO, stuNo);
        return !ObjectUtils.isEmpty(mapper.selectOne(wrapper));
    }

    @Override
    public StudentForm getByUsername(String username) {
        QueryWrapper<StudentForm> wrapper = new QueryWrapper<>();
        wrapper.select(StudentColumn.STU_ID, StudentColumn.NICKNAME, StudentColumn.IMAGE)
                .eq(StudentColumn.LOGIC_DELETE_FLAG, 0)
                .eq(StudentColumn.USERNAME, username);
        return mapper.selectOne(wrapper);
    }

    @Override
    public IPage<StudentForm> getAll(Page<StudentForm> page) {
        return mapper.selectAll(page);
    }

    @Override
    public IPage<StudentForm> getAllToList(Page<StudentForm> page) {
        return mapper.selectAllInfo(page);
    }

    @Override
    public StudentForm getOneById(String id) {
        return mapper.selectOneById(id);
    }

    @Override
    public boolean update(StudentForm form) {
        form.setDiscId(null);
        form.setUpdateTime(LocalDateTime.now());
        return SystemUtils.gtTheZero(mapper.updateById(form));
    }

    @Override
    public StudentForm getInfo(String stuId) {
        QueryWrapper<StudentForm> wrapper = new QueryWrapper<>();
        wrapper.select(StudentColumn.STU_ID, StudentColumn.STU_NAME, StudentColumn.NICKNAME, StudentColumn.ADDRESS,
                StudentColumn.USERNAME, StudentColumn.PHONE, StudentColumn.IMAGE)
                .eq(GlobalConstant.LOGIC_DELETE_FLAG, 0)
                .eq(StudentColumn.STU_ID, stuId);
        return mapper.selectOne(wrapper);
    }
}
