package com.boa.accountapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.accountapi.models.CurrentAccount;
import com.boa.accountapi.models.SavingsAccount;
import com.boa.accountapi.repositories.SavingsRepository;
@Service
public class SavingsServiceImpl implements SavingsService{
	@Autowired
	private SavingsRepository savingsRepository;
	

	@Override
	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		// TODO Auto-generated method stub
		return savingsRepository.save(savingsAccount);
	}

	@Override
	public SavingsAccount updateSavingsAccount(long accountNo, float roi) {
		// TODO Auto-generated method stub
		SavingsAccount savingsObj= savingsRepository.findById(accountNo).orElse(null);
		if(savingsObj!=null) {
			savingsObj.setRoi(roi);
		
		}
	  return savingsRepository.save(savingsObj);
	}

	@Override
	public List<SavingsAccount> viewAllSavingsAccounts() {
		// TODO Auto-generated method stub
		return savingsRepository.findAll();
	}

	@Override
	public SavingsAccount viewSavingsAccountByAccountNo(long accountNo) {
		// TODO Auto-generated method stub
		return savingsRepository.findById(accountNo).orElse(null);
	}

	@Override
	public boolean deleteISavingsAccountByAccountNo(long accountNo) {
		// TODO Auto-generated method stub
		boolean status=false;
		// TODO Auto-generated method stub
		if(savingsRepository.findById(accountNo)!=null)
		{
			savingsRepository.deleteById(accountNo);
			status=true;
		}	
		return status;
	}
	


}
