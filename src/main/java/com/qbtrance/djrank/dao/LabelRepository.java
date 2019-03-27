package com.qbtrance.djrank.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LabelRepository extends CrudRepository <Label, Integer> {

    List<Label> findByLabelId(Integer labelId);

}
