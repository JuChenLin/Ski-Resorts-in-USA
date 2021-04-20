package com.priscilla.web.entity.skiresort;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.priscilla.web.entity.enumerate.PriceRange;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "ski_resort")
//@NamedQuery(name = "SkiResort.findAllOrderedById”, query = “SELECT ski_resort FROM SkiResort ski_resort WHERE name like :name")
@SQLDelete(sql = "UPDATE ski_resort SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> true")
public class SkiResort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, columnDefinition = "int(6) ZEROFILL")
    private Integer id;

    @Column(name = "deleted", nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted = false;

    @NotNull(message="ski resort name is required")
    @Column(nullable = false, columnDefinition = "char(50)")
    private String name;
    @Column(nullable = false, columnDefinition = "char(100)")
    private String website;

    @Enumerated(EnumType.STRING)
    @Column
    private PriceRange priceRange;

    @Column(columnDefinition = "int(4)")
    private Integer annualSnowfall;

    @OneToOne(mappedBy = "skiResort", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
    private MountainStat mountainStat;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_street", referencedColumnName = "street")
//    @JoinColumn(name = "address_zipcode", referencedColumnName = "zipCode")
//    private Address address;

    @OneToMany(mappedBy = "skiResort", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
    private List<Address> addresses;
//    private OperatingTime operatingTime;

    public SkiResort() {

    }

    public SkiResort(String name, String website, PriceRange priceRange, Integer annualSnowfall) {
        this.name = name;
        this.website = website;
        this.priceRange = priceRange;
        this.annualSnowfall = annualSnowfall;
    }

    // Copy Constructor
    public SkiResort(SkiResort skiResort) {
        this.name = skiResort.name;
        this.website = skiResort.website;
        this.priceRange = skiResort.priceRange;
        this.annualSnowfall = skiResort.annualSnowfall;
        this.mountainStat = skiResort.mountainStat;
        this.addresses = skiResort.addresses;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public MountainStat getMountainStat() {
        return mountainStat;
    }

    public void setMountainStat(MountainStat mountainStat) {
        this.mountainStat = mountainStat;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address addressMap) {
//        this.address = address;
//    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

//    public OperatingTime getOperatingTime() {
//        return operatingTime;
//    }
//
//    public void setOperatingTime(OperatingTime operatingTime) {
//        this.operatingTime = operatingTime;
//    }

    @Override
    public String toString() {
        return "SkiResort{" +
                "id=" + id +
                ", isDeleted=" + isDeleted +
                ", name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", priceRange=" + priceRange +
                ", annualSnowfall=" + annualSnowfall +
                ", mountainStat=" + mountainStat +
                ", addresses=" + addresses +
                "}";
    }

    public void setAll(SkiResort request) {
        this.setDeleted(request.getDeleted());
        this.setName(request.getName());
        this.setWebsite(request.getWebsite());
        this.setPriceRange(request.getPriceRange());
        this.setAnnualSnowfall(request.getAnnualSnowfall());
        this.setMountainStat(request.getMountainStat());
        this.setAddresses(request.getAddresses());
    }
}
