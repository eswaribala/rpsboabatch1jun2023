package com.boa.customerapi.repositories;

import com.boa.customerapi.models.Address;
import com.boa.customerapi.models.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address,Long> {



}
