package cn.edu.cdu.wxs.uiaipms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author WXS
 * @date 2019/12/25
 */
@SpringBootApplication
@MapperScan("cn.edu.cdu.wxs.uiaipms.mapper")
public class UiaipmsApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(UiaipmsApplication.class, args);
    }

}
