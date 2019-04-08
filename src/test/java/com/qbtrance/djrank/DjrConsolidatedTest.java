package com.qbtrance.djrank;

import com.qbtrance.djrank.dao.User;
import com.qbtrance.djrank.dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DjrConsolidatedTest {

    private Logger logger = LoggerFactory.getLogger(DjrConsolidatedTest.class);

    @Autowired
    UserRepository userRepository;

    /*
     * Dual Jokey.
     * DJR Consolidate tests
     * Consolidate test, user creation with all its dependencies.
     *
     */

    @Test
    public void createFullUserTest()
    {
        logger.info("createFullUserTest start");
        User user = createUser();



        logger.info("createFullUserTest end");
    }

    public User createUser() {
        User user = new User();
        user.setLastName("Morales Lopez");
        user.setFirstName("izzy");
        user.setAka("CX-1");
        user.setCountryBirth("Mexico");
        user.setCurrentCountry("USA");
        user.setDateBirth(new Date("10/27/1082"));
        user.setDj(true);
        user.setEmail("israel@qbtrance.com");
        user.setLabelId(1);
        user.setLogo("LOGO.jpg");
        user.setPicture("Picture.jpg");
        user.setProducer(true);
        user.setPromoter(true);
        user.setQrCode("No QRCode supported yet");
        user.setShortDesc("IZZY CX-1, Psytrance DJ");
        return user;
    }

    @Test
    public void test(){
        assertEquals(1,1);
    }
}