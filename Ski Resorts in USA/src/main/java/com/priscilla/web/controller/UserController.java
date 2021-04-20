package com.priscilla.web.controller;


import com.priscilla.web.entity.enumerate.PriceRange;
import com.priscilla.web.entity.enumerate.State;
import com.priscilla.web.entity.skiresort.SkiResort;
import com.priscilla.web.entity.user.User;
import com.priscilla.web.parameter.SkiResortQueryParameter;
import com.priscilla.web.parameter.UserQueryParameter;
import com.priscilla.web.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping
public class UserController {

    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> readUsers(@ModelAttribute UserQueryParameter parameter, Model model) {
        System.out.println("readUsers method executed!");
        List<User> users = userService.getUsersByQuery(parameter);

        System.out.println("Resorts in Controller: " + users);
        model.addAttribute("resorts", users);

        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> readUser(@PathVariable("id") String id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User request) {
        User user = userService.saveUser(request);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                                  .path("/{id}")
                                                  .buildAndExpand(user.getId())
                                                  .toUri();

        return ResponseEntity.created(location).body(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User request) {
        userService.updateUser(id, request);
        User user = userService.getUser(id);
        return ResponseEntity.ok().body(user);  //200 OK
    }

    // Soft delete ski resort
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build(); // 204 OK
    }

}
