//package com.bsva.dmcs.fileLoad.visa;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import com.bsva.dcms.commons.dto.CSFBinsDTO;
//import com.bsva.dcms.commons.dto.file.FileAXSHeaderRecordDTO;
//import com.bsva.dcms.commons.dto.file.FileDTO;
//import com.bsva.dcms.commons.dto.file.FileEOS98RecordDTO;
//import com.bsva.dcms.commons.dto.file.FileAXSTrailorRecordDTO;
//import com.bsva.dcms.commons.dto.file.FileHeader90RecordDTO;
//import com.bsva.dcms.commons.dto.file.FileTrailer91_92RecordDTO;
//import com.bsva.dcms.commons.dto.file.FileTransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.NegativeCardRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISAFileTransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISATCR0TransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISATCR1TransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISATCR3TransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISATCR5TransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISATCR7TransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISAFileDTO;
//import com.bsva.dcms.commons.enums.Status;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dcms.commons.util.Constants;
//import com.bsva.dcms.commons.util.Utils;
//import com.bsva.dmcs.fileLoad.AbstractFileLoader;
//import com.bsva.dmcs.fileLoad.FileLoadDAO;
//import com.bsva.dmcs.fileLoad.Loader;
//import com.bsva.dmcs.fileLoad.exceptions.FileLoadException;
//
//public class VisaFileLoader extends AbstractFileLoader{
//
//	private Logger log = Logger.getLogger(VisaFileLoader.class);
//	private VISAFileDTO fileDto = new VISAFileDTO();
//	private VISAFileTransactionRecordDTO lastTransactionRead = null;
//
//	private List<FileTransactionRecordDTO> batchTransactionRecordDtos;
//	private List<NegativeCardRecordDTO> batchNegativeCardRecordDtos;
//
//	public FileDTO getFileByType(){
//		return fileDto;
//	}
//
//	public void loadFileByType(String fileName) throws FileLoadException{
//		// TODO Auto-generated method stub
//
//		log.info("Loading file " + fileName);
//
//		fileDto.setNegativeCardRecordDToList(new ArrayList<NegativeCardRecordDTO>());
//		fileDto.setFileCtrlTrailorDtoList(new ArrayList<FileTrailer91_92RecordDTO>());
//
//		batchTransactionRecordDtos = new ArrayList<FileTransactionRecordDTO>();
//		batchNegativeCardRecordDtos = new ArrayList<NegativeCardRecordDTO>();
//
//		BufferedReader br = null;
//		String line = "";
//		try{
//			br = new BufferedReader(new FileReader(BsvTableLookup.getInstance().getReceiveDir() + File.separator + fileName));
//
//			while ((line = br.readLine()) != null){
//
//				lineCount++;
//
//				String recordId = line.substring(0,2);
//
//				if (recordId.equals(Constants.AXS_HEADER_RECID)){
//					createAXSHeaderRecord(line);
//
//				}else if (recordId.equals(Constants.HEADER_90_RECID)){
//			        createHeader90Record(line);
//
//				}else if (recordId.equals(Constants.AXS_TRAILOR_RECID)){
//					createAXSTrailorRecord(line);
//
//				}else if (recordId.equals(Constants.EOS_98_RECID)){
//					createEOSRecord(line);
//
//				}else if (recordId.equals(Constants.END_OF_BATCH_91)  || recordId.equals(Constants.END_OF_BATCH_92)){
//					createEOB91_92Record(line);
//
//				}else if (recordId.equals(Constants.NEGATIVE_CARD_RECID)){ //41
//					createNegativeRecord(line);
//
//				}else{
//
//					switch(recordId){
//
//					case "04": case "05": case "06": case "07": case "14": case "15": case "16": case "17": case "24": case "25": case "26": case "27":
//						createFileTransaction(line);
//						recordCount++;
//						break;
//					default:
//						//TODO : We validate transaction code later, so maybe dont reject the file
//						fileDto.getErrorDto().addError(31, lineCount, Utils.IsNumeric(recordId) ? Integer.parseInt(recordId) : 0, 1, recordId, null);
//						fileDto.setFileStatus(Status.R.getSymbol());
//					}
//				}
//			}
//
//			//if you read the entire file and still found no trailor record
//			if (fileDto.getFileAxsTrailorRecordDto() == null){
//				fileDto.getErrorDto().addError(9, lineCount, 99, 1 ,  "99", null);
//				fileDto.setFileStatus(Status.R.getSymbol());
//			}
//
//			fileDto.setFileLinesCount(lineCount);
//			fileDto.setRecordCount(recordCount);
//		}catch(Exception e){
//
//			fileDto.getErrorDto().addError(4, lineCount, lineCount , 1, line, null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//			log.error("Error loading file" + fileName + " into memory. cause : " + e.getMessage() , e);
//		}finally{
//			if (br != null){
//					try {
//						br.close();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						log.error(e.getMessage() , e);
//					}
//			}
//		}
//
//		log.info("Finished Loading " + fileName);
//
//	}
//
//	public void createFileTransaction(String line){
//
//		// here we will start grouping lines into one transaction based on sequence numbers
//		String sequenceNumber = line.substring(3 , 4);  //includes the qualifier
//
//
//		//create tcr records for the file transation
//		if (sequenceNumber.equals(String.valueOf(Constants.TCR0_RECID))){
//	        createTCR0Record(line);
//
//		}else if (sequenceNumber.equals(String.valueOf(Constants.TCR1_RECID))){
//	        createTCR1Record(line);
//
//		}else if (sequenceNumber.equals(String.valueOf(Constants.TCR3_RECID))){
//	        createTCR3Record(line);
//
//		}else if (sequenceNumber.equals(String.valueOf(Constants.TCR5_RECID))){
//	        createTCR5Record(line);
//
//		}else if (sequenceNumber.equals(String.valueOf(Constants.TCR7_RECID))){
//	        createTCR7Record(line);
//
//		}
//
//	}
//	private void createTCR3Record(String line) {
//
//		if (this.fileDto.getFileAxsTrailorRecordDto() != null){
//			fileDto.getErrorDto().addError(9, lineCount,Integer.parseInt(line.substring(0 , 2)) , 0 , null , null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//			return;
//		}
//
//		//check sequencing
//		if (lastTransactionRead.getTcr0TransactionRecordDto() == null){
//			fileDto.getErrorDto().addError(4 , lineCount , Integer.parseInt(line.substring(0 , 2)) , 0 , null , null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//			return;
//		}else if (lastTransactionRead.getTcr1TransactionRecordDto() == null){
//			fileDto.getErrorDto().addError(4 , lineCount , Integer.parseInt(line.substring(0 , 2)) , 0 , null , null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//			return;
//		}else if (lastTransactionRead.getTcr7TransactionRecordDto()!= null){
//			fileDto.getErrorDto().addError(4 , lineCount , Integer.parseInt(line.substring(0 , 2)) , 0 , null , null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//			return;
//		}
//
//		VISATCR3TransactionRecordDTO tcr3 = new VISATCR3TransactionRecordDTO();
//
//
//
//
//		 String fr3FleetTc = line.substring(0,2).trim();
//		 tcr3.setFr3FleetTc(fr3FleetTc);
//		 String fr3FleetTcq  = line.substring(2,4).trim();
//		 tcr3.setFr3FleetTcq(fr3FleetTcq);
//		 String tcrNumber = line.substring(3 , 4).trim();
//		 tcr3.setTcrNumber(tcrNumber);
//		 String fr3FleetComSeqNo  = line.substring(3,6).trim();
//		 tcr3.setFr3FleetComSeqNo(fr3FleetComSeqNo);
//		 String fr3FleetAttId  = line.substring(6,18).trim();
//		 tcr3.setFr3FleetAttId(fr3FleetAttId);
//		 String fr3FleetBusFormatCde  = line.substring(18,20).trim();
//		 tcr3.setFr3FleetBusFormatCde(fr3FleetBusFormatCde);
//		 String timeStamp = line.substring(18,24).trim();
//		 tcr3.setTimeStamp(timeStamp);
//		 String fr3FleetReserved  = line.substring(20,28).trim();
//		 tcr3.setFr3FleetReserved(fr3FleetReserved);
//		 String fr3FleetTypeOfPurchase  = line.substring(28,29).trim();
//		 tcr3.setFr3FleetTypeOfPurchase(fr3FleetTypeOfPurchase);
//		 String fr3FleetFuelType  = line.substring(29,31).trim();
//		 tcr3.setFr3FleetFuelType(fr3FleetFuelType);
//		 String fr3FleetFiller  = line.substring(31,98).trim();
//		 tcr3.setFr3FleetFiller(fr3FleetFiller);
//
//		tcr3.setRecord(line);
//		tcr3.setLineNumber(lineCount);
//		lastTransactionRead.setVisaTCR5Present(true);
//		tcr3.setSubServices(this.fileDto.getFileSubService().trim());
//
//		lastTransactionRead.setNonFinRecCount(lastTransactionRead.getNonFinRecCount() + 1);
//		lastTransactionRead.setTcr3TransactionRecordDto(tcr3);
//
//	}
//
//	public void createAXSHeaderRecord(String line){
//
//		super.createAXSHeaderRecord(line);
//		fileDto.setFileSubService(line.substring(14, 20).trim());
//
//		fileDto.setFileAXSHeaderRecordDto(fileAXSHeaderRecordDto);
//	}
//
//	public void createAXSTrailorRecord(String line){
//
//		//save the last transaction read like we do when we encounter a 00 sequence
//		if (lastTransactionRead != null){
//			this.fileDto.getFileTransactionRecordDtoList().add(lastTransactionRead);
//			addTransactionToBatch(lastTransactionRead);
//
//			lastTransactionRead = new VISAFileTransactionRecordDTO();
//			lastTransactionRead.setRecordOffset(recordOffset++);
//		}
//
//		super.createAXSTrailorRecord(line);
//		this.fileDto.setFileAxsTrailorRecordDto(fileAXSTrailorRecordDto);
//	}
//	public void createEOSRecord(String line){
//
//		//save the last transaction read like we do when we encounter a 00 sequence
//		if (lastTransactionRead != null){
//			this.fileDto.getFileTransactionRecordDtoList().add(lastTransactionRead);
//			addTransactionToBatch(lastTransactionRead);
//
//			lastTransactionRead = null; //because we dont expect any transactions beyond this point, plus the line we are reading is not a txn either
//		}
//		super.createEOSRecord(line);
//		this.fileDto.setFileEOS98RecordDto(fileEOSTrailorRecordDto);
//
//	}
//	public void createHeader90Record(String line){
//
//		super.createHeader90Record(line);
//		this.fileDto.setFileHeader90RecordDto(fileHeader90Dto);
//	}
//
//	public void createTCR0Record(String line){
//
//		//first check that we receive a header before we got the firt transaction
//		if (fileDto.getFileAXSHeaderRecordDto() == null){
//			fileDto.getErrorDto().addError(3 , lineCount , 1 , 6 , null , null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//			return;
//		}
//		if (this.fileDto.getFileAxsTrailorRecordDto() != null){
//			fileDto.getErrorDto().addError(9, lineCount, 1 , 6 , null , null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//			return;
//		}
//
//		//save the last transaction and start a new one
//		if (lastTransactionRead != null){
//			this.fileDto.getFileTransactionRecordDtoList().add(lastTransactionRead);
//			addTransactionToBatch(lastTransactionRead);
//
//			lastTransactionRead = new VISAFileTransactionRecordDTO();
//			lastTransactionRead.setRecordOffset(recordOffset++);
//		}else{
//			lastTransactionRead = new VISAFileTransactionRecordDTO();
//			lastTransactionRead.setRecordOffset(recordOffset++);
//		}
//
//		VISATCR0TransactionRecordDTO tcr0 = new VISATCR0TransactionRecordDTO();
//
//		//set transaction code to the transaction object
//		String transactionCode = line.substring(0 , 2).trim();
//		tcr0.setTransactionCode(transactionCode);
//		try{
//			lastTransactionRead.setTransactionCode(Short.valueOf(transactionCode));
//		}catch(Exception e){log.error(e.getMessage());}
//
//		String tranCodeQualifier = line.substring(2 , 3).trim();
//		tcr0.setTranCodeQualifier(tranCodeQualifier);
//		String tcrNumber = line.substring(3 , 4).trim();
//		tcr0.setTcrNumber(tcrNumber);
//
//		//set account number/account number
//		String accountNumber = line.substring(4 , 20).trim();
//		tcr0.setAccountNumber(accountNumber);
//		lastTransactionRead.setCardNumber(accountNumber);
//
//
//		//set card type, issuer , issuer bin
//				String issuerWorkstationBIN = line.substring(4 , 10).trim();
//				tcr0.setIssuerWorkstationBIN(issuerWorkstationBIN);
//				lastTransactionRead.setIssuerBin(Integer.parseInt(issuerWorkstationBIN));
//				CSFBinsDTO binDto = null;
//				try{
//					//binDto = BsvTableLookup.getInstance().getCsfBins().get(issuerWorkstationBIN);
//					binDto = BsvTableLookup.getInstance().getBINDetailForBin(Integer.valueOf(issuerWorkstationBIN));
//
//					if(binDto!=null){
//						String cardType = binDto.getCardType();
//						lastTransactionRead.setCardType(Integer.parseInt(cardType));
//						lastTransactionRead.setIssuer(binDto.getBankCode());
//					}else{
//						lastTransactionRead.setCardType(-1);
//						lastTransactionRead.setIssuer(-1);
//						log.error("Invalid Issuer Workstation BIN Number: " + issuerWorkstationBIN);
//					}
//				}catch(Exception e){log.error(e.getMessage());}
//
//		String accNoExtension = line.substring(20 , 23).trim();
//		tcr0.setAccNoExtension(accNoExtension);
//		String floorLimitIndicator = line.substring(23 , 24).trim();
//		tcr0.setFloorLimitIndicator(floorLimitIndicator);
//		String exceptionfileInd = line.substring(24 , 25).trim();
//		tcr0.setExceptionfileInd(exceptionfileInd);
//		String pcasIndicator = line.substring(25 , 26).trim();
//		tcr0.setPcasIndicator(pcasIndicator);
//		String acqReferenceNo = line.substring(26 , 49).trim();
//		tcr0.setAcqReferenceNo(acqReferenceNo);
//
//
//		//set acuirer , acquirer bin
//		String acquirerWorkstationBIN = line.substring(27 , 33).trim();
//		tcr0.setAcquirerWorkstationBIN(acquirerWorkstationBIN);
//		lastTransactionRead.setAcquirerBin(Integer.parseInt(acquirerWorkstationBIN));
//		try{
//			binDto = BsvTableLookup.getInstance().getCsfBins().get(acquirerWorkstationBIN);
//
//			if(binDto!=null){
//				lastTransactionRead.setAcquirer(binDto.getBankCode());
//			}else{
//				lastTransactionRead.setAcquirer(-1);
//				log.error("Invalid Aquirer Workstation BIN Number: " + acquirerWorkstationBIN);
//			}
//		}catch(Exception e){log.error(e.getMessage());}
//
//		log.info("Issuer:" + lastTransactionRead.getIssuer() + " Acquirer:" + lastTransactionRead.getAcquirer() + " transaction code:" +
//					lastTransactionRead.getTransactionCode() + " Card Type"  + lastTransactionRead.getCardType()  );
//		String acqBusinessID = line.substring(49 , 57).trim();
//		tcr0.setAcqBusinessID(acqBusinessID);
//		String purchaseDate = line.substring(57 , 61).trim();
//		tcr0.setPurchaseDate(purchaseDate);
//		String destinationAmount = line.substring(61 , 73).trim();
//		tcr0.setDestinationAmount(destinationAmount);
//		String destCurrencyCode = line.substring(73 , 76).trim();
//		tcr0.setDestCurrencyCode(destCurrencyCode);
//
//		//set transaction amount
//		String sourceAmount = line.substring(76 , 88).trim();
//		tcr0.setSourceAmount(sourceAmount);
//		try{
//			lastTransactionRead.setTransactionAmount(Long.parseLong(sourceAmount));
//		}catch(Exception e){log.error(e.getMessage());}
//
//		String sourceCurrencyCode = line.substring(88 , 91).trim();
//		tcr0.setSourceCurrencyCode(sourceCurrencyCode);
//		String merchantName = line.substring(91 , 116).trim();
//		tcr0.setMerchantName(merchantName);
//		String merchantCity = line.substring(116 , 129).trim();
//		tcr0.setMerchantCity(merchantCity);
//		String merchantCountry = line.substring(129 , 132).trim();
//		tcr0.setMerchantCountry(merchantCountry);
//
//		//set merchant code. mandatory for amex
//		String merchantCatCode = line.substring(132 , 136).trim();
//		tcr0.setMerchantCatCode(merchantCatCode);
//		try{
//			lastTransactionRead.setMerchantCatCode(Integer.parseInt(merchantCatCode));
//		}catch(Exception e){log.error(e.getMessage());}
//
//		String merchantZIPCode = line.substring(136 , 141).trim();
//		tcr0.setMerchantZIPCode(merchantZIPCode);
//		String merchantStateCode = line.substring(141 , 144).trim();
//		tcr0.setMerchantStateCode(merchantStateCode);
//		String requestPaymentInd = line.substring(144 , 145).trim();
//		tcr0.setRequestPaymentInd(requestPaymentInd);
//
//		String filler = line.substring(145 , 146);
//
//		String usageCode = line.substring(146 , 147).trim();
//		tcr0.setUsageCode(usageCode);
//
//		//set message reason code
//		String reasonCode = line.substring(147 , 149).trim();
//		tcr0.setReasonCode(reasonCode);
//		try{
//			lastTransactionRead.setMessageReasonCode(Integer.parseInt(reasonCode));
//		}catch(Exception e){log.error(e.getMessage());}
//
//		String settlementFlag = line.substring(149 , 150).trim();
//		tcr0.setSettlementFlag(settlementFlag);
//		String authorisationIndicator = line.substring(150 , 151).trim();
//		tcr0.setAuthorisationIndicator(authorisationIndicator);
//		String authorisationCode = line.substring(151 , 157).trim();
//		tcr0.setAuthorisationCode(authorisationCode);
//		String termCapability = line.substring(157,158).trim();    // SARB
//		tcr0.setTerminalCapability(termCapability);
//		String internationalFeeInd = line.substring(158 , 159).trim();
//		tcr0.setInternationalFeeInd(internationalFeeInd);
//		String cardholderID = line.substring(155,156).trim();;   // SARB
//		tcr0.setCardholderIDMethod(cardholderID);
//		String collectionOnlyFlag = line.substring(160 , 161).trim();
//		tcr0.setCollectionOnlyFlag(collectionOnlyFlag);
//
//		if (line.length() >= 163){
//			String posEntryMode = line.substring(161,162).trim(); // SARB
//			tcr0.setPosEntryMode(posEntryMode);
//			String centralProcDate = line.substring(163 , 167).trim();
//			tcr0.setCentralProcDate(centralProcDate);
//			String reimbursementAttrbte = line.substring(167 , 168).trim();
//			tcr0.setReimbursementAttrbte(reimbursementAttrbte);
//		}
//		tcr0.setRecord(line);
//		tcr0.setLineNumber(lineCount);
//		tcr0.setSubServices(this.fileDto.getFileSubService().trim());
//		lastTransactionRead.setTcr0TransactionRecordDto(tcr0);
//
//	}
//	public void createTCR1Record(String line){
//
//		if (this.fileDto.getFileAxsTrailorRecordDto() != null){
//			fileDto.getErrorDto().addError(9, lineCount,Integer.parseInt(line.substring(0 , 2)) , 0 , null , null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//			return;
//		}
//
//		//check sequencing
//		if (lastTransactionRead.getTcr0TransactionRecordDto() == null){
//			fileDto.getErrorDto().addError(4 , lineCount , Integer.parseInt(line.substring(0 , 2)) , 0 , null , null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//			return;
//		}else if (lastTransactionRead.getTcr5TransactionRecordDto()!= null || lastTransactionRead.getTcr7TransactionRecordDto()!= null){
//			fileDto.getErrorDto().addError(4 , lineCount , Integer.parseInt(line.substring(0 , 2)) , 0 , null , null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//			return;
//		}
//
//		VISATCR1TransactionRecordDTO tcr1 = new VISATCR1TransactionRecordDTO();
//
//		String transactionCode = line.substring(0 , 2).trim();
//		tcr1.setTransactionCode(transactionCode);
//		String tranCodeQualifier = line.substring(2 , 3).trim();
//		tcr1.setTranCodeQualifier(tranCodeQualifier);
//		String tcrNumber = line.substring(3 , 4).trim();
//		tcr1.setTcrNumber(tcrNumber);
//
//
////		//set card type, issuer , issuer bin
////		String issuerWorkstationBIN = line.substring(4 , 10).trim();
////		tcr1.setIssuerWorkstationBIN(issuerWorkstationBIN);
////		lastTransactionRead.setIssuerBin(Integer.parseInt(issuerWorkstationBIN));
////		CSFBinsDTO binDto = null;
////		try{
////			binDto = BsvTableLookup.getInstance().getCsfBins().get(issuerWorkstationBIN);
////
////			if(binDto!=null){
////				String cardType = binDto.getCardType();
////				lastTransactionRead.setCardType(Integer.parseInt(cardType));
////				lastTransactionRead.setIssuer(binDto.getBankCode());
////			}else{
////				lastTransactionRead.setCardType(-1);
////				lastTransactionRead.setIssuer(-1);
////				log.error("Invalid Issuer Workstation BIN Number: " + issuerWorkstationBIN);
////			}
////		}catch(Exception e){log.error(e.getMessage());}
////
////
////		//set acuirer , acquirer bin
////		String acquirerWorkstationBIN = line.substring(10 , 16).trim();
////		tcr1.setAcquirerWorkstationBIN(acquirerWorkstationBIN);
////		lastTransactionRead.setAcquirerBin(Integer.parseInt(acquirerWorkstationBIN));
////		try{
////			binDto = BsvTableLookup.getInstance().getCsfBins().get(acquirerWorkstationBIN);
////
////			if(binDto!=null){
////				lastTransactionRead.setAcquirer(binDto.getBankCode());
////			}else{
////				lastTransactionRead.setAcquirer(-1);
////				log.error("Invalid Aquirer Workstation BIN Number: " + issuerWorkstationBIN);
////			}
////		}catch(Exception e){log.error(e.getMessage());}
////
//		String chargebackReferenceNumber = line.substring(16 , 22).trim();
//		tcr1.setChargebackReferenceNumber(chargebackReferenceNumber);
//		String documentationIndicator = line.substring(22 , 23).trim();
//		tcr1.setDocumentationIndicator(documentationIndicator);
//		String memberMessageText = line.substring(23 , 73).trim();
//		tcr1.setMemberMessageText(memberMessageText);
//		String specialConditionIndicators = line.substring(73 , 75).trim();
//		tcr1.setSpecialConditionIndicators(specialConditionIndicators);
//		String cardChip = line.substring(75 , 78).trim();
//		 switch (cardChip) {
//		case "2":
//		case "6":
//		case "SA1":
//			tcr1.setChipCard("1");
//			break;
//
//		default:
//			tcr1.setChipCard("0");
//			break;
//		}
//		String issuerCharge = line.substring(78 , 79).trim();
//		tcr1.setIssuerCharge(issuerCharge);
//		String reserved = line.substring(79 , 80).trim();
//		tcr1.setReserved(reserved);
//		String cardAcceptorID = line.substring(80 , 95).trim();
//		tcr1.setCardAcceptorID(cardAcceptorID);
//		String terminalID = line.substring(95 , 103).trim();
//		tcr1.setTerminalID(terminalID);
//		String nationalReimbursementFee = line.substring(103 , 115).trim();
//		tcr1.setNationalReimbursementFee(nationalReimbursementFee);
//		String mail_TelephoneElectronicCommerceIndicator = line.substring(115 , 116).trim();
//		tcr1.setMail_TelephoneElectronicCommerceIndicator(mail_TelephoneElectronicCommerceIndicator);
//		String specialChargebackIndicator = line.substring(116 , 117).trim();  // SARB
//		tcr1.setSpecialChargebackIndicator(specialChargebackIndicator);
//		String eComInd = line.substring(115,116).trim();
//		tcr1.setECommInd(eComInd);
//		String interfaceTraceNumber = line.substring(117 , 123).trim();
//		tcr1.setInterfaceTraceNumber(interfaceTraceNumber);
//		String unattendedAcceptanceTerminalIndicator = line.substring(123 , 124).trim();
//		tcr1.setUnattendedAcceptanceTerminalIndicator(unattendedAcceptanceTerminalIndicator);
//		String prepaidCardIndicator = line.substring(124 , 125).trim();
//		tcr1.setPrepaidCardIndicator(prepaidCardIndicator);
//		String serviceDevelopmentField = line.substring(125 , 126).trim();
//		tcr1.setServiceDevelopmentField(serviceDevelopmentField);
//		String avsResponseCode = line.substring(126 , 127).trim();
//		tcr1.setAvsResponseCode(avsResponseCode);
//		String authorizationSourceCode = line.substring(127 , 128).trim();
//		tcr1.setAuthorizationSourceCode(authorizationSourceCode);
//		String purchaseIdentifierFormat = line.substring(128 , 129).trim();
//		tcr1.setPurchaseIdentifierFormat(purchaseIdentifierFormat);
//		String atmAccountSelection = line.substring(129 , 130).trim();
//		tcr1.setAtmAccountSelection(atmAccountSelection);
//		String installmentPaymentCount = line.substring(130 , 132).trim();
//		tcr1.setInstallmentPaymentCount(installmentPaymentCount);
//		String purchaseIdentifier = line.substring(132 , 157).trim();
//		tcr1.setPurchaseIdentifier(purchaseIdentifier);
//
//		if (line.length() >= 166){
//			String cashback = line.substring(157 , 166).trim();
//			tcr1.setCashback(cashback);
//
//			if (!cashback.equals("") && (Utils.IsNumeric(cashback)  && Integer.parseInt(cashback) > 0) ){
//				lastTransactionRead.setTransactionACashBack(true);
//				try{
//					lastTransactionRead.setCashbackAmount(Long.parseLong(cashback));
//				}catch(Exception e){log.error(e.getMessage());}
//			}
//
//			String chipConditionCode = line.substring(166 , 167).trim();
//			tcr1.setChipConditionCode(chipConditionCode);
//			String posEnvironment = line.substring(167 , 168).trim();
//			tcr1.setPosEnvironment(posEnvironment);
//		}
//		//set the transation target of the file
//		if (fileDto.getFileOriginator() == lastTransactionRead.getAcquirer()){
//			lastTransactionRead.setTransactionTarget(lastTransactionRead.getIssuer());
//		}else
//			lastTransactionRead.setTransactionTarget(lastTransactionRead.getAcquirer());
//
//		tcr1.setRecord(line);
//		tcr1.setLineNumber(lineCount);
//		tcr1.setSubServices(this.fileDto.getFileSubService().trim());
//
//		lastTransactionRead.setNonFinRecCount(lastTransactionRead.getNonFinRecCount() + 1);
//		lastTransactionRead.setTcr1TransactionRecordDto(tcr1);
//	}
//	public void createTCR5Record(String line){
//
//		if (this.fileDto.getFileAxsTrailorRecordDto() != null){
//			fileDto.getErrorDto().addError(9, lineCount,Integer.parseInt(line.substring(0 , 2)) , 0 , null , null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//			return;
//		}
//
//		//check sequencing
//		if (lastTransactionRead.getTcr0TransactionRecordDto() == null){
//			fileDto.getErrorDto().addError(4 , lineCount , Integer.parseInt(line.substring(0 , 2)) , 0 , null , null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//			return;
//		}else if (lastTransactionRead.getTcr1TransactionRecordDto() == null){
//			fileDto.getErrorDto().addError(4 , lineCount , Integer.parseInt(line.substring(0 , 2)) , 0 , null , null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//			return;
//		}else if (lastTransactionRead.getTcr7TransactionRecordDto()!= null){
//			fileDto.getErrorDto().addError(4 , lineCount , Integer.parseInt(line.substring(0 , 2)) , 0 , null , null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//			return;
//		}
//
//		VISATCR5TransactionRecordDTO tcr5 = new VISATCR5TransactionRecordDTO();
//
//		String transactionCode = line.substring(0 , 2).trim();
//		tcr5.setTransactionCode(transactionCode);
//		String tranCodeQualifier = line.substring(2 , 3).trim();
//		tcr5.setTranCodeQualifier(tranCodeQualifier);
//		String tcrNumber = line.substring(3 , 4).trim();
//		tcr5.setTcrNumber(tcrNumber);
//		String transactionIdentifier = line.substring(4 , 19).trim();
//		tcr5.setTransactionIdentifier(transactionIdentifier);
//		String authorizedAmount = line.substring(19 , 31).trim();
//		tcr5.setAuthorizedAmount(authorizedAmount);
//		String authorizationCurrencyCode = line.substring(31 , 34).trim();
//		tcr5.setAuthorizationCurrencyCode(authorizationCurrencyCode);
//		String authorizationResponseCode = line.substring(34 , 36).trim();
//		tcr5.setAuthorizationResponseCode(authorizationResponseCode);
//		String validationCode = line.substring(36 , 40).trim();
//		tcr5.setValidationCode(validationCode);
//		String excludedTransactionIdentifierReason = line.substring(40 , 41).trim();
//		tcr5.setExcludedTransactionIdentifierReason(excludedTransactionIdentifierReason);
//		String crsProcessingCode = line.substring(41 , 42).trim();
//		tcr5.setCrsProcessingCode(crsProcessingCode);
//		String chargebackRightsIndicator = line.substring(42 , 44).trim();
//		tcr5.setChargebackRightsIndicator(chargebackRightsIndicator);
//		String multipleClearingSequenceNumber = line.substring(44 , 46).trim();
//		tcr5.setMultipleClearingSequenceNumber(multipleClearingSequenceNumber);
//		String multipleClearingSequenceCount = line.substring(46 , 48).trim();
//		tcr5.setMultipleClearingSequenceCount(multipleClearingSequenceCount);
//		String marketSpecificAuthorizationDataIndicator = line.substring(48 , 49).trim();
//		tcr5.setMarketSpecificAuthorizationDataIndicator(marketSpecificAuthorizationDataIndicator);
//		String totalAuthorizedAmount = line.substring(49 , 61).trim();
//		tcr5.setTotalAuthorizedAmount(totalAuthorizedAmount);
//		String informationIndicator = line.substring(61 , 62).trim();
//		tcr5.setInformationIndicator(informationIndicator);
//		String merchantTelephoneNumber = line.substring(62 , 76).trim();
//		tcr5.setMerchantTelephoneNumber(merchantTelephoneNumber);
//		String additionalDataIndicator = line.substring(76 , 77).trim();
//		tcr5.setAdditionalDataIndicator(additionalDataIndicator);
//		String merchantVolumeIndicator = line.substring(77 , 79).trim();
//		tcr5.setMerchantVolumeIndicator(merchantVolumeIndicator);
//		String electronicCommerceGoodsIndicator = line.substring(79 , 81).trim();
//		tcr5.setElectronicCommerceGoodsIndicator(electronicCommerceGoodsIndicator);
//		String merchantVerificationValue = line.substring(81 , 91).trim();
//		tcr5.setMerchantVerificationValue(merchantVerificationValue);
//		String interchangeFeeAmount = line.substring(91 , 106).trim();
//		tcr5.setInterchangeFeeAmount(interchangeFeeAmount);
//		String interchangeFeeSign = line.substring(106 , 107).trim();
//		tcr5.setInterchangeFeeSign(interchangeFeeSign);
//
//		String sourceCurrencyToBaseCurrencyExchangeRate = line.substring(107 , 115).trim();
//		try{
//			Integer.parseInt(sourceCurrencyToBaseCurrencyExchangeRate);
//			tcr5.setSourceCurrencyToBaseCurrencyExchangeRate(sourceCurrencyToBaseCurrencyExchangeRate);
//		}catch(Exception e){
//			tcr5.setSourceCurrencyToBaseCurrencyExchangeRate("0");
//		}
//		String baseCurrencyToDestinationCurrencyExchangeRate = line.substring(115 , 123).trim();
//		tcr5.setBaseCurrencyToDestinationCurrencyExchangeRate(baseCurrencyToDestinationCurrencyExchangeRate);
//		String optionalIssuerISAAmount = line.substring(123 , 135).trim();
//		tcr5.setOptionalIssuerISAAmount(optionalIssuerISAAmount);
//		String reserved1 = line.substring(135 , 167).trim();
//		tcr5.setReserved1(reserved1);
//		String cvv2ResultCode = line.substring(167 , 168).trim();
//		tcr5.setCvv2ResultCode(cvv2ResultCode);
//
//		tcr5.setRecord(line);
//		tcr5.setLineNumber(lineCount);
//		lastTransactionRead.setVisaTCR5Present(true);
//
//		lastTransactionRead.setNonFinRecCount(lastTransactionRead.getNonFinRecCount() + 1);
//		lastTransactionRead.setTcr5TransactionRecordDto(tcr5);
//
//	}
//	public void createTCR7Record(String line){
//
//		if (this.fileDto.getFileAxsTrailorRecordDto() != null){
//			fileDto.getErrorDto().addError(9, lineCount,Integer.parseInt(line.substring(0 , 2)) , 0 , null , null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//			return;
//		}
//
//		//check sequencing
//		if (lastTransactionRead.getTcr0TransactionRecordDto() == null){
//			fileDto.getErrorDto().addError(4 , lineCount , Integer.parseInt(line.substring(0 , 2)) , 0 , null , null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//		}else if (lastTransactionRead.getTcr1TransactionRecordDto() == null){
//			fileDto.getErrorDto().addError(4 , lineCount , Integer.parseInt(line.substring(0 , 2)) , 0 , null , null);
//			fileDto.setFileStatus(Status.R.getSymbol());
//		}
//
//		VISATCR7TransactionRecordDTO tcr7 = new VISATCR7TransactionRecordDTO();
//
//		String transactionCode = line.substring(0 , 2).trim();
//		tcr7.setTransactionCode(transactionCode);
//		String tranCodeQualifier = line.substring(2 , 3).trim();
//		tcr7.setTranCodeQualifier(tranCodeQualifier);
//		String tcrNumber = line.substring(3 , 4).trim();
//		tcr7.setTcrNumber(tcrNumber);
//		String transactionType = line.substring(4 , 6).trim();
//		tcr7.setTransactionType(transactionType);
//		String cardSequenceNumber = line.substring(6 , 9).trim();
//		tcr7.setCardSequenceNumber(cardSequenceNumber);
//		String terminalTransactionDate = line.substring(9 , 15).trim();
//		tcr7.setTerminalTransactionDate(terminalTransactionDate);
//		String terminalCapabilityProfile = line.substring(15 , 21).trim();
//		tcr7.setTerminalCapabilityProfile(terminalCapabilityProfile);
//		String terminalCountryCode = line.substring(21 , 24).trim();
//		tcr7.setTerminalCountryCode(terminalCountryCode);
//		String terminalSerialNumber = line.substring(24 , 32).trim();
//		tcr7.setTerminalSerialNumber(terminalSerialNumber);
//		String unpredictableNumber = line.substring(32 , 40).trim();
//		tcr7.setUnpredictableNumber(unpredictableNumber);
//		String applicationTransactionCounter = line.substring(40 , 44).trim();
//		tcr7.setApplicationTransactionCounter(applicationTransactionCounter);
//		String applicationInterchangeProfile = line.substring(44 , 48).trim();
//		tcr7.setApplicationInterchangeProfile(applicationInterchangeProfile);
//		String cryptogram = line.substring(48 , 64).trim();
//		tcr7.setCryptogram(cryptogram);
//
//		String issuerApplicationDataByte2 = line.substring(64 , 66).trim();
//		tcr7.setIssuerApplicationDataByte2(issuerApplicationDataByte2);
//		String issuerApplicationDataByte3 = line.substring(66 , 68).trim();
//		tcr7.setIssuerApplicationDataByte3(issuerApplicationDataByte3);
//		String terminalVerificationResults = line.substring(68 , 78).trim();
//		tcr7.setTerminalVerificationResults(terminalVerificationResults);
//		String issuerApplicationDataByte4_7 = line.substring(78 , 86).trim();
//		tcr7.setIssuerApplicationDataByte4_7(issuerApplicationDataByte4_7);
//		String cryptogramAmount = line.substring(86 , 98).trim();
//		tcr7.setCryptogramAmount(cryptogramAmount);
//		String issuerApplicationDataByte8 = line.substring(98 , 100).trim();
//		tcr7.setIssuerApplicationDataByte8(issuerApplicationDataByte8);
//		String issuerApplicationDataByte9_16 = line.substring(100 , 116).trim();
//		tcr7.setIssuerApplicationDataByte9_16(issuerApplicationDataByte9_16);
//
//		String issuerApplicationDataByte1 = line.substring(116 , 118).trim();
//		tcr7.setIssuerApplicationDataByte1(issuerApplicationDataByte1);
//		String issuerApplicationDataByte17 = line.substring(118 , 120).trim();
//		tcr7.setIssuerApplicationDataByte17(issuerApplicationDataByte17);
//		String issuerApplicationDataByte18_32 = line.substring(120 , 150).trim();
//		tcr7.setIssuerApplicationDataByte18_32(issuerApplicationDataByte18_32);
//
//		String reserved = line.substring(150 , 158);
//
//		String issuerScript1Results = line.substring(158 , 168).trim();
//		tcr7.setIssuerScript1Results(issuerScript1Results);
//
//		tcr7.setRecord(line);
//		tcr7.setLineNumber(lineCount);
//
//		lastTransactionRead.setNonFinRecCount(lastTransactionRead.getNonFinRecCount() + 1);
//		lastTransactionRead.setTcr7TransactionRecordDto(tcr7);
//	}
//	public void createEOB91_92Record(String line){
//
//		// you cant have a 91/92 record before a 01 record
//		if (this.fileDto.getFileAXSHeaderRecordDto()== null){
//			fileDto.getErrorDto().addError(3, lineCount, Integer.parseInt(line.substring(0,2)), 1, line.substring(0,2), "01");
//			fileDto.setFileStatus(Status.R.getSymbol());
//		}
//
//		if (this.fileDto.getFileAxsTrailorRecordDto() != null){
//			fileDto.getErrorDto().addError(9, lineCount, Integer.parseInt(line.substring(0,2)), 1, line.substring(0,2), "01");
//			fileDto.setFileStatus(Status.R.getSymbol());
//		}
//
//		//save the last transaction read like we do when we encounter a 00 sequence
//		if (lastTransactionRead != null){
//			this.fileDto.getFileTransactionRecordDtoList().add(lastTransactionRead);
//			addTransactionToBatch(lastTransactionRead);
//
//			lastTransactionRead = null; //because the line we are reading is not a transaction
//		}
//
//		FileTrailer91_92RecordDTO trailor91_92 = new FileTrailer91_92RecordDTO();
//		trailor91_92.setFileTransactionRecordDtoList(batchTransactionRecordDtos);
//		trailor91_92.setNegativeCardRecordDtoList(batchNegativeCardRecordDtos);
//
//		String transactionCode = line.substring(0 , 2).trim();
//		trailor91_92.setTransactionCode(transactionCode);
//		String tranCodeQualifier = line.substring(2 , 3).trim();
//		trailor91_92.setTranCodeQualifier(tranCodeQualifier);
//		String tcrNumber = line.substring(3 , 4).trim();
//		trailor91_92.setTcrNumber(tcrNumber);
//		String bin = line.substring(4 , 10).trim();
//		trailor91_92.setBin(bin);
//		String processingDate = line.substring(10 , 15).trim();
//		trailor91_92.setProcessingDate(processingDate);
//		String destinationAmount = line.substring(15 , 30).trim();
//		trailor91_92.setDestinationAmount(destinationAmount);
//		String noOfMoneyTransfers = line.substring(30, 42).trim();
//		trailor91_92.setNoOfMoneyTransfers(noOfMoneyTransfers);
//		String batchNumber = line.substring(42 , 48).trim();
//		trailor91_92.setBatchNumber(batchNumber);
//		String noOfTCRs = line.substring(48 , 60).trim();
//		trailor91_92.setNoOfTCRs(noOfTCRs);
//
//		String reserved1 = line.substring(60 , 66);
//
//		String centreBatchIndicator = line.substring(66 , 74).trim();
//		trailor91_92.setCentreBatchIndicator(centreBatchIndicator);
//
//		String noOfTransactions = line.substring(74 , 85).trim();
//		trailor91_92.setNoOfTransactions(noOfTransactions);
//
//		String reserved2 = line.substring(85 , 103);
//
//		String sourceAmount = line.substring(103 , 116).trim();
//		trailor91_92.setSourceAmount(sourceAmount);
//
//		trailor91_92.setRecord(line);
//		trailor91_92.setLineNumber(lineCount);
//		trailor91_92.setFileTransactionRecordDtoList(fileDto.getFileTransactionRecordDtoList());
//
//
//		this.fileDto.getFileCtrlTrailorDtoList().add(trailor91_92);
//
//		resetTransactionBatch();
//		resetNegativeCardBatch();
//	}
//
//	public void createNegativeRecord(String line){
//
//		super.createNegativeRecord(line);
//
//		this.fileDto.getNegativeCardRecordDToList().add(negCardRecordDto);
//		addNegativeCardRecordToBatch(negCardRecordDto);
//	}
//
//	private void addTransactionToBatch(VISAFileTransactionRecordDTO lastTransactionRead){
//		batchTransactionRecordDtos.add(lastTransactionRead);
//	}
//
//	private void addNegativeCardRecordToBatch(NegativeCardRecordDTO negativeRec){
//		batchNegativeCardRecordDtos.add(negativeRec);
//	}
//
//	private void resetTransactionBatch(){
//		batchTransactionRecordDtos.clear();
//	}
//
//	private void resetNegativeCardBatch(){
//		batchNegativeCardRecordDtos.clear();
//	}
//
//	@Override
//	public void setConnection(Connection connection) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//
//
//
//
//}
