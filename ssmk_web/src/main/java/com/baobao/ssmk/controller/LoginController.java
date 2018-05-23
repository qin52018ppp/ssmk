package com.baobao.ssmk.controller;
import com.baobao.ssmk.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "/login.json", method = RequestMethod.POST)
    @ResponseBody
    public Object login(String userName, String passwd) {
        LOGGER.info(String.format("username:%s,passwd:%s", userName, passwd));
        Object o= loginService.login(userName, passwd);
        return o;
    }
}
