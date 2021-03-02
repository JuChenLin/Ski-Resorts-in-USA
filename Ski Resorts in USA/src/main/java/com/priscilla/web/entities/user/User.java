package com.priscilla.web.entities.user;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

@Validated
public abstract class User {
    private final String id;
    @Email
    private String email;
    private String username;

    public User(String id, @Email String email, String username) {
        this.id = id;
        this.email = email;
        this.username = username == null ? email : username;
    }

    public String getId() { return id; }

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
