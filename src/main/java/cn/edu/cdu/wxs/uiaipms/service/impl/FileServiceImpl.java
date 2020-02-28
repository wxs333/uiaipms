package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.service.FileService;
import cn.edu.cdu.wxs.uiaipms.utils.FtpUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.LocalDateTime;

/**
 * 文件 服务层实现类
 *
 * @author WXS
 * @date 2020/2/26
 */
@Service
@PropertySource("classpath:ftp.properties")
public class FileServiceImpl implements FileService {
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
    public boolean upload(String path, InputStream inputStream) {
        String fileName = LocalDateTime.now().toString();
        return upload(path, fileName, inputStream);
    }

    @Override
    public boolean upload(String path, String fileName, InputStream inputStream) {
        return FtpUtils.upload(host, port, username, password,path, fileName, inputStream);
    }
}
