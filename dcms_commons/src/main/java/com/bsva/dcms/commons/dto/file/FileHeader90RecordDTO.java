package com.bsva.dcms.commons.dto.file;

public class FileHeader90RecordDTO {

	private String transactionCode;
	private String processingBin;
	private String processingDate;
	private String testOption;
	private String securityCode;
	private String outgointFileId;
	private String reserved1;
	private String reserved2;
	private String reserved3;
	private String reserved4;

	private String record;
	private int lineNumber;
	private int recordOffset = 0; // transaction line number , 4 lines include one transaction, header + trailer
	private boolean isCurrentRecordValid = true;

	public String getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getProcessingBin() {
		return processingBin;
	}
	public void setProcessingBin(String processingBin) {
		this.processingBin = processingBin;
	}

	public String getProcessingDate() {
		return processingDate;
	}
	public void setProcessingDate(String processingDate) {
		this.processingDate = processingDate;
	}

	public String getReserved1() {
		return reserved1;
	}
	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}

	public String getTestOption() {
		return testOption;
	}
	public void setTestOption(String testOption) {
		this.testOption = testOption;
	}

	public String getReserved2() {
		return reserved2;
	}
	public void setReserved2(String reserved2) {
		this.reserved2 = reserved2;
	}

	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getReserved3() {
		return reserved3;
	}
	public void setReserved3(String reserved3) {
		this.reserved3 = reserved3;
	}

	public String getOutgointFileId() {
		return outgointFileId;
	}
	public void setOutgointFileId(String outgointFileId) {
		this.outgointFileId = outgointFileId;
	}

	public String getReserved4() {
		return reserved4;
	}
	public void setReserved4(String reserved4) {
		this.reserved4 = reserved4;
	}

	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public int getRecordOffset() {
		return recordOffset;
	}
	public void setRecordOffset(int recordOffset) {
		this.recordOffset = recordOffset;
	}
	public boolean isCurrentRecordValid() {
		return isCurrentRecordValid;
	}
	public void setCurrentRecordValid(boolean isCurrentRecordValid) {
		this.isCurrentRecordValid = isCurrentRecordValid;
	}

	public String toString(){

		StringBuffer buff = new StringBuffer();

		buff.append(getTransactionCode());
		buff.append(getProcessingBin());
		buff.append(getProcessingDate());
		buff.append(getReserved1());
		buff.append(getTestOption());
		buff.append(getReserved2());
		buff.append(getSecurityCode());
		buff.append(getReserved3());
		buff.append(getOutgointFileId());
		buff.append(getReserved4());

		return buff.toString();

	}


}
