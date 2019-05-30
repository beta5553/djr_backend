package com.qbtrance.djrank.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "BIOGRAPHY")
public class Biography {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BIOGRAPHY_ID")
    private Integer biographyId;

    //REF_ID (Reference id can be used to store user biographies or Record Label biographies.
    @Column(name = "USER_ID", insertable = false, nullable = true)
    private Integer userId;

    @Column(name = "LANG")
    private String lang;

    @Column(name = "BIO")
    private String biography;

    @ManyToOne
    @JoinColumn (name = "user_id", insertable=false, updatable=false, nullable = true)
    @JsonBackReference
    private User user;

}