package com.dgv.extensions;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType.Type;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImportParameter;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType;

import com.dgv.factories.JPAEntityManagerFactory;
import com.dgv.models.Customer;


public class CustomerProcessor {

	@EdmFunctionImport(name="Registered", entitySet="Customers", returnType = @ReturnType(type=Type.SIMPLE, isCollection = false))
	public boolean isCustomerRegistered (@EdmFunctionImportParameter(name = "CustomerNo")String customerNo) {
		EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		
		TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.customerNo = :customerNo", Customer.class);
		query.setParameter("customerNo", customerNo);
		
		try {
			query.getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		} finally {
			entityManager.close();
		}
	}
}
