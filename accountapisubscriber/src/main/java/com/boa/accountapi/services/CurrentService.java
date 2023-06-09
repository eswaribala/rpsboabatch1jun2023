package com.boa.accountapi.services;

import java.util.List;

import com.boa.accountapi.models.CurrentAccount;



public interface CurrentService {
	
	CurrentAccount addCurrentAccount(CurrentAccount currentAccount);
	CurrentAccount updateCurrentAccount(long accountNo, long overDraftLimit);
	List<CurrentAccount> viewAllCurrentAccounts();
	CurrentAccount viewCurrentAccountByAccountNo(long accountNo);
	boolean deleteCurrentAccountByAccountNo(long accountNo);
	

}
