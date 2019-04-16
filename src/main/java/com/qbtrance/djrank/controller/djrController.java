package com.qbtrance.djrank.controller;

import com.qbtrance.djrank.dao.User;
import com.qbtrance.djrank.dao.UserRepository;
import com.qbtrance.djrank.service.WelcomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class djrController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserRepository userRepository;

    @Autowired
    WelcomeService welcomeService;

    // Redirect to index.html
    @GetMapping("/")
    public void djrStart(HttpServletResponse response) throws IOException {
        response.sendRedirect("/index.html");
    }

    @GetMapping("/getUsers")
    public List<User> getDjs()  {
        return (List<User>) userRepository.findByUserId(43);
    }


}