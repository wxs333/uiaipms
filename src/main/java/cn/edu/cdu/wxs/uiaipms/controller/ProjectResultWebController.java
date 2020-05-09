package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目成果 视图控制类
 *
 * @author WXS
 * @date 2020/5/8
 */
@RequestMapping("res")
@Controller
public class ProjectResultWebController {
    /**
     * 前缀
     */
    private static final String PREFIX = "pro_result/";

    /**
     * 成果展示
     *
     * @return 视图
     */
    @RequestMapping("show")
    public String show() {
        return PREFIX + "show";
    }
}
