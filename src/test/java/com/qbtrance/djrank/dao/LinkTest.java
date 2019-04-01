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
public class LinkTest {

    private static final Logger logger = LoggerFactory.getLogger(LinkTest.class);

    @Autowired
    LinkRepository linkRepository;

    /**
     *  TODO: This method is not insert the user id to the link, must likely will need to create the user and save it at the same time.
     */
    @Test
    public void createLinkTest() {
        logger.info("createLinkTest start");

        Link link = new Link();
        link.setUrl("link URL");
        link.setMusicLink(true); // its a music link
        link.setEventLink(false); //its event link (fb event or website event)
        link.setEmbededCode("EMBEDED CODE FOR PLUGINS");
        link.setDescription("SoundCloud description");
        link.setLinkName("SoundCloud");
        link.setUserId(42);
        linkRepository.save(link);

        logger.info("createLinkTest end");
    }

    @Test
    public void deleteLinkTest() {
        logger.info("createLinkTest start");
        List<Link> linkList = linkRepository.findByLinkId(1);

        for(Link link : linkList){
            System.out.println("Deleting: ");
            System.out.println("Link id" + link.getLinkId());
            System.out.println("Link desc" + link.getDescription());
            System.out.println("Link name" + link.getLinkName());
            linkRepository.delete(link);
        }

        logger.info("createLinkTest end");
    }

    /**
     * In order to update a link, the user field need to be populated with an actual user on the database.
     * It has to be linked with an existing user on the database.
     *
     */
    @Test
    public void updateLinkTest(){
        logger.info("updateLinkTest start");
        List<Link> linkList = linkRepository.findByLinkId(1);

        for(Link link : linkList){
            System.out.println("Updating: ");
            System.out.println("Link id" + link.getLinkId());
            System.out.println("Link desc" + link.getDescription());
            System.out.println("Link name" + link.getLinkName());

            link.setDescription("Description EDITED!");
            linkRepository.save(link);
        }

        logger.info("updateLinkTest end");
    }
}
