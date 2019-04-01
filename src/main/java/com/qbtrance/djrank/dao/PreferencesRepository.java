package com.qbtrance.djrank.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PreferencesRepository extends CrudRepository <Preferences, Integer> {

    List<Preferences> findByPreferenceId(Integer prefId);
    Preferences findByUserId(Integer userId);

}
