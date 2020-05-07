package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.service.FtpService;
import cn.edu.cdu.wxs.uiaipms.utils.FtpUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件 服务层实现类
 *
 * @author WXS
 * @date 2020/2/26
 */
@Service
@PropertySource("classpath:/ftp.properties")
public class FtpServiceImpl implements FtpService {
    /**
     * 地址
     */
    @Value("${ftp.host}")
    private String host;
    /**
     * 端口
     */
    @Value("${ftp.port}")
    private Integer port;
    /**
     * 用户名
     */
    @Value("${ftp.username}")
    private String username;
    /**
     * 密码
     */
    @Value("${ftp.password}")
    private String password;


    @Override
    public boolean upload(String path, String fileName, InputStream inputStream) {
        return FtpUtils.upload(host, port, username, password, path, fileName, inputStream);
    }

    @Override
    public void download(String path, OutputStream outputStream) {
        FtpUtils.download(host, port, username, password, path, outputStream);
    }

    @Override
    public InputStream download(String path) {
        return FtpUtils.download(host, port, username, password, path);
    }

    @Override
    public boolean remove(String path) {
        return FtpUtils.remove(host, port, username, password, path);
    }
}
