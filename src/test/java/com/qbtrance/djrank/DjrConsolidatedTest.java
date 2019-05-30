package com.qbtrance.djrank;

import com.qbtrance.djrank.dao.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
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
     * DJK
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
        bioEn.setBiography("Test user biography. X");
        user.addBiography(bioEn);

        Biography bioSp = new Biography();
        bioSp.setLang("SP");
        bioSp.setBiography("Prueba de biografia del usuario user X");
        user.addBiography(bioSp);

        Label label = new Label();
        label.setCountry("UK");
        label.setDescription("Label from UK");
        label.setEmail("label@email.com");
        label.setLabelManager("Israel Morales");
        label.setLabelName("qbtrance UK records");
        label.setLogo("No logo");
        user.addLabel(label);

        Image image = new Image();
        image.setImageCategory("profile");
        image.setImageName("Profiles");
        image.setImageFile("file location");
        user.addImage(image);

        Link link = new Link();
        link.setDescription("SouundCloud link");
        link.setEmbededCode("Some code here");
        link.setMusicLink(true);
        link.setEventLink(true);
        link.setLinkName("soundcloud");
        link.setUrl("link URL here");
        user.addLink(link);

        Vote vote = new Vote();
        vote.setVotedLabelId(12);
        vote.setVotedUserId(42);
        user.addVote(vote);

        Vote vote1 = new Vote();
        vote1.setVotedLabelId(12);
        vote1.setVotedUserId(42);
        user.addVote(vote1);

        Vote vote2 = new Vote();
        vote2.setVotedLabelId(12);
        vote2.setVotedUserId(42);
        user.addVote(vote2);

        Vote vote3 = new Vote();
        vote3.setVotedLabelId(12);
        vote3.setVotedUserId(42);
        user.addVote(vote3);

        Preferences prefs = new Preferences();
        prefs.setBgColor("ORANGE");
        user.addPreferences(prefs);

        userRepository.save(user);

        logger.info("createFullUserTest end");
    }

    public User createUser() {
        User user = new User();
        user.setLastName("Morales Lopez");
        user.setFirstName("izzy TEST X");
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
        User user = userRepository.findByUserId(43);

        if (user != null) {
                logger.info("User found: " + user.getUserId());
                logger.info("Preparing to delete user and its dependencies");
                userRepository.delete(user);
            }

        logger.info("deleteConsolidatedUser ends");
    }

    @Test
    @Transactional
    public void printAllUsers()
    {
        logger.info("printAllUser starts");
        List<User> userList = (List<User>) userRepository.findAll();
        userList.forEach(user -> System.out.println(user.getFirstName()));

        System.out.println("--");
        System.out.println("--");

        for(User user : userList){
            System.out.println("user id" + user.getUserId());
            System.out.println("User name" + user.getFirstName());

            for(Biography bio : user.getBiographyList()) {
                System.out.println("\nBiography info:");
                System.out.println("Biography" + bio.getLang());
                System.out.println("Biography" + bio.getBiography());
            }

            for(Image image : user.getImageSet()) {
                System.out.println("\nImage");
                System.out.println("Image category " + image.getImageCategory());
                System.out.println("Image name" + image.getImageName());
                System.out.println("" + image.getImageFile());
            }

            for (Label label : user.getLabelList()) {
                System.out.println("\nLabel info:");
                System.out.println("Label name" + label.getLabelName());
                System.out.println("Label description " + label.getDescription());
                System.out.println("label manager " + label.getLabelManager());
                System.out.println("label country" + label.getCountry());
                System.out.println("label email" + label.getEmail());
            }

            for(Link link : user.getLinkSet()){
                System.out.println("\nLink info:");
                System.out.println("Link Desc: " + link.getDescription());
                System.out.println("Link name " + link.getLinkName());
                System.out.println("Link url" + link.getUrl());
                System.out.println("Link embedded code:  " + link.getEmbededCode());
            }

            if (user.getPrefs()!=null) {
                System.out.println("\nPreferences: ");
                System.out.println("Background color: " + user.getPrefs().getBgColor());
            }

            for (Vote vote : user.getVoteList()){
                System.out.println("\nVotes");
                System.out.println("Voted label id: " + vote.getVotedLabelId());
                System.out.println("Voted user id: " + vote.getVotedUserId());
                System.out.println("Vote id: " + vote.getVoteId());
            }
        }

        logger.info("printAllUser all information and dependencies ends");
    }
}