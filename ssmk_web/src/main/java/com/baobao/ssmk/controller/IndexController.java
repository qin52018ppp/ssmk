package com.baobao.ssmk.controller;
import com.baobao.ssmk.service.ILoginService;
import com.baobao.ssmk.service.IRedisService;
import com.baobao.ssmk.service.ITestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    public static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private ITestService testService;

    @RequestMapping("/s/onSubmit")
    public String onSubmit() {
        return "redirect:../login";
    }

    @RequestMapping("/account/s")
    public String account() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model,Long id) {
        model.addAttribute("user",testService.test(id));
        return "login";
    }
}
