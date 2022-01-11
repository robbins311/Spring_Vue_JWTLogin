package com.example.loginwithvue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class HomeController {

    @RequestMapping("/view")
    public int Login() {
        return 10;
    }

    @RequestMapping("/aView")
    public String authView() {
        return "aView";
    }


    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {return "hello";}


}
