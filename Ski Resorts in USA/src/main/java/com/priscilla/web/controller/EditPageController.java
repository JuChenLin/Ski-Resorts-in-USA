package com.priscilla.web.controller;

import com.priscilla.web.entity.enumerate.PriceRange;
import com.priscilla.web.entity.enumerate.State;
import com.priscilla.web.entity.skiresort.Address;
import com.priscilla.web.entity.skiresort.SkiResort;
import com.priscilla.web.service.SkiResortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/ski-resort/edit")
public class EditPageController {

    @Autowired
    SkiResortService skiResortService;

    @PostMapping("/add-address")
    public String addAddress(SkiResort skiResort, Model model) {
        System.out.println("EditPageController --- add address method executed before skiResortService.");
        System.out.println("EditPageController --- input skiResort: " + skiResort);
        skiResortService.addEmptyAddressField(skiResort);
        System.out.println("EditPageController --- add address method executed after skiResortService..");
        System.out.println("EditPageController --- updated skiResort: " + skiResort);

        model.addAttribute("resort", skiResort);
//        model.addAttribute("stat", skiResort.getMountainStat());
        model.addAttribute("states", State.values());
        model.addAttribute("priceRanges", PriceRange.values());

//        return "redirect:/ski-resort/edit"; // returning the updated section
        return "/skiresort/edit :: addresses";
    }

//    @GetMapping("/addAddress")
//    public String getAddAddress() {
//        System.out.println("Controller add address get method executed.");
//        return "/skiresort/edit :: addresses"; // returning the updated section
//    }
}
