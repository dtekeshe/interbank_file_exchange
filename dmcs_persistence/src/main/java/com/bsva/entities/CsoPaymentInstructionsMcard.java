/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSO_PAYMENT_INSTRUCTIONS_MCARD")
@NamedQueries({
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findAll", query = "SELECT c FROM CsoPaymentInstructionsMcard c"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByFileRefNumber1", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.csoPaymentInstructionsMcardPK.fileRefNumber1 = :fileRefNumber1"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findBySystemSeqNumber2", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.csoPaymentInstructionsMcardPK.systemSeqNumber2 = :systemSeqNumber2"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByServiceCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.serviceCode = :serviceCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findBySubServiceName", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.subServiceName = :subServiceName"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByAcquirerMember", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.acquirerMember = :acquirerMember"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByIssuerMember", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.issuerMember = :issuerMember"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByMastercardAmount", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.mastercardAmount = :mastercardAmount"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByFinancialIndicator", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.financialIndicator = :financialIndicator"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByPrimaryBitmap", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.primaryBitmap = :primaryBitmap"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findBySecondaryBitmap", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.secondaryBitmap = :secondaryBitmap"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByMessageTypeIndicator", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.messageTypeIndicator = :messageTypeIndicator"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP2PanLength", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p2PanLength = :p2PanLength"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP2Pan", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p2Pan = :p2Pan"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP3ProcessCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p3ProcessCode = :p3ProcessCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP4TransactionAmount", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p4TransactionAmount = :p4TransactionAmount"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP5ReconclliationAmount", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p5ReconclliationAmount = :p5ReconclliationAmount"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP6CardholderBilling", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p6CardholderBilling = :p6CardholderBilling"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP7TransctionDateAndTime", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p7TransctionDateAndTime = :p7TransctionDateAndTime"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP8IccrAmount", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p8IccrAmount = :p8IccrAmount"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP9ReconConversionRate", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p9ReconConversionRate = :p9ReconConversionRate"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP10CardholderConvRate", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p10CardholderConvRate = :p10CardholderConvRate"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP11SystemTraceAuditNumber", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p11SystemTraceAuditNumber = :p11SystemTraceAuditNumber"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP12LocalDate", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p12LocalDate = :p12LocalDate"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP13LocalTime", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p13LocalTime = :p13LocalTime"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP14ExpirationDate", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p14ExpirationDate = :p14ExpirationDate"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP15SettlementDate", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p15SettlementDate = :p15SettlementDate"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP16ConversionDate", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p16ConversionDate = :p16ConversionDate"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP17CaptureDate", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p17CaptureDate = :p17CaptureDate"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP18MerchantType", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p18MerchantType = :p18MerchantType"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP19AcqBankInstitutionCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p19AcqBankInstitutionCode = :p19AcqBankInstitutionCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP20CountryCodePriAccNo", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p20CountryCodePriAccNo = :p20CountryCodePriAccNo"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP21FwdingInstCountryCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p21FwdingInstCountryCode = :p21FwdingInstCountryCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP22PointOfSaleData", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p22PointOfSaleData = :p22PointOfSaleData"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP23CardSequenceNumber", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p23CardSequenceNumber = :p23CardSequenceNumber"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP24FunctionCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p24FunctionCode = :p24FunctionCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP25MessageReasonCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p25MessageReasonCode = :p25MessageReasonCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP26CardAcceptorBusCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p26CardAcceptorBusCode = :p26CardAcceptorBusCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP27AuthIdResponseLength", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p27AuthIdResponseLength = :p27AuthIdResponseLength"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP28TransactionFeeAmount", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p28TransactionFeeAmount = :p28TransactionFeeAmount"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP29SettlementFeeAmount", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p29SettlementFeeAmount = :p29SettlementFeeAmount"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP30OriginalAmount", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p30OriginalAmount = :p30OriginalAmount"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP31AcquirerRefLength", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p31AcquirerRefLength = :p31AcquirerRefLength"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP31AcquirerRefData", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p31AcquirerRefData = :p31AcquirerRefData"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP32AcquiringInstLength", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p32AcquiringInstLength = :p32AcquiringInstLength"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP32AcquiringInstCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p32AcquiringInstCode = :p32AcquiringInstCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP33ForwardingInstLength", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p33ForwardingInstLength = :p33ForwardingInstLength"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP33ForwardingInstCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p33ForwardingInstCode = :p33ForwardingInstCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP34ExtendedAccountNumber", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p34ExtendedAccountNumber = :p34ExtendedAccountNumber"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP35Track2Data", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p35Track2Data = :p35Track2Data"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP36Track3Data", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p36Track3Data = :p36Track3Data"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP37RetrievalRefNumber", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p37RetrievalRefNumber = :p37RetrievalRefNumber"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP38ApprovalCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p38ApprovalCode = :p38ApprovalCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP39ResponseCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p39ResponseCode = :p39ResponseCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP40ServiceCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p40ServiceCode = :p40ServiceCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP41CardAcceptorTerminalId", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p41CardAcceptorTerminalId = :p41CardAcceptorTerminalId"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP42CardAcceptorId", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p42CardAcceptorId = :p42CardAcceptorId"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP43CardAcceptorLength", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p43CardAcceptorLength = :p43CardAcceptorLength"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP43CardAcceptorName", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p43CardAcceptorName = :p43CardAcceptorName"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP44AdditionalResponseData", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p44AdditionalResponseData = :p44AdditionalResponseData"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP45Track1Data", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p45Track1Data = :p45Track1Data"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP46AdditionalDataIso", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p46AdditionalDataIso = :p46AdditionalDataIso"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP47AdditionalDataNational", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p47AdditionalDataNational = :p47AdditionalDataNational"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP48AdditionalDataLength", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p48AdditionalDataLength = :p48AdditionalDataLength"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP48AdditionalData", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p48AdditionalData = :p48AdditionalData"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP49CurrencyCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p49CurrencyCode = :p49CurrencyCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP50ReconcilliationCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p50ReconcilliationCode = :p50ReconcilliationCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP51CardholderBillCurCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p51CardholderBillCurCode = :p51CardholderBillCurCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP52PersonalIdNumber", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p52PersonalIdNumber = :p52PersonalIdNumber"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP53SecurityRelControlInfo", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p53SecurityRelControlInfo = :p53SecurityRelControlInfo"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP54AdditionalAmntLength", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p54AdditionalAmntLength = :p54AdditionalAmntLength"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP54AdditionalAmounts", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p54AdditionalAmounts = :p54AdditionalAmounts"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP55IccLength", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p55IccLength = :p55IccLength"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP55IccSystemRelatedData", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p55IccSystemRelatedData = :p55IccSystemRelatedData"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP62AddLen", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p62AddLen = :p62AddLen"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP62AdditionalData", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p62AdditionalData = :p62AdditionalData"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP63TxLifeCycleIdLength", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p63TxLifeCycleIdLength = :p63TxLifeCycleIdLength"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP63TransactionLifeCycleId", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p63TransactionLifeCycleId = :p63TransactionLifeCycleId"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByP64PrimaryMac", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.p64PrimaryMac = :p64PrimaryMac"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS66SettlemntCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s66SettlemntCode = :s66SettlemntCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS67ExtendedPaymentCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s67ExtendedPaymentCode = :s67ExtendedPaymentCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS68RecInstCountryCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s68RecInstCountryCode = :s68RecInstCountryCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS69SettleInstCountryCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s69SettleInstCountryCode = :s69SettleInstCountryCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS70NetworkManCountryCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s70NetworkManCountryCode = :s70NetworkManCountryCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS71MessageNumber", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s71MessageNumber = :s71MessageNumber"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS72DataLen", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s72DataLen = :s72DataLen"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS72DataRecord", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s72DataRecord = :s72DataRecord"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS73ActionDate", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s73ActionDate = :s73ActionDate"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS74NoOfCredits", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s74NoOfCredits = :s74NoOfCredits"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS75ReversalNoOfCredits", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s75ReversalNoOfCredits = :s75ReversalNoOfCredits"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS76NoOfDebits", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s76NoOfDebits = :s76NoOfDebits"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS77ReversalNoOfDebits", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s77ReversalNoOfDebits = :s77ReversalNoOfDebits"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS78NumberTransfers", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s78NumberTransfers = :s78NumberTransfers"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS79ReversalNumberTransfers", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s79ReversalNumberTransfers = :s79ReversalNumberTransfers"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS80NumberEnquiries", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s80NumberEnquiries = :s80NumberEnquiries"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS81NumberAuthorisations", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s81NumberAuthorisations = :s81NumberAuthorisations"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS82ProcessingFeeCredits", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s82ProcessingFeeCredits = :s82ProcessingFeeCredits"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS83TransactionFeeCredits", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s83TransactionFeeCredits = :s83TransactionFeeCredits"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS84ProcessingFeeDebits", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s84ProcessingFeeDebits = :s84ProcessingFeeDebits"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS85TransctionFeeAmounts", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s85TransctionFeeAmounts = :s85TransctionFeeAmounts"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS86AmountCredits", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s86AmountCredits = :s86AmountCredits"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS87ReversalAmountCredits", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s87ReversalAmountCredits = :s87ReversalAmountCredits"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS88AmountDebits", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s88AmountDebits = :s88AmountDebits"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS89ReversalAmountDebits", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s89ReversalAmountDebits = :s89ReversalAmountDebits"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS90OriginatingDataElements", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s90OriginatingDataElements = :s90OriginatingDataElements"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS91FileUpdateCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s91FileUpdateCode = :s91FileUpdateCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS92FilesSecurityCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s92FilesSecurityCode = :s92FilesSecurityCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS93Length", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s93Length = :s93Length"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS93TransactionDestInstId", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s93TransactionDestInstId = :s93TransactionDestInstId"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS94Length", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s94Length = :s94Length"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS94TransactionOrigInstId", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s94TransactionOrigInstId = :s94TransactionOrigInstId"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS95CardIssRefDataLength", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s95CardIssRefDataLength = :s95CardIssRefDataLength"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS95CardIssuerRefData", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s95CardIssuerRefData = :s95CardIssuerRefData"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS96MessageSecurityCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s96MessageSecurityCode = :s96MessageSecurityCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS97NetSettlementAmount", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s97NetSettlementAmount = :s97NetSettlementAmount"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS98Payee", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s98Payee = :s98Payee"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS99SettlementInstIdCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s99SettlementInstIdCode = :s99SettlementInstIdCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS100RiiLen", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s100RiiLen = :s100RiiLen"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS100RcvingInstIdCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s100RcvingInstIdCode = :s100RcvingInstIdCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS101FileName", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s101FileName = :s101FileName"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS102AccountIdentification1", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s102AccountIdentification1 = :s102AccountIdentification1"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS103AccountIdentification2", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s103AccountIdentification2 = :s103AccountIdentification2"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS104TransactionDescription", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s104TransactionDescription = :s104TransactionDescription"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS111Length", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s111Length = :s111Length"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS111AmtCurrencyConversion", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s111AmtCurrencyConversion = :s111AmtCurrencyConversion"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS123AddLen", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s123AddLen = :s123AddLen"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS123AdditionalData", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s123AdditionalData = :s123AdditionalData"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS124AddLen", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s124AddLen = :s124AddLen"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS124AdditionalData", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s124AdditionalData = :s124AdditionalData"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS125AddLen", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s125AddLen = :s125AddLen"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS125AdditionalData", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s125AdditionalData = :s125AdditionalData"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByS127NetworkData", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.s127NetworkData = :s127NetworkData"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByInputFileIdentifier", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.inputFileIdentifier = :inputFileIdentifier"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findBySeqNo", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.seqNo = :seqNo"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByProcessStatus", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.processStatus = :processStatus"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByRecordId", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.recordId = :recordId"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByTransactionCode", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.transactionCode = :transactionCode"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByCardType", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.cardType = :cardType"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByFilenameDescription", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.filenameDescription = :filenameDescription"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByIrd", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.ird = :ird"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByCashbackPurchase", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.cashbackPurchase = :cashbackPurchase"),
    @NamedQuery(name = "CsoPaymentInstructionsMcard.findByCashbackPurchaseAmnt", query = "SELECT c FROM CsoPaymentInstructionsMcard c WHERE c.cashbackPurchaseAmnt = :cashbackPurchaseAmnt")})
