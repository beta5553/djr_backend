package com.qbtrance.djrank.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VoteTest {

    private Logger logger = LoggerFactory.getLogger(VoteTest.class);

    @Autowired
    VoteRepository voteRepository;


    /**
     * This test requires exisiting userUd, Existing voted label and existing voted user Id.
     *
     */
    @Test
    public void createVoteTest()
    {
        logger.info("createVoteTest start");
        Vote vote = new Vote();
        vote.setUserId(39);
        vote.setVotedLabelId(6);
        vote.setVotedUserId(500);
        voteRepository.save(vote);
        logger.info("createVoteTest end");
    }

    @Test
    public void updateVoteTest() {

    }

}
