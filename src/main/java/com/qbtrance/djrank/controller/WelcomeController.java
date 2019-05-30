package com.qbtrance.djrank.controller;

import com.qbtrance.djrank.service.WelcomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class WelcomeController {

    @Autowired
    WelcomeService welcomeService;

    @ResponseBody
    @GetMapping("/welcome")
    public void hello(Model model, HttpServletResponse response){
        model.addAttribute("user", "Izzy");
        log.info("model = {}", model);
        //return "Welcome jsp";
        try {
            response.sendRedirect("/welcome.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}