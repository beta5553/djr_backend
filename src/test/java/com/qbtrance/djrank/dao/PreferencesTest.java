package com.qbtrance.djrank.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PreferencesTest {

    private Logger logger = LoggerFactory.getLogger(PreferencesTest.class);

    @Autowired
    private PreferencesRepository preferencesRepository;

    @Test
    public void createPreferenceTest(){

        logger.info("createPreferenceTest start");
        Preferences prefs = new Preferences();
        prefs.setBgColor("BLACK");
        prefs.setUserId(32);
        preferencesRepository.save(prefs);
        logger.info("createPreferenceTest ends");
    }

    @Test
    public void updatePreferenceTest(){

        logger.info("updatePreferenceTest start");
        List<Preferences> prefList = preferencesRepository.findByPreferenceId(3);

        if (prefList != null)
            for(Preferences pref : prefList) {

                System.out.println("Editing: ");
                System.out.println(pref.getBgColor());
                System.out.println(pref.getUserId());

                pref.setBgColor("BLUE EDIT");
                preferencesRepository.save(pref);
            }

        logger.info("updatePreferenceTest ends");
    }

    @Test
    public void deletePreferenceTest() {

        logger.info("deletePreferenceTest start");
        List<Preferences> prefList = preferencesRepository.findByPreferenceId(3);

        if (prefList != null)
            for(Preferences pref : prefList) {
                System.out.println("Deleting: ");
                System.out.println(pref.getBgColor());
                System.out.println(pref.getUserId());

                preferencesRepository.delete(pref);
            }

        logger.info("deletePreferenceTest ends");
    }

}