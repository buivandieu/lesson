package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository repository;

	public Page<Account> getAllAccounts(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Account getAccountByID(int id) {
		return repository.findById(id).get();
	}

}
