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
import com.boa.accountapi.services.CurrentService;
import com.boa.accountapi.services.CurrentService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/currents")
public class CurrentController {
	
	@Autowired
	private CurrentService CurrentService;
	

	//post
	@PostMapping({"/v1.0/"})
	public ResponseEntity<String> addCurrent(@RequestBody CurrentAccount CurrentAccount) {
		
	  CurrentAccount CurrentObj=this.CurrentService.addCurrentAccount(CurrentAccount);
	  Gson gson=new Gson();
	  if(CurrentObj!=null) {
		  return ResponseEntity.status(HttpStatus.CREATED)
				  .body(gson.toJson(CurrentObj));
	  }
	  else
	  {
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				  .body("Current Account Not created");
	  }
	}
	
	
	
	
	//get
	@GetMapping({"/v1.0"})
	public List<CurrentAccount> getCurrentAccount(){
		return this.CurrentService.viewAllCurrentAccounts();
	}
	
	@GetMapping({"/v1.0/{accountNo}"})
	public CurrentAccount getCurrentAccountByAccountNo(@PathVariable("accountNo") long accountNo) {
	   return this.CurrentService.viewCurrentAccountByAccountNo(accountNo);	
	}
	
	
}
