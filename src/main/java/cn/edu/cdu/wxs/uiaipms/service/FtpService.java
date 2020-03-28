package cn.edu.cdu.wxs.uiaipms.service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件 服务层接口
 *
 * @author WXS
 * @date 2020/2/26
 */
public interface FtpService {

    /**
     * 文件上传
     *
     * @param path        上传路径
     * @param fileName    文件名
     * @param inputStream 问价输入流
     * @return true 成功 false 失败
     */
    boolean upload(String path, String fileName, InputStream inputStream);

    /**
     * 文件下载
     * @param path 路径
     * @param outputStream  输出流
     */
    void download(String path, OutputStream outputStream);
}
