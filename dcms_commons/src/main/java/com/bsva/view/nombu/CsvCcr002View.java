package com.bsva.view.nombu;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.dto.views.CsvCcr002ViewDto;
import com.bsva.dcms.commons.dto.views.CsvCcr00XDataViewDto;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.util.BsvTableLookup;


public class CsvCcr002View {

	/*private Connection connection;
	private List<CsvCcr002ViewDto> cvsCcr002ViewList = null;
	private ReportLayout reportLayout = null;
	private ReportData reportDataLayoutBean = null;
	private CsvCcr00XDataViewDto dto = null;
	private CsvCcr002ViewDto cvsCcr002ViewDto = null;

	public CsvCcr002View(Connection connection){

		try{

			this.connection = connection;
			this.cvsCcr002ViewList = new ArrayList<>();
			this.dto = new CsvCcr00XDataViewDto();
			this.cvsCcr002ViewDto = new CsvCcr002ViewDto();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	//get data from CSV_CCR00X_DATA_VIEW
	public List<CsvCcr00XDataViewDto> execute() throws DAOException{
		
		CsvCcr00XDataView csvCcr00XDataView = new CsvCcr00XDataView(connection);
		
		reportDataLayoutBean = (ReportData) csvCcr00XDataView.build(reportDataLayoutBean);
		reportLayout = (ReportLayout) csvCcr00XDataView.build(reportLayout) ;

		
		List<CsvCcr00XDataViewDto>  csvCcr00XDataViewList = csvCcr00XDataView.executeAll(dto,reportDataLayoutBean,reportLayout);

		try{

			for(CsvCcr00XDataViewDto csvCcr00XDataViewDto : csvCcr00XDataViewList){

				String subService = csvCcr00XDataViewDto.getSubService();
				if (csvCcr00XDataViewDto.getSubService().equals("MASTERCARD")){
					subService = "VISA CARD";
				}

				csvCcr00XDataViewDto.getIssuerMember();
				csvCcr00XDataViewDto.getIssuerBankCode();
				csvCcr00XDataViewDto.getAcquirerMember();
				csvCcr00XDataViewDto.getAcquirerBankCode();
				csvCcr00XDataViewDto.getService();
				csvCcr00XDataViewDto.getSubService();
				csvCcr00XDataViewDto.getBilingFee();
				csvCcr00XDataViewDto.getBillingFeeAmount();
				csvCcr00XDataViewDto.getBillingVat();

				//group by
				csvCcr00XDataViewDto.getIssuerMember();
				csvCcr00XDataViewDto.getIssuerBankCode();
				csvCcr00XDataViewDto.getAcquirerMember();
				csvCcr00XDataViewDto.getAcquirerBankCode();
				csvCcr00XDataViewDto.getService();
				csvCcr00XDataViewDto.getSubService();

				Map<String,List<CsvCcr00XDataViewDto>> cvsDataViewGrouping = new HashMap<>();

				String key = csvCcr00XDataViewDto.getAcquirerMember() + csvCcr00XDataViewDto.getIssuerMember() + csvCcr00XDataViewDto.getService() + csvCcr00XDataViewDto.getSubService();

				if (cvsDataViewGrouping.containsKey(key)){

					List<CsvCcr00XDataViewDto> cvsCCR00XDataList = cvsDataViewGrouping.get(key);
					cvsCCR00XDataList.add(csvCcr00XDataViewDto);

				}else{
					List<CsvCcr00XDataViewDto> cvsCCR00XDataList = new ArrayList<>();
					cvsCCR00XDataList.add(csvCcr00XDataViewDto);

					cvsDataViewGrouping.put(key, cvsCCR00XDataList);		    	
				}

				csvCcr00XDataViewList.add(csvCcr00XDataViewDto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return csvCcr00XDataViewList;


	}


	public List<CsvCcr002ViewDto> executeAll(){

		applying the rules  a.issuer_bank_code = b.acquirer_bank_code
	               AND a.acquirer_bank_code = b.issuer_bank_code
	               AND a.service = b.service
	               AND a.sub_service = b.sub_service
	            LEFT OUTER JOIN csf_member_service c
	            ON a.issuer_bank_code = c.bank_code
	            and a.service = c.service
	               AND a.sub_service = c.sub_service
	      WHERE NVL (a.total_cost, 0) <> 0 OR NVL (b.total_cost, 0) <> 0

		List<TranCostsDto> transCostList = new ArrayList<>();
		
		try{
			for(TranCostsDto transCostOriginal : transCostList){
				for(TranCostsDto transCostDestination : transCostList){

					if (transCostOriginal.getIssuerBankCode() == transCostDestination.getAcquirerBankCode() && transCostOriginal.getAcquirerBankCode() == transCostDestination.getIssuerBankCode()
							&&  transCostOriginal.getService().equals(transCostDestination.getService()) && transCostOriginal.getSubService().equals(transCostDestination.getSubService())){

						List<CSFMemberServiceDTO> csfMemberServiceList  = (ArrayList<CSFMemberServiceDTO>)BsvTableLookup.getInstance().getCsfMemberService();

						for(CSFMemberServiceDTO csfMemberService : csfMemberServiceList){

							if (transCostOriginal.getIssuerBankCode() == csfMemberService.getBankCode() && transCostOriginal.getService().equals(csfMemberService.getService())
									&& transCostOriginal.getSubService().equals(csfMemberService.getSubService()));


							Double sum = (transCostOriginal.getBillingFee() + transCostOriginal.getBillingFeeAmount() + transCostOriginal.getBillingVat());
							Double totalCosta = sum;
							Double totalCostb = sum;

							if ((totalCosta) != 0 || (totalCostb)!= 0)

								//set values to cvsCcr002ViewDto for population
								cvsCcr002ViewDto.setIssuerMember(transCostOriginal.getIssuerMember());
							cvsCcr002ViewDto.setIssuerBankCode(transCostOriginal.getIssuerBankCode());
							cvsCcr002ViewDto.setAcquirerMember(transCostOriginal.getAcquirerMember());
							cvsCcr002ViewDto.setAcquirerBankCode(transCostOriginal.getAcquirerBankCode());
							cvsCcr002ViewDto.setService(transCostOriginal.getService());
							cvsCcr002ViewDto.setSubService(transCostOriginal.getSubService());

							//Calculate nett fees  						
							Double acqFees = (totalCosta) * -1;
							Double issFees = (totalCostb) * -1;
							Double nettFees = (acqFees) - (issFees);

							cvsCcr002ViewDto.setAcquirerFees(acqFees);
							cvsCcr002ViewDto.setIssuerFees(issFees);
							cvsCcr002ViewDto.setNettFees(nettFees);
							cvsCcr002ViewDto.setInvoiceNumber(csfMemberService.getInvoiceNoCCR001());

						}


					}

					cvsCcr002ViewList.add(cvsCcr002ViewDto);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return cvsCcr002ViewList;

	}



	class TranCostsDto {

		String issuerMember;
		int issuerBankCode;
		String acquirerMember;
		int acquirerBankCode;
		String service;
		String subService;
		Double billingFee;
		Double billingFeeAmount;
		Double billingVat;
		Double totalCost;

		public String getIssuerMember() {
			return issuerMember;
		}
		public void setIssuerMember(String issuerMember) {
			this.issuerMember = issuerMember;
		}
		public int getIssuerBankCode() {
			return issuerBankCode;
		}
		public void setIssuerBankCode(int issuerBankCode) {
			this.issuerBankCode = issuerBankCode;
		}
		public String getAcquirerMember() {
			return acquirerMember;
		}
		public void setAcquirerMember(String acquirerMember) {
			this.acquirerMember = acquirerMember;
		}
		public int getAcquirerBankCode() {
			return acquirerBankCode;
		}
		public void setAcquirerBankCode(int acquirerBankCode) {
			this.acquirerBankCode = acquirerBankCode;
		}
		public String getService() {
			return service;
		}
		public void setService(String service) {
			this.service = service;
		}
		public String getSubService() {
			return subService;
		}
		public void setSubService(String subService) {
			this.subService = subService;
		}
		public Double getBillingFee() {
			return billingFee;
		}
		public void setBillingFee(Double billingFee) {
			this.billingFee = billingFee;
		}
		public Double getBillingFeeAmount() {
			return billingFeeAmount;
		}
		public void setBillingFeeAmount(Double billingFeeAmount) {
			this.billingFeeAmount = billingFeeAmount;
		}
		public Double getBillingVat() {
			return billingVat;
		}
		public void setBillingVat(Double billingVat) {
			this.billingVat = billingVat;
		}
		public Double getTotalCost() {
			return totalCost;
		}
		public void setTotalCost(Double totalCost) {
			this.totalCost = totalCost;
		}

	}*/
}
