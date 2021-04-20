package com.priscilla.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping
public class MainController {

    @RequestMapping({"/","/index.html"})
    public String index() {
        return "redirect:/ski-resorts";
    }

//    @ResponseBody
//    @RequestMapping("/hello")
//    public  String hello(){
//        return "Hello World";
//    }

//    @RequestMapping("/hello")
//    public @ResponseBody
//    String greeting() {
//        return "Hello, World";
//    }
//
//    @RequestMapping("/success")
//    public String success(Map<String,Object> map) {
//        map.put("hello", "Hello");
//        //classpath:/templates/success.html
//        return "success";
//    }

}
