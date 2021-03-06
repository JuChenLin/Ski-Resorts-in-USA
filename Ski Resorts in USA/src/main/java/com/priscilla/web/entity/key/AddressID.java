package com.priscilla.web.entity.key;

import com.priscilla.web.entity.enumerate.State;

import java.io.Serializable;

public class AddressID implements Serializable {
    private String street;
    private Integer zipCode;

    public AddressID(String street, Integer zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }
}
