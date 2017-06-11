package com.dgv.extensions;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.odata2.api.edm.EdmSimpleTypeKind;
import org.apache.olingo.odata2.api.edm.provider.ComplexType;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.Schema;
import org.apache.olingo.odata2.api.edm.provider.SimpleProperty;
import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmExtension;
import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmSchemaView;

public class ODataProcessiongExtension implements JPAEdmExtension {

	@Override
	public void extendJPAEdmSchema(JPAEdmSchemaView arg0) {
		Schema schema = arg0.getEdmSchema();
		schema.getComplexTypes().add(getComplexType());
	}

	@Override
	public void extendWithOperation(JPAEdmSchemaView arg0) {
		arg0.registerOperations(CustomerProcessor.class, null);

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

      property.setName("HAProjectId");
      property.setType(EdmSimpleTypeKind.Int64);
      properties.add(property);

      property = new SimpleProperty();
      property.setName("CardAmount");
      property.setType(EdmSimpleTypeKind.String);
      properties.add(property);

      property = new SimpleProperty();
      property.setName("PinAmount");
      property.setType(EdmSimpleTypeKind.String);
      properties.add(property);
      
      property = new SimpleProperty();
      property.setName("Delivery");
      property.setType(EdmSimpleTypeKind.String);
      properties.add(property);
      
      property = new SimpleProperty();
      property.setName("DeliveryDate");
      property.setType(EdmSimpleTypeKind.String);
      properties.add(property);
      
      property = new SimpleProperty();
      property.setName("CardInfoId");
      property.setType(EdmSimpleTypeKind.Int64);
      properties.add(property);
      
      property = new SimpleProperty();
      property.setName("Description");
      property.setType(EdmSimpleTypeKind.String);
      properties.add(property);
      
      property = new SimpleProperty();
      property.setName("ImageURL");
      property.setType(EdmSimpleTypeKind.String);
      properties.add(property);
      
      property = new SimpleProperty();
      property.setName("StatusId");
      property.setType(EdmSimpleTypeKind.Int64);
      properties.add(property);
      
      property = new SimpleProperty();
      property.setName("StatusDescription");
      property.setType(EdmSimpleTypeKind.String);
      properties.add(property);
      
      property = new SimpleProperty();
      property.setName("StatusIcon");
      property.setType(EdmSimpleTypeKind.String);
      properties.add(property);
      
      property = new SimpleProperty();
      property.setName("DurationEndId");
      property.setType(EdmSimpleTypeKind.Int64);
      properties.add(property);
      
      property = new SimpleProperty();
      property.setName("endDate");
      property.setType(EdmSimpleTypeKind.String);
      properties.add(property);
      
      property = new SimpleProperty();
      property.setName("ChipColourId");
      property.setType(EdmSimpleTypeKind.Int64);
      properties.add(property);
      
      property = new SimpleProperty();
      property.setName("Colour");
      property.setType(EdmSimpleTypeKind.String);
      properties.add(property);
      
      complexType.setName("Projects");
      complexType.setProperties(properties);

      return complexType;
		
	}
}
