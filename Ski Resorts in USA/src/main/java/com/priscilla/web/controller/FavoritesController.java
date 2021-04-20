package com.priscilla.web.controller;


import com.priscilla.web.entity.user.User;
import com.priscilla.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class FavoritesController {

    @Autowired
    UserService userService;

    @GetMapping("/my-favorites")
    @ResponseBody
    public User readFavorites(@AuthenticationPrincipal OAuth2User principal) {
        System.out.println("Login User: " + principal);

        String userId = principal.getAttribute("sub");
        List<Integer> favorites = userService.getUser(userId).getFavorites();
        System.out.println("User's favorites list: " + favorites);

        return userService.getUser(userId);
    }

    @PutMapping("/my-favorites/{id}")
    public String addFavorites(@AuthenticationPrincipal OAuth2User principal, @PathVariable("id") Integer skiResortId) {
        System.out.println("skiResortId: " + skiResortId);

        String userId = principal.getAttribute("sub");
        User user = userService.getUser(userId);

        System.out.println("Before adding ski resort to favorites: " + user.getFavorites());
        user.getFavorites().add(skiResortId);
        System.out.println("After adding ski resort to favorites: " + user.getFavorites());

        System.out.println("User: " + user);

        userService.updateUser(userId, user);

        return "redirect:/my-favorites";
//        return user;
    }

//    @PostMapping("/favorites")
//    public ResponseEntity<User> createFavorites(@RequestBody Favorites favorites) {
//        User user = userService.saveUser(request);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(user.getId())
//                .toUri();
//
//        return ResponseEntity.created(location).body(user);
//    }
}
