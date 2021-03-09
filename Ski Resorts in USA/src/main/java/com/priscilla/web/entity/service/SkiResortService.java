package com.priscilla.web.entity.service;

import com.priscilla.web.dao.SkiResortDao;
import com.priscilla.web.entity.skiresort.SkiResort;
import com.priscilla.web.exception.NotFoundException;
import com.priscilla.web.parameter.SkiResortQueryParameter;
import com.priscilla.web.repository.SkiResortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SkiResortService {

//    @Autowired
//    private SkiResortDao skiResortDao;
    @Autowired
    private SkiResortRepository skiResortRepository;

    public SkiResort saveSkiResort(SkiResort request) {
        SkiResort skiResort = new SkiResort(request);
        return skiResortRepository.save(skiResort);
    }

    public SkiResort updateSkiResort(Integer id, SkiResort request) {
        SkiResort skiResort = skiResortRepository.findById(id)
                                                 .orElseThrow(() -> new NotFoundException("There's no such ski resort."));
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
//            Sort.Order order = Sort.Order.by(orderBy);
            sort = Sort.by(direction, orderBy);
        }

        return skiResortRepository.findByNameContaining(nameKeyword, sort);
    }
}
