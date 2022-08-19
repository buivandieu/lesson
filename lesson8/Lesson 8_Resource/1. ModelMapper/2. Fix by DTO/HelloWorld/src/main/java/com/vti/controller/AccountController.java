package com.vti.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.DepartmentFilterForm;
import com.vti.service.IAccountService;
import com.vti.service.IDepartmentService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/v1/accounts")
public class AccountController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IAccountService service;


	@GetMapping()
	public Page<AccountDTO> getAllAccounts(
			Pageable pageable, 
			@RequestParam(value = "search", required = false) String search,
			DepartmentFilterForm filterForm) {

		Page<Account> entityPages = service.getAllAccounts(pageable, search, filterForm);

		// convert entities --> dtos
		List<AccountDTO> dtos = modelMapper.map(
				entityPages.getContent(), 
				new TypeToken<List<AccountDTO>>() {}.getType());

		Page<AccountDTO> dtoPages = new PageImpl<>(dtos, pageable, entityPages.getTotalElements());

		return dtoPages;
	}

	@GetMapping(value = "/{id}")
	public Account getDepartmentByID(@PathVariable(name = "id") int id) {
		return service.getDepartmentByID(id);
	}

	@PostMapping()
	public void createDepartment(@RequestBody Account department) {
		service.createAccount(department);
	}

	@PutMapping(value = "/{id}")
	public void updateDepartment(@PathVariable(name = "id") int id, @RequestBody Account department) {
		department.setId(id);
		service.updateAccount(department);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteDepartment(@PathVariable(name = "id") int id) {
		service.deleteAccount(id);
	}
}
