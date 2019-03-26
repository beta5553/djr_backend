package com.qbtrance.djrank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DjrankBackendApplication {

    private static final Logger logger = LoggerFactory.getLogger(DjrankBackendApplication.class);

    {
        logger.info(this.getClass().getName());
        logger.info("Starting DjRank app");
    }

    public static void main(String[] args) {
        SpringApplication.run(DjrankBackendApplication.class, args);
    }

}