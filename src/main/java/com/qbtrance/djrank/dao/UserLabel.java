package com.qbtrance.djrank.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "USER_LABEL")
public class UserLabel {

    /**
     * Not finished yet, missing to define relashionship between \
     * Label and User : Many to Many using spring data anotattions.
     */

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "USERLABEL_ID")
    private int userLabelId;

    @Column (name = "USER_ID")
    private int userId;

    @Column (name = "LABEL_ID")
    private int labelId;

}