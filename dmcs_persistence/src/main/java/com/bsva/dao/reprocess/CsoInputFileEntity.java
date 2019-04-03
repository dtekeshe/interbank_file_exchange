package com.bsva.dao.reprocess;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CSO_INPUT_FILE_CONTROLS")
public class CsoInputFileEntity {

	@Column(name = "FILE_REF_NUMBER")
	private String fileName;
	@Column(name = "OUTPUT_DATE")
	private String loadDate;
	@Column(name="NUMBER_OF_RECS")
	private String numberOfRecs;         
	@Column(name="NUMBER_CREDITS ")              
	private String numberCredits;
	@Column(name = "NUMBER_DEBITS")
	private String numberDebits;
	@Column(name = "CREDIT_VALUE")
	private String creditValue;
	@Column(name = "DEBIT_VALUE")
	private String debitValue;
	@Column(name = "PROCESS_STATUS")
	private String processStatus;
	@Column(name = "ORIGINATING_MEMBER")
	private String originatingMember;
	@Id
	@Column(name = "SYSTEM_SEQ_NUMBER")
	@NotNull
	private String systemSeqNumber;
	@Column(name = "ODS_DATA_STATUS")
	private String odsDataStatus;
	@Column(name = "NUMBER_OF_REJECTS")
	private String numberOfNonFin;
	@Column(name = "NEGATIVE_DUPLICATE_COUNT")
	private String negativeDuplicateCount;
	@Column(name = "NEGATIVE_CARD_COUNT")
	private String negativeCardCount;
	
	
	public CsoInputFileEntity(){
		
	}


	public String getFileName() {
		return fileName;
	}


	public String getLoadDate() {
		return loadDate;
	}


	public String getNumberOfRecs() {
		return numberOfRecs;
	}


	public String getNumberCredits() {
		return numberCredits;
	}


	public String getNumberDebits() {
		return numberDebits;
	}


	public String getCreditValue() {
		return creditValue;
	}


	public String getDebitValue() {
		return debitValue;
	}


	public String getProcessStatus() {
		return processStatus;
	}


	public String getOriginatingMember() {
		return originatingMember;
	}


	public String getSystemSeqNumber() {
		return systemSeqNumber;
	}


	public String getOdsDataStatus() {
		return odsDataStatus;
	}


	public String getNumberOfNonFin() {
		return numberOfNonFin;
	}


	public String getNegativeDuplicateCount() {
		return negativeDuplicateCount;
	}


	public String getNegativeCardCount() {
		return negativeCardCount;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public void setLoadDate(String loadDate) {
		this.loadDate = loadDate;
	}


	public void setNumberOfRecs(String numberOfRecs) {
		this.numberOfRecs = numberOfRecs;
	}


	public void setNumberCredits(String numberCredits) {
		this.numberCredits = numberCredits;
	}


	public void setNumberDebits(String numberDebits) {
		this.numberDebits = numberDebits;
	}


	public void setCreditValue(String creditValue) {
		this.creditValue = creditValue;
	}


	public void setDebitValue(String debitValue) {
		this.debitValue = debitValue;
	}


	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}


	public void setOriginatingMember(String originatingMember) {
		this.originatingMember = originatingMember;
	}


	public void setSystemSeqNumber(String systemSeqNumber) {
		this.systemSeqNumber = systemSeqNumber;
	}


	public void setOdsDataStatus(String odsDataStatus) {
		this.odsDataStatus = odsDataStatus;
	}


	public void setNumberOfNonFin(String numberOfNonFin) {
		this.numberOfNonFin = numberOfNonFin;
	}


	public void setNegativeDuplicateCount(String negativeDuplicateCount) {
		this.negativeDuplicateCount = negativeDuplicateCount;
	}


