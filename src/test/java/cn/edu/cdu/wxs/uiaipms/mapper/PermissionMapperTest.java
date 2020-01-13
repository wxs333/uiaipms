package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.column.StudentColumn;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PermissionMapperTest {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper mapper;

    @Test
    public void selectAllByRoleCode() {
        Set<String> roles = roleMapper.selectAllByUsername("zhangsan", StudentColumn.STUDENT_TABLE, StudentColumn.STU_ID, 3);
        Set<String> pers = mapper.selectAllByRoleCode(roles);
        pers.forEach(System.out::println);
    }
}