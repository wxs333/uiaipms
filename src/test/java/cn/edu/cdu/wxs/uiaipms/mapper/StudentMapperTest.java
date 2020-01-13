package cn.edu.cdu.wxs.uiaipms.mapper;

import cn.edu.cdu.wxs.uiaipms.column.AdminColumn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentMapperTest {
    @Autowired
    private StudentMapper mapper;

    @Test
    public void selectPasswordByUsernameTest() {
        System.out.println(mapper.selectPasswordByUsername("admin1", AdminColumn.ADMIN_TABLE));
    }

}