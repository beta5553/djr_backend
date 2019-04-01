package com.qbtrance.djrank.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;
import java.util.*;

@Slf4j
@Getter
@Setter
@ToString
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "AKA")
    private String aka;
    @Column(name = "IS_PRODUCER")
    private boolean isProducer;
    @Column(name = "IS_DJ")
    private boolean isDj;
    @Column(name = "IS_VJ")
    private boolean isVj;
    @Column(name = "IS_PROMOTER")
    private boolean isPromoter;
    @Column(name = "SHORT_DESC")
    private String shortDesc;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "DATE_BIRTH")
    private Date dateBirth;
    @Column(name = "CURRENT_COUNTRY")
    private String currentCountry;
    @Column(name = "COUNTRY_BIRTH")
    private String countryBirth;
    @Column(name = "PICTURE")
    private String picture;
    @Column(name = "LOGO")
    private String logo;
    @Column(name = "QRCODE")
    private String qrCode;
    @Column(name = "LABEL_ID")
    private int labelId;

    // Avoid lazy loading using FetchType.EAGER.
    @OneToMany(fetch = FetchType.EAGER, targetEntity=Biography.class, cascade = CascadeType.ALL)
    //@OneToMany(targetEntity=Biography.class)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = true)
    private List<Biography> biographyList;

    @OneToMany(targetEntity=Image.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = true)
    private Set<Image> imageSet;

    @OneToMany(targetEntity=Link.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = true)
    private Set<Link> linkSet;

    @OneToOne(targetEntity=Preferences.class)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = true)
    Preferences prefs;


   /**
     *
     * @param bio
     */
    public void addBiography(Biography bio) {
        if(bio != null) {
            if (biographyList == null) {
                biographyList = new ArrayList<>();
            }
            bio.setUser(this);
            biographyList.add(bio);
        }
    }

    /**
     * Adding images.
     * @param image
     */
    public void addImage(Image image) {
        if (image != null) {
            if (imageSet == null) {
                imageSet = new HashSet<>();
            }
            image.setUser(this);
            imageSet.add(image);
        }
    }

    public void addLink(Link link) {
        if (link != null) {
            if (linkSet == null) {
                linkSet = new HashSet<>();
            }
            link.setUser(this);
            linkSet.add(link);
        }
    }

}