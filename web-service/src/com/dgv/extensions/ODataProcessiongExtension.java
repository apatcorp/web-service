package com.dgv.extensions;

import java.io.InputStream;

import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmExtension;
import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmSchemaView;

public class ODataProcessiongExtension implements JPAEdmExtension {

	@Override
	public void extendJPAEdmSchema(JPAEdmSchemaView arg0) {
		
	}

	@Override
	public void extendWithOperation(JPAEdmSchemaView arg0) {
		arg0.registerOperations(CustomerProcessor.class, null);
		arg0.registerOperations(StatusProcessor.class, null);
	}

	@Override
	public InputStream getJPAEdmMappingModelStream() {
		
		return null;
	}

}
