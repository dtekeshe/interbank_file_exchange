package com.bsva.entities.v02;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


/**
 * @author AugustineA
 *
 */
@Entity
@Table(name="CSO_PAYMENT_INSTRUCTIONS_MCARD")
@DynamicUpdate
public class ChargeBackEntity implements Serializable {
	 /**
	 * 
	 */
	
	 private static final long serialVersionUID = 1L;
	 
	 @EmbeddedId
	 private ChargeBacksEntity_PK id;	
	 @Column(name = "P2_PAN")
	 private String p2Pan;
	 @Column(name = "P31_ACQUIRER_REF_DATA")
	 private String p31AcquirerRefData;
	 @Column(name = "P12_LOCAL_DATE")
	 private String p12LocalDate;
	 @Column(name = "P4_TRANSACTION_AMOUNT")
	 private String p4TransactionAmount;
	 @Column(name = "P38_APPROVAL_CODE")
	 private String p38ApprovalCode;
	 @Column(name = "P43_CARD_ACCEPTOR_NAME")
	 private String p43CardAcceptorName;
	 @Column(name = "P26_CARD_ACCEPTOR_BUS_CODE")
	 private String p26CardAcceptorBusCode;
	 @Column(name = "P25_MESSAGE_REASON_CODE")
	 private String p25MessageReasonCode;
	 @Column(name = "USAGE_CODE")
	 private String usageCode;
	 
	 public ChargeBackEntity(){
		 
	 }

	public ChargeBackEntity(ChargeBacksEntity_PK id, String p2Pan, String p31AcquirerRefData, String p12LocalDate,
			String p4TransactionAmount, String p38ApprovalCode, String p43CardAcceptorName,
			String p26CardAcceptorBusCode, String p25MessageReasonCode, String usageCode) {
		super();
		this.id = id;
		this.p2Pan = p2Pan;
		this.p31AcquirerRefData = p31AcquirerRefData;
		this.p12LocalDate = p12LocalDate;
		this.p4TransactionAmount = p4TransactionAmount;
		this.p38ApprovalCode = p38ApprovalCode;
		this.p43CardAcceptorName = p43CardAcceptorName;
		this.p26CardAcceptorBusCode = p26CardAcceptorBusCode;
		this.p25MessageReasonCode = p25MessageReasonCode;
		this.usageCode = usageCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ChargeBacksEntity_PK getId() {
		return id;
	}

	public String getP2Pan() {
		return p2Pan;
	}

	public String getP31AcquirerRefData() {
		return p31AcquirerRefData;
	}

	public String getP12LocalDate() {
		return p12LocalDate;
	}

	public String getP4TransactionAmount() {
		return p4TransactionAmount;
	}

	public String getP38ApprovalCode() {
		return p38ApprovalCode;
	}

	public String getP43CardAcceptorName() {
		return p43CardAcceptorName;
	}

	public String getP26CardAcceptorBusCode() {
		return p26CardAcceptorBusCode;
	}

	public String getP25MessageReasonCode() {
		return p25MessageReasonCode;
	}

	public String getUsageCode() {
		return usageCode;
	}

	public void setId(ChargeBacksEntity_PK id) {
		this.id = id;
	}

	public void setP2Pan(String p2Pan) {
		this.p2Pan = p2Pan;
	}

	public void setP31AcquirerRefData(String p31AcquirerRefData) {
		this.p31AcquirerRefData = p31AcquirerRefData;
	}

	public void setP12LocalDate(String p12LocalDate) {
		this.p12LocalDate = p12LocalDate;
	}

	public void setP4TransactionAmount(String p4TransactionAmount) {
		this.p4TransactionAmount = p4TransactionAmount;
	}

	public void setP38ApprovalCode(String p38ApprovalCode) {
		this.p38ApprovalCode = p38ApprovalCode;
	}

	public void setP43CardAcceptorName(String p43CardAcceptorName) {
		this.p43CardAcceptorName = p43CardAcceptorName;
	}

	public void setP26CardAcceptorBusCode(String p26CardAcceptorBusCode) {
		this.p26CardAcceptorBusCode = p26CardAcceptorBusCode;
	}

	public void setP25MessageReasonCode(String p25MessageReasonCode) {
		this.p25MessageReasonCode = p25MessageReasonCode;
	}

	public void setUsageCode(String usageCode) {
		this.usageCode = usageCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((p12LocalDate == null) ? 0 : p12LocalDate.hashCode());
		result = prime * result + ((p25MessageReasonCode == null) ? 0 : p25MessageReasonCode.hashCode());
		result = prime * result + ((p26CardAcceptorBusCode == null) ? 0 : p26CardAcceptorBusCode.hashCode());
		result = prime * result + ((p2Pan == null) ? 0 : p2Pan.hashCode());
		result = prime * result + ((p31AcquirerRefData == null) ? 0 : p31AcquirerRefData.hashCode());
		result = prime * result + ((p38ApprovalCode == null) ? 0 : p38ApprovalCode.hashCode());
		result = prime * result + ((p43CardAcceptorName == null) ? 0 : p43CardAcceptorName.hashCode());
		result = prime * result + ((p4TransactionAmount == null) ? 0 : p4TransactionAmount.hashCode());
		result = prime * result + ((usageCode == null) ? 0 : usageCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChargeBackEntity other = (ChargeBackEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (p12LocalDate == null) {
			if (other.p12LocalDate != null)
				return false;
		} else if (!p12LocalDate.equals(other.p12LocalDate))
			return false;
		if (p25MessageReasonCode == null) {
			if (other.p25MessageReasonCode != null)
				return false;
		} else if (!p25MessageReasonCode.equals(other.p25MessageReasonCode))
			return false;
		if (p26CardAcceptorBusCode == null) {
			if (other.p26CardAcceptorBusCode != null)
				return false;
		} else if (!p26CardAcceptorBusCode.equals(other.p26CardAcceptorBusCode))
			return false;
		if (p2Pan == null) {
			if (other.p2Pan != null)
				return false;
		} else if (!p2Pan.equals(other.p2Pan))
			return false;
		if (p31AcquirerRefData == null) {
			if (other.p31AcquirerRefData != null)
				return false;
		} else if (!p31AcquirerRefData.equals(other.p31AcquirerRefData))
			return false;
		if (p38ApprovalCode == null) {
			if (other.p38ApprovalCode != null)
				return false;
		} else if (!p38ApprovalCode.equals(other.p38ApprovalCode))
			return false;
		if (p43CardAcceptorName == null) {
			if (other.p43CardAcceptorName != null)
				return false;
		} else if (!p43CardAcceptorName.equals(other.p43CardAcceptorName))
			return false;
		if (p4TransactionAmount == null) {
			if (other.p4TransactionAmount != null)
				return false;
		} else if (!p4TransactionAmount.equals(other.p4TransactionAmount))
			return false;
		if (usageCode == null) {
			if (other.usageCode != null)
				return false;
		} else if (!usageCode.equals(other.usageCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append(p2Pan);
		builder.append(p31AcquirerRefData);
		builder.append(p12LocalDate);
		builder.append(p4TransactionAmount);
		builder.append(p38ApprovalCode);
		builder.append(p43CardAcceptorName);
		builder.append(p26CardAcceptorBusCode);
		builder.append(p25MessageReasonCode);
		builder.append(usageCode);
		return builder.toString();
	}


	
	
	 
	 
}
