package com.bsva.dcms.commons.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsoPaymentInstructionsMcardDao;
import com.bsva.dcms.commons.dto.CsoPaymentInstructionsMcardDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsoPaymentInstructionsMcard;
import com.bsva.entities.CsoPaymentInstructionsMcardPK;

public class CsoPaymentInstructionsMcardDAO {

    //private CsoPaymentInstructionsMcardRepo csoPaymentInstructionsMcardRepoDao = DaoFactory.csoPaymentInstructionsMcardInstance();
    private CsoPaymentInstructionsMcardDao csoPaymentInstructionsMcardDao = new CsoPaymentInstructionsMcardDao();
    //private List<String> map = new ArrayList<String>();
    private Map<String, Object> map = new HashMap<>();

    public CsoPaymentInstructionsMcardDAO() {

    }

    public void create(CsoPaymentInstructionsMcardDTO bean) throws DAOException {

        CsoPaymentInstructionsMcard csoPaymentInstructionsMcard = new CsoPaymentInstructionsMcard();
        CsoPaymentInstructionsMcardPK csoPaymentInstructionsMcardPK = new CsoPaymentInstructionsMcardPK();
        csoPaymentInstructionsMcardPK.setFileRefNumber1(bean.getFileRefNumber1());
        csoPaymentInstructionsMcardPK.setSystemSeqNumber2(bean.getSystemSeqNumber2());

        csoPaymentInstructionsMcard.setCsoPaymentInstructionsMcardPK(csoPaymentInstructionsMcardPK);

        csoPaymentInstructionsMcard.setServiceCode(bean.getServiceCode());
        csoPaymentInstructionsMcard.setSubServiceName(bean.getSubServiceName());
        csoPaymentInstructionsMcard.setAcquirerMember((short) bean.getAcquirerMember());
        csoPaymentInstructionsMcard.setIssuerMember((short) bean.getIssuerMember());
        csoPaymentInstructionsMcard.setMastercardAmount(bean.getMastercardAmount());
        csoPaymentInstructionsMcard.setFinancialIndicator(bean.getFinancialIndicator());
        csoPaymentInstructionsMcard.setPrimaryBitmap(bean.getPrimaryBitmap());
        csoPaymentInstructionsMcard.setSecondaryBitmap(bean.getSecondaryBitmap());
        csoPaymentInstructionsMcard.setMessageTypeIndicator((short) bean.getMessageTypeIndicator());
        csoPaymentInstructionsMcard.setP2PanLength((short) bean.getP2PanLength());
        csoPaymentInstructionsMcard.setP2Pan(bean.getP2Pan());
        csoPaymentInstructionsMcard.setP3ProcessCode(bean.getP3ProcessCode());
        csoPaymentInstructionsMcard.setP4TransactionAmount(bean.getP4TransactionAmount());
        csoPaymentInstructionsMcard.setP5ReconclliationAmount(bean.getP5ReconclliationAmount());
        csoPaymentInstructionsMcard.setP6CardholderBilling(bean.getP6CardholderBilling());
        csoPaymentInstructionsMcard.setP7TransctionDateAndTime(bean.getP7TransctionDateAndTime());
        csoPaymentInstructionsMcard.setP8IccrAmount(bean.getP8IccrAmount());
        csoPaymentInstructionsMcard.setP9ReconConversionRate(bean.getP9ReconConversionRate());
        csoPaymentInstructionsMcard.setP10CardholderConvRate(bean.getP10CardholderConvRate());
        csoPaymentInstructionsMcard.setP11SystemTraceAuditNumber(bean.getP11SystemTraceAuditNumber());
        csoPaymentInstructionsMcard.setP12LocalDate(bean.getP12LocalDate());
        csoPaymentInstructionsMcard.setP13LocalTime((int) bean.getP13LocalTime());
        csoPaymentInstructionsMcard.setP14ExpirationDate(bean.getP14ExpirationDate());
        csoPaymentInstructionsMcard.setP15SettlementDate((short) bean.getP15SettlementDate());
        csoPaymentInstructionsMcard.setP16ConversionDate((short) bean.getP16ConversionDate());
        csoPaymentInstructionsMcard.setP17CaptureDate((short) bean.getP17CaptureDate());
        csoPaymentInstructionsMcard.setP18MerchantType((short) bean.getP18MerchantType());
        csoPaymentInstructionsMcard.setP19AcqBankInstitutionCode((short) bean.getP19AcqBankInstitutionCode());
        csoPaymentInstructionsMcard.setP20CountryCodePriAccNo((short) bean.getP20CountryCodePriAccNo());
        csoPaymentInstructionsMcard.setP21FwdingInstCountryCode((short) bean.getP21FwdingInstCountryCode());
        csoPaymentInstructionsMcard.setP22PointOfSaleData(bean.getP22PointOfSaleData());
        csoPaymentInstructionsMcard.setP23CardSequenceNumber((short) bean.getP23CardSequenceNumber());
        csoPaymentInstructionsMcard.setP24FunctionCode((short) bean.getP24FunctionCode());
        csoPaymentInstructionsMcard.setP25MessageReasonCode((short) bean.getP25MessageReasonCode());
        csoPaymentInstructionsMcard.setP26CardAcceptorBusCode((short) bean.getP26CardAcceptorBusCode());
        csoPaymentInstructionsMcard.setP27AuthIdResponseLength((short) bean.getP27AuthIdResponseLength());
        csoPaymentInstructionsMcard.setP28TransactionFeeAmount(bean.getP28TransactionFeeAmount());
        csoPaymentInstructionsMcard.setP29SettlementFeeAmount(bean.getP29SettlementFeeAmount());
        csoPaymentInstructionsMcard.setP30OriginalAmount(bean.getP30OriginalAmount());
        csoPaymentInstructionsMcard.setP31AcquirerRefLength((short) bean.getP31AcquirerRefLength());
        csoPaymentInstructionsMcard.setP31AcquirerRefData(bean.getP31AcquirerRefData());
        csoPaymentInstructionsMcard.setP32AcquiringInstLength((short) bean.getP32AcquiringInstLength());
        csoPaymentInstructionsMcard.setP32AcquiringInstCode(bean.getP32AcquiringInstCode());
        csoPaymentInstructionsMcard.setP33ForwardingInstLength((short) bean.getP33ForwardingInstLength());
        csoPaymentInstructionsMcard.setP33ForwardingInstCode(bean.getP33ForwardingInstCode());
        csoPaymentInstructionsMcard.setP34ExtendedAccountNumber(bean.getP34ExtendedAccountNumber());
        csoPaymentInstructionsMcard.setP35Track2Data(bean.getP35Track2Data());
        csoPaymentInstructionsMcard.setP36Track3Data(bean.getP36Track3Data());
        csoPaymentInstructionsMcard.setP37RetrievalRefNumber(bean.getP37RetrievalRefNumber());
        csoPaymentInstructionsMcard.setP38ApprovalCode(bean.getP38ApprovalCode());
        csoPaymentInstructionsMcard.setP39ResponseCode(bean.getP39ResponseCode());
        csoPaymentInstructionsMcard.setP40ServiceCode((short) bean.getP40ServiceCode());
        csoPaymentInstructionsMcard.setP41CardAcceptorTerminalId(bean.getP41CardAcceptorTerminalId());
        csoPaymentInstructionsMcard.setP42CardAcceptorId(bean.getP42CardAcceptorId());
        csoPaymentInstructionsMcard.setP43CardAcceptorLength((short) bean.getP43CardAcceptorLength());
        csoPaymentInstructionsMcard.setP43CardAcceptorName(bean.getP43CardAcceptorName());
        csoPaymentInstructionsMcard.setP44AdditionalResponseData(bean.getP44AdditionalResponseData());
        csoPaymentInstructionsMcard.setP45Track1Data(bean.getP45Track1Data());
        csoPaymentInstructionsMcard.setP46AdditionalDataIso(bean.getP46AdditionalDataIso());
        csoPaymentInstructionsMcard.setP47AdditionalDataNational(bean.getP47AdditionalDataNational());
        csoPaymentInstructionsMcard.setP48AdditionalDataLength(bean.getP48AdditionalDataLength());
        csoPaymentInstructionsMcard.setP48AdditionalData(bean.getP48AdditionalData());
        csoPaymentInstructionsMcard.setP49CurrencyCode((short) bean.getP49CurrencyCode());
        csoPaymentInstructionsMcard.setP50ReconcilliationCode((short) bean.getP50ReconcilliationCode());
        csoPaymentInstructionsMcard.setP51CardholderBillCurCode((short) bean.getP51CardholderBillCurCode());
        csoPaymentInstructionsMcard.setP52PersonalIdNumber(bean.getP52PersonalIdNumber());
        csoPaymentInstructionsMcard.setP53SecurityRelControlInfo(bean.getP53SecurityRelControlInfo());
        csoPaymentInstructionsMcard.setP54AdditionalAmntLength((short) bean.getP54AdditionalAmntLength());
        csoPaymentInstructionsMcard.setP54AdditionalAmounts(bean.getP54AdditionalAmounts());
        csoPaymentInstructionsMcard.setP55IccLength((short) bean.getP55IccLength());
        csoPaymentInstructionsMcard.setP55IccSystemRelatedData(bean.getP55IccSystemRelatedData());
        csoPaymentInstructionsMcard.setP62AddLen((short) bean.getP62AddLen());
        csoPaymentInstructionsMcard.setP35Track2Data(bean.getP62AdditionalData());
        csoPaymentInstructionsMcard.setP36Track3Data(bean.getP62AdditionalData());
        csoPaymentInstructionsMcard.setP37RetrievalRefNumber(bean.getP63TransactionLifeCycleId());
        csoPaymentInstructionsMcard.setP38ApprovalCode(bean.getP64PrimaryMac());
        csoPaymentInstructionsMcard.setP39ResponseCode(bean.getS66SettlemntCode());
        csoPaymentInstructionsMcard.setS67ExtendedPaymentCode((short) bean.getS67ExtendedPaymentCode());
        csoPaymentInstructionsMcard.setS68RecInstCountryCode((short) bean.getS68RecInstCountryCode());
        csoPaymentInstructionsMcard.setS69SettleInstCountryCode((short) bean.getS69SettleInstCountryCode());
        csoPaymentInstructionsMcard.setP43CardAcceptorLength((short) bean.getS70NetworkManCountryCode());
        csoPaymentInstructionsMcard.setP43CardAcceptorName(bean.getP43CardAcceptorName());
        csoPaymentInstructionsMcard.setP44AdditionalResponseData(bean.getP44AdditionalResponseData());
        csoPaymentInstructionsMcard.setP45Track1Data(bean.getP45Track1Data());
        csoPaymentInstructionsMcard.setP46AdditionalDataIso(bean.getP46AdditionalDataIso());
        csoPaymentInstructionsMcard.setP47AdditionalDataNational(bean.getP47AdditionalDataNational());
        csoPaymentInstructionsMcard.setP48AdditionalDataLength(bean.getP48AdditionalDataLength());
        csoPaymentInstructionsMcard.setP48AdditionalData(bean.getP48AdditionalData());
        csoPaymentInstructionsMcard.setP49CurrencyCode((short) bean.getP49CurrencyCode());
        csoPaymentInstructionsMcard.setP50ReconcilliationCode((short) bean.getP50ReconcilliationCode());
        csoPaymentInstructionsMcard.setP51CardholderBillCurCode((short) bean.getP51CardholderBillCurCode());
        csoPaymentInstructionsMcard.setP52PersonalIdNumber(bean.getP52PersonalIdNumber());
        csoPaymentInstructionsMcard.setS71MessageNumber(bean.getS71MessageNumber());
        csoPaymentInstructionsMcard.setS72DataLen((short) bean.getS72DataLen());
        csoPaymentInstructionsMcard.setS72DataRecord(bean.getS72DataRecord());
        csoPaymentInstructionsMcard.setS73ActionDate(bean.getS73ActionDate());
        csoPaymentInstructionsMcard.setS76NoOfDebits(bean.getS74NoOfCredits());
        csoPaymentInstructionsMcard.setS75ReversalNoOfCredits(bean.getS75ReversalNoOfCredits());
        csoPaymentInstructionsMcard.setS76NoOfDebits(bean.getS76NoOfDebits());
        csoPaymentInstructionsMcard.setS77ReversalNoOfDebits(bean.getS77ReversalNoOfDebits());
        csoPaymentInstructionsMcard.setS78NumberTransfers(bean.getS78NumberTransfers());
        csoPaymentInstructionsMcard.setS79ReversalNumberTransfers(bean.getS79ReversalNumberTransfers());
        csoPaymentInstructionsMcard.setS80NumberEnquiries(bean.getS80NumberEnquiries());
        csoPaymentInstructionsMcard.setS81NumberAuthorisations(bean.getS81NumberAuthorisations());
        csoPaymentInstructionsMcard.setS82ProcessingFeeCredits(bean.getS82ProcessingFeeCredits());
        csoPaymentInstructionsMcard.setS83TransactionFeeCredits(bean.getS83TransactionFeeCredits());
        csoPaymentInstructionsMcard.setS84ProcessingFeeDebits(bean.getS84ProcessingFeeDebits());
        csoPaymentInstructionsMcard.setS85TransctionFeeAmounts(bean.getS85TransctionFeeAmounts());
        csoPaymentInstructionsMcard.setS86AmountCredits(bean.getS86AmountCredits());
        csoPaymentInstructionsMcard.setS87ReversalAmountCredits(bean.getS87ReversalAmountCredits());
        csoPaymentInstructionsMcard.setS88AmountDebits(bean.getS88AmountDebits());
        csoPaymentInstructionsMcard.setS89ReversalAmountDebits(bean.getS89ReversalAmountDebits());
        csoPaymentInstructionsMcard.setS90OriginatingDataElements(bean.getS90OriginatingDataElements());
        csoPaymentInstructionsMcard.setS91FileUpdateCode(bean.getS91FileUpdateCode());
        csoPaymentInstructionsMcard.setS92FilesSecurityCode(bean.getS92FilesSecurityCode());
        csoPaymentInstructionsMcard.setS93Length((short) bean.getS93Length());
        csoPaymentInstructionsMcard.setS93TransactionDestInstId(bean.getS93TransactionDestInstId());
        csoPaymentInstructionsMcard.setS94Length((short) bean.getS94Length());
        csoPaymentInstructionsMcard.setS94TransactionOrigInstId(bean.getS94TransactionOrigInstId());
        csoPaymentInstructionsMcard.setS95CardIssRefDataLength((short) bean.getS95CardIssRefDataLength());
        csoPaymentInstructionsMcard.setS95CardIssuerRefData(bean.getS95CardIssuerRefData());
        csoPaymentInstructionsMcard.setS96MessageSecurityCode(bean.getS96MessageSecurityCode());
        csoPaymentInstructionsMcard.setS97NetSettlementAmount(bean.getS97NetSettlementAmount());
        csoPaymentInstructionsMcard.setS98Payee(bean.getS98Payee());
        csoPaymentInstructionsMcard.setS99SettlementInstIdCode(bean.getS99SettlementInstIdCode());
        csoPaymentInstructionsMcard.setS100RiiLen((short) bean.getS100RiiLen());
        csoPaymentInstructionsMcard.setS100RcvingInstIdCode(bean.getS100RcvingInstIdCode());
        csoPaymentInstructionsMcard.setS101FileName(bean.getS101FileName());
        csoPaymentInstructionsMcard.setS102AccountIdentification1(bean.getS102AccountIdentification1());
        csoPaymentInstructionsMcard.setS103AccountIdentification2(bean.getS103AccountIdentification2());
        csoPaymentInstructionsMcard.setS104TransactionDescription(bean.getS104TransactionDescription());
        csoPaymentInstructionsMcard.setS111Length((short) bean.getS111Length());
        csoPaymentInstructionsMcard.setS111AmtCurrencyConversion(bean.getS111AmtCurrencyConversion());
        csoPaymentInstructionsMcard.setS123AddLen((short) bean.getS123AddLen());
        csoPaymentInstructionsMcard.setS123AdditionalData(bean.getS123AdditionalData());
        csoPaymentInstructionsMcard.setS124AddLen((short) bean.getS124AddLen());
        csoPaymentInstructionsMcard.setS124AdditionalData(bean.getS124AdditionalData());
        csoPaymentInstructionsMcard.setS125AddLen((short) bean.getS125AddLen());
        csoPaymentInstructionsMcard.setS125AdditionalData(bean.getS125AdditionalData());
        csoPaymentInstructionsMcard.setS127NetworkData(bean.getS127NetworkData());
        csoPaymentInstructionsMcard.setInputFileIdentifier(bean.getInputFileIdentifier());
        csoPaymentInstructionsMcard.setSeqNo(bean.getSeqNo());
        csoPaymentInstructionsMcard.setProcessStatus(bean.getProcessStatus());
        csoPaymentInstructionsMcard.setRecordId((short) bean.getRecordId());
        csoPaymentInstructionsMcard.setTransactionCode((short) bean.getTransactionCode());
        csoPaymentInstructionsMcard.setCardType(bean.getCardType());
        csoPaymentInstructionsMcard.setFilenameDescription(bean.getFilenameDescription());
        csoPaymentInstructionsMcard.setP55IccSysDataRaw(bean.getP55IccSysDataRaw());
        csoPaymentInstructionsMcard.setIrd((short) bean.getIrd());
        csoPaymentInstructionsMcard.setCashbackPurchase(bean.getCashbackPurchase());
        csoPaymentInstructionsMcard.setCashbackPurchaseAmnt(BigDecimal.valueOf(bean.getCashbackPurchaseAmnt()));
        try {
            csoPaymentInstructionsMcardDao.create(csoPaymentInstructionsMcard);
        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
        }

    }

