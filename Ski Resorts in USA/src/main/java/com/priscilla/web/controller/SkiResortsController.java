package com.priscilla.web.controller;

import com.priscilla.web.entity.enumerate.PriceRange;
import com.priscilla.web.entity.enumerate.State;
import com.priscilla.web.entity.service.SkiResortService;
import com.priscilla.web.entity.skiresort.SkiResort;
import com.priscilla.web.parameter.SkiResortQueryParameter;
import com.priscilla.web.repository.SkiResortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ski-resorts", produces = MediaType.APPLICATION_JSON_VALUE)
public class SkiResortsController {

//    @Autowired
//    private SkiResortRepository skiResortRepository;

    @Autowired
    private SkiResortService skiResortService;



    // Get all ski resorts, go to list page
    @GetMapping
    public ResponseEntity<List<SkiResort>> readSkiResorts(@ModelAttribute SkiResortQueryParameter parameter, Model model) {
//        List<SkiResort> allSkiResorts = skiResortRepository.findAll();
//        model.addAttribute("resorts", skiResorts);

        List<SkiResort> skiResorts = skiResortService.getSkiResortsByQuery(parameter);
//        List<SkiResort> skiResorts = skiResortService.getSkiResortsAll();
        return ResponseEntity.ok().body(skiResorts);
    }

    // Get the ski resort by ID
    @GetMapping("/{id}")
    public ResponseEntity<SkiResort> readSkiResort(@PathVariable("id") Integer id) {
//        Optional<SkiResort> optionalSkiResort = Optional.ofNullable(skiResortRepository.findById(id).get());
//
//        return optionalSkiResort.map( skiResort -> ResponseEntity.ok().body(skiResort) )  //200 OK
//                .orElseGet( () -> ResponseEntity.notFound().build() );  //404 Not found

        SkiResort skiResort = skiResortService.getSkiResort(id);
        return ResponseEntity.ok().body(skiResort);
    }

//    @GetMapping()
//    public ResponseEntity<List<SkiResort>> searchSkiResorts(@ModelAttribute SkiResortQueryParameter parameter) {
//        String nameKeyword = parameter.getKeyword();
//        String orderBy = parameter.getOrderBy();
//        String sortRule = parameter.getSortRule();
//
//        Comparator<SkiResort> comparator = Objects.nonNull(orderBy) && Onjects.nonNull(sortRule)?
//                                           configureSortComparator(orderBy, sortRule) : (p1, p2) -> 0;
//
//        return ResponseEntity.ok().body(searchedSkiResorts);
//    }


////     Go to ski resort editing page
//    @GetMapping("/resort")
//    public String toEditPage(Model model) {
//        model.addAttribute("states", State.values());
//        model.addAttribute("priceRanges", PriceRange.values());
//        return "/skiresort/edit";
//    }
//

        // Create new ski resort
        @PostMapping
        public ResponseEntity<SkiResort> createSkiResort(@RequestBody SkiResort request) {
//            skiResortRepository.save(skiResort);

            SkiResort skiResort = skiResortService.saveSkiResort(request);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(skiResort.getId())
                    .toUri();

            return ResponseEntity.created(location).body(skiResort);
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

    // Soft delete ski resort
    @PutMapping("/{id}")
    public ResponseEntity<SkiResort> updateSkiResort(@PathVariable("id") Integer id, @RequestBody SkiResort request) {
//        Optional<SkiResort> optionalSkiResort = skiResortRepository.findById(id);
//
//        if (!optionalSkiResort.isPresent()) {
//            return ResponseEntity.notFound().build();  //404 Not found
//        }
//
//        SkiResort skiResort = optionalSkiResort.get();
//        skiResort.setName(request.getName());
//        skiResort.setWebsite(request.getWebsite());
//        skiResort.setPriceRange(request.getPriceRange());
//        skiResort.setAnnualSnowfall(request.getAnnualSnowfall());
//        skiResortRepository.save(skiResort);

        SkiResort skiResort = skiResortService.updateSkiResort(id, request);
        return ResponseEntity.ok().body(skiResort);  //200 OK
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id){
//        skiResortRepository.deleteById(id);

        skiResortService.deleteSkiResort(id);
        return ResponseEntity.noContent().build(); // 204 OK
    }

}
