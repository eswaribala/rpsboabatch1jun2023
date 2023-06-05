package com.boa.customerapi.services;

import com.boa.customerapi.models.;
import com.boa.customerapi.repositories.CorporateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorporateService {

    @Autowired
    private CorporateRepository corporateRepository;

    //insert

    public Corporate addCorporate(Corporate corporate){

        return corporateRepository.save(corporate);
    }

    //select all

    public List<Corporate> getAllCorporates(){
        return this.corporateRepository.findAll();

    }



    //where

    public Corporate getCorporateById(long accountNo){
        return this.corporateRepository.findById(accountNo).orElse(null);
    }


    //update

    public Corporate updateCorporateById(long accountNo, long contactNo){

        Corporate corporate=this.getCorporateById(accountNo);
        if(corporate!=null){
            corporate.setContactNo(contactNo);
            this.corporateRepository.save(corporate);
        }
        return corporate;
    }


    //delete

    public boolean deleteCorporateById(long accountNo){
        boolean status=false;
        Corporate corporate=this.getCorporateById(accountNo);
        if(corporate!=null)
        {
            this.corporateRepository.deleteById(accountNo);
            status=true;
        }

        return status;

    }


    
}
