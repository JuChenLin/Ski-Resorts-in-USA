package com.priscilla.web.entity.key;

import com.priscilla.web.entity.enumerate.State;

import java.io.Serializable;
import java.util.Objects;

public class AddressID implements Serializable {
    private String street;
    private Integer zipCode;

    public AddressID(String street, Integer zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressID that = (AddressID) o;
        return street.equals(that.street) && zipCode.equals(that.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, zipCode);
    }
}
