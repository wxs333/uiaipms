package cn.edu.cdu.wxs.uiaipms.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * ftp文件上传下载 工具类
 *
 * @author WXS
 * @date 2020/2/26
 */
public class FtpUtils {
    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(FtpUtils.class);

    /**
     * 获取一个已连接的FTPClient
     *
     * @param host     IP地址
     * @param port     端口
     * @param username 用户名
     * @param password 密码
     * @return FTPClient
     */
    private static FTPClient getFtpClient(String host, int port, String username, String password) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(host, port);
            if (ftpClient.login(username, password)) {
                return ftpClient;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
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
        // 获取FTPClient
        FTPClient ftpClient = getFtpClient(host, port, username, password);
        try {
            // FTPClient连接服务器成功
            if (!ObjectUtils.isEmpty(ftpClient)) {
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                // 切换到上传目录
                ftpClient.changeWorkingDirectory(path);
                // 文件上传
                boolean result = ftpClient.storeFile(filename, inputStream);
                if (result) {
                    logger.info("文件上传成功");
                }
                return result;
            }
        } catch (Exception e) {
            logger.info("文件上传失败：" + e);
            return false;
        } finally {
            close(ftpClient);
        }
        logger.info("服务器连接失败");
        return false;
    }

    /**
     * 文件下载
     *
     * @param host         IP地址
     * @param port         端口
     * @param username     用户名
     * @param password     密码
     * @param path         路径
     * @param outputStream 输出流
     */
    public static void download(String host, int port, String username, String password, String path, OutputStream outputStream) {
        // 获取FTPClient
        FTPClient ftpClient = getFtpClient(host, port, username, password);
        try {
            if (!ObjectUtils.isEmpty(ftpClient)) {
                InputStream inputStream = ftpClient.retrieveFileStream(path);
                byte[] bytes = new byte[1024];
                while ((inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes);
                }
            }
        } catch (Exception e) {
            logger.info("下载文件失败");
        } finally {
            close(ftpClient);
        }
    }

    /**
     * 获取文件输入流
     * @param host         IP地址
     * @param port         端口
     * @param username     用户名
     * @param password     密码
     * @param path         路径
     * @return 输入流
     */
    public static InputStream download(String host, int port, String username, String password, String path) {
        // 获取FTPClient
        FTPClient ftpClient = getFtpClient(host, port, username, password);
        InputStream inputStream = null;
        try {
            if (!ObjectUtils.isEmpty(ftpClient)) {
                inputStream = ftpClient.retrieveFileStream(path);
            }
        } catch (Exception e) {
            logger.info("获取文件输入流失败");
        } finally {
            close(ftpClient);
        }
        return inputStream;
    }


        /**
         * 关闭ftp服务器连接
         *
         * @param ftpClient ftp客户端
         */
    private static void close(FTPClient ftpClient) {
        try {
            ftpClient.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 私有构造方法，禁止实例化
     */
    private FtpUtils() {
    }
}
