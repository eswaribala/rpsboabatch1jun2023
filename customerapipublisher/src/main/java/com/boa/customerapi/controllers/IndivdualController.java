package com.boa.customerapi.controllers;

import com.boa.customerapi.dtos.ResponseWrapper;
import com.boa.customerapi.models.Individual;
import com.boa.customerapi.services.IndividualService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/individuals")

public class IndivdualController {

    @Autowired
    private IndividualService individualService;

    @PostMapping({"/v1.0/"})
    public ResponseEntity<ResponseWrapper> addIndividual(@RequestBody Individual individual){
        Individual indObj=this.individualService.addIndividual(individual);
        if(indObj!=null){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(indObj));

        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseWrapper("Individual Object not Created because required parameters missing"));
    }

    @GetMapping({"/v1.0/"})
    public List<Individual> getIndividuals(){


            return this.individualService.getAllIndividuals();
    }
    @GetMapping({"/v1.0/{accountNo}"})
    public ResponseEntity<ResponseWrapper> getIndividualById(@PathVariable("accountNo") long accountNo){
        Individual indObj=this.individualService.getIndividualById(accountNo);
        if(indObj!=null){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(indObj));

        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseWrapper("Individual Object not found"));

    }

    @GetMapping({"/v1.0/email/{email}"})
    public ResponseEntity<ResponseWrapper> getIndividualByEmail(@PathVariable("email") String email){
        List<Individual> indList=this.individualService.getIndividualByEmail(email);
        if(indList.size()>0){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(indList));

        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseWrapper("Individual Object not found"));

    }

    @PutMapping({"/v1.0/{accountNo}"})
    public ResponseEntity<ResponseWrapper> updateIndividualById(@PathVariable("accountNo") long accountNo, @RequestParam("contactNo") long contactNo){
        Individual indObj=this.individualService.updateIndividualById(accountNo,contactNo);
        if(indObj!=null){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(indObj));

        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseWrapper("Individual Object not Updated because required parameters missing"));
    }

    @DeleteMapping({"/v1.0/{accountNo}"})
    public ResponseEntity<ResponseWrapper> deleteIndividualById(@PathVariable("accountNo") long accountNo){

        if(this.individualService.deleteIndividualById(accountNo)){
           return  ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseWrapper("Individual Object "+accountNo +"deleted"));
        }
        else
        {
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseWrapper("Individual Object "+accountNo +" not deleted"));
        }

    }


}
