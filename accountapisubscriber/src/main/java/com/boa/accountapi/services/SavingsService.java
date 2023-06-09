package com.boa.accountapi.services;

import java.util.List;

import com.boa.accountapi.models.SavingsAccount;



public interface SavingsService {
	
	SavingsAccount addSavingsAccount(SavingsAccount savingsAccount);
	SavingsAccount updateSavingsAccount(long accountNo, float roi);
	List<SavingsAccount> viewAllSavingsAccounts();
	SavingsAccount viewSavingsAccountByAccountNo(long accountNo);
	boolean deleteISavingsAccountByAccountNo(long accountNo);
	

}
