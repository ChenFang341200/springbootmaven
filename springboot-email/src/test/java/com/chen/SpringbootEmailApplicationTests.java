package com.chen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootEmailApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("主题：嘀嘀嘀");
        message.setText("这是测试内容");
        message.setTo("CHENCHEN039@huazhu.com");
        message.setFrom("985021765@qq.com");
        mailSender.send(message);

    }

    @Test
    public void Test1() throws  Exception{
        //创建复杂的邮件
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage,true);

        helper.setSubject("主题：代附件");
        helper.setText("<b style = 'color:red'>测试内容</b>",true);
        helper.setTo("CHENCHEN039@huazhu.com");
        helper.setFrom("985021765@qq.com");

        //上传文件
        helper.addAttachment("1.jpg",new File("C:\\Users\\chen\\Pictures\\Saved Pictures\\12.jpg"));
        mailSender.send(mimeMailMessage);
    }
}
