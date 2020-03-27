package cn.edu.cdu.wxs.uiaipms.service.impl;

import cn.edu.cdu.wxs.uiaipms.service.EmailService;
import cn.edu.cdu.wxs.uiaipms.utils.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * 邮件服务 业务实现类
 *
 * @author WXS
 * @date 2020/3/27
 */
@Service
public class EmailServiceImpl implements EmailService {

    /**
     * 邮件发送对象
     */
    @Autowired
    private JavaMailSender mailSender;

    private final Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 发送邮件的邮箱
     */
    @Value("${spring.mail.username}")
    private String from;

    @Override
    public String sendVerCodeEmail(String to) {
        logger.info("发件人：" + from);
        SimpleMailMessage message = new SimpleMailMessage();
        // 获取验证码
        String code = SystemUtils.verificationCode();
        // 邮件主题以及内容模板
        String subject = "修改密码验证邮件";
        String content = "你的验证码是：" + code + "\r\n如果不是你本人的操作，请忽略此邮件！";
        // 邮件发送人
        message.setFrom(from);
        // 邮件接收人
        message.setTo(to);
        // 邮件主题
        message.setSubject(subject);
        // 邮件内容
        message.setText(content);
        try {
            // 发送
            mailSender.send(message);
            logger.info("邮件发送成功");
        } catch (Exception e) {
            logger.info("邮件发送失败");
        }
        return code;
    }
}
