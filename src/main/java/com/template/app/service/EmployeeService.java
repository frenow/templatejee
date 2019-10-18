package com.template.app.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.template.app.entity.EmployeeEntity;
import com.template.app.service.repository.EmployeeRepository;

@Stateless
@Local
public class EmployeeService {
	
	@Inject
	private EmployeeRepository employeeRepository;

	public List<EmployeeEntity> retrieveAll() {			
		System.out.println("service");
		List<EmployeeEntity> employeeList = employeeRepository.retrieveAll();
		
		return employeeList;	
	}
	
	public EmployeeEntity get(Long id) {
		System.out.println("service");
		EmployeeEntity e = employeeRepository.get(id);
		return e;
	}		

}