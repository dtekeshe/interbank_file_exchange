package com.bsva.dcms.commons.views;

import java.util.Collection;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.bsva.dcms.commons.dao.CsoSystemParametersDAO;
import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.dto.CSFMembersDTO;
import com.bsva.dcms.commons.dto.CSFSubServicesDTO;
import com.bsva.dcms.commons.dto.CsfCompanyParametersDTO;
import com.bsva.dcms.commons.dto.CsoSystemParametersDTO;
import com.bsva.dcms.commons.dto.views.CsvSettlementViewDto;
import com.bsva.dcms.commons.dto.views.CsvTransactionsViewDto;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.views.CsvTransactionsView;

/*
 * this class returns volume and nett amounts for each bank to bank by service and subservice
 * first it calculates volume and nett using transactions, by group using acquirer|issuer|service|sub_Service
 * then it creates bank X bank relationships for each service and subservice
 * 	 note : we might not have received transactions for some bank to bank relationship so that data will be zero
 * for bank A x bank B , we get a->b data as credit , and b-> a data as debit
 */
public class CsvSettlementView{

	private DataSource connection;
	private List<CsvSettlementViewDto> csvSettlementViewDtoList = null;
	private Logger log = Logger.getLogger(CsvSettlementView.class);
	
	public CsvSettlementView(){
		this.csvSettlementViewDtoList = new ArrayList<>();
	}

