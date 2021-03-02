package com.priscilla.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("email") String user,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session) {
        session.setAttribute("loginUser", user);

        if (!StringUtils.isEmpty(user) && password.equals("admin")) {
            return "redirect:/resorts";
//            return "redirect:/favorite";
        } else {

            map.put("msg", "username or password not correct");
            return "login";

        }
    }
}
