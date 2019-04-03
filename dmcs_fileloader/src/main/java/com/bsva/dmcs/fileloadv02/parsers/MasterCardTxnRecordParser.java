package com.bsva.dmcs.fileloadv02.parsers;

import com.bsva.dao.v02.CardTypesDAO;
import com.bsva.dao.v02.TransactionTypesDAO;

import com.bsva.dao.v02.billing.CashbackAcceptorsDAO;
import com.bsva.dao.v02.fileloader.MCardChargeBacksReasonCodeDAO;
import com.bsva.dao.v02.fileloader.TxnCodeMappingDAO;
import com.bsva.dmcs.fileloadv02.dto.*;
import com.bsva.dmcs.fileloadv02.dto.Justification;
import com.bsva.dmcs.fileloadv02.indexer.MastercardPDSReader;
import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.dmcs.fileloadv02.model.MemberInfoBean;
import com.bsva.dmcs.fileloadv02.model.TCRCode;
import com.bsva.dmcs.fileloadv02.model.TerminalInfo;
import com.bsva.dmcs.fileloadv02.util.BinarySearch;
import com.bsva.dmcs.fileloadv02.util.StringUtils;
import com.bsva.dmcs.fileloadv02.util.VISAParserUtils;
import com.bsva.dmcs.fileloadv02.validators.BINValidator;
import com.bsva.dto.ErrorDTO;
import com.bsva.entities.v02.commons.CardTypeEntity;
import com.bsva.entities.v02.loader.McardChargeBacksEntity;
import com.bsva.entities.v02.loader.McardChargeBacksEntity_PK;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static com.bsva.dmcs.fileloadv02.util.MathUtils.isNumber;
import static com.bsva.dmcs.fileloadv02.util.StringUtils.*;
import static com.bsva.dmcs.reportv02.util.StringUtils.parseInt;
import static com.bsva.dmcs.reportv02.util.StringUtils.parseLong;
import static com.bsva.dto.ErrorCode.*;

/**
 * Constructs a MasterCard TCR object from a string
 */
@SuppressWarnings("unused")
public class MasterCardTxnRecordParser extends TxnRecordParser {

	private final Integer[] txnTypes;

	private final Map<Integer, CardTypeEntity> cardTypes;

	private final List<SubService> EXCLUDED_SUB_SERVICES;

	private final BINValidator binValidator;

	private final MastercardPDSReader mastercardPDSReader;

	private final Map<McardChargeBacksEntity_PK, McardChargeBacksEntity> mcardCahrgebacks;

	private final static Map<String, Integer> TXN_CODE_NORMALISER;
	static {
		TXN_CODE_NORMALISER = new TxnCodeMappingDAO().txnCodeMap();
	}

	private final List<Integer> cashbackAcceptors;

	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyMMdd");

	public MasterCardTxnRecordParser() {

		// txn types
		this.txnTypes = new TransactionTypesDAO().txnTypes();
		// card types
		this.cardTypes = new CardTypesDAO().cardTypes();
		// excluded sub services
		this.EXCLUDED_SUB_SERVICES = VISAParserUtils.excludedSubServices();
		// bin validator
		binValidator = new BINValidator();
		// cashback acceptors
		cashbackAcceptors = new CashbackAcceptorsDAO().cashbackAcceptor();
		// PDS payload reader
		mastercardPDSReader = new MastercardPDSReader();

		mcardCahrgebacks = new MCardChargeBacksReasonCodeDAO().getMCardReasonCodes();
	}

