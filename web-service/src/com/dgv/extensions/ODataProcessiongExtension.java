package com.dgv.extensions;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.odata2.api.edm.EdmSimpleTypeKind;
import org.apache.olingo.odata2.api.edm.provider.ComplexType;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;
import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmExtension;
import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmSchemaView;

public class ODataProcessiongExtension implements JPAEdmExtension {

	@Override
	public void extendJPAEdmSchema(JPAEdmSchemaView arg0) {
		arg0.registerOperations(CustomerProcessor.class, null);
	}

	@Override
	public void extendWithOperation(JPAEdmSchemaView arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public InputStream getJPAEdmMappingModelStream() {
		// TODO Auto-generated method stub
		return null;
	}

	private ComplexType getComplexType () {
	 ComplexType complexType = new ComplexType();

      List<Property> properties = new ArrayList<Property>();
      SimpleProperty property = new SimpleProperty();

      property.setName("Amount");
      property.setType(EdmSimpleTypeKind.Int16);
      properties.add(property);

      property = new SimpleProperty();
      property.setName("Currency");
      property.setType(EdmSimpleTypeKind.String);
      properties.add(property);

      complexType.setName("OrderValue");
      complexType.setProperties(properties);

      return complexType;
		
	}
}
