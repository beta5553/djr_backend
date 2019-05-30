package com.qbtrance.djrank;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DjrankBackendApplication {

    //Static block.
    {
        log.info(this.getClass().getName());
        log.info("Starting DJR app");
    }

    public static void main(String[] args) {
        SpringApplication.run(DjrankBackendApplication.class, args);
    }
}
