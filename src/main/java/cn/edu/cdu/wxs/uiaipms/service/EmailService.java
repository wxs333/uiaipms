package cn.edu.cdu.wxs.uiaipms.service;

/**
 * 邮件服务 业务接口类
 *
 * @author WXS
 * @date 2020/3/27
 */
public interface EmailService {

    /**
     * 发送验证码邮件
     *
     * @param to 收件人
     * @return 验证码
     */
    String sendVerCodeEmail(String to);
}
