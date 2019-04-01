package com.qbtrance.djrank.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository <Message, Integer> {

    List<Message> findByMessageId(Integer MessageId);
}
