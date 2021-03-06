package com.priscilla.web.entity.skiresort;

import com.priscilla.web.entity.enumerate.PriceRange;

import javax.persistence.*;

@Entity
@Table(name = "ski_resort")
public class SkiResort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(6) ZEROFILL")
    private Integer id;

    @Column(nullable = false, columnDefinition = "char(50)")
    private String name;
    @Column(nullable = false, columnDefinition = "char(100)")
    private String website;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "char(10) default 'UNKNOWN'")
    private PriceRange priceRange = PriceRange.UNKNOWN;

    @Column(length = 10, columnDefinition = "char(10) default 'UNKNOWN'")
    private String annualSnowfall = "UNKNOWN";

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_street", referencedColumnName = "street")
    @JoinColumn(name = "address_zipcode", referencedColumnName = "zipCode")
    private Address address;
//    private Map<String, Address> addressMap;
//    private OperatingTime operatingTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mountain_stat_id", referencedColumnName = "id")
    private MountainStat mountainStat;


//    public SkiResort(String id, String name, String website, State state, PriceRange priceRange) {
//        this.id = id;
//        this.name = name;
//        this.website = website;
//        this.priceRange = priceRange;
//        this.address = new Address(state);
//
//        this.annualSnowfall = null;
//        this.mountainStat = new MountainStat();
//    }

//    public SkiResort(String id, String name, String website, State state, PriceRange priceRange) {
//        this(id, name, website, state, priceRange);
//
//        this.annualSnowfall = null;
//        this.mountainStat = new MountainStat();
////        this.addresses = new HashMap<String, Address>();
////        this.operatingTime = operatingTime;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getAnnualSnowfall() {
        return annualSnowfall;
    }

    public void setAnnualSnowfall(String annualSnowfall) {
        this.annualSnowfall = annualSnowfall;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address addressMap) {
        this.address = address;
    }

//    public Map<String, Address> getAddressMap() {
//        return addressMap;
//    }
//
//    public void setAddressMap(Map<String, Address> addressMap) {
//        this.addressMap = addressMap;
//    }

////    public OperatingTime getOperatingTime() {
////        return operatingTime;
////    }
////
////    public void setOperatingTime(OperatingTime operatingTime) {
////        this.operatingTime = operatingTime;
////    }
//
    public MountainStat getMountainStat() {
        return mountainStat;
    }

    public void setMountainStat(MountainStat mountainStat) {
        this.mountainStat = mountainStat;
    }

//
//    @Override
//    public String toString() {
//        return "SkiResort{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", website='" + website + '\'' +
//                ", priceRange=" + priceRange +
//                ", addresses=" + address +
////                ", operatingTime=" + operatingTime +
//                ", mountainStat=" + mountainStat +
//                ", annualSnowfall=" + annualSnowfall +
//                '}';
//    }
}
