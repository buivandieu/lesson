package com.vti.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.entity.Employees;
import com.vti.form.account.AccountFilterForm;
import com.vti.form.account.CreatingAccountForm;
import com.vti.repository.IEmployeesRepository;
import com.vti.specification.account.AccountSpecification;

@Service
public class EmployeesService implements IEmployeesService {

	@Autowired
	private IEmployeesRepository repository;

	@Autowired
	private ModelMapper modelMapper;
	
	public Page<Employees> getAllAccounts(
			Pageable pageable, 
			String search, 
			AccountFilterForm filterForm) {
		
		Specification<Employees> where = AccountSpecification.buildWhere(search, filterForm);
		return repository.findAll(where, pageable);
	}
	
	public Employees getAccountByID(int id) {
		return repository.findById(id).get();
	}
	
	public void createAccount(CreatingAccountForm form) {
		
		// omit id field
		TypeMap<CreatingAccountForm, Employees> typeMap = modelMapper.getTypeMap(CreatingAccountForm.class, Employees.class);
		if (typeMap == null) { // if not already added
			// skip field
			modelMapper.addMappings(new PropertyMap<CreatingAccountForm, Employees>() {
				@Override
				protected void configure() {
					skip(destination.getId());
				}
			});
		}

		// convert form to entity
		Employees account = modelMapper.map(form, Employees.class);
		
		repository.save(account);
	}

	public boolean isAccountExistsByUsername(String username) {
		return repository.existsByUsername(username);
	}
}


