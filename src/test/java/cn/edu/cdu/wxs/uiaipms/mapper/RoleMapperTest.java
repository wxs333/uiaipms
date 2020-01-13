package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.column.StudentColumn;
import cn.edu.cdu.wxs.uiaipms.domain.Permission;
import cn.edu.cdu.wxs.uiaipms.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void selectAllByUserId() {
        System.out.println(roleMapper.selectAllByUsername("zhangsan", StudentColumn.STUDENT_TABLE, StudentColumn.STU_ID, 3).size());
    }
}