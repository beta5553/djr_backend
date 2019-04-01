package com.qbtrance.djrank.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LinkRepository extends CrudRepository <Link, Integer> {

    List<Link> findByLinkId(Integer linkId);
    List<Link> findByUserId(Integer userId);

}
