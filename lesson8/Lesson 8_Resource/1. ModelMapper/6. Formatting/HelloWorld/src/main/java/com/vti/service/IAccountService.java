package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Account;

public interface IAccountService {

	public Page<Account> getAllAccounts(Pageable pageable);

	public Account getAccountByID(int id);
}
