package com.bsva.entities.v02.loader;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/**
 * TODO Document
 */
@Entity
@DynamicUpdate
public class FileDetailEntity implements Serializable {


	@Id
    @Column(name = "CARD_TRANSACTION")
    private String cardTransaction;
	@Column(name = "FILE_REF_NUMBER")
	private String cardRefNumber;

	public String getCardRefNumber() {
		return cardRefNumber;
	}

	public void setCardRefNumber(String cardRefNumber) {
		this.cardRefNumber = cardRefNumber;
	}

	public String getCardTransaction() {
		return cardTransaction;
	}

	public void setCardTransaction(String cardTransaction) {
		this.cardTransaction = cardTransaction;
	}
}