@DynamicUpdate
public class CsoPaymentInstructionsMcard implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsoPaymentInstructionsMcardPK csoPaymentInstructionsMcardPK;
    @Size(max = 4)
    @Column(name = "SERVICE_CODE")
    private String serviceCode;
    @Size(max = 10)
    @Column(name = "SUB_SERVICE_NAME")
    private String subServiceName;
    @Column(name = "ACQUIRER_MEMBER")
    private Short acquirerMember;
    @Column(name = "ISSUER_MEMBER")
    private Short issuerMember;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MASTERCARD_AMOUNT")
    private Long mastercardAmount;
    @Size(max = 1)
    @Column(name = "FINANCIAL_INDICATOR")
    private String financialIndicator;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "PRIMARY_BITMAP")
    private String primaryBitmap;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "SECONDARY_BITMAP")
    private String secondaryBitmap;
    @Column(name = "MESSAGE_TYPE_INDICATOR")
    private Short messageTypeIndicator;
    @Column(name = "P2_PAN_LENGTH")
    private Short p2PanLength;
    @Size(max = 19)
    @Column(name = "P2_PAN")
    private String p2Pan;
    @Column(name = "P3_PROCESS_CODE")
    private Integer p3ProcessCode;
    @Column(name = "P4_TRANSACTION_AMOUNT")
    private Long p4TransactionAmount;
    @Column(name = "P5_RECONCLLIATION_AMOUNT")
    private Long p5ReconclliationAmount;
    @Column(name = "P6_CARDHOLDER_BILLING")
    private Long p6CardholderBilling;
    @Column(name = "P7_TRANSCTION_DATE_AND_TIME")
    private Long p7TransctionDateAndTime;
    @Column(name = "P8_ICCR_AMOUNT")
    private Integer p8IccrAmount;
    @Column(name = "P9_RECON_CONVERSION_RATE")
    private Integer p9ReconConversionRate;
    @Column(name = "P10_CARDHOLDER_CONV_RATE")
    private Integer p10CardholderConvRate;
    @Column(name = "P11_SYSTEM_TRACE_AUDIT_NUMBER")
    private Integer p11SystemTraceAuditNumber;
    @Column(name = "P12_LOCAL_DATE")
    private Long p12LocalDate;
    @Column(name = "P13_LOCAL_TIME")
    private Integer p13LocalTime;
    @Column(name = "P14_EXPIRATION_DATE")
    private Integer p14ExpirationDate;
    @Column(name = "P15_SETTLEMENT_DATE")
    private Short p15SettlementDate;
    @Column(name = "P16_CONVERSION_DATE")
    private Short p16ConversionDate;
    @Column(name = "P17_CAPTURE_DATE")
    private Short p17CaptureDate;
    @Column(name = "P18_MERCHANT_TYPE")
    private Short p18MerchantType;
    @Column(name = "P19_ACQ_BANK_INSTITUTION_CODE")
    private Short p19AcqBankInstitutionCode;
    @Column(name = "P20_COUNTRY_CODE_PRI_ACC_NO")
    private Short p20CountryCodePriAccNo;
    @Column(name = "P21_FWDING_INST_COUNTRY_CODE")
    private Short p21FwdingInstCountryCode;
    @Size(max = 12)
    @Column(name = "P22_POINT_OF_SALE_DATA")
    private String p22PointOfSaleData;
    @Column(name = "P23_CARD_SEQUENCE_NUMBER")
    private Short p23CardSequenceNumber;
    @Column(name = "P24_FUNCTION_CODE")
    private Short p24FunctionCode;
    @Column(name = "P25_MESSAGE_REASON_CODE")
    private Short p25MessageReasonCode;
    @Column(name = "P26_CARD_ACCEPTOR_BUS_CODE")
    private Short p26CardAcceptorBusCode;
    @Column(name = "P27_AUTH_ID_RESPONSE_LENGTH")
    private Short p27AuthIdResponseLength;
    @Column(name = "P28_TRANSACTION_FEE_AMOUNT")
    private Integer p28TransactionFeeAmount;
    @Column(name = "P29_SETTLEMENT_FEE_AMOUNT")
    private Integer p29SettlementFeeAmount;
    @Size(max = 24)
    @Column(name = "P30_ORIGINAL_AMOUNT")
    private String p30OriginalAmount;
    @Column(name = "P31_ACQUIRER_REF_LENGTH")
    private Short p31AcquirerRefLength;
    @Size(max = 23)
    @Column(name = "P31_ACQUIRER_REF_DATA")
    private String p31AcquirerRefData;
    @Column(name = "P32_ACQUIRING_INST_LENGTH")
    private Short p32AcquiringInstLength;
    @Column(name = "P32_ACQUIRING_INST_CODE")
    private Long p32AcquiringInstCode;
    @Column(name = "P33_FORWARDING_INST_LENGTH")
    private Short p33ForwardingInstLength;
    @Column(name = "P33_FORWARDING_INST_CODE")
    private Long p33ForwardingInstCode;
    @Size(max = 28)
    @Column(name = "P34_EXTENDED_ACCOUNT_NUMBER")
    private String p34ExtendedAccountNumber;
    @Size(max = 37)
    @Column(name = "P35_TRACK_2_DATA")
    private String p35Track2Data;
    @Size(max = 44)
    @Column(name = "P36_TRACK_3_DATA")
    private String p36Track3Data;
    @Size(max = 12)
    @Column(name = "P37_RETRIEVAL_REF_NUMBER")
    private String p37RetrievalRefNumber;
    @Size(max = 6)
    @Column(name = "P38_APPROVAL_CODE")
    private String p38ApprovalCode;
    @Size(max = 2)
    @Column(name = "P39_RESPONSE_CODE")
    private String p39ResponseCode;
    @Column(name = "P40_SERVICE_CODE")
    private Short p40ServiceCode;
    @Size(max = 8)
    @Column(name = "P41_CARD_ACCEPTOR_TERMINAL_ID")
    private String p41CardAcceptorTerminalId;
    @Size(max = 15)
    @Column(name = "P42_CARD_ACCEPTOR_ID")
    private String p42CardAcceptorId;
    @Column(name = "P43_CARD_ACCEPTOR_LENGTH")
    private Short p43CardAcceptorLength;
    @Size(max = 99)
    @Column(name = "P43_CARD_ACCEPTOR_NAME")
    private String p43CardAcceptorName;
    @Size(max = 27)
    @Column(name = "P44_ADDITIONAL_RESPONSE_DATA")
    private String p44AdditionalResponseData;
    @Size(max = 76)
    @Column(name = "P45_TRACK_1_DATA")
    private String p45Track1Data;
    @Size(max = 20)
    @Column(name = "P46_ADDITIONAL_DATA_ISO")
    private String p46AdditionalDataIso;
    @Size(max = 20)
    @Column(name = "P47_ADDITIONAL_DATA_NATIONAL")
    private String p47AdditionalDataNational;
    @Size(max = 3)
    @Column(name = "P48_ADDITIONAL_DATA_LENGTH")
    private String p48AdditionalDataLength;
    @Size(max = 250)
    @Column(name = "P48_ADDITIONAL_DATA")
    private String p48AdditionalData;
    @Column(name = "P49_CURRENCY_CODE")
    private Short p49CurrencyCode;
    @Column(name = "P50_RECONCILLIATION_CODE")
    private Short p50ReconcilliationCode;
    @Column(name = "P51_CARDHOLDER_BILL_CUR_CODE")
    private Short p51CardholderBillCurCode;
    @Size(max = 16)
    @Column(name = "P52_PERSONAL_ID_NUMBER")
    private String p52PersonalIdNumber;
    @Column(name = "P53_SECURITY_REL_CONTROL_INFO")
    private Long p53SecurityRelControlInfo;
    @Column(name = "P54_ADDITIONAL_AMNT_LENGTH")
    private Short p54AdditionalAmntLength;
    @Size(max = 23)
    @Column(name = "P54_ADDITIONAL_AMOUNTS")
    private String p54AdditionalAmounts;
    @Column(name = "P55_ICC_LENGTH")
    private Short p55IccLength;
    @Size(max = 255)
    @Column(name = "P55_ICC_SYSTEM_RELATED_DATA")
    private String p55IccSystemRelatedData;
    @Column(name = "P62_ADD_LEN")
    private Short p62AddLen;
    @Size(max = 43)
    @Column(name = "P62_ADDITIONAL_DATA")
    private String p62AdditionalData;
    @Column(name = "P63_TX_LIFE_CYCLE_ID_LENGTH")
    private Short p63TxLifeCycleIdLength;
    @Size(max = 19)
    @Column(name = "P63_TRANSACTION_LIFE_CYCLE_ID")
    private String p63TransactionLifeCycleId;
    @Size(max = 16)
    @Column(name = "P64_PRIMARY_MAC")
    private String p64PrimaryMac;
    @Size(max = 1)
    @Column(name = "S66_SETTLEMNT_CODE")
    private String s66SettlemntCode;
    @Column(name = "S67_EXTENDED_PAYMENT_CODE")
    private Short s67ExtendedPaymentCode;
    @Column(name = "S68_REC_INST_COUNTRY_CODE")
    private Short s68RecInstCountryCode;
    @Column(name = "S69_SETTLE_INST_COUNTRY_CODE")
    private Short s69SettleInstCountryCode;
    @Column(name = "S70_NETWORK_MAN_COUNTRY_CODE")
    private Short s70NetworkManCountryCode;
    @Column(name = "S71_MESSAGE_NUMBER")
    private Integer s71MessageNumber;
    @Column(name = "S72_DATA_LEN")
    private Short s72DataLen;
    @Size(max = 100)
    @Column(name = "S72_DATA_RECORD")
    private String s72DataRecord;
    @Column(name = "S73_ACTION_DATE")
    private Integer s73ActionDate;
    @Column(name = "S74_NO_OF_CREDITS")
    private Long s74NoOfCredits;
    @Column(name = "S75_REVERSAL_NO_OF_CREDITS")
    private Long s75ReversalNoOfCredits;
    @Column(name = "S76_NO_OF_DEBITS")
    private Long s76NoOfDebits;
    @Column(name = "S77_REVERSAL_NO_OF_DEBITS")
    private Long s77ReversalNoOfDebits;
    @Column(name = "S78_NUMBER_TRANSFERS")
    private Long s78NumberTransfers;
    @Column(name = "S79_REVERSAL_NUMBER_TRANSFERS")
    private Long s79ReversalNumberTransfers;
    @Column(name = "S80_NUMBER_ENQUIRIES")
    private Long s80NumberEnquiries;
    @Column(name = "S81_NUMBER_AUTHORISATIONS")
    private Long s81NumberAuthorisations;
    @Column(name = "S82_PROCESSING_FEE_CREDITS")
    private Long s82ProcessingFeeCredits;
    @Column(name = "S83_TRANSACTION_FEE_CREDITS")
    private Long s83TransactionFeeCredits;
    @Column(name = "S84_PROCESSING_FEE_DEBITS")
    private Long s84ProcessingFeeDebits;
    @Column(name = "S85_TRANSCTION_FEE_AMOUNTS")
    private Long s85TransctionFeeAmounts;
    @Column(name = "S86_AMOUNT_CREDITS")
    private Long s86AmountCredits;
    @Column(name = "S87_REVERSAL_AMOUNT_CREDITS")
    private Long s87ReversalAmountCredits;
    @Column(name = "S88_AMOUNT_DEBITS")
    private Long s88AmountDebits;
    @Column(name = "S89_REVERSAL_AMOUNT_DEBITS")
    private Long s89ReversalAmountDebits;
    @Column(name = "S90_ORIGINATING_DATA_ELEMENTS")
    private Long s90OriginatingDataElements;
    @Size(max = 1)
    @Column(name = "S91_FILE_UPDATE_CODE")
    private String s91FileUpdateCode;
    @Size(max = 2)
    @Column(name = "S92_FILES_SECURITY_CODE")
    private String s92FilesSecurityCode;
    @Column(name = "S93_LENGTH")
    private Short s93Length;
    @Column(name = "S93_TRANSACTION_DEST_INST_ID")
    private Long s93TransactionDestInstId;
    @Column(name = "S94_LENGTH")
    private Short s94Length;
    @Size(max = 11)
    @Column(name = "S94_TRANSACTION_ORIG_INST_ID")
    private String s94TransactionOrigInstId;
    @Column(name = "S95_CARD_ISS_REF_DATA_LENGTH")
    private Short s95CardIssRefDataLength;
    @Size(max = 10)
    @Column(name = "S95_CARD_ISSUER_REF_DATA")
    private String s95CardIssuerRefData;
    @Size(max = 16)
    @Column(name = "S96_MESSAGE_SECURITY_CODE")
    private String s96MessageSecurityCode;
    @Column(name = "S97_NET_SETTLEMENT_AMOUNT")
    private Long s97NetSettlementAmount;
    @Size(max = 25)
    @Column(name = "S98_PAYEE")
    private String s98Payee;
    @Column(name = "S99_SETTLEMENT_INST_ID_CODE")
    private Long s99SettlementInstIdCode;
    @Column(name = "S100_RII_LEN")
    private Short s100RiiLen;
    @Column(name = "S100_RCVING_INST_ID_CODE")
    private Long s100RcvingInstIdCode;
    @Size(max = 4)
    @Column(name = "S101_FILE_NAME")
    private String s101FileName;
    @Size(max = 28)
    @Column(name = "S102_ACCOUNT_IDENTIFICATION_1")
    private String s102AccountIdentification1;
    @Size(max = 28)
    @Column(name = "S103_ACCOUNT_IDENTIFICATION_2")
    private String s103AccountIdentification2;
    @Size(max = 30)
    @Column(name = "S104_TRANSACTION_DESCRIPTION")
    private String s104TransactionDescription;
    @Column(name = "S111_LENGTH")
    private Short s111Length;
    @Size(max = 12)
    @Column(name = "S111_AMT_CURRENCY_CONVERSION")
    private String s111AmtCurrencyConversion;
    @Column(name = "S123_ADD_LEN")
    private Short s123AddLen;
    @Size(max = 43)
    @Column(name = "S123_ADDITIONAL_DATA")
    private String s123AdditionalData;
    @Column(name = "S124_ADD_LEN")
    private Short s124AddLen;
    @Size(max = 43)
    @Column(name = "S124_ADDITIONAL_DATA")
    private String s124AdditionalData;
    @Column(name = "S125_ADD_LEN")
    private Short s125AddLen;
    @Size(max = 43)
    @Column(name = "S125_ADDITIONAL_DATA")
    private String s125AdditionalData;
    @Size(max = 43)
    @Column(name = "S127_NETWORK_DATA")
    private String s127NetworkData;
    @Size(max = 8)
    @Column(name = "INPUT_FILE_IDENTIFIER")
    private String inputFileIdentifier;
    @Column(name = "SEQ_NO")
    private Long seqNo;
    @Size(max = 1)
    @Column(name = "PROCESS_STATUS")
    private String processStatus;
    @Column(name = "RECORD_ID")
    private Short recordId;
    @Column(name = "TRANSACTION_CODE")
    private Short transactionCode;
    @Size(max = 2)
    @Column(name = "CARD_TYPE")
    private String cardType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "FILENAME_DESCRIPTION")
    private String filenameDescription;
    @Lob
    @Column(name = "P55_ICC_SYS_DATA_RAW")
    private byte[] p55IccSysDataRaw;
    @Column(name = "IRD")
    private Short ird;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CASHBACK_PURCHASE")
    private String cashbackPurchase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CASHBACK_PURCHASE_AMNT")
    private BigDecimal cashbackPurchaseAmnt;
    @Column(name = "POS_ENTRY_MODE")
    private String posEntryMode;
    @Column(name = "CHIP_CARD")
    private String chipCard;
    @Column(name = "TERMINAL_CAPABILITY")
    private String terminalCapability;
    @Column(name = "ECOMM_IND")
    private String ecommInd;
    @Column(name = "CARD_PRESENT")
    private String cardPresent;
    @Column(name = "RATE_DESC")
    private String rateDesc;
    @Column(name = "INTERCHANGE_FEE")
    private Double interchangeFee;
    @Column(name = "INTERCHANGE_PERC")
    private Double interchangePerc;
    @Column(name = "INTERCHANGE_VAT")
    private Double interchangeVat;
    @Column(name = "CASHBACK_IC_FEE")
    private Double cashbackIcFee;
    @Column(name = "CASHBACK_IC_PERC")
    private Double cashbackIcPerc;
    @Column(name = "CASHBACK_IC_VAT")
    private Double cashbackIcVat;   

    public CsoPaymentInstructionsMcard() {
    }

    public CsoPaymentInstructionsMcard(CsoPaymentInstructionsMcardPK csoPaymentInstructionsMcardPK) {
        this.csoPaymentInstructionsMcardPK = csoPaymentInstructionsMcardPK;
    }

    public CsoPaymentInstructionsMcard(CsoPaymentInstructionsMcardPK csoPaymentInstructionsMcardPK, String primaryBitmap, String secondaryBitmap, String filenameDescription, String cashbackPurchase, BigDecimal cashbackPurchaseAmnt) {
        this.csoPaymentInstructionsMcardPK = csoPaymentInstructionsMcardPK;
        this.primaryBitmap = primaryBitmap;
        this.secondaryBitmap = secondaryBitmap;
        this.filenameDescription = filenameDescription;
        this.cashbackPurchase = cashbackPurchase;
        this.cashbackPurchaseAmnt = cashbackPurchaseAmnt;
    }

    public CsoPaymentInstructionsMcard(String fileRefNumber1, long systemSeqNumber2) {
        this.csoPaymentInstructionsMcardPK = new CsoPaymentInstructionsMcardPK(fileRefNumber1, systemSeqNumber2);
    }

    public CsoPaymentInstructionsMcardPK getCsoPaymentInstructionsMcardPK() {
        return csoPaymentInstructionsMcardPK;
    }

    public void setCsoPaymentInstructionsMcardPK(CsoPaymentInstructionsMcardPK csoPaymentInstructionsMcardPK) {
        this.csoPaymentInstructionsMcardPK = csoPaymentInstructionsMcardPK;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getSubServiceName() {
        return subServiceName;
    }

    public void setSubServiceName(String subServiceName) {
        this.subServiceName = subServiceName;
    }

    public Short getAcquirerMember() {
        return acquirerMember;
    }

    public void setAcquirerMember(Short acquirerMember) {
        this.acquirerMember = acquirerMember;
    }

    public Short getIssuerMember() {
        return issuerMember;
    }

    public void setIssuerMember(Short issuerMember) {
        this.issuerMember = issuerMember;
    }

    public Long getMastercardAmount() {
        return mastercardAmount;
    }

    public void setMastercardAmount(Long mastercardAmount) {
        this.mastercardAmount = mastercardAmount;
    }

    public String getFinancialIndicator() {
        return financialIndicator;
    }

    public void setFinancialIndicator(String financialIndicator) {
        this.financialIndicator = financialIndicator;
    }

    public String getPrimaryBitmap() {
        return primaryBitmap;
    }

    public void setPrimaryBitmap(String primaryBitmap) {
        this.primaryBitmap = primaryBitmap;
    }

    public String getSecondaryBitmap() {
        return secondaryBitmap;
    }

    public void setSecondaryBitmap(String secondaryBitmap) {
        this.secondaryBitmap = secondaryBitmap;
    }

    public Short getMessageTypeIndicator() {
        return messageTypeIndicator;
    }

    public void setMessageTypeIndicator(Short messageTypeIndicator) {
        this.messageTypeIndicator = messageTypeIndicator;
    }

    public Short getP2PanLength() {
        return p2PanLength;
    }

    public void setP2PanLength(Short p2PanLength) {
        this.p2PanLength = p2PanLength;
    }

    public String getP2Pan() {
        return p2Pan;
    }

    public void setP2Pan(String p2Pan) {
        this.p2Pan = p2Pan;
    }

    public Integer getP3ProcessCode() {
        return p3ProcessCode;
    }

    public void setP3ProcessCode(Integer p3ProcessCode) {
        this.p3ProcessCode = p3ProcessCode;
    }

    public Long getP4TransactionAmount() {
        return p4TransactionAmount;
    }

    public void setP4TransactionAmount(Long p4TransactionAmount) {
        this.p4TransactionAmount = p4TransactionAmount;
    }

    public Long getP5ReconclliationAmount() {
        return p5ReconclliationAmount;
    }

    public void setP5ReconclliationAmount(Long p5ReconclliationAmount) {
        this.p5ReconclliationAmount = p5ReconclliationAmount;
    }

    public Long getP6CardholderBilling() {
        return p6CardholderBilling;
    }

    public void setP6CardholderBilling(Long p6CardholderBilling) {
        this.p6CardholderBilling = p6CardholderBilling;
    }

    public Long getP7TransctionDateAndTime() {
        return p7TransctionDateAndTime;
    }

    public void setP7TransctionDateAndTime(Long p7TransctionDateAndTime) {
        this.p7TransctionDateAndTime = p7TransctionDateAndTime;
    }

    public Integer getP8IccrAmount() {
        return p8IccrAmount;
    }

    public void setP8IccrAmount(Integer p8IccrAmount) {
        this.p8IccrAmount = p8IccrAmount;
    }

    public Integer getP9ReconConversionRate() {
        return p9ReconConversionRate;
    }

    public void setP9ReconConversionRate(Integer p9ReconConversionRate) {
        this.p9ReconConversionRate = p9ReconConversionRate;
    }

    public Integer getP10CardholderConvRate() {
        return p10CardholderConvRate;
    }

    public void setP10CardholderConvRate(Integer p10CardholderConvRate) {
        this.p10CardholderConvRate = p10CardholderConvRate;
    }

    public Integer getP11SystemTraceAuditNumber() {
        return p11SystemTraceAuditNumber;
    }

    public void setP11SystemTraceAuditNumber(Integer p11SystemTraceAuditNumber) {
        this.p11SystemTraceAuditNumber = p11SystemTraceAuditNumber;
    }

    public Long getP12LocalDate() {
        return p12LocalDate;
    }

    public void setP12LocalDate(Long p12LocalDate) {
        this.p12LocalDate = p12LocalDate;
    }

    public Integer getP13LocalTime() {
        return p13LocalTime;
    }

    public void setP13LocalTime(Integer p13LocalTime) {
        this.p13LocalTime = p13LocalTime;
    }

    public Integer getP14ExpirationDate() {
        return p14ExpirationDate;
    }

    public void setP14ExpirationDate(Integer p14ExpirationDate) {
        this.p14ExpirationDate = p14ExpirationDate;
    }

    public Short getP15SettlementDate() {
        return p15SettlementDate;
    }

    public void setP15SettlementDate(Short p15SettlementDate) {
        this.p15SettlementDate = p15SettlementDate;
    }

    public Short getP16ConversionDate() {
        return p16ConversionDate;
    }

    public void setP16ConversionDate(Short p16ConversionDate) {
        this.p16ConversionDate = p16ConversionDate;
    }

    public Short getP17CaptureDate() {
        return p17CaptureDate;
    }

    public void setP17CaptureDate(Short p17CaptureDate) {
        this.p17CaptureDate = p17CaptureDate;
    }

    public Short getP18MerchantType() {
        return p18MerchantType;
    }

    public void setP18MerchantType(Short p18MerchantType) {
        this.p18MerchantType = p18MerchantType;
    }

    public Short getP19AcqBankInstitutionCode() {
        return p19AcqBankInstitutionCode;
    }

    public void setP19AcqBankInstitutionCode(Short p19AcqBankInstitutionCode) {
        this.p19AcqBankInstitutionCode = p19AcqBankInstitutionCode;
    }

    public Short getP20CountryCodePriAccNo() {
        return p20CountryCodePriAccNo;
    }

    public void setP20CountryCodePriAccNo(Short p20CountryCodePriAccNo) {
        this.p20CountryCodePriAccNo = p20CountryCodePriAccNo;
    }

    public Short getP21FwdingInstCountryCode() {
        return p21FwdingInstCountryCode;
    }

    public void setP21FwdingInstCountryCode(Short p21FwdingInstCountryCode) {
        this.p21FwdingInstCountryCode = p21FwdingInstCountryCode;
    }

    public String getP22PointOfSaleData() {
        return p22PointOfSaleData;
    }

    public void setP22PointOfSaleData(String p22PointOfSaleData) {
        this.p22PointOfSaleData = p22PointOfSaleData;
    }

    public Short getP23CardSequenceNumber() {
        return p23CardSequenceNumber;
    }

    public void setP23CardSequenceNumber(Short p23CardSequenceNumber) {
        this.p23CardSequenceNumber = p23CardSequenceNumber;
    }

    public Short getP24FunctionCode() {
        return p24FunctionCode;
    }

    public void setP24FunctionCode(Short p24FunctionCode) {
        this.p24FunctionCode = p24FunctionCode;
    }

    public Short getP25MessageReasonCode() {
        return p25MessageReasonCode;
    }

    public void setP25MessageReasonCode(Short p25MessageReasonCode) {
        this.p25MessageReasonCode = p25MessageReasonCode;
    }

    public Short getP26CardAcceptorBusCode() {
        return p26CardAcceptorBusCode;
    }

    public void setP26CardAcceptorBusCode(Short p26CardAcceptorBusCode) {
        this.p26CardAcceptorBusCode = p26CardAcceptorBusCode;
    }

    public Short getP27AuthIdResponseLength() {
        return p27AuthIdResponseLength;
    }

    public void setP27AuthIdResponseLength(Short p27AuthIdResponseLength) {
        this.p27AuthIdResponseLength = p27AuthIdResponseLength;
    }

    public Integer getP28TransactionFeeAmount() {
        return p28TransactionFeeAmount;
    }

    public void setP28TransactionFeeAmount(Integer p28TransactionFeeAmount) {
        this.p28TransactionFeeAmount = p28TransactionFeeAmount;
    }

    public Integer getP29SettlementFeeAmount() {
        return p29SettlementFeeAmount;
    }

    public void setP29SettlementFeeAmount(Integer p29SettlementFeeAmount) {
        this.p29SettlementFeeAmount = p29SettlementFeeAmount;
    }

    public String getP30OriginalAmount() {
        return p30OriginalAmount;
    }

    public void setP30OriginalAmount(String p30OriginalAmount) {
        this.p30OriginalAmount = p30OriginalAmount;
    }

    public Short getP31AcquirerRefLength() {
        return p31AcquirerRefLength;
    }

    public void setP31AcquirerRefLength(Short p31AcquirerRefLength) {
        this.p31AcquirerRefLength = p31AcquirerRefLength;
    }

    public String getP31AcquirerRefData() {
        return p31AcquirerRefData;
    }

    public void setP31AcquirerRefData(String p31AcquirerRefData) {
        this.p31AcquirerRefData = p31AcquirerRefData;
    }

    public Short getP32AcquiringInstLength() {
        return p32AcquiringInstLength;
    }

    public void setP32AcquiringInstLength(Short p32AcquiringInstLength) {
        this.p32AcquiringInstLength = p32AcquiringInstLength;
    }

    public Long getP32AcquiringInstCode() {
        return p32AcquiringInstCode;
    }

    public void setP32AcquiringInstCode(Long p32AcquiringInstCode) {
        this.p32AcquiringInstCode = p32AcquiringInstCode;
    }

    public Short getP33ForwardingInstLength() {
        return p33ForwardingInstLength;
    }

    public void setP33ForwardingInstLength(Short p33ForwardingInstLength) {
        this.p33ForwardingInstLength = p33ForwardingInstLength;
    }

    public Long getP33ForwardingInstCode() {
        return p33ForwardingInstCode;
    }

    public void setP33ForwardingInstCode(Long p33ForwardingInstCode) {
        this.p33ForwardingInstCode = p33ForwardingInstCode;
    }

    public String getP34ExtendedAccountNumber() {
        return p34ExtendedAccountNumber;
    }

    public void setP34ExtendedAccountNumber(String p34ExtendedAccountNumber) {
        this.p34ExtendedAccountNumber = p34ExtendedAccountNumber;
    }

    public String getP35Track2Data() {
        return p35Track2Data;
    }

    public void setP35Track2Data(String p35Track2Data) {
        this.p35Track2Data = p35Track2Data;
    }

    public String getP36Track3Data() {
        return p36Track3Data;
    }

    public void setP36Track3Data(String p36Track3Data) {
        this.p36Track3Data = p36Track3Data;
    }

    public String getP37RetrievalRefNumber() {
        return p37RetrievalRefNumber;
    }

    public void setP37RetrievalRefNumber(String p37RetrievalRefNumber) {
        this.p37RetrievalRefNumber = p37RetrievalRefNumber;
    }

    public String getP38ApprovalCode() {
        return p38ApprovalCode;
    }

    public void setP38ApprovalCode(String p38ApprovalCode) {
        this.p38ApprovalCode = p38ApprovalCode;
    }

    public String getP39ResponseCode() {
        return p39ResponseCode;
    }

    public void setP39ResponseCode(String p39ResponseCode) {
        this.p39ResponseCode = p39ResponseCode;
    }

    public Short getP40ServiceCode() {
        return p40ServiceCode;
    }

    public void setP40ServiceCode(Short p40ServiceCode) {
        this.p40ServiceCode = p40ServiceCode;
    }

    public String getP41CardAcceptorTerminalId() {
        return p41CardAcceptorTerminalId;
    }

    public void setP41CardAcceptorTerminalId(String p41CardAcceptorTerminalId) {
        this.p41CardAcceptorTerminalId = p41CardAcceptorTerminalId;
    }

    public String getP42CardAcceptorId() {
        return p42CardAcceptorId;
    }

    public void setP42CardAcceptorId(String p42CardAcceptorId) {
        this.p42CardAcceptorId = p42CardAcceptorId;
    }

    public Short getP43CardAcceptorLength() {
        return p43CardAcceptorLength;
    }

    public void setP43CardAcceptorLength(Short p43CardAcceptorLength) {
        this.p43CardAcceptorLength = p43CardAcceptorLength;
    }

    public String getP43CardAcceptorName() {
        return p43CardAcceptorName;
    }

    public void setP43CardAcceptorName(String p43CardAcceptorName) {
        this.p43CardAcceptorName = p43CardAcceptorName;
    }

    public String getP44AdditionalResponseData() {
        return p44AdditionalResponseData;
    }

    public void setP44AdditionalResponseData(String p44AdditionalResponseData) {
        this.p44AdditionalResponseData = p44AdditionalResponseData;
    }

    public String getP45Track1Data() {
        return p45Track1Data;
    }

    public void setP45Track1Data(String p45Track1Data) {
        this.p45Track1Data = p45Track1Data;
    }

    public String getP46AdditionalDataIso() {
        return p46AdditionalDataIso;
    }

    public void setP46AdditionalDataIso(String p46AdditionalDataIso) {
        this.p46AdditionalDataIso = p46AdditionalDataIso;
    }

    public String getP47AdditionalDataNational() {
        return p47AdditionalDataNational;
    }

    public void setP47AdditionalDataNational(String p47AdditionalDataNational) {
        this.p47AdditionalDataNational = p47AdditionalDataNational;
    }

    public String getP48AdditionalDataLength() {
        return p48AdditionalDataLength;
    }

    public void setP48AdditionalDataLength(String p48AdditionalDataLength) {
        this.p48AdditionalDataLength = p48AdditionalDataLength;
    }

    public String getP48AdditionalData() {
        return p48AdditionalData;
    }

    public void setP48AdditionalData(String p48AdditionalData) {
        this.p48AdditionalData = p48AdditionalData;
    }

    public Short getP49CurrencyCode() {
        return p49CurrencyCode;
    }

    public void setP49CurrencyCode(Short p49CurrencyCode) {
        this.p49CurrencyCode = p49CurrencyCode;
    }

    public Short getP50ReconcilliationCode() {
        return p50ReconcilliationCode;
    }

    public void setP50ReconcilliationCode(Short p50ReconcilliationCode) {
        this.p50ReconcilliationCode = p50ReconcilliationCode;
    }

    public Short getP51CardholderBillCurCode() {
        return p51CardholderBillCurCode;
    }

    public void setP51CardholderBillCurCode(Short p51CardholderBillCurCode) {
        this.p51CardholderBillCurCode = p51CardholderBillCurCode;
    }

    public String getP52PersonalIdNumber() {
        return p52PersonalIdNumber;
    }

    public void setP52PersonalIdNumber(String p52PersonalIdNumber) {
        this.p52PersonalIdNumber = p52PersonalIdNumber;
    }

    public Long getP53SecurityRelControlInfo() {
        return p53SecurityRelControlInfo;
    }

    public void setP53SecurityRelControlInfo(Long p53SecurityRelControlInfo) {
        this.p53SecurityRelControlInfo = p53SecurityRelControlInfo;
    }

    public Short getP54AdditionalAmntLength() {
        return p54AdditionalAmntLength;
    }

    public void setP54AdditionalAmntLength(Short p54AdditionalAmntLength) {
        this.p54AdditionalAmntLength = p54AdditionalAmntLength;
    }

    public String getP54AdditionalAmounts() {
        return p54AdditionalAmounts;
    }

    public void setP54AdditionalAmounts(String p54AdditionalAmounts) {
        this.p54AdditionalAmounts = p54AdditionalAmounts;
    }

    public Short getP55IccLength() {
        return p55IccLength;
    }

    public void setP55IccLength(Short p55IccLength) {
        this.p55IccLength = p55IccLength;
    }

    public String getP55IccSystemRelatedData() {
        return p55IccSystemRelatedData;
    }

    public void setP55IccSystemRelatedData(String p55IccSystemRelatedData) {
        this.p55IccSystemRelatedData = p55IccSystemRelatedData;
    }

    public Short getP62AddLen() {
        return p62AddLen;
    }

    public void setP62AddLen(Short p62AddLen) {
        this.p62AddLen = p62AddLen;
    }

    public String getP62AdditionalData() {
        return p62AdditionalData;
    }

    public void setP62AdditionalData(String p62AdditionalData) {
        this.p62AdditionalData = p62AdditionalData;
    }

    public Short getP63TxLifeCycleIdLength() {
        return p63TxLifeCycleIdLength;
    }

    public void setP63TxLifeCycleIdLength(Short p63TxLifeCycleIdLength) {
        this.p63TxLifeCycleIdLength = p63TxLifeCycleIdLength;
    }

    public String getP63TransactionLifeCycleId() {
        return p63TransactionLifeCycleId;
    }

    public void setP63TransactionLifeCycleId(String p63TransactionLifeCycleId) {
        this.p63TransactionLifeCycleId = p63TransactionLifeCycleId;
    }

    public String getP64PrimaryMac() {
        return p64PrimaryMac;
    }

    public void setP64PrimaryMac(String p64PrimaryMac) {
        this.p64PrimaryMac = p64PrimaryMac;
    }

    public String getS66SettlemntCode() {
        return s66SettlemntCode;
    }

    public void setS66SettlemntCode(String s66SettlemntCode) {
        this.s66SettlemntCode = s66SettlemntCode;
    }

    public Short getS67ExtendedPaymentCode() {
        return s67ExtendedPaymentCode;
    }

    public void setS67ExtendedPaymentCode(Short s67ExtendedPaymentCode) {
        this.s67ExtendedPaymentCode = s67ExtendedPaymentCode;
    }

    public Short getS68RecInstCountryCode() {
        return s68RecInstCountryCode;
    }

    public void setS68RecInstCountryCode(Short s68RecInstCountryCode) {
        this.s68RecInstCountryCode = s68RecInstCountryCode;
    }

    public Short getS69SettleInstCountryCode() {
        return s69SettleInstCountryCode;
    }

    public void setS69SettleInstCountryCode(Short s69SettleInstCountryCode) {
        this.s69SettleInstCountryCode = s69SettleInstCountryCode;
    }

    public Short getS70NetworkManCountryCode() {
        return s70NetworkManCountryCode;
    }

    public void setS70NetworkManCountryCode(Short s70NetworkManCountryCode) {
        this.s70NetworkManCountryCode = s70NetworkManCountryCode;
    }

    public Integer getS71MessageNumber() {
        return s71MessageNumber;
    }

    public void setS71MessageNumber(Integer s71MessageNumber) {
        this.s71MessageNumber = s71MessageNumber;
    }

    public Short getS72DataLen() {
        return s72DataLen;
    }

    public void setS72DataLen(Short s72DataLen) {
        this.s72DataLen = s72DataLen;
    }

    public String getS72DataRecord() {
        return s72DataRecord;
    }

    public void setS72DataRecord(String s72DataRecord) {
        this.s72DataRecord = s72DataRecord;
    }

    public Integer getS73ActionDate() {
        return s73ActionDate;
    }

    public void setS73ActionDate(Integer s73ActionDate) {
        this.s73ActionDate = s73ActionDate;
    }

    public Long getS74NoOfCredits() {
        return s74NoOfCredits;
    }

    public void setS74NoOfCredits(Long s74NoOfCredits) {
        this.s74NoOfCredits = s74NoOfCredits;
    }

    public Long getS75ReversalNoOfCredits() {
        return s75ReversalNoOfCredits;
    }

    public void setS75ReversalNoOfCredits(Long s75ReversalNoOfCredits) {
        this.s75ReversalNoOfCredits = s75ReversalNoOfCredits;
    }

    public Long getS76NoOfDebits() {
        return s76NoOfDebits;
    }

    public void setS76NoOfDebits(Long s76NoOfDebits) {
        this.s76NoOfDebits = s76NoOfDebits;
    }

    public Long getS77ReversalNoOfDebits() {
        return s77ReversalNoOfDebits;
    }

    public void setS77ReversalNoOfDebits(Long s77ReversalNoOfDebits) {
        this.s77ReversalNoOfDebits = s77ReversalNoOfDebits;
    }

    public Long getS78NumberTransfers() {
        return s78NumberTransfers;
    }

    public void setS78NumberTransfers(Long s78NumberTransfers) {
        this.s78NumberTransfers = s78NumberTransfers;
    }

    public Long getS79ReversalNumberTransfers() {
        return s79ReversalNumberTransfers;
    }

    public void setS79ReversalNumberTransfers(Long s79ReversalNumberTransfers) {
        this.s79ReversalNumberTransfers = s79ReversalNumberTransfers;
    }

    public Long getS80NumberEnquiries() {
        return s80NumberEnquiries;
    }

    public void setS80NumberEnquiries(Long s80NumberEnquiries) {
        this.s80NumberEnquiries = s80NumberEnquiries;
    }

    public Long getS81NumberAuthorisations() {
        return s81NumberAuthorisations;
    }

    public void setS81NumberAuthorisations(Long s81NumberAuthorisations) {
        this.s81NumberAuthorisations = s81NumberAuthorisations;
    }

    public Long getS82ProcessingFeeCredits() {
        return s82ProcessingFeeCredits;
    }

    public void setS82ProcessingFeeCredits(Long s82ProcessingFeeCredits) {
        this.s82ProcessingFeeCredits = s82ProcessingFeeCredits;
    }

    public Long getS83TransactionFeeCredits() {
        return s83TransactionFeeCredits;
    }

    public void setS83TransactionFeeCredits(Long s83TransactionFeeCredits) {
        this.s83TransactionFeeCredits = s83TransactionFeeCredits;
    }

    public Long getS84ProcessingFeeDebits() {
        return s84ProcessingFeeDebits;
    }

    public void setS84ProcessingFeeDebits(Long s84ProcessingFeeDebits) {
        this.s84ProcessingFeeDebits = s84ProcessingFeeDebits;
    }

    public Long getS85TransctionFeeAmounts() {
        return s85TransctionFeeAmounts;
    }

    public void setS85TransctionFeeAmounts(Long s85TransctionFeeAmounts) {
        this.s85TransctionFeeAmounts = s85TransctionFeeAmounts;
    }

    public Long getS86AmountCredits() {
        return s86AmountCredits;
    }

    public void setS86AmountCredits(Long s86AmountCredits) {
        this.s86AmountCredits = s86AmountCredits;
    }

    public Long getS87ReversalAmountCredits() {
        return s87ReversalAmountCredits;
    }

    public void setS87ReversalAmountCredits(Long s87ReversalAmountCredits) {
        this.s87ReversalAmountCredits = s87ReversalAmountCredits;
    }

    public Long getS88AmountDebits() {
        return s88AmountDebits;
    }

    public void setS88AmountDebits(Long s88AmountDebits) {
        this.s88AmountDebits = s88AmountDebits;
    }

    public Long getS89ReversalAmountDebits() {
        return s89ReversalAmountDebits;
    }

    public void setS89ReversalAmountDebits(Long s89ReversalAmountDebits) {
        this.s89ReversalAmountDebits = s89ReversalAmountDebits;
    }

    public Long getS90OriginatingDataElements() {
        return s90OriginatingDataElements;
    }

    public void setS90OriginatingDataElements(Long s90OriginatingDataElements) {
        this.s90OriginatingDataElements = s90OriginatingDataElements;
    }

    public String getS91FileUpdateCode() {
        return s91FileUpdateCode;
    }

    public void setS91FileUpdateCode(String s91FileUpdateCode) {
        this.s91FileUpdateCode = s91FileUpdateCode;
    }

    public String getS92FilesSecurityCode() {
        return s92FilesSecurityCode;
    }

    public void setS92FilesSecurityCode(String s92FilesSecurityCode) {
        this.s92FilesSecurityCode = s92FilesSecurityCode;
    }

    public Short getS93Length() {
        return s93Length;
    }

    public void setS93Length(Short s93Length) {
        this.s93Length = s93Length;
    }

    public Long getS93TransactionDestInstId() {
        return s93TransactionDestInstId;
    }

    public void setS93TransactionDestInstId(Long s93TransactionDestInstId) {
        this.s93TransactionDestInstId = s93TransactionDestInstId;
    }

    public Short getS94Length() {
        return s94Length;
    }

    public void setS94Length(Short s94Length) {
        this.s94Length = s94Length;
    }

    public String getS94TransactionOrigInstId() {
        return s94TransactionOrigInstId;
    }

    public void setS94TransactionOrigInstId(String s94TransactionOrigInstId) {
        this.s94TransactionOrigInstId = s94TransactionOrigInstId;
    }

    public Short getS95CardIssRefDataLength() {
        return s95CardIssRefDataLength;
    }

    public void setS95CardIssRefDataLength(Short s95CardIssRefDataLength) {
        this.s95CardIssRefDataLength = s95CardIssRefDataLength;
    }

    public String getS95CardIssuerRefData() {
        return s95CardIssuerRefData;
    }

    public void setS95CardIssuerRefData(String s95CardIssuerRefData) {
        this.s95CardIssuerRefData = s95CardIssuerRefData;
    }

    public String getS96MessageSecurityCode() {
        return s96MessageSecurityCode;
    }

    public void setS96MessageSecurityCode(String s96MessageSecurityCode) {
        this.s96MessageSecurityCode = s96MessageSecurityCode;
    }

    public Long getS97NetSettlementAmount() {
        return s97NetSettlementAmount;
    }

    public void setS97NetSettlementAmount(Long s97NetSettlementAmount) {
        this.s97NetSettlementAmount = s97NetSettlementAmount;
    }

    public String getS98Payee() {
        return s98Payee;
    }

    public void setS98Payee(String s98Payee) {
        this.s98Payee = s98Payee;
    }

    public Long getS99SettlementInstIdCode() {
        return s99SettlementInstIdCode;
    }

    public void setS99SettlementInstIdCode(Long s99SettlementInstIdCode) {
        this.s99SettlementInstIdCode = s99SettlementInstIdCode;
    }

    public Short getS100RiiLen() {
        return s100RiiLen;
    }

    public void setS100RiiLen(Short s100RiiLen) {
        this.s100RiiLen = s100RiiLen;
    }

    public Long getS100RcvingInstIdCode() {
        return s100RcvingInstIdCode;
    }

    public void setS100RcvingInstIdCode(Long s100RcvingInstIdCode) {
        this.s100RcvingInstIdCode = s100RcvingInstIdCode;
    }

    public String getS101FileName() {
        return s101FileName;
    }

    public void setS101FileName(String s101FileName) {
        this.s101FileName = s101FileName;
    }

    public String getS102AccountIdentification1() {
        return s102AccountIdentification1;
    }

    public void setS102AccountIdentification1(String s102AccountIdentification1) {
        this.s102AccountIdentification1 = s102AccountIdentification1;
    }

    public String getS103AccountIdentification2() {
        return s103AccountIdentification2;
    }

    public void setS103AccountIdentification2(String s103AccountIdentification2) {
        this.s103AccountIdentification2 = s103AccountIdentification2;
    }

    public String getS104TransactionDescription() {
        return s104TransactionDescription;
    }

    public void setS104TransactionDescription(String s104TransactionDescription) {
        this.s104TransactionDescription = s104TransactionDescription;
    }

    public Short getS111Length() {
        return s111Length;
    }

    public void setS111Length(Short s111Length) {
        this.s111Length = s111Length;
    }

    public String getS111AmtCurrencyConversion() {
        return s111AmtCurrencyConversion;
    }

    public void setS111AmtCurrencyConversion(String s111AmtCurrencyConversion) {
        this.s111AmtCurrencyConversion = s111AmtCurrencyConversion;
    }

    public Short getS123AddLen() {
        return s123AddLen;
    }

    public void setS123AddLen(Short s123AddLen) {
        this.s123AddLen = s123AddLen;
    }

    public String getS123AdditionalData() {
        return s123AdditionalData;
    }

    public void setS123AdditionalData(String s123AdditionalData) {
        this.s123AdditionalData = s123AdditionalData;
    }

    public Short getS124AddLen() {
        return s124AddLen;
    }

    public void setS124AddLen(Short s124AddLen) {
        this.s124AddLen = s124AddLen;
    }

    public String getS124AdditionalData() {
        return s124AdditionalData;
    }

    public void setS124AdditionalData(String s124AdditionalData) {
        this.s124AdditionalData = s124AdditionalData;
    }

    public Short getS125AddLen() {
        return s125AddLen;
    }

    public void setS125AddLen(Short s125AddLen) {
        this.s125AddLen = s125AddLen;
    }

    public String getS125AdditionalData() {
        return s125AdditionalData;
    }

    public void setS125AdditionalData(String s125AdditionalData) {
        this.s125AdditionalData = s125AdditionalData;
    }

    public String getS127NetworkData() {
        return s127NetworkData;
    }

    public void setS127NetworkData(String s127NetworkData) {
        this.s127NetworkData = s127NetworkData;
    }

    public String getInputFileIdentifier() {
        return inputFileIdentifier;
    }

    public void setInputFileIdentifier(String inputFileIdentifier) {
        this.inputFileIdentifier = inputFileIdentifier;
    }

    public Long getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Long seqNo) {
        this.seqNo = seqNo;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public Short getRecordId() {
        return recordId;
    }

    public void setRecordId(Short recordId) {
        this.recordId = recordId;
    }

    public Short getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(Short transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getFilenameDescription() {
        return filenameDescription;
    }

    public void setFilenameDescription(String filenameDescription) {
        this.filenameDescription = filenameDescription;
    }

    public byte[] getP55IccSysDataRaw() {
        return p55IccSysDataRaw;
    }

    public void setP55IccSysDataRaw(byte[] p55IccSysDataRaw) {
        this.p55IccSysDataRaw = p55IccSysDataRaw;
    }

    public Short getIrd() {
        return ird;
    }

    public void setIrd(Short ird) {
        this.ird = ird;
    }

    public String getCashbackPurchase() {
        return cashbackPurchase;
    }

    public void setCashbackPurchase(String cashbackPurchase) {
        this.cashbackPurchase = cashbackPurchase;
    }

    public BigDecimal getCashbackPurchaseAmnt() {
        return cashbackPurchaseAmnt;
    }

    public void setCashbackPurchaseAmnt(BigDecimal cashbackPurchaseAmnt) {
        this.cashbackPurchaseAmnt = cashbackPurchaseAmnt;
    }

    public String getPosEntryMode() {
        return posEntryMode;
    }

    public void setPosEntryMode(String posEntryMode) {
        this.posEntryMode = posEntryMode;
    }

    public String getChipCard() {
        return chipCard;
    }

    public void setChipCard(String chipCard) {
        this.chipCard = chipCard;
    }

    public String getTerminalCapability() {
        return terminalCapability;
    }

    public void setTerminalCapability(String terminalCapability) {
        this.terminalCapability = terminalCapability;
    }

    public String getEcommInd() {
        return ecommInd;
    }

    public void setEcommInd(String ecommInd) {
        this.ecommInd = ecommInd;
    }

    public String getCardPresent() {
        return cardPresent;
    }

    public void setCardPresent(String cardPresent) {
        this.cardPresent = cardPresent;
    }

    public String getRateDesc() {
        return rateDesc;
    }

    public void setRateDesc(String rateDesc) {
        this.rateDesc = rateDesc;
    }

    public Double getInterchangeFee() {
        return interchangeFee;
    }

    public void setInterchangeFee(Double interchangeFee) {
        this.interchangeFee = interchangeFee;
    }

    public Double getInterchangePerc() {
        return interchangePerc;
    }

    public void setInterchangePerc(Double interchangePerc) {
        this.interchangePerc = interchangePerc;
    }

    public Double getInterchangeVat() {
        return interchangeVat;
    }

    public void setInterchangeVat(Double interchangeVat) {
        this.interchangeVat = interchangeVat;
    }

    public Double getCashbackIcFee() {
        return cashbackIcFee;
    }

    public void setCashbackIcFee(Double cashbackIcFee) {
        this.cashbackIcFee = cashbackIcFee;
    }

    public Double getCashbackIcPerc() {
        return cashbackIcPerc;
    }

    public void setCashbackIcPerc(Double cashbackIcPerc) {
        this.cashbackIcPerc = cashbackIcPerc;
    }

    public Double getCashbackIcVat() {
        return cashbackIcVat;
    }

    public void setCashbackIcVat(Double cashbackIcVat) {
        this.cashbackIcVat = cashbackIcVat;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csoPaymentInstructionsMcardPK != null ? csoPaymentInstructionsMcardPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoPaymentInstructionsMcard)) {
            return false;
        }
        CsoPaymentInstructionsMcard other = (CsoPaymentInstructionsMcard) object;
        if ((this.csoPaymentInstructionsMcardPK == null && other.csoPaymentInstructionsMcardPK != null) || (this.csoPaymentInstructionsMcardPK != null && !this.csoPaymentInstructionsMcardPK.equals(other.csoPaymentInstructionsMcardPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoPaymentInstructionsMcard[ csoPaymentInstructionsMcardPK=" + csoPaymentInstructionsMcardPK + " ]";
    }
    
}
