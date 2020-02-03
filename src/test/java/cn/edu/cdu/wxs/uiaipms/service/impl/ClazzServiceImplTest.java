package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.service.ClazzService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ClazzServiceImplTest {

    @Autowired
    private ClazzService service;

    @Test
    public void getAllByDiscId() {
        System.out.println(service.getAllByDiscId("f17283b04faa4a59a744d97a252162c1").size());
    }
}