package com.bsva.dcms.commons.dto.file;

public class MastercardFileDTO extends FileDTO{
	
	private IPMFileHeaderDTO ipmFileHeaderDto;
	private IPMFileTrailorDTO ipmFileTrailorDto;

	public MastercardFileDTO(){}

	public IPMFileHeaderDTO getIpmFileHeaderDto() {
		return ipmFileHeaderDto;
	}

	public void setIpmFileHeaderDto(IPMFileHeaderDTO ipmFileHeaderDto) {
		this.ipmFileHeaderDto = ipmFileHeaderDto;
	}

	public IPMFileTrailorDTO getIpmFileTrailorDto() {
		return ipmFileTrailorDto;
	}

	public void setIpmFileTrailorDto(IPMFileTrailorDTO ipmFileTrailorDto) {
		this.ipmFileTrailorDto = ipmFileTrailorDto;
	}
}
