package com.bsva.dcms.commons.dto.file;

public class FileTransactionRecordDTO {

    private int issuerBin = 0;
    private int issuer = 0;
    private int acquirerBin = 0;
    private int acquirer = 0;
    private int cardType = 0;
    private String cardNumber = "";
    private short transactionCode = 0;
    private long transactionAmount = 0;
//    private boolean visaTCR5Present = false;    
    private boolean isTransactionACashBack = false;
    private long cashbackAmount = 0;
    private int messageTypeInd = 0;
    private int merchantCatCode = 0;
    private int messageReasonCode = 0;
    private String outputFileName = null;
//    private String fleetTranDate;
//    private String fleetTranTime;
//    private String fleetProduct = "";
//    private String fleetSubProduct = "";    
    private int transactionTarget;
    private boolean isCurrentRecordValid = true;
    private int recordOffset = 0; // transaction line number , 4 lines include one transaction, header + trailer	
    private int nonFinRecCount = 0;
    private VISATCR0TransactionRecordDTO tcr0TransactionRecordDto;
    private VISATCR1TransactionRecordDTO tcr1TransactionRecordDto;
    private VISATCR3TransactionRecordDTO tcr3TransactionRecordDto;
    private VISATCR5TransactionRecordDTO tcr5TransactionRecordDto;
    private VISATCR7TransactionRecordDTO tcr7TransactionRecordDto;
    private String fileName;
    //i think we can do without these 2 fields
    private int recordStartByte;
    private int recordEndByte;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public VISATCR0TransactionRecordDTO getTcr0TransactionRecordDto() {
        return tcr0TransactionRecordDto;
    }

    public void setTcr0TransactionRecordDto(
            VISATCR0TransactionRecordDTO tcr0TransactionRecordDto) {
        this.tcr0TransactionRecordDto = tcr0TransactionRecordDto;
    }

    public VISATCR1TransactionRecordDTO getTcr1TransactionRecordDto() {
        return tcr1TransactionRecordDto;
    }

    public void setTcr1TransactionRecordDto(
            VISATCR1TransactionRecordDTO tcr1TransactionRecordDto) {
        this.tcr1TransactionRecordDto = tcr1TransactionRecordDto;
    }

    public VISATCR3TransactionRecordDTO getTcr3TransactionRecordDto() {
		return tcr3TransactionRecordDto;
	}

	public void setTcr3TransactionRecordDto(VISATCR3TransactionRecordDTO tcr3TransactionRecordDto) {
		this.tcr3TransactionRecordDto = tcr3TransactionRecordDto;
	}

	public VISATCR5TransactionRecordDTO getTcr5TransactionRecordDto() {
        return tcr5TransactionRecordDto;
    }

    public void setTcr5TransactionRecordDto(
            VISATCR5TransactionRecordDTO tcr5TransactionRecordDto) {
        this.tcr5TransactionRecordDto = tcr5TransactionRecordDto;
    }

    public VISATCR7TransactionRecordDTO getTcr7TransactionRecordDto() {
        return tcr7TransactionRecordDto;
    }

    public void setTcr7TransactionRecordDto(
            VISATCR7TransactionRecordDTO tcr7TransactionRecordDto) {
        this.tcr7TransactionRecordDto = tcr7TransactionRecordDto;
    }

    public int getIssuerBin() {
        return issuerBin;
    }

    public void setIssuerBin(int issuerBin) {
        this.issuerBin = issuerBin;
    }

    public int getIssuer() {
        return issuer;
    }

    public void setIssuer(int issuer) {
        this.issuer = issuer;
    }

    public int getAcquirerBin() {
        return acquirerBin;
    }

    public void setAcquirerBin(int acquirerBin) {
        this.acquirerBin = acquirerBin;
    }

    public int getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(int acquirer) {
        this.acquirer = acquirer;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public short getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(short transactionCode) {
        this.transactionCode = transactionCode;
    }

    public long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
//	public boolean isVisaTCR5Present() {
//		return visaTCR5Present;
//	}
//	public void setVisaTCR5Present(boolean visaTCR5Present) {
//		this.visaTCR5Present = visaTCR5Present;
//	}

    public boolean isTransactionACashBack() {
        return isTransactionACashBack;
    }

    public void setTransactionACashBack(boolean isTransactionACashBack) {
        this.isTransactionACashBack = isTransactionACashBack;
    }

    public long getCashbackAmount() {
        return cashbackAmount;
    }

    public void setCashbackAmount(long cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }

    public int getMessageTypeInd() {
        return messageTypeInd;
    }

    public void setMessageTypeInd(int messageTypeInd) {
        this.messageTypeInd = messageTypeInd;
    }

    public int getMerchantCatCode() {
        return merchantCatCode;
    }

    public void setMerchantCatCode(int merchantCatCode) {
        this.merchantCatCode = merchantCatCode;
    }

    public int getMessageReasonCode() {
        return messageReasonCode;
    }

    public void setMessageReasonCode(int messageReasonCode) {
        this.messageReasonCode = messageReasonCode;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }
//	public String getFleetTranDate() {
//		return fleetTranDate;
//	}
//	public void setFleetTranDate(String fleetTranDate) {
//		this.fleetTranDate = fleetTranDate;
//	}
//	public String getFleetTranTime() {
//		return fleetTranTime;
//	}
//	public void setFleetTranTime(String fleetTranTime) {
//		this.fleetTranTime = fleetTranTime;
//	}
//	public String getFleetProduct() {
//		return fleetProduct;
//	}
//	public void setFleetProduct(String fleetProduct) {
//		this.fleetProduct = fleetProduct;
//	}
//	public String getFleetSubProduct() {
//		return fleetSubProduct;
//	}
//	public void setFleetSubProduct(String fleetSubProduct) {
//		this.fleetSubProduct = fleetSubProduct;
//	}

    public int getTransactionTarget() {
        return transactionTarget;
    }

    public void setTransactionTarget(int transactionTarget) {
        this.transactionTarget = transactionTarget;
    }

    public boolean isCurrentRecordValid() {
        return isCurrentRecordValid;
    }

    public void setCurrentRecordValid(boolean isCurrentRecordValid) {
        this.isCurrentRecordValid = isCurrentRecordValid;
    }

    public int getRecordOffset() {
        return recordOffset;
    }

    public void setRecordOffset(int recordOffset) {
        this.recordOffset = recordOffset;
    }

    public int getNonFinRecCount() {
        return nonFinRecCount;
    }

    public void setNonFinRecCount(int nonFinRecCount) {
        this.nonFinRecCount = nonFinRecCount;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public int getRecordStartByte() {
        return recordStartByte;
    }

    public void setRecordStartByte(int recordStartByte) {
        this.recordStartByte = recordStartByte;
    }

    public int getRecordEndByte() {
        return recordEndByte;
    }

    public void setRecordEndByte(int recordEndByte) {
        this.recordEndByte = recordEndByte;
    }

}
