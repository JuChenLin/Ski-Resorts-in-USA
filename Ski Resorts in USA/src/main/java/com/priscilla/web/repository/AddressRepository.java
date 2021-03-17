package com.priscilla.web.repository;

import com.priscilla.web.entity.key.AddressID;
import com.priscilla.web.entity.skiresort.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}

//public interface AddressRepository extends JpaRepository<Address, AddressID> {
//
//}

//public interface AddressRepository<Address, AddressID extends Serializable> extends JpaRepository<Address, AddressID> {
//
//}
