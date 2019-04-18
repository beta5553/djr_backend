package com.qbtrance.djrank.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table (name = "VOTE")
public class Vote {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    @Column (name = "VOTE_ID")
    private Integer voteId;

    @Column (name = "USER_ID")
    private Integer userId;

    @Column (name = "VOTED_USER_ID")
    private Integer votedUserId;

    @Column (name = "VOTED_LABEL_ID")
    private Integer votedLabelId;

    @ManyToOne
    @JoinColumn (name = "user_id", insertable=false, updatable=false, nullable = true)
    private User user;

}
