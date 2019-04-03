package com.bsva.dcms.commons.views;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.dto.views.CsvCcr002ViewDto;
import com.bsva.dcms.commons.dto.views.CsvCcr00XDataViewDto;
import com.bsva.dcms.commons.util.BsvTableLookup;

public class CsvCcr002View {
	
	private Connection connection;
	private List<CsvCcr002ViewDto> csvCcr002ViewDtos = null;
	
	public CsvCcr002View(Connection connection){
		this.connection = connection;
		this.csvCcr002ViewDtos = new ArrayList<>();
	}
	
	public List<CsvCcr002ViewDto> execute(){
		
		Map<String , TranCosts> tranCostsGroup = buildTranCosts();
		
		/*
		 * find the nett fees between 2 banks if any 
		 * e.g bank A owes bank B, and bank B owes bank A , so nett is the difference
		 */
		Collection<TranCosts> tranCosts = tranCostsGroup.values();
		for(TranCosts tranCostA : tranCosts){
			
			CSFMemberServiceDTO csfMemberServiceDTO = getMemberService(tranCostA);
			if (csfMemberServiceDTO == null)
				continue;
			
			CsvCcr002ViewDto csvCcr002ViewDto = new CsvCcr002ViewDto();
			csvCcr002ViewDto.setIssuerMember(tranCostA.getIssuerMember());
			csvCcr002ViewDto.setIssuerBankCode(tranCostA.getIssuerBankCode());
			csvCcr002ViewDto.setAcquirerBankCode(tranCostA.getAcquirerBankCode());
			csvCcr002ViewDto.setAcquirerMember(tranCostA.getAcquirerMember());
			csvCcr002ViewDto.setService(tranCostA.getService());
			csvCcr002ViewDto.setSubService(tranCostA.getSubService());
			csvCcr002ViewDto.setAcquirerFees(tranCostA.getTotalCost() * -1);
			csvCcr002ViewDto.setInvoiceNumber(csfMemberServiceDTO.getInvoiceNoCCR001());
			
			// if this is a bank A to bank B transaction, check if there is a corresponding bank B to bank A transaction
			boolean isMatchFound = false;
			for(TranCosts tranCostB : tranCosts){
				
				if (tranCostA.getIssuerBankCode() == tranCostB.getAcquirerBankCode() &&
						tranCostA.getAcquirerBankCode() == tranCostB.getIssuerBankCode() && 
						tranCostA.getService().equals(tranCostB.getService()) && 
						tranCostA.getSubService().equals(tranCostB.getSubService()) && 
						(tranCostA.getTotalCost() != 0 || tranCostB.getTotalCost() != 0)){
					
					csvCcr002ViewDto.setIssuerFees(tranCostB.getTotalCost() * -1);
					csvCcr002ViewDto.setNettFees((csvCcr002ViewDto.getAcquirerFees() * -1)  - (csvCcr002ViewDto.getIssuerFees() * -1));
					
					
					if (tranCostA.getTotalCost() == 0 || tranCostB.getTotalCost()==0){
						continue;
					}
					csvCcr002ViewDtos.add(csvCcr002ViewDto);
					
					isMatchFound = true;
				}
			}
			
			if (!isMatchFound){
				// we still need to add without the matching values 
				csvCcr002ViewDto.setIssuerFees(0);
				csvCcr002ViewDto.setNettFees((csvCcr002ViewDto.getAcquirerFees() * -1)  - (csvCcr002ViewDto.getIssuerFees() * -1));
				
				//note by default tranCostB.getTotalCost()==0 so we cant add this unmatch
				csvCcr002ViewDtos.add(csvCcr002ViewDto);
			}
			//buildTranCosts();
		}
		return csvCcr002ViewDtos;
	}

