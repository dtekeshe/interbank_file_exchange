package com.bsva.dmcs.views;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.bsva.dcms.commons.dao.CSFCardTypesDAO;
import com.bsva.dcms.commons.dto.CSFCardTypesDTO;
import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.dto.CSFMembersDTO;
import com.bsva.dcms.commons.dto.CSFSubServicesDTO;
import com.bsva.dcms.commons.dto.CSFTransactionTypesDTO;
import com.bsva.dcms.commons.dto.views.CsvCcr00XDataViewDto;
import com.bsva.dcms.commons.dto.views.CsvTransactionsViewDto;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.views.CsvTransactionsView;
import com.bsva.dmcs.file.reports.ReportData;
import com.bsva.dmcs.file.reports.ReportLayout;
import com.bsva.entities.CsoInputFileControls;

/*Test Data
 * for each bank X bank, by service , by sub_service , by card type by transactioncode , use received transactions to get 
 * volume ( note cashback will become a separate item so a trans with cashback has a vol of 2), trans amount(cashback and normal tran combined),
 * billing fee, amount and vat(cashback and normal tran combined)
 */
public class CsvCcr00XDataView {
	
	private List<CsvCcr00XDataViewDto> csvCcr00XDataViewDtoList = null;
	private List<CsvCcr00XDataViewDto> csvCcr00XDataViewDtoList2 = new ArrayList<>();
	private List<ReportLayout> reportLayoutDto2 = new ArrayList<>();
	private List<ReportLayout> reportLayoutDtos = new ArrayList<>();
	private Map<String,ReportData> reportDataGroup = new HashMap<String, ReportData>();
	private Logger log = Logger.getLogger(CsvCcr00XDataView.class);
	
	public CsvCcr00XDataView(){
		//this.csvCcr00XDataViewDtoList = new ArrayList<>();
		//this.reportLayoutDtos = new ArrayList<>();
	}
	public List<ReportLayout> reportData(){
		List<ReportLayout> report = null;		
		report = buildReportLayout();
	   return report;
	}
	
	public Map<String,ReportData> reportDataMap(){
		Map<String,ReportData> reportMap = null;
		reportMap = buildReportData();
	   return reportMap;
	}

