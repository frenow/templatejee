package com.template.app.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.template.app.entity.CompanyEntity;
import com.template.app.service.repository.CompanyRepository;

@Stateless
@Local
public class CompanyService {
	
	@Inject
	private CompanyRepository companyRepository;

	public List<CompanyEntity> retrieveAll() {			
		System.out.println("service");
		List<CompanyEntity> companyList = companyRepository.retrieveAll();		
		return companyList;
			
	}
	public CompanyEntity get(Long id) {
		System.out.println("service");
		CompanyEntity c = companyRepository.get(id);
		return c;
	}	
}