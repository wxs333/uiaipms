package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
     * @param model  数据模型
     * @param userId 用户id
     * @return 视图
     */
    @GetMapping("info")
    public String info(Model model, String userId) {
        model.addAttribute("userId", userId);
        return PREFIX + "info";
    }
}
