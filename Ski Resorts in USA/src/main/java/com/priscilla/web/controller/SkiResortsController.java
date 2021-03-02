package com.priscilla.web.controller;

import com.priscilla.web.dao.SkiResortDao;
import com.priscilla.web.entities.skiresorts.PriceRange;
import com.priscilla.web.entities.skiresorts.SkiResort;
import com.priscilla.web.entities.skiresorts.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.Map;

@Controller
public class SkiResortsController {

    @Autowired
    private SkiResortDao skiResortDao;

    // Get all ski resorts, go to list page
    @GetMapping(value={"/", "/index", "resorts"})
    public String list(Model model) {
        Collection<SkiResort> skiResorts = skiResortDao.getAll();
        model.addAttribute("resorts", skiResorts);

        return "/skiresort/list";
    }

    // Go to ski resort editing page
    @GetMapping("/resort")
    public String toEditPage(Model model) {

        model.addAttribute("states", State.values());
        model.addAttribute("priceRanges", PriceRange.values());
        return "/skiresort/edit";
    }

    // Save ski resort info
    @PostMapping("/resort")
    public String addSkiResort(SkiResort skiResort) {
        System.out.println("Add ski resort: " + skiResort);

        skiResortDao.save(skiResort);

        // Come to ski resorts list
        // redirect:
        // forward:
        return "redirect:/resorts";
    }

    @GetMapping("/resort/{id}")
    public String toEditPage(@PathVariable("id") String id, Model model) {
        SkiResort skiResort = skiResortDao.get(id);

        model.addAttribute("resort", skiResort);
        model.addAttribute("states", State.values());
        model.addAttribute("priceRanges", PriceRange.values());

        return "/skiresort/edit";
    }

    @PutMapping("/resort")
    public String updateSkiResort(SkiResort skiResort) {
        System.out.println("Update ski resort: " + skiResort);

        skiResortDao.save(skiResort);

        // Come to ski resorts list
        // redirect:
        // forward:
        return "redirect:/resorts";
    }

    @DeleteMapping("/resort/{id}")
    public String deleteEmployee(@PathVariable("id") String id){
        skiResortDao.delete(id);
        return "redirect:/resorts";
    }

    // Go to ski resort detail page
    @GetMapping("/ski-resort/{id}")
    public String toDetailPage(@PathVariable("id") String id, Model model) {
        SkiResort skiResort = skiResortDao.get(id);

        model.addAttribute("resort", skiResort);
        model.addAttribute("states", State.values());
        model.addAttribute("priceRanges", PriceRange.values());
        return "/skiresort/detail";
    }
}
