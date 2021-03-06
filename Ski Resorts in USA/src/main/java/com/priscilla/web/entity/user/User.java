package com.priscilla.web.entity.user;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

//public abstract class User {
//
//    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private final String id;
//
//    @Email
//    @Column
//    private String email;
//
//    @Column
//    private String username;
//
//    protected User(String id) {
//        this.id = id;
//    }
//
//    public User(String id, @Email String email, String username) {
//        this(id);
//        this.email = email;
//        this.username = username == null ? email : username;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//}

@Validated
public abstract class User {

    private final String id;

    @Email
    private String email;
    private String username;

    protected User(String id) {
        this.id = id;
    }

    public User(String id, @Email String email, String username) {
        this(id);
        this.email = email;
        this.username = username == null ? email : username;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}