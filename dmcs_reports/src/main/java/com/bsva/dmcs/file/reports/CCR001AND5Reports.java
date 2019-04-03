package com.bsva.dmcs.file.reports;

import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.bsva.dmcs.file.reports.dto.ReportsSubline;
import com.bsva.dmcs.reports.SummaryPage;

/**
 * @author AugustineA
 *
 */
@XmlRootElement(name = "employee")
@XmlAccessorType (XmlAccessType.FIELD)
public class CCR001AND5Reports {

	private String recorIdentifier;
	private String outputDate;
	private String serviceType;
	private String subServiceType;
	private String bankMemberNumber;
	private String originator;
	private String fileName;
	private String fileNumber;
	private String dataType;
	private String dataDirection;
	private String settlementDate;
	private String testLive;
	private String recordSize;
	private String filler;
	private String reportSortSequence;
	
	private String compName;
	private String reportName;//CCR001
	private String bankersName;//SOUTH AFRICAN BANKERS SERVICES COMPANY LIMITED
	private String processDate;
	private String page;//PAGE:-
	private String pageNumber;
	private String taxInvoiceNumber;//TAX INVOICE NUMBER: 
	private String invoiceNumber;
	private String regNumber;//REG.NO.  
	private String companyRegNumber;
	private String subservice;
	private String service;
	private ReportsSubline reportsSub;
	
	private String to;
	private String from;
	
	private String transactionDescription;//C R E D I T   C A R D   F E E   C A L C U L A T I O N   R E P O R T
	private String underLine;//---------------------------------------------------------------------------------------------------------
	private String toAddress;
	private String toAddress2;
	private String toAddress3;
	private String toAddress4;
	private String toVatRegNo;
	private String fromAddress;
	private String fromAddress2;
	private String fromAddress3;
	private String fromAddress4;
	private String fromVatRegNo;
	private String countHeader;
	private String amountHeader;
	private String itemHeader;
	private String transactionTypes;
	private String subTotals;
	private String grandTotals;
	private long volume = 0;
	private long value = 0;
	private Double billAmount = 0.00;
	private Double billAdvAmount = 0.00;
	private Double billVat = 0.00;
	private Double totalCharges = 0.00;
	private Double nettAmount = 0.00;
	private String totalName = "";
	private String subService = "";
	private String elDescription = "";
	private FromAddress fromAddres;
	private ToAddress toAddres;
	
	private String count;
	private String amount;
	private String interchange;
	private String vat;
	private String totalCharge;
	private String netAmount;
	
	private String transCount;
	private String transAmount;
	private String transInterchange;
	private String transVat;
	private String transTotalCharge;
	private String transNetAmount;

	
	private HeaderRecord headerRecord;
	private FooterRecord footerRecord;
	private TaxInvoiceSubline taxInvoiceSubline;
	private ReportLine reportLine;
	private TaxRegNumber taxRegNumber;
	
	private String cardType;
	
	

	private String salesDraftSD;
	private String chargeBacksSD;
	private String reversalsSD;
	private String subTotalSalesSD;
	
	private String countSD = "0";
	private String amountSD ;
	private String interchangeSD ;
	private String vatSD ;
	private String totalChargeSD ;
	private String netAmountSD ;
	
	private String purchaseWCashPurc;
	private String chargBackWCAPurc;
	private String reversalsWCashPurc;
	private String cashBackOnPRPurc;
	private String cashBackWPurc;
	private String reversalsWPurc;	
	private String subTotalsPurc;
	
	private String countPurc  = "0";
	private String amountPurc ;
	private String interchangePurc ;
	private String vatPurc ;
	private String totalChargePurc ;
	private String netAmountPurc ;
	
	private String cashBackNoP;
	private String chargBacksP;
	private String reversalCashP;
	private String subTotalsP;
	
	private String countP;
	private String amountP ;
	private String interchangeP ;
	private String vatP ;
	private String totalChargeP ;
	private String netAmountP ;
	
	private String petrolSalesPS;
	private String chargBacksPS;
	private String reversalsPS;
	private String subTotalsPS;
	
	private String countPS ;
	private String amountPS ;
	private String interchangePS ;
	private String vatPS ;
	private String totalChargePS ;
	private String netAmountPS ;
	
	private String creditVouchersCV;
	private String chargeBacksCV;
	private String reversalsCV;
	private String subTotalsCV;
	
	private String countCV ;
	private String amountCV ;
	private String interchangeCV ;
	private String vatCV ;
	private String totalChargeCV ;
	private String netAmountCV ;
	
	
	private String cashAdvancesCA;
	private String chargeBacksCA;
	private String reversalsCA;
	private String subTotalsCA;
	
	private String countCA ;
	private String amountCA ;
	private String interchangeCA ;
	private String vatCA ;
	private String totalChargeCA ;
	private String netAmountCA ;
	
	private String transactionTypeDecsription;
	private String grandTotalsAll;
	
	private String countAll;
	private String amountAll;
	private String interchangeAll;
	private String vatAll;
	private String totalChargeAll;
	private String netAmountAll;
	private String underlines;
	
	private String subTotalsAll;
	private String subTotalsCount;
	private String subTotalsAmount;
	private String subTotalsInterchange;
	private String subTotalsVat;
	private String subTotalsTotalCharges;
	private String subTotalsNetAmount;
	
