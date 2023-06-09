package com.boa.customerapi.controllers;

import com.boa.customerapi.dtos.ResponseWrapper;

import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.services.CorporateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corporates")
public class CorporateController {

    @Autowired
    private CorporateService corporateService;

    @PostMapping({"/v1.0/"})
    public ResponseEntity<ResponseWrapper> addCorporate(@RequestBody Corporate Corporate){
        Corporate indObj=this.corporateService.addCorporate(Corporate);
        if(indObj!=null){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(indObj));

        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseWrapper("Corporate Object not Created because required parameters missing"));
    }

    @GetMapping({"/v1.0/"})
    public List<Corporate> getCorporates(){

        return this.corporateService.getAllCorporates();
    }
    @GetMapping({"/v1.0/{accountNo}"})
    public ResponseEntity<ResponseWrapper> getCorporateById(@PathVariable("accountNo") long accountNo){
        Corporate indObj=this.corporateService.getCorporateById(accountNo);
        if(indObj!=null){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(indObj));

        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseWrapper("Corporate Object not found"));

    }



    @PutMapping({"/v1.0/{accountNo}"})
    public ResponseEntity<ResponseWrapper> updateCorporateById(@PathVariable("accountNo") long accountNo, @RequestParam("contactNo") int contactNo){
        Corporate indObj=this.corporateService.updateCorporateById(accountNo,contactNo);
        if(indObj!=null){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(indObj));

        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseWrapper("Corporate Object not Updated because required parameters missing"));
    }

    @DeleteMapping({"/v1.0/{accountNo}"})
    public ResponseEntity<ResponseWrapper> deleteCorporateById(@PathVariable("accountNo") long accountNo){

        if(this.corporateService.deleteCorporateById(accountNo)){
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseWrapper("Corporate Object "+accountNo +"deleted"));
        }
        else
        {
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseWrapper("Corporate Object "+accountNo +" not deleted"));
        }

    }
}
