package com.ccw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/world")
    public String helloworld() {
        return "nacos-consumer: hello world!!!";
    }

}
