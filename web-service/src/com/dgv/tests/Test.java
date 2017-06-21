package com.dgv.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.dgv.factories.JPAEntityManagerFactory;
import com.dgv.models.CardInfo;
import com.dgv.models.ChipColour;
import com.dgv.models.Customer;
import com.dgv.models.DurationEnd;
import com.dgv.models.HAProject;
import com.dgv.models.Status;

public class Test {

	public static void addCustomer() {
		Customer customer = createCustomerEntity();
		
		EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(customer);
			entityManager.getTransaction().commit();
			
		} finally {
			entityManager.close();
		}
	}
	
	static Customer createCustomerEntity () {
		Customer customer = new Customer();
		customer.setCustomerId(10090000);
		customer.setName("Berliner Volksbank");
		customer.setLocation("Berlin");
		customer.setAddress("Kurfürstendamm 112");
		customer.setPostcode("10200");
		customer.setContactPerson("Jürgen Heiler");
		customer.setTelNo("030 30633300");
		
		List<HAProject> list = setHAProject(customer);
		customer.setHAProject(list);
		
		return customer;
	}
	
	static List<HAProject> setHAProject (Customer customer) {
		List<HAProject> list = new ArrayList<>();
		
		HAProject haProject1 = new HAProject();
		haProject1.setCardAmount("" + ThreadLocalRandom.current().nextInt(100, 1000000));
		haProject1.setPinAmount("" + ThreadLocalRandom.current().nextInt(100, 1000000));
		haProject1.setDelivery("Direktversand / Direktversand");
		haProject1.setDeliveryDate("W25, 2017");
		haProject1.setCardInfo(getCardInfo());
		haProject1.setChipColour(getChipColour());
		haProject1.setDurationEnd(getDurationEnd());
		haProject1.setStatus(getStatus());
		haProject1.setCustomer(customer);
		
		HAProject haProject2 = new HAProject();
		haProject2.setCardAmount("" + ThreadLocalRandom.current().nextInt(100, 1000000));
		haProject2.setPinAmount("" + ThreadLocalRandom.current().nextInt(100, 1000000));
		haProject2.setDelivery("Direktversand / Direktversand");
		haProject2.setDeliveryDate("W25, 2017");
		haProject2.setCardInfo(getCardInfo());
		haProject2.setChipColour(getChipColour());
		haProject2.setDurationEnd(getDurationEnd());
		haProject2.setStatus(getStatus());
		haProject2.setCustomer(customer);
		
		HAProject haProject3 = new HAProject();
		haProject3.setCardAmount("" + ThreadLocalRandom.current().nextInt(100, 1000000));
		haProject3.setPinAmount("" + ThreadLocalRandom.current().nextInt(100, 1000000));
		haProject3.setDelivery("Direktversand / Sammelversnad");
		haProject3.setDeliveryDate("03.06.2017");
		haProject3.setCardInfo(getCardInfo());
		haProject3.setChipColour(getChipColour());
		haProject3.setDurationEnd(getDurationEnd());
		haProject3.setStatus(getStatus());
		haProject3.setCustomer(customer);
		
		HAProject haProject4 = new HAProject();
		haProject4.setCardAmount("" + ThreadLocalRandom.current().nextInt(100, 1000000));
		haProject4.setPinAmount("" + ThreadLocalRandom.current().nextInt(100, 1000000));
		haProject4.setDelivery("Sammelversand / Direktversand");
		haProject4.setDeliveryDate("23.09.2017");
		haProject4.setCardInfo(getCardInfo());
		haProject4.setChipColour(getChipColour());
		haProject4.setDurationEnd(getDurationEnd());
		haProject4.setStatus(getStatus());
		haProject4.setCustomer(customer);
		
		list.add(haProject1);
		list.add(haProject2);
		list.add(haProject3);
		list.add(haProject4);
		
		return list;
	}
	
	static Status getStatus () {
		String[] statusOptions = {"wartet auf Freigabe", "angenommen"};
		
		EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		
		TypedQuery<Status> query = entityManager.createQuery("SELECT s FROM Status s WHERE s.statusDescription = :status", Status.class);
		query.setParameter("status", statusOptions[ThreadLocalRandom.current().nextInt(0, statusOptions.length)]);
		try {
			return query.getSingleResult();			
		} finally {
			entityManager.close();
		}
	}
	
	static DurationEnd getDurationEnd () {
		String[] durationEndOptions = {"2020", "2021", "2022", "2023", "2024", "2025"};
		
		EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		
		TypedQuery<DurationEnd> query = entityManager.createQuery("SELECT d FROM DurationEnd d WHERE d.endDate = :endDate", DurationEnd.class);
		query.setParameter("endDate", durationEndOptions[ThreadLocalRandom.current().nextInt(0, durationEndOptions.length)]);
		try {
			return query.getSingleResult();			
		} finally {
			entityManager.close();
		}
	}
	
	static CardInfo getCardInfo () {
		String[] cardInfoOptions = {"VR BankCard Maestro", "VR BankCard Edition", "VR BankCard Plus"};
		
		EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		
		TypedQuery<CardInfo> query = entityManager.createQuery("SELECT c FROM CardInfo c WHERE c.description = :description", CardInfo.class);
		query.setParameter("description", cardInfoOptions[ThreadLocalRandom.current().nextInt(0, cardInfoOptions.length)]);
		try {
			return query.getSingleResult();			
		} finally {
			entityManager.close();
		}
	}
	
	static ChipColour getChipColour () {
		String[] chipColourOptions = {"silber", "gold", "kontaktlos"};
		
		EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		
		TypedQuery<ChipColour> query = entityManager.createQuery("SELECT c FROM ChipColour c WHERE c.colour = :colour", ChipColour.class);
		query.setParameter("colour", chipColourOptions[ThreadLocalRandom.current().nextInt(0, chipColourOptions.length)]);
		try {
			return query.getSingleResult();			
		} finally {
			entityManager.close();
		}
	}
}
