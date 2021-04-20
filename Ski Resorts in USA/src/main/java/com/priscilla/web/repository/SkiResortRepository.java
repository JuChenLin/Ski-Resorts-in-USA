package com.priscilla.web.repository;

import com.priscilla.web.entity.skiresort.SkiResort;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkiResortRepository extends JpaRepository<SkiResort, Integer> {

    // Select All
    List<SkiResort> findAllOrderedById(Integer id);

    // Select not Deleted
    List<SkiResort> findByIsDeletedFalse();

    // Name Query
    List<SkiResort> findByNameContaining (String name, Sort sort);

    // priceRange Queries
    List<SkiResort> findByPriceRangeIs(String priceRange, Sort sort);

}
