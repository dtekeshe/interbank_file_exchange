//package com.bsva.dmcs.fileLoad.visa;
//
//import java.math.BigDecimal;
//
//import javax.sql.DataSource;
//
//import org.apache.log4j.Logger;
//
//
//import com.bsva.dcms.commons.dao.CSOPaymentInstructionsVisaDAO;
//import com.bsva.dcms.commons.dao.CsoFleetBillingDAO;
//import com.bsva.dcms.commons.dao.CsoTransactionsDAO;
//import com.bsva.dcms.commons.dto.CSOPaymentInstructionsVisaDTO;
//import com.bsva.dcms.commons.dto.CSOTransactionDTO;
//import com.bsva.dcms.commons.dto.CsoFleetBillingDTO;
//import com.bsva.dcms.commons.dto.file.FileDTO;
//import com.bsva.dcms.commons.dto.file.FileTransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISAFileDTO;
//import com.bsva.dcms.commons.dto.file.VISAFileTransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISATCR0TransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISATCR1TransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISATCR3TransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISATCR5TransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.VISATCR7TransactionRecordDTO;
//import com.bsva.dcms.commons.exceptions.DAOException;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dcms.commons.util.DateUtil;
//import com.bsva.dcms.commons.util.Utils;
//import com.bsva.dmcs.fileLoad.AbstractFileSaver;
//import com.bsva.dmcs.fileLoad.exceptions.FileLoadException;
//import com.bsva.dmcs.fileLoad.masterCard.MasterCardFileSaver;
//import com.bsva.dmcs.reports.CSR024;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.logging.Level;
//
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.TransformerConfigurationException;
//import javax.xml.transform.TransformerFactoryConfigurationError;
//
//public class VisaFileSaver extends AbstractFileSaver{
//
//	private VISAFileDTO fileDto;
//	private Logger log = Logger.getLogger(VisaFileSaver.class);
//	private int  segNumber = 0;
//        private CsoFleetBillingDAO csoFleetBillingDao = new CsoFleetBillingDAO();
//
//
//	public void save(FileDTO fileDto) throws FileLoadException{
//
//		if (fileDto.getFileTransactionRecordDtoList().size() <= 0){
//			log.debug("File " + fileDto.getFileName() + " has not transactions to be saved. Exiting...");
//			return;
//		}
//
//		log.info("Saving file " + fileDto.getFileName() + " to the database");
//
//		this.fileDto = (VISAFileDTO)fileDto;
//		//if file was rejected, then dont continue
////		if (this.fileDto.getFileStatus().equals(Status.R.getSymbol())){
////			log.debug("File " + fileDto.getFileName() + "was rejected, so we wont be saving to the database");
////			return;
////		}
//
//		//save file cso_input_file_controls
//		long fileSequence = loadInputFileControls(fileDto);
//
//                 // generate csr024 report
//
//
//			//save each transaction of the file into CSO_TRANSACTION
//			for(FileTransactionRecordDTO fileTransactionDto : fileDto.getFileTransactionRecordDtoList()){
//				VISAFileTransactionRecordDTO visaFileTransactionRecordDTO = (VISAFileTransactionRecordDTO)fileTransactionDto;
//				loadFileTransaction(visaFileTransactionRecordDTO , fileSequence);
//			}
//
//			Utils.logSpolog("File " + fileDto.getFileName() + " Saved to the database");
//
//			log.info("Finished Saving file " + fileDto.getFileName() + " to the database");
//
//	}
//
//	public void loadFileTransaction(VISAFileTransactionRecordDTO fileTransactionDto , long fileSequence) throws FileLoadException{
//
//		try{
//			CSOTransactionDTO transactionDto = new CSOTransactionDTO();
//			CsoTransactionsDAO transactionDao = new CsoTransactionsDAO();
//
//			transactionDto.setFileSystemSeqNumber(fileSequence);
//			transactionDto.setRecordNumber(fileTransactionDto.getRecordOffset());
//			transactionDto.setTransactionCode(fileTransactionDto.getTransactionCode());
//			transactionDto.setCardType(fileTransactionDto.getCardType());
//			transactionDto.setTransactionAmount(fileTransactionDto.getTransactionAmount());
//			transactionDto.setIssuerMember(fileTransactionDto.getIssuer());
//			transactionDto.setAcquirerMember(fileTransactionDto.getAcquirer());
//			transactionDto.setIssuerBin(fileTransactionDto.getIssuerBin());
//			transactionDto.setAcquirerBin(fileTransactionDto.getAcquirerBin());
//			transactionDto.setProcessStatus(fileTransactionDto.isCurrentRecordValid() ? "A" : "R");
//			transactionDto.setCashbackPresent(fileTransactionDto.isTransactionACashBack()? "Y" : "N");
//			transactionDto.setCashbackAmount(new BigDecimal(fileTransactionDto.getCashbackAmount()));
//			transactionDto.setRecordStartByte(fileTransactionDto.getRecordStartByte());
//			transactionDto.setRecordEndByte(fileTransactionDto.getRecordEndByte());
//
//			if (fileTransactionDto.isVisaTCR5Present()) {
//				transactionDto.setFileRecordCnt(fileTransactionDto.getNonFinRecCount() + 1);
//	        } else {
//	        	transactionDto.setFileRecordCnt(fileTransactionDto.getNonFinRecCount() + 2);
//	        }
//
//			transactionDto.setMessageTypeInd(fileTransactionDto.getMessageTypeInd()); //MTI
//			transactionDto.setMerchantCatCode(fileTransactionDto.getMerchantCatCode());
//			transactionDto.setIntchgRateDsgn(0);
//			transactionDto.setMessageReasonCode(fileTransactionDto.getMessageReasonCode());
//			transactionDto.setOutputFilename(fileTransactionDto.getOutputFileName());
//			transactionDto.setAccountNumber(fileTransactionDto.getCardNumber());
//
//			transactionDto.setFleetCountTran("N"); //default
//			transactionDto.setExtractInd("N");
//			transactionDao.create(transactionDto);
//
//			int seqNumber = (int) transactionDto.getSystemSeqNumber();
//			int fileSysSeqNum = (int) transactionDto.getFileSystemSeqNumber();
//			/*
//			CsoInputFileControlsDTO inputDTO = new CsoInputFileControlsDTO();
//			inputDTO.setSystemSeqNumber(fileSysSeqNum);
//			CsoInputFileControlsDAO inputDao = new CsoInputFileControlsDAO();
//			CsoInputFileControlsDTO inputDataDTO = inputDao.retrieve(inputDTO);*/
//			saveTransactionCsoFleetBilling(transactionDto, fileTransactionDto,seqNumber,fileSysSeqNum);
//			saveTransactionPaymentInstructions(transactionDto, fileTransactionDto,seqNumber,fileSysSeqNum);
//
//		}catch(Exception e){
//			throw new FileLoadException(e.getMessage());
//		}
//	}
//
//	public void saveTransactionCsoFleetBilling(CSOTransactionDTO transactionDto , VISAFileTransactionRecordDTO fileTransactionDto, int sysSeqNumber,int fileSysSeqNum) throws FileLoadException{
//		try{
//			VISATCR3TransactionRecordDTO tc03Record = fileTransactionDto.getTcr3TransactionRecordDto();
//			if (tc03Record != null){
//				CsoFleetBillingDTO csoFleetBillingDTO = new CsoFleetBillingDTO();
//
//				csoFleetBillingDTO.setAccNo(transactionDto.getAccountNumber());
//				csoFleetBillingDTO.setAcq((short)transactionDto.getAcquirerMember());
//				csoFleetBillingDTO.setAcqRefNo(fileTransactionDto.getAcquirerBin());
//				csoFleetBillingDTO.setAmount(new BigDecimal(transactionDto.getTransactionAmount()));
//				csoFleetBillingDTO.setCardType(transactionDto.getCardType());
//				csoFleetBillingDTO.setFileRefNumber(transactionDto.getFileSystemSeqNumber());
//				csoFleetBillingDTO.setIss((short)transactionDto.getIssuerMember());
//				csoFleetBillingDTO.setProduct(this.fileDto.getFileService());
//				csoFleetBillingDTO.setSubProduct(this.fileDto.getFileSubService());
//				csoFleetBillingDTO.setService(this.fileDto.getFileService());
//				csoFleetBillingDTO.setSubService(this.fileDto.getFileSubService());
//				csoFleetBillingDTO.setTxCde((short)transactionDto.getTransactionCode());
//				csoFleetBillingDTO.setTxCnt((short)transactionDto.getFileRecordCnt());
//				csoFleetBillingDTO.setTranSystemSeqNumber(sysSeqNumber);
//				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//				String processDate = BsvTableLookup.getInstance().getProcessDate();
//				Date date = formatter.parse(processDate);
//				Date dateTime = getTxnDate(fileTransactionDto.getTcr0TransactionRecordDto().getPurchaseDate(), tc03Record.getTimeStamp(),date) ;
//
//				long longStr = dateTime.getTime();
//				csoFleetBillingDTO.setTxDateTime(longStr);//fileTransactionDto.getTcr0TransactionRecordDto().getPurchaseDate()+tc03Record.getTimeStamp()));
//				csoFleetBillingDao.create(csoFleetBillingDTO);
//			}
//
//		}catch(Exception e){
//			throw new FileLoadException(e.getMessage());
//		}
//	}
//
//	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	public static Date getTxnDate(String txnMonthDay, String txnTime, Date processDate) {
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(processDate);
//		Integer processYear = cal.get(Calendar.YEAR);
//
//		try {
//             DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
//			//String result = dateFormat.format(cal.getTime());
//			String processDateFormat = processYear + txnMonthDay+" " + txnTime;
//			Date txnDate = dateFormat.parse(processDateFormat);
//			// txn date can not be in the future
//			return txnDate;//txnDate.getTime() < processDate.getTime() ? txnDate : DATE_FORMAT.parse( (--processYear) + txnMonthDay + " " + txnTime);
//		} catch (ParseException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//
//	public void saveTransactionPaymentInstructions(CSOTransactionDTO transactionDto , VISAFileTransactionRecordDTO fileTransactionDto,int sysSeqNumber,int fileSysSeqNum) throws FileLoadException{
//
//		try{
//			CSOPaymentInstructionsVisaDAO paymentInstructionDao = new CSOPaymentInstructionsVisaDAO();
//
//			VISATCR0TransactionRecordDTO tc00Record = fileTransactionDto.getTcr0TransactionRecordDto();
//                        VISATCR1TransactionRecordDTO tc01Record = fileTransactionDto.getTcr1TransactionRecordDto();
//
//			if (tc00Record != null){
//				CSOPaymentInstructionsVisaDTO paymentInstructionDto = new CSOPaymentInstructionsVisaDTO();
//				paymentInstructionDto.setFileRefNumber(String.valueOf(transactionDto.getFileSystemSeqNumber()));
//				paymentInstructionDto.setService(this.fileDto.getFileService());
//				paymentInstructionDto.setSubService(this.fileDto.getFileSubService());
//
//				paymentInstructionDto.setSystemGenSeqNumber(sysSeqNumber);
//
//				paymentInstructionDto.setAccountNumber(tc00Record.getAccountNumber());
//				paymentInstructionDto.setVisaAmount(Integer.parseInt(tc00Record.getSourceAmount()));
//				paymentInstructionDto.setFinancialIndicator("Y");
//				paymentInstructionDto.setTransactionCode(tc00Record.getTransactionCode());
//				paymentInstructionDto.setTransactionCodeQualifier(Integer.parseInt(tc00Record.getTranCodeQualifier()));
//				paymentInstructionDto.setTransactionCodeNumber(Integer.parseInt(tc00Record.getTcrNumber()));
//				paymentInstructionDto.setInputSeqNumber(tc00Record.getLineNumber());
//				paymentInstructionDto.setCardTransaction(tc00Record.getRecord());
//				paymentInstructionDto.setProcessStatus(transactionDto.getProcessStatus());
//				paymentInstructionDto.setInputFileIdentifier("I");
//				paymentInstructionDto.setSettlementDate(DateUtil.formatStringToDate(this.fileDto.getFileAXSHeaderRecordDto().getSettlementDate() , "yyyyMMdd"));
//				paymentInstructionDto.setOutputDate(DateUtil.formatStringToDate(this.fileDto.getFileAxsTrailorRecordDto().getOutputDate() , "yyyyMMdd"));
//
//				//paymentInstructionDto.setFilenameDescription(this.fileDto.getFileName());
//				paymentInstructionDto.setIssuerMember(transactionDto.getIssuerMember());
////				paymentInstructionDto.setIssuerCountryCode("0");
//				paymentInstructionDto.setXborderIssuerMember(transactionDto.getIssuerMember());
//
//				paymentInstructionDto.setAcquierMember(transactionDto.getAcquirerMember());
////				paymentInstructionDto.setAcquierCountryCode("0");
//				paymentInstructionDto.setXborderCountryCode("0");
//
//				paymentInstructionDto.setCardType(String.valueOf(transactionDto.getCardType()));
//				paymentInstructionDto.setCashbackPurchase("N");
//
//                // SARB Billing Values
//                paymentInstructionDto.setPosEntryModeIn(tc00Record.getPosEntryMode());
//                paymentInstructionDto.setTerminalCapabilityIn(tc00Record.getPosTermCapability());
//                paymentInstructionDto.setCardPresent(tc00Record.getCardholderIDMethod());
//				paymentInstructionDto.setECommIndIn(tc00Record.getECommInd());
//
//				paymentInstructionDao.create(paymentInstructionDto);
//			}
//
//
//			if (tc01Record != null){
//				CSOPaymentInstructionsVisaDTO paymentInstructionDto = new CSOPaymentInstructionsVisaDTO();
//				paymentInstructionDto.setFileRefNumber(String.valueOf(transactionDto.getFileSystemSeqNumber() == 0 ? " " : transactionDto.getFileSystemSeqNumber()));
//				paymentInstructionDto.setService(this.fileDto.getFileService());
//				paymentInstructionDto.setSubService(this.fileDto.getFileSubService());
//				paymentInstructionDto.setSystemGenSeqNumber(sysSeqNumber);
//				paymentInstructionDto.setTransactionCode(tc01Record.getTransactionCode());
//				paymentInstructionDto.setTransactionCodeQualifier(Integer.parseInt(tc01Record.getTranCodeQualifier()));
//				paymentInstructionDto.setTransactionCodeNumber(Integer.parseInt(tc01Record.getTcrNumber()));
//				paymentInstructionDto.setInputSeqNumber(tc01Record.getLineNumber());
//				paymentInstructionDto.setFinancialIndicator("N");
//				paymentInstructionDto.setProcessStatus(transactionDto.getProcessStatus());
//				paymentInstructionDto.setInputFileIdentifier("I");
//				paymentInstructionDto.setSettlementDate(DateUtil.formatStringToDate(this.fileDto.getFileAXSHeaderRecordDto().getSettlementDate() , "yyyyMMdd"));
//				paymentInstructionDto.setOutputDate(DateUtil.formatStringToDate(this.fileDto.getFileAxsTrailorRecordDto().getOutputDate() , "yyyyMMdd"));
//
////				CSFBinsDTO binDto = BsvTableLookup.getInstance().getCsfBins().get(tc01Record.getIssuerWorkstationBIN());
//				paymentInstructionDto.setIssuerMember(transactionDto.getIssuerMember());
////				paymentInstructionDto.setIssuerCountryCode("0");
//				paymentInstructionDto.setXborderIssuerMember(transactionDto.getIssuerMember());
//
//				paymentInstructionDto.setAcquierMember(transactionDto.getAcquirerMember());
////				paymentInstructionDto.setAcquierCountryCode("0");
//				paymentInstructionDto.setXborderCountryCode("0");
//
//				paymentInstructionDto.setCardType(String.valueOf(transactionDto.getCardType()));
//				paymentInstructionDto.setCashbackPurchase(tc01Record.getCashback().equals("") ? "Y" : "N");
//				paymentInstructionDto.setCashbackPurchaseAmnt(Integer.parseInt(tc01Record.getCashback()));
//				paymentInstructionDto.setChipCard(tc01Record.getChipCard());
//				paymentInstructionDto.setEcommInd(tc01Record.geteCommInd());
//				//paymentInstructionDto.setFilenameDescription(this.fileDto.getFileName());
//				paymentInstructionDto.setCardTransaction(tc01Record.getRecord());
//
//				paymentInstructionDao.create(paymentInstructionDto);
//			}
//
//			VISATCR3TransactionRecordDTO tc03Record = fileTransactionDto.getTcr3TransactionRecordDto();
//			if (tc03Record != null){
//				CSOPaymentInstructionsVisaDTO paymentInstructionDto = new CSOPaymentInstructionsVisaDTO();
//				paymentInstructionDto.setFileRefNumber(String.valueOf(transactionDto.getFileSystemSeqNumber()));
//				paymentInstructionDto.setService(this.fileDto.getFileService());
//				paymentInstructionDto.setSubService(this.fileDto.getFileSubService());
//
//				paymentInstructionDto.setSystemGenSeqNumber(sysSeqNumber);
//
//				paymentInstructionDto.setAccountNumber(transactionDto.getAccountNumber());
//				//paymentInstructionDto.setVisaAmount(Integer.parseInt(transactionDto.getSourceAmount()));
//				paymentInstructionDto.setFinancialIndicator("N");
//				paymentInstructionDto.setTransactionCode(tc03Record.getFr3FleetTc());
//				paymentInstructionDto.setTransactionCodeQualifier(Integer.parseInt(tc03Record.getFr3FleetTcq()));//.getFr3FleetTcq));
//				paymentInstructionDto.setTransactionCodeNumber(Integer.parseInt(tc03Record.getTcrNumber()));
//				paymentInstructionDto.setInputSeqNumber(tc03Record.getLineNumber());
//				paymentInstructionDto.setCardTransaction(tc03Record.getRecord());
//				paymentInstructionDto.setProcessStatus(transactionDto.getProcessStatus());
//				paymentInstructionDto.setInputFileIdentifier("I");
//				paymentInstructionDto.setSettlementDate(DateUtil.formatStringToDate(this.fileDto.getFileAXSHeaderRecordDto().getSettlementDate() , "yyyyMMdd"));
//				paymentInstructionDto.setOutputDate(DateUtil.formatStringToDate(this.fileDto.getFileAxsTrailorRecordDto().getOutputDate() , "yyyyMMdd"));
//
//				//paymentInstructionDto.setFilenameDescription(this.fileDto.getFileName());
//				paymentInstructionDto.setIssuerMember(transactionDto.getIssuerMember());
////				paymentInstructionDto.setIssuerCountryCode("0");
//				paymentInstructionDto.setXborderIssuerMember(transactionDto.getIssuerMember());
//
//				paymentInstructionDto.setAcquierMember(transactionDto.getAcquirerMember());
////				paymentInstructionDto.setAcquierCountryCode("0");
//				paymentInstructionDto.setXborderCountryCode("0");
//
//				paymentInstructionDto.setCardType(String.valueOf(transactionDto.getCardType()));
//				paymentInstructionDto.setCashbackPurchase("N");
//
//                // SARB Billing Values
//                /*paymentInstructionDto.setPosEntryModeIn(tc03Record.getPosEntryMode());
//                paymentInstructionDto.setTerminalCapabilityIn(tc03Record.getPosTermCapability());
//                paymentInstructionDto.setCardholderIndIn(tc03Record.getCardholderIDMethod());
//                //paymentInstructionDto.setChipCard(tc00Record.getChipCard());
//				paymentInstructionDto.setECommIndIn(tc03Record.getECommInd());*/
//
//				paymentInstructionDao.create(paymentInstructionDto);
//			}
//
//
//			VISATCR5TransactionRecordDTO tc05Record = fileTransactionDto.getTcr5TransactionRecordDto();
//			if (tc05Record != null){
//				CSOPaymentInstructionsVisaDTO paymentInstructionDto = new CSOPaymentInstructionsVisaDTO();
//				paymentInstructionDto.setFileRefNumber(String.valueOf(transactionDto.getFileSystemSeqNumber()));
//				paymentInstructionDto.setService(this.fileDto.getFileService());
//				paymentInstructionDto.setSubService(this.fileDto.getFileSubService());
//				paymentInstructionDto.setSystemGenSeqNumber(sysSeqNumber);
//				paymentInstructionDto.setTransactionCode(tc05Record.getTransactionCode());
//				paymentInstructionDto.setTransactionCodeQualifier(Integer.parseInt(tc05Record.getTranCodeQualifier()));
//				paymentInstructionDto.setTransactionCodeNumber(Integer.parseInt(tc05Record.getTcrNumber()));
//				paymentInstructionDto.setInputSeqNumber(tc05Record.getLineNumber());
//				paymentInstructionDto.setFinancialIndicator("N");
//				paymentInstructionDto.setProcessStatus(transactionDto.getProcessStatus());
//				paymentInstructionDto.setInputFileIdentifier("I");
//				paymentInstructionDto.setSettlementDate(DateUtil.formatStringToDate(this.fileDto.getFileAXSHeaderRecordDto().getSettlementDate() , "yyyyMMdd"));
//				paymentInstructionDto.setOutputDate(DateUtil.formatStringToDate(this.fileDto.getFileAxsTrailorRecordDto().getOutputDate() , "yyyyMMdd"));
//
//				paymentInstructionDto.setExchangeRate(Integer.parseInt(tc05Record.getSourceCurrencyToBaseCurrencyExchangeRate()));
//				//paymentInstructionDto.setFilenameDescription(this.fileDto.getFileName());
//				paymentInstructionDto.setIssuerMember(transactionDto.getIssuerMember());
////				paymentInstructionDto.setIssuerCountryCode("0");
//				paymentInstructionDto.setXborderIssuerMember(transactionDto.getIssuerMember());
//
//				paymentInstructionDto.setAcquierMember(transactionDto.getAcquirerMember());
////				paymentInstructionDto.setAcquierCountryCode("0");
//				paymentInstructionDto.setXborderCountryCode("0");
//
//				paymentInstructionDto.setCardType(String.valueOf(transactionDto.getCardType()));
//				paymentInstructionDto.setCardTransaction(tc05Record.getRecord());
//				paymentInstructionDto.setCashbackPurchase("N");
//
//				paymentInstructionDao.create(paymentInstructionDto);
//			}
//
//			VISATCR7TransactionRecordDTO tc07Record = fileTransactionDto.getTcr7TransactionRecordDto();
//			if (tc07Record != null){
//				CSOPaymentInstructionsVisaDTO paymentInstructionDto = new CSOPaymentInstructionsVisaDTO();
//				paymentInstructionDto.setFileRefNumber(String.valueOf(transactionDto.getFileSystemSeqNumber()));
//				paymentInstructionDto.setService(this.fileDto.getFileService());
//				paymentInstructionDto.setSubService(this.fileDto.getFileSubService());
//				paymentInstructionDto.setSystemGenSeqNumber(sysSeqNumber);
//				paymentInstructionDto.setTransactionCode(tc07Record.getTransactionCode());
//				paymentInstructionDto.setTransactionCodeQualifier(Integer.parseInt(tc07Record.getTranCodeQualifier()));
//				paymentInstructionDto.setTransactionCodeNumber(Integer.parseInt(tc07Record.getTcrNumber()));
//				paymentInstructionDto.setInputSeqNumber(tc07Record.getLineNumber());
//				paymentInstructionDto.setFinancialIndicator("N");
//				paymentInstructionDto.setProcessStatus(transactionDto.getProcessStatus());
//				paymentInstructionDto.setInputFileIdentifier("I");
//				paymentInstructionDto.setSettlementDate(DateUtil.formatStringToDate(this.fileDto.getFileAXSHeaderRecordDto().getSettlementDate() , "yyyyMMdd"));
//				paymentInstructionDto.setOutputDate(DateUtil.formatStringToDate(this.fileDto.getFileAxsTrailorRecordDto().getOutputDate() , "yyyyMMdd"));
//
//				//paymentInstructionDto.setFilenameDescription(this.fileDto.getFileName());
//				paymentInstructionDto.setIssuerMember(transactionDto.getIssuerMember());
////				paymentInstructionDto.setIssuerCountryCode("0");
//				paymentInstructionDto.setXborderIssuerMember(transactionDto.getIssuerMember());
//
//				paymentInstructionDto.setAcquierMember(transactionDto.getAcquirerMember());
////				paymentInstructionDto.setAcquierCountryCode("0");
//				paymentInstructionDto.setXborderCountryCode("0");
//
//				paymentInstructionDto.setCardType(String.valueOf(transactionDto.getCardType()));
//				paymentInstructionDto.setCardTransaction(tc07Record.getRecord());
//				paymentInstructionDto.setCashbackPurchase("N");
//
//				paymentInstructionDao.create(paymentInstructionDto);
//			}
//
//		}catch(Exception e){
//			throw new FileLoadException(e.getMessage());
//		}
//	}
//
//	@Override
//	public void setConnection(DataSource conn) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//}
