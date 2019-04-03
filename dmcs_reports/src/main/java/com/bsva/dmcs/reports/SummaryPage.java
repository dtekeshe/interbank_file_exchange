package com.bsva.dmcs.reports;

import java.math.BigDecimal;

import com.bsva.dmcs.file.reports.FromAddress;
import com.bsva.dmcs.file.reports.ToAddress;
import com.bsva.dmcs.reportv02.util.SettlementSummaryWriter;


/**
 * @author AugustineA
 *
 */
public class SummaryPage {

	// DT 22 Jan 2017 starts
	private Integer acquirerCode;
	private Integer issuerCode;

	public Integer getAcquirerCode() {
		return acquirerCode;
	}

	public void setAcquirerCode(Integer acquirerCode) {
		this.acquirerCode = acquirerCode;
	}

	public Integer getIssuerCode() {
		return issuerCode;
	}

	public void setIssuerCode(Integer issuerCode) {
		this.issuerCode = issuerCode;
	}
	// DT 22 Jan 2017 ends

	private String salesDraft;
	private String salesDraftCount;
	private String salesDraftAmount;
	private String salesDraftInterChange;
	private String salesDraftVat;
	private String salesDraftTotalCharges;
	private String salesDraftNetAmount;
	
	private String chargeBacksSd;
	private String chargeBacksSdCount;
	private String chargeBacksSdAmount;
	private String chargeBacksSdInterChange;
	private String chargeBacksSdVat;
	private String chargeBacksSdTotalCharges;
	private String chargeBacksSdNetAmount;
	
	private String reversalsSd;
	private String reversalsSdCount;
	private String reversalsSdAmount;
	private String reversalsSdInterChange;
	private String reversalsSdVat;
	private String reversalsSdTotalCharges;
	private String reversalsSdNetAmount;
	
	private String subTotalsSd;
	private String subTotalsSdCount;
	private String subTotalsSdAmount;
	private String subTotalsSdInterChange;
	private String subTotalsSdVat;
	private String subTotalsSdTotalCharges;
	private String subTotalsSdNetAmount;
	
	private String purchaseWCash;
	private String purchaseWCashCount;
	private String purchaseWCashAmount;
	private String purchaseWCashInterChange;
	private String purchaseWCashVat;
	private String purchaseWCashTotalCharges;
	private String purchaseWCashNetAmount;
	
	private String chargeBackWCash;	
	private String chargeBackWCashCount;
	private String chargeBackWCashAmount;
	private String chargeBackWCashInterChange;
	private String chargeBackWCashVat;
	private String chargeBackWCashTotalCharges;
	private String chargeBackWCashNetAmount;
	
	private String reversalWCash;
	private String reversalWCashCount;
	private String reversalWCashAmount;
	private String reversalWCashInterChange;
	private String reversalWCashVat;
	private String reversalWCashTotalCharges;
	private String reversalWCashNetAmount;
	
	private String cashBackOnPR;
	private String cashBackOnPRCount;
	private String cashBackOnPRAmount;
	private String cashBackOnPRInterChange;
	private String cashBackOnPRVat;
	private String cashBackOnPRTotalCharges;
	private String cashBackOnPRNetAmount;
	
	private String cashBackWPurc;
	private String cashBackWPurcCount;
	private String cashBackWPurcAmount;
	private String cashBackWPurcInterChange;
	private String cashBackWPurcVat;
	private String cashBackWPurcTotalCharges;
	private String cashBackWPurcNetAmount;
	
	private String reversalWpurc;
	private String reversalWpurcCount;
	private String reversalWpurcAmount;
	private String reversalWpurcInterChange;
	private String reversalWpurcVat;
	private String reversalWpurcTotalCharges;
	private String reversalWpurcNetAmount;
	
	private String subTotalsWpurc;
	private String subTotalsWpurcCount;
	private String subTotalsWpurcAmount;
	private String subTotalsWpurcInterChange;
	private String subTotalsWpurcVat;
	private String subTotalsWpurcTotalCharges;
	private String subTotalsWpurcNetAmount;
	
	private String cashBackNoP;
	private String cashBackNoPCount;
	private String cashBackNoPAmount;
	private String cashBackNoPInterChange;
	private String cashBackNoPVat;
	private String cashBackNoPTotalCharges;
	private String cashBackNoPNetAmount;
	
	private String chargeBackCas;
	private String chargeBackCasCount;
	private String chargeBackCasAmount;
	private String chargeBackCasInterChange;
	private String chargeBackCasVat;
	private String chargeBackCashTotalCharges;
	private String chargeBackCasNetAmount;
	
	private String reversalCash;
	private String reversalCashCount;
	private String reversalCashAmount;
	private String reversalCashInterChange;
	private String reversalCashVat;
	private String reversalCashTotalCharges;
	private String reversalCashNetAmount;
	
	private String subTotalsCash;
	private String subTotalsCashCount;
	private String subTotalsCashAmount;
	private String subTotalsCashInterChange;
	private String subTotalsCashVat;
	private String subTotalsCashTotalCharges;
	private String subTotalsCashNetAmount;
	
	private String petrolSales;
	private String petrolSalesCount;
	private String petrolSalesAmount;
	private String petrolSalesInterChange;
	private String petrolSalesVat;
	private String petrolSalesTotalCharges;
	private String petrolSalesNetAmount;
	
	private String chargeBacksPs;
	private String chargeBacksPsCount;
	private String chargeBacksPsAmount;
	private String chargeBacksPsInterChange;
	private String chargeBacksPsVat;
	private String chargeBacksPsTotalCharges;
	private String chargeBacksPsNetAmount;
	
	private String reversalsPs;
	private String reversalsPsCount;
	private String reversalsPsAmount;
	private String reversalsPsInterChange;
	private String reversalsPsVat;
	private String reversalsPsTotalCharges;
	private String reversalsPsNetAmount;
	
	private String subTotalsPs;
	private String subTotalsPsCount;
	private String subTotalsPsAmount;
	private String subTotalsPsInterChange;
	private String subTotalsPsVat;
	private String subTotalsPsTotalCharges;
	private String subTotalsPsNetAmount;
	
	private String creditVouchers;
	private String creditVouchersCount;
	private String creditVouchersAmount;
	private String creditVouchersInterChange;
	private String creditVouchersVat;
	private String creditVouchersTotalCharges;
	private String creditVouchersNetAmount;
	
	private String chargeBacksCv;
	private String chargeBacksCvCount;
	private String chargeBacksCvAmount;
	private String chargeBacksCvInterChange;
	private String chargeBacksCvVat;
	private String chargeBacksCvTotalCharges;
	private String chargeBacksCvNetAmount;
	
	private String reversalsCv;
	private String reversalsCvCount;
	private String reversalsCvAmount;
	private String reversalsCvInterChange;
	private String reversalsCvVat;
	private String reversalsCvTotalCharges;
	private String reversalsCvNetAmount;
	
	private String subTotalsCv;
	private String subTotalsCvCount;
	private String subTotalsCvAmount;
	private String subTotalsCvInterChange;
	private String subTotalsCvVat;
	private String subTotalsCvTotalCharges;
	private String subTotalsCvNetAmount;
	
	private String cashAdvances;
	private String cashAdvancesCount;
	private String cashAdvancesAmount;
	private String cashAdvancesInterChange;
	private String cashAdvancesVat;
	private String cashAdvancesTotalCharges;
	private String cashAdvancesNetAmount;
	
	private String chargeBacksCa;
	private String chargeBacksCaCount;
	private String chargeBacksCaAmount;
	private String chargeBacksCaInterChange;
	private String chargeBacksCaVat;
	private String chargeBacksCaTotalCharges;
	private String chargeBacksCaNetAmount;
	
	private String reversalsCa;	
	private String reversalsCaCount;
	private String reversalsCaAmount;
	private String reversalsCaInterChange;
	private String reversalsCaVat;
	private String reversalsCaTotalCharges;
	private String reversalsCaNetAmount;
	
	private String subTotalsCa;
	private String subTotalsCaCount;
	private String subTotalsCaAmount;
	private String subTotalsCaInterChange;
	private String subTotalsCaVat;
	private String subTotalsCaTotalCharges;
	private String subTotalsCaNetAmount;
	
	
	private String grandTotalsAll;
	private String grandTotalsAllCount;
	private String grandTotalsAllAmount;
	private String grandTotalsAllInterChange;
	private String grandTotalsAllVat;
	private String grandTotalsAllTotalCharges;
	private String grandTotalsAllNetAmount;
	
	private String count;
	private String amount;
	private String interchange;
	private String vat;
	private String totalCharges;
	private String netAmount;
	
	private String countValue;
	private String amountValue;
	private String interchangeValue;
	private String vatValue;
	private String totalChargesValue;
	private String netAmountValue;
	
