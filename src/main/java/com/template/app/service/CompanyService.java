package com.template.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.template.app.entity.CompanyEntity;
import com.template.app.service.repository.CompanyRepository;

@Stateless
public class CompanyService {
	
	@Inject
	private CompanyRepository companyRepository;

	public List<CompanyEntity> retrieveAll() {			
		System.out.println("service");
		List<CompanyEntity> companyList = companyRepository.retrieveAll();
		
		return companyList;
		
		//mock
		//List<CompanyEntity> listCompanies = new ArrayList<CompanyEntity>();
		//listCompanies.add(new CompanyEntity(1L, "Google"));
		//listCompanies.add(new CompanyEntity(2L, "Apple"));
		//listCompanies.add(new CompanyEntity(3L, "Microsoft"));
		//return listCompanies;		
	}
}