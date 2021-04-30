package com.priscilla.web.controller.archived;

import com.priscilla.web.entity.enumerate.PriceRange;
import com.priscilla.web.entity.enumerate.State;
import com.priscilla.web.entity.skiresort.SkiResort;
import com.priscilla.web.repository.SkiResortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/ski-resorts-html")
public class SkiResortsControllerHTML {

    @Autowired
    private SkiResortRepository skiResortRepository;

//     Get all ski resorts, go to list page
//    @GetMapping(value={"/", "/index", "resorts"})
    @GetMapping
    public String list(Model model) {
        List<SkiResort> listSkiResort = skiResortRepository.findAll();
        model.addAttribute("resorts", listSkiResort);

        return "/skiresort/list";
    }

//     Go to ski resort editing page
    @GetMapping("/edit")
    public String toEditPage(Model model) {
        model.addAttribute("states", State.values());
        model.addAttribute("priceRanges", PriceRange.values());
        return "/skiresort/edit";
    }

//     Save ski resort info
    @PostMapping
    public String addSkiResort(SkiResort skiResort) {
        System.out.println("Add ski resort: " + skiResort);

        skiResortRepository.save(skiResort);

        // Come to ski resorts list
        // redirect:
        // forward:
        return "redirect:/resorts";
    }

//    @GetMapping("/resort/{id}")
//    public String toEditPage(@PathVariable("id") String id, Model model) {
//        SkiResort skiResort = skiResortDao.get(id);
//
//        model.addAttribute("resort", skiResort);
//        model.addAttribute("states", State.values());
//        model.addAttribute("priceRanges", PriceRange.values());
//
//        return "/skiresort/edit";
//    }
//
//    @PutMapping("/resort")
//    public String updateSkiResort(SkiResort skiResort) {
//        System.out.println("Update ski resort: " + skiResort);
//
//        skiResortDao.save(skiResort);
//
//        // Come to ski resorts list
//        // redirect:
//        // forward:
//        return "redirect:/resorts";
//    }
//
//    @DeleteMapping("/resort/{id}")
//    public String deleteEmployee(@PathVariable("id") String id){
//        skiResortDao.delete(id);
//        return "redirect:/resorts";
//    }
//
//    // Go to ski resort detail page
//    @GetMapping("/ski-resort/{id}")
//    public String toDetailPage(@PathVariable("id") String id, Model model) {
//        SkiResort skiResort = skiResortDao.get(id);
//
//        model.addAttribute("resort", skiResort);
//        model.addAttribute("states", State.values());
//        model.addAttribute("priceRanges", PriceRange.values());
//        return "/skiresort/detail";
//    }
}
