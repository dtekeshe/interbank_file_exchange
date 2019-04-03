package com.bsva.view.nombu;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dcms.commons.dao.CsoTransactionsDAO;
import com.bsva.dcms.commons.dto.CSFCardTypesDTO;
import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.dto.CSFMembersDTO;
import com.bsva.dcms.commons.dto.CSFSubServicesDTO;
import com.bsva.dcms.commons.dto.CSFTransactionTypesDTO;
import com.bsva.dcms.commons.dto.CSOTransactionDTO;
import com.bsva.dcms.commons.dto.views.CsvCcr00XDataViewDto;
import com.bsva.dcms.commons.dto.views.CsvTransactionsViewDto;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.util.BsvTableLookup;


public class CsvCcr00XDataView {

	/*private Connection connection;
	private List<CsvCcr00XDataViewDto> csvCcr00XDataViewDtoList = null;
	private List<ReportLayout> reportLayoutList = null;
	private List<ReportData> reportDataList = null;


	public CsvCcr00XDataView(Connection connection){
		try{
			this.connection = connection;
			this.csvCcr00XDataViewDtoList = new ArrayList<>();
			this.reportLayoutList = new ArrayList<>();
			this.reportDataList = new ArrayList<>();

		}catch(Exception e){
			e.printStackTrace();
		}
	}



	//get list of transactions
	public List<CSFTransactionTypesDTO> execute(){

		List<CSFTransactionTypesDTO> dtoList = (List<CSFTransactionTypesDTO>) BsvTableLookup.getInstance().getCsfTransactionTypes().values();
		try{
			for(CSFTransactionTypesDTO csfTransactionTypesDTO : dtoList){

				if (csfTransactionTypesDTO.getFinancialInd().equals("Y")){

					int transactionCode = csfTransactionTypesDTO.getTransactionCode();

					if (csfTransactionTypesDTO.getTransactionCode() == 9)
						transactionCode = 5;

					if (csfTransactionTypesDTO.getTransactionCode() == 19)
						transactionCode = 15;

					if (csfTransactionTypesDTO.getTransactionCode() == 29)
						transactionCode = 25;



					String	transactionDescription = BsvTableLookup.getInstance().getCsfTransactionTypes().get(String.valueOf(transactionCode)).getTransactionDescription();
					int reportSortSeq = BsvTableLookup.getInstance().getCsfTransactionTypes().get(String.valueOf(transactionCode)).getReportSortSequence();

					csfTransactionTypesDTO.setTransactionCode(transactionCode);
					csfTransactionTypesDTO.setTransactionDescription(transactionDescription);
					csfTransactionTypesDTO.setReportSortSequence(reportSortSeq);

				}
				dtoList.add(csfTransactionTypesDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dtoList;
	}


	public List<ReportLayout> build(ReportLayout reportLayout){


		List<CSFMembersDTO> csfMemberList = (List<CSFMembersDTO>) BsvTableLookup.getInstance().getCsfMembers().values();

		try{
			for(CSFMembersDTO csfMemberOriginator : csfMemberList){

				if (csfMemberOriginator!=null && csfMemberOriginator.getMnemonicMemberName()!=null){
					for(CSFMembersDTO csfMemberDestination : csfMemberList){

						if (csfMemberDestination!=null && csfMemberDestination.getMnemonicMemberName()!=null)
							if (csfMemberOriginator.getBankCode() != csfMemberDestination.getBankCode()){

								CSFMemberServiceDTO csfMemberServiceOriginator  = BsvTableLookup.getInstance().getCsfMemberService().get(csfMemberOriginator.getBankCode());
								CSFMemberServiceDTO csfMemberServiceDestination = BsvTableLookup.getInstance().getCsfMemberService().get(csfMemberDestination.getBankCode());

								if (csfMemberOriginator.getBankCode() == csfMemberServiceOriginator.getBankCode())
									if (csfMemberDestination.getBankCode() == csfMemberServiceDestination.getBankCode())
										if (csfMemberServiceOriginator.getSubService().equals(csfMemberServiceDestination.getSubService()) && csfMemberServiceOriginator.getService().equals(csfMemberServiceDestination.getService()));


								CSFSubServicesDTO csfSubServicesDTO = BsvTableLookup.getInstance().getCsfSubServices().get(csfMemberServiceOriginator.getSubService());

								if (csfSubServicesDTO.getSubservice().equals(csfMemberServiceOriginator.getSubService()) && csfSubServicesDTO.getService().equals(csfMemberServiceOriginator.getService()));

								CSFCardTypesDTO csfCardTypes = BsvTableLookup.getInstance().getCsfCardTypes().get(csfMemberOriginator.getBankCode());

								if (csfMemberServiceOriginator.getSubService().equals(csfCardTypes.getSubService()))

								reportLayout.setIssuerMember(csfMemberOriginator.getMemberName());
								reportLayout.setIssuerCode(csfMemberOriginator.getBankCode());
								reportLayout.setAcquirerMember(csfMemberDestination.getMemberName());
								reportLayout.setAcquirerCode(csfMemberDestination.getBankCode());
								reportLayout.setSubService(csfSubServicesDTO.getSubservice());
								reportLayout.setDisplayName(csfSubServicesDTO.getDisplayName());
								reportLayout.setCardType(csfCardTypes.getCardType());
								reportLayout.setCardDescription(csfCardTypes.getCardDescription());
								reportLayout.setTransactionCode(transactionCode);
							reportLayout.setTransactionDescription(transactionDescription);
							reportLayout.setReportSortSequence(reportSortSeq);
								reportLayout.setService(csfSubServicesDTO.getService());	

								reportLayoutList.add(reportLayout); 

							}
					}
				}

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return reportLayoutList;


	}

	public List<ReportData> build(ReportData reportDataLayoutBean) throws DAOException{

		CsvTransactionsView csvTransactionsView = new CsvTransactionsView(connection);
		List<CsvTransactionsViewDto>  csvTransactionvList= csvTransactionsView.execute();   

		try{
			for(CsvTransactionsViewDto csvTransactionsViewDto : csvTransactionvList){

				int acquirerMember;
				if (csvTransactionsViewDto.getDestReport().equals("A"))
					acquirerMember = csvTransactionsViewDto.getAcquirerMember();
				else
					acquirerMember = csvTransactionsViewDto.getIssuerMember();

				int issuerMember;
				if (csvTransactionsViewDto.getDestReport().equals("A"))
					issuerMember = csvTransactionsViewDto.getIssuerMember();
				else
					issuerMember = csvTransactionsViewDto.getAcquirerMember();


				String service = csvTransactionsViewDto.getService();
				int cardType = csvTransactionsViewDto.getCardType();

				int volume;

				if (csvTransactionsViewDto.getFleetCountTran().equals("Y"))
					volume = 1;
				else
					volume = 0;

				CSOTransactionDTO csoTransactionDTO = new CSOTransactionDTO();
				List<CSOTransactionDTO> transactions =  new CsoTransactionsDAO(connection).retrieveRelated(csoTransactionDTO);

				int transactionCode =  csvTransactionsViewDto.getTransactionCode();

				for(CSOTransactionDTO csoTransaction : transactions){

					if (csoTransaction.getTransactionCode() == 3)
						transactionCode = 8;
					if (csoTransaction.getTransactionCode() == 13)
						transactionCode = 18;
					if (csoTransaction.getTransactionCode() == 23)
						transactionCode = 28;

				}

				if ((csvTransactionsViewDto.getTransactionCode() == 3 && csvTransactionsViewDto.getTransactionCode() == 13 && csvTransactionsViewDto.getTransactionCode() == 23) && csvTransactionsViewDto.getTransactionStatus().equals("C") && 
						(csvTransactionsViewDto.getFileStatus().equals("C") || csvTransactionsViewDto.getFileStatus().equals("E"))){
					return null;
				}


				double amount = ((csvTransactionsViewDto.getTransactionAmount()) * (csvTransactionsViewDto.getAmountDirection())) + (csvTransactionsViewDto.getBillingFee())  + (csvTransactionsViewDto.getBillingFeeAmount()) 
						+ (csvTransactionsViewDto.getBillingVat());

				reportDataLayoutBean.setAcquirerMember(acquirerMember);
				reportDataLayoutBean.setIssuerMember(issuerMember);
				reportDataLayoutBean.setService(service);
				reportDataLayoutBean.setCardType(cardType);
				reportDataLayoutBean.setVolume(volume);
				reportDataLayoutBean.setTransactionCode(transactionCode);
				reportDataLayoutBean.setTransactionAmnt(amount);
				reportDataLayoutBean.setBillingFee(csvTransactionsViewDto.getBillingFee());
				reportDataLayoutBean.setBillingVat(csvTransactionsViewDto.getBillingVat());
				reportDataLayoutBean.setDestReport(csvTransactionsViewDto.getDestReport());

				reportDataList.add(reportDataLayoutBean);

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return reportDataList;


	}

	public List<ReportData> builds(ReportData reportDataLayoutBean, CsvCcr00XDataViewDto dto) throws DAOException{

		CsvTransactionsView csvTransactionsView = new CsvTransactionsView(connection);
		List<CsvTransactionsViewDto>  csvTransactionvList= csvTransactionsView.execute();   

		try{
			for(CsvTransactionsViewDto csvTransactionsViewDto : csvTransactionvList){

				int acquirerMember;
				if (csvTransactionsViewDto.getDestReport().equals("A"))
					acquirerMember = csvTransactionsViewDto.getAcquirerMember();
				else
					acquirerMember = csvTransactionsViewDto.getIssuerMember();

				int issuerMember;
				if (csvTransactionsViewDto.getDestReport().equals("A"))
					issuerMember = csvTransactionsViewDto.getIssuerMember();
				else
					issuerMember = csvTransactionsViewDto.getAcquirerMember();


				String service = csvTransactionsViewDto.getService();
				int cardType = csvTransactionsViewDto.getCardType();

				int volume;

				if (csvTransactionsViewDto.getFleetCountTran().equals("Y"))
					volume = 1;
				else
					volume = 0;

				CSOTransactionDTO csoTransactionDTO = new CSOTransactionDTO();
				List<CSOTransactionDTO> transactions =  new CsoTransactionsDAO(connection).retrieveRelated(csoTransactionDTO);

				int transactionCode =  csvTransactionsViewDto.getTransactionCode();

				for(CSOTransactionDTO csoTransaction : transactions){
					if (csoTransaction.getTransactionCode() == 9)
						transactionCode = 5;
					if (csoTransaction.getTransactionCode() == 19)
						transactionCode = 15;
					if (csoTransaction.getTransactionCode() == 29)
						transactionCode = 25;

				}

				if ((csvTransactionsViewDto.getTransactionStatus().equals("C") && 
						(csvTransactionsViewDto.getFileStatus().equals("C") || csvTransactionsViewDto.getFileStatus().equals("E")) && 
						csvTransactionsViewDto.getTransactionCode() < 40)){
					return null;
				}

				//grouping
				reportDataLayoutBean.setAcquirerMember(acquirerMember);
				reportDataLayoutBean.setIssuerMember(issuerMember);
				reportDataLayoutBean.setService(service);
				reportDataLayoutBean.setCardType(cardType);
				reportDataLayoutBean.setTransactionCode(transactionCode);
				reportDataLayoutBean.setDestReport(csvTransactionsViewDto.getDestReport());

				Map<String,List<ReportData>> reportDataGrouping = new HashMap<>();
				String key = reportDataLayoutBean.getAcquirerMember() + reportDataLayoutBean.getIssuerMember() + reportDataLayoutBean.getService();

				if (reportDataGrouping.containsKey(key)){

					List<ReportData> reportList = reportDataGrouping.get(key);
					reportList.add(reportDataLayoutBean);

				}else{
					List<ReportData> reportList = new ArrayList<>();
					reportList.add(reportDataLayoutBean);

					reportDataGrouping.put(key, reportList);		    	
				}
				reportDataList.add(reportDataLayoutBean);

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return reportDataList;


	}

	public List<CsvCcr00XDataViewDto> executeAll(CsvCcr00XDataViewDto dto, ReportData reportDataLayoutBean, ReportLayout reportLayout){

		Map<String,List<ReportLayout>> reportLayoutGrouping = new HashMap<>();

		try{
			//check rules		
			if (reportLayout.getIssuerCode()== reportDataLayoutBean.getIssuerMember() && reportLayout.getAcquirerCode() == reportDataLayoutBean.getAcquirerMember() 
					&& reportLayout.getService().equals(reportDataLayoutBean.getService()) && reportLayout.getCardType()== reportDataLayoutBean.getCardType() 
					&& reportLayout.getTransactionCode() == reportDataLayoutBean.getTransactionCode()){

				//set values to the CsvCcr00XDataViewDto					
				dto.setIssuerMember(reportLayout.getIssuerMember());
				dto.setIssuerBankCode(reportLayout.getIssuerCode());
				dto.setAcquirerMember(reportLayout.getAcquirerMember());
				dto.setAcquirerBankCode(reportLayout.getAcquirerCode());
				dto.setService(reportLayout.getService());
				dto.setSubService(reportLayout.getSubService());
				dto.setCardType(reportLayout.getCardType());
				dto.setCardDescription(reportLayout.getCardDescription());
				dto.setTransactionCode(reportLayout.getTransactionCode());
				dto.setTransactionDescription(reportLayout.getTransactionDescription());
				dto.setVolume(reportDataLayoutBean.getVolume());
				dto.setTransactionValue(reportDataLayoutBean.getTranValue());
				dto.setBilingFee(reportDataLayoutBean.getBillingFee());
				dto.setBillingFeeAmount(reportDataLayoutBean.getBillingFeeAmount());
				dto.setBillingVat(reportDataLayoutBean.getBillingVat());
				dto.setReportSortSequence(reportLayout.getReportSortSequence());

				//order by
				reportLayout.getIssuerCode();
				reportLayout.getAcquirerCode();
				reportLayout.getService();
				reportLayout.getSubService();
				reportLayout.getCardType();
				reportLayout.getReportSortSequence();

				String key = reportLayout.getAcquirerMember() + reportLayout.getIssuerMember() + reportLayout.getService() + reportLayout.getSubService();

				if (reportLayoutGrouping.containsKey(key)){

					List<ReportLayout> reportLayoutList = reportLayoutGrouping.get(key);
					reportLayoutList.add(reportLayout);

				}else{
					List<ReportLayout> reportLayoutList = new ArrayList<>();
					reportLayoutList.add(reportLayout);

					reportLayoutGrouping.put(key, reportLayoutList);		    	
				}


				csvCcr00XDataViewDtoList.add(dto);

			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return csvCcr00XDataViewDtoList;


	}


	class ReportLayout{

		String issuerMember;
		int issuerCode;
		String acquirerMember;
		int acquirerCode;
		String subService;
		String displayName;
		int cardType;
		String cardDescription;
		int transactionCode;
		String transactionDescription;
		int reportSortSequence;
		String service;

		public String getIssuerMember() {
			return issuerMember;
		}
		public void setIssuerMember(String issuerMember) {
			this.issuerMember = issuerMember;
		}
		public int getIssuerCode() {
			return issuerCode;
		}
		public void setIssuerCode(int issuerCode) {
			this.issuerCode = issuerCode;
		}
		public String getAcquirerMember() {
			return acquirerMember;
		}
		public void setAcquirerMember(String acquirerMember) {
			this.acquirerMember = acquirerMember;
		}
		public int getAcquirerCode() {
			return acquirerCode;
		}
		public void setAcquirerCode(int acquirerCode) {
			this.acquirerCode = acquirerCode;
		}
		public String getSubService() {
			return subService;
		}
		public void setSubService(String subService) {
			this.subService = subService;
		}
		public String getDisplayName() {
			return displayName;
		}
		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}
		public int getCardType() {
			return cardType;
		}
		public void setCardType(int cardType) {
			this.cardType = cardType;
		}
		public String getCardDescription() {
			return cardDescription;
		}
		public void setCardDescription(String cardDescription) {
			this.cardDescription = cardDescription;
		}
		public int getTransactionCode() {
			return transactionCode;
		}
		public void setTransactionCode(int transactionCode) {
			this.transactionCode = transactionCode;
		}
		public String getTransactionDescription() {
			return transactionDescription;
		}
		public void setTransactionDescription(String transactionDescription) {
			this.transactionDescription = transactionDescription;
		}
		public int getReportSortSequence() {
			return reportSortSequence;
		}
		public void setReportSortSequence(int reportSortSequence) {
			this.reportSortSequence = reportSortSequence;
		}
		public String getService() {
			return service;
		}
		public void setService(String service) {
			this.service = service;
		}


	}

	class ReportData{

		int acquirerMember;
		int issuerMember;
		String service;
		int cardType;
		int transactionCode;
		String destReport;
		int volume;
		Double transactionAmnt;
		Double tranValue;
		Double billingFee;
		Double billingFeeAmount;
		Double billingVat;

		public int getAcquirerMember() {
			return acquirerMember;
		}
		public void setAcquirerMember(int acquirerMember) {
			this.acquirerMember = acquirerMember;
		}
		public int getIssuerMember() {
			return issuerMember;
		}
		public void setIssuerMember(int issuerMember) {
			this.issuerMember = issuerMember;
		}
		public String getService() {
			return service;
		}
		public void setService(String service) {
			this.service = service;
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
		public String getDestReport() {
			return destReport;
		}
		public void setDestReport(String destReport) {
			this.destReport = destReport;
		}
		public int getVolume() {
			return volume;
		}
		public void setVolume(int volume) {
			this.volume = volume;
		}
		public Double getTransactionAmnt() {
			return transactionAmnt;
		}
		public void setTransactionAmnt(Double transactionAmnt) {
			this.transactionAmnt = transactionAmnt;
		}
		public Double getTranValue() {
			return tranValue;
		}
		public void setTranValue(Double tranValue) {
			this.tranValue = tranValue;
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

	}*/
}
