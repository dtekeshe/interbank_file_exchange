package com.bsva.dmcs.fileloadv02.parsers;

import com.bsva.dao.v02.CardTypesDAO;
import com.bsva.dao.v02.CompanyParametersDAO;
import com.bsva.dao.v02.TransactionTypesDAO;
import com.bsva.dao.v02.fileloader.VisaChargeBacksReasonCodeDAO;
import com.bsva.dcms.commons.dao.CSFMembersServiceDAO;
import com.bsva.dcms.commons.dao.CsfCompanyParametersDAO;
import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.dto.CsfCompanyParametersDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dmcs.fileloadv02.dto.MemberInfoDTO;
import com.bsva.dmcs.fileloadv02.dto.SubService;
import com.bsva.dmcs.fileloadv02.model.MemberInfoBean;
import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.dmcs.fileloadv02.model.TCRCode;
import com.bsva.dmcs.fileloadv02.model.TerminalInfo;
import com.bsva.dmcs.fileloadv02.util.BinarySearch;
import com.bsva.dmcs.fileloadv02.util.VISAParserUtils;
import com.bsva.dmcs.fileloadv02.validators.BINValidator;
import com.bsva.dto.ErrorDTO;
import com.bsva.entities.CsfCompanyParameters;
import com.bsva.entities.v02.commons.CardTypeEntity;
import com.bsva.entities.v02.loader.VisaChargeBacksEntity;
import com.bsva.entities.v02.params.CompanyParametersEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static com.bsva.dmcs.fileloadv02.util.MathUtils.isNumber;
import static com.bsva.dmcs.fileloadv02.util.StringUtils.replace;
import static com.bsva.dmcs.reportv02.util.StringUtils.parseInt;
import static com.bsva.dmcs.fileloadv02.util.StringUtils.substring;
import static com.bsva.dmcs.fileloadv02.util.VISAParserUtils.getChipCardNormalized;
import static com.bsva.dmcs.reportv02.util.StringUtils.parseLong;

import static com.bsva.dto.ErrorCode.*;

/**
 * Constructs a VISA TCR object from a string
 */
public class VISATxnRecordParser extends TxnRecordParser {

	private final Integer[] txnTypes;

	private final Map<Integer, CardTypeEntity> cardTypes;

	private final List<SubService> EXCLUDED_SUB_SERVICES;

	private final List<VisaChargeBacksEntity> reasonCodes;

	private final BINValidator binValidator;
	
	private final CompanyParametersEntity companyParametersEntity;

	public VISATxnRecordParser() {

		// txn types
		this.txnTypes = new TransactionTypesDAO().txnTypes();
		// card types
		this.cardTypes = new CardTypesDAO().cardTypes();
		// reasonCode
		this.reasonCodes = new VisaChargeBacksReasonCodeDAO().getReasonCodes();
		// excluded sub services
		this.EXCLUDED_SUB_SERVICES = VISAParserUtils.excludedSubServices();
		
		this.companyParametersEntity = new CompanyParametersDAO().companyParameters();
		// bin validator
		binValidator = new BINValidator();
	}

