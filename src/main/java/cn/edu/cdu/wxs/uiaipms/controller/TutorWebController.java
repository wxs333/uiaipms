package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 导师 视图控制类
 *
 * @author WXS
 * @date 2020/4/10
 */
@Controller
@RequestMapping("tutor")
public class TutorWebController {
    /**
     * 前缀
     */
    private static final String PREFIX = "tutor/";

    /**
     * 基本资料
     *
     * @return 视图
     */
    @GetMapping("info")
    public String info() {
        return PREFIX + "info";
    }
}