	private String grandTotalsName;
	private String grandTotalsCountCalc;
	private String grandTotalsAmountCalc;
	private String grandTotalsInterchangeCalc;
	private String grandTotalsVatCalc;
	private String grandTotalsTotalChargesCalc;
	private String grandTotalsNetAmountCalc;
	private SummaryPage summaryPage;
	
	public String getReportSortSequence() {
		return reportSortSequence;
	}
	public void setReportSortSequence(String reportSortSequence) {
		this.reportSortSequence = reportSortSequence;
	}
	public SummaryPage getSummaryPage() {
		return summaryPage;
	}
	public void setSummaryPage(SummaryPage summaryPage) {
		this.summaryPage = summaryPage;
	}
	public String getGrandTotalsName() {
		return grandTotalsName;
	}
	public void setGrandTotalsName(String grandTotalsName) {
		this.grandTotalsName = grandTotalsName;
	}
	public String getGrandTotalsCountCalc() {
		return grandTotalsCountCalc;
	}
	public String getGrandTotalsAmountCalc() {
		return grandTotalsAmountCalc;
	}
	public String getGrandTotalsInterchangeCalc() {
		return grandTotalsInterchangeCalc;
	}
	public String getGrandTotalsVatCalc() {
		return grandTotalsVatCalc;
	}
	public String getGrandTotalsTotalChargesCalc() {
		return grandTotalsTotalChargesCalc;
	}
	public String getGrandTotalsNetAmountCalc() {
		return grandTotalsNetAmountCalc;
	}
	public void setGrandTotalsCountCalc(String grandTotalsCountCalc) {
		this.grandTotalsCountCalc = grandTotalsCountCalc;
	}
	public void setGrandTotalsAmountCalc(String grandTotalsAmountCalc) {
		this.grandTotalsAmountCalc = grandTotalsAmountCalc;
	}
	public void setGrandTotalsInterchangeCalc(String grandTotalsInterchangeCalc) {
		this.grandTotalsInterchangeCalc = grandTotalsInterchangeCalc;
	}
	public void setGrandTotalsVatCalc(String grandTotalsVatCalc) {
		this.grandTotalsVatCalc = grandTotalsVatCalc;
	}
	public void setGrandTotalsTotalChargesCalc(String grandTotalsTotalChargesCalc) {
		this.grandTotalsTotalChargesCalc = grandTotalsTotalChargesCalc;
	}
	public void setGrandTotalsNetAmountCalc(String grandTotalsNetAmountCalc) {
		this.grandTotalsNetAmountCalc = grandTotalsNetAmountCalc;
	}
	public String getSubTotalsAll() {
		return subTotalsAll;
	}
	public String getSubTotalsCount() {
		return subTotalsCount;
	}
	public String getSubTotalsAmount() {
		return subTotalsAmount;
	}
	public String getSubTotalsInterchange() {
		return subTotalsInterchange;
	}
	public String getSubTotalsVat() {
		return subTotalsVat;
	}
	public String getSubTotalsTotalCharges() {
		return subTotalsTotalCharges;
	}
	public String getSubTotalsNetAmount() {
		return subTotalsNetAmount;
	}
	public void setSubTotalsAll(String subTotalsAll) {
		this.subTotalsAll = subTotalsAll;
	}
	public void setSubTotalsCount(String subTotalsCount) {
		this.subTotalsCount = subTotalsCount;
	}
	public void setSubTotalsAmount(String subTotalsAmount) {
		this.subTotalsAmount = subTotalsAmount;
	}
	public void setSubTotalsInterchange(String subTotalsInterchange) {
		this.subTotalsInterchange = subTotalsInterchange;
	}
	public void setSubTotalsVat(String subTotalsVat) {
		this.subTotalsVat = subTotalsVat;
	}
	public void setSubTotalsTotalCharges(String subTotalsTotalCharges) {
		this.subTotalsTotalCharges = subTotalsTotalCharges;
	}
	public void setSubTotalsNetAmount(String subTotalsNetAmount) {
		this.subTotalsNetAmount = subTotalsNetAmount;
	}
	public String getTransCount() {
		return transCount;
	}
	
