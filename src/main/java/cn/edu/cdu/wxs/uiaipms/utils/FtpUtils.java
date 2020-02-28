package cn.edu.cdu.wxs.uiaipms.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.InputStream;

/**
 * ftp文件上传下载 工具类
 *
 * @author WXS
 * @date 2020/2/26
 */
public class FtpUtils {
    /**
     * ftp服务器客户端
     */
    private static FTPClient ftpClient = null;

    /**
     * 连接ftp服务器
     *
     * @param host     IP地址
     * @param port     端口
     * @param username 用户名
     * @param password 密码
     * @return true 成功 false 失败
     * @throws Exception 异常
     */
    private static boolean initFtpClient(String host, int port, String username, String password) throws Exception {
        ftpClient.connect(host, port);
        return ftpClient.login(username, password);
    }

    /**
     * 文件上传
     *
     * @param host        IP地址
     * @param port        端口
     * @param username    用户名
     * @param password    密码
     * @param path        上传路径
     * @param filename    文件名
     * @param inputStream 文件输入流
     * @return true 成功 false 失败
     */
    public static boolean upload(String host, int port, String username, String password, String path, String filename, InputStream inputStream) {
        try {
            // 成功连接服务器
            if (initFtpClient(host, port, username, password)) {
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                ftpClient.changeWorkingDirectory(path);
                // 开始上传
                return ftpClient.storeFile(filename, inputStream);
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * 私有构造方法，禁止实例化
     */
    private FtpUtils() {
    }
}
