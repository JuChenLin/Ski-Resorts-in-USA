package com.priscilla.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping
public class MainController {

    @RequestMapping({"/","/index"})
    public String index() {
        return "redirect:/ski-resorts";
    }
}
