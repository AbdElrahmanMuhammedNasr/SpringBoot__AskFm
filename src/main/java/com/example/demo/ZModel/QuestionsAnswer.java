package com.example.demo.ZModel;


import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table
// this is post and answer in profile
public class QuestionsAnswer {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    @Nullable
    private String email ; // the questioner
    @Column
    private String answer;
    @Column
    private String question;
    @Column
    private Timestamp date;
    @ManyToOne
    private User user;



    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
