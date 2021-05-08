package com.priscilla.web.entity.skiresort;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.priscilla.web.entity.enumerate.State;
import com.priscilla.web.entity.key.AddressID;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "address")
@SQLDelete(sql = "UPDATE address SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> true")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(6) ZEROFILL", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "deleted", nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted = false;

    @Column(columnDefinition = "char(20) default 'Ski Resort'")
    private String name = "Ski Resort";
    @Column(nullable = false, columnDefinition = "char(50)")
    private String street;
    @Column(nullable = false, columnDefinition = "char(30)")
    private String city;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private State state;
    @Column(nullable = false, columnDefinition = "char(15)")
    private String zipCode;

    @OneToOne
    @JoinColumn(name = "ski_resort_id", updatable = false)
    @JsonIgnore
    private SkiResort skiResort;

    public Address() {};

    public Address(String name, String street, String city, State state, String zipCode) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(String name, String street, String city, State state, String zipCode, SkiResort skiResort) {
        this(name, street, city, state, zipCode);
        this.skiResort = skiResort;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public SkiResort getSkiResort() {
        return skiResort;
    }

    public void setSkiResort(SkiResort skiResort) {
        this.skiResort = skiResort;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", isDeleted=" + isDeleted +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state=" + state +
                ", zipCode='" + zipCode + '\'' +
//                ", skiResort=" + skiResort +
                '}';
    }
}
