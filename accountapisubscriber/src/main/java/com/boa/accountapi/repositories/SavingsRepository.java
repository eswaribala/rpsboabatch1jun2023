package com.boa.accountapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.accountapi.models.SavingsAccount;


public interface SavingsRepository extends JpaRepository<SavingsAccount,Long>{

}
