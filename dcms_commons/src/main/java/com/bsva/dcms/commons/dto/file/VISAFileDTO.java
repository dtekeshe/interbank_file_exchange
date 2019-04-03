package com.bsva.dcms.commons.dto.file;

import java.util.List;

public class VISAFileDTO extends FileDTO{
	
	private FileHeader90RecordDTO fileHeader90RecordDto;
	private List<NegativeCardRecordDTO> negativeCardRecordDToList;
	private List<FileTrailer91_92RecordDTO> fileCtrlTrailorDtoList;
	
	public List<NegativeCardRecordDTO> getNegativeCardRecordDToList() {
		return negativeCardRecordDToList;
	}
	
	public void setNegativeCardRecordDToList(List<NegativeCardRecordDTO> negativeCardRecordDToList) {
		this.negativeCardRecordDToList = negativeCardRecordDToList;
	}

	public List<FileTrailer91_92RecordDTO> getFileCtrlTrailorDtoList() {
		return fileCtrlTrailorDtoList;
	}

	public void setFileCtrlTrailorDtoList(
			List<FileTrailer91_92RecordDTO> fileCtrlTrailorDtoList) {
		this.fileCtrlTrailorDtoList = fileCtrlTrailorDtoList;
	}

	public FileHeader90RecordDTO getFileHeader90RecordDto() {
		return fileHeader90RecordDto;
	}

	public void setFileHeader90RecordDto(FileHeader90RecordDTO fileHeader90RecordDto) {
		this.fileHeader90RecordDto = fileHeader90RecordDto;
	}
}
