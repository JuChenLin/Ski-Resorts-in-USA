package com.priscilla.web.component;

import com.priscilla.web.entity.enumerate.UserRole;
import com.priscilla.web.entity.user.User;
import com.priscilla.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostConstruct {

    @Autowired
    UserService userService;

//    public void init () {
//        addFirstAdmin();
//    }

    @javax.annotation.PostConstruct
    public void addFirstAdmin () {

        System.out.println("Add 1st admin user");

        User user = new User("REG0000000000000", "admin@sk.com", "Admin", UserRole.ADMIN, "REG");
        System.out.println("PostConstruct ---> addFirstAdmin: " + user);

        userService.saveUser(user);
    }
}