	public String getTransAmount() {
		return transAmount;
	}
	public String getTransInterchange() {
		return transInterchange;
	}
	public String getTransVat() {
		return transVat;
	}
	public String getTransTotalCharge() {
		return transTotalCharge;
	}
	public String getTransNetAmount() {
		return transNetAmount;
	}
	public void setTransCount(String transCount) {
		this.transCount = transCount;
	}
	public void setTransAmount(String transAmount) {
		this.transAmount = transAmount;
	}
	public void setTransInterchange(String transInterchange) {
		this.transInterchange = transInterchange;
	}
	public void setTransVat(String transVat) {
		this.transVat = transVat;
	}
	public void setTransTotalCharge(String transTotalCharge) {
		this.transTotalCharge = transTotalCharge;
	}
	public void setTransNetAmount(String transNetAmount) {
		this.transNetAmount = transNetAmount;
	}	
	public String getTransactionTypeDecsription() {
		return transactionTypeDecsription;
	}
	public void setTransactionTypeDecsription(String transactionType) {
		this.transactionTypeDecsription = transactionType;
	}
	public FooterRecord getFooterRecord() {
		return footerRecord;
	}
	public void setFooterRecord(FooterRecord footerRecord) {
		this.footerRecord = footerRecord;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	public String getUnderlines() {
		return underlines;
	}
	public void setUnderlines(String underlines) {
		this.underlines = underlines;
	}
	public String getSalesDraftSD() {
		return salesDraftSD;
	}
	public String getChargeBacksSD() {
		return chargeBacksSD;
	}
	public String getReversalsSD() {
		return reversalsSD;
	}
	public String getSubTotalSalesSD() {
		return subTotalSalesSD;
	}
	public String getCountSD() {
		return countSD;
	}
	public String getAmountSD() {
		return amountSD;
	}
	public String getInterchangeSD() {
		return interchangeSD;
	}
	public String getVatSD() {
		return vatSD;
	}
	public String getTotalChargeSD() {
		return totalChargeSD;
	}
	public String getNetAmountSD() {
		return netAmountSD;
	}
	public String getPurchaseWCashPurc() {
		return purchaseWCashPurc;
	}
	public String getChargBackWCAPurc() {
		return chargBackWCAPurc;
	}
	public String getReversalsWCashPurc() {
		return reversalsWCashPurc;
	}
	public String getCashBackOnPRPurc() {
		return cashBackOnPRPurc;
	}
	public String getCashBackWPurc() {
		return cashBackWPurc;
	}
	public String getReversalsWPurc() {
		return reversalsWPurc;
	}
	public String getSubTotalsPurc() {
		return subTotalsPurc;
	}
	public String getCountPurc() {
		return countPurc;
	}
	public String getAmountPurc() {
		return amountPurc;
	}
	public String getInterchangePurc() {
		return interchangePurc;
	}
	public String getVatPurc() {
		return vatPurc;
	}
	public String getTotalChargePurc() {
		return totalChargePurc;
	}
	public String getNetAmountPurc() {
		return netAmountPurc;
	}
	public String getCashBackNoP() {
		return cashBackNoP;
	}
	public String getChargBacksP() {
		return chargBacksP;
	}
	public String getReversalCashP() {
		return reversalCashP;
	}
	public String getSubTotalsP() {
		return subTotalsP;
	}
	public String getCountP() {
		return countP;
	}
	public String getAmountP() {
		return amountP;
	}
	public String getInterchangeP() {
		return interchangeP;
	}
	public String getVatP() {
		return vatP;
	}
	public String getTotalChargeP() {
		return totalChargeP;
	}
	public String getNetAmountP() {
		return netAmountP;
	}
	public String getPetrolSalesPS() {
		return petrolSalesPS;
	}
	public String getChargBacksPS() {
		return chargBacksPS;
	}
	public String getReversalsPS() {
		return reversalsPS;
	}
	public String getSubTotalsPS() {
		return subTotalsPS;
	}
	public String getCountPS() {
		return countPS;
	}
	public String getAmountPS() {
		return amountPS;
	}
	public String getInterchangePS() {
		return interchangePS;
	}
	public String getVatPS() {
		return vatPS;
	}
	public String getTotalChargePS() {
		return totalChargePS;
	}
	public String getNetAmountPS() {
		return netAmountPS;
	}
	public String getCreditVouchersCV() {
		return creditVouchersCV;
	}
	public String getChargeBacksCV() {
		return chargeBacksCV;
	}
	public String getReversalsCV() {
		return reversalsCV;
	}
	public String getSubTotalsCV() {
		return subTotalsCV;
	}
	public String getCountCV() {
		return countCV;
	}
	public String getAmountCV() {
		return amountCV;
	}
	public String getInterchangeCV() {
		return interchangeCV;
	}
	public String getVatCV() {
		return vatCV;
	}
	public String getTotalChargeCV() {
		return totalChargeCV;
	}
	public String getNetAmountCV() {
		return netAmountCV;
	}
	public String getCashAdvancesCA() {
		return cashAdvancesCA;
	}
	public String getChargeBacksCA() {
		return chargeBacksCA;
	}
	public String getReversalsCA() {
		return reversalsCA;
	}
	public String getSubTotalsCA() {
		return subTotalsCA;
	}
	public String getCountCA() {
		return countCA;
	}
	public String getAmountCA() {
		return amountCA;
	}
	public String getInterchangeCA() {
		return interchangeCA;
	}
	public String getVatCA() {
		return vatCA;
	}
	public String getTotalChargeCA() {
		return totalChargeCA;
	}
	public String getNetAmountCA() {
		return netAmountCA;
	}
	public String getGrandTotalsAll() {
		return grandTotalsAll;
	}
	public String getCountAll() {
		return countAll;
	}
	public String getAmountAll() {
		return amountAll;
	}
	public String getInterchangeAll() {
		return interchangeAll;
	}
	public String getVatAll() {
		return vatAll;
	}
	public String getTotalChargeAll() {
		return totalChargeAll;
	}
	public String getNetAmountAll() {
		return netAmountAll;
	}
	public void setSalesDraftSD(String salesDraftSD) {
		this.salesDraftSD = salesDraftSD;
	}
	public void setChargeBacksSD(String chargeBacksSD) {
		this.chargeBacksSD = chargeBacksSD;
	}
	public void setReversalsSD(String reversalsSD) {
		this.reversalsSD = reversalsSD;
	}
	public void setSubTotalSalesSD(String subTotalSalesSD) {
		this.subTotalSalesSD = subTotalSalesSD;
	}
	public void setCountSD(String countSD) {
		this.countSD = countSD;
	}
	public void setAmountSD(String amountSD) {
		this.amountSD = amountSD;
	}
	public void setInterchangeSD(String interchangeSD) {
		this.interchangeSD = interchangeSD;
	}
	public void setVatSD(String vatSD) {
		this.vatSD = vatSD;
	}
	public void setTotalChargeSD(String totalChargeSD) {
		this.totalChargeSD = totalChargeSD;
	}
	public void setNetAmountSD(String netAmountSD) {
		this.netAmountSD = netAmountSD;
	}
	public void setPurchaseWCashPurc(String purchaseWCashPurc) {
		this.purchaseWCashPurc = purchaseWCashPurc;
	}
	public void setChargBackWCAPurc(String chargBackWCAPurc) {
		this.chargBackWCAPurc = chargBackWCAPurc;
	}
	public void setReversalsWCashPurc(String reversalsWCashPurc) {
		this.reversalsWCashPurc = reversalsWCashPurc;
	}
	public void setCashBackOnPRPurc(String cashBackOnPRPurc) {
		this.cashBackOnPRPurc = cashBackOnPRPurc;
	}
	public void setCashBackWPurc(String cashBackWPurc) {
		this.cashBackWPurc = cashBackWPurc;
	}
	public void setReversalsWPurc(String reversalsWPurc) {
		this.reversalsWPurc = reversalsWPurc;
	}
	public void setSubTotalsPurc(String subTotalsPurc) {
		this.subTotalsPurc = subTotalsPurc;
	}
	public void setCountPurc(String countPurc) {
		this.countPurc = countPurc;
	}
	public void setAmountPurc(String amountPurc) {
		this.amountPurc = amountPurc;
	}
	public void setInterchangePurc(String interchangePurc) {
		this.interchangePurc = interchangePurc;
	}
	public void setVatPurc(String vatPurc) {
		this.vatPurc = vatPurc;
	}
	public void setTotalChargePurc(String totalChargePurc) {
		this.totalChargePurc = totalChargePurc;
	}
	public void setNetAmountPurc(String netAmountPurc) {
		this.netAmountPurc = netAmountPurc;
	}
	public void setCashBackNoP(String cashBackNoP) {
		this.cashBackNoP = cashBackNoP;
	}
	public void setChargBacksP(String chargBacksP) {
		this.chargBacksP = chargBacksP;
	}
	public void setReversalCashP(String reversalCashP) {
		this.reversalCashP = reversalCashP;
	}
	public void setSubTotalsP(String subTotalsP) {
		this.subTotalsP = subTotalsP;
	}
	public void setCountP(String countP) {
		this.countP = countP;
	}
	public void setAmountP(String amountP) {
		this.amountP = amountP;
	}
	public void setInterchangeP(String interchangeP) {
		this.interchangeP = interchangeP;
	}
	public void setVatP(String vatP) {
		this.vatP = vatP;
	}
	public void setTotalChargeP(String totalChargeP) {
		this.totalChargeP = totalChargeP;
	}
	public void setNetAmountP(String netAmountP) {
		this.netAmountP = netAmountP;
	}
	public void setPetrolSalesPS(String petrolSalesPS) {
		this.petrolSalesPS = petrolSalesPS;
	}
	public void setChargBacksPS(String chargBacksPS) {
		this.chargBacksPS = chargBacksPS;
	}
	public void setReversalsPS(String reversalsPS) {
		this.reversalsPS = reversalsPS;
	}
	public void setSubTotalsPS(String subTotalsPS) {
		this.subTotalsPS = subTotalsPS;
	}
	public void setCountPS(String countPS) {
		this.countPS = countPS;
	}
	public void setAmountPS(String amountPS) {
		this.amountPS = amountPS;
	}
	public void setInterchangePS(String interchangePS) {
		this.interchangePS = interchangePS;
	}
	public void setVatPS(String vatPS) {
		this.vatPS = vatPS;
	}
	public void setTotalChargePS(String totalChargePS) {
		this.totalChargePS = totalChargePS;
	}
	public void setNetAmountPS(String netAmountPS) {
		this.netAmountPS = netAmountPS;
	}
	public void setCreditVouchersCV(String creditVouchersCV) {
		this.creditVouchersCV = creditVouchersCV;
	}
	public void setChargeBacksCV(String chargeBacksCV) {
		this.chargeBacksCV = chargeBacksCV;
	}
	public void setReversalsCV(String reversalsCV) {
		this.reversalsCV = reversalsCV;
	}
	public void setSubTotalsCV(String subTotalsCV) {
		this.subTotalsCV = subTotalsCV;
	}
	public void setCountCV(String countCV) {
		this.countCV = countCV;
	}
	public void setAmountCV(String amountCV) {
		this.amountCV = amountCV;
	}
	public void setInterchangeCV(String interchangeCV) {
		this.interchangeCV = interchangeCV;
	}
	public void setVatCV(String vatCV) {
		this.vatCV = vatCV;
	}
	public void setTotalChargeCV(String totalChargeCV) {
		this.totalChargeCV = totalChargeCV;
	}
	public void setNetAmountCV(String netAmountCV) {
		this.netAmountCV = netAmountCV;
	}
	public void setCashAdvancesCA(String cashAdvancesCA) {
		this.cashAdvancesCA = cashAdvancesCA;
	}
	public void setChargeBacksCA(String chargeBacksCA) {
		this.chargeBacksCA = chargeBacksCA;
	}
	public void setReversalsCA(String reversalsCA) {
		this.reversalsCA = reversalsCA;
	}
	public void setSubTotalsCA(String subTotalsCA) {
		this.subTotalsCA = subTotalsCA;
	}
	public void setCountCA(String countCA) {
		this.countCA = countCA;
	}
	public void setAmountCA(String amountCA) {
		this.amountCA = amountCA;
	}
	public void setInterchangeCA(String interchangeCA) {
		this.interchangeCA = interchangeCA;
	}
	public void setVatCA(String vatCA) {
		this.vatCA = vatCA;
	}
	public void setTotalChargeCA(String totalChargeCA) {
		this.totalChargeCA = totalChargeCA;
	}
	public void setNetAmountCA(String netAmountCA) {
		this.netAmountCA = netAmountCA;
	}
	public void setGrandTotalsAll(String grandTotalsAll) {
		this.grandTotalsAll = grandTotalsAll;
	}
	public void setCountAll(String countAll) {
		this.countAll = countAll;
	}
	public void setAmountAll(String amountAll) {
		this.amountAll = amountAll;
	}
	public void setInterchangeAll(String interchangeAll) {
		this.interchangeAll = interchangeAll;
	}
	public void setVatAll(String vatAll) {
		this.vatAll = vatAll;
	}
	public void setTotalChargeAll(String totalChargeAll) {
		this.totalChargeAll = totalChargeAll;
	}
	public void setNetAmountAll(String netAmountAll) {
		this.netAmountAll = netAmountAll;
	}
	
	
	public TaxRegNumber getTaxRegNumber() {
		return taxRegNumber;
	}


	public void setTaxRegNumber(TaxRegNumber taxRegNumber) {
		this.taxRegNumber = taxRegNumber;
	}


	public ReportLine getReportLine() {
		return reportLine;
	}


	public void setReportLine(ReportLine reportLine) {
		this.reportLine = reportLine;
	}


	public TaxInvoiceSubline getTaxInvoiceSubline() {
		return taxInvoiceSubline;
	}


	public void setTaxInvoiceSubline(TaxInvoiceSubline taxInvoiceSubline) {
		this.taxInvoiceSubline = taxInvoiceSubline;
	}


	public HeaderRecord getHeaderRecord() {
		return headerRecord;
	}


	public void setHeaderRecord(HeaderRecord headerRecord) {
		this.headerRecord = headerRecord;
	}

	public ReportsSubline getReportsSub() {
		return reportsSub;
	}


	public void setReportsSub(ReportsSubline reportsSub) {
		this.reportsSub = reportsSub;
	}
	
	
	public String getCount() {
		return count;
	}


	public void setCount(String count) {
		this.count = count;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getInterchange() {
		return interchange;
	}


	public void setInterchange(String interchange) {
		this.interchange = interchange;
	}


	public String getVat() {
		return vat;
	}


	public void setVat(String vat) {
		this.vat = vat;
	}


	public String getTotalCharge() {
		return totalCharge;
	}


	public void setTotalCharge(String totalCharge) {
		this.totalCharge = totalCharge;
	}


	public String getNetAmount() {
		return netAmount;
	}


	public void setNetAmount(String netAmount) {
		this.netAmount = netAmount;
	}


	public ToAddress getToAddres() {
		return toAddres;
	}


	public void setToAddres(ToAddress toAddres) {
		this.toAddres = toAddres;
	}


	public FromAddress getFromAddres() {
		return fromAddres;
	}


	public void setFromAddres(FromAddress fromAddres) {
		this.fromAddres = fromAddres;
	}


	public CCR001AND5Reports() {
	}


	public String getRecorIdentifier() {
		return recorIdentifier;
	}


	public void setRecorIdentifier(String recorIdentifier) {
		this.recorIdentifier = recorIdentifier;
	}


	public String getOutputDate() {
		return outputDate;
	}


	public void setOutputDate(String outputDate) {
		this.outputDate = outputDate;
	}


	public String getServiceType() {
		return serviceType;
	}


	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}


	public String getSubServiceType() {
		return subServiceType;
	}


	public void setSubServiceType(String subServiceType) {
		this.subServiceType = subServiceType;
	}


	public String getBankMemberNumber() {
		return bankMemberNumber;
	}


	public void setBankMemberNumber(String bankMemberNumber) {
		this.bankMemberNumber = bankMemberNumber;
	}


	public String getOriginator() {
		return originator;
	}


	public void setOriginator(String originator) {
		this.originator = originator;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFileNumber() {
		return fileNumber;
	}


	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}


	public String getDataType() {
		return dataType;
	}


	public void setDataType(String dataType) {
		this.dataType = dataType;
	}


	public String getDataDirection() {
		return dataDirection;
	}


	public void setDataDirection(String dataDirection) {
		this.dataDirection = dataDirection;
	}


	public String getSettlementDate() {
		return settlementDate;
	}


	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}


