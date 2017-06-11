package com.dgv.extensions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType.Type;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImportParameter;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType;

import com.dgv.factories.JPAEntityManagerFactory;
import com.dgv.models.Customer;
import com.dgv.models.HAProject;

public class CustomerProcessor {

	/*@EdmFunctionImport(name="GetCustomerDetails", entitySet="Customers", returnType = @ReturnType(type=Type.SIMPLE, isCollection = false))
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
	}*/
	
	@EdmFunctionImport(name="GetHAProjectDetails", returnType = @ReturnType(type=Type.COMPLEX, isCollection = true))
	public List<Projects> getCustomerDetails (@EdmFunctionImportParameter(name = "CustomerId") String customerId) {
		EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		
		long customerIdAsLong = Long.parseLong(customerId);
		TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.customerId = :customerId", Customer.class);
		query.setParameter("customerId", customerIdAsLong);
		
		try {
			Customer customer = query.getSingleResult();
			List<Projects> list = new ArrayList<>();
			Collection<HAProject> haProjects = customer.getHAProject();
			
			for (HAProject haProject: haProjects) {
				Projects p = new Projects();
				
				p.setHaProjectId(haProject.getHAProjectId());
				p.setCardAmount(haProject.getCardAmount());
				p.setPinAmount(haProject.getPinAmount());
				p.setDelivery(haProject.getDelivery());
				p.setDeliveryDate(haProject.getDeliveryDate());
				
				p.setCardInfoId(haProject.getCardInfo().getCardInfoId());
				p.setDescription(haProject.getCardInfo().getDescription());
				p.setImageURL(haProject.getCardInfo().getImageURL());
				
				p.setStatusId(haProject.getStatus().getStatusId());
				p.setStatusDescription(haProject.getStatus().getStatusDescription());
				p.setStatusIcon(haProject.getStatus().getStatusIcon());
				
				p.setDurationEndId(haProject.getDurationEnd().getDurationEndId());
				p.setEndDate(haProject.getDurationEnd().getEndDate());
				
				p.setChipColourId(haProject.getChipColour().getChipColourId());
				p.setColour(haProject.getChipColour().getColour());
				
				list.add(p);
			}
			
			
			return list;
		} catch (NoResultException e) {
			return null;
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
