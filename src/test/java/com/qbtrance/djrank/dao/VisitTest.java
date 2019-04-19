package com.qbtrance.djrank.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitTest {

    private Logger logger = LoggerFactory.getLogger(VisitTest.class);

    @Autowired
    VisitRepository visitRepository;

    @Test
    public void createVisitTest() {
        logger.info("createVisitTest start");
        Visit visit = new Visit();
        visit.setTimestamp(new Date("01/01/2019"));
        visit.setUserId(1);

        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("google.com", 80));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(socket.getLocalAddress());
        visit.setUserIp(socket.getLocalAddress().toString());
        visitRepository.save(visit);

        logger.info("createVisitTest end");
    }

    @Test
    public void updateVisitTest(){
        logger.info("updateVisitTest start");

        Visit visit = visitRepository.findByVisitId(1);

        if (visit != null) {

            System.out.println("Editing: ");
            System.out.println("Visit id:" + visit.getVisitId());
            System.out.println("Visit time:" + visit.getTimestamp());
            System.out.println("Visit ip:" + visit.getUserIp());

            visit.setUserIp("127.0.0.1");
            visitRepository.save(visit);
        }

        logger.info("updateVisitTest end");
    }

    @Test
    public void deleteVisitTest(){
        logger.info("deleteVisitTest start");

        Visit visit = visitRepository.findByVisitId(1);
        if (visit != null) {

            System.out.println("Deleting: ");
            System.out.println("Visit id:" + visit.getVisitId());
            System.out.println("Visit time:" + visit.getTimestamp());
            System.out.println("Visit ip:" + visit.getUserIp());

            visitRepository.delete(visit);
        }

        logger.info("deleteVisitTest end");
    }

}