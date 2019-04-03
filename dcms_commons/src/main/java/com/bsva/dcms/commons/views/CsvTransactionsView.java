package com.bsva.dcms.commons.views;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.bsva.dcms.commons.dao.CsfCardFeeBilateralDAO;
import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
import com.bsva.dcms.commons.dao.CsoTransactionsDAO;
import com.bsva.dcms.commons.dto.CSFBinsDTO;
import com.bsva.dcms.commons.dto.CSFCardTypesDTO;
import com.bsva.dcms.commons.dto.CSFSubServicesDTO;
import com.bsva.dcms.commons.dto.CSFTransactionTypesDTO;
import com.bsva.dcms.commons.dto.CSOTransactionDTO;
import com.bsva.dcms.commons.dto.CsfCardFeeBilateralDTO;
import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
import com.bsva.dcms.commons.dto.views.CsvTransactionsViewDto;
import com.bsva.dcms.commons.enums.Status;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.util.DateUtil;


/*
 * this will get all the transactions that we have received
 * for each transaction, validate acquirer member, issuer member, card type, transction type
 * bilateral fees for issuer|acquirer|card type| tranasaction type + cb filtered in combo > for interchange values
 * bilareral fees for issues|acquirer|card type| cb trans type based on (tranasaction type + cb filtered) above > for cashback interchange fees
 * and return all these values for transactions
 */
public class CsvTransactionsView{

	private DataSource connection;
	private List<CsvTransactionsViewDto> csvTransactionsViewDtoList = null;
	private Logger log = Logger.getLogger(CsvTransactionsView.class);
	
	public CsvTransactionsView(){
		this.csvTransactionsViewDtoList = new ArrayList<>();
	}

