package com.template.app.rest.employee;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.template.app.entity.EmployeeEntity;
import com.template.app.exception.AppException;
import com.template.app.service.EmployeeService;

@Path("/employee")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class EmployeeRest {
	
	@Inject
	private EmployeeService employeeService;	
	
	@GET
	@Path("/all")
	public List<EmployeeEntity> getAllEmployees() throws AppException{
				
		List<EmployeeEntity> listEmployees = employeeService.retrieveAll();
		return listEmployees;
	}	

}
