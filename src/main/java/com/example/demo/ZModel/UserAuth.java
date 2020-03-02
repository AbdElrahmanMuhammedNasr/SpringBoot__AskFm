package com.example.demo.ZModel;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table
public class UserAuth {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    @Email
    private String email;
    @Column
    private String password ;

    public Long getId() {
        return id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }
}
