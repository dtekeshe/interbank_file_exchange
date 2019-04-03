//package com.bsva.dmcs.fileloadv02.parsers;
//
//import static com.bsva.dmcs.fileloadv02.util.MathUtils.isNumber;
//import static com.bsva.dmcs.fileloadv02.util.VISAParserUtils.getChipCardNormalized;
//import static com.bsva.dmcs.fileloadv02.util.StringUtils.parseInt;
//import static com.bsva.dmcs.fileloadv02.util.StringUtils.substring;
//import static com.bsva.dmcs.fileloadv02.util.StringUtils.parseBigDecimal;
//import static com.bsva.dmcs.fileloadv02.util.XMLMarshaller.marshall;
//
//import com.bsva.dao.v02.CardTypesDAO;
//import com.bsva.dao.v02.TransactionTypesDAO;
//import com.bsva.dmcs.fileloadv02.dto.*;
//import com.bsva.dmcs.fileloadv02.model.MemberInfoBean;
//import com.bsva.dmcs.fileloadv02.model.TCR;
//import com.bsva.dmcs.fileloadv02.model.TCRCode;
//import com.bsva.dmcs.fileloadv02.model.TerminalInfo;
//import com.bsva.dmcs.fileloadv02.util.BinarySearch;
//import com.bsva.dmcs.fileloadv02.util.VISAParserUtils;
//import com.bsva.dmcs.fileloadv02.validators.BINValidator;
//import com.bsva.dto.ErrorCode;
//import com.bsva.entities.v02.commons.CardTypeEntity;
//
//import java.io.PrintWriter;
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Map;
//
///**
// * Constructs a VISA TCR object from a string
// */
//public class VISATCRStringParser {
//
//    private final Integer[] txnTypes;
//    private final Map<Integer, CardTypeEntity> cardTypes;
//    private final List<SubService> EXCLUDED_SUB_SERVICES;
//
//    public VISATCRStringParser() {
//
//        // txn types
//        this.txnTypes = new TransactionTypesDAO().txnTypes();
//        // card types
//        this.cardTypes = new CardTypesDAO().cardTypes();
//        // excluded sub services
//        this.EXCLUDED_SUB_SERVICES = VISAParserUtils.excludedSubServices();
//    }
//
//    public TCR parse(
//            Long fileSeqNumber,
//            Long txnSeqNumber,
//            Long paySeqNumber,
//            String line,
//            Long lineID,
//            MemberInfoBean memberInfoBean,
//            SubService subService,
//            PrintWriter reportOut) {
//
//        boolean isValid = true;
//
//        Integer txnCode = parseInt(line.substring(0, 2).trim());
//        Integer tcrId = parseInt(line.substring(2, 4).trim());
//        TCRCode tcrCode = TCRCode.instance(tcrId);
//
//        TCR tcr = new TCR( fileSeqNumber, txnSeqNumber, paySeqNumber, line, lineID, txnCode, tcrCode );
//
//        switch(tcrCode) {
//
//            case TCR0: // Financial Transaction Control Record.
//
//                // validate txn code
//                if ( ! isValidTransactionCode(txnCode) ) {
//
//                    reportOut.println(
//                            marshall(new ErrorDTO(
//                                    txnCode, lineID, 4, ErrorCode.TRAN_CODE_DOES_NOT_EXIST.getName(), null)));
//
//                    isValid = false;
//                }
//
//                // acquirer bin, code
//                Integer acquirerBin = parseInt(substring(line, 27, 33));
//                tcr.setAcquirerBin(acquirerBin);
//                MemberInfoDTO acquiringMember = memberInfoBean.getMemberByBin(acquirerBin);
//                tcr.setAcquirerCode(acquiringMember.getBankCode());
//                // acquirer info validation
//                if ( acquirerBin == null ) {
//                    reportOut.println(
//                            marshall(new ErrorDTO(
//                                    txnCode, lineID, 4, ErrorCode.INVALID_ACQUIRER_BIN.getName(), null)));
//                    isValid = false;
//                }
//
//                // issuer bin, code, card type, member role and bin aging params
//                Integer issuerBin = parseInt( substring( line, 4, 10 ) );
//                tcr.setIssuerBin(issuerBin);
//                MemberInfoDTO issuingMember = memberInfoBean.getMemberByBin(issuerBin);
//                tcr.setIssuerCode(issuingMember.getBankCode());
//                tcr.setCardType(issuingMember.getCardType());
//                tcr.setMemberRole(issuingMember.getMemberRole());
//                tcr.setDistributionCode(issuingMember.getDistributionCode());
//                tcr.setDaysBeforefirstDeletionDate(issuingMember.getDaysBeforefirstDeletionDate());
//                tcr.setDaysBeforefinalDeletionDate(issuingMember.getDaysBeforefinalDeletionDate());
//
//                // issuer info validation
//                if ( issuerBin == null) {
//
//                    reportOut.println(
//                            marshall(new ErrorDTO(
//                                    txnCode, lineID, 4, ErrorCode.INVALID_ISSUER_BIN.getName(), null)));
//                    isValid = false;
//                }
//
//                // card type validation
//                if (tcr.getCardType() == null || tcr.getCardType() == 0) {
//
//                    reportOut.println(
//                            marshall(new ErrorDTO(
//                                    txnCode, lineID, 4, ErrorCode.INVALID_CARD_TYPE.getName(), null)));
//                    isValid = false;
//                }
//                CardTypeEntity cardType = cardTypes.get(tcr.getCardType());
//                if ( (cardType != null)
//                        && (tcr.getTxnCode() == 51)
//                        && cardType.getCardDescription().contains("MAS")) {
//
//                    reportOut.println(
//                            marshall(new ErrorDTO(
//                                    txnCode, lineID, 1, ErrorCode.INVALID_CARD_TYPE.getName(), null)));
//                    isValid = false;
//                }
//
//                // BIN Validation
//                if ( txnCode > 1 && txnCode < 40 ) {
//                    isValid = BINValidator.validate(tcr, reportOut);
//                }
//
//                if ( txnCode > 10 && txnCode < 20 ) {
//                    if (EXCLUDED_SUB_SERVICES.contains(subService)) {
//
//                        reportOut.println(
//                                marshall(new ErrorDTO(
//                                        txnCode, lineID, 7, ErrorCode.TRAN_NOT_ALLOWED_FOR_SUBSERV.getName(), null)));
//
//                        isValid = false;
//                    }
//                }
//
//                if ( txnCode > 50 && txnCode < 60 ) {
//                    isValid = BINValidator.validate(tcr, reportOut);
//                }
//
//                // account number
//                String accountNumber = substring(line, 4, 20);
//                tcr.setAccountNumber(accountNumber);
//                if ( ! isNumber( accountNumber ) ) {
//
//                    reportOut.println(
//                            marshall(new ErrorDTO(
//                                    txnCode, lineID, 4, ErrorCode.CARD_NUMBER_NOT_NUMERIC.getName(), null)));
//
//                    isValid = false;
//                }
//                // account number length validation
//                if ( accountNumber.length() < 16 ) {
//
//                    reportOut.println(
//                            marshall(new ErrorDTO(
//                                    txnCode, lineID, 4, ErrorCode.INVALID_CARD_NUMBER_LENGTH.getName(), null)));
//
//                    isValid = false;
//                }
//
//                // amount
//                BigDecimal amount = parseBigDecimal(substring(line, 76, 88));
//                if ( amount  == null ) {
//
//                    reportOut.println(
//                            marshall(new ErrorDTO(
//                                    txnCode, lineID, 10, ErrorCode.AMOUNT_NOT_NUMERIC.getName(), null)));
//                    isValid = false;
//                }
//                tcr.setAmount(amount);
//
//                // PASA limit validation
//                BigDecimal pasaLimit = cardType != null ? cardType.getPasaPaymentLimit() : BigDecimal.ZERO;
//                if (tcr.getAmount().compareTo(pasaLimit) == 1) {
//
//                    reportOut.println(
//                            marshall(new ErrorDTO(
//                                    txnCode, lineID, 14, ErrorCode.TX_EXCEEDS_PASA_PAYMENT_LIMIT.getName(), null)));
//                    isValid = false;
//                }
//
//                String usageCode = substring(line, 146, 147);
//                tcr.setUsageCode(usageCode);
//
//                String posEntryMode = substring(line, 161, 163);
//                String terminalCapability = substring( line, 156, 158 );
//                String cardPresent = substring(line, 155, 156);
//
//                TerminalInfo terminalInfo = new TerminalInfo();
//                terminalInfo.setPosEntryMode( posEntryMode );
//                terminalInfo.setTerminalCapability( terminalCapability );
//                terminalInfo.setCardPresent( cardPresent );
//
//                tcr.setTerminalInfo( terminalInfo );
//
//                break;
//
//            case TCR1:
//
//                String chipCard = substring(line, 75, 78);
//                String ecommIndicator = substring(line, 115, 116);
//
//                terminalInfo = new TerminalInfo();
//                terminalInfo.setChipCard( getChipCardNormalized(chipCard) );
//                terminalInfo.setEcommIndicator(ecommIndicator.trim().isEmpty() ? "0" : ecommIndicator);
//
//                tcr.setTerminalInfo(terminalInfo);
//
//                BigDecimal cashbackAmount = parseBigDecimal( substring(line, 157, 166) );
//                tcr.setCashbackAmount( cashbackAmount );
//
//                break;
//
//            case TCR5:
//                break;
//            case TCR7:
//                break;
//            default:
//                break;
//        }
//
//        tcr.setStatus(isValid ? "A" : "R");
//
//        return tcr;
//    }
//
//    public boolean isValidTransactionCode(Integer txnCode) {
//
//        return BinarySearch.search(txnCode, txnTypes, txnTypes.length);
//    }
//}
