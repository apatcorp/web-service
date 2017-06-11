package com.dgv.factories;

import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;

import com.dgv.constants.Constants;

public class JPAEntityManagerFactory {

	private static EntityManagerFactory entityManagerFactory = null;
	
	public static void createEntityManagerFactory() {
		if (entityManagerFactory == null) {			
			// get the data source
			InitialContext initialContext;
			DataSource dataSource;
			try {
				initialContext = new InitialContext();
				dataSource = (DataSource)initialContext.lookup(Constants.DATA_SOURCE);	
				// mark the data source to be a non jta data source 
				Map<String, Object> properties = new HashMap<String, Object>();
				properties.put(PersistenceUnitProperties.NON_JTA_DATASOURCE, dataSource);		
				// finally create the entity manager factory
				entityManagerFactory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME, properties);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static EntityManagerFactory getEntityManagerFactory () {
		if (entityManagerFactory == null) {
			createEntityManagerFactory();
		}
		return entityManagerFactory;
	}

}
