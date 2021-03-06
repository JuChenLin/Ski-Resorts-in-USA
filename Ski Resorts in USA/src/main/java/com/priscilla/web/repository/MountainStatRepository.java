package com.priscilla.web.repository;

import com.priscilla.web.entity.skiresort.MountainStat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MountainStatRepository extends JpaRepository<MountainStat, Integer> {
}
