package com.boa.accountapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.accountapi.models.CurrentAccount;



public interface CurrentRepository extends JpaRepository<CurrentAccount,Long>{

}
