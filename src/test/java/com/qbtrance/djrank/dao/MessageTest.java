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
public class MessageTest {

    private static final Logger logger = LoggerFactory.getLogger(MessageTest.class);

    @Autowired
    MessageRepository messageRepository;

    @Test
    public void createMessageTest() {
        logger.info("createMessageTest start");
        Message msg = new Message();

        msg.setMessage("Hola mensajes");
        msg.setToUserId(1);
        msg.setFromUserId(0);
        msg.setDeleted(false);

        messageRepository.save(msg);
        logger.info("createMessageTest end");
    }

    @Test
    public void editMessageTest() {
        logger.info("editMessageTest start");
        List<Message> msgList = messageRepository.findByMessageId(3);

        for(Message msg : msgList) {
            System.out.println("Editing: ");

            System.out.println("message:" + msg.getMessage());
            System.out.println("userId:" + msg.getToUserId());
            System.out.println("fromUserId:" + msg.getFromUserId());

            msg.setMessage("Hola mensajes EDITADO");
            msg.setToUserId(23);
            msg.setFromUserId(42);
            msg.setDeleted(true);

            messageRepository.save(msg);
        }

        logger.info("editMessageTest end");
    }

    @Test
    public void deleteMessageTest() {
        logger.info("deleteMessageTest start");
        List<Message> msgList = messageRepository.findByMessageId(4);

        for (Message msg : msgList) {
            System.out.println("Deleting: ");

            msg.getMessage();
            msg.getToUserId();
            msg.getFromUserId();

            messageRepository.delete(msg);
        }

        logger.info("deleteMessageTest end");
    }
}