	public String getTestLive() {
		return testLive;
	}


	public void setTestLive(String testLive) {
		this.testLive = testLive;
	}


	public String getRecordSize() {
		return recordSize;
	}


	public void setRecordSize(String recordSize) {
		this.recordSize = recordSize;
	}


	public String getFiller() {
		return filler;
	}


	public void setFiller(String filler) {
		this.filler = filler;
	}


	public String getCompName() {
		return compName;
	}


	public void setCompName(String compName) {
		this.compName = compName;
	}


	public String getReportName() {
		return reportName;
	}


	public void setReportName(String reportName) {
		this.reportName = reportName;
	}


	public String getBankersName() {
		return bankersName;
	}


	public void setBankersName(String bankersName) {
		this.bankersName = bankersName;
	}


	public String getProcessDate() {
		return processDate;
	}


	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}


	public String getPage() {
		return page;
	}


	public void setPage(String page) {
		this.page = page;
	}


	public String getPageNumber() {
		return pageNumber;
	}


	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}


	public String getTaxInvoiceNumber() {
		return taxInvoiceNumber;
	}


	public void setTaxInvoiceNumber(String taxInvoiceNumber) {
		this.taxInvoiceNumber = taxInvoiceNumber;
	}


	public String getInvoiceNumber() {
		return invoiceNumber;
	}


	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}


	public String getRegNumber() {
		return regNumber;
	}


	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}


	public String getCompanyRegNumber() {
		return companyRegNumber;
	}


	public void setCompanyRegNumber(String companyRegNumber) {
		this.companyRegNumber = companyRegNumber;
	}


	public String getSubservice() {
		return subservice;
	}


	public void setSubservice(String subservice) {
		this.subservice = subservice;
	}


	public String getService() {
		return service;
	}


	public void setService(String service) {
		this.service = service;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTransactionDescription() {
		return transactionDescription;
	}


	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}


	public String getUnderLine() {
		return underLine;
	}


	public void setUnderLine(String underLine) {
		this.underLine = underLine;
	}


	public String getToAddress() {
		return toAddress;
	}


	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}


	public String getToAddress2() {
		return toAddress2;
	}


	public void setToAddress2(String toAddress2) {
		this.toAddress2 = toAddress2;
	}


	public String getToAddress3() {
		return toAddress3;
	}


	public void setToAddress3(String toAddress3) {
		this.toAddress3 = toAddress3;
	}


	public String getToAddress4() {
		return toAddress4;
	}


	public void setToAddress4(String toAddress4) {
		this.toAddress4 = toAddress4;
	}


	public String getToVatRegNo() {
		return toVatRegNo;
	}


	public void setToVatRegNo(String toVatRegNo) {
		this.toVatRegNo = toVatRegNo;
	}


	public String getFromAddress() {
		return fromAddress;
	}


	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}


	public String getFromAddress2() {
		return fromAddress2;
	}


	public void setFromAddress2(String fromAddress2) {
		this.fromAddress2 = fromAddress2;
	}


	public String getFromAddress3() {
		return fromAddress3;
	}


	public void setFromAddress3(String fromAddress3) {
		this.fromAddress3 = fromAddress3;
	}


	public String getFromAddress4() {
		return fromAddress4;
	}


	public void setFromAddress4(String fromAddress4) {
		this.fromAddress4 = fromAddress4;
	}


	public String getFromVatRegNo() {
		return fromVatRegNo;
	}


	public void setFromVatRegNo(String fromVatRegNo) {
		this.fromVatRegNo = fromVatRegNo;
	}


	public String getCountHeader() {
		return countHeader;
	}


	public void setCountHeader(String countHeader) {
		this.countHeader = countHeader;
	}


	public String getAmountHeader() {
		return amountHeader;
	}


	public void setAmountHeader(String amountHeader) {
		this.amountHeader = amountHeader;
	}


	public String getItemHeader() {
		return itemHeader;
	}


	public void setItemHeader(String itemHeader) {
		this.itemHeader = itemHeader;
	}


	public String getTransactionTypes() {
		return transactionTypes;
	}


	public void setTransactionTypes(String transactionTypes) {
		this.transactionTypes = transactionTypes;
	}


	public String getSubTotals() {
		return subTotals;
	}


	public void setSubTotals(String subTotals) {
		this.subTotals = subTotals;
	}


	public String getGrandTotals() {
		return grandTotals;
	}


	public void setGrandTotals(String grandTotals) {
		this.grandTotals = grandTotals;
	}


	public long getVolume() {
		return volume;
	}


	public void setVolume(long volume) {
		this.volume = volume;
	}


	public long getValue() {
		return value;
	}


	public void setValue(long value) {
		this.value = value;
	}


	public Double getBillAmount() {
		return billAmount;
	}


	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}


	public Double getBillAdvAmount() {
		return billAdvAmount;
	}


	public void setBillAdvAmount(Double billAdvAmount) {
		this.billAdvAmount = billAdvAmount;
	}


	public Double getBillVat() {
		return billVat;
	}


	public void setBillVat(Double billVat) {
		this.billVat = billVat;
	}


	public Double getTotalCharges() {
		return totalCharges;
	}


	public void setTotalCharges(Double totalCharges) {
		this.totalCharges = totalCharges;
	}


	public Double getNettAmount() {
		return nettAmount;
	}


	public void setNettAmount(Double nettAmount) {
		this.nettAmount = nettAmount;
	}


	public String getTotalName() {
		return totalName;
	}


	public void setTotalName(String totalName) {
		this.totalName = totalName;
	}


	public String getSubService() {
		return subService;
	}


	public void setSubService(String subService) {
		this.subService = subService;
	}


	public String getElDescription() {
		return elDescription;
	}


	public void setElDescription(String elDescription) {
		this.elDescription = elDescription;
	}
	
	
	public void clearTotals() {
		volume = 0;
		value = 0;
		billAmount = 0.00;
		billAdvAmount = 0.0;
		billVat = 0.00;
		totalCharges = 0.00;
		nettAmount = 0.00;
	}

	public void setDescription(String inDescription) {
		elDescription = inDescription;
	}

	public void addToTotals(long vol,double repValue,double repBillAmnt,double repBillPrec,double repBilVat) {
		volume += vol;
		value += repValue;
		billAmount += repBillAmnt;
		billAdvAmount += repBillPrec;
		billVat += repBilVat;
		totalCharges = billAmount + billAdvAmount + billVat;
		nettAmount = value + totalCharges;
	}

	public void addToTotals(CCR001AND5Reports inEl) {
		volume += inEl.volume;
		value += inEl.value;
		billAmount += inEl.billAmount;
		billAdvAmount += inEl.billAdvAmount;
		billVat += inEl.billVat;
		totalCharges = billAmount + billAdvAmount + billVat;
		nettAmount = value + totalCharges;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if(to != null){
		builder.append(to == null ? rightPadding(" ",1):rightPadding("TO:-  "+to,95) + rightPadZeros("FROM:-  "+from,17));	
		builder.append(System.lineSeparator());
		}
		if(toAddress != null){
		builder.append(toAddress == null ? rightPadding(" ",1)  :rightPadZeros(toAddress,95)  + rightPadZeros(fromAddress,17));
		builder.append(System.lineSeparator());
		}
		if(toAddress2 != null){
		builder.append(toAddress2 == null ? rightPadding(" ",1) :rightPadZeros(toAddress2,95) + rightPadZeros(fromAddress2,17));
		builder.append(System.lineSeparator());
		}
		if(toAddress3 != null){
		builder.append(toAddress3 == null ? rightPadding(" ",1) :rightPadZeros(toAddress3,95) + rightPadZeros(fromAddress3,17));
		builder.append(System.lineSeparator());
		}
		if(toAddress4 != null){
		builder.append(toAddress4 == null ? rightPadding(" ",1) :rightPadZeros(toAddress4,95) + rightPadZeros(fromAddress4,17));
		builder.append(System.lineSeparator());
		}
		if(toVatRegNo != null){
		builder.append(toVatRegNo == null ? rightPadding(" ",1) :rightPadZeros(toVatRegNo,95) + rightPadZeros(fromVatRegNo,17));
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		}
		if(count != null){
		builder.append(count == null ? rightPadding(" ",17) :padLeft(count,43) + padLeft(amount,18) + padLeft(interchange,16) + padLeft(vat,15) + padLeft(totalCharge,22) + padLeft(netAmount,17));
		builder.append(System.lineSeparator());
		}
		//builder.append(underlines == null ? rightPadding(" ",1) :rightPadZeros("",17) + padLeft(underlines,17) + padLeft(underlines,17) + padLeft(underlines,17)+ padLeft(underlines,17) + padLeft(underlines,17)+ padLeft(underlines,17));
		//builder.append(System.lineSeparator());
		if(transactionTypeDecsription != null){
		builder.append(transactionTypeDecsription == null ? rightPadding(" ",1) :rightPadZeros(transactionTypeDecsription,24) + padLeft(transCount,17) + padLeft(transAmount,17) + padLeft(transInterchange,17)+ padLeft(transVat,17) + padLeft(transTotalCharge,17)+ padLeft(transNetAmount,17));
		builder.append(System.lineSeparator());
		builder.append(underlines == null ? rightPadding(" ",1) :rightPadZeros("",17) + padLeft(underlines,17) + padLeft(underlines,17) + padLeft(underlines,17)+ padLeft(underlines,17) + padLeft(underlines,17)+ padLeft(underlines,17));
		builder.append(System.lineSeparator());
		}
		if(subTotalsAll != null){
		builder.append(subTotalsAll == null ? rightPadding(" ",1) :rightPadZeros(subTotalsAll,24) + padLeft(subTotalsCount,17) + padLeft(subTotalsAmount,17) + padLeft(subTotalsInterchange,17)+ padLeft(subTotalsVat,17) + padLeft(subTotalsTotalCharges,17)+ padLeft(subTotalsNetAmount,17));
		builder.append(System.lineSeparator());
		builder.append(underlines == null ? rightPadding(" ",1) :rightPadZeros("",17) + padLeft(underlines,17) + padLeft(underlines,17) + padLeft(underlines,17)+ padLeft(underlines,17) + padLeft(underlines,17)+ padLeft(underlines,17));
		builder.append(System.lineSeparator());
		}
		if(grandTotalsName != null){
		builder.append(grandTotalsName == null ? rightPadding(" ",1) :rightPadZeros(grandTotalsName,24) + padLeft(grandTotalsCountCalc,17) + padLeft(grandTotalsAmountCalc,17) + padLeft(grandTotalsInterchangeCalc,17)+ padLeft(grandTotalsVatCalc,17) + padLeft(grandTotalsTotalChargesCalc,17)+ padLeft(grandTotalsNetAmountCalc,17));
		builder.append(System.lineSeparator());
		builder.append(underlines == null ? rightPadding(" ",1) :rightPadZeros("",17) + padLeft(underlines,17) + padLeft(underlines,17) + padLeft(underlines,17)+ padLeft(underlines,17) + padLeft(underlines,17)+ padLeft(underlines,17));
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		}
		/*		
		builder.append(cashAdvancesCA == null ? rightPadding(" ",1) :rightPadZeros(cashAdvancesCA,17) + padLeft(countCA,17) + padLeft(amountCA,17) + padLeft(interchangeCA,17)+ padLeft(vatCA,17) + padLeft(totalChargeCA,17)+ padLeft(netAmountCA,17));
		builder.append(System.lineSeparator());
		builder.append(chargeBacksCA == null ? rightPadding(" ",1) :rightPadZeros(chargeBacksCA,17) + padLeft(countCA,17) + padLeft(amountCA,17) + padLeft(interchangeCA,17)+ padLeft(vatCA,17) + padLeft(totalChargeCA,17)+ padLeft(netAmountCA,17));
		builder.append(System.lineSeparator());
		builder.append(reversalsCA == null ? rightPadding(" ",1) :rightPadZeros(reversalsCA,17) + padLeft(countCA,17) + padLeft(amountCA,17) + padLeft(interchangeCA,17)+ padLeft(vatCA,17) + padLeft(totalChargeCA,17)+ padLeft(netAmountCA,17));
		builder.append(System.lineSeparator());
		builder.append(underlines == null ? rightPadding(" ",1) :rightPadZeros("",17) + padLeft(underlines,17) + padLeft(underlines,17) + padLeft(underlines,17)+ padLeft(underlines,17) + padLeft(underlines,17)+ padLeft(underlines,17));
		builder.append(System.lineSeparator());
		builder.append(subTotalsCA == null ? rightPadding(" ",1) :rightPadZeros(subTotalsCA,17) + padLeft(countCA,17) + padLeft(amountCA,17) + padLeft(interchangeCA,17)+ padLeft(vatCA,17) + padLeft(totalChargeCA,17)+ padLeft(netAmountCA,17));
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		
		builder.append(grandTotalsAll == null ? rightPadding(" ",1) :rightPadZeros(grandTotalsAll,17) + padLeft(countAll,17) + padLeft(amountAll,17) + padLeft(interchangeAll,17)+ padLeft(vatAll,17) + padLeft(totalChargeAll,17)+ padLeft(netAmountAll,17));
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());*/
		
		
		return builder.toString();
	}


	public static String leftJustifyWithZeros(String s, int length) {
	     if (s.length() >= length) return s;
	     else return String.format("%0" + (length-s.length()) + "d%s", 0, s);
	}
	
	public static String leftJustifyWithSpaces(String s, int length) {
	     if (s.length() >= length) return s;
	     else return String.format("%"+ (length-s.length()) +"s", s);
	}
	
	public static String doubleToStringCommaReplacer(Long l) {

	     return String.format("%.2f", l).replace(".", "");
	}
	
	public static String getTime(){
		
     Date date = new Date();
		  Format formatter = new SimpleDateFormat("HH:mm:ss");
		 String s = formatter.format(date);
		 
		 String[] splist =s.split(":");
		 
		 String hour = splist[0];
		 String minutes = splist[1];
		 String seconds = splist[2];
		 	 
		 return leftJustifyWithZeros(hour,2) + minutes + seconds;
	}
	public static boolean isEmpty(String str) {
	      return str == null || str.length() == 0;
	  }
	  /**
	 * @param str
	 * @param num
	 * @return
	 */
	public static String rightPadZeros(String str, int num) {
		    return String.format("%1$-" + num + "s", str).replace(' ', ' ');
	  }
	  /**
	 * @param str
	 * @param num
	 * @return
	 */
	public static String rightPadding(String str, int num) {
		    return String.format("%1$-" + num + "s", str);
		  }
	/**
	* @param s
	* @param n
	* @return
	*/
	public static String padLeft(String s, int n) {
			    return String.format("%1$" + n + "s", s);
		   }
	
	/**
	* @param s
	* @param n
	* @return
	*/
	public static String padLeftDoble(String s, double n) {
		    return String.format("%1$" + n + "s", s);
	   }
	 /**
	 * @param s
	 * @param n
	 * @return
	 */
	public static String padLeftString(String s, int n) {
		   return String.format("%0$"+ n +"s", s);
	  }
	 /**
	 * @param s
	 * @param n
	 * @return
	 */
	public static String paddingLeft(String s, int n) {
		   return String.format("%1$"+ n + "s", s);
	  }
	 /**
	 * @param str
	 * @return
	 */
	public static String Convert(String str) {
		   
		   BigDecimal payments = new BigDecimal(str);
		   BigDecimal payments2 = new BigDecimal("100");
		   String str1 = String.format("%.2f",payments.multiply(payments2)).replace('.','0').substring(0,6);
		   return str1 ;
	   }
	 
	 /**
	 * @param str
	 * @return
	 */
	public static String Converter(String str){
		    BigDecimal payments3 = new BigDecimal(str);
			BigDecimal payments24= new BigDecimal("100");
			payments3.toBigInteger().toString();
			String str1 = paddingLeft(String.format("%.2f",payments3.multiply(payments24)),16).replace('.',' ').substring(0, 14);
			String str3 = str1;	
			return paddingLeft(str3,17).substring(0, 16);
	 }
	 
	 /**
	 * @param str
	 * @return
	 */
	public static String Converter1(String str){
		    BigDecimal payments3 = new BigDecimal(str);
			BigDecimal payments24= new BigDecimal("100");
			payments3.toBigInteger().toString();
			String str1 = paddingLeft(String.format("%.2f",payments3.multiply(payments24)),16).replace('.',' ').substring(0, 14);
			String str3 = str1;	
			return paddingLeft(str3,17).substring(0, 16).replace(' ', '0');
	 }

	
}
