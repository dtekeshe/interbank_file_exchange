package com.bsva.dcms.commons.dto.file;

import java.util.List;

public class FileDTO {
	
	private String fileStatus = "A";
	private String fileName;
	private String fileRefNumber;   // filename + processing date
	private String fileService = "";  
	private String fileSubService = ""; 
	private int fileOriginator = 0; 
	private int fileLinesCount = 0;		
	private FileAXSHeaderRecordDTO fileAXSHeaderRecordDto;
	private List<FileTransactionRecordDTO>  fileTransactionRecordDtoList;
	private FileEOS98RecordDTO fileEOS98RecordDto;
	private FileAXSTrailorRecordDTO fileAxsTrailorRecordDto;
	private ErrorDTO errorDto = new ErrorDTO();
	private int recordCount = 0; 
	private long fileSystemSeqNumber;
	private String lastFileIndicator = null;
	private String fileNumber = null;
	private long hashTotal = 0L;
	private String bankCode = null;
	private int troRecordCount = 0;
	private int internalCounter = 0;
		
	
	public int getInternalCounter() {
		return internalCounter;
	}
	public void setInternalCounter(int internalCounter) {
		this.internalCounter = internalCounter;
	}
	public int getTroRecordCount() {
		return troRecordCount;
	}
	public void setTroRecordCount(int troRecordCount) {
		this.troRecordCount = troRecordCount;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public long getHashTotal() {
		return hashTotal;
	}
	public void setHashTotal(long hashTotal) {
		this.hashTotal = hashTotal;
	}
	public String getFileNumber() {
		return fileNumber;
	}
	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}
	public String getLastFileIndicator() {
		return lastFileIndicator;
	}
	public void setLastFileIndicator(String lastFileIndicator) {
		this.lastFileIndicator = lastFileIndicator;
	}
	public String getFileStatus() {
		return fileStatus;
	}
	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}
	public FileAXSHeaderRecordDTO getFileAXSHeaderRecordDto() {
		return fileAXSHeaderRecordDto;
	}
	public void setFileAXSHeaderRecordDto(
			FileAXSHeaderRecordDTO fileAXSHeaderRecordDto) {
		this.fileAXSHeaderRecordDto = fileAXSHeaderRecordDto;
	}

	public List<FileTransactionRecordDTO> getFileTransactionRecordDtoList() {
		return fileTransactionRecordDtoList;
	}
	public void setFileTransactionRecordDtoList(
			List<FileTransactionRecordDTO> fileTransactionRecordDtoList) {
		this.fileTransactionRecordDtoList = fileTransactionRecordDtoList;
	}

	public FileEOS98RecordDTO getFileEOS98RecordDto() {
		return fileEOS98RecordDto;
	}
	public void setFileEOS98RecordDto(FileEOS98RecordDTO fileEOS98RecordDto) {
		this.fileEOS98RecordDto = fileEOS98RecordDto;
	}
	
	public FileAXSTrailorRecordDTO getFileAxsTrailorRecordDto() {
		return fileAxsTrailorRecordDto;
	}
	public void setFileAxsTrailorRecordDto(FileAXSTrailorRecordDTO fileAxsTrailorRecordDto) {
		this.fileAxsTrailorRecordDto = fileAxsTrailorRecordDto;
	}
	public ErrorDTO getErrorDto() {
		return errorDto;
	}
	public void setErrorDto(ErrorDTO errorDto) {
		this.errorDto = errorDto;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileRefNumber() {
		return fileRefNumber;
	}
	public void setFileRefNumber(String fileRefNumber) {
		this.fileRefNumber = fileRefNumber;
	}
	public String getFileService() {
		return fileService;
	}
	public void setFileService(String fileService) {
		this.fileService = fileService;
	}
	public String getFileSubService() {
		return fileSubService;
	}
	public void setFileSubService(String fileSubService) {
		this.fileSubService = fileSubService;
	}

	public int getFileOriginator() {
		return fileOriginator;
	}
	public void setFileOriginator(int fileOriginator) {
		this.fileOriginator = fileOriginator;
	}
	public int getFileLinesCount() {
		return fileLinesCount;
	}
	public void setFileLinesCount(int fileLinesCount) {
		this.fileLinesCount = fileLinesCount;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public long getFileSystemSeqNumber() {
		return fileSystemSeqNumber;
	}
	public void setFileSystemSeqNumber(long fileSystemSeqNumber) {
		this.fileSystemSeqNumber = fileSystemSeqNumber;
	}
	
}
