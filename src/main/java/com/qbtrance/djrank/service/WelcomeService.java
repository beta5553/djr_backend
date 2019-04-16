package com.qbtrance.djrank.service;

import org.springframework.stereotype.Service;

@Service
public interface WelcomeService {

    public String getWelcomeMessage(String user);
    public String getHelloMessage(String user);

}
