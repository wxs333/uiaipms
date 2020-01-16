package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleServiceImplTest {

    @Autowired
    private RoleService service;

    @Test
    public void getList() {
        Set<String> set = new HashSet<>();
        set.add("student_role");
        System.out.println(service.getListRole());
    }
    @Test
    public void getRoleByUsername() {
        System.out.println(service.getRoleByUsername("tutor", "tutor1"));
    }
}