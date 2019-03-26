package com.qbtrance.djrank.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "LINK")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LINK_ID")
    private int linkId;

    // Foreang key.
    @Column(name = "USER_ID", insertable = false, nullable = true)
    private int userId;

    @Column(name = "LINK_NAME")
    private String linkName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "URL")
    private String url;
    @Column(name = "EMBEDED_CODE")
    private String embededCode;
    @Column(name = "IS_EVENT_LINK")
    private boolean isEventLink;
    @Column(name = "IS_MUSIC_LINK")
    private boolean isMusicLink;

    //One user can have more than one biography depending on the language).
    //user most be lower case or will cause an exception.
    @ManyToOne
    @JoinColumn (name = "user_id", insertable=false, updatable=false, nullable = true)
    private User user;

}
