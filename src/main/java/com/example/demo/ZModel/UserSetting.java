package com.example.demo.ZModel;


import javax.persistence.*;
import java.sql.Date;

//@Embeddable
@Entity
@Table
public class UserSetting {

    @Id
    @GeneratedValue
    private  Long id;
    @Column
    private  String location = "";
    @Column
    private String bio="";
    @Column
    private String [] anotherWebSites = new String[]{};
    @Column
    private String hashTags="";
    @Column
    private String userName;
    @Column
    private Date dateOfBirth;
    @Column
    private String gender;
    @Column
    private boolean [] privacyQuestion = new boolean[]{true,true,true,true};

//    @OneToOne
//    private User user ;



    //-------------------------------------------------

    public Long getId() {
        return id;
    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String[] getAnotherWebSites() {
        return anotherWebSites;
    }

    public void setAnotherWebSites(String[] anotherWebSites) {
        this.anotherWebSites = anotherWebSites;
    }

    public String getHashTags() {
        return hashTags;
    }

    public void setHashTags(String hashTags) {
        this.hashTags = hashTags;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean[] getPrivacyQuestion() {
        return privacyQuestion;
    }

    public void setPrivacyQuestion(boolean[] privacyQuestion) {
        this.privacyQuestion = privacyQuestion;
    }
}
