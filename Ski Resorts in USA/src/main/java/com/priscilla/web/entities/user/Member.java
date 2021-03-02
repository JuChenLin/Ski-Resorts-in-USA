package com.priscilla.web.entities.user;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

@Validated
public class Member extends User {
    private static final String USER_RULE = "mem";
    private static Integer defaultIdNum = 1;

    public Member(@Email String email, String username) {

        super((USER_RULE + String.format("%07d", defaultIdNum++)), email, username);
    }

    @Override
    public String toString() {
        return "Member {" +
                "id='" + super.getId() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", username='" + getUsername() + '\'' +
                '}';
    }
}
