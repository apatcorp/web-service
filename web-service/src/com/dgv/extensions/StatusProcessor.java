package com.dgv.extensions;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImportParameter;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType.Type;

import com.dgv.factories.JPAEntityManagerFactory;
import com.dgv.models.Status;

public class StatusProcessor {

	@EdmFunctionImport(name="GetStatus", entitySet="Statuss", returnType = @ReturnType(type=Type.ENTITY, isCollection = false))
	public Status getStatusFromDescription (@EdmFunctionImportParameter(name = "StatusDescription")String statusDescription) {
		EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		
		TypedQuery<Status> query = entityManager.createQuery("SELECT s FROM Status s WHERE s.statusDescription = :statusDescription", Status.class);
		query.setParameter("statusDescription", statusDescription);
		
		try {			
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			entityManager.close();
		}
		
	}
}
