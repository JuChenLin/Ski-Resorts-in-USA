package com.priscilla.web.entity.skiresort;

import com.priscilla.web.entity.enumerate.PriceRange;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@SQLDelete(sql = "UPDATE ski_resort SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Table(name = "ski_resort")
public class SkiResort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(6) ZEROFILL", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "deleted", nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted = false;

    @Column(nullable = false, columnDefinition = "char(50)")
    private String name;
    @Column(nullable = false, columnDefinition = "char(100)")
    private String website;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "char(10) default 'UNKNOWN'")
    private PriceRange priceRange = PriceRange.UNKNOWN;

    @Column(columnDefinition = "int(4) default -1")
    private Integer annualSnowfall = -1;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_street", referencedColumnName = "street")
    @JoinColumn(name = "address_zipcode", referencedColumnName = "zipCode")
    private Address address;
//    private Map<String, Address> addressMap;
//    private OperatingTime operatingTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mountain_stat_id", referencedColumnName = "id")
    private MountainStat mountainStat;

    public SkiResort() {

    }

    public SkiResort(SkiResort skiResort) {
//        this.isDeleted = skiResort.isDeleted;
        this.name = skiResort.name;
        this.website = skiResort.website;
        this.priceRange = skiResort.priceRange;
        this.annualSnowfall = skiResort.annualSnowfall;
        this.address = skiResort.address;
        this.mountainStat = skiResort.mountainStat;
    }

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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        this.isDeleted = deleted;
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

    public Integer getAnnualSnowfall() {
        return annualSnowfall;
    }

    public void setAnnualSnowfall(Integer annualSnowfall) {
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

    public void setAll(SkiResort request) {
        this.setDeleted(request.getDeleted());
        this.setName(request.getName());
        this.setWebsite(request.getWebsite());
        this.setPriceRange(request.getPriceRange());
        this.setAnnualSnowfall(request.getAnnualSnowfall());
        this.setAddress(request.getAddress());
        this.setAnnualSnowfall(request.getAnnualSnowfall());
    }
}