    public CsoPaymentInstructionsMcardDTO retrieve(CsoPaymentInstructionsMcardDTO obj) throws DAOException {
        CsoPaymentInstructionsMcardDTO dto = new CsoPaymentInstructionsMcardDTO();

        try {

            String sql = "SELECT c FROM CsoPaymentInstructionsMcard c" + buildWhereClause(obj, true);
            CsoPaymentInstructionsMcard bean = csoPaymentInstructionsMcardDao.executeQueryParametersSingleDate(sql, map);

            if (bean.getCsoPaymentInstructionsMcardPK().getFileRefNumber1() != null) {
                dto.setFileRefNumber1(bean.getCsoPaymentInstructionsMcardPK().getFileRefNumber1());
            }
            dto.setSystemSeqNumber2(bean.getCsoPaymentInstructionsMcardPK().getSystemSeqNumber2());
            if (bean.getServiceCode() != null) {
                dto.setServiceCode(bean.getServiceCode());
            }
            if (bean.getSubServiceName() != null) {
                dto.setSubServiceName(bean.getSubServiceName());
            }
            if (bean.getAcquirerMember() != null) {
                dto.setAcquirerMember(bean.getAcquirerMember().shortValue());
            }
            if (bean.getIssuerMember() != null) {
                dto.setIssuerMember(bean.getIssuerMember().shortValue());
            }
            if (bean.getMastercardAmount() != null) {
                dto.setMastercardAmount(bean.getMastercardAmount());
            }
            if (bean.getFinancialIndicator() != null) {
                dto.setFinancialIndicator(bean.getFinancialIndicator());
            }
            if (bean.getPrimaryBitmap() != null) {
                dto.setPrimaryBitmap(bean.getPrimaryBitmap());
            }
            if (bean.getSecondaryBitmap() != null) {
                dto.setSecondaryBitmap(bean.getSecondaryBitmap());
            }
            if (bean.getMessageTypeIndicator() != null) {
                dto.setMessageTypeIndicator(bean.getMessageTypeIndicator().shortValue());
            }
            if (bean.getP2PanLength() != null) {
                dto.setP2PanLength(bean.getP2PanLength().intValue());
            }
            if (bean.getP2Pan() != null) {
                dto.setP2Pan(bean.getP2Pan());
            }
            if (bean.getP3ProcessCode() != null) {
                dto.setP3ProcessCode(bean.getP3ProcessCode().intValue());
            }
            if (bean.getP4TransactionAmount() != null) {
                dto.setP4TransactionAmount(bean.getP4TransactionAmount().longValue());
            }
            if (bean.getP5ReconclliationAmount() != null) {
                dto.setP5ReconclliationAmount(bean.getP5ReconclliationAmount().longValue());
            }
            if (bean.getP6CardholderBilling() != null) {
                dto.setP6CardholderBilling(bean.getP6CardholderBilling().longValue());
            }
            if (bean.getP7TransctionDateAndTime() != null) {
                dto.setP7TransctionDateAndTime(bean.getP7TransctionDateAndTime().longValue());
            }
            if (bean.getP8IccrAmount() != null) {
                dto.setP8IccrAmount(bean.getP8IccrAmount().intValue());
            }
            if (bean.getP9ReconConversionRate() != null) {
                dto.setP9ReconConversionRate(bean.getP9ReconConversionRate().intValue());
            }
            if (bean.getP10CardholderConvRate() != null) {
                dto.setP10CardholderConvRate(bean.getP10CardholderConvRate().intValue());
            }
            if (bean.getP11SystemTraceAuditNumber() != null) {
                dto.setP11SystemTraceAuditNumber(bean.getP11SystemTraceAuditNumber().intValue());
            }
            if (bean.getP12LocalDate() != null) {
                dto.setP12LocalDate(bean.getP12LocalDate().longValue());
            }
            if (bean.getP13LocalTime() != null) {
                dto.setP13LocalTime((int) bean.getP13LocalTime().intValue());
            }
            if (bean.getP14ExpirationDate() != null) {
                dto.setP14ExpirationDate(bean.getP14ExpirationDate().intValue());
            }
            if (bean.getP15SettlementDate() != null) {
                dto.setP15SettlementDate(bean.getP15SettlementDate().shortValue());
            }
            if (bean.getP16ConversionDate() != null) {
                dto.setP16ConversionDate(bean.getP16ConversionDate().intValue());
            }
            if (bean.getP17CaptureDate() != null) {
                dto.setP17CaptureDate(bean.getP17CaptureDate().intValue());
            }
            if (bean.getP18MerchantType() != null) {
                dto.setP18MerchantType(bean.getP18MerchantType().intValue());
            }
            if (bean.getP19AcqBankInstitutionCode() != null) {
                dto.setP19AcqBankInstitutionCode(bean.getP19AcqBankInstitutionCode().intValue());
            }
            if (bean.getP20CountryCodePriAccNo() != null) {
                dto.setP20CountryCodePriAccNo(bean.getP20CountryCodePriAccNo().intValue());
            }
            if (bean.getP21FwdingInstCountryCode() != null) {
                dto.setP21FwdingInstCountryCode(bean.getP21FwdingInstCountryCode().intValue());
            }
            if (bean.getP22PointOfSaleData() != null) {
                dto.setP22PointOfSaleData(bean.getP22PointOfSaleData());
            }
            if (bean.getP23CardSequenceNumber() != null) {
                dto.setP23CardSequenceNumber(bean.getP23CardSequenceNumber().intValue());
            }
            if (bean.getP24FunctionCode() != null) {
                dto.setP24FunctionCode(bean.getP24FunctionCode().intValue());
            }
            if (bean.getP25MessageReasonCode() != null) {
                dto.setP25MessageReasonCode(bean.getP25MessageReasonCode().intValue());
            }
            if (bean.getP26CardAcceptorBusCode() != null) {
                dto.setP26CardAcceptorBusCode(bean.getP26CardAcceptorBusCode().intValue());
            }
            if (bean.getP27AuthIdResponseLength() != null) {
                dto.setP27AuthIdResponseLength(bean.getP27AuthIdResponseLength().intValue());
            }
            if (bean.getP28TransactionFeeAmount() != null) {
                dto.setP28TransactionFeeAmount(bean.getP28TransactionFeeAmount().intValue());
            }
            if (bean.getP29SettlementFeeAmount() != null) {
                dto.setP29SettlementFeeAmount(bean.getP29SettlementFeeAmount().intValue());
            }
            if (bean.getP30OriginalAmount() != null) {
                dto.setP30OriginalAmount(bean.getP30OriginalAmount());
            }
            if (bean.getP31AcquirerRefLength() != null) {
                dto.setP31AcquirerRefLength(bean.getP31AcquirerRefLength().intValue());
            }
            if (bean.getP31AcquirerRefData() != null) {
                dto.setP31AcquirerRefData(bean.getP31AcquirerRefData());
            }
            if (bean.getP32AcquiringInstLength() != null) {
                dto.setP32AcquiringInstLength(bean.getP32AcquiringInstLength().intValue());
            }
            if (bean.getP32AcquiringInstCode() != null) {
                dto.setP32AcquiringInstCode(bean.getP32AcquiringInstCode().longValue());
            }
            if (bean.getP33ForwardingInstLength() != null) {
                dto.setP33ForwardingInstLength(bean.getP33ForwardingInstLength().intValue());
            }
            if (bean.getP33ForwardingInstCode() != null) {
                dto.setP33ForwardingInstCode(bean.getP33ForwardingInstCode().longValue());
            }
            if (bean.getP34ExtendedAccountNumber() != null) {
                dto.setP34ExtendedAccountNumber(bean.getP34ExtendedAccountNumber());
            }
            if (bean.getP35Track2Data() != null) {
                dto.setP35Track2Data(bean.getP35Track2Data());
            }
            if (bean.getP36Track3Data() != null) {
                dto.setP36Track3Data(bean.getP36Track3Data());
            }
            if (bean.getP37RetrievalRefNumber() != null) {
                dto.setP37RetrievalRefNumber(bean.getP37RetrievalRefNumber());
            }
            if (bean.getP38ApprovalCode() != null) {
                dto.setP38ApprovalCode(bean.getP38ApprovalCode());
            }
            if (bean.getP39ResponseCode() != null) {
                dto.setP39ResponseCode(bean.getP39ResponseCode());
            }
            if (bean.getP40ServiceCode() != null) {
                dto.setP40ServiceCode(bean.getP40ServiceCode().intValue());
            }
            if (bean.getP41CardAcceptorTerminalId() != null) {
                dto.setP41CardAcceptorTerminalId(bean.getP41CardAcceptorTerminalId());
            }
            if (bean.getP42CardAcceptorId() != null) {
                dto.setP42CardAcceptorId(bean.getP42CardAcceptorId());
            }
            if (bean.getP43CardAcceptorLength() != null) {
                dto.setP43CardAcceptorLength(bean.getP43CardAcceptorLength().intValue());
            }
            if (bean.getP43CardAcceptorName() != null) {
                dto.setP43CardAcceptorName(bean.getP43CardAcceptorName());
            }
            if (bean.getP44AdditionalResponseData() != null) {
                dto.setP44AdditionalResponseData(bean.getP44AdditionalResponseData());
            }
            if (bean.getP45Track1Data() != null) {
                dto.setP45Track1Data(bean.getP45Track1Data());
            }
            if (bean.getP46AdditionalDataIso() != null) {
                dto.setP46AdditionalDataIso(bean.getP46AdditionalDataIso());
            }
            if (bean.getP47AdditionalDataNational() != null) {
                dto.setP47AdditionalDataNational(bean.getP47AdditionalDataNational());
            }
            if (bean.getP48AdditionalDataLength() != null) {
                dto.setP48AdditionalDataLength(bean.getP48AdditionalDataLength());
            }
            if (bean.getP48AdditionalData() != null) {
                dto.setP48AdditionalData(bean.getP48AdditionalData());
            }
            if (bean.getP49CurrencyCode() != null) {
                dto.setP49CurrencyCode(bean.getP49CurrencyCode().intValue());
            }

            if (bean.getP50ReconcilliationCode() != null) {
                dto.setP50ReconcilliationCode(bean.getP50ReconcilliationCode().intValue());
            }
            if (bean.getP51CardholderBillCurCode() != null) {
                dto.setP51CardholderBillCurCode(bean.getP51CardholderBillCurCode().intValue());
            }
            if (bean.getP52PersonalIdNumber() != null) {
                dto.setP52PersonalIdNumber(bean.getP52PersonalIdNumber());
            }
            if (bean.getP53SecurityRelControlInfo() != null) {
                dto.setP53SecurityRelControlInfo(bean.getP53SecurityRelControlInfo().longValue());
            }
            if (bean.getP54AdditionalAmntLength() != null) {
                dto.setP54AdditionalAmntLength(bean.getP54AdditionalAmntLength().intValue());
            }
            if (bean.getP54AdditionalAmounts() != null) {
                dto.setP54AdditionalAmounts(bean.getP54AdditionalAmounts());
            }

            if (bean.getP55IccLength() != null) {
                dto.setP55IccLength(bean.getP55IccLength().intValue());
            }
            if (bean.getP55IccSystemRelatedData() != null) {
                dto.setP55IccSystemRelatedData(bean.getP55IccSystemRelatedData());
            }
            if (bean.getP62AddLen() != null) {
                dto.setP62AddLen(bean.getP62AddLen().intValue());
            }
            if (bean.getP62AdditionalData() != null) {
                dto.setP35Track2Data(bean.getP62AdditionalData());
            }
            if (bean.getP62AdditionalData() != null) {
                dto.setP36Track3Data(bean.getP62AdditionalData());
            }
            if (bean.getP63TransactionLifeCycleId() != null) {
                dto.setP37RetrievalRefNumber(bean.getP63TransactionLifeCycleId());
            }

            if (bean.getP64PrimaryMac() != null) {
                dto.setP38ApprovalCode(bean.getP64PrimaryMac());
            }
            if (bean.getS66SettlemntCode() != null) {
                dto.setP39ResponseCode(bean.getS66SettlemntCode());
            }
            if (bean.getS67ExtendedPaymentCode() != null) {
                dto.setS67ExtendedPaymentCode(bean.getS67ExtendedPaymentCode().intValue());
            }
            if (bean.getS68RecInstCountryCode() != null) {
                dto.setS68RecInstCountryCode(bean.getS68RecInstCountryCode().intValue());
            }
            if (bean.getS69SettleInstCountryCode() != null) {
                dto.setS69SettleInstCountryCode(bean.getS69SettleInstCountryCode().intValue());
            }
            if (bean.getS70NetworkManCountryCode() != null) {
                dto.setP43CardAcceptorLength(bean.getS70NetworkManCountryCode().intValue());
            }

            if (bean.getP43CardAcceptorName() != null) {
                dto.setP43CardAcceptorName(bean.getP43CardAcceptorName());
            }
            if (bean.getP44AdditionalResponseData() != null) {
                dto.setP44AdditionalResponseData(bean.getP44AdditionalResponseData());
            }
            if (bean.getP45Track1Data() != null) {
                dto.setP45Track1Data(bean.getP45Track1Data());
            }
            if (bean.getP46AdditionalDataIso() != null) {
                dto.setP46AdditionalDataIso(bean.getP46AdditionalDataIso());
            }
            if (bean.getP47AdditionalDataNational() != null) {
                dto.setP47AdditionalDataNational(bean.getP47AdditionalDataNational());
            }
            if (bean.getP48AdditionalDataLength() != null) {
                dto.setP48AdditionalDataLength(bean.getP48AdditionalDataLength());
            }

            if (bean.getP48AdditionalData() != null) {
                dto.setP48AdditionalData(bean.getP48AdditionalData());
            }
            if (bean.getP49CurrencyCode() != null) {
                dto.setP49CurrencyCode(bean.getP49CurrencyCode().intValue());
            }
            if (bean.getP50ReconcilliationCode() != null) {
                dto.setP50ReconcilliationCode(bean.getP50ReconcilliationCode().intValue());
            }
            if (bean.getP51CardholderBillCurCode() != null) {
                dto.setP51CardholderBillCurCode(bean.getP51CardholderBillCurCode().intValue());
            }
            if (bean.getP52PersonalIdNumber() != null) {
                dto.setP52PersonalIdNumber(bean.getP52PersonalIdNumber());
            }
            if (bean.getS71MessageNumber() != null) {
                dto.setS71MessageNumber(bean.getS71MessageNumber().intValue());
            }

            if (bean.getS72DataLen() != null) {
                dto.setS72DataLen(bean.getS72DataLen().intValue());
            }
            if (bean.getS72DataRecord() != null) {
                dto.setS72DataRecord(bean.getS72DataRecord());
            }
            if (bean.getS73ActionDate() != null) {
                dto.setS73ActionDate(bean.getS73ActionDate().intValue());
            }
            if (bean.getS74NoOfCredits() != null) {
                dto.setS76NoOfDebits(bean.getS74NoOfCredits().longValue());
            }
            if (bean.getS75ReversalNoOfCredits() != null) {
                dto.setS75ReversalNoOfCredits(bean.getS75ReversalNoOfCredits().longValue());
            }
            if (bean.getS76NoOfDebits() != null) {
                dto.setS76NoOfDebits(bean.getS76NoOfDebits().longValue());
            }

            if (bean.getS77ReversalNoOfDebits() != null) {
                dto.setS77ReversalNoOfDebits(bean.getS77ReversalNoOfDebits().longValue());
            }
            if (bean.getS78NumberTransfers() != null) {
                dto.setS78NumberTransfers(bean.getS78NumberTransfers().longValue());
            }
            if (bean.getS79ReversalNumberTransfers() != null) {
                dto.setS79ReversalNumberTransfers(bean.getS79ReversalNumberTransfers().longValue());
            }
            if (bean.getS80NumberEnquiries() != null) {
                dto.setS80NumberEnquiries(bean.getS80NumberEnquiries().longValue());
            }
            if (bean.getS81NumberAuthorisations() != null) {
                dto.setS81NumberAuthorisations(bean.getS81NumberAuthorisations().longValue());
            }
            if (bean.getS82ProcessingFeeCredits() != null) {
                dto.setS82ProcessingFeeCredits(bean.getS82ProcessingFeeCredits().longValue());
            }

            if (bean.getS83TransactionFeeCredits() != null) {
                dto.setS83TransactionFeeCredits(bean.getS83TransactionFeeCredits().longValue());
            }
            if (bean.getS84ProcessingFeeDebits() != null) {
                dto.setS84ProcessingFeeDebits(bean.getS84ProcessingFeeDebits().longValue());
            }
            if (bean.getS85TransctionFeeAmounts() != null) {
                dto.setS85TransctionFeeAmounts(bean.getS85TransctionFeeAmounts().longValue());
            }
            if (bean.getS86AmountCredits() != null) {
                dto.setS86AmountCredits(bean.getS86AmountCredits().longValue());
            }
            if (bean.getS87ReversalAmountCredits() != null) {
                dto.setS87ReversalAmountCredits(bean.getS87ReversalAmountCredits().longValue());
            }
            if (bean.getS88AmountDebits() != null) {
                dto.setS88AmountDebits(bean.getS88AmountDebits().longValue());
            }

            if (bean.getS89ReversalAmountDebits() != null) {
                dto.setS89ReversalAmountDebits(bean.getS89ReversalAmountDebits().longValue());
            }
            if (bean.getS90OriginatingDataElements() != null) {
                dto.setS90OriginatingDataElements(bean.getS90OriginatingDataElements().longValue());
            }
            if (bean.getS91FileUpdateCode() != null) {
                dto.setS91FileUpdateCode(bean.getS91FileUpdateCode());
            }
            if (bean.getS92FilesSecurityCode() != null) {
                dto.setS92FilesSecurityCode(bean.getS92FilesSecurityCode());
            }
            if (bean.getS93Length() != null) {
                dto.setS93Length(bean.getS93Length().intValue());
            }
            if (bean.getS93TransactionDestInstId() != null) {
                dto.setS93TransactionDestInstId(bean.getS93TransactionDestInstId().longValue());
            }

            if (bean.getS94Length() != null) {
                dto.setS94Length(bean.getS94Length().intValue());
            }
            if (bean.getS94TransactionOrigInstId() != null) {
                dto.setS94TransactionOrigInstId(bean.getS94TransactionOrigInstId());
            }
            if (bean.getS95CardIssRefDataLength() != null) {
                dto.setS95CardIssRefDataLength(bean.getS95CardIssRefDataLength().intValue());
            }
            if (bean.getS95CardIssuerRefData() != null) {
                dto.setS95CardIssuerRefData(bean.getS95CardIssuerRefData());
            }
            if (bean.getS96MessageSecurityCode() != null) {
                dto.setS96MessageSecurityCode(bean.getS96MessageSecurityCode());
            }
            if (bean.getS97NetSettlementAmount() != null) {
                dto.setS97NetSettlementAmount(bean.getS97NetSettlementAmount().longValue());
            }

            if (bean.getS98Payee() != null) {
                dto.setS98Payee(bean.getS98Payee());
            }
            if (bean.getS99SettlementInstIdCode() != null) {
                dto.setS99SettlementInstIdCode(bean.getS99SettlementInstIdCode().longValue());
            }
            if (bean.getS100RiiLen() != null) {
                dto.setS100RiiLen(bean.getS100RiiLen().intValue());
            }
            if (bean.getS100RcvingInstIdCode() != null) {
                dto.setS100RcvingInstIdCode(bean.getS100RcvingInstIdCode().longValue());
            }
            if (bean.getS101FileName() != null) {
                dto.setS101FileName(bean.getS101FileName());
            }
            if (bean.getS102AccountIdentification1() != null) {
                dto.setS102AccountIdentification1(bean.getS102AccountIdentification1());
            }

            if (bean.getS103AccountIdentification2() != null) {
                dto.setS103AccountIdentification2(bean.getS103AccountIdentification2());
            }
            if (bean.getS104TransactionDescription() != null) {
                dto.setS104TransactionDescription(bean.getS104TransactionDescription());
            }
            if (bean.getS111Length() != null) {
                dto.setS111Length(bean.getS111Length().intValue());
            }
            if (bean.getS111AmtCurrencyConversion() != null) {
                dto.setS111AmtCurrencyConversion(bean.getS111AmtCurrencyConversion());
            }
            if (bean.getS123AddLen() != null) {
                dto.setS123AddLen(bean.getS123AddLen().intValue());
            }
            if (bean.getS123AdditionalData() != null) {
                dto.setS123AdditionalData(bean.getS123AdditionalData());
            }

            if (bean.getS124AddLen() != null) {
                dto.setS124AddLen(bean.getS124AddLen().intValue());
            }
            if (bean.getS124AdditionalData() != null) {
                dto.setS124AdditionalData(bean.getS124AdditionalData());
            }
            if (bean.getS125AddLen() != null) {
                dto.setS125AddLen(bean.getS125AddLen().intValue());
            }
            if (bean.getS125AdditionalData() != null) {
                dto.setS125AdditionalData(bean.getS125AdditionalData());
            }
            if (bean.getS127NetworkData() != null) {
                dto.setS127NetworkData(bean.getS127NetworkData());
            }
            if (bean.getInputFileIdentifier() != null) {
                dto.setInputFileIdentifier(bean.getInputFileIdentifier());
            }

            if (bean.getSeqNo() != null) {
                dto.setSeqNo(bean.getSeqNo().longValue());
            }
            if (bean.getProcessStatus() != null) {
                dto.setProcessStatus(bean.getProcessStatus());
            }
            if (bean.getRecordId() != null) {
                dto.setRecordId(bean.getRecordId().intValue());
            }
            if (bean.getTransactionCode() != null) {
                dto.setTransactionCode(bean.getTransactionCode());
            }
            if (bean.getCardType() != null) {
                dto.setCardType(bean.getCardType());
            }
            if (bean.getFilenameDescription() != null) {
                dto.setFilenameDescription(bean.getFilenameDescription());
            }

            if (bean.getP55IccSysDataRaw() != null) {
                dto.setP55IccSysDataRaw(bean.getP55IccSysDataRaw());
            }
            if (bean.getIrd() != null) {
                dto.setIrd(bean.getIrd().intValue());
            }
            if (bean.getCashbackPurchase() != null) {
                dto.setCashbackPurchase(bean.getCashbackPurchase());
            }
            if (bean.getCashbackPurchaseAmnt() != null) {
                dto.setCashbackPurchaseAmnt(bean.getCashbackPurchaseAmnt().doubleValue());
            }

        } catch (Exception ex) {
            ex.getMessage();
        }
        map.clear();
        return dto;
    }