	private FromAddress fromAddres;
	private ToAddress toAddres;
	
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

	
	
	public String getTo() {
		return to;
	}

	public String getFrom() {
		return from;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public String getUnderLine() {
		return underLine;
	}

	public String getToAddress() {
		return toAddress;
	}

	public String getToAddress2() {
		return toAddress2;
	}

	public String getToAddress3() {
		return toAddress3;
	}

	public String getToAddress4() {
		return toAddress4;
	}

	public String getToVatRegNo() {
		return toVatRegNo;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public String getFromAddress2() {
		return fromAddress2;
	}

	public String getFromAddress3() {
		return fromAddress3;
	}

	public String getFromAddress4() {
		return fromAddress4;
	}

	public String getFromVatRegNo() {
		return fromVatRegNo;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public void setUnderLine(String underLine) {
		this.underLine = underLine;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public void setToAddress2(String toAddress2) {
		this.toAddress2 = toAddress2;
	}

	public void setToAddress3(String toAddress3) {
		this.toAddress3 = toAddress3;
	}

	public void setToAddress4(String toAddress4) {
		this.toAddress4 = toAddress4;
	}

	public void setToVatRegNo(String toVatRegNo) {
		this.toVatRegNo = toVatRegNo;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public void setFromAddress2(String fromAddress2) {
		this.fromAddress2 = fromAddress2;
	}

	public void setFromAddress3(String fromAddress3) {
		this.fromAddress3 = fromAddress3;
	}

	public void setFromAddress4(String fromAddress4) {
		this.fromAddress4 = fromAddress4;
	}

	public void setFromVatRegNo(String fromVatRegNo) {
		this.fromVatRegNo = fromVatRegNo;
	}

	public FromAddress getFromAddres() {
		return fromAddres;
	}

	public ToAddress getToAddres() {
		return toAddres;
	}

	public void setFromAddres(FromAddress fromAddres) {
		this.fromAddres = fromAddres;
	}

	public void setToAddres(ToAddress toAddres) {
		this.toAddres = toAddres;
	}

	public String getCountValue() {
		return countValue;
	}

	public String getAmountValue() {
		return amountValue;
	}

	public String getInterchangeValue() {
		return interchangeValue;
	}

	public String getVatValue() {
		return vatValue;
	}

	public String getTotalChargesValue() {
		return totalChargesValue;
	}

	public String getNetAmountValue() {
		return netAmountValue;
	}

	public void setCountValue(String countValue) {
		this.countValue = countValue;
	}

	public void setAmountValue(String amountValue) {
		this.amountValue = amountValue;
	}

	public void setInterchangeValue(String interchangeValue) {
		this.interchangeValue = interchangeValue;
	}

	public void setVatValue(String vatValue) {
		this.vatValue = vatValue;
	}

	public void setTotalChargesValue(String totalChargesValue) {
		this.totalChargesValue = totalChargesValue;
	}

	public void setNetAmountValue(String netAmountValue) {
		this.netAmountValue = netAmountValue;
	}

	public String getSalesDraft() {
		return salesDraft;
	}

	public String getSalesDraftCount() {
		return salesDraftCount;
	}

	public String getSalesDraftAmount() {
		return salesDraftAmount;
	}

	public String getSalesDraftInterChange() {
		return salesDraftInterChange;
	}

	public String getSalesDraftVat() {
		return salesDraftVat;
	}

	public String getSalesDraftTotalCharges() {
		return salesDraftTotalCharges;
	}

	public String getSalesDraftNetAmount() {
		return salesDraftNetAmount;
	}

	public String getChargeBacksSd() {
		return chargeBacksSd;
	}

	public String getChargeBacksSdCount() {
		return chargeBacksSdCount;
	}

	public String getChargeBacksSdAmount() {
		return chargeBacksSdAmount;
	}

	public String getChargeBacksSdInterChange() {
		return chargeBacksSdInterChange;
	}

	public String getChargeBacksSdVat() {
		return chargeBacksSdVat;
	}

	public String getChargeBacksSdTotalCharges() {
		return chargeBacksSdTotalCharges;
	}

	public String getChargeBacksSdNetAmount() {
		return chargeBacksSdNetAmount;
	}

	public String getReversalsSd() {
		return reversalsSd;
	}

	public String getReversalsSdCount() {
		return reversalsSdCount;
	}

	public String getReversalsSdAmount() {
		return reversalsSdAmount;
	}

	public String getReversalsSdInterChange() {
		return reversalsSdInterChange;
	}

	public String getReversalsSdVat() {
		return reversalsSdVat;
	}

	public String getReversalsSdTotalCharges() {
		return reversalsSdTotalCharges;
	}

	public String getReversalsSdNetAmount() {
		return reversalsSdNetAmount;
	}

	public String getSubTotalsSd() {
		return subTotalsSd;
	}

	public String getSubTotalsSdCount() {
		return subTotalsSdCount;
	}

	public String getSubTotalsSdAmount() {
		return subTotalsSdAmount;
	}

	public String getSubTotalsSdInterChange() {
		return subTotalsSdInterChange;
	}

	public String getSubTotalsSdVat() {
		return subTotalsSdVat;
	}

	public String getSubTotalsSdTotalCharges() {
		return subTotalsSdTotalCharges;
	}

	public String getSubTotalsSdNetAmount() {
		return subTotalsSdNetAmount;
	}

	public String getPurchaseWCash() {
		return purchaseWCash;
	}

	public String getPurchaseWCashCount() {
		return purchaseWCashCount;
	}

	public String getPurchaseWCashAmount() {
		return purchaseWCashAmount;
	}

	public String getPurchaseWCashInterChange() {
		return purchaseWCashInterChange;
	}

	public String getPurchaseWCashVat() {
		return purchaseWCashVat;
	}

	public String getPurchaseWCashTotalCharges() {
		return purchaseWCashTotalCharges;
	}

	public String getPurchaseWCashNetAmount() {
		return purchaseWCashNetAmount;
	}

	public String getChargeBackWCash() {
		return chargeBackWCash;
	}

	public String getChargeBackWCashCount() {
		return chargeBackWCashCount;
	}

	public String getChargeBackWCashAmount() {
		return chargeBackWCashAmount;
	}

	public String getChargeBackWCashInterChange() {
		return chargeBackWCashInterChange;
	}

	public String getChargeBackWCashVat() {
		return chargeBackWCashVat;
	}

	public String getChargeBackWCashTotalCharges() {
		return chargeBackWCashTotalCharges;
	}

	public String getChargeBackWCashNetAmount() {
		return chargeBackWCashNetAmount;
	}

	public String getReversalWCash() {
		return reversalWCash;
	}

	public String getReversalWCashCount() {
		return reversalWCashCount;
	}

	public String getReversalWCashAmount() {
		return reversalWCashAmount;
	}

	public String getReversalWCashInterChange() {
		return reversalWCashInterChange;
	}

	public String getReversalWCashVat() {
		return reversalWCashVat;
	}

	public String getReversalWCashTotalCharges() {
		return reversalWCashTotalCharges;
	}

	public String getReversalWCashNetAmount() {
		return reversalWCashNetAmount;
	}

	public String getCashBackOnPR() {
		return cashBackOnPR;
	}

	public String getCashBackOnPRCount() {
		return cashBackOnPRCount;
	}

	public String getCashBackOnPRAmount() {
		return cashBackOnPRAmount;
	}

	public String getCashBackOnPRInterChange() {
		return cashBackOnPRInterChange;
	}

	public String getCashBackOnPRVat() {
		return cashBackOnPRVat;
	}

	public String getCashBackOnPRTotalCharges() {
		return cashBackOnPRTotalCharges;
	}

	public String getCashBackOnPRNetAmount() {
		return cashBackOnPRNetAmount;
	}

	public String getCashBackWPurc() {
		return cashBackWPurc;
	}

	public String getCashBackWPurcCount() {
		return cashBackWPurcCount;
	}

	public String getCashBackWPurcAmount() {
		return cashBackWPurcAmount;
	}

	public String getCashBackWPurcInterChange() {
		return cashBackWPurcInterChange;
	}

	public String getCashBackWPurcVat() {
		return cashBackWPurcVat;
	}

	public String getCashBackWPurcTotalCharges() {
		return cashBackWPurcTotalCharges;
	}

	public String getCashBackWPurcNetAmount() {
		return cashBackWPurcNetAmount;
	}

	public String getReversalWpurc() {
		return reversalWpurc;
	}

	public String getReversalWpurcCount() {
		return reversalWpurcCount;
	}

	public String getReversalWpurcAmount() {
		return reversalWpurcAmount;
	}

	public String getReversalWpurcInterChange() {
		return reversalWpurcInterChange;
	}

	public String getReversalWpurcVat() {
		return reversalWpurcVat;
	}

	public String getReversalWpurcTotalCharges() {
		return reversalWpurcTotalCharges;
	}

	public String getReversalWpurcNetAmount() {
		return reversalWpurcNetAmount;
	}

	public String getSubTotalsWpurc() {
		return subTotalsWpurc;
	}

	public String getSubTotalsWpurcCount() {
		return subTotalsWpurcCount;
	}

	public String getSubTotalsWpurcAmount() {
		return subTotalsWpurcAmount;
	}

	public String getSubTotalsWpurcInterChange() {
		return subTotalsWpurcInterChange;
	}

	public String getSubTotalsWpurcVat() {
		return subTotalsWpurcVat;
	}

	public String getSubTotalsWpurcTotalCharges() {
		return subTotalsWpurcTotalCharges;
	}

	public String getSubTotalsWpurcNetAmount() {
		return subTotalsWpurcNetAmount;
	}

	public String getCashBackNoP() {
		return cashBackNoP;
	}

	public String getCashBackNoPCount() {
		return cashBackNoPCount;
	}

	public String getCashBackNoPAmount() {
		return cashBackNoPAmount;
	}

	public String getCashBackNoPInterChange() {
		return cashBackNoPInterChange;
	}

	public String getCashBackNoPVat() {
		return cashBackNoPVat;
	}

	public String getCashBackNoPTotalCharges() {
		return cashBackNoPTotalCharges;
	}

	public String getCashBackNoPNetAmount() {
		return cashBackNoPNetAmount;
	}

	public String getChargeBackCas() {
		return chargeBackCas;
	}

	public String getChargeBackCasCount() {
		return chargeBackCasCount;
	}

	public String getChargeBackCasAmount() {
		return chargeBackCasAmount;
	}

	public String getChargeBackCasInterChange() {
		return chargeBackCasInterChange;
	}

	public String getChargeBackCasVat() {
		return chargeBackCasVat;
	}

	public String getChargeBackCashTotalCharges() {
		return chargeBackCashTotalCharges;
	}

	public String getChargeBackCasNetAmount() {
		return chargeBackCasNetAmount;
	}

	public String getReversalCash() {
		return reversalCash;
	}

	public String getReversalCashCount() {
		return reversalCashCount;
	}

	public String getReversalCashAmount() {
		return reversalCashAmount;
	}

	public String getReversalCashInterChange() {
		return reversalCashInterChange;
	}

	public String getReversalCashVat() {
		return reversalCashVat;
	}

	public String getReversalCashTotalCharges() {
		return reversalCashTotalCharges;
	}

	public String getReversalCashNetAmount() {
		return reversalCashNetAmount;
	}

	public String getSubTotalsCash() {
		return subTotalsCash;
	}

	public String getSubTotalsCashCount() {
		return subTotalsCashCount;
	}

	public String getSubTotalsCashAmount() {
		return subTotalsCashAmount;
	}

	public String getSubTotalsCashInterChange() {
		return subTotalsCashInterChange;
	}

	public String getSubTotalsCashVat() {
		return subTotalsCashVat;
	}

	public String getSubTotalsCashTotalCharges() {
		return subTotalsCashTotalCharges;
	}

	public String getSubTotalsCashNetAmount() {
		return subTotalsCashNetAmount;
	}

	public String getPetrolSales() {
		return petrolSales;
	}

	public String getPetrolSalesCount() {
		return petrolSalesCount;
	}

	public String getPetrolSalesAmount() {
		return petrolSalesAmount;
	}

	public String getPetrolSalesInterChange() {
		return petrolSalesInterChange;
	}

	public String getPetrolSalesVat() {
		return petrolSalesVat;
	}

	public String getPetrolSalesTotalCharges() {
		return petrolSalesTotalCharges;
	}

	public String getPetrolSalesNetAmount() {
		return petrolSalesNetAmount;
	}

	public String getChargeBacksPs() {
		return chargeBacksPs;
	}

	public String getChargeBacksPsCount() {
		return chargeBacksPsCount;
	}

	public String getChargeBacksPsAmount() {
		return chargeBacksPsAmount;
	}

	public String getChargeBacksPsInterChange() {
		return chargeBacksPsInterChange;
	}

	public String getChargeBacksPsVat() {
		return chargeBacksPsVat;
	}

	public String getChargeBacksPsTotalCharges() {
		return chargeBacksPsTotalCharges;
	}

	public String getChargeBacksPsNetAmount() {
		return chargeBacksPsNetAmount;
	}

	public String getReversalsPs() {
		return reversalsPs;
	}

	public String getReversalsPsCount() {
		return reversalsPsCount;
	}

	public String getReversalsPsAmount() {
		return reversalsPsAmount;
	}

	public String getReversalsPsInterChange() {
		return reversalsPsInterChange;
	}

	public String getReversalsPsVat() {
		return reversalsPsVat;
	}

	public String getReversalsPsTotalCharges() {
		return reversalsPsTotalCharges;
	}

	public String getReversalsPsNetAmount() {
		return reversalsPsNetAmount;
	}

	public String getSubTotalsPs() {
		return subTotalsPs;
	}

	public String getSubTotalsPsCount() {
		return subTotalsPsCount;
	}

	public String getSubTotalsPsAmount() {
		return subTotalsPsAmount;
	}

	public String getSubTotalsPsInterChange() {
		return subTotalsPsInterChange;
	}

	public String getSubTotalsPsVat() {
		return subTotalsPsVat;
	}

	public String getSubTotalsPsTotalCharges() {
		return subTotalsPsTotalCharges;
	}

	public String getSubTotalsPsNetAmount() {
		return subTotalsPsNetAmount;
	}

	public String getCreditVouchers() {
		return creditVouchers;
	}

	public String getCreditVouchersCount() {
		return creditVouchersCount;
	}

	public String getCreditVouchersAmount() {
		return creditVouchersAmount;
	}

	public String getCreditVouchersInterChange() {
		return creditVouchersInterChange;
	}

	public String getCreditVouchersVat() {
		return creditVouchersVat;
	}

	public String getCreditVouchersTotalCharges() {
		return creditVouchersTotalCharges;
	}

	public String getCreditVouchersNetAmount() {
		return creditVouchersNetAmount;
	}

	public String getChargeBacksCv() {
		return chargeBacksCv;
	}

	public String getChargeBacksCvCount() {
		return chargeBacksCvCount;
	}

	public String getChargeBacksCvAmount() {
		return chargeBacksCvAmount;
	}

	public String getChargeBacksCvInterChange() {
		return chargeBacksCvInterChange;
	}

	public String getChargeBacksCvVat() {
		return chargeBacksCvVat;
	}

	public String getChargeBacksCvTotalCharges() {
		return chargeBacksCvTotalCharges;
	}

	public String getChargeBacksCvNetAmount() {
		return chargeBacksCvNetAmount;
	}

	public String getReversalsCv() {
		return reversalsCv;
	}

	public String getReversalsCvCount() {
		return reversalsCvCount;
	}

	public String getReversalsCvAmount() {
		return reversalsCvAmount;
	}

	public String getReversalsCvInterChange() {
		return reversalsCvInterChange;
	}

	public String getReversalsCvVat() {
		return reversalsCvVat;
	}

	public String getReversalsCvTotalCharges() {
		return reversalsCvTotalCharges;
	}

	public String getReversalsCvNetAmount() {
		return reversalsCvNetAmount;
	}

	public String getSubTotalsCv() {
		return subTotalsCv;
	}

	public String getSubTotalsCvCount() {
		return subTotalsCvCount;
	}

	public String getSubTotalsCvAmount() {
		return subTotalsCvAmount;
	}

	public String getSubTotalsCvInterChange() {
		return subTotalsCvInterChange;
	}

	public String getSubTotalsCvVat() {
		return subTotalsCvVat;
	}

	public String getSubTotalsCvTotalCharges() {
		return subTotalsCvTotalCharges;
	}

	public String getSubTotalsCvNetAmount() {
		return subTotalsCvNetAmount;
	}

	public String getCashAdvances() {
		return cashAdvances;
	}

	public String getCashAdvancesCount() {
		return cashAdvancesCount;
	}

	public String getCashAdvancesAmount() {
		return cashAdvancesAmount;
	}

	public String getCashAdvancesInterChange() {
		return cashAdvancesInterChange;
	}

	public String getCashAdvancesVat() {
		return cashAdvancesVat;
	}

	public String getCashAdvancesTotalCharges() {
		return cashAdvancesTotalCharges;
	}

	public String getCashAdvancesNetAmount() {
		return cashAdvancesNetAmount;
	}

	public String getChargeBacksCa() {
		return chargeBacksCa;
	}

	public String getChargeBacksCaCount() {
		return chargeBacksCaCount;
	}

	public String getChargeBacksCaAmount() {
		return chargeBacksCaAmount;
	}

	public String getChargeBacksCaInterChange() {
		return chargeBacksCaInterChange;
	}

	public String getChargeBacksCaVat() {
		return chargeBacksCaVat;
	}

	public String getChargeBacksCaTotalCharges() {
		return chargeBacksCaTotalCharges;
	}

	public String getChargeBacksCaNetAmount() {
		return chargeBacksCaNetAmount;
	}

	public String getReversalsCa() {
		return reversalsCa;
	}

	public String getReversalsCaCount() {
		return reversalsCaCount;
	}

	public String getReversalsCaAmount() {
		return reversalsCaAmount;
	}

	public String getReversalsCaInterChange() {
		return reversalsCaInterChange;
	}

	public String getReversalsCaVat() {
		return reversalsCaVat;
	}

	public String getReversalsCaTotalCharges() {
		return reversalsCaTotalCharges;
	}

	public String getReversalsCaNetAmount() {
		return reversalsCaNetAmount;
	}

	public String getSubTotalsCa() {
		return subTotalsCa;
	}

	public String getSubTotalsCaCount() {
		return subTotalsCaCount;
	}

	public String getSubTotalsCaAmount() {
		return subTotalsCaAmount;
	}

	public String getSubTotalsCaInterChange() {
		return subTotalsCaInterChange;
	}

	public String getSubTotalsCaVat() {
		return subTotalsCaVat;
	}

	public String getSubTotalsCaTotalCharges() {
		return subTotalsCaTotalCharges;
	}

	public String getSubTotalsCaNetAmount() {
		return subTotalsCaNetAmount;
	}

	public String getGrandTotalsAll() {
		return grandTotalsAll;
	}

	public String getGrandTotalsAllCount() {
		return grandTotalsAllCount;
	}

	public String getGrandTotalsAllAmount() {
		return grandTotalsAllAmount;
	}

	public String getGrandTotalsAllInterChange() {
		return grandTotalsAllInterChange;
	}

	public String getGrandTotalsAllVat() {
		return grandTotalsAllVat;
	}

	public String getGrandTotalsAllTotalCharges() {
		return grandTotalsAllTotalCharges;
	}

	public String getGrandTotalsAllNetAmount() {
		return grandTotalsAllNetAmount;
	}

	public String getCount() {
		return count;
	}

	public String getAmount() {
		return amount;
	}

	public String getInterchange() {
		return interchange;
	}

	public String getVat() {
		return vat;
	}

	public String getTotalCharges() {
		return totalCharges;
	}

	public String getNetAmount() {
		return netAmount;
	}

	public void setSalesDraft(String salesDraft) {
		this.salesDraft = salesDraft;
	}

	public void setSalesDraftCount(String salesDraftCount) {
		this.salesDraftCount = salesDraftCount;
	}

	public void setSalesDraftAmount(String salesDraftAmount) {
		this.salesDraftAmount = salesDraftAmount;
	}

	public void setSalesDraftInterChange(String salesDraftInterChange) {
		this.salesDraftInterChange = salesDraftInterChange;
	}

	public void setSalesDraftVat(String salesDraftVat) {
		this.salesDraftVat = salesDraftVat;
	}

	public void setSalesDraftTotalCharges(String salesDraftTotalCharges) {
		this.salesDraftTotalCharges = salesDraftTotalCharges;
	}

	public void setSalesDraftNetAmount(String salesDraftNetAmount) {
		this.salesDraftNetAmount = salesDraftNetAmount;
	}

	public void setChargeBacksSd(String chargeBacksSd) {
		this.chargeBacksSd = chargeBacksSd;
	}

	public void setChargeBacksSdCount(String chargeBacksSdCount) {
		this.chargeBacksSdCount = chargeBacksSdCount;
	}

	public void setChargeBacksSdAmount(String chargeBacksSdAmount) {
		this.chargeBacksSdAmount = chargeBacksSdAmount;
	}

	public void setChargeBacksSdInterChange(String chargeBacksSdInterChange) {
		this.chargeBacksSdInterChange = chargeBacksSdInterChange;
	}

	public void setChargeBacksSdVat(String chargeBacksSdVat) {
		this.chargeBacksSdVat = chargeBacksSdVat;
	}

	public void setChargeBacksSdTotalCharges(String chargeBacksSdTotalCharges) {
		this.chargeBacksSdTotalCharges = chargeBacksSdTotalCharges;
	}

	public void setChargeBacksSdNetAmount(String chargeBacksSdNetAmount) {
		this.chargeBacksSdNetAmount = chargeBacksSdNetAmount;
	}

	public void setReversalsSd(String reversalsSd) {
		this.reversalsSd = reversalsSd;
	}

	public void setReversalsSdCount(String reversalsSdCount) {
		this.reversalsSdCount = reversalsSdCount;
	}

	public void setReversalsSdAmount(String reversalsSdAmount) {
		this.reversalsSdAmount = reversalsSdAmount;
	}

	public void setReversalsSdInterChange(String reversalsSdInterChange) {
		this.reversalsSdInterChange = reversalsSdInterChange;
	}

	public void setReversalsSdVat(String reversalsSdVat) {
		this.reversalsSdVat = reversalsSdVat;
	}

	public void setReversalsSdTotalCharges(String reversalsSdTotalCharges) {
		this.reversalsSdTotalCharges = reversalsSdTotalCharges;
	}

	public void setReversalsSdNetAmount(String reversalsSdNetAmount) {
		this.reversalsSdNetAmount = reversalsSdNetAmount;
	}

	public void setSubTotalsSd(String subTotalsSd) {
		this.subTotalsSd = subTotalsSd;
	}

	public void setSubTotalsSdCount(String subTotalsSdCount) {
		this.subTotalsSdCount = subTotalsSdCount;
	}

	public void setSubTotalsSdAmount(String subTotalsSdAmount) {
		this.subTotalsSdAmount = subTotalsSdAmount;
	}

	public void setSubTotalsSdInterChange(String subTotalsSdInterChange) {
		this.subTotalsSdInterChange = subTotalsSdInterChange;
	}

	public void setSubTotalsSdVat(String subTotalsSdVat) {
		this.subTotalsSdVat = subTotalsSdVat;
	}

	public void setSubTotalsSdTotalCharges(String subTotalsSdTotalCharges) {
		this.subTotalsSdTotalCharges = subTotalsSdTotalCharges;
	}

	public void setSubTotalsSdNetAmount(String subTotalsSdNetAmount) {
		this.subTotalsSdNetAmount = subTotalsSdNetAmount;
	}

	public void setPurchaseWCash(String purchaseWCash) {
		this.purchaseWCash = purchaseWCash;
	}

	public void setPurchaseWCashCount(String purchaseWCashCount) {
		this.purchaseWCashCount = purchaseWCashCount;
	}

	public void setPurchaseWCashAmount(String purchaseWCashAmount) {
		this.purchaseWCashAmount = purchaseWCashAmount;
	}

	public void setPurchaseWCashInterChange(String purchaseWCashInterChange) {
		this.purchaseWCashInterChange = purchaseWCashInterChange;
	}

	public void setPurchaseWCashVat(String purchaseWCashVat) {
		this.purchaseWCashVat = purchaseWCashVat;
	}

	public void setPurchaseWCashTotalCharges(String purchaseWCashTotalCharges) {
		this.purchaseWCashTotalCharges = purchaseWCashTotalCharges;
	}

	public void setPurchaseWCashNetAmount(String purchaseWCashNetAmount) {
		this.purchaseWCashNetAmount = purchaseWCashNetAmount;
	}

	public void setChargeBackWCash(String chargeBackWCash) {
		this.chargeBackWCash = chargeBackWCash;
	}

	public void setChargeBackWCashCount(String chargeBackWCashCount) {
		this.chargeBackWCashCount = chargeBackWCashCount;
	}

	public void setChargeBackWCashAmount(String chargeBackWCashAmount) {
		this.chargeBackWCashAmount = chargeBackWCashAmount;
	}

	public void setChargeBackWCashInterChange(String chargeBackWCashInterChange) {
		this.chargeBackWCashInterChange = chargeBackWCashInterChange;
	}

	public void setChargeBackWCashVat(String chargeBackWCashVat) {
		this.chargeBackWCashVat = chargeBackWCashVat;
	}

	public void setChargeBackWCashTotalCharges(String chargeBackWCashTotalCharges) {
		this.chargeBackWCashTotalCharges = chargeBackWCashTotalCharges;
	}

	public void setChargeBackWCashNetAmount(String chargeBackWCashNetAmount) {
		this.chargeBackWCashNetAmount = chargeBackWCashNetAmount;
	}

	public void setReversalWCash(String reversalWCash) {
		this.reversalWCash = reversalWCash;
	}

	public void setReversalWCashCount(String reversalWCashCount) {
		this.reversalWCashCount = reversalWCashCount;
	}

	public void setReversalWCashAmount(String reversalWCashAmount) {
		this.reversalWCashAmount = reversalWCashAmount;
	}

	public void setReversalWCashInterChange(String reversalWCashInterChange) {
		this.reversalWCashInterChange = reversalWCashInterChange;
	}

	public void setReversalWCashVat(String reversalWCashVat) {
		this.reversalWCashVat = reversalWCashVat;
	}

	public void setReversalWCashTotalCharges(String reversalWCashTotalCharges) {
		this.reversalWCashTotalCharges = reversalWCashTotalCharges;
	}

	public void setReversalWCashNetAmount(String reversalWCashNetAmount) {
		this.reversalWCashNetAmount = reversalWCashNetAmount;
	}

	public void setCashBackOnPR(String cashBackOnPR) {
		this.cashBackOnPR = cashBackOnPR;
	}

	public void setCashBackOnPRCount(String cashBackOnPRCount) {
		this.cashBackOnPRCount = cashBackOnPRCount;
	}

	public void setCashBackOnPRAmount(String cashBackOnPRAmount) {
		this.cashBackOnPRAmount = cashBackOnPRAmount;
	}

	public void setCashBackOnPRInterChange(String cashBackOnPRInterChange) {
		this.cashBackOnPRInterChange = cashBackOnPRInterChange;
	}

	public void setCashBackOnPRVat(String cashBackOnPRVat) {
		this.cashBackOnPRVat = cashBackOnPRVat;
	}

	public void setCashBackOnPRTotalCharges(String cashBackOnPRTotalCharges) {
		this.cashBackOnPRTotalCharges = cashBackOnPRTotalCharges;
	}

	public void setCashBackOnPRNetAmount(String cashBackOnPRNetAmount) {
		this.cashBackOnPRNetAmount = cashBackOnPRNetAmount;
	}

	public void setCashBackWPurc(String cashBackWPurc) {
		this.cashBackWPurc = cashBackWPurc;
	}

	public void setCashBackWPurcCount(String cashBackWPurcCount) {
		this.cashBackWPurcCount = cashBackWPurcCount;
	}

	public void setCashBackWPurcAmount(String cashBackWPurcAmount) {
		this.cashBackWPurcAmount = cashBackWPurcAmount;
	}

	public void setCashBackWPurcInterChange(String cashBackWPurcInterChange) {
		this.cashBackWPurcInterChange = cashBackWPurcInterChange;
	}

	public void setCashBackWPurcVat(String cashBackWPurcVat) {
		this.cashBackWPurcVat = cashBackWPurcVat;
	}

	public void setCashBackWPurcTotalCharges(String cashBackWPurcTotalCharges) {
		this.cashBackWPurcTotalCharges = cashBackWPurcTotalCharges;
	}

	public void setCashBackWPurcNetAmount(String cashBackWPurcNetAmount) {
		this.cashBackWPurcNetAmount = cashBackWPurcNetAmount;
	}

	public void setReversalWpurc(String reversalWpurc) {
		this.reversalWpurc = reversalWpurc;
	}

	public void setReversalWpurcCount(String reversalWpurcCount) {
		this.reversalWpurcCount = reversalWpurcCount;
	}

	public void setReversalWpurcAmount(String reversalWpurcAmount) {
		this.reversalWpurcAmount = reversalWpurcAmount;
	}

	public void setReversalWpurcInterChange(String reversalWpurcInterChange) {
		this.reversalWpurcInterChange = reversalWpurcInterChange;
	}

	public void setReversalWpurcVat(String reversalWpurcVat) {
		this.reversalWpurcVat = reversalWpurcVat;
	}

	public void setReversalWpurcTotalCharges(String reversalWpurcTotalCharges) {
		this.reversalWpurcTotalCharges = reversalWpurcTotalCharges;
	}

	public void setReversalWpurcNetAmount(String reversalWpurcNetAmount) {
		this.reversalWpurcNetAmount = reversalWpurcNetAmount;
	}

	public void setSubTotalsWpurc(String subTotalsWpurc) {
		this.subTotalsWpurc = subTotalsWpurc;
	}

	public void setSubTotalsWpurcCount(String subTotalsWpurcCount) {
		this.subTotalsWpurcCount = subTotalsWpurcCount;
	}

	public void setSubTotalsWpurcAmount(String subTotalsWpurcAmount) {
		this.subTotalsWpurcAmount = subTotalsWpurcAmount;
	}

	public void setSubTotalsWpurcInterChange(String subTotalsWpurcInterChange) {
		this.subTotalsWpurcInterChange = subTotalsWpurcInterChange;
	}

	public void setSubTotalsWpurcVat(String subTotalsWpurcVat) {
		this.subTotalsWpurcVat = subTotalsWpurcVat;
	}

	public void setSubTotalsWpurcTotalCharges(String subTotalsWpurcTotalCharges) {
		this.subTotalsWpurcTotalCharges = subTotalsWpurcTotalCharges;
	}

	public void setSubTotalsWpurcNetAmount(String subTotalsWpurcNetAmount) {
		this.subTotalsWpurcNetAmount = subTotalsWpurcNetAmount;
	}

	public void setCashBackNoP(String cashBackNoP) {
		this.cashBackNoP = cashBackNoP;
	}

	public void setCashBackNoPCount(String cashBackNoPCount) {
		this.cashBackNoPCount = cashBackNoPCount;
	}

	public void setCashBackNoPAmount(String cashBackNoPAmount) {
		this.cashBackNoPAmount = cashBackNoPAmount;
	}

	public void setCashBackNoPInterChange(String cashBackNoPInterChange) {
		this.cashBackNoPInterChange = cashBackNoPInterChange;
	}

	public void setCashBackNoPVat(String cashBackNoPVat) {
		this.cashBackNoPVat = cashBackNoPVat;
	}

	public void setCashBackNoPTotalCharges(String cashBackNoPTotalCharges) {
		this.cashBackNoPTotalCharges = cashBackNoPTotalCharges;
	}

	public void setCashBackNoPNetAmount(String cashBackNoPNetAmount) {
		this.cashBackNoPNetAmount = cashBackNoPNetAmount;
	}

	public void setChargeBackCas(String chargeBackCas) {
		this.chargeBackCas = chargeBackCas;
	}

	public void setChargeBackCasCount(String chargeBackCasCount) {
		this.chargeBackCasCount = chargeBackCasCount;
	}

	public void setChargeBackCasAmount(String chargeBackCasAmount) {
		this.chargeBackCasAmount = chargeBackCasAmount;
	}

	public void setChargeBackCasInterChange(String chargeBackCasInterChange) {
		this.chargeBackCasInterChange = chargeBackCasInterChange;
	}

	public void setChargeBackCasVat(String chargeBackCasVat) {
		this.chargeBackCasVat = chargeBackCasVat;
	}

	public void setChargeBackCashTotalCharges(String chargeBackCashTotalCharges) {
		this.chargeBackCashTotalCharges = chargeBackCashTotalCharges;
	}

	public void setChargeBackCasNetAmount(String chargeBackCasNetAmount) {
		this.chargeBackCasNetAmount = chargeBackCasNetAmount;
	}

	public void setReversalCash(String reversalCash) {
		this.reversalCash = reversalCash;
	}

	public void setReversalCashCount(String reversalCashCount) {
		this.reversalCashCount = reversalCashCount;
	}

	public void setReversalCashAmount(String reversalCashAmount) {
		this.reversalCashAmount = reversalCashAmount;
	}

	public void setReversalCashInterChange(String reversalCashInterChange) {
		this.reversalCashInterChange = reversalCashInterChange;
	}

	public void setReversalCashVat(String reversalCashVat) {
		this.reversalCashVat = reversalCashVat;
	}

	public void setReversalCashTotalCharges(String reversalCashTotalCharges) {
		this.reversalCashTotalCharges = reversalCashTotalCharges;
	}

	public void setReversalCashNetAmount(String reversalCashNetAmount) {
		this.reversalCashNetAmount = reversalCashNetAmount;
	}

	public void setSubTotalsCash(String subTotalsCash) {
		this.subTotalsCash = subTotalsCash;
	}

	public void setSubTotalsCashCount(String subTotalsCashCount) {
		this.subTotalsCashCount = subTotalsCashCount;
	}

	public void setSubTotalsCashAmount(String subTotalsCashAmount) {
		this.subTotalsCashAmount = subTotalsCashAmount;
	}

	public void setSubTotalsCashInterChange(String subTotalsCashInterChange) {
		this.subTotalsCashInterChange = subTotalsCashInterChange;
	}

	public void setSubTotalsCashVat(String subTotalsCashVat) {
		this.subTotalsCashVat = subTotalsCashVat;
	}

	public void setSubTotalsCashTotalCharges(String subTotalsCashTotalCharges) {
		this.subTotalsCashTotalCharges = subTotalsCashTotalCharges;
	}

	public void setSubTotalsCashNetAmount(String subTotalsCashNetAmount) {
		this.subTotalsCashNetAmount = subTotalsCashNetAmount;
	}

	public void setPetrolSales(String petrolSales) {
		this.petrolSales = petrolSales;
	}

	public void setPetrolSalesCount(String petrolSalesCount) {
		this.petrolSalesCount = petrolSalesCount;
	}

	public void setPetrolSalesAmount(String petrolSalesAmount) {
		this.petrolSalesAmount = petrolSalesAmount;
	}

	public void setPetrolSalesInterChange(String petrolSalesInterChange) {
		this.petrolSalesInterChange = petrolSalesInterChange;
	}

	public void setPetrolSalesVat(String petrolSalesVat) {
		this.petrolSalesVat = petrolSalesVat;
	}

	public void setPetrolSalesTotalCharges(String petrolSalesTotalCharges) {
		this.petrolSalesTotalCharges = petrolSalesTotalCharges;
	}

	public void setPetrolSalesNetAmount(String petrolSalesNetAmount) {
		this.petrolSalesNetAmount = petrolSalesNetAmount;
	}

	public void setChargeBacksPs(String chargeBacksPs) {
		this.chargeBacksPs = chargeBacksPs;
	}

	public void setChargeBacksPsCount(String chargeBacksPsCount) {
		this.chargeBacksPsCount = chargeBacksPsCount;
	}

	public void setChargeBacksPsAmount(String chargeBacksPsAmount) {
		this.chargeBacksPsAmount = chargeBacksPsAmount;
	}

	public void setChargeBacksPsInterChange(String chargeBacksPsInterChange) {
		this.chargeBacksPsInterChange = chargeBacksPsInterChange;
	}

	public void setChargeBacksPsVat(String chargeBacksPsVat) {
		this.chargeBacksPsVat = chargeBacksPsVat;
	}

	public void setChargeBacksPsTotalCharges(String chargeBacksPsTotalCharges) {
		this.chargeBacksPsTotalCharges = chargeBacksPsTotalCharges;
	}

	public void setChargeBacksPsNetAmount(String chargeBacksPsNetAmount) {
		this.chargeBacksPsNetAmount = chargeBacksPsNetAmount;
	}

	public void setReversalsPs(String reversalsPs) {
		this.reversalsPs = reversalsPs;
	}

	public void setReversalsPsCount(String reversalsPsCount) {
		this.reversalsPsCount = reversalsPsCount;
	}

	public void setReversalsPsAmount(String reversalsPsAmount) {
		this.reversalsPsAmount = reversalsPsAmount;
	}

	public void setReversalsPsInterChange(String reversalsPsInterChange) {
		this.reversalsPsInterChange = reversalsPsInterChange;
	}

	public void setReversalsPsVat(String reversalsPsVat) {
		this.reversalsPsVat = reversalsPsVat;
	}

	public void setReversalsPsTotalCharges(String reversalsPsTotalCharges) {
		this.reversalsPsTotalCharges = reversalsPsTotalCharges;
	}

	public void setReversalsPsNetAmount(String reversalsPsNetAmount) {
		this.reversalsPsNetAmount = reversalsPsNetAmount;
	}

	public void setSubTotalsPs(String subTotalsPs) {
		this.subTotalsPs = subTotalsPs;
	}

	public void setSubTotalsPsCount(String subTotalsPsCount) {
		this.subTotalsPsCount = subTotalsPsCount;
	}

	public void setSubTotalsPsAmount(String subTotalsPsAmount) {
		this.subTotalsPsAmount = subTotalsPsAmount;
	}

	public void setSubTotalsPsInterChange(String subTotalsPsInterChange) {
		this.subTotalsPsInterChange = subTotalsPsInterChange;
	}

	public void setSubTotalsPsVat(String subTotalsPsVat) {
		this.subTotalsPsVat = subTotalsPsVat;
	}

	public void setSubTotalsPsTotalCharges(String subTotalsPsTotalCharges) {
		this.subTotalsPsTotalCharges = subTotalsPsTotalCharges;
	}

	public void setSubTotalsPsNetAmount(String subTotalsPsNetAmount) {
		this.subTotalsPsNetAmount = subTotalsPsNetAmount;
	}

	public void setCreditVouchers(String creditVouchers) {
		this.creditVouchers = creditVouchers;
	}

	public void setCreditVouchersCount(String creditVouchersCount) {
		this.creditVouchersCount = creditVouchersCount;
	}

	public void setCreditVouchersAmount(String creditVouchersAmount) {
		this.creditVouchersAmount = creditVouchersAmount;
	}

	public void setCreditVouchersInterChange(String creditVouchersInterChange) {
		this.creditVouchersInterChange = creditVouchersInterChange;
	}

	public void setCreditVouchersVat(String creditVouchersVat) {
		this.creditVouchersVat = creditVouchersVat;
	}

	public void setCreditVouchersTotalCharges(String creditVouchersTotalCharges) {
		this.creditVouchersTotalCharges = creditVouchersTotalCharges;
	}

	public void setCreditVouchersNetAmount(String creditVouchersNetAmount) {
		this.creditVouchersNetAmount = creditVouchersNetAmount;
	}

	public void setChargeBacksCv(String chargeBacksCv) {
		this.chargeBacksCv = chargeBacksCv;
	}

	public void setChargeBacksCvCount(String chargeBacksCvCount) {
		this.chargeBacksCvCount = chargeBacksCvCount;
	}

	public void setChargeBacksCvAmount(String chargeBacksCvAmount) {
		this.chargeBacksCvAmount = chargeBacksCvAmount;
	}

	public void setChargeBacksCvInterChange(String chargeBacksCvInterChange) {
		this.chargeBacksCvInterChange = chargeBacksCvInterChange;
	}

	public void setChargeBacksCvVat(String chargeBacksCvVat) {
		this.chargeBacksCvVat = chargeBacksCvVat;
	}

	public void setChargeBacksCvTotalCharges(String chargeBacksCvTotalCharges) {
		this.chargeBacksCvTotalCharges = chargeBacksCvTotalCharges;
	}

	public void setChargeBacksCvNetAmount(String chargeBacksCvNetAmount) {
		this.chargeBacksCvNetAmount = chargeBacksCvNetAmount;
	}

	public void setReversalsCv(String reversalsCv) {
		this.reversalsCv = reversalsCv;
	}

	public void setReversalsCvCount(String reversalsCvCount) {
		this.reversalsCvCount = reversalsCvCount;
	}

	public void setReversalsCvAmount(String reversalsCvAmount) {
		this.reversalsCvAmount = reversalsCvAmount;
	}

	public void setReversalsCvInterChange(String reversalsCvInterChange) {
		this.reversalsCvInterChange = reversalsCvInterChange;
	}

	public void setReversalsCvVat(String reversalsCvVat) {
		this.reversalsCvVat = reversalsCvVat;
	}

	public void setReversalsCvTotalCharges(String reversalsCvTotalCharges) {
		this.reversalsCvTotalCharges = reversalsCvTotalCharges;
	}

	public void setReversalsCvNetAmount(String reversalsCvNetAmount) {
		this.reversalsCvNetAmount = reversalsCvNetAmount;
	}

	public void setSubTotalsCv(String subTotalsCv) {
		this.subTotalsCv = subTotalsCv;
	}

	public void setSubTotalsCvCount(String subTotalsCvCount) {
		this.subTotalsCvCount = subTotalsCvCount;
	}

	public void setSubTotalsCvAmount(String subTotalsCvAmount) {
		this.subTotalsCvAmount = subTotalsCvAmount;
	}

	public void setSubTotalsCvInterChange(String subTotalsCvInterChange) {
		this.subTotalsCvInterChange = subTotalsCvInterChange;
	}

	public void setSubTotalsCvVat(String subTotalsCvVat) {
		this.subTotalsCvVat = subTotalsCvVat;
	}

	public void setSubTotalsCvTotalCharges(String subTotalsCvTotalCharges) {
		this.subTotalsCvTotalCharges = subTotalsCvTotalCharges;
	}

	public void setSubTotalsCvNetAmount(String subTotalsCvNetAmount) {
		this.subTotalsCvNetAmount = subTotalsCvNetAmount;
	}

	public void setCashAdvances(String cashAdvances) {
		this.cashAdvances = cashAdvances;
	}

	public void setCashAdvancesCount(String cashAdvancesCount) {
		this.cashAdvancesCount = cashAdvancesCount;
	}

	public void setCashAdvancesAmount(String cashAdvancesAmount) {
		this.cashAdvancesAmount = cashAdvancesAmount;
	}

	public void setCashAdvancesInterChange(String cashAdvancesInterChange) {
		this.cashAdvancesInterChange = cashAdvancesInterChange;
	}

	public void setCashAdvancesVat(String cashAdvancesVat) {
		this.cashAdvancesVat = cashAdvancesVat;
	}

	public void setCashAdvancesTotalCharges(String cashAdvancesTotalCharges) {
		this.cashAdvancesTotalCharges = cashAdvancesTotalCharges;
	}

	public void setCashAdvancesNetAmount(String cashAdvancesNetAmount) {
		this.cashAdvancesNetAmount = cashAdvancesNetAmount;
	}

	public void setChargeBacksCa(String chargeBacksCa) {
		this.chargeBacksCa = chargeBacksCa;
	}

	public void setChargeBacksCaCount(String chargeBacksCaCount) {
		this.chargeBacksCaCount = chargeBacksCaCount;
	}

	public void setChargeBacksCaAmount(String chargeBacksCaAmount) {
		this.chargeBacksCaAmount = chargeBacksCaAmount;
	}

	public void setChargeBacksCaInterChange(String chargeBacksCaInterChange) {
		this.chargeBacksCaInterChange = chargeBacksCaInterChange;
	}

	public void setChargeBacksCaVat(String chargeBacksCaVat) {
		this.chargeBacksCaVat = chargeBacksCaVat;
	}

	public void setChargeBacksCaTotalCharges(String chargeBacksCaTotalCharges) {
		this.chargeBacksCaTotalCharges = chargeBacksCaTotalCharges;
	}

	public void setChargeBacksCaNetAmount(String chargeBacksCaNetAmount) {
		this.chargeBacksCaNetAmount = chargeBacksCaNetAmount;
	}

	public void setReversalsCa(String reversalsCa) {
		this.reversalsCa = reversalsCa;
	}

	public void setReversalsCaCount(String reversalsCaCount) {
		this.reversalsCaCount = reversalsCaCount;
	}

	public void setReversalsCaAmount(String reversalsCaAmount) {
		this.reversalsCaAmount = reversalsCaAmount;
	}

	public void setReversalsCaInterChange(String reversalsCaInterChange) {
		this.reversalsCaInterChange = reversalsCaInterChange;
	}

	public void setReversalsCaVat(String reversalsCaVat) {
		this.reversalsCaVat = reversalsCaVat;
	}

	public void setReversalsCaTotalCharges(String reversalsCaTotalCharges) {
		this.reversalsCaTotalCharges = reversalsCaTotalCharges;
	}

	public void setReversalsCaNetAmount(String reversalsCaNetAmount) {
		this.reversalsCaNetAmount = reversalsCaNetAmount;
	}

	public void setSubTotalsCa(String subTotalsCa) {
		this.subTotalsCa = subTotalsCa;
	}

	public void setSubTotalsCaCount(String subTotalsCaCount) {
		this.subTotalsCaCount = subTotalsCaCount;
	}

	public void setSubTotalsCaAmount(String subTotalsCaAmount) {
		this.subTotalsCaAmount = subTotalsCaAmount;
	}

	public void setSubTotalsCaInterChange(String subTotalsCaInterChange) {
		this.subTotalsCaInterChange = subTotalsCaInterChange;
	}

	public void setSubTotalsCaVat(String subTotalsCaVat) {
		this.subTotalsCaVat = subTotalsCaVat;
	}

	public void setSubTotalsCaTotalCharges(String subTotalsCaTotalCharges) {
		this.subTotalsCaTotalCharges = subTotalsCaTotalCharges;
	}

	public void setSubTotalsCaNetAmount(String subTotalsCaNetAmount) {
		this.subTotalsCaNetAmount = subTotalsCaNetAmount;
	}

	public void setGrandTotalsAll(String grandTotalsAll) {
		this.grandTotalsAll = grandTotalsAll;
	}

	public void setGrandTotalsAllCount(String grandTotalsAllCount) {
		this.grandTotalsAllCount = grandTotalsAllCount;
	}

	public void setGrandTotalsAllAmount(String grandTotalsAllAmount) {
		this.grandTotalsAllAmount = grandTotalsAllAmount;
	}

	public void setGrandTotalsAllInterChange(String grandTotalsAllInterChange) {
		this.grandTotalsAllInterChange = grandTotalsAllInterChange;
	}

	public void setGrandTotalsAllVat(String grandTotalsAllVat) {
		this.grandTotalsAllVat = grandTotalsAllVat;
	}

	public void setGrandTotalsAllTotalCharges(String grandTotalsAllTotalCharges) {
		this.grandTotalsAllTotalCharges = grandTotalsAllTotalCharges;
	}

	public void setGrandTotalsAllNetAmount(String grandTotalsAllNetAmount) {
		this.grandTotalsAllNetAmount = grandTotalsAllNetAmount;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public void setInterchange(String interchange) {
		this.interchange = interchange;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public void setTotalCharges(String totalCharges) {
		this.totalCharges = totalCharges;
	}

	public void setNetAmount(String netAmount) {
		this.netAmount = netAmount;
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
		builder.append(count == null ? rightPadding(" ",1) :rightPadding("",45) + rightPadding(count,3) + padLeft(amount,16) + padLeft(interchange,16) + padLeft(vat,15) + padLeft(totalCharges,22) + padLeft(netAmount,17));
		builder.append(System.lineSeparator());
		}

		/*if(countValue != null){
		builder.append(countValue == null ? rightPadding(" ",1) :rightPadding(salesDraft,25) +padLeft(countValue,25) + padLeft(amountValue,16) + padLeft(interchangeValue,16) + padLeft(vatValue,15) + padLeft(totalChargesValue,22) + padLeft(netAmountValue,17));
		builder.append(System.lineSeparator());
		}*/

		/*
		 * Structural changes by David Tekeshe, 22 January 2017
		 */
		SettlementSummaryWriter.write(builder, acquirerCode, issuerCode);
		/*
		if(salesDraft != null){
		builder.append(salesDraft == null ? rightPadding(" ",1) :rightPadding(salesDraft,25) + padLeft(salesDraftCount,25) + padLeft(salesDraftAmount,16) + padLeft(salesDraftInterChange,16) + padLeft(salesDraftVat,15) + padLeft(salesDraftTotalCharges,22) + padLeft(salesDraftNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(chargeBacksSd != null){
		builder.append(chargeBacksSd == null ? rightPadding(" ",1) :rightPadding(chargeBacksSd,25) + padLeft(chargeBacksSdCount,25) + padLeft(chargeBacksSdAmount,16) + padLeft(chargeBacksSdInterChange,16) + padLeft(chargeBacksSdVat,15) + padLeft(chargeBacksSdTotalCharges,22) + padLeft(chargeBacksSdNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(reversalsSd != null){
		builder.append(reversalsSd == null ? rightPadding(" ",1) :rightPadding(reversalsSd,25) + padLeft(reversalsSdCount,25) + padLeft(reversalsSdAmount,16) + padLeft(reversalsSdInterChange,16) + padLeft(reversalsSdVat,15) + padLeft(reversalsSdTotalCharges,22) + padLeft(reversalsSdNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(subTotalsSd != null){
		builder.append(subTotalsSd == null ? rightPadding(" ",1) :rightPadding(subTotalsSd,25) + padLeft(subTotalsSdCount,25) + padLeft(subTotalsSdAmount,16) + padLeft(subTotalsSdInterChange,16) + padLeft(subTotalsSdVat,15) + padLeft(subTotalsSdTotalCharges,22) + padLeft(subTotalsSdNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(purchaseWCash != null){
		builder.append(purchaseWCash == null ? rightPadding(" ",1) :rightPadding(purchaseWCash,25) + padLeft(purchaseWCashCount,25) + padLeft(purchaseWCashAmount,16) + padLeft(purchaseWCashInterChange,16) + padLeft(purchaseWCashVat,15) + padLeft(purchaseWCashTotalCharges,22) + padLeft(purchaseWCashNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(chargeBackWCash != null){
		builder.append(chargeBackWCash == null ? rightPadding(" ",1) :rightPadding(chargeBackWCash,25) + padLeft(chargeBackWCashCount,25) + padLeft(chargeBackWCashAmount,16) + padLeft(chargeBackWCashInterChange,16) + padLeft(chargeBackWCashVat,15) + padLeft(chargeBackWCashTotalCharges,22) + padLeft(chargeBackWCashNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(reversalWCash != null){
		builder.append(reversalWCash == null ? rightPadding(" ",1) :rightPadding(reversalWCash,25) + padLeft(reversalWCashCount,25) + padLeft(reversalWCashAmount,16) + padLeft(reversalWCashInterChange,16) + padLeft(reversalWCashVat,15) + padLeft(reversalWCashTotalCharges,22) + padLeft(reversalWCashNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(cashBackOnPR != null){
		builder.append(cashBackOnPR == null ? rightPadding(" ",1) :rightPadding(cashBackOnPR,25) + padLeft(cashBackOnPRCount,25) + padLeft(cashBackOnPRAmount,16) + padLeft(cashBackOnPRInterChange,16) + padLeft(cashBackOnPRVat,15) + padLeft(cashBackOnPRTotalCharges,22) + padLeft(cashBackOnPRNetAmount,17));
		}
		builder.append(System.lineSeparator());
		if(cashBackWPurc != null){
		builder.append(cashBackWPurc == null ? rightPadding(" ",1) :rightPadding(cashBackWPurc,25) + padLeft(cashBackWPurcCount,25) + padLeft(cashBackWPurcAmount,16) + padLeft(cashBackWPurcInterChange,16) + padLeft(cashBackWPurcVat,15) + padLeft(cashBackWPurcTotalCharges,22) + padLeft(cashBackWPurcNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(reversalWpurc != null){
		builder.append(reversalWpurc  == null ? rightPadding(" ",1) :rightPadding(reversalWpurc,25) + padLeft(reversalWpurcCount,25) + padLeft(reversalWpurcAmount,16) + padLeft(reversalWpurcInterChange,16) + padLeft(reversalWpurcVat,15) + padLeft(reversalWpurcTotalCharges,22) + padLeft(reversalWpurcNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(subTotalsWpurc != null){
		builder.append(subTotalsWpurc == null ? rightPadding(" ",1) :rightPadding(subTotalsWpurc,25) + padLeft(subTotalsWpurcCount,25) + padLeft(subTotalsWpurcAmount,16) + padLeft(subTotalsWpurcInterChange,16) + padLeft(subTotalsWpurcVat,15) + padLeft(subTotalsWpurcTotalCharges,22) + padLeft(subTotalsWpurcNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(cashBackNoP != null){
		builder.append(cashBackNoP  == null ? rightPadding(" ",1) :rightPadding(cashBackNoP,25) + padLeft(cashBackNoPCount,25) + padLeft(cashBackNoPAmount,16) + padLeft(cashBackNoPInterChange,16) + padLeft(cashBackNoPVat,15) + padLeft(cashBackNoPTotalCharges,22) + padLeft(cashBackNoPNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(chargeBackCas != null){
		builder.append(chargeBackCas  == null ? rightPadding(" ",1) :rightPadding(chargeBackCas,25) + padLeft(chargeBackCasCount,25) + padLeft(chargeBackCasAmount,16) + padLeft(chargeBackCasInterChange,16) + padLeft(chargeBackCasVat,15) + padLeft(chargeBackCashTotalCharges,22) + padLeft(chargeBackCasNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(reversalCash != null){
		builder.append(reversalCash  == null ? rightPadding(" ",1) :rightPadding(reversalCash,25) + padLeft(reversalCashCount,25) + padLeft(reversalCashAmount,16) + padLeft(reversalCashInterChange,16) + padLeft(reversalCashVat,15) + padLeft(reversalCashTotalCharges,22) + padLeft(reversalCashNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(subTotalsCash != null){
		builder.append(subTotalsCash  == null ? rightPadding(" ",1) :rightPadding(subTotalsCash,25) + padLeft(subTotalsCashCount,25) + padLeft(subTotalsCashAmount,16) + padLeft(subTotalsCashInterChange,16) + padLeft(subTotalsCashVat,15) + padLeft(subTotalsCashTotalCharges,22) + padLeft(subTotalsCashNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(petrolSales != null){
		builder.append(petrolSales == null ? rightPadding(" ",1) :rightPadding(petrolSales,25) + padLeft(petrolSalesCount,25) + padLeft(petrolSalesAmount,16) + padLeft(petrolSalesInterChange,16) + padLeft(petrolSalesVat,15) + padLeft(petrolSalesTotalCharges,22) + padLeft(petrolSalesNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(chargeBacksPs != null){
		builder.append(chargeBacksPs == null ? rightPadding(" ",1) :rightPadding(chargeBacksPs,25) + padLeft(chargeBacksPsCount,25) + padLeft(chargeBacksPsAmount,16) + padLeft(chargeBacksPsInterChange,16) + padLeft(chargeBacksPsVat,15) + padLeft(chargeBacksPsTotalCharges,22) + padLeft(chargeBacksPsNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(reversalsPs != null){
		builder.append(reversalsPs == null ? rightPadding(" ",1) :rightPadding(reversalsPs,25) + padLeft(reversalsPsCount,25) + padLeft(reversalsPsAmount,16) + padLeft(reversalsPsInterChange,16) + padLeft(reversalsPsVat,15) + padLeft(reversalsPsTotalCharges,22) + padLeft(reversalsPsNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(subTotalsPs != null){
		builder.append(subTotalsPs == null ? rightPadding(" ",1) :rightPadding(subTotalsPs,25) + padLeft(subTotalsPsCount,25) + padLeft(subTotalsPsAmount,16) + padLeft(subTotalsPsInterChange,16) + padLeft(subTotalsPsVat,15) + padLeft(subTotalsPsTotalCharges,22) + padLeft(subTotalsPsNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(creditVouchers != null){
		builder.append(creditVouchers == null ? rightPadding(" ",1) :rightPadding(creditVouchers,25) + padLeft(creditVouchersCount,25) + padLeft(creditVouchersAmount,16) + padLeft(creditVouchersInterChange,16) + padLeft(creditVouchersVat,15) + padLeft(creditVouchersTotalCharges,22) + padLeft(creditVouchersNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(chargeBacksCv != null){
		builder.append(chargeBacksCv == null ? rightPadding(" ",1) :rightPadding(chargeBacksCv,25) + padLeft(chargeBacksCvCount,25) + padLeft(chargeBacksCvAmount,16) + padLeft(chargeBacksCvInterChange,16) + padLeft(chargeBacksCvVat,15) + padLeft(chargeBacksCvTotalCharges,22) + padLeft(chargeBacksCvNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(reversalsCv != null){
		builder.append(reversalsCv == null ? rightPadding(" ",1) :rightPadding(reversalsCv,25) + padLeft(reversalsCvCount,25) + padLeft(reversalsCvAmount,16) + padLeft(reversalsCvInterChange,16) + padLeft(reversalsCvVat,15) + padLeft(reversalsCvTotalCharges,22) + padLeft(reversalsCvNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(subTotalsCv != null){
		builder.append(subTotalsCv == null ? rightPadding(" ",1) :rightPadding(subTotalsCv,25) + padLeft(subTotalsCvCount,25) + padLeft(subTotalsCvAmount,16) + padLeft(subTotalsCvInterChange,16) + padLeft(subTotalsCvVat,15) + padLeft(subTotalsCvTotalCharges,22) + padLeft(subTotalsCvNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(cashAdvances != null){
		builder.append(cashAdvances == null ? rightPadding(" ",1) :rightPadding(cashAdvances,25) + padLeft(cashAdvancesCount,25) + padLeft(cashAdvancesAmount,16) + padLeft(cashAdvancesInterChange,16) + padLeft(cashAdvancesVat,15) + padLeft(cashAdvancesTotalCharges,22) + padLeft(cashAdvancesNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(chargeBacksCa != null){
		builder.append(chargeBacksCa == null ? rightPadding(" ",1) :rightPadding(chargeBacksCa,25) + padLeft(chargeBacksCaCount,25) + padLeft(chargeBacksCaAmount,16) + padLeft(chargeBacksCaInterChange,16) + padLeft(chargeBacksCaVat,15) + padLeft(chargeBacksCaTotalCharges,22) + padLeft(chargeBacksCaNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(reversalsCa != null){
		builder.append(reversalsCa == null ? rightPadding(" ",1) :rightPadding(reversalsCa,25) + padLeft(reversalsCaCount,25) + padLeft(reversalsCaAmount,16) + padLeft(reversalsCaInterChange,16) + padLeft(reversalsCaVat,15) + padLeft(reversalsCaTotalCharges,22) + padLeft(reversalsCaNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(subTotalsCa != null){
		builder.append(subTotalsCa == null ? rightPadding(" ",1) :rightPadding(subTotalsCa,25) + padLeft(subTotalsCaCount,25) + padLeft(subTotalsCaAmount,16) + padLeft(subTotalsCaInterChange,16) + padLeft(subTotalsCaVat,15) + padLeft(subTotalsCaTotalCharges,22) + padLeft(subTotalsCaNetAmount,17));
		builder.append(System.lineSeparator());
		}
		if(grandTotalsAll != null){
		builder.append(grandTotalsAll == null ? rightPadding(" ",1) :rightPadding(grandTotalsAll,25) + padLeft(grandTotalsAllCount,25) + padLeft(grandTotalsAllAmount,16) + padLeft(grandTotalsAllInterChange,16) + padLeft(grandTotalsAllVat,15) + padLeft(grandTotalsAllTotalCharges,22) + padLeft(grandTotalsAllNetAmount,17));		
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		}
		*/
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
