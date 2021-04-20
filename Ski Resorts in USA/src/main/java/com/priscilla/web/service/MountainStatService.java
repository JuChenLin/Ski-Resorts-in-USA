package com.priscilla.web.service;

import com.priscilla.web.entity.skiresort.MountainStat;
import com.priscilla.web.entity.skiresort.SkiResort;
import com.priscilla.web.exception.NotFoundException;
import com.priscilla.web.parameter.SkiResortQueryParameter;
import com.priscilla.web.repository.MountainStatRepository;
import com.priscilla.web.repository.SkiResortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MountainStatService {

    @Autowired
    private MountainStatRepository mountainStatRepository;

    public MountainStat saveMountainStat(MountainStat request) {
        MountainStat mountainStat = new MountainStat(request);
        return mountainStatRepository.save(mountainStat);
    }

    public MountainStat updateMountainStat(Integer id, MountainStat request) {
        MountainStat mountainStat = mountainStatRepository.findById(id)
                                                 .orElseThrow(() -> new NotFoundException("There's no such mountain stat in database."));
        mountainStat.setAll(request);

        return mountainStatRepository.save(mountainStat);
    }

//    public void deleteSkiResort(Integer id) {
//        skiResortRepository.deleteById(id);
//    }
//
//    public SkiResort getSkiResort(Integer id) {
//        return skiResortRepository.findById(id)
//                                  .orElseThrow(() -> new NotFoundException("There's no such ski resort."));
//    }
//
//    public List<SkiResort> getSkiResortsAll() {
//        return skiResortRepository.findAll();
//    }
//
//    public List<SkiResort> getSkiResortsByQuery(SkiResortQueryParameter parameter) {
//        String nameKeyword = Optional.ofNullable(parameter.getKeyword()).orElse("");
//        String orderBy = parameter.getOrderBy();
//        String sortRule = parameter.getSortRule();
//
//        Sort sort = Sort.unsorted();
//        if (Objects.nonNull(orderBy) && Objects.nonNull(sortRule)) {
//            Sort.Direction direction = Sort.Direction.fromString(sortRule);
//            sort = Sort.by(direction, orderBy);
//
////            sort = Sort.by(Sort.Order.asc("id"), Sort.Order.desc("annualSnowfall"));
//        }
//
//        return skiResortRepository.findByNameContaining(nameKeyword, sort);
//    }
}
