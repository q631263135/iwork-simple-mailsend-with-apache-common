package com.joyin.simplemail.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/11/11 10:13
 */
@Component
@PropertySource({"classpath:mail.properties"})
@Data
public class MailConfig {

    @Value("${mail.host}")
    private String host;

    @Value("${mail.port}")
    private int port;

    @Value("${mail.username}")
    private String username;

    @Value("${mail.password}")
    private String password;

    @Value("${mail.sendFrom}")
    private String sendFrom;

    @Value("${mail.sendName}")
    private String sendName;
    
    @Value("${isqqmail}")
    private boolean isqqmail;
}