	public FileDetailDTO parse(AtomicLong fileSeqNumber, AtomicLong txnSeqNumber, String line, Long lineID,
			MemberInfoBean memberInfoBean, SubService subService, List<ErrorDTO> errors) {

		boolean isValid = true;
		int initErrorCount = errors.size();

		String recordId = substring(line, 0, 2);
		Integer txnCode = parseInt(line, 0, 2);
		Integer tcrId = parseInt(line, 2, 4);
		TCRCode tcrCode = TCRCode.TCR0;

		// read txn code
		String mastercardTxnCode = substring(line, 175, 177);

		FileDetailDTO fileDetailDTO = new FileDetailDTO(fileSeqNumber, txnSeqNumber, line, lineID, txnCode, tcrCode);
		fileDetailDTO.setInputLength(line.length());

		switch (tcrCode) {

		case TCR0:

			// validate txn code
			if (!isValidTransactionCode(txnCode)) {
				error(errors, recordId, lineID, TRAN_CODE_DOES_NOT_EXIST, 1, "" + txnCode);
			}

			// acquirer bin, code
			Integer acquirerBin = parseInt(line, 368, 374);// acquirermember
			if (acquirerBin != null) {
				fileDetailDTO.setAcquirerBin(acquirerBin);

				MemberInfoDTO acquiringMember = memberInfoBean.getMemberByBin(acquirerBin);
				if (acquiringMember != null) {
					fileDetailDTO.setAcquirerCode(acquiringMember.getBankCode());
				}
			}
			else {
				error(errors, recordId, lineID, INVALID_ACQUIRER_BIN, 2, "" + txnCode);
			}
			// acquirer info validation
			if (acquirerBin == null) {
				error(errors, recordId, lineID, INVALID_ACQUIRER_BIN, 2, "" + txnCode);
			}

			String amountValue = line.substring(181, 193);
			String valueAmount = amountValue.replace("-", "").replace(".", "");
			// amount
			Long valueAmountLong = Long.parseLong(amountValue);
			Long amount = parseLong(line, 181, 193);
			if (valueAmountLong != null ) {
				fileDetailDTO.setAmount(amount);
			}
			else {
				error(errors, recordId, lineID, AMOUNT_NOT_NUMERIC, 4, "" + txnCode);
			}

			// issuer bin, code, card type, member role and bin aging params
			String s = substring(line, 156, 162);// issuermember
			Integer issuerBin = parseInt(line, 156, 162);
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

					// account number
					String accountNumber = substring(line, 156, 172);
					fileDetailDTO.setAccountNumber(accountNumber);
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

					// txn local date
					try {
						String localDate = line.substring(257, 263);
						fileDetailDTO.setDateTime(DATE_FORMAT.parse(localDate));
					}
					catch (ParseException e) {
						System.out.println("ERROR LOCAL TXN DATE INVALID: ");
					}

					// billing info
					String posData = substring(line, 298, 310);
					String posDataAdditional = substring(line, 815, 839);

					Integer billingTxnCode = TXN_CODE_NORMALISER.get(mastercardTxnCode);

					// read mti
					String mti = substring(line, 150, 154);

					// adjust txn code
					switch (mti) {
					case "1442":
						billingTxnCode += 10;
						break;
					case "1240":
						break;
					}
					fileDetailDTO.setMessageTypeIndicator(mti);
					String primaryBitMap = substring(line, 23, 67);
					//if (primaryBitMap == null) {
					if (primaryBitMap.length() > 0) {
						fileDetailDTO.setPrimaryBitmap(primaryBitMap);
					}
					else if(primaryBitMap.length() <= 0){
						fileDetailDTO.setPrimaryBitmap("0000000000000000000000000000000000000000000000000000000000000000");
						error(errors, recordId, lineID, INVALID_BITMAP, 91, "" + txnCode);
					}

					String secondaryBitMap = substring(line, 67, 131);
					fileDetailDTO.setSecondaryBitmap(secondaryBitMap);
					String processingCode = substring(line, 175, 181);
					fileDetailDTO.setProcessingCode(processingCode);
					// started here
					fileDetailDTO.setRecordId(recordId);
					String p12LocalDate = substring(line, 257, 263);
					fileDetailDTO.setP12LocalDate(p12LocalDate);
					String transactionCode = "" + txnCode;
					fileDetailDTO.setTransactionCode(transactionCode);
					String p4TransAmount = substring(line, 195, 207);
					fileDetailDTO.setP4transAmount(p4TransAmount);
					String p38ApprovalCode = substring(line, 268, 374);
					fileDetailDTO.setP38approvalCode(p38ApprovalCode);
					String p43CardAcceptorName = substring(line, 573, 672);
					fileDetailDTO.setP43cardAcceptorName(p43CardAcceptorName);
					String p26CardAcceptorBusCode = substring(line, 277, 281);
					fileDetailDTO.setP26CardAcceptorBusCode(p26CardAcceptorBusCode);
					// String p25MessageReason = substring(line, 273, 277);//Renoved after implementing 2nd presentment
					// on MCI.
					String p25MessageReason = substring(line, 316, 320);
					fileDetailDTO.setP25MessageReasonCode(p25MessageReason);
					String p30OriginalAmount = substring(line, 281, 305);
					fileDetailDTO.setP30OriginalAmount(p30OriginalAmount);
					fileDetailDTO.setSystemSeqNumber("" + txnSeqNumber);
					String p24FunctionCode = substring(line, 313, 316);// functionCode
					fileDetailDTO.setP24FunctionCode(p24FunctionCode);
					// fileDetailDTO.setFinancialIndicator(financialIndicator);
					// fileDetailDTO.setProcessStatus(processStatus);
					fileDetailDTO.setSystemSeqNumber2("" + fileSeqNumber);

					String p5ReconciliationAmount = substring(line, 193, 205);
					fileDetailDTO.setP5ReconciliationAmount(p5ReconciliationAmount);
					String messageReasonCode = substring(line, 316, 320);
					fileDetailDTO.setMessageReasonCode(messageReasonCode);
					String cardAcceptorbusCode = substring(line, 320, 324);
					fileDetailDTO.setCardAcceptorbusCode(cardAcceptorbusCode);
					String retrievalRefNumber = substring(line, 526, 532);
					fileDetailDTO.setRetrievalRefNumber(retrievalRefNumber);
					String approvalCode = substring(line, 538, 544);
					fileDetailDTO.setApprovalCode(approvalCode);
					String icclength = substring(line, 1132, 1135);
					fileDetailDTO.setIcclength(icclength);
					String iccSystemRelatedData = substring(line, 270, 273);
					fileDetailDTO.setIccSystemRelatedData(iccSystemRelatedData);
					String p2PanLength = substring(line, 154, 156);
					fileDetailDTO.setP2PanLength(p2PanLength);
					String p2Pan = substring(line, 156, 172);
					fileDetailDTO.setP2Pan(p2Pan);
					String p12localDate = substring(line, 257, 263);
					fileDetailDTO.setP12localDate(p12localDate);
					String p13localTime = substring(line, 263, 269);
					fileDetailDTO.setP13localTime(p13localTime);
					String pointOfSaleData = substring(line, 298, 310);
					fileDetailDTO.setPointOfSaleData(pointOfSaleData);
					String cardAcceptorTerminalId = substring(line, 548, 556);
					fileDetailDTO.setCardAcceptorTerminalId(cardAcceptorTerminalId);
					String cardAcceptorId = substring(line, 556, 568);
					fileDetailDTO.setCardAcceptorId(cardAcceptorId);
					String functionCode = substring(line, 313, 316);
					fileDetailDTO.setFunctionCode(functionCode);
					String acquirerRefLength = substring(line, 365, 367);
					fileDetailDTO.setAcquirerRefLength(acquirerRefLength);
					String p31AcquirerRefData = substring(line, 367, 390); // 368, 391);
					fileDetailDTO.setP31AcquirerRefData(p31AcquirerRefData);
					String code = substring(line, 545, 548);
					fileDetailDTO.setCode(code);
					String cardAcceptorLength = substring(line, 571, 273);
					fileDetailDTO.setCardAcceptorLength(cardAcceptorLength);
					String p26cardAcceptorName = substring(line, 573, 620);
					fileDetailDTO.setP26cardAcceptorName(p26cardAcceptorName);
					String additionalDataLength = substring(line, 816, 818);
					fileDetailDTO.setAdditionalDataLength(additionalDataLength);
					String additionalData = substring(line, 818, 1068);
					fileDetailDTO.setAdditionalData(additionalData);
					String p20currencyCode = substring(line, 1068, 1071);
					fileDetailDTO.setP20currencyCode(p20currencyCode);
					String reconcilliationCode = substring(line, 1071, 1074);
					fileDetailDTO.setReconcilliationCode(reconcilliationCode);
					String messageNumber = substring(line, 1485, 1491);
					fileDetailDTO.setMessageNumber(messageNumber);
					String s70NetworkmanCountryCode = substring(line, 1495, 1503);
					fileDetailDTO.setS70NetworkmanCountryCode(s70NetworkmanCountryCode);
					String s72Datalen = substring(line, 1504, 1507);
					fileDetailDTO.setS72Datalen(s72Datalen);
					String s72DataRecord = substring(line, 1508, 1608);
					fileDetailDTO.setS72DataRecord(s72DataRecord);
					String s73Actiondate = substring(line, 1609, 1611);
					fileDetailDTO.setS73Actiondate(s73Actiondate);
					String s74NoofCredits = substring(line, 1616, 1626);
					fileDetailDTO.setS74NoofCredits(s74NoofCredits);
					String s75ReversalNoofCredits = substring(line, 1627, 1637);
					fileDetailDTO.setS75ReversalNoofCredits(s75ReversalNoofCredits);
					String s76NoofDebits = substring(line, 1638, 1648);
					fileDetailDTO.setS76NoofDebits(s76NoofDebits);
					String s77ReversalNoofDebits = substring(line, 1649, 1659);
					fileDetailDTO.setS77ReversalNoofDebits(s77ReversalNoofDebits);
					String s78NumberTransfers = substring(line, 1660, 1670);
					fileDetailDTO.setS78NumberTransfers(s78NumberTransfers);
					String s79ReversalNumberTransfers = substring(line, 1671, 1681);
					fileDetailDTO.setS79ReversalNumberTransfers(s79ReversalNumberTransfers);
					String s80NumberEnquiries = substring(line, 1682, 1692);
					fileDetailDTO.setS80NumberEnquiries(s80NumberEnquiries);
					String s81NumberAuthorisations = substring(line, 1693, 1703);
					fileDetailDTO.setS81NumberAuthorisations(s81NumberAuthorisations);
					String s82ProcessingFeeCredits = substring(line, 1704, 1716);
					fileDetailDTO.setS82ProcessingFeeCredits(s82ProcessingFeeCredits);
					String s83TransactionfeeCredits = substring(line, 1717, 1729);
					fileDetailDTO.setS83TransactionfeeCredits(s83TransactionfeeCredits);
					String s84ProcessingFeeDebits = substring(line, 1730, 1742);
					fileDetailDTO.setS84ProcessingFeeDebits(s84ProcessingFeeDebits);
					String s85TransctionfeeAmounts = substring(line, 1743, 1755);
					fileDetailDTO.setS85TransctionfeeAmounts(s85TransctionfeeAmounts);
					String s86AmountCredits = substring(line, 1756, 1772);
					fileDetailDTO.setS86AmountCredits(s86AmountCredits);
					String s87ReversalAmountCredits = substring(line, 1734, 1750);
					fileDetailDTO.setS87ReversalAmountCredits(s87ReversalAmountCredits);
					String s88AmountDebits = substring(line, 1751, 1767);
					fileDetailDTO.setS88AmountDebits(s88AmountDebits);
					String s89ReversalAmountDebits = substring(line, 1768, 1784);
					fileDetailDTO.setS89ReversalAmountDebits(s89ReversalAmountDebits);
					String s90OriginatingDataElements = substring(line, 1785, 1801);
					fileDetailDTO.setS90OriginatingDataElements(s90OriginatingDataElements);
					String s91FileUpdateCode = substring(line, 1802, 1803);
					fileDetailDTO.setS91FileUpdateCode(s91FileUpdateCode);
					String s92FilesSecurityCode = substring(line, 1804, 1806);
					fileDetailDTO.setS92FilesSecurityCode(s92FilesSecurityCode);
					String s93Length = substring(line, 1807, 1809);
					fileDetailDTO.setS93Length(s93Length);
					String forwardingInstLength = substring(line, 1824, 1826);
					fileDetailDTO.setForwardingInstLength(forwardingInstLength);
					String forwardingInstCode = substring(line, 1833, 1837);
					fileDetailDTO.setForwardingInstCode(forwardingInstCode);

					String s93TransactionDestInstId = substring(line, 1810, 1821);
					fileDetailDTO.setS93TransactionDestInstId(s93TransactionDestInstId);
					String s94Length = substring(line, 1822, 1824);
					fileDetailDTO.setS94Length(s94Length);
					String s94TransactionorigInstId = substring(line, 1824, 1835);
					fileDetailDTO.setS94TransactionorigInstId(s94TransactionorigInstId);
					String s95CardIssrefDataLength = substring(line, 1835, 1837);
					fileDetailDTO.setS95CardIssrefDataLength(s95CardIssrefDataLength);
					String s95CardIssuerRefData = substring(line, 1837, 1849);
					fileDetailDTO.setS95CardIssuerRefData(s95CardIssuerRefData);
					String s96MessageSecuritycode = substring(line, 1849, 1865);
					fileDetailDTO.setS96MessageSecuritycode(s96MessageSecuritycode);
					String s97NetSettlementAmount = substring(line, 1865, 1881);
					fileDetailDTO.setS97NetSettlementAmount(s97NetSettlementAmount);
					String s98Payee = substring(line, 1881, 2006);
					fileDetailDTO.setS98Payee(s98Payee);
					String s99SettlementInstidCode = substring(line, 1906, 1908);
					fileDetailDTO.setS99SettlementInstidCode(s99SettlementInstidCode);
					String s100Riilen = substring(line, 1917, 1919);
					fileDetailDTO.setS100Riilen(s100Riilen);
					String s100RcvingInstidCode = substring(line, 1919, 1930);
					fileDetailDTO.setS100RcvingInstidCode(s100RcvingInstidCode);
					String s101Filename = substring(line, 1930, 1934);
					fileDetailDTO.setS101Filename(s101Filename);
					String s102AccountIdentification1 = substring(line, 1934, 1962);
					fileDetailDTO.setS102AccountIdentification1(s102AccountIdentification1);
					String s103AccountIdentification2 = substring(line, 1962, 1990);
					fileDetailDTO.setS103AccountIdentification2(s103AccountIdentification2);
					String s104TransactionDescription = substring(line, 1990, 2010);
					fileDetailDTO.setS104TransactionDescription(s104TransactionDescription);
					String s111Len = substring(line, 2020, 2023);
					fileDetailDTO.setS111Len(s111Len);
					String s111AmtcurrencyConversion = substring(line, 2023, 2035);
					fileDetailDTO.setS111AmtcurrencyConversion(s111AmtcurrencyConversion);
					String s123Addlen = substring(line, 2035, 2038);
					fileDetailDTO.setS123Addlen(s123Addlen);
					String s123AdditionalData = substring(line, 2038, 2081);
					fileDetailDTO.setS123AdditionalData(s123AdditionalData);
					String s124Addlen = substring(line, 2081, 2084);
					fileDetailDTO.setS124Addlen(s124Addlen);
					String s124AdditionalData = substring(line, 2084, 2127);
					fileDetailDTO.setS123AdditionalData(s123AdditionalData);
					String s125Addlen = substring(line, 2127, 2130);
					fileDetailDTO.setS125Addlen(s125Addlen);
					String s125AdditionalData = substring(line, 2130, 2173);
					fileDetailDTO.setS125AdditionalData(s125AdditionalData);
					String s127Addlen = substring(line, 2173, 2176);
					fileDetailDTO.setS127Addlen(s127Addlen);
					String s127NetworkData = substring(line, 2176, 2219);
					fileDetailDTO.setS127NetworkData(s127NetworkData);

					// read mti
					String mti1 = substring(line, 150, 154);
					String p24FunctionCode1 = substring(line, 313, 316);// functionCode
					String p25MessageReasonCodes = substring(line, 316, 320).trim();
					// Chargeback First Presntment (MCI)
					if ("1442".equals(mti1)) {
						// MCI chargebacks validations
						if (p24FunctionCode1.equals("450") || p24FunctionCode1.equals("451")
								|| p24FunctionCode1.equals("453") || p24FunctionCode1.equals("454")) {
							List<McardChargeBacksEntity> searchReasonCode = new MCardChargeBacksReasonCodeDAO()
									.fetchReasonCodes(Integer.valueOf(mti1), Integer.valueOf(p24FunctionCode1),
											Integer.valueOf(p25MessageReasonCodes));
							if (searchReasonCode.isEmpty()) {
								error(errors, recordId, lineID, REASON_CODE_DOES_NOT_EXIST, 4, "");
							}
						}
					}
					// Chargeback Second Presentment (MCI)
					if ("1240".equals(mti1)) {
						// MCI chargebacks validations
						if (p24FunctionCode1.equals("205") || p24FunctionCode1.equals("282")) {
							List<McardChargeBacksEntity> searchReasonCode = new MCardChargeBacksReasonCodeDAO()
									.fetchReasonCodes(Integer.valueOf(mti1), Integer.valueOf(p24FunctionCode1),
											Integer.valueOf(p25MessageReasonCodes));
							if (searchReasonCode.isEmpty()) {
								error(errors, recordId, lineID, REASON_CODE_DOES_NOT_EXIST, 4, "");
							}
						}
					}

					// parse PDS payloads
					List<MastercardPDSDTO> pdsList = MastercardPDSReader.read(txnSeqNumber.longValue(), line);
					fileDetailDTO.setPdsList(pdsList);

					// check if this a reversal txn
					boolean isReversal = false;
					//String pdsNumber = substring(line, 818, 822);
					for (MastercardPDSDTO mastercardPDSDTO : pdsList) {
						if (25 == mastercardPDSDTO.getPdsNumber()) {
							isReversal = mastercardPDSDTO.getPdsData().startsWith("R");
							if(!isReversal){
								error(errors, recordId, lineID, INVALID_PDS_0025_REVERSAL, 4, "" + txnCode);
							}else{
								isReversal = true;
							}
						}
					}

					boolean hasCashBack = false;
					if (isReversal && ("1240".equals(mti) || "1442".equals(mti))) {
						billingTxnCode += 20;
					}

					// charge back
					Integer cardAcceptor = StringUtils.parseInt(substring(line, 320, 324));
					boolean mccPresent = cashbackAcceptors.contains(cardAcceptor);

					Long cashBackAmount = null;

					// check if there is cash back amount
					if ("09".equals(mastercardTxnCode) && ("1240".equals(mti) || "1442".equals(mti))) {
						cashBackAmount = parseLong(line, 1121, 1132);
						if (cashBackAmount > 0.00) {
							hasCashBack = true;
						}
						else {
							hasCashBack = false;
						}
						fileDetailDTO.setCashbackAmount(cashBackAmount);
						fileDetailDTO.setCashBackPresent(hasCashBack);
					}

					if (("1240".equals(mti) || "1442".equals(mti)) && "01".equals(mastercardTxnCode) && !mccPresent) {
						cashBackAmount = amount;
						hasCashBack = true;
						billingTxnCode -= 2;
						fileDetailDTO.setCashbackAmount(cashBackAmount);
						fileDetailDTO.setCashBackPresent(hasCashBack);
					}
					fileDetailDTO.setBillingTxnCode(billingTxnCode);
					String serviceCode = substring(line, 545, 548);
					TerminalInfo terminalInfo = new TerminalInfo();
					terminalInfo.setTerminalCapability(substring(posData, 0, 1));
					terminalInfo.setCardPresent(substring(posData, 5, 6));
					terminalInfo.setPosEntryMode(substring(posData, 6, 7));
					terminalInfo.setChipCard(substring(serviceCode, 0, 1));
					String ecommInd = substring(posDataAdditional, 3, 4);
					terminalInfo.setEcommIndicator(!ecommInd.trim().isEmpty() ? ecommInd : "0");
					fileDetailDTO.setTerminalInfo(terminalInfo);
					// setEcommIndicatorIfPDS52Exists(pdsList, terminalInfo);
				}
				else {
					error(errors, recordId, lineID, INVALID_ISSUER_BIN, 3, s);
				}
			}

