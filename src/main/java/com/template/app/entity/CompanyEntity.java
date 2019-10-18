package com.template.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="COMPANY")
@SequenceGenerator(name = "COMPANY_ID_GENERATOR", sequenceName = "SE_COMPANY", allocationSize = 1)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@NamedQueries({
    @NamedQuery(name="CompanyEntity.retrieveAll", query="Select distinct c from CompanyEntity c")
}) 

public class CompanyEntity implements IEntity<Long> {

	/**
	 * Emerson
	 */
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_ID_GENERATOR")	
	private Long id;
	
	@NotNull 
	@Size(min=2, max = 40)
	@Column
	private String name;
	
	@OneToMany (targetEntity = EmployeeEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="company")
	private List<EmployeeEntity> employees;			

	public CompanyEntity(Long id, String name, List<EmployeeEntity> employees) {
		this.id = id;
		this.name = name;
		this.employees = employees;
	}

	public List<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CompanyEntity() {
		
	}
	
	public CompanyEntity(Long id) {
		this.id = id;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

}
