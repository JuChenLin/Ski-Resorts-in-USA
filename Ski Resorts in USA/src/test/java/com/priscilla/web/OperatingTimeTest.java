package com.priscilla.web;

import com.priscilla.web.entities.skiresorts.DayOpeningTime;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;

@RunWith(SpringRunner.class)
@SpringBootTest
class OperatingTimeTest {

    @Autowired
    DayOpeningTime dayOpeningTime;

    @Test
    void testDayOpeningTime() {
        System.out.println("--- Test DayOpeningTime");
        dayOpeningTime.setFromTime(LocalTime.parse("08:30"));
        dayOpeningTime.setToTime(LocalTime.parse("16:00"));
        System.out.println(" fromTime:" + dayOpeningTime.getFromTime());
        System.out.println(" toTime:" + dayOpeningTime.getToTime());
    }

//    @Autowired
//    SkiResort skiResort;

}
