package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.exception.BalanceException;
import com.example.demo.model.Account;
import com.example.demo.model.Txn;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.AccountRepositoryTxn;

@Service
public class TxrServiceImpl implements TxrService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountRepositoryTxn accountRepositoryTxn;

	@Transactional
	@Override
	public boolean txr(double amount, String fromaccnum, String toaccnum) {

		Account fromAccount =
				accountRepository.findById(fromaccnum)
				.orElseThrow(()->new AccountNotFoundException(fromaccnum + " not exist"));
		Account toAccount = accountRepository.findById(toaccnum)
				.orElseThrow(()->new AccountNotFoundException(toaccnum + " not exist"));
		
		System.out.println("debit & credit..");

		if (fromAccount.getBalance() < amount)
			throw new BalanceException("current balance " + fromAccount.getBalance());

		fromAccount.setBalance(fromAccount.getBalance() - amount); // debit
		toAccount.setBalance(toAccount.getBalance() + amount); // credit
		
		
		Txn txn_statement = new Txn(toaccnum, fromaccnum, amount, Txn.getLocalDateTime(), "remark-4",
									Txn.getLocalDateTime_Month(), Txn.getLocalDateTime_Day());
				
				

		accountRepository.save(fromAccount);
		accountRepository.save(toAccount);
		
		accountRepositoryTxn.save(txn_statement);

		return true;

	}

}
