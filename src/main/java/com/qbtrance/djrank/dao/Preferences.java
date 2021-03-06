package com.qbtrance.djrank.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table (name = "PREFS")
public class Preferences {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "PREF_ID")
    private int preferenceId;

    @Column (name = "USER_ID")
    private int userId;

    @Column (name = "BG_COLOR")
    private String bgColor;

    @OneToOne
    @JoinColumn (name = "user_id", insertable=false, updatable=false, nullable = true)
    private User user;

}
