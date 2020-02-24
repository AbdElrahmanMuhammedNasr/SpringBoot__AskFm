package com.example.demo.ZModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue
    private Long id;

//    @Lob
//    private  byte [] image ;
    @Column
    @Email
    private String email;
    @Column
    @Length(min = 5 , max = 15)
    private String fullName;

//    @Embedded
    @OneToOne(cascade = CascadeType.ALL)
    @Nullable
    private UserSetting userSetting;

    @Embedded
    @Nullable
    private UserProfile userProfile;




    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Friends> friends = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Questions> questions = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<QuestionsAnswer> questionsAnswers = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BlockList> blockList  = new ArrayList<>();



//----------------------------------------------------------------

    public Long getId() {
        return id;
    }

//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserSetting getUserSetting() {
        return userSetting;
    }

    public void setUserSetting(UserSetting userSetting) {
        this.userSetting = userSetting;
    }

    public List<Friends> getFriends() {
        return friends;
    }

    public void setFriends(List<Friends> friends) {
        this.friends = friends;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    public List<QuestionsAnswer> getQuestionsAnswers() {
        return questionsAnswers;
    }

    public void setQuestionsAnswers(List<QuestionsAnswer> questionsAnswers) {
        this.questionsAnswers = questionsAnswers;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public List<BlockList> getBlockList() {
        return blockList;
    }

    public void setBlockList(List<BlockList> blockList) {
        this.blockList = blockList;
    }


//    public void saveImageFile(MultipartFile file) throws Exception{
//
//            byte[] byteObjects = new byte[file.getBytes().length];
//            int i = 0;
//            for (byte b : file.getBytes()){
//                byteObjects[i++] = b;
//            }
//            setImage(byteObjects);
//
//    }


}




