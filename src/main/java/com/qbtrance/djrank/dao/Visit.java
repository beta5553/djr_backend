package com.qbtrance.djrank.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * This class will have no relationship with a user, it can be managed independently.
 * No relations, i will just inject data here.
 */

@Setter
@Getter
@Entity
@Table(name="VISIT")
public class Visit {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "VISIT_ID")
    private Integer visitId;

    @Column (name = "USER_ID")
    private Integer userId;

    @Column (name = "USER_IP")
    private String userIp;

    @Column (name = "TIMESTAMP")
    private Date timestamp;

}
