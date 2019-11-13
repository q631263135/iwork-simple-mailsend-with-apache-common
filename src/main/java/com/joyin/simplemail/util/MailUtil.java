package com.joyin.simplemail.util;

import com.joyin.simplemail.config.MailConfig;
import javax.activation.MailcapCommandMap;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/11/12 11:52
 */
@Component
public class MailUtil {

    private static MailConfig mailConfig;

    public static void sendMail(String to) {
        SimpleEmail email = new SimpleEmail();
        email.setHostName(mailConfig.getHost());
        try {
            email.addTo(to);
            if (mailConfig.isIsqqmail()) {
                email.setAuthentication("631263135@qq.com", "yzzphxmztpukbbfd");
            }
            email.setFrom(mailConfig.getSendFrom());
            email.setDebug(true);
            email.setSubject("TEST");
            email.setMsg("TEST");
            email.send();
            email.setSSLCheckServerIdentity(true);
        } catch (EmailException ex) {
            ex.printStackTrace();
        }
    }

    @Autowired
    public void setMailConfig(MailConfig mailConfig) {
        this.mailConfig = mailConfig;
    }
}
