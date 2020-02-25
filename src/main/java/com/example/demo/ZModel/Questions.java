package com.example.demo.ZModel;


import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Time;

@Entity
@Table
public class Questions {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String question;

    @Column
    @Nullable
    private String email; // the eamil of quesrioner
    @Column
    private Time time;
    @ManyToOne
    private User user;


    public Long getId() {
        return id;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
