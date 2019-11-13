package com.joyin.simplemail.controller;

import com.joyin.simplemail.util.ExceptionUtil;
import com.joyin.simplemail.util.MailUtil;
import java.io.IOException;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/11/11 10:20
 */
@Controller
@Log
@RequestMapping("/mailapi")
public class MailController {

    @GetMapping("/sendMail")
    public String sendMail(String receiver, Model mv) throws IOException {
        try {
            MailUtil.sendMail(receiver);
            mv.addAttribute("msg", "发送成功");
        } catch (Exception e) {
            mv.addAttribute("msg", "发送失败：" + ExceptionUtil.getStackTrace(e));
        }
        return "/sendMail";
    }

}
