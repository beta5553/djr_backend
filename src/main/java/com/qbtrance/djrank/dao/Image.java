package com.qbtrance.djrank.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table (name = "IMAGE")
public class Image {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "IMAGE_ID")
    private int imageId;

    // Foreang key.
    @Column(name = "USER_ID", insertable = false, nullable = true)
    private int userId;

    @Column (name = "IMAGE_NAME")
    private String imageName;
    @Column (name = "IMAGE_FILE")
    private String imageFile;
    @Column (name = "IMAGE_CATEGORY")
    private String imageCategory;

    @ManyToOne
    @JoinColumn (name = "user_id", insertable=false, updatable=false, nullable = true)
    @JsonBackReference
    private User user;

}