    public List<CsoPaymentInstructionsMcardDTO> retrieveRelated(CsoPaymentInstructionsMcardDTO obj) throws DAOException {

        List<CsoPaymentInstructionsMcardDTO> dtoList = new LinkedList<CsoPaymentInstructionsMcardDTO>();
        CsoPaymentInstructionsMcardDTO dto = null;
        try {

            String sql = "SELECT c  FROM CsoPaymentInstructionsMcard c " + buildWhereClause(obj, true);

            List<CsoPaymentInstructionsMcard> csoPaymentInstructionsMcardaretrieveRelated = csoPaymentInstructionsMcardDao.executeQueryParameters(sql, map);

            for (CsoPaymentInstructionsMcard bean : csoPaymentInstructionsMcardaretrieveRelated) {

                dto = new CsoPaymentInstructionsMcardDTO();

                if (bean.getCsoPaymentInstructionsMcardPK().getFileRefNumber1() != null) {
                    dto.setFileRefNumber1(bean.getCsoPaymentInstructionsMcardPK().getFileRefNumber1());
                }
                dto.setSystemSeqNumber2(bean.getCsoPaymentInstructionsMcardPK().getSystemSeqNumber2());
                if (bean.getServiceCode() != null) {
                    dto.setServiceCode(bean.getServiceCode());
                }
                if (bean.getSubServiceName() != null) {
                    dto.setSubServiceName(bean.getSubServiceName());
                }
                if (bean.getAcquirerMember() != null) {
                    dto.setAcquirerMember(bean.getAcquirerMember());
                }
                if (bean.getIssuerMember() != null) {
                    dto.setIssuerMember(bean.getIssuerMember());
                }
                if (bean.getMastercardAmount() != null) {
                    dto.setMastercardAmount(bean.getMastercardAmount());
                }
                if (bean.getFinancialIndicator() != null) {
                    dto.setFinancialIndicator(bean.getFinancialIndicator());
                }
                if (bean.getPrimaryBitmap() != null) {
                    dto.setPrimaryBitmap(bean.getPrimaryBitmap());
                }
                if (bean.getSecondaryBitmap() != null) {
                    dto.setSecondaryBitmap(bean.getSecondaryBitmap());
                }
                if (bean.getMessageTypeIndicator() != null) {
                    dto.setMessageTypeIndicator(bean.getMessageTypeIndicator());
                }
                if (bean.getP2PanLength() != null) {
                    dto.setP2PanLength(bean.getP2PanLength().intValue());
                }
                if (bean.getP2Pan() != null) {
                    dto.setP2Pan(bean.getP2Pan());
                }
                if (bean.getP3ProcessCode() != null) {
                    dto.setP3ProcessCode(bean.getP3ProcessCode());
                }
                if (bean.getP4TransactionAmount() != null) {
                    dto.setP4TransactionAmount(bean.getP4TransactionAmount());
                }
                if (bean.getP5ReconclliationAmount() != null) {
                    dto.setP5ReconclliationAmount(bean.getP5ReconclliationAmount());
                }
                if (bean.getP6CardholderBilling() != null) {
                    dto.setP6CardholderBilling(bean.getP6CardholderBilling());
                }
                if (bean.getP7TransctionDateAndTime() != null) {
                    dto.setP7TransctionDateAndTime(bean.getP7TransctionDateAndTime());
                }
                if (bean.getP8IccrAmount() != null) {
                    dto.setP8IccrAmount(bean.getP8IccrAmount().intValue());
                }
                if (bean.getP9ReconConversionRate() != null) {
                    dto.setP9ReconConversionRate(bean.getP9ReconConversionRate().intValue());
                }
                if (bean.getP10CardholderConvRate() != null) {
                    dto.setP10CardholderConvRate(bean.getP10CardholderConvRate().intValue());
                }
                if (bean.getP11SystemTraceAuditNumber() != null) {
                    dto.setP11SystemTraceAuditNumber(bean.getP11SystemTraceAuditNumber().intValue());
                }
                if (bean.getP12LocalDate() != null) {
                    dto.setP12LocalDate(bean.getP12LocalDate().longValue());
                }
                if (bean.getP13LocalTime() != null) {
                    dto.setP13LocalTime((int) bean.getP13LocalTime().intValue());
                }
                if (bean.getP14ExpirationDate() != null) {
                    dto.setP14ExpirationDate(bean.getP14ExpirationDate().intValue());
                }
                if (bean.getP15SettlementDate() != null) {
                    dto.setP15SettlementDate(bean.getP15SettlementDate().shortValue());
                }
                if (bean.getP16ConversionDate() != null) {
                    dto.setP16ConversionDate(bean.getP16ConversionDate().intValue());
                }
                if (bean.getP17CaptureDate() != null) {
                    dto.setP17CaptureDate(bean.getP17CaptureDate().intValue());
                }
                if (bean.getP18MerchantType() != null) {
                    dto.setP18MerchantType(bean.getP18MerchantType().intValue());
                }
                if (bean.getP19AcqBankInstitutionCode() != null) {
                    dto.setP19AcqBankInstitutionCode(bean.getP19AcqBankInstitutionCode().intValue());
                }
                if (bean.getP20CountryCodePriAccNo() != null) {
                    dto.setP20CountryCodePriAccNo(bean.getP20CountryCodePriAccNo().intValue());
                }
                if (bean.getP21FwdingInstCountryCode() != null) {
                    dto.setP21FwdingInstCountryCode(bean.getP21FwdingInstCountryCode().intValue());
                }
                if (bean.getP22PointOfSaleData() != null) {
                    dto.setP22PointOfSaleData(bean.getP22PointOfSaleData());
                }
                if (bean.getP23CardSequenceNumber() != null) {
                    dto.setP23CardSequenceNumber(bean.getP23CardSequenceNumber().intValue());
                }
                if (bean.getP24FunctionCode() != null) {
                    dto.setP24FunctionCode(bean.getP24FunctionCode().intValue());
                }
                if (bean.getP25MessageReasonCode() != null) {
                    dto.setP25MessageReasonCode(bean.getP25MessageReasonCode().intValue());
                }
                if (bean.getP26CardAcceptorBusCode() != null) {
                    dto.setP26CardAcceptorBusCode(bean.getP26CardAcceptorBusCode().intValue());
                }
                if (bean.getP27AuthIdResponseLength() != null) {
                    dto.setP27AuthIdResponseLength(bean.getP27AuthIdResponseLength().intValue());
                }
                if (bean.getP28TransactionFeeAmount() != null) {
                    dto.setP28TransactionFeeAmount(bean.getP28TransactionFeeAmount().intValue());
                }
                if (bean.getP29SettlementFeeAmount() != null) {
                    dto.setP29SettlementFeeAmount(bean.getP29SettlementFeeAmount().intValue());
                }
                if (bean.getP30OriginalAmount() != null) {
                    dto.setP30OriginalAmount(bean.getP30OriginalAmount());
                }
                if (bean.getP31AcquirerRefLength() != null) {
                    dto.setP31AcquirerRefLength(bean.getP31AcquirerRefLength().intValue());
                }
                if (bean.getP31AcquirerRefData() != null) {
                    dto.setP31AcquirerRefData(bean.getP31AcquirerRefData());
                }
                if (bean.getP32AcquiringInstLength() != null) {
                    dto.setP32AcquiringInstLength(bean.getP32AcquiringInstLength().intValue());
                }
                if (bean.getP32AcquiringInstCode() != null) {
                    dto.setP32AcquiringInstCode(bean.getP32AcquiringInstCode().longValue());
                }
                if (bean.getP33ForwardingInstLength() != null) {
                    dto.setP33ForwardingInstLength(bean.getP33ForwardingInstLength().intValue());
                }
                if (bean.getP33ForwardingInstCode() != null) {
                    dto.setP33ForwardingInstCode(bean.getP33ForwardingInstCode().longValue());
                }
                if (bean.getP34ExtendedAccountNumber() != null) {
                    dto.setP34ExtendedAccountNumber(bean.getP34ExtendedAccountNumber());
                }
                if (bean.getP35Track2Data() != null) {
                    dto.setP35Track2Data(bean.getP35Track2Data());
                }
                if (bean.getP36Track3Data() != null) {
                    dto.setP36Track3Data(bean.getP36Track3Data());
                }
                if (bean.getP37RetrievalRefNumber() != null) {
                    dto.setP37RetrievalRefNumber(bean.getP37RetrievalRefNumber());
                }
                if (bean.getP38ApprovalCode() != null) {
                    dto.setP38ApprovalCode(bean.getP38ApprovalCode());
                }
                if (bean.getP39ResponseCode() != null) {
                    dto.setP39ResponseCode(bean.getP39ResponseCode());
                }
                if (bean.getP40ServiceCode() != null) {
                    dto.setP40ServiceCode(bean.getP40ServiceCode().intValue());
                }
                if (bean.getP41CardAcceptorTerminalId() != null) {
                    dto.setP41CardAcceptorTerminalId(bean.getP41CardAcceptorTerminalId());
                }
                if (bean.getP42CardAcceptorId() != null) {
                    dto.setP42CardAcceptorId(bean.getP42CardAcceptorId());
                }
                if (bean.getP43CardAcceptorLength() != null) {
                    dto.setP43CardAcceptorLength(bean.getP43CardAcceptorLength().intValue());
                }
                if (bean.getP43CardAcceptorName() != null) {
                    dto.setP43CardAcceptorName(bean.getP43CardAcceptorName());
                }
                if (bean.getP44AdditionalResponseData() != null) {
                    dto.setP44AdditionalResponseData(bean.getP44AdditionalResponseData());
                }
                if (bean.getP45Track1Data() != null) {
                    dto.setP45Track1Data(bean.getP45Track1Data());
                }
                if (bean.getP46AdditionalDataIso() != null) {
                    dto.setP46AdditionalDataIso(bean.getP46AdditionalDataIso());
                }
                if (bean.getP47AdditionalDataNational() != null) {
                    dto.setP47AdditionalDataNational(bean.getP47AdditionalDataNational());
                }
                if (bean.getP48AdditionalDataLength() != null) {
                    dto.setP48AdditionalDataLength(bean.getP48AdditionalDataLength());
                }
                if (bean.getP48AdditionalData() != null) {
                    dto.setP48AdditionalData(bean.getP48AdditionalData());
                }
                if (bean.getP49CurrencyCode() != null) {
                    dto.setP49CurrencyCode(bean.getP49CurrencyCode().intValue());
                }

                if (bean.getP50ReconcilliationCode() != null) {
                    dto.setP50ReconcilliationCode(bean.getP50ReconcilliationCode().intValue());
                }
                if (bean.getP51CardholderBillCurCode() != null) {
                    dto.setP51CardholderBillCurCode(bean.getP51CardholderBillCurCode().intValue());
                }
                if (bean.getP52PersonalIdNumber() != null) {
                    dto.setP52PersonalIdNumber(bean.getP52PersonalIdNumber());
                }
                if (bean.getP53SecurityRelControlInfo() != null) {
                    dto.setP53SecurityRelControlInfo(bean.getP53SecurityRelControlInfo().longValue());
                }
                if (bean.getP54AdditionalAmntLength() != null) {
                    dto.setP54AdditionalAmntLength(bean.getP54AdditionalAmntLength().intValue());
                }
                if (bean.getP54AdditionalAmounts() != null) {
                    dto.setP54AdditionalAmounts(bean.getP54AdditionalAmounts());
                }

                if (bean.getP55IccLength() != null) {
                    dto.setP55IccLength(bean.getP55IccLength().intValue());
                }
                if (bean.getP55IccSystemRelatedData() != null) {
                    dto.setP55IccSystemRelatedData(bean.getP55IccSystemRelatedData());
                }
                if (bean.getP62AddLen() != null) {
                    dto.setP62AddLen(bean.getP62AddLen().intValue());
                }
                if (bean.getP62AdditionalData() != null) {
                    dto.setP35Track2Data(bean.getP62AdditionalData());
                }
                if (bean.getP62AdditionalData() != null) {
                    dto.setP36Track3Data(bean.getP62AdditionalData());
                }
                if (bean.getP63TransactionLifeCycleId() != null) {
                    dto.setP37RetrievalRefNumber(bean.getP63TransactionLifeCycleId());
                }

                if (bean.getP64PrimaryMac() != null) {
                    dto.setP38ApprovalCode(bean.getP64PrimaryMac());
                }
                if (bean.getS66SettlemntCode() != null) {
                    dto.setP39ResponseCode(bean.getS66SettlemntCode());
                }
                if (bean.getS67ExtendedPaymentCode() != null) {
                    dto.setS67ExtendedPaymentCode(bean.getS67ExtendedPaymentCode().intValue());
                }
                if (bean.getS68RecInstCountryCode() != null) {
                    dto.setS68RecInstCountryCode(bean.getS68RecInstCountryCode().intValue());
                }
                if (bean.getS69SettleInstCountryCode() != null) {
                    dto.setS69SettleInstCountryCode(bean.getS69SettleInstCountryCode().intValue());
                }
                if (bean.getS70NetworkManCountryCode() != null) {
                    dto.setP43CardAcceptorLength(bean.getS70NetworkManCountryCode().intValue());
                }

                if (bean.getP43CardAcceptorName() != null) {
                    dto.setP43CardAcceptorName(bean.getP43CardAcceptorName());
                }
                if (bean.getP44AdditionalResponseData() != null) {
                    dto.setP44AdditionalResponseData(bean.getP44AdditionalResponseData());
                }
                if (bean.getP45Track1Data() != null) {
                    dto.setP45Track1Data(bean.getP45Track1Data());
                }
                if (bean.getP46AdditionalDataIso() != null) {
                    dto.setP46AdditionalDataIso(bean.getP46AdditionalDataIso());
                }
                if (bean.getP47AdditionalDataNational() != null) {
                    dto.setP47AdditionalDataNational(bean.getP47AdditionalDataNational());
                }
                if (bean.getP48AdditionalDataLength() != null) {
                    dto.setP48AdditionalDataLength(bean.getP48AdditionalDataLength());
                }

                if (bean.getP48AdditionalData() != null) {
                    dto.setP48AdditionalData(bean.getP48AdditionalData());
                }
                if (bean.getP49CurrencyCode() != null) {
                    dto.setP49CurrencyCode(bean.getP49CurrencyCode().intValue());
                }
                if (bean.getP50ReconcilliationCode() != null) {
                    dto.setP50ReconcilliationCode(bean.getP50ReconcilliationCode().intValue());
                }
                if (bean.getP51CardholderBillCurCode() != null) {
                    dto.setP51CardholderBillCurCode(bean.getP51CardholderBillCurCode().intValue());
                }
                if (bean.getP52PersonalIdNumber() != null) {
                    dto.setP52PersonalIdNumber(bean.getP52PersonalIdNumber());
                }
                if (bean.getS71MessageNumber() != null) {
                    dto.setS71MessageNumber(bean.getS71MessageNumber().intValue());
                }

                if (bean.getS72DataLen() != null) {
                    dto.setS72DataLen(bean.getS72DataLen().intValue());
                }
                if (bean.getS72DataRecord() != null) {
                    dto.setS72DataRecord(bean.getS72DataRecord());
                }
                if (bean.getS73ActionDate() != null) {
                    dto.setS73ActionDate(bean.getS73ActionDate().intValue());
                }
                if (bean.getS74NoOfCredits() != null) {
                    dto.setS76NoOfDebits(bean.getS74NoOfCredits().longValue());
                }
                if (bean.getS75ReversalNoOfCredits() != null) {
                    dto.setS75ReversalNoOfCredits(bean.getS75ReversalNoOfCredits().longValue());
                }
                if (bean.getS76NoOfDebits() != null) {
                    dto.setS76NoOfDebits(bean.getS76NoOfDebits().longValue());
                }

                if (bean.getS77ReversalNoOfDebits() != null) {
                    dto.setS77ReversalNoOfDebits(bean.getS77ReversalNoOfDebits().longValue());
                }
                if (bean.getS78NumberTransfers() != null) {
                    dto.setS78NumberTransfers(bean.getS78NumberTransfers().longValue());
                }
                if (bean.getS79ReversalNumberTransfers() != null) {
                    dto.setS79ReversalNumberTransfers(bean.getS79ReversalNumberTransfers().longValue());
                }
                if (bean.getS80NumberEnquiries() != null) {
                    dto.setS80NumberEnquiries(bean.getS80NumberEnquiries().longValue());
                }
                if (bean.getS81NumberAuthorisations() != null) {
                    dto.setS81NumberAuthorisations(bean.getS81NumberAuthorisations().longValue());
                }
                if (bean.getS82ProcessingFeeCredits() != null) {
                    dto.setS82ProcessingFeeCredits(bean.getS82ProcessingFeeCredits().longValue());
                }

                if (bean.getS83TransactionFeeCredits() != null) {
                    dto.setS83TransactionFeeCredits(bean.getS83TransactionFeeCredits().longValue());
                }
                if (bean.getS84ProcessingFeeDebits() != null) {
                    dto.setS84ProcessingFeeDebits(bean.getS84ProcessingFeeDebits().longValue());
                }
                if (bean.getS85TransctionFeeAmounts() != null) {
                    dto.setS85TransctionFeeAmounts(bean.getS85TransctionFeeAmounts().longValue());
                }
                if (bean.getS86AmountCredits() != null) {
                    dto.setS86AmountCredits(bean.getS86AmountCredits().longValue());
                }
                if (bean.getS87ReversalAmountCredits() != null) {
                    dto.setS87ReversalAmountCredits(bean.getS87ReversalAmountCredits().longValue());
                }
                if (bean.getS88AmountDebits() != null) {
                    dto.setS88AmountDebits(bean.getS88AmountDebits().longValue());
                }

                if (bean.getS89ReversalAmountDebits() != null) {
                    dto.setS89ReversalAmountDebits(bean.getS89ReversalAmountDebits().longValue());
                }
                if (bean.getS90OriginatingDataElements() != null) {
                    dto.setS90OriginatingDataElements(bean.getS90OriginatingDataElements().longValue());
                }
                if (bean.getS91FileUpdateCode() != null) {
                    dto.setS91FileUpdateCode(bean.getS91FileUpdateCode());
                }
                if (bean.getS92FilesSecurityCode() != null) {
                    dto.setS92FilesSecurityCode(bean.getS92FilesSecurityCode());
                }
                if (bean.getS93Length() != null) {
                    dto.setS93Length(bean.getS93Length().intValue());
                }
                if (bean.getS93TransactionDestInstId() != null) {
                    dto.setS93TransactionDestInstId(bean.getS93TransactionDestInstId().longValue());
                }

                if (bean.getS94Length() != null) {
                    dto.setS94Length(bean.getS94Length().intValue());
                }
                if (bean.getS94TransactionOrigInstId() != null) {
                    dto.setS94TransactionOrigInstId(bean.getS94TransactionOrigInstId());
                }
                if (bean.getS95CardIssRefDataLength() != null) {
                    dto.setS95CardIssRefDataLength(bean.getS95CardIssRefDataLength().intValue());
                }
                if (bean.getS95CardIssuerRefData() != null) {
                    dto.setS95CardIssuerRefData(bean.getS95CardIssuerRefData());
                }
                if (bean.getS96MessageSecurityCode() != null) {
                    dto.setS96MessageSecurityCode(bean.getS96MessageSecurityCode());
                }
                if (bean.getS97NetSettlementAmount() != null) {
                    dto.setS97NetSettlementAmount(bean.getS97NetSettlementAmount().longValue());
                }

                if (bean.getS98Payee() != null) {
                    dto.setS98Payee(bean.getS98Payee());
                }
                if (bean.getS99SettlementInstIdCode() != null) {
                    dto.setS99SettlementInstIdCode(bean.getS99SettlementInstIdCode().longValue());
                }
                if (bean.getS100RiiLen() != null) {
                    dto.setS100RiiLen(bean.getS100RiiLen().intValue());
                }
                if (bean.getS100RcvingInstIdCode() != null) {
                    dto.setS100RcvingInstIdCode(bean.getS100RcvingInstIdCode().longValue());
                }
                if (bean.getS101FileName() != null) {
                    dto.setS101FileName(bean.getS101FileName());
                }
                if (bean.getS102AccountIdentification1() != null) {
                    dto.setS102AccountIdentification1(bean.getS102AccountIdentification1());
                }

                if (bean.getS103AccountIdentification2() != null) {
                    dto.setS103AccountIdentification2(bean.getS103AccountIdentification2());
                }
                if (bean.getS104TransactionDescription() != null) {
                    dto.setS104TransactionDescription(bean.getS104TransactionDescription());
                }
                if (bean.getS111Length() != null) {
                    dto.setS111Length(bean.getS111Length().intValue());
                }
                if (bean.getS111AmtCurrencyConversion() != null) {
                    dto.setS111AmtCurrencyConversion(bean.getS111AmtCurrencyConversion());
                }
                if (bean.getS123AddLen() != null) {
                    dto.setS123AddLen(bean.getS123AddLen().intValue());
                }
                if (bean.getS123AdditionalData() != null) {
                    dto.setS123AdditionalData(bean.getS123AdditionalData());
                }

                if (bean.getS124AddLen() != null) {
                    dto.setS124AddLen(bean.getS124AddLen().intValue());
                }
                if (bean.getS124AdditionalData() != null) {
                    dto.setS124AdditionalData(bean.getS124AdditionalData());
                }
                if (bean.getS125AddLen() != null) {
                    dto.setS125AddLen(bean.getS125AddLen().intValue());
                }
                if (bean.getS125AdditionalData() != null) {
                    dto.setS125AdditionalData(bean.getS125AdditionalData());
                }
                if (bean.getS127NetworkData() != null) {
                    dto.setS127NetworkData(bean.getS127NetworkData());
                }
                if (bean.getInputFileIdentifier() != null) {
                    dto.setInputFileIdentifier(bean.getInputFileIdentifier());
                }

                if (bean.getSeqNo() != null) {
                    dto.setSeqNo(bean.getSeqNo().longValue());
                }
                if (bean.getProcessStatus() != null) {
                    dto.setProcessStatus(bean.getProcessStatus());
                }
                if (bean.getRecordId() != null) {
                    dto.setRecordId(bean.getRecordId().intValue());
                }
                if (bean.getTransactionCode() != null) {
                    dto.setTransactionCode(bean.getTransactionCode());
                }
                if (bean.getCardType() != null) {
                    dto.setCardType(bean.getCardType());
                }
                if (bean.getFilenameDescription() != null) {
                    dto.setFilenameDescription(bean.getFilenameDescription());
                }

                if (bean.getP55IccSysDataRaw() != null) {
                    dto.setP55IccSysDataRaw(bean.getP55IccSysDataRaw());
                }
                if (bean.getIrd() != null) {
                    dto.setIrd(bean.getIrd().intValue());
                }
                if (bean.getCashbackPurchase() != null) {
                    dto.setCashbackPurchase(bean.getCashbackPurchase());
                }
                if (bean.getCashbackPurchaseAmnt() != null) {
                    dto.setCashbackPurchaseAmnt(bean.getCashbackPurchaseAmnt().doubleValue());
                }

                dtoList.add(dto);
            }

        } catch (Exception ex) {
            ex.getMessage();
        }
        map.clear();
        return dtoList;
    }

