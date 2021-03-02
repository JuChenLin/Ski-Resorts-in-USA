package com.priscilla.web.entities.user;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

@Validated
public class Admin extends User {
    private static final String USER_RULE = "adm";
    private static Integer defaultIdNum = 1;

    public Admin(@Email String email, String username) {
        super((USER_RULE + String.format("%07d", defaultIdNum++)), email, username);
    }

    @Override
    public String toString() {
        return "Admin {" +
                "id='" + super.getId() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", username='" + super.getUsername() + '\'' +
                '}';
    }
}
