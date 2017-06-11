package com.dgv.models;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import com.dgv.models.CardInfo;
import com.dgv.models.Status;
import com.dgv.models.ChipColour;
import com.dgv.models.DurationEnd;
import com.dgv.models.Customer;

@Entity
@Table(name = "HA_PROJECT")
public class HAProject implements Serializable {

	private static final long serialVersionUID = 1L;

	public HAProject() {
	}

	@Id
	@Column(name = "HA_PROJECT_ID")
	@GeneratedValue(strategy = IDENTITY)
	private long hAProjectId;
	private String cardAmount;
	@Column(name = "PIN_AMOUNT")
	private String pinAmount;
	private String delivery;
	private String deliveryDate;
	@OneToOne
	private CardInfo cardInfo;
	@OneToOne
	private Status status;
	@OneToOne
	private ChipColour chipColour;
	@OneToOne
	private DurationEnd durationEnd;
	@ManyToOne
	private Customer customer;

	public long getHAProjectId() {
		return hAProjectId;
	}

	public void setHAProjectId(long id) {
		this.hAProjectId = id;
	}

	public String getCardAmount() {
		return cardAmount;
	}

	public void setCardAmount(String param) {
		this.cardAmount = param;
	}

	public String getPinAmount() {
		return pinAmount;
	}

	public void setPinAmount(String param) {
		this.pinAmount = param;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String param) {
		this.delivery = param;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String param) {
		this.deliveryDate = param;
	}

	public CardInfo getCardInfo() {
	    return cardInfo;
	}

	public void setCardInfo(CardInfo param) {
	    this.cardInfo = param;
	}

	public Status getStatus() {
	    return status;
	}

	public void setStatus(Status param) {
	    this.status = param;
	}

	public ChipColour getChipColour() {
	    return chipColour;
	}

	public void setChipColour(ChipColour param) {
	    this.chipColour = param;
	}

	public DurationEnd getDurationEnd() {
	    return durationEnd;
	}

	public void setDurationEnd(DurationEnd param) {
	    this.durationEnd = param;
	}

	public Customer getCustomer() {
	    return customer;
	}

	public void setCustomer(Customer param) {
	    this.customer = param;
	}

}