    private String buildWhereClause(CsoPaymentInstructionsMcardDTO bean, boolean select) throws DAOException {
        if (bean == null) {
            return "";
        }

        StringBuilder buff = new StringBuilder();
        boolean whereClause = false;
        if (select == true) {
            if (bean.getFileRefNumber1() != null && !bean.getFileRefNumber1().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.csoPaymentInstructionsMcardPK.fileRefNumber1 =:fileRefNumber1");
                map.put("fileRefNumber1", bean.getFileRefNumber1());

            }
            if (bean.getSystemSeqNumber2() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.csoPaymentInstructionsMcardPK.systemSeqNumber2 =:systemSeqNumber2");
                map.put("systemSeqNumber2", bean.getSystemSeqNumber2());

            }
            if (bean.getServiceCode() != null && !bean.getServiceCode().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.serviceCode =:serviceCode");
                map.put("serviceCode", bean.getServiceCode());

            }

            if (bean.getSubServiceName() != null && !bean.getSubServiceName().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.subServiceName =:subServiceName");
                map.put("subServiceName", bean.getSubServiceName());

            }
            if (bean.getAcquirerMember() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.acquirerMember =:acquirerMember");
                map.put("acquirerMember", bean.getAcquirerMember());

            }
            if (bean.getIssuerMember() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.issuerMember =:issuerMember");
                map.put("issuerMember", bean.getIssuerMember());

            }
            if (bean.getMastercardAmount() > 0.0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.mastercardAmount =:mastercardAmount");
                map.put("mastercardAmount", String.valueOf(bean.getMastercardAmount()));

            }
            if (bean.getFinancialIndicator() != null && !bean.getFinancialIndicator().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.financialIndicator =:financialIndicator");
                map.put("financialIndicator", bean.getFinancialIndicator());

            }
            if (bean.getPrimaryBitmap() != null && !bean.getPrimaryBitmap().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.primaryBitmap =:primaryBitmap");
                map.put("primaryBitmap", bean.getPrimaryBitmap());

            }
            if (bean.getSecondaryBitmap() != null && !bean.getSecondaryBitmap().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.secondaryBitmap =:secondaryBitmap");
                map.put("secondaryBitmap", bean.getSecondaryBitmap());

            }
            if (bean.getMessageTypeIndicator() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.messageTypeIndicator =:messageTypeIndicator");
                map.put("messageTypeIndicator", String.valueOf(bean.getMessageTypeIndicator()));

            }
            if (bean.getP2PanLength() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p2PanLength =:p2PanLength");
                map.put("p2PanLength", String.valueOf(bean.getP2PanLength()));

            }
            if (bean.getP2Pan() != null && !bean.getP2Pan().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p2Pan =:p2Pan");
                map.put("p2Pan", bean.getP2Pan());

            }
            if (bean.getP3ProcessCode() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p3ProcessCode =:p3ProcessCode");
                map.put("p3ProcessCode", String.valueOf(bean.getP3ProcessCode()));

            }
            if (bean.getP4TransactionAmount() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p4TransactionAmount =:p4TransactionAmount");
                map.put("p4TransactionAmount", String.valueOf(bean.getP4TransactionAmount()));

            }
            if (bean.getP5ReconclliationAmount() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p5ReconclliationAmount =:p5ReconclliationAmount");
                map.put("p5ReconclliationAmount", String.valueOf(bean.getP5ReconclliationAmount()));

            }
            if (bean.getP6CardholderBilling() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p6CardholderBilling =:p6CardholderBilling");
                map.put("p6CardholderBilling", String.valueOf(bean.getP6CardholderBilling()));

            }
            if (bean.getP7TransctionDateAndTime() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p7TransctionDateAndTime =:p7TransctionDateAndTime");
                map.put("p7TransctionDateAndTime", String.valueOf(bean.getP7TransctionDateAndTime()));

            }
            if (bean.getP8IccrAmount() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p8IccrAmount =:p8IccrAmount");
                map.put("p8IccrAmount", String.valueOf(bean.getP8IccrAmount()));

            }
            if (bean.getP9ReconConversionRate() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p9ReconConversionRate =:p9ReconConversionRate");
                map.put("p9ReconConversionRate", String.valueOf(bean.getP9ReconConversionRate()));

            }
            if (bean.getP10CardholderConvRate() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p10CardholderConvRate =:p10CardholderConvRate");
                map.put("p10CardholderConvRate", String.valueOf(bean.getP10CardholderConvRate()));

            }
            if (bean.getP11SystemTraceAuditNumber() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p11SystemTraceAuditNumber =:p11SystemTraceAuditNumber");
                map.put("p11SystemTraceAuditNumber", String.valueOf(bean.getP11SystemTraceAuditNumber()));

            }
            if (bean.getP12LocalDate() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p12LocalDate =:p12LocalDate");
                map.put("p12LocalDate", String.valueOf(bean.getP12LocalDate()));

            }
            if (bean.getP13LocalTime() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p13LocalTime =:p13LocalTime");
                map.put("p13LocalTime", String.valueOf(bean.getP13LocalTime()));

            }
            if (bean.getP14ExpirationDate() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p14ExpirationDate =:p14ExpirationDate");
                map.put("p14ExpirationDate", String.valueOf(bean.getP14ExpirationDate()));

            }
            if (bean.getP15SettlementDate() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p15SettlementDate =:p15SettlementDate");
                map.put("", String.valueOf(bean.getP15SettlementDate()));

            }
            if (bean.getP16ConversionDate() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p16ConversionDate =:p16ConversionDate");
                map.put("p16ConversionDate", String.valueOf(bean.getP16ConversionDate()));

            }
            if (bean.getP17CaptureDate() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p17CaptureDate =:p17CaptureDate");
                map.put("p17CaptureDate", String.valueOf(bean.getP17CaptureDate()));

            }
            if (bean.getP18MerchantType() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p18MerchantType =:p18MerchantType");
                map.put("p18MerchantType", String.valueOf(bean.getP18MerchantType()));

            }
            if (bean.getP19AcqBankInstitutionCode() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p19AcqBankInstitutionCode =:p19AcqBankInstitutionCode");
                map.put("p19AcqBankInstitutionCode", String.valueOf(bean.getP19AcqBankInstitutionCode()));

            }
            if (bean.getP20CountryCodePriAccNo() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p20CountryCodePriAccNo =:p20CountryCodePriAccNo");
                map.put("p20CountryCodePriAccNo", String.valueOf(bean.getP20CountryCodePriAccNo()));

            }
            if (bean.getP21FwdingInstCountryCode() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p21FwdingInstCountryCode =:p21FwdingInstCountryCode");
                map.put("p21FwdingInstCountryCode", String.valueOf(bean.getP21FwdingInstCountryCode()));

            }
            if (bean.getP22PointOfSaleData() != null && !bean.getP22PointOfSaleData().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p22PointOfSaleData =:p22PointOfSaleData");
                map.put("p22PointOfSaleData", bean.getP22PointOfSaleData());

            }
            if (bean.getP23CardSequenceNumber() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p23CardSequenceNumber =:p23CardSequenceNumber");
                map.put("p23CardSequenceNumber", String.valueOf(bean.getP23CardSequenceNumber()));

            }
            if (bean.getP24FunctionCode() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p24FunctionCode =:p24FunctionCode");
                map.put("p24FunctionCode", String.valueOf(bean.getP24FunctionCode()));

            }
            if (bean.getP25MessageReasonCode() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p25MessageReasonCode =:p25MessageReasonCode");
                map.put("p25MessageReasonCode", String.valueOf(bean.getP25MessageReasonCode()));

            }
            if (bean.getP26CardAcceptorBusCode() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p26CardAcceptorBusCode =:p26CardAcceptorBusCode");
                map.put("p26CardAcceptorBusCode", String.valueOf(bean.getP26CardAcceptorBusCode()));

            }
            if (bean.getP27AuthIdResponseLength() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p27AuthIdResponseLength =:p27AuthIdResponseLength");
                map.put("p27AuthIdResponseLength", String.valueOf(bean.getP27AuthIdResponseLength()));

            }
            if (bean.getP28TransactionFeeAmount() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p28TransactionFeeAmount =:p28TransactionFeeAmount");
                map.put("p28TransactionFeeAmount", String.valueOf(bean.getP28TransactionFeeAmount()));

            }
            if (bean.getP29SettlementFeeAmount() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p29SettlementFeeAmount =:p29SettlementFeeAmount");
                map.put("p29SettlementFeeAmount", String.valueOf(bean.getP29SettlementFeeAmount()));

            }
            if (bean.getP30OriginalAmount() != null && !bean.getP30OriginalAmount().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p30OriginalAmount=:p30OriginalAmount");
                map.put("p30OriginalAmount", bean.getP30OriginalAmount());

            }
            if (bean.getP31AcquirerRefLength() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p31AcquirerRefData=:p31AcquirerRefData");
                map.put("p31AcquirerRefData", bean.getP31AcquirerRefLength());

            }
            if (bean.getP31AcquirerRefData() != null && !bean.getP31AcquirerRefData().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p31AcquirerRefLength=:p31AcquirerRefLength");
                map.put("p31AcquirerRefLength", String.valueOf(bean.getP31AcquirerRefData()));

            }
            if (bean.getP32AcquiringInstLength() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p32AcquiringInstLength=:p32AcquiringInstLength");
                map.put("p32AcquiringInstLength", String.valueOf(bean.getP32AcquiringInstLength()));

            }
            if (bean.getP32AcquiringInstCode() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p32AcquiringInstCode=:p32AcquiringInstCode");
                map.put("p32AcquiringInstCode", String.valueOf(bean.getP32AcquiringInstCode()));

            }
            if (bean.getP33ForwardingInstLength() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p33ForwardingInstLength=:p33ForwardingInstLength");
                map.put("p33ForwardingInstLength", String.valueOf(bean.getP33ForwardingInstLength()));

            }
            if (bean.getP33ForwardingInstCode() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p33ForwardingInstCode=:p33ForwardingInstCode");
                map.put("p33ForwardingInstCode", String.valueOf(bean.getP33ForwardingInstCode()));

            }
            if (bean.getP34ExtendedAccountNumber() != null && !bean.getP34ExtendedAccountNumber().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p34ExtendedAccountNumber=:p34ExtendedAccountNumber");
                map.put("p34ExtendedAccountNumber", bean.getP34ExtendedAccountNumber());

            }
            if (bean.getP35Track2Data() != null && !bean.getP35Track2Data().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p35Track2Data=:p35Track2Data");
                map.put("p35Track2Data", bean.getP35Track2Data());

            }
            if (bean.getP36Track3Data() != null && !bean.getP36Track3Data().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p36Track3Data=:p36Track3Data");
                map.put("p36Track3Data", bean.getP36Track3Data());

            }
            if (bean.getP37RetrievalRefNumber() != null && !bean.getP37RetrievalRefNumber().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p37RetrievalRefNumber=:p37RetrievalRefNumber");
                map.put("p37RetrievalRefNumber", bean.getP37RetrievalRefNumber());

            }
            if (bean.getP38ApprovalCode() != null && !bean.getP38ApprovalCode().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p38ApprovalCode=:p38ApprovalCode");
                map.put("p38ApprovalCode", bean.getP38ApprovalCode());

            }
            if (bean.getP39ResponseCode() != null && !bean.getP39ResponseCode().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p39ResponseCode=:p39ResponseCode");
                map.put("p39ResponseCode", bean.getP39ResponseCode());

            }
            if (bean.getP40ServiceCode() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p40ServiceCode=:p40ServiceCode");
                map.put("p40ServiceCode", String.valueOf(bean.getP40ServiceCode()));

            }
            if (bean.getP41CardAcceptorTerminalId() != null && !bean.getP41CardAcceptorTerminalId().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p41CardAcceptorTerminalId=:p41CardAcceptorTerminalId");
                map.put("p41CardAcceptorTerminalId", bean.getP41CardAcceptorTerminalId());

            }
            if (bean.getP42CardAcceptorId() != null && !bean.getP42CardAcceptorId().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p42CardAcceptorId=:p42CardAcceptorId");
                map.put("p42CardAcceptorId", bean.getP42CardAcceptorId());

            }
            if (bean.getP43CardAcceptorLength() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p43CardAcceptorLength=:p43CardAcceptorLength");
                map.put("p43CardAcceptorLength", String.valueOf(bean.getP43CardAcceptorLength()));

            }
            if (bean.getP43CardAcceptorName() != null && !bean.getP43CardAcceptorName().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p43CardAcceptorName=:p43CardAcceptorName");
                map.put("p43CardAcceptorName", bean.getP43CardAcceptorLength());
            }
            if (bean.getP44AdditionalResponseData() != null && !bean.getP44AdditionalResponseData().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p44AdditionalResponseData=:p44AdditionalResponseData");
                map.put("p44AdditionalResponseData", bean.getP44AdditionalResponseData());

            }
            if (bean.getP45Track1Data() != null && !bean.getP45Track1Data().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p45Track1Data=:p45Track1Data");
                map.put("p45Track1Data", bean.getP45Track1Data());

            }
            if (bean.getP46AdditionalDataIso() != null && !bean.getP46AdditionalDataIso().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p46AdditionalDataIso=:p46AdditionalDataIso");
                map.put("p46AdditionalDataIso", bean.getP46AdditionalDataIso());

            }
            if (bean.getP47AdditionalDataNational() != null && !bean.getP47AdditionalDataNational().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p47AdditionalDataNational=:p47AdditionalDataNational");
                map.put("p47AdditionalDataNational", bean.getP47AdditionalDataNational());

            }
            if (bean.getP48AdditionalDataLength() != null && !bean.getP48AdditionalDataLength().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p48AdditionalDataLength=:p48AdditionalDataLength");
                map.put("p48AdditionalDataLength", bean.getP48AdditionalDataLength());

            }
            if (bean.getP48AdditionalData() != null && !bean.getP48AdditionalData().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p48AdditionalData=:p48AdditionalData");
                map.put("p48AdditionalData", bean.getP48AdditionalData());

            }
            if (bean.getP49CurrencyCode() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p49CurrencyCode=:p49CurrencyCode");
                map.put("p49CurrencyCode", String.valueOf(bean.getP49CurrencyCode()));

            }
            if (bean.getP50ReconcilliationCode() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p50ReconcilliationCode=:p50ReconcilliationCode");
                map.put("p50ReconcilliationCode", String.valueOf(bean.getP50ReconcilliationCode()));

            }
            if (bean.getP51CardholderBillCurCode() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p51CardholderBillCurCode=:p51CardholderBillCurCode");
                map.put("p51CardholderBillCurCode", String.valueOf(bean.getP51CardholderBillCurCode()));

            }
            if (bean.getP52PersonalIdNumber() != null && !bean.getP52PersonalIdNumber().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p52PersonalIdNumber=:p52PersonalIdNumber");
                map.put("p52PersonalIdNumber", bean.getP52PersonalIdNumber());

            }
            if (bean.getP53SecurityRelControlInfo() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p53SecurityRelControlInfo=:p53SecurityRelControlInfo");
                map.put("p53SecurityRelControlInfo", String.valueOf(bean.getP53SecurityRelControlInfo()));

            }
            if (bean.getP54AdditionalAmntLength() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p54AdditionalAmntLength=:p54AdditionalAmntLength");
                map.put("p54AdditionalAmntLength", String.valueOf(bean.getP54AdditionalAmntLength()));

            }
            if (bean.getP54AdditionalAmounts() != null && !bean.getP54AdditionalAmounts().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p54AdditionalAmounts=:p54AdditionalAmounts");
                map.put("p54AdditionalAmounts", bean.getP54AdditionalAmounts());

            }
            if (bean.getP55IccLength() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p55IccLength=:p55IccLength");
                map.put("p55IccLength", String.valueOf(bean.getP55IccLength()));

            }
            if (bean.getP55IccSystemRelatedData() != null && !bean.getP55IccSystemRelatedData().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p55IccSystemRelatedData=:p55IccSystemRelatedData");
                map.put("p55IccSystemRelatedData", bean.getP55IccSystemRelatedData());

            }
            if (bean.getP62AddLen() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p62AddLen=:p62AddLen");
                map.put("p62AddLen", String.valueOf(bean.getP62AddLen()));

            }
            if (bean.getP62AdditionalData() != null && !bean.getP62AdditionalData().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p62AdditionalData=:p62AdditionalData");
                map.put("p62AdditionalData", bean.getP62AdditionalData());

            }
            if (bean.getP63TxLifeCycleIdLength() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p63TxLifeCycleIdLength=:p63TxLifeCycleIdLength");
                map.put("p63TxLifeCycleIdLength", String.valueOf(bean.getP63TxLifeCycleIdLength()));

            }
            if (bean.getP63TransactionLifeCycleId() != null && !bean.getP63TransactionLifeCycleId().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p63TransactionLifeCycleId=:p63TransactionLifeCycleId");
                map.put("p63TransactionLifeCycleId", bean.getP63TransactionLifeCycleId());

            }
            if (bean.getP64PrimaryMac() != null && !bean.getP64PrimaryMac().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p64PrimaryMac=:p64PrimaryMac");
                map.put("p64PrimaryMac", bean.getP64PrimaryMac());

            }
            if (bean.getS66SettlemntCode() != null && !bean.getS66SettlemntCode().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s66SettlemntCode=:s66SettlemntCode");
                map.put("s66SettlemntCode", bean.getS66SettlemntCode());

            }
            if (bean.getS67ExtendedPaymentCode() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s67ExtendedPaymentCode=:s67ExtendedPaymentCode");
                map.put("s67ExtendedPaymentCode", String.valueOf(bean.getS67ExtendedPaymentCode()));

            }
            if (bean.getS68RecInstCountryCode() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s68RecInstCountryCode=:s68RecInstCountryCode");
                map.put("s68RecInstCountryCode", String.valueOf(bean.getS68RecInstCountryCode()));

            }
            if (bean.getS69SettleInstCountryCode() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s69SettleInstCountryCode=:s69SettleInstCountryCode");
                map.put("s69SettleInstCountryCode", String.valueOf(bean.getS69SettleInstCountryCode()));

            }
            if (bean.getS70NetworkManCountryCode() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s70NetworkManCountryCode=:s70NetworkManCountryCode");
                map.put("s70NetworkManCountryCode", String.valueOf(bean.getS70NetworkManCountryCode()));

            }
            if (bean.getS71MessageNumber() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s71MessageNumber=:s71MessageNumber");
                map.put("s71MessageNumber", String.valueOf(bean.getS71MessageNumber()));

            }
            if (bean.getS72DataLen() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s72DataLen=:s72DataLen");
                map.put("s72DataLen", String.valueOf(bean.getS72DataLen()));

            }
            if (bean.getS72DataRecord() != null && !bean.getS72DataRecord().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s72DataRecord=:s72DataRecord");
                map.put("s72DataRecord", bean.getS72DataRecord());

            }
            if (bean.getS73ActionDate() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s73ActionDate=:s73ActionDate");
                map.put("s73ActionDate", String.valueOf(bean.getS73ActionDate()));

            }
            if (bean.getS74NoOfCredits() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s74NoOfCredits=:s74NoOfCredits");
                map.put("s74NoOfCredits", String.valueOf(bean.getS74NoOfCredits()));

            }
            if (bean.getS75ReversalNoOfCredits() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s75ReversalNoOfCredits=:s75ReversalNoOfCredits");
                map.put("s75ReversalNoOfCredits", String.valueOf(bean.getS75ReversalNoOfCredits()));

            }
            if (bean.getS76NoOfDebits() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s76NoOfDebits=:s76NoOfDebits");
                map.put("s76NoOfDebits", String.valueOf(bean.getS76NoOfDebits()));

            }
            if (bean.getS77ReversalNoOfDebits() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s77ReversalNoOfDebits=:s77ReversalNoOfDebits");
                map.put("s77ReversalNoOfDebits", String.valueOf(bean.getS77ReversalNoOfDebits()));

            }
            if (bean.getS78NumberTransfers() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s78NumberTransfers=:s78NumberTransfers");
                map.put("s78NumberTransfers", String.valueOf(bean.getS78NumberTransfers()));

            }
            if (bean.getS79ReversalNumberTransfers() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s79ReversalNumberTransfers=:s79ReversalNumberTransfers");
                map.put("s79ReversalNumberTransfers", String.valueOf(bean.getS79ReversalNumberTransfers()));

            }
            if (bean.getS80NumberEnquiries() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s80NumberEnquiries=:s80NumberEnquiries");
                map.put("s80NumberEnquiries", String.valueOf(bean.getS80NumberEnquiries()));

            }
            if (bean.getS81NumberAuthorisations() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s81NumberAuthorisations=:s81NumberAuthorisations");
                map.put("s81NumberAuthorisations", String.valueOf(bean.getS81NumberAuthorisations()));

            }
            if (bean.getS82ProcessingFeeCredits() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s82ProcessingFeeCredits=:s82ProcessingFeeCredits");
                map.put("s82ProcessingFeeCredits", String.valueOf(bean.getS82ProcessingFeeCredits()));

            }
            if (bean.getS83TransactionFeeCredits() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s83TransactionFeeCredits=:s83TransactionFeeCredits");
                map.put("s83TransactionFeeCredits", String.valueOf(bean.getS83TransactionFeeCredits()));

            }
            if (bean.getS84ProcessingFeeDebits() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s84ProcessingFeeDebits=:s84ProcessingFeeDebits");
                map.put("s84ProcessingFeeDebits", String.valueOf(bean.getS84ProcessingFeeDebits()));

            }
            if (bean.getS85TransctionFeeAmounts() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s85TransctionFeeAmounts=:s85TransctionFeeAmounts");
                map.put("s85TransctionFeeAmounts", String.valueOf(bean.getS85TransctionFeeAmounts()));

            }
            if (bean.getS86AmountCredits() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s86AmountCredits=:s86AmountCredits");
                map.put("s86AmountCredits", String.valueOf(bean.getS86AmountCredits()));

            }
            if (bean.getS87ReversalAmountCredits() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s87ReversalAmountCredits=:s87ReversalAmountCredits");
                map.put("s87ReversalAmountCredits", String.valueOf(bean.getS87ReversalAmountCredits()));

            }
            if (bean.getS88AmountDebits() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s88AmountDebits=:s88AmountDebits");
                map.put("s88AmountDebits", String.valueOf(bean.getS88AmountDebits()));

            }
            if (bean.getS89ReversalAmountDebits() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s89ReversalAmountDebits=:s89ReversalAmountDebits");
                map.put("s89ReversalAmountDebits", String.valueOf(bean.getS89ReversalAmountDebits()));

            }
            if (bean.getS90OriginatingDataElements() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s90OriginatingDataElements=:s90OriginatingDataElements");
                map.put("s90OriginatingDataElements", String.valueOf(bean.getS90OriginatingDataElements()));

            }
            if (bean.getS91FileUpdateCode() != null && !bean.getS91FileUpdateCode().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s91FileUpdateCode=:s91FileUpdateCode");
                map.put("s91FileUpdateCode", String.valueOf(bean.getS91FileUpdateCode()));

            }
            if (bean.getS92FilesSecurityCode() != null && !bean.getS92FilesSecurityCode().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s92FilesSecurityCode=:s92FilesSecurityCode");
                map.put("s92FilesSecurityCode", String.valueOf(bean.getS92FilesSecurityCode()));

            }
            if (bean.getS93Length() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s93Length=:s93Length");
                map.put("s93Length", String.valueOf(bean.getS93Length()));

            }
            if (bean.getS93TransactionDestInstId() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s93TransactionDestInstId=:s93TransactionDestInstId");
                map.put("s93TransactionDestInstId", String.valueOf(bean.getS93TransactionDestInstId()));

            }
            if (bean.getS94Length() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s94Length=:s94Length");
                map.put("s94Length", String.valueOf(bean.getS94Length()));

            }
            if (bean.getS94TransactionOrigInstId() != null && !bean.getS94TransactionOrigInstId().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s94TransactionOrigInstId=:s94TransactionOrigInstId");
                map.put("s94TransactionOrigInstId", String.valueOf(bean.getS94TransactionOrigInstId()));

            }
            if (bean.getS95CardIssRefDataLength() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s95CardIssRefDataLength=:s95CardIssRefDataLength");
                map.put("s95CardIssRefDataLength", String.valueOf(bean.getS95CardIssRefDataLength()));

            }
            if (bean.getS95CardIssuerRefData() != null && !bean.getS95CardIssuerRefData().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s95CardIssuerRefData=:s95CardIssuerRefData");
                map.put("s95CardIssuerRefData", bean.getS95CardIssuerRefData());
            }
            if (bean.getS96MessageSecurityCode() != null && !bean.getS96MessageSecurityCode().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s96MessageSecurityCode=:s96MessageSecurityCode");
                map.put("s96MessageSecurityCode", bean.getS96MessageSecurityCode());

            }
            if (bean.getS97NetSettlementAmount() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s97NetSettlementAmount=:s97NetSettlementAmount");
                map.put("s97NetSettlementAmount", String.valueOf(bean.getS97NetSettlementAmount()));

            }
            if (bean.getS98Payee() != null && !bean.getS98Payee().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s98Payee=:s98Payee");
                map.put("s98Payee", bean.getS98Payee());

            }
            if (bean.getS99SettlementInstIdCode() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s99SettlementInstIdCode=:s99SettlementInstIdCode");
                map.put("s99SettlementInstIdCode", String.valueOf(bean.getS99SettlementInstIdCode()));

            }
            if (bean.getS100RiiLen() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s100RiiLen=:s100RiiLen");
                map.put("s100RiiLen", String.valueOf(bean.getS100RiiLen()));

            }
            if (bean.getS100RcvingInstIdCode() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s100RcvingInstIdCode=:s100RcvingInstIdCode");
                map.put("s100RcvingInstIdCode", String.valueOf(bean.getS100RcvingInstIdCode()));

            }
            if (bean.getS101FileName() != null && !bean.getS101FileName().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s101FileName=:s101FileName");
                map.put("s101FileName", bean.getS101FileName());

            }
            if (bean.getS102AccountIdentification1() != null && !bean.getS102AccountIdentification1().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s102AccountIdentification1=:s102AccountIdentification1");
                map.put("s102AccountIdentification1", bean.getS102AccountIdentification1());

            }
            if (bean.getS103AccountIdentification2() != null && !bean.getS103AccountIdentification2().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s103AccountIdentification2=:s103AccountIdentification2");
                map.put("s103AccountIdentification2", bean.getS103AccountIdentification2());

            }
            if (bean.getS104TransactionDescription() != null && !bean.getS104TransactionDescription().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s104TransactionDescription=:s104TransactionDescription");
                map.put("s104TransactionDescription", bean.getS103AccountIdentification2());

            }
            if (bean.getS111Length() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s111Length=:s111Length");
                map.put("s111Length", String.valueOf(bean.getS111Length()));

            }
            if (bean.getS111AmtCurrencyConversion() != null && !bean.getS111AmtCurrencyConversion().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s111AmtCurrencyConversion=:s111AmtCurrencyConversion");
                map.put("s111AmtCurrencyConversion", bean.getS111AmtCurrencyConversion());

            }
            if (bean.getS123AddLen() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s123AddLen=:s123AddLen");
                map.put("s123AddLen", String.valueOf(bean.getS123AddLen()));

            }
            if (bean.getS123AdditionalData() != null && !bean.getS123AdditionalData().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s123AdditionalData=:s123AdditionalData");
                map.put("s123AdditionalData", bean.getS123AdditionalData());

            }
            if (bean.getS124AddLen() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s124AddLen=:s124AddLen");
                map.put("s124AddLen", String.valueOf(bean.getS124AddLen()));

            }
            if (bean.getS124AdditionalData() != null && !bean.getS124AdditionalData().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s124AdditionalData=:s124AdditionalData");
                map.put("s124AdditionalData", bean.getS124AdditionalData());

            }
            if (bean.getS125AddLen() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s125AddLen=:s125AddLen");
                map.put("s125AddLen", String.valueOf(bean.getS125AddLen()));

            }
            if (bean.getS125AdditionalData() != null && !bean.getS125AdditionalData().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s125AdditionalData=:s125AdditionalData");
                map.put("s125AdditionalData", bean.getS125AdditionalData());

            }
            if (bean.getS127NetworkData() != null && !bean.getS127NetworkData().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.s127NetworkData=:s127NetworkData");
                map.put("s127NetworkData", bean.getS127NetworkData());

            }
            if (bean.getInputFileIdentifier() != null && !bean.getInputFileIdentifier().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.inputFileIdentifier=:inputFileIdentifier");
                map.put("inputFileIdentifier", String.valueOf(bean.getInputFileIdentifier()));

            }
            if (bean.getSeqNo() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.seqNo=:seqNo");
                map.put("seqNo", String.valueOf(bean.getSeqNo()));

            }

            if (bean.getProcessStatus() != null && !bean.getProcessStatus().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.processStatus=:processStatus");
                map.put("processStatus", bean.getProcessStatus());

            }
            if (bean.getRecordId() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.recordId=:recordId");
                map.put("recordId", String.valueOf(bean.getRecordId()));

            }
            if (bean.getTransactionCode() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.transactionCode=:transactionCode");
                map.put("transactionCode", String.valueOf(bean.getTransactionCode()));

            }
            if (bean.getCardType() != null && !bean.getCardType().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.cardType=:cardType");
                map.put("cardType", bean.getCardType());

            }
            if (bean.getFilenameDescription() != null && !bean.getFilenameDescription().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.filenameDescription=:filenameDescription");
                map.put("filenameDescription", bean.getFilenameDescription());

            }
            if (bean.getP55IccSysDataRaw() != null) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.p55IccSysDataRaw=:p55IccSysDataRaw");
                map.put("p55IccSysDataRaw", String.valueOf(bean.getP55IccSysDataRaw()));

            }
            if (bean.getIrd() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.ird=:ird");
                map.put("ird", String.valueOf(bean.getIrd()));

            }
            if (bean.getCashbackPurchase() != null && !bean.getCashbackPurchase().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.cashbackPurchase=:cashbackPurchase");
                map.put("cashbackPurchase", bean.getCashbackPurchase());

            }
            if (bean.getCashbackPurchaseAmnt() > 0.0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.cashbackPurchaseAmnt=:cashbackPurchaseAmnt");
                map.put("cashbackPurchaseAmnt", String.valueOf(bean.getCashbackPurchaseAmnt()));

            }
        }
        if (!whereClause && select == false) {
            throw new DAOException("Cannot build all rows in CCCOWNER.CsoPaymentInstructionsMcard");
        }

