package com.dgv.util;

import java.util.Collection;

import com.dgv.models.Customer;
import com.dgv.models.HAProject;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class GsonCustomerConverter {

	
	public static String convertCustomerToJSon (Customer customer) {
		Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
			
			@Override
			public boolean shouldSkipField(FieldAttributes f) {
				// TODO Auto-generated method stub
				return (f.getDeclaredClass() == Customer.class && f.getName().equals("hAProject")) ||
						(f.getDeclaredClass() == HAProject.class && f.getName().equals("customer"));
			}
			
			@Override
			public boolean shouldSkipClass(Class<?> clazz) {
				// TODO Auto-generated method stub
				return clazz == Collection.class;
			}
		}).create();
		
		String customerAsJson= gson.toJson(customer);
		
		Collection<HAProject> list = customer.getHAProject();
		String haProjectsAsJson = gson.toJson(list);
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("Customer", customerAsJson);
		jsonObject.addProperty("Projects", haProjectsAsJson);
		
		return jsonObject.toString();
	}
	

}
