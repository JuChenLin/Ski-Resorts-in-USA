package com.priscilla.web.controller;

import com.priscilla.web.entity.enumerate.PriceRange;
import com.priscilla.web.entity.enumerate.State;
import com.priscilla.web.service.SkiResortService;
import com.priscilla.web.entity.skiresort.SkiResort;
import com.priscilla.web.parameter.SkiResortQueryParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/ski-resorts", produces = MediaType.APPLICATION_JSON_VALUE)
public class SkiResortsController {

    @Autowired
    private SkiResortService skiResortService;

    // List ski resorts on listing page "/resorts" (template "list.html")
    @GetMapping
    public ResponseEntity<List<SkiResort>> readSkiResorts(@ModelAttribute SkiResortQueryParameter parameter, Model model) {
//        List<SkiResort> allSkiResorts = skiResortRepository.findAll();
//        model.addAttribute("resorts", skiResorts);

        List<SkiResort> skiResorts = skiResortService.getSkiResortsByQuery(parameter);
//        List<SkiResort> skiResorts = skiResortService.getSkiResortsAll();
        return ResponseEntity.ok().body(skiResorts);
    }

    // Show information of the ski resort of given id on showing page "/resorts/{id}" (template "detail.html")
    @GetMapping("/{id}")
    public ResponseEntity<SkiResort> readSkiResort(@PathVariable("id") Integer id) {
//        Optional<SkiResort> optionalSkiResort = Optional.ofNullable(skiResortRepository.findById(id).get());
//        return optionalSkiResort.map( skiResort -> ResponseEntity.ok().body(skiResort) )  //200 OK
//                .orElseGet( () -> ResponseEntity.notFound().build() );  //404 Not found

        SkiResort skiResort = skiResortService.getSkiResort(id);
        return ResponseEntity.ok().body(skiResort);
    }


    // Show no information on editing page "/resorts/edit" (template "edit.html")
    @GetMapping("/edit")
    public ResponseEntity<Model> toEditPage(Model model) {
        model.addAttribute("states", State.values());
        model.addAttribute("priceRanges", PriceRange.values());

//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/edit")
//                .build()
//                .toUri();

        return ResponseEntity.ok().body(model);
    }

    // Create a new ski resort
    // Then show information of this ski resort of given id on showing page "/resorts/{id}" (template "detail.html")
    @PostMapping
    public ResponseEntity<SkiResort> createSkiResort(@RequestBody SkiResort request, Model model) {
        SkiResort skiResort = skiResortService.saveSkiResort(request);
//        model.addAttribute("resort", skiResort);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                                  .path("/{id}")
                                                  .buildAndExpand(skiResort.getId())
                                                  .toUri();

        return ResponseEntity.created(location).body(skiResort);
    }

    // Show information of the ski resort of given id on editing page "/resorts/edit" (template "edit.html")
    @GetMapping("/edit/{id}")
    public ResponseEntity<Model> toEditPage(@PathVariable("id") Integer id, Model model) {
        SkiResort skiResort = skiResortService.getSkiResort(id);

        model.addAttribute("resort", skiResort);
        model.addAttribute("states", State.values());
        model.addAttribute("priceRanges", PriceRange.values());

        return ResponseEntity.ok().body(model);
    }

    // Update the ski resort of given id
    // Then show information of this ski resort of given id on showing page "/resorts/{id}" (template "detail.html")
    @PutMapping("/{id}")
    public ResponseEntity<SkiResort> updateSkiResort(@PathVariable("id") Integer id, @RequestBody SkiResort request) {

        System.out.println("Ski Resort Controller -- Request: " + request);
        SkiResort skiResort = skiResortService.updateSkiResort(id, request);
        return ResponseEntity.ok().body(skiResort);  //200 OK
    }

    // Soft delete ski resort
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id){
//        skiResortRepository.deleteById(id);

        skiResortService.deleteSkiResort(id);
        return ResponseEntity.noContent().build(); // 204 OK
    }

}
