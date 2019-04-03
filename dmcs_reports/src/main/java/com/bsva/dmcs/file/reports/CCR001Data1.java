package com.bsva.dmcs.file.reports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author AugustineA
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CCR001Data1 {

	
	@XmlAttribute
	private long volume;
	private long value;
	private long billAmount;
	private long billAdvAmount;
	private long billVat;
	private long totalCharges;
	private long nettAmount;
	private String totalName;
	private String subService;
	private String elDescription;
	private int currIss;
	private int currAcq;
	private int currCard;
	private int issCde;
	private int acqCde;
	private int cardType;
	private String cardDesc;
	private String tranDesc;
	private String fileName;
	private int txType;
	private long repVolume;
	private double repValue;
	private double repBillAmnt;
	private double repBillPrec;
	private double repBilVat;
	private int invoiceNo;
	private BankAddress address;
	private boolean grandTotsAdded;
	

	public boolean isGrandTotsAdded() {
		return grandTotsAdded;
	}


	public void setGrandTotsAdded(boolean grandTotsAdded) {
		this.grandTotsAdded = grandTotsAdded;
	}


	public CCR001Data1() {
	}


	public CCR001Data1(long volume, long value, long billAmount,
			long billAdvAmount, long billVat, long totalCharges,
			long nettAmount, String totalName, String subService,
			String elDescription, int currIss, int currAcq, int currCard,
			int issCde, int acqCde, int cardType, String cardDesc,
			String tranDesc, String fileName, int txType, long repVolume,
			double repValue, double repBillAmnt, double repBillPrec,
			double repBilVat, int invoiceNo, BankAddress address) {
		super();
		this.volume = volume;
		this.value = value;
		this.billAmount = billAmount;
		this.billAdvAmount = billAdvAmount;
		this.billVat = billVat;
		this.totalCharges = totalCharges;
		this.nettAmount = nettAmount;
		this.totalName = totalName;
		this.subService = subService;
		this.elDescription = elDescription;
		this.currIss = currIss;
		this.currAcq = currAcq;
		this.currCard = currCard;
		this.issCde = issCde;
		this.acqCde = acqCde;
		this.cardType = cardType;
		this.cardDesc = cardDesc;
		this.tranDesc = tranDesc;
		this.fileName = fileName;
		this.txType = txType;
		this.repVolume = repVolume;
		this.repValue = repValue;
		this.repBillAmnt = repBillAmnt;
		this.repBillPrec = repBillPrec;
		this.repBilVat = repBilVat;
		this.invoiceNo = invoiceNo;
		this.address = address;
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


	public long getBillAmount() {
		return billAmount;
	}


	public void setBillAmount(long billAmount) {
		this.billAmount = billAmount;
	}


	public long getBillAdvAmount() {
		return billAdvAmount;
	}


	public void setBillAdvAmount(long billAdvAmount) {
		this.billAdvAmount = billAdvAmount;
	}


	public long getBillVat() {
		return billVat;
	}


	public void setBillVat(long billVat) {
		this.billVat = billVat;
	}


	public long getTotalCharges() {
		return totalCharges;
	}


	public void setTotalCharges(long totalCharges) {
		this.totalCharges = totalCharges;
	}


	public long getNettAmount() {
		return nettAmount;
	}


	public void setNettAmount(long nettAmount) {
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


	public int getCurrIss() {
		return currIss;
	}


	public void setCurrIss(int currIss) {
		this.currIss = currIss;
	}


	public int getCurrAcq() {
		return currAcq;
	}


	public void setCurrAcq(int currAcq) {
		this.currAcq = currAcq;
	}


	public int getCurrCard() {
		return currCard;
	}


	public void setCurrCard(int currCard) {
		this.currCard = currCard;
	}


	public int getIssCde() {
		return issCde;
	}


	public void setIssCde(int issCde) {
		this.issCde = issCde;
	}


	public int getAcqCde() {
		return acqCde;
	}


	public void setAcqCde(int acqCde) {
		this.acqCde = acqCde;
	}


	public int getCardType() {
		return cardType;
	}


	public void setCardType(int cardType) {
		this.cardType = cardType;
	}


	public String getCardDesc() {
		return cardDesc;
	}


	public void setCardDesc(String cardDesc) {
		this.cardDesc = cardDesc;
	}


	public String getTranDesc() {
		return tranDesc;
	}


	public void setTranDesc(String tranDesc) {
		this.tranDesc = tranDesc;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public int getTxType() {
		return txType;
	}


	public void setTxType(int txType) {
		this.txType = txType;
	}


	public long getRepVolume() {
		return repVolume;
	}


	public void setRepVolume(long repVolume) {
		this.repVolume = repVolume;
	}


	public double getRepValue() {
		return repValue;
	}


	public void setRepValue(double repValue) {
		this.repValue = repValue;
	}


	public double getRepBillAmnt() {
		return repBillAmnt;
	}


	public void setRepBillAmnt(double repBillAmnt) {
		this.repBillAmnt = repBillAmnt;
	}


	public double getRepBillPrec() {
		return repBillPrec;
	}


	public void setRepBillPrec(double repBillPrec) {
		this.repBillPrec = repBillPrec;
	}


	public double getRepBilVat() {
		return repBilVat;
	}


	public void setRepBilVat(double repBilVat) {
		this.repBilVat = repBilVat;
	}


	public int getInvoiceNo() {
		return invoiceNo;
	}


	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}


	public BankAddress getAddress() {
		return address;
	}


	public void setAddress(BankAddress address) {
		this.address = address;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(volume);
		builder.append(value);
		builder.append(billAmount);
		builder.append(billAdvAmount);
		builder.append(billVat);
		builder.append(totalCharges);
		builder.append(nettAmount);
		builder.append(totalName);
		builder.append(subService);
		builder.append(elDescription);
		builder.append(currIss);
		builder.append(currAcq);
		builder.append(currCard);
		builder.append(issCde);
		builder.append(acqCde);
		builder.append(cardType);
		builder.append(cardDesc);
		builder.append(tranDesc);
		builder.append(fileName);
		builder.append(txType);
		builder.append(repVolume);
		builder.append(repValue);
		builder.append(repBillAmnt);
		builder.append(repBillPrec);
		builder.append(repBilVat);
		builder.append(invoiceNo);
		builder.append(address);
		return builder.toString();
	}
	
	
	
}
