package com.priscilla.web.repository;

import com.priscilla.web.entity.skiresort.SkiResort;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkiResortRepositoryTest {

    @Autowired
    SkiResort skiResort;
    @Autowired
    SkiResortRepository skiResortRepository;


    @Test
    public void getSkiResort() {
        Optional<SkiResort> optionalSkiResort = skiResortRepository.findById(000001);
    }


}
