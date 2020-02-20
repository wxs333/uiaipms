package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;


    @Test
    public void getByUsernameOrStuNo() {
        System.out.println(studentService.isExistByUsernameOrStuNo("student1", "2016104143249"));
    }

    @Test
    public void getByUsername() {
        System.out.println(studentService.getByUsername("student1"));
    }

    @Test
    public void getOneById() {
        System.out.println(studentService.getOneById("1fc437fc26b647109322e0e05c0efe5d"));
    }
}