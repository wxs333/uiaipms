package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.column.StudentColumn;
import cn.edu.cdu.wxs.uiaipms.domain.Student;
import cn.edu.cdu.wxs.uiaipms.mapper.StudentMapper;
import cn.edu.cdu.wxs.uiaipms.service.StudentService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public BaseMapper<Student> getMapper() {
        return mapper;
    }

    @Override
    public String getPasswordByUsername(String username) {
        return mapper.selectPasswordByUsername(username, StudentColumn.STUDENT_TABLE);
    }

}
