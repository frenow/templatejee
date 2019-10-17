package com.template.app.rest.company;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.template.app.entity.CompanyEntity;
import com.template.app.exception.AppException;
import com.template.app.service.CompanyService;

/**
 * Class Rest to provide company rest operations
 *
 */
@Path("/company")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class CompanyRest {
	

	@GET
	@Path("/all")
	public List<CompanyEntity> getAllCompanies() throws AppException{
		
		CompanyService cs = new CompanyService();		

		List<CompanyEntity> listCompanies = cs.retrieveAll();
		return listCompanies;
	}
	
}
