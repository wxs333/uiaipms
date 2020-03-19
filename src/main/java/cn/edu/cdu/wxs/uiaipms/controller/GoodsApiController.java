package cn.edu.cdu.wxs.uiaipms.controller;

import cn.edu.cdu.wxs.uiaipms.constant.GlobalConstant;
import cn.edu.cdu.wxs.uiaipms.form.GoodsForm;
import cn.edu.cdu.wxs.uiaipms.result.JsonResult;
import cn.edu.cdu.wxs.uiaipms.service.ExcelService;
import cn.edu.cdu.wxs.uiaipms.service.GoodsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 物品 数据控制层
 *
 * @author WXS
 * @date 2020/3/10
 */
@RestController
@RequestMapping("api/goods")
public class GoodsApiController extends BaseController {

    @Autowired
    private GoodsService service;
    @Autowired
    private ExcelService<GoodsForm> excelService;

    /**
     * 获取所有物品的ID，名称
     *
     * @return json
     */
    @GetMapping("getAllGoods")
    public JsonResult<List<GoodsForm>> getAllGoods() {
        return jsonResult(service.getAllGoods());
    }

    /**
     * 入库
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("add")
    public JsonResult<String> add(GoodsForm form) {
        String adminId = "e7a185e5074741b385d3615d41a92038";
        if (service.add(form, adminId)) {
            return jsonResult("入库成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "发生错误，请与系统管理员联系");
    }

    /**
     * 根据ID获取货物信息
     *
     * @param id ID
     * @return json
     */
    @GetMapping("getOne")
    public JsonResult<GoodsForm> getOne(@NotNull String id) {
        return jsonResult(service.getById(id));
    }

    /**
     * 查看设备
     *
     * @param studId 工作室id
     * @return json
     */
    @GetMapping("seeGoods")
    public JsonResult<List<GoodsForm>> seeGoods(@NotNull String studId) {
        return jsonResult("0", service.getGoodsByStudId(studId));
    }

    /**
     * 分页获取所有物品
     *
     * @param page 分页
     * @return json
     */
    @GetMapping("list")
    public JsonResult<IPage<GoodsForm>> list(Page<GoodsForm> page) {
        return jsonResult("0", service.getByPage(page));
    }

    /**
     * 修改
     *
     * @param form 表单
     * @return json
     */
    @PostMapping("update")
    public JsonResult<String> update(GoodsForm form) {
        form.setUpdateTime(LocalDateTime.now());
        if (service.modifyById(form)) {
            return jsonResult("修改成功");
        }
        return jsonResult(GlobalConstant.FAILURE, "发生错误，请与系统管理员联系");
    }

    /**
     * 数据导出
     *
     * @param response 响应
     */
    @GetMapping("export")
    public void export(HttpServletResponse response) {
        // 获取数据
        List<GoodsForm> data = service.getList();
        // 数据导出
        excelService.export("物品列表", "物品列表", data, GoodsForm.class, response);
    }

    /**
     * 获取某个工作室的设备及其数量
     *
     * @param studId 工作室id
     * @return json
     */
    @GetMapping("details")
    public JsonResult<List<GoodsForm>> details(@NotNull String studId) {
        return jsonResult(service.getGoodsAndNumByStudId(studId));
    }

}
