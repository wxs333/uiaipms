package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.form.ProjectForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    /**
     * 个人申报的项目
     *
     * @return 视图
     */
    @GetMapping("myPro")
    public String myPro() {
        return PREFIX + "my_project";
    }

    /**
     * 项目重新申报页面
     *
     * @param form 表单
     * @return 视图
     */
    @GetMapping("afresh")
    public ModelAndView afresh(ProjectForm form) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("form", form);
        modelAndView.setViewName(PREFIX + "pro_afresh");
        return modelAndView;
    }
}
