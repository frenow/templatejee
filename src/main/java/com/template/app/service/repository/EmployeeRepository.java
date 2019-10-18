package com.template.app.service.repository;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.template.app.entity.EmployeeEntity;
import com.template.app.exception.AppException;
import com.template.app.messages.AppBeanMessages;

@Stateless
@Local
public class EmployeeRepository {

	@PersistenceContext(unitName = "company-persistence-unit")
	private EntityManager entityManager;

	private EntityManager getEntityManager()
	{
		return entityManager;
	}	
	
	public List<EmployeeEntity> retrieveAll() {
		try {
			System.out.println("repository");
			String namedQuery = "EmployeeEntity.retrieveAll";
			
			Query query = getEntityManager().createNamedQuery(namedQuery);

			List<EmployeeEntity> list = (List<EmployeeEntity>)query.getResultList( );
			return list;

		} catch (AppException e) {
			System.out.println("erro 1"+e);
			throw e;
		} catch (Exception e) {
			System.out.println("erro 2"+e);
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}	

}
