package util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;
import java.util.Random;

/**
 * @Author YZ
 * @Date 2018/3/5
 */
public class Sendmail {
    public static void send(String email,String content){
        Properties p=new Properties();
        p.put("mail.smtp.host","smtp.smail.nju.edu.cn");
        p.put("mail.smtp.auth","true");
        Authenticator authenticator=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("151150072@smail.nju.edu.cn","Yz223344513?..,,");
            }
        };
        //获得一个带有authenticator的session实例
        Session sendMailSession = Session.getDefaultInstance(p,authenticator);
        Message mailMessage = new MimeMessage(sendMailSession);

        try {
            Address from = new InternetAddress("151150072@smail.nju.edu.cn");
            //设置发出方
            mailMessage.setFrom(from);
            Address to = new InternetAddress(email);//设置接收人员
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            mailMessage.setSubject("Training College ---验证---");//设置邮件标题
//            mailMessage.setText(captcha); //设置邮件内容
            mailMessage.setContent(content,"text/html;charset=utf-8");
            // 发送邮件
            Transport.send(mailMessage);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
