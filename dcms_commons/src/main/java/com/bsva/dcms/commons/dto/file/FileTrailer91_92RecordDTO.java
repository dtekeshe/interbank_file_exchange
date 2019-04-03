package com.bsva.dcms.commons.dto.file;

import java.util.List;

//import com.github.ffpojo.metadata.positional.annotation.PositionalField;
//import com.github.ffpojo.metadata.positional.annotation.PositionalRecord;

public class FileTrailer91_92RecordDTO{
	
	private String transactionCode;
	private String tranCodeQualifier;
	private String tcrNumber;
	private String bin;
	private String processingDate;
	private String destinationAmount;
	private String noOfMoneyTransfers;
	private String batchNumber;
	private String noOfTCRs;
	private String centreBatchIndicator;
	private String noOfTransactions;
	private String sourceAmount;
	private String reserved1;
	private String reserved2;
	private String filler;
	private List<FileTransactionRecordDTO>  fileTransactionRecordDtoList;
	private List<NegativeCardRecordDTO> negativeCardRecordDtoList;
	
	
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
	public String getTranCodeQualifier() {
		return tranCodeQualifier;
	}
	public void setTranCodeQualifier(String tranCodeQualifier) {
		this.tranCodeQualifier = tranCodeQualifier;
	}
	public String getTcrNumber() {
		return tcrNumber;
	}
	public void setTcrNumber(String tcrNumber) {
		this.tcrNumber = tcrNumber;
	}
	public String getBin() {
		return bin;
	}
	public void setBin(String bin) {
		this.bin = bin;
	}
	
	public String getProcessingDate() {
		return processingDate;
	}
	public void setProcessingDate(String processingDate) {
		this.processingDate = processingDate;
	}
	
	public String getDestinationAmount() {
		return destinationAmount;
	}
	public void setDestinationAmount(String destinationAmount) {
		this.destinationAmount = destinationAmount;
	}
	
	public String getNoOfMoneyTransfers() {
		return noOfMoneyTransfers;
	}
	public void setNoOfMoneyTransfers(String noOfMoneyTransfers) {
		this.noOfMoneyTransfers = noOfMoneyTransfers;
	}

	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	
	public String getNoOfTCRs() {
		return noOfTCRs;
	}
	public void setNoOfTCRs(String noOfTCRs) {
		this.noOfTCRs = noOfTCRs;
	}
	
	public String getReserved1() {
		return reserved1;
	}
	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}
	
	public String getCentreBatchIndicator() {
		return centreBatchIndicator;
	}
	public void setCentreBatchIndicator(String centreBatchIndicator) {
		this.centreBatchIndicator = centreBatchIndicator;
	}

	public String getNoOfTransactions() {
		return noOfTransactions;
	}
	public void setNoOfTransactions(String noOfTransactions) {
		this.noOfTransactions = noOfTransactions;
	}
	
	public String getReserved2() {
		return reserved2;
	}
	public void setReserved2(String reserved2) {
		this.reserved2 = reserved2;
	}
	
	public String getSourceAmount() {
		return sourceAmount;
	}
	public void setSourceAmount(String sourceAmount) {
		this.sourceAmount = sourceAmount;
	}
	
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	
	
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
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
	
	public List<FileTransactionRecordDTO> getFileTransactionRecordDtoList() {
		return fileTransactionRecordDtoList;
	}
	public void setFileTransactionRecordDtoList(
			List<FileTransactionRecordDTO> fileTransactionRecordDtoList) {
		this.fileTransactionRecordDtoList = fileTransactionRecordDtoList;
	}

	public List<NegativeCardRecordDTO> getNegativeCardRecordDtoList() {
		return negativeCardRecordDtoList;
	}
	public void setNegativeCardRecordDtoList(
			List<NegativeCardRecordDTO> negativeCardRecordDtoList) {
		this.negativeCardRecordDtoList = negativeCardRecordDtoList;
	}
	
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	
	
	public String toString(){
		
		StringBuffer buff = new StringBuffer();
		buff.append(getTransactionCode());
		buff.append(getTranCodeQualifier());
		buff.append(getTcrNumber());
		buff.append(getBin());
		buff.append(getProcessingDate());
		buff.append(getDestinationAmount());
		buff.append(getNoOfMoneyTransfers());
		buff.append(getBatchNumber());
		buff.append(getNoOfTCRs());
		buff.append(getReserved1());
		buff.append(getCentreBatchIndicator());
		buff.append(getNoOfTransactions());
		buff.append(getReserved2());
		buff.append(getSourceAmount());
		buff.append(getFiller());
		
		return buff.toString();
	}

	
}
