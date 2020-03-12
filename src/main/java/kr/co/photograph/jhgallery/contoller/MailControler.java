package kr.co.photograph.jhgallery.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.internet.MimeMessage;

@Controller

public class MailControler {
    @Autowired
    JavaMailSender javaMailSender;

    @RequestMapping(value = "/sendmail", method = RequestMethod.POST)
    public String sendMail(String name, String eemail, String subject, String text) {
        final MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                helper.setFrom(eemail);
                helper.setTo("amapow25@gmail.com");
                helper.setSubject(subject + " from" + name);
                helper.setText(text);
            }
        };
        javaMailSender.send(preparator);
        return "/contact";
    }
}
