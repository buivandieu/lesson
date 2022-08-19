package com.vti.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.EmployeesDTO;
import com.vti.entity.Employees;
import com.vti.form.account.AccountFilterForm;
import com.vti.form.account.CreatingAccountForm;
import com.vti.service.IEmployeesService;

@RestController
@RequestMapping(value = "api/v1/Employees")

public class EmployeesController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IEmployeesService service;

	@GetMapping()
	public Page<EmployeesDTO> getAllAccounts(
			Pageable pageable, 
			@RequestParam(value = "search", required = false) String search,
			AccountFilterForm filterForm) {

		Page<Employees> entityPages = service.getAllAccounts(pageable, search, filterForm);

		// convert entities --> dtos
		List<EmployeesDTO> dtos = modelMapper.map(
				entityPages.getContent(), 
				new TypeToken<List<EmployeesDTO>>() {}.getType());

		Page<EmployeesDTO> dtoPages = new PageImpl<>(dtos, pageable, entityPages.getTotalElements());

		return dtoPages;
	}
	
	@GetMapping(value = "/{id}")
	public EmployeesDTO getAccountByID(@PathVariable(name = "id") int id) {
		Employees entity = service.getAccountByID(id);

		// convert entity to dto
		EmployeesDTO dto = modelMapper.map(entity, EmployeesDTO.class);
		
		dto.add(linkTo(methodOn(EmployeesController.class).getAccountByID(id)).withSelfRel());

		return dto;
	}

	@PostMapping()
	public void createAccount(@RequestBody CreatingAccountForm form) {
		service.createAccount(form);
	}
}

