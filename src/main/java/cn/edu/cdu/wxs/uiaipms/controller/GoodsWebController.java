package cn.edu.cdu.wxs.uiaipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;

/**
 * 物品 视图控制层
 *
 * @author WXS
 * @date 2020/3/12
 */
@RequestMapping("goods")
@Controller
public class GoodsWebController {
    /**
     * 前缀
     */
    private static final String PREFIX = "goods/";

    /**
     * 列表
     *
     * @return 视图
     */
    @GetMapping("list")
    public String list() {
        return PREFIX + "list";
    }

    /**
     * 修改页面
     *
     * @param id id
     * @return 视图
     */
    @GetMapping("update")
    public ModelAndView update(@NotNull String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", id);
        modelAndView.setViewName(PREFIX + "update");
        return modelAndView;
    }

}
