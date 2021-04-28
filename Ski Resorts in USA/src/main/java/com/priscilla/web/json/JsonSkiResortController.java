package com.priscilla.web.json;

import com.priscilla.web.entity.enumerate.PriceRange;
import com.priscilla.web.entity.enumerate.State;
import com.priscilla.web.entity.skiresort.SkiResort;
import com.priscilla.web.repository.SkiResortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/json/resort", produces = MediaType.APPLICATION_JSON_VALUE)
public class JsonSkiResortController {

    @Autowired
    SkiResortRepository skiResortRepository;

//    @GetMapping("/test/{id}")
//    public SkiResort getResort(@PathVariable("id") Integer id){
//        SkiResort get = skiResortRepository.findById(id).get();
//        return get;
//    }
//
//    @GetMapping("/test")
//    public SkiResort insertResort(SkiResort skiResort){
//        SkiResort save = skiResortRepository.save(skiResort);
//        return save;
//    }

    @GetMapping
    public String list(Model model) {
        List<SkiResort> listSkiResort = skiResortRepository.findAll();
        model.addAttribute("resorts", listSkiResort);

        return "/test/list";
    }

//    @GetMapping("/test/resort")
//    public String toEditPage(Model model) {
//        model.addAttribute("states", State.values());
//        model.addAttribute("priceRanges", PriceRange.values());
//        return "/skiresort/edit";
//    }
//
//    @PostMapping("/resort")
//    public String addSkiResort(SkiResort skiResort) {
//        System.out.println("Add ski resort: " + skiResort);
//
//        skiResortRepository.save(skiResort);
//
//        // Come to ski resorts list
//        // redirect:
//        // forward:
//        return "redirect:/resorts";
//    }
}