	public void setNegativeCardCount(String negativeCardCount) {
		this.negativeCardCount = negativeCardCount;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creditValue == null) ? 0 : creditValue.hashCode());
		result = prime * result + ((debitValue == null) ? 0 : debitValue.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((loadDate == null) ? 0 : loadDate.hashCode());
		result = prime * result + ((negativeCardCount == null) ? 0 : negativeCardCount.hashCode());
		result = prime * result + ((negativeDuplicateCount == null) ? 0 : negativeDuplicateCount.hashCode());
		result = prime * result + ((numberCredits == null) ? 0 : numberCredits.hashCode());
		result = prime * result + ((numberDebits == null) ? 0 : numberDebits.hashCode());
		result = prime * result + ((numberOfNonFin == null) ? 0 : numberOfNonFin.hashCode());
		result = prime * result + ((numberOfRecs == null) ? 0 : numberOfRecs.hashCode());
		result = prime * result + ((odsDataStatus == null) ? 0 : odsDataStatus.hashCode());
		result = prime * result + ((originatingMember == null) ? 0 : originatingMember.hashCode());
		result = prime * result + ((processStatus == null) ? 0 : processStatus.hashCode());
		result = prime * result + ((systemSeqNumber == null) ? 0 : systemSeqNumber.hashCode());
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
		CsoInputFileEntity other = (CsoInputFileEntity) obj;
		if (creditValue == null) {
			if (other.creditValue != null)
				return false;
		}
		else if (!creditValue.equals(other.creditValue))
			return false;
		if (debitValue == null) {
			if (other.debitValue != null)
				return false;
		}
		else if (!debitValue.equals(other.debitValue))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		}
		else if (!fileName.equals(other.fileName))
			return false;
		if (loadDate == null) {
			if (other.loadDate != null)
				return false;
		}
		else if (!loadDate.equals(other.loadDate))
			return false;
		if (negativeCardCount == null) {
			if (other.negativeCardCount != null)
				return false;
		}
		else if (!negativeCardCount.equals(other.negativeCardCount))
			return false;
		if (negativeDuplicateCount == null) {
			if (other.negativeDuplicateCount != null)
				return false;
		}
		else if (!negativeDuplicateCount.equals(other.negativeDuplicateCount))
			return false;
		if (numberCredits == null) {
			if (other.numberCredits != null)
				return false;
		}
		else if (!numberCredits.equals(other.numberCredits))
			return false;
		if (numberDebits == null) {
			if (other.numberDebits != null)
				return false;
		}
		else if (!numberDebits.equals(other.numberDebits))
			return false;
		if (numberOfNonFin == null) {
			if (other.numberOfNonFin != null)
				return false;
		}
		else if (!numberOfNonFin.equals(other.numberOfNonFin))
			return false;
		if (numberOfRecs == null) {
			if (other.numberOfRecs != null)
				return false;
		}
		else if (!numberOfRecs.equals(other.numberOfRecs))
			return false;
		if (odsDataStatus == null) {
			if (other.odsDataStatus != null)
				return false;
		}
		else if (!odsDataStatus.equals(other.odsDataStatus))
			return false;
		if (originatingMember == null) {
			if (other.originatingMember != null)
				return false;
		}
		else if (!originatingMember.equals(other.originatingMember))
			return false;
		if (processStatus == null) {
			if (other.processStatus != null)
				return false;
		}
		else if (!processStatus.equals(other.processStatus))
			return false;
		if (systemSeqNumber == null) {
			if (other.systemSeqNumber != null)
				return false;
		}
		else if (!systemSeqNumber.equals(other.systemSeqNumber))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CsoInputFileEntity [fileName=");
		builder.append(fileName);
		builder.append(", loadDate=");
		builder.append(loadDate);
		builder.append(", numberOfRecs=");
		builder.append(numberOfRecs);
		builder.append(", numberCredits=");
		builder.append(numberCredits);
		builder.append(", numberDebits=");
		builder.append(numberDebits);
		builder.append(", creditValue=");
		builder.append(creditValue);
		builder.append(", debitValue=");
		builder.append(debitValue);
		builder.append(", processStatus=");
		builder.append(processStatus);
		builder.append(", originatingMember=");
		builder.append(originatingMember);
		builder.append(", systemSeqNumber=");
		builder.append(systemSeqNumber);
		builder.append(", odsDataStatus=");
		builder.append(odsDataStatus);
		builder.append(", numberOfNonFin=");
		builder.append(numberOfNonFin);
		builder.append(", negativeDuplicateCount=");
		builder.append(negativeDuplicateCount);
		builder.append(", negativeCardCount=");
		builder.append(negativeCardCount);
		builder.append("]");
		return builder.toString();
	}
}
