package com.priscilla.web.concrete;

import com.priscilla.web.entity.enumerate.PriceRange;
import com.priscilla.web.entity.enumerate.State;
import com.priscilla.web.entity.skiresort.SkiResort;
import com.priscilla.web.entity.user.User;
import com.priscilla.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;

@Component
public class AddModelAttributes {

    @Autowired
    UserService userService;

    public void modelOAuth2User (OAuth2User principal, Model model) {
        if(principal == null) return;
//        System.out.println("Login User:" + principal);

        String id = principal.getAttribute("sub");
        User user = userService.getUser(id);
        model.addAttribute("user", user);
    }

    public void modelSkiResorts (List<SkiResort> skiResorts, Model model) {
        if(skiResorts == null) return;
//        System.out.println("AddModelAttributes.modelSkiResorts --- > Resorts: " + skiResorts);
        model.addAttribute("resorts", skiResorts);
    }

    public void modelSkiResort (SkiResort skiResort, Model model) {
        if(skiResort == null) return;

        model.addAttribute("resort", skiResort);
    }

    public void modelSkiResortEnum (Model model) {
        model.addAttribute("states", State.values());
        model.addAttribute("priceRanges", PriceRange.values());
    }
}
