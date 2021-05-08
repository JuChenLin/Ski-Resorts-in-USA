package com.priscilla.web.controller.admin;

import com.priscilla.web.concrete.AddModelAttributes;
import com.priscilla.web.entity.skiresort.SkiResort;
import com.priscilla.web.parameter.SkiResortQueryParameter;
import com.priscilla.web.service.SkiResortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/ski-resorts")
public class SkiResortAdminController {

    @Autowired
    private SkiResortService skiResortService;
    @Autowired
    private AddModelAttributes addModelAttributes;

    @GetMapping
    public String readSkiResorts (@AuthenticationPrincipal OAuth2User principal, @ModelAttribute SkiResortQueryParameter parameter, Model model) {
//        System.out.println("SkiResortsController ---> OAuth2User: " + principal);
        List<SkiResort> skiResorts = skiResortService.getSkiResortsByQuery(parameter);

        addModelAttributes.modelSkiResorts (skiResorts, model);
        addModelAttributes.modelOAuth2User(principal, model);
//        System.out.println("SkiResortsController ---> model: " + model);

//        return "/admin/list";
        return "/layout/base/list";
    }

    @GetMapping("/{id}")
    public String readSkiResort (@AuthenticationPrincipal OAuth2User principal, @PathVariable("id") Integer id, Model model) {
        SkiResort skiResort = skiResortService.getSkiResort(id);

        addModelAttributes.modelSkiResortEnum(model);
        addModelAttributes.modelSkiResort(skiResort, model);
        addModelAttributes.modelOAuth2User(principal, model);

        return "/admin/detail";
    }

    @GetMapping("/edit")
    public String toEditPage (@AuthenticationPrincipal OAuth2User principal, Model model) {
        addModelAttributes.modelSkiResortEnum(model);
        addModelAttributes.modelOAuth2User(principal, model);

        return "/admin/edit";
    }

    @PostMapping
    public String createSkiResort (SkiResort request, Model model) {
//        System.out.println("Create ski resort: " + request);
        SkiResort skiResort = skiResortService.saveSkiResort(request);

        return "redirect:/ski-resorts/" + skiResort.getId();
    }

    @GetMapping("/edit/{id}")
    public String toEditPage (@AuthenticationPrincipal OAuth2User principal, @PathVariable("id") Integer id, Model model) {
        SkiResort skiResort = skiResortService.getSkiResort(id);

        addModelAttributes.modelSkiResort(skiResort, model);
        addModelAttributes.modelSkiResortEnum(model);

        addModelAttributes.modelOAuth2User(principal, model);

        return "/admin/edit";
    }

    @PutMapping("/{id}")
    public String updateSkiResort (@PathVariable("id") Integer id, SkiResort request) {
//        System.out.println("Input ID: " + id);
//        System.out.println("Update ski resort ID " + request.getId() + ": " + request);
//        System.out.println("Update mountain stat ID " + request.getId() + ": " + request);
        SkiResort skiResort = skiResortService.updateSkiResort(id, request);

        return "redirect:/ski-resorts/" + id;
    }

    // Soft delete ski resort
    @DeleteMapping("/{id}")
    public String deleteEmployee (@PathVariable("id") Integer id){
        skiResortService.deleteSkiResort(id);

        return "redirect:/ski-resorts";
    }

}
