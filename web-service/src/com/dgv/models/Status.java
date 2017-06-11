package com.dgv.models;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "STATUS")
public class Status implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "STATUS_ID")
	@GeneratedValue(strategy = IDENTITY)
	private long statusId;

	private String statusDescription;

	private String statusIcon;

	public Status() {
		super();
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long id) {
		this.statusId = id;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String param) {
		this.statusDescription = param;
	}

	public String getStatusIcon() {
		return statusIcon;
	}

	public void setStatusIcon(String param) {
		this.statusIcon = param;
	}

}