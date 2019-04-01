package com.qbtrance.djrank.dao;

import org.springframework.data.repository.CrudRepository;


public interface VisitRepository extends CrudRepository<Visit, Integer> {

    Visit findByVisitId(Integer visitId);

}
