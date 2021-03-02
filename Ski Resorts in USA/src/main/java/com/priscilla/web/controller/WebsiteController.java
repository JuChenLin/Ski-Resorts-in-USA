package com.priscilla.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WebsiteController {

//    @RequestMapping({"/","/index.html"})
//    public String index() {
//        return "index";
//    }
//    @ResponseBody
//    @RequestMapping("/hello")
//    public  String hello(){
//        return "Hello World";
//    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        map.put("hello", "Hello");
        //classpath:/templates/success.html
        return "success";
    }

}
