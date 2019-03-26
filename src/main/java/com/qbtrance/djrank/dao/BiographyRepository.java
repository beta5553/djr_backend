package com.qbtrance.djrank.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BiographyRepository extends CrudRepository<Biography, Integer> {

   List<Biography> findByUserId(Integer userId);

}
