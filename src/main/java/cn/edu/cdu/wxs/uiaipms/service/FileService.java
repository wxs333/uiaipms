package cn.edu.cdu.wxs.uiaipms.service;

import java.io.InputStream;

/**
 * 文件 服务层接口
 * @author WXS
 * @date 2020/2/26
 */
public interface FileService {

    /**
     * 文件上传
     * @param path 上传路径
     * @param inputStream 问价输入流
     * @return true 成功 false 失败
     */
    boolean upload(String path, InputStream inputStream);

    /**
     * 文件上传
     * @param path 上传路径
     * @param fileName 文件名
     * @param inputStream 问价输入流
     * @return true 成功 false 失败
     */
    boolean upload(String path, String fileName, InputStream inputStream);
}
