package com.dgv.factories;


import javax.persistence.EntityManagerFactory;

import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;

import com.dgv.constants.Constants;
import com.dgv.extensions.ODataProcessiongExtension;

public class MainODataServiceFactory extends ODataJPAServiceFactory {

	@Override
	public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {
		// get the oDataJPAContext
		ODataJPAContext oDataJPAContext = this.getODataJPAContext();
		EntityManagerFactory emf = JPAEntityManagerFactory.getEntityManagerFactory();	
		
		oDataJPAContext.setEntityManagerFactory(emf);		
		oDataJPAContext.setPersistenceUnitName(Constants.PERSISTENCE_UNIT_NAME);
		oDataJPAContext.setJPAEdmExtension(new ODataProcessiongExtension());
			
		return oDataJPAContext;
	}

}
