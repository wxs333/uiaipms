package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.form.CompanyForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.CompanyService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业用户 数据控制层
 * @author WXS
 * @date 2020/1/19
 */
@RestController
@RequestMapping("api/com")
public class CompanyApiController extends BaseController {

    @Autowired
    private CompanyService service;

    /**
     * 分页获取所有信息
     * @param page 分页
     * @return 分页集合
     */
    @GetMapping("list")
    public JsonResult<IPage<CompanyForm>> list(Page<CompanyForm> page) {
        return jsonResult("0", service.getAllInfo(page));
    }
}
