//package com.bsva.dmcs.fileLoad.visa;
//
//
//import java.sql.Connection;
//import java.util.Date;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.apache.log4j.Logger;
//
//import com.bsva.dcms.commons.dto.CSFBinsDTO;
//import com.bsva.dcms.commons.dto.CSFCardTypesDTO;
//import com.bsva.dcms.commons.dto.file.ErrorDTO;
//import com.bsva.dcms.commons.dto.file.FileAXSTrailorRecordDTO;
//import com.bsva.dcms.commons.dto.file.FileDTO;
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
//import com.bsva.dcms.commons.util.DateUtil;
//import com.bsva.dcms.commons.util.StringUtil;
//import com.bsva.dcms.commons.util.Utils;
//import com.bsva.dmcs.fileLoad.AbstractFileValidator;
//import com.bsva.dmcs.fileLoad.exceptions.FileLoadException;
//
//public class VisaFileValidator extends AbstractFileValidator{
//
//	private BsvTableLookup bsvTableLookup = BsvTableLookup.getInstance();
//	private ErrorDTO errorDto = new ErrorDTO();
//	private VISAFileDTO fileDto = new VISAFileDTO();
//	private Logger log = Logger.getLogger(VisaFileValidator.class);
//
//
//	public void validateByFileType(FileDTO fileDto) throws FileLoadException {
//		// TODO Auto-generated method stub
//		log.info("Validating file " +  fileDto.getFileName());
//
//		try{
//			this.fileDto = (VISAFileDTO)fileDto;
//			this.errorDto = this.fileDto.getErrorDto();
//
//			//if file was rejected, then dont continue
//			if (this.fileDto.getFileStatus().equals(Status.R.getSymbol()))
//				return;
//
//			//if header was invalid, dont bother validating the rest of the file
//			if (!validateVisaHeader()){
//				return;
//			}
//
////			if (!validateVisa90Header()){
////				return;
////			}
//			if (!validateVisaRecord())
//				return;
//
////			if (!validateVisaEOS()){
////				return;
////			}
////
////			if (!validateMasterCard91_92()){
////				return;
////			}
////
////			if (!validateVisaTrailor())
////				return;
//		}catch(Exception e){
//			throw new FileLoadException(e.getMessage());
//		}
//
//		log.info("Finished Validating " + fileDto.getFileName());
//	}
//
//	//TODO if header is invalid , dont validate the rest of the file
//	private boolean validateVisaHeader(){
//
//		//super.validateFileHeader();
//
//		boolean result = validateFileHeader();
//
//	    //FNNMENOSTR
//		if (bsvTableLookup.getCsfSystemSettings().get("FNNMENOSTR") != null){
//
//		}
//		if(result){
//			return true;
//		}else{
//			return false;
//		}
//
//		//return this.fileDto.getFileStatus().equals(Status.R.getSymbol());
//	}
//
//	private boolean validateVisa90Header(){
//		FileHeader90RecordDTO header90Dto = fileDto.getFileHeader90RecordDto();
//
//		if (header90Dto != null){
//			try{
//				//check the header processDate
//				Date processDate = DateUtil.formatStringToDate(bsvTableLookup.getProcessDate(), "yyyyMMdd");
//				String formattedDate = DateUtil.formatDate(processDate, "yyddd");
//				if (!header90Dto.getProcessingDate().equals(formattedDate)){
//					errorDto.addError(11, header90Dto.getLineNumber(), Integer.parseInt(Constants.HEADER_90_RECID), 3, header90Dto.getProcessingDate(), formattedDate);
//					fileDto.setFileStatus(Status.R.getSymbol());
//				}
//			}catch(Exception e){
//				errorDto.addError(11, header90Dto.getLineNumber(), Integer.parseInt(Constants.HEADER_90_RECID), 3, header90Dto.getProcessingDate(), null);
//				fileDto.setFileStatus(Status.R.getSymbol());
//			}
//
//			try{
//				//check test live indicator
//				if (!header90Dto.getTestOption().equals(bsvTableLookup.getSystemStatus())){
//				     errorDto.addError(15, 1, 1, 5, header90Dto.getTestOption(),bsvTableLookup.getSystemStatus());
//				     fileDto.setFileStatus(Status.R.getSymbol());
//				}
//			}catch(Exception e){
//				 errorDto.addError(15, 1, 1, 5, header90Dto.getTestOption(),bsvTableLookup.getSystemStatus());
//			     fileDto.setFileStatus(Status.R.getSymbol());
//			}
//		}
//		return this.fileDto.getFileStatus().equals(Status.A.getSymbol());
//	}
//	private boolean validateVisaRecord(){
//
//		//validate all the other transactions except 41
//				for(FileTransactionRecordDTO tranDto : fileDto.getFileTransactionRecordDtoList()){
//
//					VISAFileTransactionRecordDTO currentFileTransactionRecordDto = (VISAFileTransactionRecordDTO)tranDto;
//
//					VISATCR0TransactionRecordDTO tcr0TransactionRecordDto = currentFileTransactionRecordDto.getTcr0TransactionRecordDto();
//					VISATCR1TransactionRecordDTO tcr1TransactionRecordDto = currentFileTransactionRecordDto.getTcr1TransactionRecordDto();
//					VISATCR3TransactionRecordDTO tcr3TransactionRecordDto = currentFileTransactionRecordDto.getTcr3TransactionRecordDto();
//					VISATCR5TransactionRecordDTO tcr5TransactionRecordDto = currentFileTransactionRecordDto.getTcr5TransactionRecordDto();
//					VISATCR7TransactionRecordDTO tcr7TransactionRecordDto = currentFileTransactionRecordDto.getTcr7TransactionRecordDto();
//
//					//** Lets validating fields that are common amongst transaction code **
//
//					//is transaction code valid
//					try{
//					if (bsvTableLookup.getCsfTransactionTypes().get(String.valueOf(currentFileTransactionRecordDto.getTransactionCode())) == null){
//						throw new NullPointerException("");
//						//errorDto.addError(31, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 1,String.valueOf(currentFileTransactionRecordDto.getTransactionCode()),"");
//						//currentFileTransactionRecordDto.setCurrentRecordValid(false);
//					}
//					}catch(Exception ex){
//						ex.printStackTrace();
//						throw new NullPointerException("throw new NullPointerException No Transaction code");
//
//					}
//
//					//issuer bin and acquirer bin must be numeric
//					if (tcr0TransactionRecordDto.getIssuerWorkstationBIN().length() > 0 && !Utils.IsNumeric(tcr0TransactionRecordDto.getIssuerWorkstationBIN())){ //
//						errorDto.addError(27, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 4,tcr0TransactionRecordDto.getIssuerWorkstationBIN(),"");
//						currentFileTransactionRecordDto.setCurrentRecordValid(false);
//					}
//					if (tcr0TransactionRecordDto.getAcquirerWorkstationBIN().length() > 0 && !Utils.IsNumeric(tcr0TransactionRecordDto.getAcquirerWorkstationBIN())){
//						errorDto.addError(28, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 5,tcr0TransactionRecordDto.getAcquirerWorkstationBIN(),"");
//						currentFileTransactionRecordDto.setCurrentRecordValid(false);
//					}
//
//					//transaction codes for tcr1 and tcr0 must be the same
//					if (!tcr1TransactionRecordDto.getTransactionCode().equals(tcr0TransactionRecordDto.getTransactionCode())){
//
//						errorDto.addError(41, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 1,tcr1TransactionRecordDto.getTransactionCode(),tcr0TransactionRecordDto.getTransactionCode());
//						currentFileTransactionRecordDto.setCurrentRecordValid(false);
//					}
//
//					//sequence number must be in order
//					if (tcr0TransactionRecordDto.getLineNumber() > tcr1TransactionRecordDto.getLineNumber() ||
//							(tcr5TransactionRecordDto != null && tcr0TransactionRecordDto.getLineNumber() > tcr5TransactionRecordDto.getLineNumber())||
//							(tcr3TransactionRecordDto != null && tcr0TransactionRecordDto.getLineNumber() > tcr3TransactionRecordDto.getLineNumber())||
//							(tcr7TransactionRecordDto != null && tcr0TransactionRecordDto.getLineNumber() > tcr7TransactionRecordDto.getLineNumber())){
//
//						errorDto.addError(42, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 3,tcr0TransactionRecordDto.getTcrNumber(),"");
//						currentFileTransactionRecordDto.setCurrentRecordValid(false);
//					}
//
//					if (tcr5TransactionRecordDto != null){  // because TCR5 is optional
//						if (tcr1TransactionRecordDto.getLineNumber() > tcr5TransactionRecordDto.getLineNumber() ||
//								(tcr7TransactionRecordDto != null && tcr1TransactionRecordDto.getLineNumber() > tcr7TransactionRecordDto.getLineNumber())){
//							errorDto.addError(42, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(),currentFileTransactionRecordDto.getTransactionCode(), 3,tcr1TransactionRecordDto.getTcrNumber() + "","");
//							currentFileTransactionRecordDto.setCurrentRecordValid(false);
//						}
//						if ((tcr7TransactionRecordDto != null && tcr5TransactionRecordDto.getLineNumber() > tcr7TransactionRecordDto.getLineNumber())){
//							errorDto.addError(42, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(),currentFileTransactionRecordDto.getTransactionCode(), 3,tcr5TransactionRecordDto.getTcrNumber() + "","");
//							currentFileTransactionRecordDto.setCurrentRecordValid(false);
//						}
//					}
//
//					//card number/account number must be numeric
//					if (!Utils.IsNumeric(currentFileTransactionRecordDto.getCardNumber())){
//						errorDto.addError(77, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 4,currentFileTransactionRecordDto.getCardNumber(),null);
//						currentFileTransactionRecordDto.setCurrentRecordValid(false);
//					}
//
//					//length for account number
//					if (currentFileTransactionRecordDto.getCardNumber().length() < 16){
//						errorDto.addError(55, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 4,currentFileTransactionRecordDto.getCardNumber(),null);
//						currentFileTransactionRecordDto.setCurrentRecordValid(false);
//					}
//
//					//validate card type
//					if (currentFileTransactionRecordDto.getCardType() == 0){
//						errorDto.addError(79, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 4,String.valueOf(currentFileTransactionRecordDto.getCardType()),null);
//						currentFileTransactionRecordDto.setCurrentRecordValid(false);
//					}
//
//					CSFCardTypesDTO csfCardTypesDTO = bsvTableLookup.getCsfCardTypes().get(String.valueOf(currentFileTransactionRecordDto.getCardType()));
//					if (currentFileTransactionRecordDto.getCardType() != -1 && csfCardTypesDTO == null){
//						errorDto.addError(78, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 4,String.valueOf(currentFileTransactionRecordDto.getCardType()),"");
//						currentFileTransactionRecordDto.setCurrentRecordValid(false);
//					}
//
//					//card description - check if card type is allowed for subservice
//					String cardDescription  =  csfCardTypesDTO == null ? "" : csfCardTypesDTO.getCardDescription();
//					if (currentFileTransactionRecordDto.getTransactionCode() == 51 && cardDescription.contains("MAS")){
//						errorDto.addError(78, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 1,String.valueOf(currentFileTransactionRecordDto.getTransactionCode()),"");
//						currentFileTransactionRecordDto.setCurrentRecordValid(false);
//					}
//					//transaction amount
//					if(!Utils.IsNumeric(String.valueOf(currentFileTransactionRecordDto.getTransactionAmount()))){
//						errorDto.addError(33, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 14,
//								Utils.formatAmount(currentFileTransactionRecordDto.getTransactionAmount(), 10),"");
//						currentFileTransactionRecordDto.setCurrentRecordValid(false);
//
//					}else{
//						double pasaLimit = csfCardTypesDTO == null ? 0 : csfCardTypesDTO.getPasaPaymentLimit();
//
//						if (currentFileTransactionRecordDto.getCardType() != -1  && currentFileTransactionRecordDto.getTransactionAmount() > (pasaLimit * 100)){ //Compare cent values
//							errorDto.addError(43, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 14 ,
//							Utils.formatAmount(currentFileTransactionRecordDto.getTransactionAmount(), 8),Utils.formatAmount(pasaLimit, 8));
//							currentFileTransactionRecordDto.setCurrentRecordValid(false);
//						}
//			}
//			//** end of common validations **
//
//			int transactionCode = currentFileTransactionRecordDto.getTransactionCode();
//
//			if (transactionCode > 1 && transactionCode < 40){
//				//validate visa bin
//				validateVISAbin(currentFileTransactionRecordDto, errorDto);
//			}
//
//			if (transactionCode > 10 && transactionCode < 20){
//
//				String filenamePrefix = fileDto.getFileName().substring(0 , 2);
//
//				// fleet , amex and diners club
//				if (filenamePrefix.equals("CL")  || filenamePrefix.equals("CA") || filenamePrefix.equals("CK")){
//					errorDto.addError(80, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 7,String.valueOf(currentFileTransactionRecordDto.getTransactionCode()),null);
//					currentFileTransactionRecordDto.setCurrentRecordValid(false);
//				}
//			}
//
//			if (transactionCode > 50 && transactionCode < 60){ //e.g 51/53
//
//				//there might be some additional validations here
//
//				validateVISAbin(currentFileTransactionRecordDto, errorDto);
//			}
//
//			if (transactionCode > 89 )
//				return true;
//
//			//** Validations by file prefix **
//			String filenamePrefix = fileDto.getFileName().substring(0 , 2);
//
//			//amex file
//			if (filenamePrefix.equals("CA")){
//
//				validateAMEXMerchantSE(currentFileTransactionRecordDto,errorDto);
//
//			}else if (filenamePrefix.equals("CL")){  //fleet file
//
//				String purchaseDate = tcr0TransactionRecordDto.getPurchaseDate();
//				String month = purchaseDate.substring(0,2);
//				String day = purchaseDate.substring(2, 4);
//
//				if (!Utils.IsNumeric(month) || (Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12 )){
//					errorDto.addError(1, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 19,month,"");
//					currentFileTransactionRecordDto.setCurrentRecordValid(false);
//				}
//
//				if (!Utils.IsNumeric(day) || (Integer.parseInt(day) < 1 || Integer.parseInt(day) > 31 )){
//					errorDto.addError(1, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 19,day,"");
//					currentFileTransactionRecordDto.setCurrentRecordValid(false);
//				}
//
//				//fleet??
//			}else{
//				//fleet??
//				if (currentFileTransactionRecordDto.getCardType() == 6){
//					//i.e fleet transactions found on VISA files
//				}
//			}
//		}
//
//		//validate 41
//		for(NegativeCardRecordDTO negativeCardRecordDto : fileDto.getNegativeCardRecordDToList()){
//			if (!Utils.IsNumeric(negativeCardRecordDto.getAccountNumber())){
//				errorDto.addError(77, new Long(negativeCardRecordDto.getRecordOffset()).longValue(), Integer.parseInt(negativeCardRecordDto.getTransactionCode()), 6,negativeCardRecordDto.getAccountNumber(),null);
//				negativeCardRecordDto.setCurrentRecordValid(false);
//			}
//
//			if (!Utils.IsNumeric(negativeCardRecordDto.getSourceBin())){
//				errorDto.addError(53, new Long(negativeCardRecordDto.getRecordOffset()).longValue(), Integer.parseInt(negativeCardRecordDto.getTransactionCode()), 3,negativeCardRecordDto.getSourceBin(),null);
//				negativeCardRecordDto.setCurrentRecordValid(false);
//			}
//		}
//
//		return this.fileDto.getFileStatus().equals(Status.A.getSymbol());
//	}
//
//	private void validateVISAbin(VISAFileTransactionRecordDTO currentFileTransactionRecordDto,ErrorDTO errorDto) {
//
//		if (currentFileTransactionRecordDto.getIssuerBin() == -1 && currentFileTransactionRecordDto.getIssuerBin() == 0){
//			errorDto.addError(27, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 4, String.valueOf(currentFileTransactionRecordDto.getIssuerBin()), "");
//			currentFileTransactionRecordDto.setCurrentRecordValid(false);
//		}
//
//		if (currentFileTransactionRecordDto.getAcquirerBin() == -1){
//			errorDto.addError(28, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 5, String.valueOf(currentFileTransactionRecordDto.getAcquirerBin()), "");
//			currentFileTransactionRecordDto.setCurrentRecordValid(false);
//		}
//
//		if(currentFileTransactionRecordDto.getIssuerBin() != -1){
//			CSFBinsDTO issuerBinDto = bsvTableLookup.getBINDetailForBin(currentFileTransactionRecordDto.getIssuerBin());
//		    if ( issuerBinDto != null){
//
//		    	if (currentFileTransactionRecordDto.getAcquirerBin() != -1  || issuerBinDto.getAcqIssBoth().equals("B") || issuerBinDto.getAcqIssBoth().equals("I")){
//
//		    		if (!binDatingValidation(currentFileTransactionRecordDto, 'I', issuerBinDto, errorDto)){
//		    			currentFileTransactionRecordDto.setCurrentRecordValid(false);//error message set inside binDatingValidation
//		    		}
//		    	}else{
//		    		errorDto.addError(63, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 4, String.valueOf(currentFileTransactionRecordDto.getIssuerBin()), "");
//		    		currentFileTransactionRecordDto.setCurrentRecordValid(false);
//		    	}
//		    }
//		}else{
//	    	errorDto.addError(27, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 4, String.valueOf(currentFileTransactionRecordDto.getIssuerBin()), "");
//			currentFileTransactionRecordDto.setCurrentRecordValid(false);
//	    }
//
//	    if(currentFileTransactionRecordDto.getAcquirerBin() != -1){
//		    CSFBinsDTO acquirerBinDto = bsvTableLookup.getBINDetailForBin(currentFileTransactionRecordDto.getAcquirerBin());
//		    if (acquirerBinDto != null){
//
//		    	if ((acquirerBinDto.getAcqIssBoth().equals("B") || acquirerBinDto.getAcqIssBoth().equals("A"))){
//
//		    		if (!binDatingValidation(currentFileTransactionRecordDto, 'A', acquirerBinDto, errorDto)){
//		    			currentFileTransactionRecordDto.setCurrentRecordValid(false); //error message set inside binDatingValidation
//		    		}
//		    	}else{
//		    		errorDto.addError(64, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 5, String.valueOf(currentFileTransactionRecordDto.getAcquirerBin()), "");
//		    		currentFileTransactionRecordDto.setCurrentRecordValid(false);
//		    	}
//		    }
//	    } else{
//	    	errorDto.addError(28, new Long(currentFileTransactionRecordDto.getRecordOffset()).longValue(), currentFileTransactionRecordDto.getTransactionCode(), 5, String.valueOf(currentFileTransactionRecordDto.getAcquirerBin()), "");
//			currentFileTransactionRecordDto.setCurrentRecordValid(false);
//	    }
//	}
//	private boolean binDatingValidation(VISAFileTransactionRecordDTO currentFileTransactionRecordDto,char issAcqBin, CSFBinsDTO csfbinsDto, ErrorDTO errorDto){
//
//		boolean binValid = true;
//		int binNo = (issAcqBin == 'I') ? currentFileTransactionRecordDto.getIssuerBin() : currentFileTransactionRecordDto.getAcquirerBin();
//
//		int transCode = currentFileTransactionRecordDto.getTransactionCode();
//
//		if (transCode == 4 || transCode == 5 || transCode == 6 || transCode == 7){
//
//			if (csfbinsDto.getActiveInd().equals("A")){
//
//				if (csfbinsDto.getDaysBeforeFirstDeletionDate() < 0 && csfbinsDto.getDaysBeforeFinalDeletionDate() > 0){
//
//					String usageCode = currentFileTransactionRecordDto.getTcr0TransactionRecordDto().getUsageCode();
//
//					if (!usageCode.equals("2")){
//						binValid = false;
//
//						errorDto.addError(issAcqBin == 'I' ? 61 : 62, currentFileTransactionRecordDto.getRecordOffset(), currentFileTransactionRecordDto.getTransactionCode(), 12, String.valueOf(binNo), null);
//					}
//				}
//
//				if (csfbinsDto.getDaysBeforeFirstDeletionDate() < 0 && csfbinsDto.getDaysBeforeFinalDeletionDate() < 0){
//					binValid = false;
//
//					errorDto.addError(issAcqBin == 'I' ? 61 : 62, currentFileTransactionRecordDto.getRecordOffset(), currentFileTransactionRecordDto.getTransactionCode(), 12, String.valueOf(binNo), null);
//				}
//			}
//		}
//		return binValid;
//	}
//	 private static void validateAMEXMerchantSE(VISAFileTransactionRecordDTO currentFileTransactionRecordDto,ErrorDTO errorDto) {
//		 int mSEl3;
//	        //Calculating the Cehck digit for American Express Cards.
//	        //Was difficult to write - is now difficult to read...
//
//	        /*
//	         *Explanation:
//	         *The AMEX Merchant SE number consists of a 10 digit number, with the
//	         * least siginificant being a check digit. Calculating the check digit is as follows:
//	         *
//	         * 1. If the 3 most siginifacant digits are more than 939, or less than 930,
//	         *    the most significant digit changes to a zero.
//	         * 2. Add the numeric vales of each of the unevent place digits, couting from right
//	         *    the left (ie: 10,9,8,7,6,5,4,3,2,1)
//	         *    1234567890
//	         *    ^digit 10
//	         *     ^digit 9
//	         *      ^digit 8
//	         *       ^digit 7
//	         *        ^digit 6
//	         *         ^digit 5
//	         *          ^digit 4
//	         *           ^digit 3
//	         *            ^digit 2
//	         *             ^digit 1
//	         * therefore: 2 + 4 + 6 + 8 (being digits 9,7,5 and 3) = 20 (total1)
//	         * 3. Using the same counting, multiply each of the even number digits by 2.
//	         *    If the result is greater than 9, add the seperate digits of the result:
//	         *    1 * 2 = 2
//	         *    3 * 2 = 6
//	         *    5 * 2 = 10 = 1 + 0 = 1
//	         *    7 * 2 = 14 = 1 + 4 = 5
//	         *    Add these values: 2 + 6 + 1 + 5 = 14. (total2)
//	         * 4. Add total1 and total2: 20 + 14 = 34
//	         * 5. If the sum of total1 and total2 is not a multiple of 10, calc the difference
//	         *    between the sum and the following multi of 10, like so:
//	         *    40 - 34 = 6.
//	         * 6. The check digit must be equal to this digit.
//	         * (in the example 0 is not = to 6 and is therefore invalid.)
//	        */
//
//		 String tmpMercSE = currentFileTransactionRecordDto.getTcr1TransactionRecordDto().getCardAcceptorID(); //TODO: 80-90 is not card acceptor id
//
//		 if (!Utils.IsNumeric(tmpMercSE)){
//
//			 errorDto.addError(48, currentFileTransactionRecordDto.getRecordOffset() , currentFileTransactionRecordDto.getTransactionCode() , 13 , null , null);
//			 currentFileTransactionRecordDto.setCurrentRecordValid(false);
//		 }else{
//			 mSEl3 = Integer.parseInt(tmpMercSE.substring(0 , 3));
//
//			 if (mSEl3 < 930 || mSEl3 > 939) {
//		            tmpMercSE = "0" + tmpMercSE.substring(1,10);
//		        }
//		        int lastDig = Integer.parseInt(tmpMercSE.substring(9,10));
//		        int cdvTot;
//		        cdvTot = Integer.parseInt(tmpMercSE.substring(1,2));
//		        cdvTot += Integer.parseInt(tmpMercSE.substring(3,4));
//		        cdvTot += Integer.parseInt(tmpMercSE.substring(5,6));
//		        cdvTot += Integer.parseInt(tmpMercSE.substring(7,8));
//
//		        int multRest;
//		        int tmpNum;
//		        int cdvTot2 = 0;
//		        for (int xx=0;xx<5;xx++) {
//		            multRest = Integer.parseInt(tmpMercSE.substring(xx * 2,(xx * 2) + 1)) * 2;
//		            if (multRest > 9) {
//		                tmpNum = (multRest / 10);
//		                tmpNum += multRest - 10;
//		            } else {
//		                tmpNum = multRest;
//		            }
//		            cdvTot2 += tmpNum;
//		        }
//		        cdvTot2 += cdvTot;
//		        int tmpTot;
//		        tmpTot = cdvTot2 / 10;
//		        tmpTot = tmpTot * 10;
//		        int cdvRes;
//		        if ((cdvTot2 - tmpTot) == 0) {
//		            cdvRes = 0;
//		        } else {
//		            cdvRes = cdvTot2 / 10;
//		            cdvRes += 1;
//		            cdvRes = cdvRes * 10;
//		            cdvRes = cdvRes - cdvTot2;
//		        }
//		        if (cdvRes != lastDig) {
//
//		        	errorDto.addError(48, currentFileTransactionRecordDto.getRecordOffset() , currentFileTransactionRecordDto.getTransactionCode() , 13 , tmpMercSE , null);
//		        	currentFileTransactionRecordDto.setCurrentRecordValid(false);
//		        }
//		 }
//	 }
//
//	 private boolean validateMasterCard91_92(){
//
//			List<FileTrailer91_92RecordDTO> trailor9192List = fileDto.getFileCtrlTrailorDtoList();
//
//			int numTcrs = 0;
//			int numTransactions = 1; // 1 is for this current record
//			double sourceAmounts = 0;
//
//			for(FileTrailer91_92RecordDTO trailor9192 : trailor9192List){
//
//				numTransactions = trailor9192.getFileTransactionRecordDtoList().size();
//				numTransactions += trailor9192.getNegativeCardRecordDtoList().size();
//
//				for(FileTransactionRecordDTO tran  : trailor9192.getFileTransactionRecordDtoList()){
//					if (tran.getTcr0TransactionRecordDto() != null){
//						numTcrs += 1;
//						sourceAmounts = tran.getTransactionAmount();
//					}
//
//					if (tran.getTcr1TransactionRecordDto() != null){
//						numTcrs += 1;
//					}
//
//					if (tran.getTcr5TransactionRecordDto() != null){
//						numTcrs += 1;
//					}
//
//					if (tran.getTcr7TransactionRecordDto() != null){
//						numTcrs += 1;
//					}
//				}
//
//				//because you can get negative card records amongst tcrs
//				for(NegativeCardRecordDTO negRec : trailor9192.getNegativeCardRecordDtoList()){
//					numTcrs += 1;
//					//sourceAmounts = negRec.get
//				}
//
//				//check number of tcrs
//				if (Integer.parseInt(trailor9192.getNoOfTCRs()) != numTcrs){
//					errorDto.addError(51 , trailor9192.getLineNumber() , 91 , 9 , trailor9192.getNoOfTransactions() , String.valueOf(numTcrs));
//					fileDto.setFileStatus(Status.R.getSymbol());
//				}
//
//				//check number of transactions
//				if (Integer.parseInt(trailor9192.getNoOfTransactions()) != numTransactions){
//					errorDto.addError(51 ,trailor9192.getLineNumber() , 91 , 12 , trailor9192.getNoOfTransactions() , String.valueOf(numTransactions));
//					fileDto.setFileStatus(Status.R.getSymbol());
//				}
//
//				//
//				if ((new Long(trailor9192.getSourceAmount())).longValue() != sourceAmounts){
//					errorDto.addError(52 ,trailor9192.getLineNumber() , 91, 14 , trailor9192.getSourceAmount() , String.valueOf(sourceAmounts));
//					fileDto.setFileStatus(Status.R.getSymbol());
//				}
//			}
//			return this.fileDto.getFileStatus().equals(Status.A.getSymbol());
//		}
//
//	 private boolean validateVisaEOS(){
//
//		super.validateFileEOS();
//		return this.fileDto.getFileStatus().equals(Status.A.getSymbol());
//	}
//
//	private boolean validateVisaTrailor(){
//
//	    super.validateFileTrailor();
//
//	    FileAXSTrailorRecordDTO axsTrailorRecDto = fileDto.getFileAxsTrailorRecordDto();
//	    //check total number of records for visa records incl control + eof records
//	  	int numOfRecords = 0;
//	  	numOfRecords +=  fileDto.getFileTransactionRecordDtoList().size();
//	  	numOfRecords += fileDto.getFileAXSHeaderRecordDto() != null ? 1 : 0;
//	  	numOfRecords += fileDto.getFileAxsTrailorRecordDto() != null ? 1 : 0;
//	  	numOfRecords += fileDto.getFileCtrlTrailorDtoList().size();
//		numOfRecords += fileDto.getFileEOS98RecordDto() != null ? 1 : 0;
//		if (Integer.parseInt(axsTrailorRecDto.getNumberOfRecords()) != numOfRecords){
//			errorDto.addError(8, axsTrailorRecDto.getLineNumber(), 99, 6,axsTrailorRecDto.getNumberOfRecords() , String.valueOf(numOfRecords));
//		  	fileDto.setFileStatus(Status.R.getSymbol());
//		}
//
//	  	//hashtotal of account numbers
//		long accNumTotal = 0;
//		for(FileTransactionRecordDTO fileTransactionRecDto : fileDto.getFileTransactionRecordDtoList()){
//			accNumTotal += Long.parseLong(fileTransactionRecDto.getCardNumber());
//		}
//		for(NegativeCardRecordDTO negativeCardRecDto : fileDto.getNegativeCardRecordDToList()){ //because u can get negative card records amongst
//			accNumTotal += Long.parseLong(negativeCardRecDto.getAccountNumber());
//		}
//
//		String accNumHash = StringUtil.rightJustify(String.valueOf(accNumTotal), StringUtil.ZERO_STRING, 12);
//		if (!axsTrailorRecDto.getHashtotalOfAccountNumbers().equals(accNumHash)){
//			errorDto.addError(6, axsTrailorRecDto.getLineNumber(), 99, 10,axsTrailorRecDto.getHashtotalOfAccountNumbers() ,accNumHash );
//		  	fileDto.setFileStatus(Status.R.getSymbol());
//		}
//		return this.fileDto.getFileStatus().equals(Status.A.getSymbol());
//	}
//
//	@Override
//	public void setConnection(DataSource conn) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
