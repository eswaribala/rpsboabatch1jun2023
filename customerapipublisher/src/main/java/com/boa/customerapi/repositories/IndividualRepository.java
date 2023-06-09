package com.boa.customerapi.repositories;

import com.boa.customerapi.models.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IndividualRepository extends JpaRepository<Individual,Long> {
    @Query("Select i from Individual i where i.email=:email")
    public List<Individual> findByEmail(@Param("email") String email);
}
