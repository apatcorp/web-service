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
import com.dgv.util.GsonCustomerConverter;

public class CustomerProcessor {

	@EdmFunctionImport(name="GetCustomerDetails", entitySet="Customers", returnType = @ReturnType(type=Type.SIMPLE, isCollection = false))
	public String getCustomerDetails (@EdmFunctionImportParameter(name = "CustomerId") String customerId) {
		EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		
		long customerIdAsLong = Long.parseLong(customerId);
		TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.customerId = :customerId", Customer.class);
		query.setParameter("customerId", customerIdAsLong);
		
		try {
			Customer customer = query.getSingleResult();
			String customerAsJson = GsonCustomerConverter.convertCustomerToJSon(customer);
			return customerAsJson;
		} catch (NoResultException e) {
			return "" + -1L;
		} finally {
			entityManager.close();
		}
	}
	
	
	
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
