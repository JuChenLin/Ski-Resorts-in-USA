package com.priscilla.web.entity.key;

import com.priscilla.web.entity.enumerate.State;

import java.io.Serializable;
import java.util.Objects;

public class AddressID implements Serializable {
    private Integer zipCode;
    private String street;

    public AddressID() {}
    public AddressID(Integer zipCode, String street) {
        this.zipCode = zipCode;
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressID that = (AddressID) o;
        return zipCode.equals(that.zipCode) && street.equals(that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipCode, street);
    }
}
