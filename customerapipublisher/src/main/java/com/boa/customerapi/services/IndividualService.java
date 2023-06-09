package com.boa.customerapi.services;

import com.boa.customerapi.models.Individual;
import com.boa.customerapi.repositories.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndividualService {
    @Autowired
    private IndividualRepository individualRepository;

    //insert

    public Individual addIndividual(Individual individual){

        return individualRepository.save(individual);
    }

    //select all

    public List<Individual> getAllIndividuals(){
        return this.individualRepository.findAll();

    }



    //where

    public Individual getIndividualById(long accountNo){
        return this.individualRepository.findById(accountNo).orElse(null);
    }


    //update

    public Individual updateIndividualById(long accountNo, long contactNo){

        Individual individual=this.getIndividualById(accountNo);
        if(individual!=null){
            individual.setContactNo(contactNo);
            this.individualRepository.save(individual);
        }
        return individual;
    }


    //delete

    public boolean deleteIndividualById(long accountNo){
        boolean status=false;
        Individual individual=this.getIndividualById(accountNo);
        if(individual!=null)
        {
            this.individualRepository.deleteById(accountNo);
            status=true;
        }

        return status;

    }


    //select by email

    public List<Individual> getIndividualByEmail(String email){
        return this.individualRepository.findByEmail(email);
    }


}
