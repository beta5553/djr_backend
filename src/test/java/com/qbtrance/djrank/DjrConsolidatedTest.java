package com.qbtrance.djrank;

import com.qbtrance.djrank.dao.Biography;
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
import java.util.List;

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
    public void createFullUserTest() {
        logger.info("createFullUserTest start");
        User user = createUser();

        //Adding one biography.
        Biography bioEn = new Biography();
        bioEn.setLang("EN");
        bioEn.setBiography("Test user biography.");
        user.addBiography(bioEn);

        Biography bioSp = new Biography();
        bioSp.setLang("SP");
        bioSp.setBiography("Prueba de biografia del usuario user");
        user.addBiography(bioSp);

        userRepository.save(user);

        logger.info("createFullUserTest end");
    }

    public User createUser() {
        User user = new User();
        user.setLastName("Morales Lopez");
        user.setFirstName("izzy TEST");
        user.setAka("CX-1");
        user.setCountryBirth("Mexico");
        user.setCurrentCountry("USA");
        user.setDateBirth(new Date("10/27/1082"));
        user.setDj(true);
        user.setEmail("israel@qbtrance.com");
        user.setLabelId(1);
        user.setLogo("//temp//logos//logo.jpg");
        user.setPicture("//temp//images//picture.jpg");
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


    /**
     * This test will delete a user and also will delete all the biographies that are related to it.
     */
    @Test
    public void deleteConsolidatedUser(){
        logger.info("deleteConsolidatedUser starts");
        List<User> userList = userRepository.findByUserId(43);

        if (userList != null)
            for (User user : userList){

                logger.info("User found: " + user.getUserId());
                logger.info("Preparing to delete user and its dependencies");

                userRepository.delete(user);
            }

        logger.info("deleteConsolidatedUser ends");
    }

    @Test
    public void printAllUsers(){
        logger.info("printAllUser starts");
        List<User> userList = (List<User>) userRepository.findAll();
        userList.forEach(user -> System.out.println(user.getFirstName()));

        for(User user : userList){
            System.out.println("user id" + user.getUserId());

            for(Biography bio : user.getBiographyList()){
                System.out.println("Printing bio list for user " + user.getUserId());
                System.out.println("Biography" + bio.getLang());
                System.out.println("Biography" + bio.getBiography());
            }
        }

        logger.info("printAllUser ends");
    }

}
