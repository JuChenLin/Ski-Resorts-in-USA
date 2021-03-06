package com.priscilla.web.entity.user;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Validated
//@Entity
//@Table(name = "Member")
public class Member extends User {
    private static final String USER_ROLE = "mem";

    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer idNum;
    private static Integer defaultIdNum = 1;

    public Member(@Email String email, String username) {

        super((USER_ROLE + String.format("%07d", defaultIdNum++)), email, username);

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