	/*
	 * combine all transactions of same bank X bank X service X tran code X card type regardless of subservice
	 */
	public Map<String , TranCosts> buildTranCosts(){
		
		CsvCcr00XDataView csvCcr00XDataView = new CsvCcr00XDataView();
		List<CsvCcr00XDataViewDto> csvCcr00XDataViewDtos = csvCcr00XDataView.execute();
		System.out.println("csvCcr00XDataViewDtos List " + csvCcr00XDataViewDtos);
		
		Map<String , TranCosts> tranCostsGroup = new HashMap<>();
		
		for(CsvCcr00XDataViewDto csvCcr00XDataViewDto  : csvCcr00XDataViewDtos){
		//	System.out.println(" cost" + csvCcr00XDataViewDto.getBilingFee() + csvCcr00XDataViewDto.getBillingFeeAmount() + csvCcr00XDataViewDto.getBillingVat());
			//double cost = csvCcr00XDataViewDto.getBilingFee() + csvCcr00XDataViewDto.getBillingFeeAmount() + csvCcr00XDataViewDto.getBillingVat();
		
			
			String key = csvCcr00XDataViewDto.getIssuerMember() + csvCcr00XDataViewDto.getIssuerBankCode() + csvCcr00XDataViewDto.getAcquirerMember()
					+ csvCcr00XDataViewDto.getAcquirerBankCode() + csvCcr00XDataViewDto.getService() + csvCcr00XDataViewDto.getSubService();
			
			if (tranCostsGroup.containsKey(key)){
				
				TranCosts currTranCosts = tranCostsGroup.get(key);
				//double totalCost = currTranCosts.getTotalCost() + cost;
				//currTranCosts.setTotalCost(totalCost);
				
			}else{
				TranCosts tranCosts = new TranCosts();
				tranCosts.setIssuerMember(csvCcr00XDataViewDto.getIssuerMember());
				//System.out.println("csvCcr00XDataViewDto.getIssuerMember()" + csvCcr00XDataViewDto.getIssuerMember());
				tranCosts.setIssuerBankCode(csvCcr00XDataViewDto.getIssuerBankCode());
				//System.out.println("csvCcr00XDataViewDto.getIssuerBankCode()" + csvCcr00XDataViewDto.getIssuerBankCode());
				tranCosts.setAcquirerMember(csvCcr00XDataViewDto.getAcquirerMember());
				//System.out.println("csvCcr00XDataViewDto.getAcquirerMember()" + csvCcr00XDataViewDto.getAcquirerMember());
				tranCosts.setAcquirerBankCode(csvCcr00XDataViewDto.getAcquirerBankCode());
				//System.out.println("csvCcr00XDataViewDto.getAcquirerBankCode()" + csvCcr00XDataViewDto.getAcquirerBankCode());
				tranCosts.setService(csvCcr00XDataViewDto.getService());
				//System.out.println("csvCcr00XDataViewDto.getService()" + csvCcr00XDataViewDto.getService());
				
				String subService = "";
				if (csvCcr00XDataViewDto.getSubService().equals("MASTERCARD"))
					subService = "VISA CARD";
				else
					subService = csvCcr00XDataViewDto.getSubService();
				
				tranCosts.setSubService(subService);
			//	tranCosts.setTotalCost(cost);
				tranCostsGroup.put(key, tranCosts);
			}
		}
		return tranCostsGroup;
	}
	
	public CSFMemberServiceDTO getMemberService(TranCosts tranCostA){
		
		boolean isMemberValid = true;
		
		//first validate member details
		List<CSFMemberServiceDTO> csfMemberServiceDTOs = BsvTableLookup.getInstance().getCsfMemberService();
		CSFMemberServiceDTO csfMemberServiceDTO = null;
		for(CSFMemberServiceDTO cmsD : csfMemberServiceDTOs){
			
			if (tranCostA.getIssuerBankCode() == cmsD.getBankCode() && 
					tranCostA.getService().equals(cmsD.getService()) && 
					tranCostA.getSubService().equalsIgnoreCase(cmsD.getSubService())){
				csfMemberServiceDTO = cmsD;
				break;
			}
		}
		
		return csfMemberServiceDTO;
	}
	class TranCosts{
		
		private String issuerMember;
		private int issuerBankCode;
		private String acquirerMember;
		private int acquirerBankCode;
		private String service;
		private String subService;
		private double totalCost;
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
		public double getTotalCost() {
			return totalCost;
		}
		public void setTotalCost(double totalCost) {
			this.totalCost = totalCost;
		}
		
	}
}
