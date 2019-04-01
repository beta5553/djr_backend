package com.qbtrance.djrank.dao;

import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, Integer> {

    Vote findByUserId(Integer userId);
    Vote findByVoteId(Integer voteId);

}
