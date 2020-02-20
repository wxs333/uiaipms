package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 学生 视图控制器
 *
 * @author WXS
 * @date 2020/2/18
 */
@Controller
@RequestMapping("stu")
public class StudentWebController {
    /**
     * 视图前缀
     */
    private static final String PREFIX = "student/";

    /**
     * 基本信息
     *
     * @return 视图
     */
    @GetMapping("info")
    public String info() {
        return PREFIX + "info";
    }
}
