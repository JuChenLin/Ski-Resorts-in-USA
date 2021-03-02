package com.priscilla.web.entities.skiresorts;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class DayOpeningTime {

    @JsonFormat(pattern="HH:mm")
    private LocalTime fromTime;

    @JsonFormat(pattern="HH:mm")
    private LocalTime toTime;

    public LocalTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalTime fromTime) {
        this.fromTime = fromTime;
    }

    public LocalTime getToTime() { return toTime; }

    public void setToTime(LocalTime toTime) {
        this.toTime = toTime;
    }
}