	public List<CsvCcr00XDataViewDto> execute(){
		
		List<ReportLayout> reportLayoutDtos =  buildReportLayout();
		Map<String,ReportData> reportDataGroup = buildReportData();
		log.debug("After the build Report Data");
		List<CsvCcr00XDataViewDto> csvCcr00XDataViewDtoList1 =  new ArrayList<CsvCcr00XDataViewDto>();
		/*
		 * get all the bank X bank X tran code X card type and assign 
		 */
		for(ReportLayout reportLayoutDto : reportLayoutDtos){

			CsvCcr00XDataViewDto csvCcr00XDataViewDto = new CsvCcr00XDataViewDto();
			
			csvCcr00XDataViewDto.setIssuerMember(reportLayoutDto.getIssuerMember());
			csvCcr00XDataViewDto.setIssuerBankCode(reportLayoutDto.getIssuerCode());
			csvCcr00XDataViewDto.setAcquirerMember(reportLayoutDto.getAcquirerMember());
			csvCcr00XDataViewDto.setAcquirerBankCode(reportLayoutDto.getAcquirerCode());
			csvCcr00XDataViewDto.setService(reportLayoutDto.getService());
			csvCcr00XDataViewDto.setSubService(reportLayoutDto.getSubService());
			csvCcr00XDataViewDto.setCardType(reportLayoutDto.getCardType());
			csvCcr00XDataViewDto.setCardDescription(reportLayoutDto.getCardDescription());
			csvCcr00XDataViewDto.setTransactionCode(reportLayoutDto.getTransactionCode());
			csvCcr00XDataViewDto.setTransactionDescription(reportLayoutDto.getTransactionDescription());
			csvCcr00XDataViewDto.setReportSortSequence(reportLayoutDto.getReportSortSequence());
			csvCcr00XDataViewDto.setDisplayName(reportLayoutDto.getDisplayName());
			csvCcr00XDataViewDto.setIssuerCode(reportLayoutDto.getIssuerCode());
			csvCcr00XDataViewDto.setIssuerMember(reportLayoutDto.getIssuerMember());
			csvCcr00XDataViewDto.setAcquirerCode(reportLayoutDto.getAcquirerCode());
			
			
			String key2 = String.valueOf(reportLayoutDto.getAcquirerCode()) + String.valueOf(reportLayoutDto.getIssuerCode()) + reportLayoutDto.getService() + String.valueOf(reportLayoutDto.getCardType())
					+ reportLayoutDto.getTransactionCode();  //what about destianation report and amount direction ? Answer is below
			
			
			Set<String> keys = reportDataGroup.keySet();
			for(String key : keys){
				
				if (key.startsWith(key2)){  // this is because key2 does not contain destination report and amount direction
					
					ReportData reportDataForKey = reportDataGroup.get(key);
				
					csvCcr00XDataViewDto.setVolume(reportDataForKey.getVolume());
					csvCcr00XDataViewDto.setTransactionValue(new BigDecimal(reportDataForKey.getTransactionAmount()).setScale(2 , RoundingMode.FLOOR).doubleValue());
					csvCcr00XDataViewDto.setBilingFee(new BigDecimal(reportDataForKey.getBillingFee()).setScale(2).doubleValue());
					csvCcr00XDataViewDto.setBillingFeeAmount((new BigDecimal(reportDataForKey.getBillingFeeAmount()).setScale(2, RoundingMode.FLOOR).doubleValue()));
					csvCcr00XDataViewDto.setBillingVat((new BigDecimal(reportDataForKey.getBillingVat()).setScale(2, RoundingMode.FLOOR).doubleValue()));
					csvCcr00XDataViewDto.setDestinationReport(reportDataForKey.getDestinationReport());
					csvCcr00XDataViewDtoList1.add(csvCcr00XDataViewDto);
				}
			}
			
		}
				
		return csvCcr00XDataViewDtoList1;
	}
	
