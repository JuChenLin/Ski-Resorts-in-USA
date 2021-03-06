package com.priscilla.web.entity.skiresort;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

@Component
public class OperatingTime {

    private Map<DayOpeningTime, DayOfWeek> openingTime;

    public OperatingTime() {
        this.openingTime = new HashMap<>();
    }

    public Map<DayOpeningTime, DayOfWeek> getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Map<DayOpeningTime, DayOfWeek> openingTime) {
        this.openingTime = openingTime;
    }

    @Override
    public String toString() {
        return "OperatingTime{" +
                "openingTime=" + openingTime +
                '}';
    }
}
