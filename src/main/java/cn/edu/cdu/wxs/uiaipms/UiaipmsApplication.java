package cn.edu.cdu.wxs.uiaipms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author WXS
 * @date 2019/12/25
 */
@SpringBootApplication
@MapperScan("cn.edu.cdu.wxs.uiaipms.mapper")
public class UiaipmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UiaipmsApplication.class, args);
    }

}