	public List<CsvTransactionsViewDto> execute(CSFSubServicesDTO subServices){  // this is for all the files..this method is used on completed files
		
		try{
			//added this condition. Get all the files whose output date is the same as the current processing date
			CsoInputFileControlsDTO csoInputFileControlsDTO = new CsoInputFileControlsDTO();
			csoInputFileControlsDTO.setProcessStatus(Status.C.getSymbol());
			csoInputFileControlsDTO.setOutputDate(DateUtil.formatStringToDate(BsvTableLookup.getInstance().getProcessDate() , "yyyyMMdd"));
			String service = subServices.getSubservice();
			csoInputFileControlsDTO.setSubService(service);
			CsoInputFileControlsDAO csoInputFileControlsdao = new CsoInputFileControlsDAO();
			List<CsoInputFileControlsDTO> csoInputFileControlsDtoList = csoInputFileControlsdao.retrieveRelated(csoInputFileControlsDTO);
		    
			if (csoInputFileControlsDtoList != null && csoInputFileControlsDtoList.size() > 0){
				for(CsoInputFileControlsDTO csoInputFuleContolsDto : csoInputFileControlsDtoList){
					execute(csoInputFuleContolsDto);
			    }
			}
		}catch(Exception e){
			log.error(e.getMessage() , e);
		}
		
		return csvTransactionsViewDtoList;
	}
	//TODO: include fleet
	public List<CsvTransactionsViewDto> execute(CsoInputFileControlsDTO csoInputFileControlsDTO){  // this is for a file
		
		try{
			
			CsvTransactionsViewDto csvTransactionsViewDto = null;
			
			//check file details
		    if (csoInputFileControlsDTO == null)
		    	return null;
			
			//calculate billing for each transaction
			CSOTransactionDTO csoTransactionDTO = new CSOTransactionDTO();
			csoTransactionDTO.setFileSystemSeqNumber(csoInputFileControlsDTO.getSystemSeqNumber());
			CsoTransactionsDAO csoTransactionsdao = new CsoTransactionsDAO();
			List<CSOTransactionDTO> transactions =  csoTransactionsdao.retrieveRelated(csoTransactionDTO);
			
			for(CSOTransactionDTO csoTransaction : transactions){
                            
				csvTransactionsViewDto = new CsvTransactionsViewDto();
				
				csvTransactionsViewDto.setFileRefNo(csoInputFileControlsDTO.getFileRefNumber());
				csvTransactionsViewDto.setService(csoInputFileControlsDTO.getService());
				csvTransactionsViewDto.setSubService(csoInputFileControlsDTO.getSubService());
				csvTransactionsViewDto.setAcquirerMember(csoTransaction.getAcquirerMember());
				csvTransactionsViewDto.setIssuerMember(csoTransaction.getIssuerMember()); 
				csvTransactionsViewDto.setCardType(csoTransaction.getCardType()); 
				String cashbackPresent = csoTransaction.getCashbackPresent();
				csvTransactionsViewDto.setCashbackPresent(cashbackPresent);
				
				int transactionCode = csoTransaction.getTransactionCode();
				if (cashbackPresent.equals("Y") && csoTransaction.getCashbackAmount().doubleValue() < csoTransaction.getTransactionAmount()){
					if (csoTransaction.getTransactionCode() >= 1 && csoTransaction.getTransactionCode() <= 9) //purchases
						transactionCode = 3; //PURCHASE (WCASHB)
					if (csoTransaction.getTransactionCode() >= 10 && csoTransaction.getTransactionCode() <= 19) //chargebacks
						transactionCode = 13; //CHARGEBACK (WCASHB)
					if (csoTransaction.getTransactionCode() >= 20 && csoTransaction.getTransactionCode() <= 29)
						transactionCode = 23; //CHARGEBACK (WCASHB)
				}else if (cashbackPresent.equals("Y") && csoTransaction.getCashbackAmount().doubleValue() == csoTransaction.getTransactionAmount()){
					if (csoTransaction.getTransactionCode() >= 1 && csoTransaction.getTransactionCode() <= 9)
						transactionCode = 2; //CASHBACK - NO PURCHASE
					if (csoTransaction.getTransactionCode() >= 10 && csoTransaction.getTransactionCode() <= 19)
						transactionCode = 12; //CHARGEBACK (CASH)
					if (csoTransaction.getTransactionCode() >= 20 && csoTransaction.getTransactionCode() <= 29)
						transactionCode = 22; //REVERSAL (CASH)
				}else if (cashbackPresent.equals("N")){
					transactionCode = csoTransaction.getTransactionCode();
				}
                                
				csvTransactionsViewDto.setTransactionCode(transactionCode);

				if (cashbackPresent.equals("Y") && csoTransaction.getCashbackAmount().doubleValue() == csoTransaction.getTransactionAmount()){
					csvTransactionsViewDto.setCashbackAmount(BigDecimal.ZERO.doubleValue()); 
				}else{
					csvTransactionsViewDto.setCashbackAmount(csoTransaction.getCashbackAmount().doubleValue());
				}
				
				csvTransactionsViewDto.setTransactionStatus(csoTransaction.getProcessStatus()); 
				csvTransactionsViewDto.setFileStatus(csoInputFileControlsDTO.getProcessStatus());
				
				double transactionAmount;
				if (cashbackPresent.equals("Y") && csoTransaction.getCashbackAmount().doubleValue() == csoTransaction.getTransactionAmount()){
					transactionAmount = csoTransaction.getTransactionAmount();
				}else{
					transactionAmount = csoTransaction.getTransactionAmount() - csoTransaction.getCashbackAmount().doubleValue();
				}
				csvTransactionsViewDto.setTransactionAmount(transactionAmount);
				
				csvTransactionsViewDto.setIssuerBin(csoTransaction.getIssuerBin());
				csvTransactionsViewDto.setAcquirerBin(csoTransaction.getAcquirerBin());
				csvTransactionsViewDto.setTransactionSystemSeqNumber(csoTransaction.getSystemSeqNumber()); 
				csvTransactionsViewDto.setBillingFee(csoTransaction.getBillingFee()); 
				csvTransactionsViewDto.setBillingFeeAmount(csoTransaction.getBillingFeeAmount()); 
				csvTransactionsViewDto.setBillingVat(csoTransaction.getBillingVat()); 
				csvTransactionsViewDto.setCashbackBillFee(csoTransaction.getCbBillFee());
				csvTransactionsViewDto.setCashbackBillFeeAmnt(csoTransaction.getCbBillFeeAmnt()); 
				csvTransactionsViewDto.setCashbackBillVat(csoTransaction.getCbBillVat()); 
				csvTransactionsViewDto.setFleetCountTran(csoTransaction.getFleetCountTran());
				csvTransactionsViewDto.setMerchantCatCode(csoTransaction.getMessageTypeInd());
				csvTransactionsViewDto.setMerchantCatCode(csoTransaction.getMerchantCatCode()); 
				csvTransactionsViewDto.setInterchangeRateDsgn(csoTransaction.getIntchgRateDsgn()); 
				csvTransactionsViewDto.setMessageReasonCode(csoTransaction.getMessageReasonCode()); 
				
				CSFBinsDTO binDto_Acquirer = null;
				
				//binDto = BsvTableLookup.getInstance().getCsfBins().get(issuerWorkstationBIN);
				binDto_Acquirer = BsvTableLookup.getInstance().getBINDetailForBin(Integer.valueOf(csoTransaction.getAcquirerBin()));
				 //binDto_Acquirer = BsvTableLookup.getInstance().getCsfBins().get(String.valueOf(csoTransaction.getAcquirerBin()));
				if (binDto_Acquirer == null){
					log.error("Invalid acquirer " + csoTransaction.getAcquirerBin() + ", transaction " + csoTransaction.getSystemSeqNumber());
					continue;
				}
				else{
					csvTransactionsViewDto.setAcquirerName(binDto_Acquirer.getBinDescription());
				}
				
				CSFBinsDTO binDto_Issuer = null;
				binDto_Issuer = BsvTableLookup.getInstance().getBINDetailForBin(Integer.valueOf(csoTransaction.getIssuerBin()));
				//binDto_Issuer = BsvTableLookup.getInstance().getCsfBins().get(String.valueOf(csoTransaction.getIssuerBin()));
				if (binDto_Issuer == null){
					log.error("Invalid issuer " + csoTransaction.getIssuerMember() + ", transaction " + csoTransaction.getSystemSeqNumber());
					continue;
				}else{
					csvTransactionsViewDto.setIssuerName(binDto_Issuer.getBinDescription());
				}
				
				CSFCardTypesDTO cardTypesDto = BsvTableLookup.getInstance().getCsfCardTypes().get(String.valueOf(csoTransaction.getCardType()));
				if ( cardTypesDto == null){
					log.error("Invalid card type " + csoTransaction.getCardType() + ", transaction " + csoTransaction.getSystemSeqNumber());
					continue;
				}else{
					csvTransactionsViewDto.setCardDescription(cardTypesDto.getCardDescription());
				}
				
				
				CSFTransactionTypesDTO transactionTypeDto =  BsvTableLookup.getInstance().getCsfTransactionTypes().get(String.valueOf(transactionCode));
				if (transactionTypeDto == null){
					log.error("Invalid transaction code " + transactionCode + " , transaction " + csoTransaction.getSystemSeqNumber()); 
					continue;
				}else{
					csvTransactionsViewDto.setTransactionDescription( transactionTypeDto.getTransactionDescription()); 
					csvTransactionsViewDto.setReportSortSequence(transactionTypeDto.getReportSortSequence()); 
				}
				
				
				
				CsfCardFeeBilateralDTO csfCardFeeBilateralDTO = new CsfCardFeeBilateralDTO();
				csfCardFeeBilateralDTO.setIssuingMember(binDto_Issuer.getBankCode());
				csfCardFeeBilateralDTO.setAcquiringMember(binDto_Acquirer.getBankCode());
				csfCardFeeBilateralDTO.setTransactionCode(transactionCode);
				csfCardFeeBilateralDTO.setCardType(cardTypesDto.getCardType());
				CsfCardFeeBilateralDAO csfCardFeeBilateraldao = new CsfCardFeeBilateralDAO();
				CsfCardFeeBilateralDTO csfCardFeeBilateral = csfCardFeeBilateraldao.retrieve(csfCardFeeBilateralDTO);
				
				if( csfCardFeeBilateral != null){
					//csf_card_fee_bilateral lookup
						csvTransactionsViewDto.setInterchangeFee(csfCardFeeBilateral.getInterchangeFee());
						csvTransactionsViewDto.setInterchangeFeeAmount(csfCardFeeBilateral.getInterchangeFeeAmount());
						csvTransactionsViewDto.setInputVat(csfCardFeeBilateral.getInputVat()); 
						csvTransactionsViewDto.setDestReport(csfCardFeeBilateral.getDestReport()); 
						csvTransactionsViewDto.setAmountDirection(csfCardFeeBilateral.getAmountDirection()); //note, is amount dir is null it should default to 1*/
						
						
					}else{
						csvTransactionsViewDto.setInterchangeFee(0);
						csvTransactionsViewDto.setInterchangeFeeAmount(0); 
						csvTransactionsViewDto.setInputVat(0); 
						csvTransactionsViewDto.setDestReport(null); 
						csvTransactionsViewDto.setAmountDirection(0); 
						//log.error("Error getting CsfCardFeeBilateral for transaction  AcquiringMember " + csfCardFeeBilateral.getAcquiringMember() + ", IssuingMember " + csfCardFeeBilateral.getIssuingMember()+ ", TransactionCode " + csfCardFeeBilateral.getTransactionCode());
						//continue;
					}
				
				CsfCardFeeBilateralDTO csfCardFeeBilateraldto= new CsfCardFeeBilateralDTO();
				csfCardFeeBilateraldto.setIssuingMember(csoTransaction.getIssuerMember());
				csfCardFeeBilateraldto.setAcquiringMember(csoTransaction.getAcquirerMember());
				csfCardFeeBilateralDTO.setCardType(csoTransaction.getCardType());
				
//				csfCardFeeBilateralDTO.setIssuingMember(binDto_Issuer.getBankCode());
//				csfCardFeeBilateralDTO.setAcquiringMember(binDto_Acquirer.getBankCode());
//				csfCardFeeBilateralDTO.setTransactionCode(transactionCode);
				
				if (transactionCode >= 0 && transactionCode <= 9)
					csfCardFeeBilateraldto.setTransactionCode(8); //CASH BACK ON PRUCHASE
				if (transactionCode >= 10 && transactionCode <= 19)
					csfCardFeeBilateraldto.setTransactionCode(18); //CASHBACK (WPURC)
				if (transactionCode >= 20 && transactionCode <= 29)
					csfCardFeeBilateraldto.setTransactionCode(28); //REVERSAL (WPURC)
				
				CsfCardFeeBilateralDTO csfCardFeeBilateralDTO2 = new CsfCardFeeBilateralDTO();
				csfCardFeeBilateralDTO2.setIssuingMember(binDto_Issuer.getBankCode());
				csfCardFeeBilateralDTO2.setAcquiringMember(binDto_Acquirer.getBankCode());
				csfCardFeeBilateralDTO2.setTransactionCode(transactionCode);
				//csfCardFeeBilateralDTO2.setCardType(cardTypesDto.getCardType());
				
				CsfCardFeeBilateralDAO csfCardFeeBilateraldao2 = new CsfCardFeeBilateralDAO();
				CsfCardFeeBilateralDTO csfCardFeeBilateral2 = csfCardFeeBilateraldao2.retrieve(csfCardFeeBilateralDTO2);
				
				if( csfCardFeeBilateral2 != null){
					//csf_card_fee_bilateral lookup
						csvTransactionsViewDto.setCashbackInterchangeFee(csfCardFeeBilateral2.getInterchangeFee());
						csvTransactionsViewDto.setCashbackInterchangeFeeAmount(csfCardFeeBilateral2.getInterchangeFeeAmount());
						csvTransactionsViewDto.setCashbackInputVat(csfCardFeeBilateral2.getInputVat()); 
						csvTransactionsViewDto.setAmountDirection(csfCardFeeBilateral2.getAmountDirection()); //note, is amount dir is null it should default to 1*/
						
						
					}else{
						csvTransactionsViewDto.setCashbackInterchangeFee(0);
						csvTransactionsViewDto.setCashbackInterchangeFeeAmount(0);
						csvTransactionsViewDto.setCashbackInputVat(0); 
						csvTransactionsViewDto.setCashbackAmountDirection(0); 
						//log.error("Error getting CsfCardFeeBilateral for transaction  AcquiringMember " + csfCardFeeBilateral2.getAcquiringMember() + ", IssuingMember " + csfCardFeeBilateral2.getIssuingMember()+ ", TransactionCode " + csfCardFeeBilateral2.getTransactionCode());
						//continue;
					}
				
				csvTransactionsViewDtoList.add(csvTransactionsViewDto);
			}

		}catch(Exception e){
			log.error(e.getMessage() , e);
		}
		
		return csvTransactionsViewDtoList;
	}
	
	public DataSource getConnection() {
		return connection;
	}

	public void setConnection(DataSource connection) {
		this.connection = connection;
	}

	public List<CsvTransactionsViewDto> getCsvTransactionsViewDtoList() {
		return csvTransactionsViewDtoList;
	}

	public void setCsvTransactionsViewDtoList(
			List<CsvTransactionsViewDto> csvTransactionsViewDtoList) {
		this.csvTransactionsViewDtoList = csvTransactionsViewDtoList;
	}
	
}
