package com.dgv.models;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "DURATION_END")
public class DurationEnd implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DURATION_END_ID")
	@GeneratedValue(strategy = IDENTITY)
	private long durationEndId;

	private String endDate;

	public DurationEnd() {
	}

	public long getDurationEndId() {
		return durationEndId;
	}

	public void setDurationEndId(long id) {
		this.durationEndId = id;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String param) {
		this.endDate = param;
	}

}