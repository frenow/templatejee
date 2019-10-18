package com.template.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="EMPLOYEE")
@SequenceGenerator(name = "EMPLOYEE_ID_GENERATOR", sequenceName = "SE_EMPLOYEE", allocationSize = 1)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@NamedQueries({
    @NamedQuery(name="EmployeeEntity.retrieveAll", query="Select distinct e from EmployeeEntity e")
}) 
public class EmployeeEntity implements IEntity<Long> {
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_ID_GENERATOR")	
	private Long id;
	
	@NotNull 
	@Size(min=2, max = 40)
	@Column
	private String name;
	
    @ManyToOne (targetEntity = CompanyEntity.class)  
    @JoinColumn(name="COMPANY_ID", referencedColumnName="ID")
    @XmlTransient
    private CompanyEntity company;	
    
	
	public CompanyEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyEntity company) {
		this.company = company;
	}

	public EmployeeEntity() {

	}


	public EmployeeEntity(Long id, String name, CompanyEntity company) {
		this.id = id;
		this.name = name;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
