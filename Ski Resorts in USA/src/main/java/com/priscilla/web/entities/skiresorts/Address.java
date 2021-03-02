package com.priscilla.web.entities.skiresorts;

public class Address {
    private State state;
    private String city;
    private String street;
    private Integer zipCode;

    public Address(State state) {
        this.state = state;
    }
    public Address(State state, String city, String street, Integer zipCode) {
        this(state);
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

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
