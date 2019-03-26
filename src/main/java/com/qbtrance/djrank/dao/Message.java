package com.qbtrance.djrank.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "MESSAGE")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "MESSEGE_ID")
    private int messageId;
    @Column(name = "FROM_USER_ID")
    private int fromUserId;
    @Column(name = "TO_USER_ID")
    private int toUserId;
    @Column(name = "MESSAGE")
    private String message;
    @Column(name = "IS_DELETED")
    private boolean isDeleted;

}
