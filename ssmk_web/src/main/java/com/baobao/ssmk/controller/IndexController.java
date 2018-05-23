package com.baobao.ssmk.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    public static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/s/onSubmit")
    public String onSubmit() {
        return "redirect:../login";
    }

    @RequestMapping("/account/s")
    public String account() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
