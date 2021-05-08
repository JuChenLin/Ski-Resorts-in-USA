package com.priscilla.web.service;

import com.priscilla.web.entity.skiresort.Address;
import com.priscilla.web.entity.skiresort.MountainStat;
import com.priscilla.web.entity.skiresort.SkiResort;
import com.priscilla.web.entity.user.User;
import com.priscilla.web.exception.NotFoundException;
import com.priscilla.web.parameter.SkiResortQueryParameter;
import com.priscilla.web.repository.SkiResortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SkiResortService {

    @Autowired
    private SkiResortRepository skiResortRepository;


    public SkiResort saveSkiResort(SkiResort request) {
        System.out.println("Ski Resort Server: " + request);

        SkiResort skiResort = new SkiResort(request);

        skiResort.getMountainStat().setSkiResort(skiResort);
        skiResort.getAddress().setSkiResort(skiResort);

        return skiResortRepository.save(skiResort);
    }

    public SkiResort updateSkiResort(Integer id, SkiResort request) {
        SkiResort skiResort = skiResortRepository.findById(id)
                                                 .orElseThrow(() -> new NotFoundException("There's no such ski resort in database."));
        skiResort.setAll(request);

        return skiResortRepository.save(skiResort);
    }

    public void deleteSkiResort(Integer id) {
        skiResortRepository.deleteById(id);
    }

    public SkiResort getSkiResort(Integer id) {
        return skiResortRepository.findById(id)
                                  .orElseThrow(() -> new NotFoundException("There's no such ski resort."));
    }

    public List<SkiResort> getSkiResortsAll() {
        return skiResortRepository.findAll();
    }

    public List<SkiResort> getSkiResortsByQuery(SkiResortQueryParameter parameter) {
        String nameKeyword = Optional.ofNullable(parameter.getKeyword()).orElse("");
        String orderBy = parameter.getOrderBy();
        String sortRule = parameter.getSortRule();

        Sort sort = Sort.unsorted();
        if (Objects.nonNull(orderBy) && Objects.nonNull(sortRule)) {
            Sort.Direction direction = Sort.Direction.fromString(sortRule);
            sort = Sort.by(direction, orderBy);
//            sort = Sort.by(Sort.Order.asc("id"), Sort.Order.desc("annualSnowfall"));
        }

        return skiResortRepository.findByNameContaining(nameKeyword, sort);

//        List<SkiResort> resorts = skiResortRepository.findByNameContaining(nameKeyword, sort);
//        return  resorts;
    }

    public SkiResort createEmptyPerson() {
        SkiResort skiResort = new SkiResort();

        skiResort.setMountainStat(new MountainStat());
        skiResort.setAddress(new Address());

        return skiResort;
    }

//    public void addEmptyAddressField(SkiResort skiResort) {
//        System.out.println("SkiResortService --- add address method executed before adding addresses list to skiResort.");
//        System.out.println("SkiResortService --- input skiResort: " + skiResort);
//
//        if (skiResort.getAddresses() == null) {
//            skiResort.setAddresses(new ArrayList<Address>());
//        }
//        skiResort.getAddresses().add(new Address());
//        System.out.println("SkiResortService --- updated skiResort: " + skiResort);
//
//        System.out.println("SkiResortService --- add address method executed after adding addresses list to skiResort.");
//    }

}
