//package com.priscilla.web.repository.imp;
//
//import com.priscilla.web.entity.enumerate.UserRole;
//import com.priscilla.web.entity.user.User;
//import com.priscilla.web.repository.UserRepository;
//import com.priscilla.web.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.PostConstruct;
//
//@Repository
//public abstract class UserRepositoryImp implements UserRepository {
//
//    @Autowired
//    UserService userService;
//
//    @PostConstruct
//    private void init(){
//        addFirstAdmin();
//    }
//
//    @PostConstruct
//    public void addFirstAdmin () {
//
//        System.out.println("Add 1st admin user");
//
//        User user = new User("REG0000000000000", "admin@sk.com", "Admin", UserRole.ADMIN, "REG");
//        System.out.println("PostConstruct ---> addFirstAdmin: " + user);
//
//        userService.saveUser(user);
//    }
//}
