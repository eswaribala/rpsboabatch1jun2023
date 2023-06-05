package com.boa.customerapi.repositories;

import com.boa.customerapi.models.Address;
import com.boa.customerapi.models.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {

    @Query("Select a from Address a where a.customer.accountNo=:accountNo")
    public List<Address> findAddressByAccountNo(@Param("accountNo") long accountNo);

}