	//get a combination of a member by each member , for each service, each subservice , each transaction type, each card type
	private  List<ReportLayout> buildReportLayout(){
		
		try{
		
			//Collection<CSFTransactionTypesDTO> csfTransactionTypesDTOs = BsvTableLookup.getInstance().getCsfTransactionTypes().values();
			List<CSFTransactionTypesDTO> values = new ArrayList<>(BsvTableLookup.getInstance().getCsfTransactionTypes().values());
			List<CSFTransactionTypesDTO> csfTransactionTypesDTOs = new ArrayList<CSFTransactionTypesDTO>(values);
	
			for(CSFTransactionTypesDTO csfTransactionTypesDTO : csfTransactionTypesDTOs){ // for each transaction type
				
				if (!csfTransactionTypesDTO.getFinancialInd().equalsIgnoreCase("Y"))
					continue;
				
				int transactionCode = csfTransactionTypesDTO.getTransactionCode();
				
				if (transactionCode == 9 || transactionCode == 19 || transactionCode == 29)
					continue;
				
						
				Collection<CSFMemberServiceDTO> csfMembersServiceDTOs = BsvTableLookup.getInstance().getCsfMemberService();
						
				for(CSFMemberServiceDTO csfMemberServiceIssuerDto : csfMembersServiceDTOs){ // for each parent member
					     
					//get member object
					CSFMembersDTO csfMembersIssuerDTO = BsvTableLookup.getInstance().getCsfMembers().get(String.valueOf(csfMemberServiceIssuerDto.getBankCode()));
					
					//check if member is valid
					if (!isMemberValid(csfMembersIssuerDTO, csfMemberServiceIssuerDto))
						continue;
					
					//check if card type of issuer is valid
					CSFCardTypesDTO csfCardTypesSearch = new CSFCardTypesDTO();
					csfCardTypesSearch.setSubService(csfMemberServiceIssuerDto.getSubService());
					List<CSFCardTypesDTO> csfCardTypesDTOs = new CSFCardTypesDAO().retrieveRelated(csfCardTypesSearch);
					
					if (csfCardTypesDTOs == null)
							continue;
					
					
					for(CSFCardTypesDTO csfCardTypesDTO : csfCardTypesDTOs){
					
						//map issuer to acquirer
						for(CSFMemberServiceDTO csfMemberServiceAcquirerDto : csfMembersServiceDTOs){ // for each child member
								
							//get member
							CSFMembersDTO csfMembersAcquirerDTO = BsvTableLookup.getInstance().getCsfMembers().get(String.valueOf(csfMemberServiceAcquirerDto.getBankCode()));
							
							//check if member is valid
							if (!isMemberValid(csfMembersAcquirerDTO, csfMemberServiceAcquirerDto))
								continue;
							
							//both members should be active for the same subservice
							if (!csfMemberServiceIssuerDto.getSubService().equals(csfMemberServiceAcquirerDto.getSubService())){
								continue;
							}
							
							if (csfMembersIssuerDTO.getBankCode() != csfMembersAcquirerDTO.getBankCode()){
								
								ReportLayout reportLayoutDto = new ReportLayout();
								reportLayoutDto.setIssuerMember(csfMembersIssuerDTO.getMemberName());
								reportLayoutDto.setIssuerCode(csfMembersIssuerDTO.getBankCode());
								reportLayoutDto.setAcquirerMember(csfMembersAcquirerDTO.getMemberName());
								reportLayoutDto.setAcquirerCode(csfMembersAcquirerDTO.getBankCode());
									
								CSFSubServicesDTO csfSubServicesDTO = new CSFSubServicesDTO();
								csfSubServicesDTO = BsvTableLookup.getInstance().getCsfSubServices().get(csfMemberServiceAcquirerDto.getSubService());
									
								reportLayoutDto.setSubService(csfMemberServiceAcquirerDto.getSubService());
								reportLayoutDto.setDisplayName(csfSubServicesDTO.getDisplayName());
								reportLayoutDto.setService(csfMemberServiceAcquirerDto.getService());
									
								reportLayoutDto.setCardType(csfCardTypesDTO.getCardType());
								reportLayoutDto.setCardDescription(csfCardTypesDTO.getCardDescription());
																
								reportLayoutDto.setTransactionCode(transactionCode);
								reportLayoutDto.setTransactionDescription(csfTransactionTypesDTO.getTransactionDescription());
								reportLayoutDto.setReportSortSequence(csfTransactionTypesDTO.getReportSortSequence());
								
								reportLayoutDtos.add(reportLayoutDto);
								
						}
					  }//end ecq loop
						
						
					}//end issuer loop
					
				}//end card type loop
				
			}//end transaction type loop
				
		}catch(Exception e){
			log.error("Error with buildReportLayout . cause : " + e.getMessage(), e);
		}
		
	   return reportLayoutDtos;
	}
	
	private boolean isMemberValid(CSFMembersDTO member , CSFMemberServiceDTO memberService){
	
		boolean isMemberValid = true;
		
		//check if the acquirer member exists
		if (member == null)
			isMemberValid = false;
		
		if (member.getMnemonicMemberName() == null)
			isMemberValid = false;
		
		//check if issuer subservice exists
		CSFSubServicesDTO csfSubServicesDTO = new CSFSubServicesDTO();
		csfSubServicesDTO = BsvTableLookup.getInstance().getCsfSubServices().get(memberService.getSubService());
		
		if (csfSubServicesDTO == null)
			isMemberValid = false;
		
		//TODO: fix the csfservice table first
		//check is issuer service exists
//		CSFServicesDTO csfServicesDTO = new CSFServicesDTO();
//		csfServicesDTO = BsvTableLookup.getInstance().getCsfServices().get(memberService.getService());
//		if (csfServicesDTO == null)
//			isMemberValid = false;

		return isMemberValid;
	}

