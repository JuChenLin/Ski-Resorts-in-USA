package com.priscilla.web.repository;

import com.priscilla.web.entity.key.AddressID;
import com.priscilla.web.entity.skiresort.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, AddressID> {

}
