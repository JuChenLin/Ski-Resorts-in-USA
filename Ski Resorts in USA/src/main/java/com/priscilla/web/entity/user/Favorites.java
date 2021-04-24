package com.priscilla.web.entity.user;

import com.priscilla.web.entity.skiresort.SkiResort;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final String id;

    private String externalID;

    private List<SkiResort> skiResorts = new ArrayList<>();

    public Favorites(String id, String externalID, List<SkiResort> skiResorts) {
        this.id = id;
        this.externalID = externalID;
        this.skiResorts = skiResorts;
    }

    public String getId() {
        return id;
    }

    public String getExternalID() {
        return externalID;
    }

    public void setExternalID(String externalID) {
        this.externalID = externalID;
    }


    public List<SkiResort> getSkiResorts() {
        return skiResorts;
    }

    public void setSkiResorts(List<SkiResort> skiResorts) {
        this.skiResorts = skiResorts;
    }

    @Override
    public String toString() {
        return "favorites{" +
                "id='" + id + '\'' +
                ", externalID='" + externalID + '\'' +
                ", skiResorts=" + skiResorts +
                '}';
    }
}
