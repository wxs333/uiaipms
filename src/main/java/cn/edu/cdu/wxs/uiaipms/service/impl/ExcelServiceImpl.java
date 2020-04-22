package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.edu.cdu.wxs.uiaipms.service.ExcelService;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * Excel导入导出 业务层实现类
 *
 * @author WXS
 * @date 2020/3/12
 */
@Service
public class ExcelServiceImpl<T> implements ExcelService<T> {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(ExcelService.class);

    @Override
    public void export(String title, String sheetName, List<T> data, Class clazz, HttpServletResponse response) {
        // 获取工作簿
        ExportParams params = new ExportParams();
        params.setTitle(title);
        params.setSheetName(sheetName);
        params.setType(ExcelType.XSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(params, clazz, data);
        OutputStream os = null;
        try {
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(sheetName + ".xlsx" , "utf-8"));
            // 浏览器不缓存
            response.addHeader("Pragma", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
            response.setDateHeader("expries", -1);
            os = response.getOutputStream();
            workbook.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            logger.info("数据导出出错：" + e.getMessage());
        }
    }
}
