package com.boa.accountapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.accountapi.models.CurrentAccount;
import com.boa.accountapi.models.SavingsAccount;
import com.boa.accountapi.repositories.CurrentRepository;
@Service
public class CurrentServiceImpl implements CurrentService{
	@Autowired
	private CurrentRepository currentRepository;

	@Override
	public CurrentAccount addCurrentAccount(CurrentAccount currentAccount) {
		// TODO Auto-generated method stub
		return currentRepository.save(currentAccount);
	}

	@Override
	public CurrentAccount updateCurrentAccount(long accountNo, long overDraftLimit) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		CurrentAccount currentAccountObj= currentRepository.findById(accountNo).orElse(null);
				if(currentAccountObj!=null) {
					currentAccountObj.setOverDraftLimit(overDraftLimit);
				
				}
			  return currentRepository.save(currentAccountObj);
	}

	@Override
	public List<CurrentAccount> viewAllCurrentAccounts() {
		// TODO Auto-generated method stub
		return currentRepository.findAll();
	}

	@Override
	public CurrentAccount viewCurrentAccountByAccountNo(long accountNo) {
		// TODO Auto-generated method stub
		return currentRepository.findById(accountNo).orElse(null);
	}

	@Override
	public boolean deleteCurrentAccountByAccountNo(long accountNo) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				boolean status=false;
				// TODO Auto-generated method stub
				if(currentRepository.findById(accountNo)!=null)
				{
					currentRepository.deleteById(accountNo);
					status=true;
				}	
				return status;
	}

	


}
