package com.dgv.models;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "CHIP_COLOUR")
public class ChipColour implements Serializable {

	private static final long serialVersionUID = 1L;

	public ChipColour() {
	}

	@Id
	@Column(name = "CHIP_COLOUR_ID")
	@GeneratedValue(strategy = IDENTITY)
	private long chipColourId;
	private String colour;

	public long getChipColourId() {
		return chipColourId;
	}

	public void setChipColourId(long id) {
		this.chipColourId = id;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String param) {
		this.colour = param;
	}

}