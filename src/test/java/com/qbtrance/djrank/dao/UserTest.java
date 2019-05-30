package com.qbtrance.djrank.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    private static final Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Autowired
    UserRepository userRepository;

    @Test
    public void createNewUserTest() {
        logger.info("createNewUserTest start");
        userRepository.save(createUser());
        logger.info("createNewUserTest end");
    }

    @Test
    public void createNewUserWithBiographiesTest() {
        logger.info("createNewUserTest start");
        userRepository.save(createUserWithBiographies());
        logger.info("createNewUserTest end");
    }

    @Test
    public void createUserWithLabel(){

    }

    @Test
    public void deleteUserTest(){
        logger.info("deleteUserTest start");

        User user = userRepository.findByUserId(42);

        if (user != null){
                System.out.println("User to delete: " + user.getLastName());
                userRepository.delete(user);
            }

        logger.info("deleteUserTest end");
    }

    @Test
    public void editUserWithBioTest(){
        logger.info("editUserTest start");
        User user = userRepository.findByUserId(41);

        if(user != null){
                System.out.println("Editing user: " + user.getFirstName());
                user.setFirstName("Israel - Edited");
                user.setLastName("Morales - Edited");

                Biography bioEdit;

                for (Biography bio : user.getBiographyList()) {
                    bioEdit = bio;
                    System.out.println("Bio lang: " + bio.getLang());
                    System.out.println("Bio: " + bio.getBiography());
                }

                user.getBiographyList().get(0).setBiography("Edited biography 1");
                userRepository.save(user);
            }

        logger.info("editUserTest end");
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
        user.setPerformer(true);
        user.setQrCode("No QRCode supported yet");
        user.setShortDesc("IZZY CX-1, Psytrance DJ");
        return user;
    }

    public User createUserWithBiographies() {
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

        Biography bio = new Biography();
        bio.setLang("EN");
        bio.setBiography("BIOGRAPHY IN ENGLISH CX-1");
        user.addBiography(bio);

        bio = new Biography();
        bio.setLang("ES");
        bio.setBiography("BIOGRAFIA EN ESPAñOL CX-1");
        user.addBiography(bio);

        bio = new Biography();
        bio.setLang("FR");
        bio.setBiography("BIOGRAPHIE EN FRANÇAIS CX-1");
        user.addBiography(bio);

        return user;
    }
}