package com.dgv.setups;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.dgv.factories.JPAEntityManagerFactory;
import com.dgv.models.CardInfo;
import com.dgv.models.ChipColour;
import com.dgv.models.DurationEnd;
import com.dgv.models.Status;

public class EntityCreation {
	
	public static void setupDB () {
		List<Object> list1 = setupCardInfoEntitys();
		List<Object> list2 = setupChipColourEntitys();
		List<Object> list3 = setupDurationEndEntitys();
		List<Object> list4 = setupStatusEntitys();
		
		EntityManager entityManager = JPAEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			for (Object object : list1) {
				entityManager.persist(object);
			}
			
			for (Object object : list2) {
				entityManager.persist(object);
			}
			
			for (Object object : list3) {
				entityManager.persist(object);
			}
			
			for (Object object : list4) {
				entityManager.persist(object);
			}
			
			entityManager.getTransaction().commit();
			
		} finally {
			entityManager.close();
		}
	}
	
	static List<Object> setupStatusEntitys () {
		List<Object> list = new ArrayList<>();
		
		Status status1 = new Status();
		status1.setStatusDescription("wartet auf Freigabe");
		status1.setStatusIcon("sap-icon://refresh");
		
		Status status2 = new Status();
		status2.setStatusDescription("angenommen");
		status2.setStatusIcon("sap-icon://accept");
		
		list.add(status1);
		list.add(status2);
		
		return list;
	}
	
	static List<Object> setupDurationEndEntitys () {
		List<Object> list = new ArrayList<>();
		
		DurationEnd durationEnd1 = new DurationEnd();
		durationEnd1.setEndDate("2020");
		
		DurationEnd durationEnd2 = new DurationEnd();
		durationEnd2.setEndDate("2021");
		
		DurationEnd durationEnd3 = new DurationEnd();
		durationEnd3.setEndDate("2022");
		
		DurationEnd durationEnd4 = new DurationEnd();
		durationEnd4.setEndDate("2023");
		
		DurationEnd durationEnd5 = new DurationEnd();
		durationEnd5.setEndDate("2024");
		
		DurationEnd durationEnd6 = new DurationEnd();
		durationEnd6.setEndDate("2025");
		
		list.add(durationEnd1);
		list.add(durationEnd2);
		list.add(durationEnd3);
		list.add(durationEnd4);
		list.add(durationEnd5);
		list.add(durationEnd6);
		
		return list;
	}
	
	static List<Object> setupCardInfoEntitys () {
		List<Object> list = new ArrayList<>();
		
		CardInfo cardInfo1 = new CardInfo();
		cardInfo1.setDescription("VR BankCard Maestro");
		cardInfo1.setImageURL("https://www.vrbank-swh.de/privatkunden/girokonto-kreditkarten/service/kontaktloses-bezahlen-mit-der-vr-bankcard-plus/_jcr_content/parsys/kartei/parsys/karteireiter/parsys/textmitbild/image.img.png/1470994413232.jpg");
		
		CardInfo cardInfo2 = new CardInfo();
		cardInfo2.setDescription("VR BankCard Edition");
		cardInfo2.setImageURL("https://www.cardscout.de/imedia/2088/RL8wF6JLqF_Rt1w9DOJjgQP-dSkJ0KCuOrRJI4uxJWM.jpg");
		
		CardInfo cardInfo3 = new CardInfo();
		cardInfo3.setDescription("VR BankCard Plus");
		cardInfo3.setImageURL("https://www.vbwildeshauser-geest.de/privatkunden/girokonto-kreditkarten/kreditkarten/bankkarte-maestro/_jcr_content/parsys/kartei/parsys/karteireiter_2135/parsys/textmitbild_d850/image.img.png/1463045478538.jpg");
		
		list.add(cardInfo1);
		list.add(cardInfo2);
		list.add(cardInfo3);
		
		return list;
	}
	
	static List<Object> setupChipColourEntitys () {
		List<Object> list = new ArrayList<>();
		
		ChipColour chipColour1 = new ChipColour();
		chipColour1.setColour("silber");
		
		ChipColour chipColour2 = new ChipColour();
		chipColour2.setColour("gold");
		
		ChipColour chipColour3 = new ChipColour();
		chipColour3.setColour("kontaktlos");
		
		list.add(chipColour1);
		list.add(chipColour2);
		list.add(chipColour3);
		
		return list;
	}
	
}
