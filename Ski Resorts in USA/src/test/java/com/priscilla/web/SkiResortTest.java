package com.priscilla.web;

import com.priscilla.web.dao.SkiResortDao;
import com.priscilla.web.entities.skiresorts.PriceRange;
import com.priscilla.web.entities.skiresorts.SkiResort;
import com.priscilla.web.entities.skiresorts.State;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
class SkiResortTest {

//    @Autowired
//    SkiResort skiResort;

//    @Test
//    void testSkiResort01() {
//        System.out.println("--- Test SkiResort01");
//        skiResort.setId("CA00001");
//        skiResort.setName("Mammoth Mountain");
//        skiResort.setWebsite("https://www.mammothmountain.com/");
//        skiResort.setState(State.parse("CA"));
//        skiResort.setPriceRange(PriceRange.HIGH);
//        System.out.println(skiResort);
//    }
//
//    @Test
//    void testSkiResort02() {
//        System.out.println("--- Test SkiResort02");
//        System.out.println(skiResort);
//    }

    @Autowired
    SkiResortDao skiResortDao;

    @Test
    void testSkiResortDao() {
        System.out.println("--- Test SkiResortDao");
        for (SkiResort skiResort : skiResortDao.getAll()) {
            System.out.println(skiResort);
        }
    }
}
