//package com.priscilla.web.entity.user;
//
//import org.springframework.validation.annotation.Validated;
//
//import javax.validation.constraints.Email;
//
//@Validated
//public class Admin extends User {
//    private static final String USER_ROLE = "adm";
//    private static Integer defaultIdNum = 1;
//
//    public Admin(@Email String email, String username) {
//        super((USER_ROLE + String.format("%07d", defaultIdNum++)), email, username);
//    }
//
//    @Override
//    public String toString() {
//        return "Admin {" +
//                "id='" + super.getId() + '\'' +
//                ", email='" + super.getEmail() + '\'' +
//                ", username='" + super.getUsername() + '\'' +
//                '}';
//    }
//}
