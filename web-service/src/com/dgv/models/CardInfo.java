package com.dgv.models;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "CARD_INFO")
public class CardInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public CardInfo() {
	}

	@Id
	@Column(name = "CARD_INFO_ID")
	@GeneratedValue(strategy = IDENTITY)
	private long cardInfoId;
	private String description;
	private String imageURL;

	public long getCardInfoId() {
		return cardInfoId;
	}

	public void setCardInfoId(long id) {
		this.cardInfoId = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String param) {
		this.description = param;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String param) {
		this.imageURL = param;
	}

}