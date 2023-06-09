package com.boa.accountapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boa.accountapi.models.CurrentAccount;
import com.boa.accountapi.models.SavingsAccount;

import com.boa.accountapi.services.SavingsService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/savings")
public class SavingsController {
	
	@Autowired
	private SavingsService savingsService;
	

	//post
	@PostMapping({"/v1.0/"})
	public ResponseEntity<String> addSavings(@RequestBody SavingsAccount savingsAccount) {
		
	  SavingsAccount savingsObj=this.savingsService.addSavingsAccount(savingsAccount);
	  Gson gson=new Gson();
	  if(savingsObj!=null) {
		  return ResponseEntity.status(HttpStatus.CREATED)
				  .body(gson.toJson(savingsObj));
	  }
	  else
	  {
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				  .body("Savings Account Not created");
	  }
	}
	
	
	
	
	//get
	@GetMapping({"/v1.0"})
	public List<SavingsAccount> getSavingsAccount(){
		return this.savingsService.viewAllSavingsAccounts();
	}
	
	@GetMapping({"/v1.0/{accountNo}"})
	public SavingsAccount getSavingsAccountByAccountNo(@PathVariable("accountNo") long accountNo) {
	   return this.savingsService.viewSavingsAccountByAccountNo(accountNo);	
	}
	
	
	
}
