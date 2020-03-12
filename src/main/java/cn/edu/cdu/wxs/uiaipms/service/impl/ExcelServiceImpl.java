package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.edu.cdu.wxs.uiaipms.service.ExcelService;
import org.apache.poi.ss.usermodel.Workbook;
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

    @Override
    public void export(String title, String sheetName, List<T> data, Class clazz, HttpServletResponse response) {
        // 获取工作簿
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(title, sheetName), clazz, data);
        OutputStream os = null;
        try {
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(sheetName + ".xls", "utf-8"));
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
            os = response.getOutputStream();
            workbook.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
