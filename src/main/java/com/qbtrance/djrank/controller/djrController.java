package com.qbtrance.djrank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class djrController {

    @GetMapping("/")
    public String djrStart(){
        return "Hellow DJR";
    }
}
