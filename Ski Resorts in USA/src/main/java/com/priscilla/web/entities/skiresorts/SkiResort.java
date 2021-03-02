package com.priscilla.web.entities.skiresorts;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

//@Component
@ConfigurationProperties(prefix = "resort")
public class SkiResort {
    private String id;
    private String name;
    private String website;
//    private State state;
    private PriceRange priceRange;

//    private Map<String, Address> addressMap;
    private Address address;
//    private OperatingTime operatingTime;

    private MountainStat mountainStat;
    private Integer annualSnowfall;

    public SkiResort(String id, String name, String website, State state, PriceRange priceRange) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.priceRange = priceRange;
        this.address = new Address(state);

        this.annualSnowfall = null;
        this.mountainStat = new MountainStat();
    }

//    public SkiResort(String id, String name, String website, State state, PriceRange priceRange) {
//        this(id, name, website, state, priceRange);
//
//        this.annualSnowfall = null;
//        this.mountainStat = new MountainStat();
////        this.addresses = new HashMap<String, Address>();
////        this.operatingTime = operatingTime;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }

//    public Map<String, Address> getAddressMap() {
//        return addressMap;
//    }
//
//    public void setAddressMap(Map<String, Address> addressMap) {
//        this.addressMap = addressMap;
//    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address addressMap) {
        this.address = address;
    }

//    public OperatingTime getOperatingTime() {
//        return operatingTime;
//    }
//
//    public void setOperatingTime(OperatingTime operatingTime) {
//        this.operatingTime = operatingTime;
//    }

    public MountainStat getMountainStat() {
        return mountainStat;
    }

    public void setMountainStat(MountainStat mountainStat) {
        this.mountainStat = mountainStat;
    }

    public Integer getAnnualSnowfall() {
        return annualSnowfall;
    }

    public void setAnnualSnowfall(Integer annualSnowfall) {
        this.annualSnowfall = annualSnowfall;
    }

    @Override
    public String toString() {
        return "SkiResort{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", priceRange=" + priceRange +
                ", addresses=" + address +
//                ", operatingTime=" + operatingTime +
                ", mountainStat=" + mountainStat +
                ", annualSnowfall=" + annualSnowfall +
                '}';
    }
}