        return buff.toString();
    }

    public void update(CsoPaymentInstructionsMcardDTO bean) throws DAOException {

        CsoPaymentInstructionsMcardPK csoPaymentInstructionsMcardPK = new CsoPaymentInstructionsMcardPK();
        csoPaymentInstructionsMcardPK.setFileRefNumber1(bean.getFileRefNumber1());
        csoPaymentInstructionsMcardPK.setSystemSeqNumber2(bean.getSystemSeqNumber2());

        CsoPaymentInstructionsMcard csoPaymentInstructionsMcard = new CsoPaymentInstructionsMcard();
        csoPaymentInstructionsMcard.setCsoPaymentInstructionsMcardPK(csoPaymentInstructionsMcardPK);
        csoPaymentInstructionsMcard.setServiceCode(bean.getServiceCode());
        csoPaymentInstructionsMcard.setSubServiceName(bean.getSubServiceName());
        csoPaymentInstructionsMcard.setAcquirerMember((short) bean.getAcquirerMember());
        csoPaymentInstructionsMcard.setIssuerMember((short) bean.getIssuerMember());
        csoPaymentInstructionsMcard.setMastercardAmount(bean.getMastercardAmount());
        csoPaymentInstructionsMcard.setFinancialIndicator(bean.getFinancialIndicator());
        csoPaymentInstructionsMcard.setPrimaryBitmap(bean.getPrimaryBitmap());
        csoPaymentInstructionsMcard.setSecondaryBitmap(bean.getSecondaryBitmap());
        csoPaymentInstructionsMcard.setMessageTypeIndicator((short) bean.getMessageTypeIndicator());
        csoPaymentInstructionsMcard.setP2PanLength((short) bean.getP2PanLength());
        csoPaymentInstructionsMcard.setP2Pan(bean.getP2Pan());
        csoPaymentInstructionsMcard.setP3ProcessCode(bean.getP3ProcessCode());
        csoPaymentInstructionsMcard.setP4TransactionAmount(bean.getP4TransactionAmount());
        csoPaymentInstructionsMcard.setP5ReconclliationAmount(bean.getP5ReconclliationAmount());
        csoPaymentInstructionsMcard.setP6CardholderBilling(bean.getP6CardholderBilling());
        csoPaymentInstructionsMcard.setP7TransctionDateAndTime(bean.getP7TransctionDateAndTime());
        csoPaymentInstructionsMcard.setP8IccrAmount(bean.getP8IccrAmount());
        csoPaymentInstructionsMcard.setP9ReconConversionRate(bean.getP9ReconConversionRate());
        csoPaymentInstructionsMcard.setP10CardholderConvRate(bean.getP10CardholderConvRate());
        csoPaymentInstructionsMcard.setP11SystemTraceAuditNumber(bean.getP11SystemTraceAuditNumber());
        csoPaymentInstructionsMcard.setP12LocalDate(bean.getP12LocalDate());
        csoPaymentInstructionsMcard.setP13LocalTime((int) bean.getP13LocalTime());
        csoPaymentInstructionsMcard.setP14ExpirationDate(bean.getP14ExpirationDate());
        csoPaymentInstructionsMcard.setP15SettlementDate((short) bean.getP15SettlementDate());
        csoPaymentInstructionsMcard.setP16ConversionDate((short) bean.getP16ConversionDate());
        csoPaymentInstructionsMcard.setP17CaptureDate((short) bean.getP17CaptureDate());
        csoPaymentInstructionsMcard.setP18MerchantType((short) bean.getP18MerchantType());
        csoPaymentInstructionsMcard.setP19AcqBankInstitutionCode((short) bean.getP19AcqBankInstitutionCode());
        csoPaymentInstructionsMcard.setP20CountryCodePriAccNo((short) bean.getP20CountryCodePriAccNo());
        csoPaymentInstructionsMcard.setP21FwdingInstCountryCode((short) bean.getP21FwdingInstCountryCode());
        csoPaymentInstructionsMcard.setP22PointOfSaleData(bean.getP22PointOfSaleData());
        csoPaymentInstructionsMcard.setP23CardSequenceNumber((short) bean.getP23CardSequenceNumber());
        csoPaymentInstructionsMcard.setP24FunctionCode((short) bean.getP24FunctionCode());
        csoPaymentInstructionsMcard.setP25MessageReasonCode((short) bean.getP25MessageReasonCode());
        csoPaymentInstructionsMcard.setP26CardAcceptorBusCode((short) bean.getP26CardAcceptorBusCode());
        csoPaymentInstructionsMcard.setP27AuthIdResponseLength((short) bean.getP27AuthIdResponseLength());
        csoPaymentInstructionsMcard.setP28TransactionFeeAmount(bean.getP28TransactionFeeAmount());
        csoPaymentInstructionsMcard.setP29SettlementFeeAmount(bean.getP29SettlementFeeAmount());
        csoPaymentInstructionsMcard.setP30OriginalAmount(bean.getP30OriginalAmount());
        csoPaymentInstructionsMcard.setP31AcquirerRefLength((short) bean.getP31AcquirerRefLength());
        csoPaymentInstructionsMcard.setP31AcquirerRefData(bean.getP31AcquirerRefData());
        csoPaymentInstructionsMcard.setP32AcquiringInstLength((short) bean.getP32AcquiringInstLength());
        csoPaymentInstructionsMcard.setP32AcquiringInstCode(bean.getP32AcquiringInstCode());
        csoPaymentInstructionsMcard.setP33ForwardingInstLength((short) bean.getP33ForwardingInstLength());
        csoPaymentInstructionsMcard.setP33ForwardingInstCode(bean.getP33ForwardingInstCode());
        csoPaymentInstructionsMcard.setP34ExtendedAccountNumber(bean.getP34ExtendedAccountNumber());
        csoPaymentInstructionsMcard.setP35Track2Data(bean.getP35Track2Data());
        csoPaymentInstructionsMcard.setP36Track3Data(bean.getP36Track3Data());
        csoPaymentInstructionsMcard.setP37RetrievalRefNumber(bean.getP37RetrievalRefNumber());
        csoPaymentInstructionsMcard.setP38ApprovalCode(bean.getP38ApprovalCode());
        csoPaymentInstructionsMcard.setP39ResponseCode(bean.getP39ResponseCode());
        csoPaymentInstructionsMcard.setP40ServiceCode((short) bean.getP40ServiceCode());
        csoPaymentInstructionsMcard.setP41CardAcceptorTerminalId(bean.getP41CardAcceptorTerminalId());
        csoPaymentInstructionsMcard.setP42CardAcceptorId(bean.getP42CardAcceptorId());
        csoPaymentInstructionsMcard.setP43CardAcceptorLength((short) bean.getP43CardAcceptorLength());
        csoPaymentInstructionsMcard.setP43CardAcceptorName(bean.getP43CardAcceptorName());
        csoPaymentInstructionsMcard.setP44AdditionalResponseData(bean.getP44AdditionalResponseData());
        csoPaymentInstructionsMcard.setP45Track1Data(bean.getP45Track1Data());
        csoPaymentInstructionsMcard.setP46AdditionalDataIso(bean.getP46AdditionalDataIso());
        csoPaymentInstructionsMcard.setP47AdditionalDataNational(bean.getP47AdditionalDataNational());
        csoPaymentInstructionsMcard.setP48AdditionalDataLength(bean.getP48AdditionalDataLength());
        csoPaymentInstructionsMcard.setP48AdditionalData(bean.getP48AdditionalData());
        csoPaymentInstructionsMcard.setP49CurrencyCode((short) bean.getP49CurrencyCode());
        csoPaymentInstructionsMcard.setP50ReconcilliationCode((short) bean.getP50ReconcilliationCode());
        csoPaymentInstructionsMcard.setP51CardholderBillCurCode((short) bean.getP51CardholderBillCurCode());
        csoPaymentInstructionsMcard.setP52PersonalIdNumber(bean.getP52PersonalIdNumber());
        csoPaymentInstructionsMcard.setP53SecurityRelControlInfo(bean.getP53SecurityRelControlInfo());
        csoPaymentInstructionsMcard.setP54AdditionalAmntLength((short) bean.getP54AdditionalAmntLength());
        csoPaymentInstructionsMcard.setP54AdditionalAmounts(bean.getP54AdditionalAmounts());
        csoPaymentInstructionsMcard.setP55IccLength((short) bean.getP55IccLength());
        csoPaymentInstructionsMcard.setP55IccSystemRelatedData(bean.getP55IccSystemRelatedData());
        csoPaymentInstructionsMcard.setP62AddLen((short) bean.getP62AddLen());
        csoPaymentInstructionsMcard.setP35Track2Data(bean.getP62AdditionalData());
        csoPaymentInstructionsMcard.setP36Track3Data(bean.getP62AdditionalData());
        csoPaymentInstructionsMcard.setP37RetrievalRefNumber(bean.getP63TransactionLifeCycleId());
        csoPaymentInstructionsMcard.setP38ApprovalCode(bean.getP64PrimaryMac());
        csoPaymentInstructionsMcard.setP39ResponseCode(bean.getS66SettlemntCode());
        csoPaymentInstructionsMcard.setS67ExtendedPaymentCode((short) bean.getS67ExtendedPaymentCode());
        csoPaymentInstructionsMcard.setS68RecInstCountryCode((short) bean.getS68RecInstCountryCode());
        csoPaymentInstructionsMcard.setS69SettleInstCountryCode((short) bean.getS69SettleInstCountryCode());
        csoPaymentInstructionsMcard.setP43CardAcceptorLength((short) bean.getS70NetworkManCountryCode());
        csoPaymentInstructionsMcard.setP43CardAcceptorName(bean.getP43CardAcceptorName());
        csoPaymentInstructionsMcard.setP44AdditionalResponseData(bean.getP44AdditionalResponseData());
        csoPaymentInstructionsMcard.setP45Track1Data(bean.getP45Track1Data());
        csoPaymentInstructionsMcard.setP46AdditionalDataIso(bean.getP46AdditionalDataIso());
        csoPaymentInstructionsMcard.setP47AdditionalDataNational(bean.getP47AdditionalDataNational());
        csoPaymentInstructionsMcard.setP48AdditionalDataLength(bean.getP48AdditionalDataLength());
        csoPaymentInstructionsMcard.setP48AdditionalData(bean.getP48AdditionalData());
        csoPaymentInstructionsMcard.setP49CurrencyCode((short) bean.getP49CurrencyCode());
        csoPaymentInstructionsMcard.setP50ReconcilliationCode((short) bean.getP50ReconcilliationCode());
        csoPaymentInstructionsMcard.setP51CardholderBillCurCode((short) bean.getP51CardholderBillCurCode());
        csoPaymentInstructionsMcard.setP52PersonalIdNumber(bean.getP52PersonalIdNumber());
        csoPaymentInstructionsMcard.setS71MessageNumber(bean.getS71MessageNumber());
        csoPaymentInstructionsMcard.setS72DataLen((short) bean.getS72DataLen());
        csoPaymentInstructionsMcard.setS72DataRecord(bean.getS72DataRecord());
        csoPaymentInstructionsMcard.setS73ActionDate(bean.getS73ActionDate());
        csoPaymentInstructionsMcard.setS76NoOfDebits(bean.getS74NoOfCredits());
        csoPaymentInstructionsMcard.setS75ReversalNoOfCredits(bean.getS75ReversalNoOfCredits());
        csoPaymentInstructionsMcard.setS76NoOfDebits(bean.getS76NoOfDebits());
        csoPaymentInstructionsMcard.setS77ReversalNoOfDebits(bean.getS77ReversalNoOfDebits());
        csoPaymentInstructionsMcard.setS78NumberTransfers(bean.getS78NumberTransfers());
        csoPaymentInstructionsMcard.setS79ReversalNumberTransfers(bean.getS79ReversalNumberTransfers());
        csoPaymentInstructionsMcard.setS80NumberEnquiries(bean.getS80NumberEnquiries());
        csoPaymentInstructionsMcard.setS81NumberAuthorisations(bean.getS81NumberAuthorisations());
        csoPaymentInstructionsMcard.setS82ProcessingFeeCredits(bean.getS82ProcessingFeeCredits());
        csoPaymentInstructionsMcard.setS83TransactionFeeCredits(bean.getS83TransactionFeeCredits());
        csoPaymentInstructionsMcard.setS84ProcessingFeeDebits(bean.getS84ProcessingFeeDebits());
        csoPaymentInstructionsMcard.setS85TransctionFeeAmounts(bean.getS85TransctionFeeAmounts());
        csoPaymentInstructionsMcard.setS86AmountCredits(bean.getS86AmountCredits());
        csoPaymentInstructionsMcard.setS87ReversalAmountCredits(bean.getS87ReversalAmountCredits());
        csoPaymentInstructionsMcard.setS88AmountDebits(bean.getS88AmountDebits());
        csoPaymentInstructionsMcard.setS89ReversalAmountDebits(bean.getS89ReversalAmountDebits());
        csoPaymentInstructionsMcard.setS90OriginatingDataElements(bean.getS90OriginatingDataElements());
        csoPaymentInstructionsMcard.setS91FileUpdateCode(bean.getS91FileUpdateCode());
        csoPaymentInstructionsMcard.setS92FilesSecurityCode(bean.getS92FilesSecurityCode());
        csoPaymentInstructionsMcard.setS93Length((short) bean.getS93Length());
        csoPaymentInstructionsMcard.setS93TransactionDestInstId(bean.getS93TransactionDestInstId());
        csoPaymentInstructionsMcard.setS94Length((short) bean.getS94Length());
        csoPaymentInstructionsMcard.setS94TransactionOrigInstId(bean.getS94TransactionOrigInstId());
        csoPaymentInstructionsMcard.setS95CardIssRefDataLength((short) bean.getS95CardIssRefDataLength());
        csoPaymentInstructionsMcard.setS95CardIssuerRefData(bean.getS95CardIssuerRefData());
        csoPaymentInstructionsMcard.setS96MessageSecurityCode(bean.getS96MessageSecurityCode());
        csoPaymentInstructionsMcard.setS97NetSettlementAmount(bean.getS97NetSettlementAmount());
        csoPaymentInstructionsMcard.setS98Payee(bean.getS98Payee());
        csoPaymentInstructionsMcard.setS99SettlementInstIdCode(bean.getS99SettlementInstIdCode());
        csoPaymentInstructionsMcard.setS100RiiLen((short) bean.getS100RiiLen());
        csoPaymentInstructionsMcard.setS100RcvingInstIdCode(bean.getS100RcvingInstIdCode());
        csoPaymentInstructionsMcard.setS101FileName(bean.getS101FileName());
        csoPaymentInstructionsMcard.setS102AccountIdentification1(bean.getS102AccountIdentification1());
        csoPaymentInstructionsMcard.setS103AccountIdentification2(bean.getS103AccountIdentification2());
        csoPaymentInstructionsMcard.setS104TransactionDescription(bean.getS104TransactionDescription());
        csoPaymentInstructionsMcard.setS111Length((short) bean.getS111Length());
        csoPaymentInstructionsMcard.setS111AmtCurrencyConversion(bean.getS111AmtCurrencyConversion());
        csoPaymentInstructionsMcard.setS123AddLen((short) bean.getS123AddLen());
        csoPaymentInstructionsMcard.setS123AdditionalData(bean.getS123AdditionalData());
        csoPaymentInstructionsMcard.setS124AddLen((short) bean.getS124AddLen());
        csoPaymentInstructionsMcard.setS124AdditionalData(bean.getS124AdditionalData());
        csoPaymentInstructionsMcard.setS125AddLen((short) bean.getS125AddLen());
        csoPaymentInstructionsMcard.setS125AdditionalData(bean.getS125AdditionalData());
        csoPaymentInstructionsMcard.setS127NetworkData(bean.getS127NetworkData());
        csoPaymentInstructionsMcard.setInputFileIdentifier(bean.getInputFileIdentifier());
        csoPaymentInstructionsMcard.setSeqNo(bean.getSeqNo());
        csoPaymentInstructionsMcard.setProcessStatus(bean.getProcessStatus());
        csoPaymentInstructionsMcard.setRecordId((short) bean.getRecordId());
        csoPaymentInstructionsMcard.setTransactionCode(bean.getTransactionCode());
        csoPaymentInstructionsMcard.setCardType(bean.getCardType());
        csoPaymentInstructionsMcard.setFilenameDescription(bean.getFilenameDescription());
        csoPaymentInstructionsMcard.setP55IccSysDataRaw(bean.getP55IccSysDataRaw());
        csoPaymentInstructionsMcard.setIrd((short) bean.getIrd());
        csoPaymentInstructionsMcard.setCashbackPurchase(bean.getCashbackPurchase());
        csoPaymentInstructionsMcard.setCashbackPurchaseAmnt(BigDecimal.valueOf(bean.getCashbackPurchaseAmnt()));

        // SARB Billing Values
        csoPaymentInstructionsMcard.setPosEntryMode(bean.getPosEntryMode());
        csoPaymentInstructionsMcard.setChipCard(bean.getChipCard());
        csoPaymentInstructionsMcard.setEcommInd(bean.getEcommInd());
        csoPaymentInstructionsMcard.setCardPresent(bean.getCardPresent());
        csoPaymentInstructionsMcard.setRateDesc(bean.getRateDesc());
        csoPaymentInstructionsMcard.setTerminalCapability(bean.getTerminalCapability());
        csoPaymentInstructionsMcard.setInterchangeFee(bean.getInterchangeFee());
        csoPaymentInstructionsMcard.setInterchangePerc(bean.getInterchangePerc());
        csoPaymentInstructionsMcard.setInterchangeVat(bean.getInterchangeVat());

        try {

            csoPaymentInstructionsMcardDao.update(csoPaymentInstructionsMcard);

        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void delete(CsoPaymentInstructionsMcardDTO bean) throws DAOException {
        CsoPaymentInstructionsMcard csoPaymentInstructionsMcard = new CsoPaymentInstructionsMcard();

        CsoPaymentInstructionsMcardPK csoPaymentInstructionsMcardPK = new CsoPaymentInstructionsMcardPK();
        csoPaymentInstructionsMcardPK.setFileRefNumber1(bean.getFileRefNumber1());
        csoPaymentInstructionsMcardPK.setSystemSeqNumber2(bean.getSystemSeqNumber2());

        csoPaymentInstructionsMcard.setCsoPaymentInstructionsMcardPK(csoPaymentInstructionsMcardPK);
        csoPaymentInstructionsMcard.setServiceCode(bean.getServiceCode());
        csoPaymentInstructionsMcard.setSubServiceName(bean.getSubServiceName());
        csoPaymentInstructionsMcard.setAcquirerMember((short) bean.getAcquirerMember());
        csoPaymentInstructionsMcard.setIssuerMember((short) bean.getIssuerMember());
        csoPaymentInstructionsMcard.setMastercardAmount(bean.getMastercardAmount());
        csoPaymentInstructionsMcard.setFinancialIndicator(bean.getFinancialIndicator());
        csoPaymentInstructionsMcard.setPrimaryBitmap(bean.getPrimaryBitmap());
        csoPaymentInstructionsMcard.setSecondaryBitmap(bean.getSecondaryBitmap());
        csoPaymentInstructionsMcard.setMessageTypeIndicator((short) bean.getMessageTypeIndicator());
        csoPaymentInstructionsMcard.setP2PanLength((short) bean.getP2PanLength());
        csoPaymentInstructionsMcard.setP2Pan(bean.getP2Pan());
        csoPaymentInstructionsMcard.setP3ProcessCode(bean.getP3ProcessCode());
        csoPaymentInstructionsMcard.setP4TransactionAmount(bean.getP4TransactionAmount());
        csoPaymentInstructionsMcard.setP5ReconclliationAmount(bean.getP5ReconclliationAmount());
        csoPaymentInstructionsMcard.setP6CardholderBilling(bean.getP6CardholderBilling());
        csoPaymentInstructionsMcard.setP7TransctionDateAndTime(bean.getP7TransctionDateAndTime());
        csoPaymentInstructionsMcard.setP8IccrAmount(bean.getP8IccrAmount());
        csoPaymentInstructionsMcard.setP9ReconConversionRate(bean.getP9ReconConversionRate());
        csoPaymentInstructionsMcard.setP10CardholderConvRate(bean.getP10CardholderConvRate());
        csoPaymentInstructionsMcard.setP11SystemTraceAuditNumber(bean.getP11SystemTraceAuditNumber());
        csoPaymentInstructionsMcard.setP12LocalDate(bean.getP12LocalDate());
        csoPaymentInstructionsMcard.setP13LocalTime((int) bean.getP13LocalTime());
        csoPaymentInstructionsMcard.setP14ExpirationDate(bean.getP14ExpirationDate());
        csoPaymentInstructionsMcard.setP15SettlementDate((short) bean.getP15SettlementDate());
        csoPaymentInstructionsMcard.setP16ConversionDate((short) bean.getP16ConversionDate());
        csoPaymentInstructionsMcard.setP17CaptureDate((short) bean.getP17CaptureDate());
        csoPaymentInstructionsMcard.setP18MerchantType((short) bean.getP18MerchantType());
        csoPaymentInstructionsMcard.setP19AcqBankInstitutionCode((short) bean.getP19AcqBankInstitutionCode());
        csoPaymentInstructionsMcard.setP20CountryCodePriAccNo((short) bean.getP20CountryCodePriAccNo());
        csoPaymentInstructionsMcard.setP21FwdingInstCountryCode((short) bean.getP21FwdingInstCountryCode());
        csoPaymentInstructionsMcard.setP22PointOfSaleData(bean.getP22PointOfSaleData());
        csoPaymentInstructionsMcard.setP23CardSequenceNumber((short) bean.getP23CardSequenceNumber());
        csoPaymentInstructionsMcard.setP24FunctionCode((short) bean.getP24FunctionCode());
        csoPaymentInstructionsMcard.setP25MessageReasonCode((short) bean.getP25MessageReasonCode());
        csoPaymentInstructionsMcard.setP26CardAcceptorBusCode((short) bean.getP26CardAcceptorBusCode());
        csoPaymentInstructionsMcard.setP27AuthIdResponseLength((short) bean.getP27AuthIdResponseLength());
        csoPaymentInstructionsMcard.setP28TransactionFeeAmount(bean.getP28TransactionFeeAmount());
        csoPaymentInstructionsMcard.setP29SettlementFeeAmount(bean.getP29SettlementFeeAmount());
        csoPaymentInstructionsMcard.setP30OriginalAmount(bean.getP30OriginalAmount());
        csoPaymentInstructionsMcard.setP31AcquirerRefLength((short) bean.getP31AcquirerRefLength());
        csoPaymentInstructionsMcard.setP31AcquirerRefData(bean.getP31AcquirerRefData());
        csoPaymentInstructionsMcard.setP32AcquiringInstLength((short) bean.getP32AcquiringInstLength());
        csoPaymentInstructionsMcard.setP32AcquiringInstCode(bean.getP32AcquiringInstCode());
        csoPaymentInstructionsMcard.setP33ForwardingInstLength((short) bean.getP33ForwardingInstLength());
        csoPaymentInstructionsMcard.setP33ForwardingInstCode(bean.getP33ForwardingInstCode());
        csoPaymentInstructionsMcard.setP34ExtendedAccountNumber(bean.getP34ExtendedAccountNumber());
        csoPaymentInstructionsMcard.setP35Track2Data(bean.getP35Track2Data());
        csoPaymentInstructionsMcard.setP36Track3Data(bean.getP36Track3Data());
        csoPaymentInstructionsMcard.setP37RetrievalRefNumber(bean.getP37RetrievalRefNumber());
        csoPaymentInstructionsMcard.setP38ApprovalCode(bean.getP38ApprovalCode());
        csoPaymentInstructionsMcard.setP39ResponseCode(bean.getP39ResponseCode());
        csoPaymentInstructionsMcard.setP40ServiceCode((short) bean.getP40ServiceCode());
        csoPaymentInstructionsMcard.setP41CardAcceptorTerminalId(bean.getP41CardAcceptorTerminalId());
        csoPaymentInstructionsMcard.setP42CardAcceptorId(bean.getP42CardAcceptorId());
        csoPaymentInstructionsMcard.setP43CardAcceptorLength((short) bean.getP43CardAcceptorLength());
        csoPaymentInstructionsMcard.setP43CardAcceptorName(bean.getP43CardAcceptorName());
        csoPaymentInstructionsMcard.setP44AdditionalResponseData(bean.getP44AdditionalResponseData());
        csoPaymentInstructionsMcard.setP45Track1Data(bean.getP45Track1Data());
        csoPaymentInstructionsMcard.setP46AdditionalDataIso(bean.getP46AdditionalDataIso());
        csoPaymentInstructionsMcard.setP47AdditionalDataNational(bean.getP47AdditionalDataNational());
        csoPaymentInstructionsMcard.setP48AdditionalDataLength(bean.getP48AdditionalDataLength());
        csoPaymentInstructionsMcard.setP48AdditionalData(bean.getP48AdditionalData());
        csoPaymentInstructionsMcard.setP49CurrencyCode((short) bean.getP49CurrencyCode());
        csoPaymentInstructionsMcard.setP50ReconcilliationCode((short) bean.getP50ReconcilliationCode());
        csoPaymentInstructionsMcard.setP51CardholderBillCurCode((short) bean.getP51CardholderBillCurCode());
        csoPaymentInstructionsMcard.setP52PersonalIdNumber(bean.getP52PersonalIdNumber());
        csoPaymentInstructionsMcard.setP53SecurityRelControlInfo(bean.getP53SecurityRelControlInfo());
        csoPaymentInstructionsMcard.setP54AdditionalAmntLength((short) bean.getP54AdditionalAmntLength());
        csoPaymentInstructionsMcard.setP54AdditionalAmounts(bean.getP54AdditionalAmounts());
        csoPaymentInstructionsMcard.setP55IccLength((short) bean.getP55IccLength());
        csoPaymentInstructionsMcard.setP55IccSystemRelatedData(bean.getP55IccSystemRelatedData());
        csoPaymentInstructionsMcard.setP62AddLen((short) bean.getP62AddLen());
        csoPaymentInstructionsMcard.setP35Track2Data(bean.getP62AdditionalData());
        csoPaymentInstructionsMcard.setP36Track3Data(bean.getP62AdditionalData());
        csoPaymentInstructionsMcard.setP37RetrievalRefNumber(bean.getP63TransactionLifeCycleId());
        csoPaymentInstructionsMcard.setP38ApprovalCode(bean.getP64PrimaryMac());
        csoPaymentInstructionsMcard.setP39ResponseCode(bean.getS66SettlemntCode());
        csoPaymentInstructionsMcard.setS67ExtendedPaymentCode((short) bean.getS67ExtendedPaymentCode());
        csoPaymentInstructionsMcard.setS68RecInstCountryCode((short) bean.getS68RecInstCountryCode());
        csoPaymentInstructionsMcard.setS69SettleInstCountryCode((short) bean.getS69SettleInstCountryCode());
        csoPaymentInstructionsMcard.setP43CardAcceptorLength((short) bean.getS70NetworkManCountryCode());
        csoPaymentInstructionsMcard.setP43CardAcceptorName(bean.getP43CardAcceptorName());
        csoPaymentInstructionsMcard.setP44AdditionalResponseData(bean.getP44AdditionalResponseData());
        csoPaymentInstructionsMcard.setP45Track1Data(bean.getP45Track1Data());
        csoPaymentInstructionsMcard.setP46AdditionalDataIso(bean.getP46AdditionalDataIso());
        csoPaymentInstructionsMcard.setP47AdditionalDataNational(bean.getP47AdditionalDataNational());
        csoPaymentInstructionsMcard.setP48AdditionalDataLength(bean.getP48AdditionalDataLength());
        csoPaymentInstructionsMcard.setP48AdditionalData(bean.getP48AdditionalData());
        csoPaymentInstructionsMcard.setP49CurrencyCode((short) bean.getP49CurrencyCode());
        csoPaymentInstructionsMcard.setP50ReconcilliationCode((short) bean.getP50ReconcilliationCode());
        csoPaymentInstructionsMcard.setP51CardholderBillCurCode((short) bean.getP51CardholderBillCurCode());
        csoPaymentInstructionsMcard.setP52PersonalIdNumber(bean.getP52PersonalIdNumber());
        csoPaymentInstructionsMcard.setS71MessageNumber(bean.getS71MessageNumber());
        csoPaymentInstructionsMcard.setS72DataLen((short) bean.getS72DataLen());
        csoPaymentInstructionsMcard.setS72DataRecord(bean.getS72DataRecord());
        csoPaymentInstructionsMcard.setS73ActionDate(bean.getS73ActionDate());
        csoPaymentInstructionsMcard.setS76NoOfDebits(bean.getS74NoOfCredits());
        csoPaymentInstructionsMcard.setS75ReversalNoOfCredits(bean.getS75ReversalNoOfCredits());
        csoPaymentInstructionsMcard.setS76NoOfDebits(bean.getS76NoOfDebits());
        csoPaymentInstructionsMcard.setS77ReversalNoOfDebits(bean.getS77ReversalNoOfDebits());
        csoPaymentInstructionsMcard.setS78NumberTransfers(bean.getS78NumberTransfers());
        csoPaymentInstructionsMcard.setS79ReversalNumberTransfers(bean.getS79ReversalNumberTransfers());
        csoPaymentInstructionsMcard.setS80NumberEnquiries(bean.getS80NumberEnquiries());
        csoPaymentInstructionsMcard.setS81NumberAuthorisations(bean.getS81NumberAuthorisations());
        csoPaymentInstructionsMcard.setS82ProcessingFeeCredits(bean.getS82ProcessingFeeCredits());
        csoPaymentInstructionsMcard.setS83TransactionFeeCredits(bean.getS83TransactionFeeCredits());
        csoPaymentInstructionsMcard.setS84ProcessingFeeDebits(bean.getS84ProcessingFeeDebits());
        csoPaymentInstructionsMcard.setS85TransctionFeeAmounts(bean.getS85TransctionFeeAmounts());
        csoPaymentInstructionsMcard.setS86AmountCredits(bean.getS86AmountCredits());
        csoPaymentInstructionsMcard.setS87ReversalAmountCredits(bean.getS87ReversalAmountCredits());
        csoPaymentInstructionsMcard.setS88AmountDebits(bean.getS88AmountDebits());
        csoPaymentInstructionsMcard.setS89ReversalAmountDebits(bean.getS89ReversalAmountDebits());
        csoPaymentInstructionsMcard.setS90OriginatingDataElements(bean.getS90OriginatingDataElements());
        csoPaymentInstructionsMcard.setS91FileUpdateCode(bean.getS91FileUpdateCode());
        csoPaymentInstructionsMcard.setS92FilesSecurityCode(bean.getS92FilesSecurityCode());
        csoPaymentInstructionsMcard.setS93Length((short) bean.getS93Length());
        csoPaymentInstructionsMcard.setS93TransactionDestInstId(bean.getS93TransactionDestInstId());
        csoPaymentInstructionsMcard.setS94Length((short) bean.getS94Length());
        csoPaymentInstructionsMcard.setS94TransactionOrigInstId(bean.getS94TransactionOrigInstId());
        csoPaymentInstructionsMcard.setS95CardIssRefDataLength((short) bean.getS95CardIssRefDataLength());
        csoPaymentInstructionsMcard.setS95CardIssuerRefData(bean.getS95CardIssuerRefData());
        csoPaymentInstructionsMcard.setS96MessageSecurityCode(bean.getS96MessageSecurityCode());
        csoPaymentInstructionsMcard.setS97NetSettlementAmount(bean.getS97NetSettlementAmount());
        csoPaymentInstructionsMcard.setS98Payee(bean.getS98Payee());
        csoPaymentInstructionsMcard.setS99SettlementInstIdCode(bean.getS99SettlementInstIdCode());
        csoPaymentInstructionsMcard.setS100RiiLen((short) bean.getS100RiiLen());
        csoPaymentInstructionsMcard.setS100RcvingInstIdCode(bean.getS100RcvingInstIdCode());
        csoPaymentInstructionsMcard.setS101FileName(bean.getS101FileName());
        csoPaymentInstructionsMcard.setS102AccountIdentification1(bean.getS102AccountIdentification1());
        csoPaymentInstructionsMcard.setS103AccountIdentification2(bean.getS103AccountIdentification2());
        csoPaymentInstructionsMcard.setS104TransactionDescription(bean.getS104TransactionDescription());
        csoPaymentInstructionsMcard.setS111Length((short) bean.getS111Length());
        csoPaymentInstructionsMcard.setS111AmtCurrencyConversion(bean.getS111AmtCurrencyConversion());
        csoPaymentInstructionsMcard.setS123AddLen((short) bean.getS123AddLen());
        csoPaymentInstructionsMcard.setS123AdditionalData(bean.getS123AdditionalData());
        csoPaymentInstructionsMcard.setS124AddLen((short) bean.getS124AddLen());
        csoPaymentInstructionsMcard.setS124AdditionalData(bean.getS124AdditionalData());
        csoPaymentInstructionsMcard.setS125AddLen((short) bean.getS125AddLen());
        csoPaymentInstructionsMcard.setS125AdditionalData(bean.getS125AdditionalData());
        csoPaymentInstructionsMcard.setS127NetworkData(bean.getS127NetworkData());
        csoPaymentInstructionsMcard.setInputFileIdentifier(bean.getInputFileIdentifier());
        csoPaymentInstructionsMcard.setSeqNo(bean.getSeqNo());
        csoPaymentInstructionsMcard.setProcessStatus(bean.getProcessStatus());
        csoPaymentInstructionsMcard.setRecordId((short) bean.getRecordId());
        csoPaymentInstructionsMcard.setTransactionCode((short) bean.getTransactionCode());
        csoPaymentInstructionsMcard.setCardType(bean.getCardType());
        csoPaymentInstructionsMcard.setFilenameDescription(bean.getFilenameDescription());
        csoPaymentInstructionsMcard.setP55IccSysDataRaw(bean.getP55IccSysDataRaw());
        csoPaymentInstructionsMcard.setIrd((short) bean.getIrd());
        csoPaymentInstructionsMcard.setCashbackPurchase(bean.getCashbackPurchase());
        csoPaymentInstructionsMcard.setCashbackPurchaseAmnt(BigDecimal.valueOf(bean.getCashbackPurchaseAmnt()));

        csoPaymentInstructionsMcardDao.delete(csoPaymentInstructionsMcard);

    }

    public void deletePayment() throws DAOException {

        csoPaymentInstructionsMcardDao.deleteTruncate("TRUNCATE TABLE CSO_PAYMENT_INSTRUCTIONS_MCARD");
        csoPaymentInstructionsMcardDao.deleteTruncate("TRUNCATE TABLE CSO_CCR030_MCARD");

    }
}
