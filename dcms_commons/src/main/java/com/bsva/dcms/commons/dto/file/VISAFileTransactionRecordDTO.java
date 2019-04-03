package com.bsva.dcms.commons.dto.file;

public class VISAFileTransactionRecordDTO extends FileTransactionRecordDTO{
	
    private boolean visaTCR5Present = false;
    private String fleetTranDate;
    private String fleetTranTime;
    private String fleetProduct = "";
    private String fleetSubProduct = "";
  
	private VISATCR0TransactionRecordDTO tcr0TransactionRecordDto;
	private VISATCR1TransactionRecordDTO tcr1TransactionRecordDto;
	private VISATCR3TransactionRecordDTO tcr3TransactionRecordDto;
	private VISATCR5TransactionRecordDTO tcr5TransactionRecordDto;
	private VISATCR7TransactionRecordDTO tcr7TransactionRecordDto;

	
	public boolean isVisaTCR5Present() {
		return visaTCR5Present;
	}
	public void setVisaTCR5Present(boolean visaTCR5Present) {
		this.visaTCR5Present = visaTCR5Present;
	}
	public String getFleetTranDate() {
		return fleetTranDate;
	}
	public void setFleetTranDate(String fleetTranDate) {
		this.fleetTranDate = fleetTranDate;
	}
	public String getFleetTranTime() {
		return fleetTranTime;
	}
	public void setFleetTranTime(String fleetTranTime) {
		this.fleetTranTime = fleetTranTime;
	}
	public String getFleetProduct() {
		return fleetProduct;
	}
	public void setFleetProduct(String fleetProduct) {
		this.fleetProduct = fleetProduct;
	}
	public String getFleetSubProduct() {
		return fleetSubProduct;
	}
	public void setFleetSubProduct(String fleetSubProduct) {
		this.fleetSubProduct = fleetSubProduct;
	}
	public VISATCR0TransactionRecordDTO getTcr0TransactionRecordDto() {
		return tcr0TransactionRecordDto;
	}
	public void setTcr0TransactionRecordDto(
			VISATCR0TransactionRecordDTO tcr0TransactionRecordDto) {
		this.tcr0TransactionRecordDto = tcr0TransactionRecordDto;
	}
	public VISATCR1TransactionRecordDTO getTcr1TransactionRecordDto() {
		return tcr1TransactionRecordDto;
	}
	public void setTcr1TransactionRecordDto(
			VISATCR1TransactionRecordDTO tcr1TransactionRecordDto) {
		this.tcr1TransactionRecordDto = tcr1TransactionRecordDto;
	}
	public VISATCR5TransactionRecordDTO getTcr5TransactionRecordDto() {
		return tcr5TransactionRecordDto;
	}
	public void setTcr5TransactionRecordDto(
			VISATCR5TransactionRecordDTO tcr5TransactionRecordDto) {
		this.tcr5TransactionRecordDto = tcr5TransactionRecordDto;
	}
	public VISATCR7TransactionRecordDTO getTcr7TransactionRecordDto() {
		return tcr7TransactionRecordDto;
	}
	public void setTcr7TransactionRecordDto(
			VISATCR7TransactionRecordDTO tcr7TransactionRecordDto) {
		this.tcr7TransactionRecordDto = tcr7TransactionRecordDto;
	}
	public VISATCR3TransactionRecordDTO getTcr3TransactionRecordDto() {
		return tcr3TransactionRecordDto;
	}
	public void setTcr3TransactionRecordDto(VISATCR3TransactionRecordDTO tcr3TransactionRecordDto) {
		this.tcr3TransactionRecordDto = tcr3TransactionRecordDto;
	}
	
}
