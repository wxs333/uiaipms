package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.service.TutorService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TutorServiceImplTest {
    @Autowired
    private TutorService service;

    @Test
    public void getByUsername() {
        System.out.println(service.getByUsername("tutor1"));
    }

    @Test
    public void getAllToList() {
        System.out.println(service.getAllToList(new Page<>()).getRecords().size());
    }
}