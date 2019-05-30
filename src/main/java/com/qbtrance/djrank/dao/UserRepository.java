package com.qbtrance.djrank.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository <User, Integer> {

    User findByUserId(Integer userId);
    //List<User> findByUserId(Integer userId);

}
