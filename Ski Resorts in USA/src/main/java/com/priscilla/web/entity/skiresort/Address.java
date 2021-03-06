package com.priscilla.web.entity.skiresort;

import com.priscilla.web.entity.enumerate.State;
import com.priscilla.web.entity.key.AddressID;

import javax.persistence.*;

@Entity
@Table(name = "address")
@IdClass(AddressID.class)
public class Address {

    @Id
    private String street;
    @Id
    private Integer zipCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "char(10) default 'UNKNOWN'")
    private State state = State.UNKNOWN;
    @Column
    private String city;

//    public Address(State state) {
//        this.state = state;
//    }
//    public Address(State state, String city, String street, Integer zipCode) {
//        this(state);
//        this.city = city;
//        this.street = street;
//        this.zipCode = zipCode;
//    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                "state=" + state +
                ", zipCode=" + zipCode +
                '}';
    }
}
