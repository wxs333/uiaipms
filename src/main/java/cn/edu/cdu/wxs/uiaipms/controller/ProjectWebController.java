package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目 视图控制器
 *
 * @author WXS
 * @date 2020/2/25
 */
@Controller
@RequestMapping("pro")
public class ProjectWebController {
    /**
     * 视图前缀
     */
    private static final String PREFIX = "project/";

    /**
     * 项目申报
     *
     * @return 视图
     */
    @GetMapping("sb")
    public String sb() {
        return PREFIX + "project_sb";
    }
}
