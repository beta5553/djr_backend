package com.qbtrance.djrank.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @Column(name = "IS_PERFORMER")
    private boolean isPerformer;
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
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = true)
    @JsonBackReference
    private List<Biography> biographyList;

    @OneToMany(targetEntity=Image.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = true)
    @JsonBackReference
    private Set<Image> imageSet;

    @OneToMany(targetEntity=Link.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = true)
    @JsonBackReference
    private Set<Link> linkSet;

    @OneToOne(targetEntity=Preferences.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = true)
    Preferences prefs;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name="user_label", joinColumns = @JoinColumn(name="user_id",referencedColumnName = "user_id"),
               inverseJoinColumns =@JoinColumn(name="label_id",referencedColumnName = "label_id"))
    @JsonBackReference
    List<Label> labelList;

    @OneToMany(targetEntity=Vote.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = true)
    @JsonBackReference
    private List<Vote> voteList;


    /**
     *
     * @param prefs
     */
    public void addPreferences(Preferences prefs){
        if (prefs != null){
            prefs.setUser(this);
            this.prefs = prefs;
        }
    }

    /**
     *
     * @param vote
     */
    public void addVote(Vote vote){
        if (vote != null) {
            if (voteList == null){
                voteList = new ArrayList<>();
            }
            vote.setUser(this);
            voteList.add(vote);
        }
    }

    /**
     *
     * @param label
     */
    public void addLabel (Label label){
        if (label != null) {
            if (labelList==null){
                labelList = new ArrayList<>();
            }
            labelList.add(label);
        }
    }

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

    /**
     *
     * @param link
     */
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
