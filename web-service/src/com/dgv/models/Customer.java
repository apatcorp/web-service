package com.dgv.models;

import java.io.Serializable;
import javax.persistence.*;
import com.dgv.models.HAProject;
import java.util.Collection;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.TABLE;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	public Customer() {
	}

	@Id
	@Column(name = "CUSTOMER_ID", nullable = false)
	@GeneratedValue(strategy = TABLE, generator = "tab")
	@TableGenerator(name = "tab")
	private long customerId;
	private String name;
	private String location;
	private String address;
	private String postcode;
	private String telNo;
	private String contactPerson;
	@OneToMany(mappedBy = "customer", cascade = PERSIST)
	private Collection<HAProject> hAProject;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long id) {
		this.customerId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String param) {
		this.name = param;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String param) {
		this.location = param;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String param) {
		this.address = param;
	}


	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String param) {
		this.telNo = param;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String param) {
		this.contactPerson = param;
	}

	public Collection<HAProject> getHAProject() {
	    return hAProject;
	}

	public void setHAProject(Collection<HAProject> param) {
	    this.hAProject = param;
	}

}