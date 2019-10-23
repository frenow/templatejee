package com.template.app.service.repository;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import com.template.app.entity.CompanyEntity;
import com.template.app.exception.AppException;
import com.template.app.messages.AppBeanMessages;

@Stateless
@Local
public class CompanyRepository {
	
	@PersistenceContext(unitName = "company-persistence-unit")
	private EntityManager entityManager;

	private EntityManager getEntityManager()
	{
		return entityManager;
	}	
	
	public List<CompanyEntity> retrieveAll() {
		try {
			System.out.println("repository");
			String namedQuery = "CompanyEntity.retrieveAll";
			
			Query query = getEntityManager().createNamedQuery(namedQuery);

			List<CompanyEntity> list = (List<CompanyEntity>)query.getResultList( );
			return list;
			
			//mock
			//List<CompanyEntity> listCompanies = new ArrayList<CompanyEntity>();
			//listCompanies.add(new CompanyEntity(1L, "Google"));
			//listCompanies.add(new CompanyEntity(2L, "Apple"));
			//listCompanies.add(new CompanyEntity(3L, "Microsoft"));
			//return listCompanies;				

		} catch (AppException e) {
			System.out.println("erro 1"+e);
			throw e;
		} catch (Exception e) {
			System.out.println("erro 2"+e);
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}
	public CompanyEntity get(Long id) {
		try {
			CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
			CriteriaQuery q = cb.createQuery(CompanyEntity.class);
			Root o = q.from(CompanyEntity.class);
			o.fetch("employees", JoinType.LEFT);
			q.select(o);
			q.where(cb.equal(o.get("id"), id));

			CompanyEntity c = (CompanyEntity)getEntityManager().createQuery(q).getSingleResult();	

			return c;

		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}

	public CompanyEntity persist(CompanyEntity companyEntity) {
		try {
			getEntityManager().persist(companyEntity);
			return companyEntity;
		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
		
	}

	public void delete(CompanyEntity companyEntity) {
		try {
			getEntityManager().remove(companyEntity);
		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
		
	}
	
	
}