			break;
		default:
			break;
		}

		isValid = !

		hasErrors(initErrorCount, errors.size());
		fileDetailDTO.setStatus(isValid ? "C" : "R");
		

		return fileDetailDTO;
	}

	private void setEcommIndicatorIfPDS52Exists(List<MastercardPDSDTO> pdsList, TerminalInfo terminalInfo) {
		// does P052 exists
		for (MastercardPDSDTO pds : pdsList) {
			if (pds.getPdsNumber().intValue() == 52) {
				// set ecomm indicator
				String d = pds.getPdsData();
				if (d.length() > 2) {
					terminalInfo.setEcommIndicator(d.substring(2, 3));
				}
			}
		}
	}

	private MastercardPDFControlDTO addNextPdsElement(int currentIdx, String pdsPayload, FileDetailDTO fileDetailDTO) {

		// 014800471020165001M
		Long txnSeqNumber = fileDetailDTO.getTxnSeqNumber().longValue();
		Integer pdsNumber = parseInt(pdsPayload, currentIdx + 0, 2);
		Integer pdsLen = parseInt(pdsPayload, currentIdx + 2, 4);
		Integer payloadLen = pdsPayload.length();
		String pdsData = substring(pdsPayload, currentIdx + 4, pdsLen < payloadLen ? pdsLen : payloadLen);
		MastercardPDSDTO pds = new MastercardPDSDTO(txnSeqNumber, pdsNumber, pdsData.length(), pdsData);

		fileDetailDTO.getPdsList().add(pds);

		// control record
		boolean isLastElement = payloadLen <= pdsLen;
		currentIdx += (4 + pdsLen);
		MastercardPDFControlDTO controlDTO = new MastercardPDFControlDTO();
		controlDTO.setIsLastElement(isLastElement);
		controlDTO.setCurrentIdx(currentIdx);

		return controlDTO;
	}

	public boolean isValidTransactionCode(Integer txnCode) {

		return BinarySearch.search(txnCode, txnTypes, txnTypes.length);
	}

}