	private Map<String,ReportData> buildReportData(){
		System.out.println("in buildReportData");
		
		/*
		 * take all the transactions you got and group them by acq|iss|service|card type|tran code|dest report|amount|dir e.g lets say you received for of those
		 * then sum their tran amount, billing fee, billing fee amount, billing vat - including cashbacks
		 * group them into 1 item
		 * also determine the actual issuer and acquirer based on dest_report
		 */
		ReportData existingReport = new ReportData();
		CsvTransactionsView csvTransactionsView = new CsvTransactionsView();
		List<CsvTransactionsViewDto> csvTransactionsViewDtos = csvTransactionsView.getCsvTransactionsViewDtoList();
		Map<String,ReportData> reportDataGrouping = new HashMap<>();
		
		for(CsvTransactionsViewDto csvTransactionViewDto : csvTransactionsViewDtos){
			
			ReportData reportData = null;
			
			//report data for normal transactions
			//TODO: remove : csvTransactionViewDto.getFileStatus().equals("A")
			if ((csvTransactionViewDto.getTransactionCode() == 3 || csvTransactionViewDto.getTransactionCode() == 13 || csvTransactionViewDto.getTransactionCode() == 23) &&
					csvTransactionViewDto.getTransactionStatus().equals("C") && 
					(csvTransactionViewDto.getFileStatus().equals("C") || csvTransactionViewDto.getFileStatus().equals("E") || csvTransactionViewDto.getFileStatus().equals("A"))){
			
				reportData = new ReportData();
				
				int acquirerMember = 0;
				int issuerMember = 0;
				if (csvTransactionViewDto.getDestReport().equals("A")){
					acquirerMember = csvTransactionViewDto.getAcquirerMember();
					issuerMember = csvTransactionViewDto.getIssuerMember();
				}else{
					acquirerMember = csvTransactionViewDto.getIssuerMember();
					issuerMember = csvTransactionViewDto.getAcquirerMember();
				}
				
				reportData.setAcquirerMember(acquirerMember);
				reportData.setIssuerMember(issuerMember);
				
				reportData.setService(csvTransactionViewDto.getService());
				reportData.setCardType(csvTransactionViewDto.getCardType());
				
				int volume = 1;
				if (csvTransactionViewDto.getFleetCountTran().equals("Y")){
					volume = 1;
				}else{
					volume = 0;
				}
				reportData.setVolume(volume);
				
				int transactionCode;
				if (csvTransactionViewDto.getTransactionCode() == 3){
					transactionCode = 8;
				}else if (csvTransactionViewDto.getTransactionCode() == 13){
					transactionCode = 18;
				}else if (csvTransactionViewDto.getTransactionCode() == 23){
					transactionCode = 28;
				}else{
					transactionCode = csvTransactionViewDto.getTransactionCode();
					reportData.setTransactionCode(transactionCode);
				}
				
				reportData.setAmountDirection(csvTransactionViewDto.getCashbackAmountDirection()); 
				reportData.setTransactionAmount(csvTransactionViewDto.getCashbackAmount());
				reportData.setBillingFee(csvTransactionViewDto.getCashbackBillFee());
				reportData.setBillingFeeAmount(csvTransactionViewDto.getCashbackBillFeeAmnt());
				reportData.setBillingVat(csvTransactionViewDto.getCashbackBillVat());
				reportData.setDestinationReport(csvTransactionViewDto.getDestReport());
				
			}
			
			//report data for cashback transactions
			if (csvTransactionViewDto.getTransactionCode() < 40 && csvTransactionViewDto.getTransactionStatus().equals("C") &&
					(csvTransactionViewDto.getFileStatus().equals("C") || csvTransactionViewDto.getFileStatus().equals("E") || csvTransactionViewDto.getFileStatus().equals("A"))){
				
				reportData = new ReportData();
				
				int acquirerMember = 0;
				int issuerMember = 0;
				if(csvTransactionViewDto.getDestReport() != null){
					
					if (csvTransactionViewDto.getDestReport().equals("A")){
						acquirerMember = csvTransactionViewDto.getAcquirerMember();
						issuerMember = csvTransactionViewDto.getIssuerMember();
					}else{
						acquirerMember = csvTransactionViewDto.getIssuerMember();
						issuerMember = csvTransactionViewDto.getAcquirerMember();
					}
				}else{				

					acquirerMember = csvTransactionViewDto.getAcquirerMember();
					issuerMember = csvTransactionViewDto.getIssuerMember();
				}
				
				reportData.setAcquirerMember(acquirerMember);
				reportData.setIssuerMember(issuerMember);
				
				reportData.setService(csvTransactionViewDto.getService());
				reportData.setCardType(csvTransactionViewDto.getCardType());
				
				int volume = 1;
				if (csvTransactionViewDto.getFleetCountTran().equals("Y")){
					volume = 1;
				}else{
					volume = 0;
				}
				reportData.setVolume(volume);
				
				int transactionCode;
				if (csvTransactionViewDto.getTransactionCode() == 9){
					transactionCode = 5;
				}else if (csvTransactionViewDto.getTransactionCode() == 19){
					transactionCode = 15;
				}else if (csvTransactionViewDto.getTransactionCode() == 29){
					transactionCode = 25;
				}else{
					transactionCode = csvTransactionViewDto.getTransactionCode();
					reportData.setTransactionCode(transactionCode);
				}
				
				reportData.setAmountDirection(csvTransactionViewDto.getAmountDirection()); 
				reportData.setTransactionAmount(csvTransactionViewDto.getTransactionAmount());
				reportData.setBillingFee(csvTransactionViewDto.getBillingFee());
				reportData.setBillingFeeAmount(csvTransactionViewDto.getBillingFeeAmount());
				reportData.setBillingVat(csvTransactionViewDto.getBillingVat());
				reportData.setDestinationReport(csvTransactionViewDto.getDestReport());
			}
			
			//group them by given key
			if (reportData != null){
				String key = String.valueOf(reportData.getAcquirerMember()) + String.valueOf(reportData.getIssuerMember()) + reportData.getService() + String.valueOf(reportData.getCardType())+
						String.valueOf(reportData.getTransactionCode())  +String.valueOf(reportData.getAmountDirection());//+ reportData.getDestinationReport());
				
				if (reportDataGrouping.containsKey(key)){
					ReportData existingReportData = reportDataGrouping.get(key);
					
					int volume = existingReportData.getVolume() + reportData.getVolume();
					existingReportData.setVolume(volume);
					//existingReport.setVolume(volume);
					
					double transactionValue = existingReportData.getTransactionAmount() +  (reportData.getTransactionAmount() * reportData.getAmountDirection());
					existingReportData.setTransactionAmount(transactionValue);
					//existingReport.setTransactionAmount(transactionValue);
					
					double billingFee = existingReportData.getBillingFee() + reportData.getBillingFee();
					existingReportData.setBillingFee(billingFee);
					//existingReport.setBillingFee(billingFee);
					
					double billingFeeAmount = existingReportData.getBillingFeeAmount() + reportData.getBillingFeeAmount();
					existingReportData.setBillingFeeAmount(billingFeeAmount);
					//existingReport.setBillingFeeAmount(billingFeeAmount);
					
					double billingVat = existingReportData.getBillingVat() + reportData.getBillingVat();
					existingReportData.setBillingVat(billingVat);
					//existingReport.setBillingVat(billingVat);
					
					reportDataGrouping.put(key, existingReportData);
					log.debug("Fiishing  with report data");		
					
				}else{
					reportDataGrouping.put(key, reportData);
					log.debug("Done  with report data");	
				}
			}
		}
		return reportDataGrouping;
	}
	
		
}

