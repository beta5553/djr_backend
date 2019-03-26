package com.qbtrance.djrank;

import com.qbtrance.djrank.dao.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DjrankBackendApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(DjrankBackendApplicationTests.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    BiographyRepository bioRepository;

    @Autowired
    LabelRepository labelRepository;

    @Autowired
    LinkRepository linkRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    PreferencesRepository preferencesRepository;

    @Autowired
    ImageRepository imageRepository;


    @Test
    public void contextLoads() {
        logger.info("Something here");
    }

    @Test
    public void testUserInsertWithBiography() {
        logger.info("testUserInsert starts");
        User user = new User();
        user.setFirstName("Israel-test3");
        user.setLastName("Morales-test3");

        //Adding bio 1
        Biography bio = new Biography();
        bio.setLang("SP");
        bio.setBiography("Esta es mi bio en sp");
        user.addBiography(bio);

        //Adding bio 2
        Biography bio2 = new Biography();
        bio2.setLang("EN");
        bio2.setBiography("This is my bio in English");
        user.addBiography(bio2);

        //Adding bio 3
        Biography bio3 = new Biography();
        bio3.setLang("FR");
        bio3.setBiography("C'est ma bio en anglais");
        user.addBiography(bio3);

        Image image = new Image();
        image.setImageCategory("pics 1");
        image.setImageFile("some file here 1");
        image.setImageName("Foto de Izzy 1");
        user.addImage(image);

        Image image1 = new Image();
        image1.setImageCategory("pics 2");
        image1.setImageFile("some file here 2");
        image1.setImageName("Foto de Izzy 2");
        user.addImage(image1);

        Link link = new Link();
        link.setUrl("");

        userRepository.save(user);
        logger.info("User saved");
    }

    @Test
    public void testUserInsert()
    {
        logger.info("testUserInsert starts");
        User user = new User();
        user.setFirstName("Israel-test-userInsert1");
        user.setLastName("Morales-test-userInsert1");
        userRepository.save(user);
        logger.info("User saved");
    }


    /**
     * USE CAREFULLY!
     * THIS TEST WILL DELETE ALL THE RECORDS IN THE USER TABLE
     */
    @Test
    public void testUserDeleteAll() {
        userRepository.deleteAll();
    }

    /**
     * This is a child table, shouldn't have data that is not assigned to a user.
     */
   @Test
    public void testBiographyInsert() {
        logger.info("testBiographyInsert starts");
        Biography bio = new Biography();
        bio.setUserId(1);
        bio.setLang("EN");
        bio.setBiography("Biography here");
        bioRepository.save(bio);
        logger.info("testBiographyInsert saved.");
    }

    @Test
    public void testLabelInsert(){
        logger.info("testLabelInsert starts");
        Label label = new Label();
        label.setCountry("Mexico");
        label.setDescription("qbCrew is a qbtrance branche");
        label.setEmail("info@qbtrance.com");
        label.setLabelManager("israel Morales");
        label.setLogo("logo file here");
        label.setLabelName("qbCrew");
        labelRepository.save(label);
        logger.info("testLabelInsert saved.");
    }

    @Test
        public void testLinkInsert(){
            logger.info("testLabelInsert starts");
            Link link = new Link();
            link.setDescription("Link description");
            link.setEmbededCode("Embeded code");
            link.setEventLink(false);
            link.setMusicLink(true);
            link.setUrl("http://qbtrance.com");
            linkRepository.save(link);
            logger.info("testLabelInsert saved");
        }

        @Test
        public void testMessageInsert(){
        logger.info("testMessageInsert starts");
        Message msg = new Message();
        msg.setFromUserId(1);
        msg.setToUserId(2);
        msg.setMessage("Hola, este es un mensaje");
        messageRepository.save(msg);
        logger.info("testMessageInsert saved");
    }


    @Test
    public void testPreferencesInsert(){
        logger.info("testPreferencesInsert start");
        Preferences pref = new Preferences();
        pref.setPreferenceId(1);
        pref.setUserId(1);
        pref.setBgColor("RED");
        preferencesRepository.save(pref);
    }

    @Test
    public void testUserLabelInsert(){
        logger.info("testUserLabelInsert start");
        logger.info("testUserLabelInsert ");
    }

    /**
     * Individual table test.
     * */
    @Test
    public void testImageInsert(){
        logger.info("testUserLabelInsert start");
        Image image = new Image();
        image.setImageCategory("pics");
        image.setImageFile("some file here");
        image.setImageName("Foto de Izzy");
        image.setUserId(1);
        imageRepository.save(image);
        logger.info("testUserLabelInsert ");
    }
}

