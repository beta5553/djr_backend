package com.qbtrance.djrank.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "LABEL")
public class Label {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "LABEL_ID")
    private int labelId;
    @Column(name = "LABEL_NAME")
    private String labelName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "LABEL_MANAGER")
    private String labelManager;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "LOGO")
    private String logo;

}