	public Integer getCurrencyCode(Integer currencyCode) {

		try {
			CsfCompanyParametersDTO csfCParam = new CsfCompanyParametersDTO();
			csfCParam.setCurrencyCodeNumber(currencyCode);
			CsfCompanyParametersDTO cparam = new CsfCompanyParametersDAO().retrieve(csfCParam);
			if (cparam != null) {
				return cparam.getCurrencyCodeNumber();
			}
		}
		catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getCurrencyCodeValidation() {
		try {
			CSFMemberServiceDTO memberService = new CSFMemberServiceDTO();
			memberService.setCurrencyCodeValidationReq("Y");
			List<CSFMemberServiceDTO> memberList = new CSFMembersServiceDAO().retrieveRelated(memberService);
			if(memberList.size() > 0){
				for (CSFMemberServiceDTO csfMemberServiceDTO : memberList) {
					
				}
			}
		}
		catch (DAOException e) {
			e.printStackTrace();
		}
		return "code";
	}

	public FileDetailDTO parse(AtomicLong fileSeqNumber, AtomicLong txnSeqNumber, String line, Long lineID,
			MemberInfoBean memberInfoBean, SubService subService, List<ErrorDTO> errors) {

		boolean isValid = true;
		int initErrorCount = errors.size();

		String recordId = substring(line, 0, 2);
		Integer txnCode = parseInt(line, 0, 2);
		Integer tcrId = parseInt(line, 2, 4);
		TCRCode tcrCode = TCRCode.instance(tcrId);

		FileDetailDTO fileDetailDTO = new FileDetailDTO(fileSeqNumber, txnSeqNumber, line, lineID, txnCode, tcrCode);
		fileDetailDTO.setInputLength(line.length());
		String reasonCode = line.substring(147, 149).trim();
		switch (tcrCode) {

		case TCR0: // Financial Transaction Control Record.

			// amount
			Long amount = parseLong(line, 76, 88);
			if (amount != null) {
				fileDetailDTO.setAmount(amount);
			}
			else {
				error(errors, recordId, lineID, AMOUNT_NOT_NUMERIC, 4, "" + txnCode);
			}

			// validate txn code
			if (!isValidTransactionCode(txnCode)) {
				error(errors, recordId, lineID, TRAN_CODE_DOES_NOT_EXIST, 1, "" + txnCode);
			}

			// acquirer bin, code
			Integer acquirerBin = parseInt(line, 27, 33);// 445143
			fileDetailDTO.setAcquirerBin(acquirerBin);

			MemberInfoDTO acquiringMember = memberInfoBean.getMemberByBin(acquirerBin);
			if (acquiringMember != null) {
				fileDetailDTO.setAcquirerCode(acquiringMember.getBankCode());
			}
			// acquirer info validation
			if (acquirerBin == null) {
				error(errors, recordId, lineID, INVALID_ACQUIRER_BIN, 2, "" + acquirerBin);
			}
			
			 // company parameters
            Integer currencyValidationCode = companyParametersEntity.getCurrencyCodeNumber();
            
			if ("VISA CARD".equals(subService.getDescription())) {
				Integer currCode = parseInt(line,73,76);
				if(currencyValidationCode.equals(currCode)){}else{
					error(errors, recordId, lineID, SRC_CURRENCY_CODE_INVALID, 59,"CURR CODE:"+""+currCode+" SHOULD BE : "+""+currencyValidationCode);
				}
			}
			// issuer bin, code, card type, member role and bin aging params
			String s = substring(line, 4, 10);
			Integer issuerBin = parseInt(line, 4, 10);
			// issuer info validation
			if (issuerBin == null) {
				error(errors, recordId, lineID, INVALID_ISSUER_BIN, 3, s);
				line = replace(line, "000000", 4, 10);
				fileDetailDTO.setInput(line);
			}
			else {
				fileDetailDTO.setIssuerBin(issuerBin);
				MemberInfoDTO issuingMember = memberInfoBean.getMemberByBin(issuerBin);
				if (issuingMember != null) {
					fileDetailDTO.setIssuerCode(issuingMember.getBankCode());
					fileDetailDTO.setCardType(issuingMember.getCardType());
					fileDetailDTO.setMemberRole(issuingMember.getMemberRole());
					fileDetailDTO.setDistributionCode(issuingMember.getDistributionCode());
					fileDetailDTO.setDaysBeforefirstDeletionDate(issuingMember.getDaysBeforefirstDeletionDate());
					fileDetailDTO.setDaysBeforefinalDeletionDate(issuingMember.getDaysBeforefinalDeletionDate());

					// card type validation
					if (fileDetailDTO.getCardType() == null || fileDetailDTO.getCardType() == 0) {
						error(errors, recordId, lineID, INVALID_CARD_TYPE, 4, "" + txnCode);
					}
					CardTypeEntity cardType = cardTypes.get(fileDetailDTO.getCardType());

					if ((cardType != null) && (fileDetailDTO.getTxnCode() == 51)
							&& cardType.getCardDescription().contains("MAS")) {
						error(errors, recordId, lineID, INVALID_CARD_TYPE, 4, "" + txnCode);
					}

					// BIN Validation
					if (txnCode > 1 && txnCode < 40) {
						isValid = binValidator.validate(fileDetailDTO, errors);
					}

					if (txnCode > 10 && txnCode < 20) {
						if (EXCLUDED_SUB_SERVICES.contains(subService)) {
							error(errors, recordId, lineID, TRAN_NOT_ALLOWED_FOR_SUBSERV, 4, "" + txnCode);
						}
					}

					if (txnCode > 50 && txnCode < 60) {
						isValid = binValidator.validate(fileDetailDTO, errors);
					}

					// looking for visa chargebacks to validate (1st Presentment)
					if ((txnCode > 10) && (txnCode < 20)) {
						boolean isvalidChargback1 = isValidChargeBackTrxnCode(reasonCodes, reasonCode);
						if (isvalidChargback1) {

						}
						else {
							error(errors, recordId, lineID, REASON_CODE_DOES_NOT_EXIST, 92, "" + txnCode);
						}
					}

					// looking for visa chargebacks to validate(2nd presentment)
					int usageCode = Integer.valueOf(line.substring(146, 147));
					if ((txnCode < 10) && (usageCode > 1)) {
						boolean isvalidChargback2 = isValidChargeBackTrxnCode(reasonCodes, reasonCode);
						if (isvalidChargback2) {
						}
						else {
							error(errors, recordId, lineID, REASON_CODE_DOES_NOT_EXIST, 92, "" + txnCode);
						}

					}

					// account number
					String accountNumber = null;
					if ("FLEET CARD".equals(subService.getDescription())) {
						accountNumber = substring(line, 4, 23);
						fileDetailDTO.setAccountNumber(accountNumber);
					}
					else {
						accountNumber = substring(line, 4, 20);
						fileDetailDTO.setAccountNumber(accountNumber);
					}
					if (!isNumber(accountNumber)) {
						error(errors, recordId, lineID, CARD_NUMBER_NOT_NUMERIC, 4, "" + txnCode);
					}
					// account number length validation
					if (accountNumber.length() < 16) {
						error(errors, recordId, lineID, INVALID_CARD_NUMBER_LENGTH, 4, "" + txnCode);
					}

					// PASA limit validation
					BigDecimal pasaLimit = cardType != null ? cardType.getPasaPaymentLimit() : BigDecimal.ZERO;
					if (fileDetailDTO.getAmount() > pasaLimit.longValue()) {
						error(errors, recordId, lineID, TX_EXCEEDS_PASA_PAYMENT_LIMIT, 14,
								"" + fileDetailDTO.getAmount());
					}
				}
				else {
					// invalid member
					error(errors, recordId, lineID, INVALID_ISSUER_BIN, 4, "" + txnCode);
				}
			}

			String usageCode = substring(line, 146, 147);
			fileDetailDTO.setUsageCode(usageCode);

			TerminalInfo terminalInfo = new TerminalInfo();
			terminalInfo.setTerminalCapability(substring(line, 153, 154));// 161, 163));
			terminalInfo.setPosEntryMode(substring(line, 157, 158));
			String cardIdMethod = substring(line, 159, 160);
			terminalInfo.setCardPresent("2".equals(cardIdMethod) ? "2" : "0");

			fileDetailDTO.setTerminalInfo(terminalInfo);

			// for Fleet Card, get timestamp
			if ("FLEET CARD".equals(subService.getDescription())) {
				fileDetailDTO.setMonthDay(substring(line, 57, 61));
			}

			break;

		case TCR1:

			String chipCard = substring(line, 75, 78);
			String ecommIndicator = substring(line, 115, 116);

			terminalInfo = new TerminalInfo();
			terminalInfo.setChipCard(getChipCardNormalized(chipCard));
			terminalInfo.setEcommIndicator(ecommIndicator.trim().isEmpty() ? "0" : ecommIndicator);

			fileDetailDTO.setTerminalInfo(terminalInfo);

			Long cashbackAmount = parseLong(line, 157, 166);
			fileDetailDTO.setCashbackAmount(cashbackAmount);

			// Calculating the Check digit for American Express Cards.
			// Was difficult to write - is now difficult to read...

			/*
			 * Explanation: The AMEX Merchant SE number consists of a 10 digit number, with the least siginificant being
			 * a check digit. Calculating the check digit is as follows:
			 * 
			 * 1. If the 3 most siginifacant digits are more than 939, or less than 930, the most significant digit
			 * changes to a zero. 2. Add the numeric vales of each of the unevent place digits, couting from right the
			 * left (ie: 10,9,8,7,6,5,4,3,2,1) 1234567890 ^digit 10 ^digit 9 ^digit 8 ^digit 7 ^digit 6 ^digit 5 ^digit
			 * 4 ^digit 3 ^digit 2 ^digit 1 therefore: 2 + 4 + 6 + 8 (being digits 9,7,5 and 3) = 20 (total1) 3. Using
			 * the same counting, multiply each of the even number digits by 2. If the result is greater than 9, add the
			 * seperate digits of the result: 1 * 2 = 2 3 * 2 = 6 5 * 2 = 10 = 1 + 0 = 1 7 * 2 = 14 = 1 + 4 = 5 Add
			 * these values: 2 + 6 + 1 + 5 = 14. (total2) 4. Add total1 and total2: 20 + 14 = 34 5. If the sum of total1
			 * and total2 is not a multiple of 10, calc the difference between the sum and the following multi of 10,
			 * like so: 40 - 34 = 6. 6. The check digit must be equal to this digit. (in the example 0 is not = to 6 and
			 * is therefore invalid.) Go to ANNEXURE D on the AMEX Clearing and Settlement Technical Specifications V2.0
			 * for more informations. spec url :/DMCS_FileLoader/spec/AMEX Clearing and Settlement Technical
			 * Specifications v2.0.docx
			 */

			if ("AMEX".equals(subService.getDescription())) {
				String tmpMercSE = substring(line, 80, 90);
				int mSEl3 = 0;

				if (!isNumber(tmpMercSE)) {
					error(errors, recordId, lineID, INVALID_AMEX_MERCHANT_SE, 4, "" + tmpMercSE);
					break;
				}
				else {
					mSEl3 = Integer.parseInt(tmpMercSE.substring(0, 3));
				}

				if (mSEl3 < 930 || mSEl3 > 939) {
					tmpMercSE = "0" + tmpMercSE.substring(1, 10);
				}
				int lastDig = Integer.parseInt(tmpMercSE.substring(9, 10));
				int cdvTot;
				cdvTot = Integer.parseInt(tmpMercSE.substring(1, 2));
				cdvTot += Integer.parseInt(tmpMercSE.substring(3, 4));
				cdvTot += Integer.parseInt(tmpMercSE.substring(5, 6));
				cdvTot += Integer.parseInt(tmpMercSE.substring(7, 8));

				int multRest;
				int tmpNum;
				int cdvTot2 = 0;
				for (int xx = 0; xx < 5; xx++) {
					multRest = Integer.parseInt(tmpMercSE.substring(xx * 2, (xx * 2) + 1)) * 2;
					if (multRest > 9) {
						tmpNum = (multRest / 10);
						tmpNum += multRest - 10;
					}
					else {
						tmpNum = multRest;
					}
					cdvTot2 += tmpNum;
				}
				cdvTot2 += cdvTot;
				int tmpTot;
				tmpTot = cdvTot2 / 10;
				tmpTot = tmpTot * 10;
				int cdvRes;
				if ((cdvTot2 - tmpTot) == 0) {
					cdvRes = 0;
				}
				else {
					cdvRes = cdvTot2 / 10;
					cdvRes += 1;
					cdvRes = cdvRes * 10;
					cdvRes = cdvRes - cdvTot2;
				}
				if (cdvRes != lastDig) {
					error(errors, recordId, lineID, INVALID_AMEX_MERCHANT_SE, 4, "" + tmpMercSE);
				}
			}

			break;
		case TCR3:
			// for Fleet Card, get timestamp
			if ("FLEET CARD".equals(subService.getDescription())) {
				fileDetailDTO.setTimeString(substring(line, 18, 24));
			}
			break;
		case TCR5:
			break;
		case TCR7:
			break;
		default:
			break;
		}

		isValid = !hasErrors(initErrorCount, errors.size());
		fileDetailDTO.setStatus(isValid ? "C" : "R");

		return fileDetailDTO;
	}

	public boolean isValidTransactionCode(Integer txnCode) {

		return BinarySearch.search(txnCode, txnTypes, txnTypes.length);
	}

	public static boolean isValidChargeBackTrxnCode(List<VisaChargeBacksEntity> arr, String targetValue) {

		for (VisaChargeBacksEntity s : arr) {

			if (s.getReasonCode().equals(targetValue)) {
				return true;
			}
		}
		return false;
	}

}
