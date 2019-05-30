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
public class LabelTest {

    private static final Logger logger = LoggerFactory.getLogger(LabelTest.class);

    @Autowired
    LabelRepository labelRepository;

    @Test
    public void labelInsertTest(){
        logger.info("labelInsertTest starts");
        Label label = new Label();
        label.setCountry("Mexico");
        label.setDescription("qbCrew is a qbtrance branche");
        label.setEmail("info@qbtrance.com");
        label.setLabelManager("israel Morales");
        label.setLogo("logo file here");
        label.setLabelName("qbCrew");
        labelRepository.save(label);
        logger.info("labelInsertTest end.");
    }

    @Test
    public void labelDeleteByLabelIdTest() {
        logger.info("labelDeleteTest start");
        List<Label> labelList = labelRepository.findByLabelId(1);

        for (Label label : labelList) {
            System.out.println("Label id: " + label.getLabelId());
            System.out.println("Label id: " + label.getLabelName());
            System.out.println("Label id: " + label.getDescription());
            System.out.println("Label id: " + label.getLabelManager());
            System.out.println("deleting...");
            labelRepository.delete(label);
        }

        logger.info("labelDeleteTest end");
    }

    @Test
    public void labelUpdateByLabelIdTest(){
        logger.info("labelUpdateByLabelIdTest start");
        List<Label> labelList = labelRepository.findByLabelId(2);

        for (Label label : labelList) {
            System.out.println("Label id: " + label.getLabelId());
            System.out.println("Label id: " + label.getLabelName());
            System.out.println("Label id: " + label.getDescription());
            System.out.println("Label id: " + label.getLabelManager());
            System.out.println("deleting...");

            label.setDescription("This is an edited description");
            labelRepository.save(label);
        }

        logger.info("labelUpdateByLabelIdTest end");
    }
}