package com.java017.tripblog.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author YuCheng
 * @date 2021/10/12 - 上午 02:07
 */

@Component
public class MailUtils {


    private JavaMailSender mailSender;

    @Autowired
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Value("${spring.mail.username}")
    private String author;

    //註冊驗證信件格式
    public String createMailVerificationContent(String userNickname, String verificationCode) {
        return "<html lang=\"utf-8\">"
                + "<body>"
                + "<h1>TripBlog 驗證信件</h1>"
                + "<div>"
                + "<p style=\"font-size: 14px\">Dear : " + userNickname + "</p>"
                + "<p style=\"font-size: 14px\">感謝您註冊會員，以下是您的驗證碼</p>"
                + "<p style=\"font-size: 16px\">"
                + verificationCode
                + "</p>"
                + "<br>"
                + "<p style=\"color: red;font-size: 12px\">請於五分鐘內完成驗證</p>"
                + "</div>"
                + "</body>"
                + "</html>";
    }

    //一般文件
    public void sendSimpleMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(author);
        message.setTo(to); //收件人
        message.setSubject(subject); //主題
        message.setText(text); //內容

        try {
            mailSender.send(message);
        } catch (MailException e) {
            System.out.println(e.getMessage());
        }
    }

    //HTML信件
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            //true創建一個multipart信件
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setFrom(author);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, true); //支援html格式開啟
            mailSender.send(message);

        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        }
    }
}
