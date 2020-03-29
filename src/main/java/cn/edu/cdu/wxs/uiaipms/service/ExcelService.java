package cn.edu.cdu.wxs.uiaipms.service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Excel导入导出 业务层接口
 *
 * @author WXS
 * @date 2020/3/12
 */
public interface ExcelService<T> {
    /**
     * Excel表格导出
     *
     * @param title     标题
     * @param sheetName sheet标题
     * @param clazz     类型
     * @param data      数据
     * @param response  响应
     */
    void export(String title, String sheetName, List<T> data, Class clazz, HttpServletResponse response);
}