	public List<CsvSettlementViewDto> execute(CSFSubServicesDTO subServices){
		try{
		//Nettotals = group transactions by acquirer|issuer|service|sub_Service and get their total voulme and nett amount
		// we used dest_report to get originating(acq) and homing back(issuer). note issuer and acquirer could have swapped pos depending on dest_report
		Map<String,NettTotalsDto> nettTotalsGroup = new HashMap<>();
		List<CsvSettlementViewDto> csvSettlementViewDtolist =  null;
		
		CsvTransactionsView csvTransactionsView = new CsvTransactionsView();
		List<CsvTransactionsViewDto>  csvTransactionvList= csvTransactionsView.execute(subServices);   
		
		//get all the completed transactions with their billing data and group them by  acquirer_member + issuer_member + service + sub_service
		if(csvTransactionvList!= null && csvTransactionvList.size() > 0){
			for(CsvTransactionsViewDto csvTransactionsViewDto : csvTransactionvList){
			
				if (csvTransactionsViewDto.getTransactionStatus().equals("C") && 
						(csvTransactionsViewDto.getFileStatus().equals("C") || csvTransactionsViewDto.getFileStatus().equals("A")) && 
						csvTransactionsViewDto.getTransactionCode() < 50){
					//do nothing
				}else
					continue;
				
				int issuerMember;
				int acquirerMember;
				
				//if (csvTransactionsViewDto.getDestReport().equals("A")){
					//issuerMember = csvTransactionsViewDto.getIssuerMember();
					//acquirerMember = csvTransactionsViewDto.getAcquirerMember();
				//}else{
					issuerMember = csvTransactionsViewDto.getAcquirerMember();
					acquirerMember = csvTransactionsViewDto.getIssuerMember();
				//}
			
				String service = csvTransactionsViewDto.getService();
				String subService = csvTransactionsViewDto.getSubService();
				int cardType = csvTransactionsViewDto.getCardType();
				int transactionCode =  csvTransactionsViewDto.getTransactionCode();
				int volume;
				
				if (csvTransactionsViewDto.getFleetCountTran().equals("N") && csvTransactionsViewDto.getCardType() == 6)
					volume = 0;
				else
					volume = 1;
			
				double nettAmount = (csvTransactionsViewDto.getTransactionAmount() * csvTransactionsViewDto.getAmountDirection()) + csvTransactionsViewDto.getBillingFeeAmount() 
						+ csvTransactionsViewDto.getBillingFee() + csvTransactionsViewDto.getBillingVat() +
						(csvTransactionsViewDto.getCashbackAmount() *csvTransactionsViewDto. getCashbackAmountDirection()) + csvTransactionsViewDto.getCashbackBillFeeAmnt() + 
						csvTransactionsViewDto.getCashbackBillFee() + csvTransactionsViewDto.getCashbackBillVat();
				
				//do the grouping here
			    NettTotalsDto nettTotalsDto = new NettTotalsDto();
			    nettTotalsDto.setIssuerMember(String.valueOf(issuerMember));
			    nettTotalsDto.setAcquirerMember(String.valueOf(acquirerMember));
			    nettTotalsDto.setService(service);
			    nettTotalsDto.setSubService(subService);
			    nettTotalsDto.setCardType(cardType);
			    nettTotalsDto.setTransactionCode(transactionCode);
			    nettTotalsDto.setVolume(volume);
			    nettTotalsDto.setNettAmount(nettAmount);
			    
			    String key = nettTotalsDto.getAcquirerMember() + nettTotalsDto.getIssuerMember() + nettTotalsDto.getService() + nettTotalsDto.getSubService();
			    
			    if (nettTotalsGroup.containsKey(key)){
			    	
			    	NettTotalsDto existingNettTotalsDto = nettTotalsGroup.get(key);
			    	
			    	int vol = existingNettTotalsDto.getVolume() + nettTotalsDto.getVolume();
			    	existingNettTotalsDto.setVolume(vol);
			    	
			    	double nettAmnt = existingNettTotalsDto.getNettAmount() + nettTotalsDto.getNettAmount();
			    	existingNettTotalsDto.setNettAmount(nettAmnt);
			    			
			    }else{
			    	nettTotalsGroup.put(key, nettTotalsDto);		    	
			    }
			}
	}
		//this would build the csvSettlementView
		if (nettTotalsGroup != null && nettTotalsGroup.size() > 0 ){
			csvSettlementViewDtolist = build(nettTotalsGroup);
		}
		return csvSettlementViewDtolist;
	}catch(Exception ex){
		ex.printStackTrace();
	 }
		return null;
	}
	private List<CsvSettlementViewDto> build(Map<String,NettTotalsDto> nettTotalsGroup){
		
		//get member by service X member by service relationship and get the volume and net from net totalls
		try{
			// get processing date
			CsoSystemParametersDTO csoSystemParametersDTO = new CsoSystemParametersDTO();
			csoSystemParametersDTO.setProcessActiveInd("Y");
			Date processingDate = new CsoSystemParametersDAO().retrieve(csoSystemParametersDTO).getProcessDate();
		   
			//get company details
			Collection<CsfCompanyParametersDTO> csfMemberServiceDtos =  BsvTableLookup.getInstance().getCsfCompanyParameters().values();
			CsfCompanyParametersDTO csfCompanyParametersDTO = (CsfCompanyParametersDTO)csfMemberServiceDtos.toArray()[0];
			// a list of members per service
			List<CSFMemberServiceDTO> csfMemberService  = (ArrayList<CSFMemberServiceDTO>)BsvTableLookup.getInstance().getCsfMemberService();
			
			for(CSFMemberServiceDTO csfMemberServiceOriginator : csfMemberService){
				
				for(CSFMemberServiceDTO csfMemberServiceDestination : csfMemberService){
					
					  
					  if (csfMemberServiceOriginator.getSubService().equals(csfMemberServiceDestination.getSubService()) &&
							  csfMemberServiceOriginator.getBankCode() != csfMemberServiceDestination.getBankCode()){
						  
						       CSFMembersDTO csfMemberOriginator  = BsvTableLookup.getInstance().getCsfMembers().get(String.valueOf(csfMemberServiceOriginator.getBankCode()));
						       CSFMembersDTO csfMemberDestination = BsvTableLookup.getInstance().getCsfMembers().get(String.valueOf(csfMemberServiceDestination.getBankCode()));
						     
						       if ( (csfMemberOriginator != null  && csfMemberOriginator.getMnemonicMemberName() != null ) && 
						    		  csfMemberDestination != null  && csfMemberDestination.getMnemonicMemberName() != null){
						    	  
						    	  CsvSettlementViewDto csvSettlemtCsvSettlementViewDto = new CsvSettlementViewDto();
						    	  
						    	  csvSettlemtCsvSettlementViewDto.setOriginatingBank(csfMemberServiceOriginator.getBankCode());
						    	  csvSettlemtCsvSettlementViewDto.setHomingBank(csfMemberServiceDestination.getBankCode());
						    	  csvSettlemtCsvSettlementViewDto.setProcessDate(processingDate);
						    	  csvSettlemtCsvSettlementViewDto.setService(csfMemberServiceOriginator.getService());
						    	  csvSettlemtCsvSettlementViewDto.setSubService(csfMemberServiceOriginator.getSubService());
						    	  
						    	  //validate subservice
						    	  CSFSubServicesDTO csfSubServicesDTO = BsvTableLookup.getInstance().getCsfSubServices().get(csfMemberServiceOriginator.getSubService());
						    	  if (csfSubServicesDTO == null){
						    		  log.error("Invalid subservice " + csfMemberServiceOriginator.getSubService());
						    		  continue;
						    	  }
						    	  
						    	  csvSettlemtCsvSettlementViewDto.setSettlementName(csfSubServicesDTO.getSettlementName());
						    	  csvSettlemtCsvSettlementViewDto.setPaymentStream(csvSettlemtCsvSettlementViewDto.getSubService().substring(1 , 2));
						    	  csvSettlemtCsvSettlementViewDto.setCurrencyCode(csfCompanyParametersDTO.getCurrencyCode());
						    	  csvSettlemtCsvSettlementViewDto.setStatusCode("D");
						    	  csvSettlemtCsvSettlementViewDto.setSettlementInd("N");
						    	  
						    	  /* What this does is get volumes and netamount when
						    	   * 1. when B bank is an acquirer and A bank an issuer and
						    	   * 2. when B bank is an issuer and A bank an aqcuirer
						    	   */
						    	  
						    	  //key order : aquirer -> issuer -> service -> subservice
						    	  //originator bank as an aquirer and homing bank as an issuer
						    	  String crKey = String.valueOf(csvSettlemtCsvSettlementViewDto.getOriginatingBank()) + String.valueOf(csvSettlemtCsvSettlementViewDto.getHomingBank()) + csvSettlemtCsvSettlementViewDto.getService() + csvSettlemtCsvSettlementViewDto.getSubService();
						    	  NettTotalsDto nettTotalsDto = nettTotalsGroup.get(crKey);
						    	  
						    	  if (nettTotalsDto != null){
							    	  csvSettlemtCsvSettlementViewDto.setCrVolume(nettTotalsDto.getVolume());
							    	  csvSettlemtCsvSettlementViewDto.setCrValue(nettTotalsDto.getNettAmount());
						    	  }else{
						    		  csvSettlemtCsvSettlementViewDto.setCrVolume(0);
							    	  csvSettlemtCsvSettlementViewDto.setCrValue(0);
						    	  }
						    	  
						    	  //key order : aquirer -> issuer -> service -> subservice
						    	  //originator bank as an issuer and homing bank as an acquirer
						    	  String drKey = String.valueOf(csvSettlemtCsvSettlementViewDto.getHomingBank()) + String.valueOf(csvSettlemtCsvSettlementViewDto.getOriginatingBank()) +  csvSettlemtCsvSettlementViewDto.getService() + csvSettlemtCsvSettlementViewDto.getSubService();
						    	  nettTotalsDto = nettTotalsGroup.get(drKey);
						    	  if (nettTotalsDto != null){
							    	  csvSettlemtCsvSettlementViewDto.setDrVolume(nettTotalsDto.getVolume());
							    	  csvSettlemtCsvSettlementViewDto.setDrValue(nettTotalsDto.getNettAmount());
						    	  }else{
						    		  csvSettlemtCsvSettlementViewDto.setDrVolume(0);
							    	  csvSettlemtCsvSettlementViewDto.setDrValue(0);
						    	  }
						    	  
						    	  csvSettlementViewDtoList.add(csvSettlemtCsvSettlementViewDto);
						      }
					  }
				}
			}
		}catch(Exception e){
			log.error(e.getMessage() , e);
		}
		
		return csvSettlementViewDtoList;
	}
	
	class NettTotalsDto{
		
		String issuerMember;
		String acquirerMember;
		String service;
		String subService;
		int volume;
		double nettAmount;
		int cardType;
		int transactionCode;
		
		public String getIssuerMember() {
			return issuerMember;
		}
		public void setIssuerMember(String issuerMember) {
			this.issuerMember = issuerMember;
		}
		public String getAcquirerMember() {
			return acquirerMember;
		}
		public void setAcquirerMember(String acquirerMember) {
			this.acquirerMember = acquirerMember;
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
		public int getVolume() {
			return volume;
		}
		public void setVolume(int volume) {
			this.volume = volume;
		}
		public double getNettAmount() {
			return nettAmount;
		}
		public void setNettAmount(double nettAmount) {
			this.nettAmount = nettAmount;
		}
		public int getCardType() {
			return cardType;
		}
		public void setCardType(int cardType) {
			this.cardType = cardType;
		}
		public int getTransactionCode() {
			return transactionCode;
		}
		public void setTransactionCode(int transactionCode) {
			this.transactionCode = transactionCode;
		}
		
	}

	public DataSource getConnection() {
		return connection;
	}

	public void setConnection(DataSource connection) {
		this.connection = connection;
	}

}
