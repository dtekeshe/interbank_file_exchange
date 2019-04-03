/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */

package za.co.bsv.util.eft.dto;

import java.util.Date;

import za.co.bsv.util.eft.util.EFTFileUtil;

/**
 * Represents the contra record of each user data set
 *
 * @author Bongani Hlope &lt;bonganih@bankserv.co.za&gt;
 */
public class ContraRecordDTO {
    public final static int RECORD_ID_CREDIT            =   12;
    public final static int RECORD_ID_DEBIT             =   52;

    private long amount;
    private int recordId;
    private int userCode;
    private int entryClass;
    private int accountType;
    private Date actionDate;
    private int sourceBranchCode;
    private String userReference;
    private long sourceAccountNumber;
    private int destinationBrancCode;
    private String sourceAccountName;
    private long destinationAccountNumber;
    private int transactionSequenceNumber;

    /**
     * @return the amount
     */
    public long getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }


    /**
     * @return the recordId
     */
    public int getRecordId() {
        return recordId;
    }

    /**
     * @param recordId the recordId to set
     */
    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    /**
     * @return the userCode
     */
    public int getUserCode() {
        return userCode;
    }

    /**
     * @param userCode the userCode to set
     */
    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    /**
     * @return the entryClass
     */
    public int getEntryClass() {
        return entryClass;
    }

    /**
     * @param entryClass the entryClass to set
     */
    public void setEntryClass(int entryClass) {
        this.entryClass = entryClass;
    }

    /**
     * @return the accountType
     */
    public int getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    /**
     * @return the actionDate
     */
    public Date getActionDate() {
        return actionDate;
    }

    /**
     * @param actionDate the actionDate to set
     */
    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    /**
     * @return the sourceBranchCode
     */
    public int getSourceBranchCode() {
        return sourceBranchCode;
    }

    /**
     * @param sourceBranchCode the sourceBranchCode to set
     */
    public void setSourceBranchCode(int sourceBranchCode) {
        this.sourceBranchCode = sourceBranchCode;
    }

    /**
     * @return the sourceAccountNumber
     */
    public long getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    /**
     * @param sourceAccountNumber the sourceAccountNumber to set
     */
    public void setSourceAccountNumber(long sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    /**
     * @return the destinationBrancCode
     */
    public int getDestinationBrancCode() {
        return destinationBrancCode;
    }

    /**
     * @param destinationBrancCode the destinationBrancCode to set
     */
    public void setDestinationBrancCode(int destinationBrancCode) {
        this.destinationBrancCode = destinationBrancCode;
    }

    /**
     * @return the destinationAccountNumber
     */
    public long getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    /**
     * @param destinationAccountNumber the destinationAccountNumber to set
     */
    public void setDestinationAccountNumber(long destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
    }

    /**
     * @return the sourceAccountName
     */
    public String getSourceAccountName() {
        return sourceAccountName;
    }

    /**
     * @param sourceAccountName the sourceAccountName to set
     */
    public void setSourceAccountName(String sourceAccountName) {
        this.sourceAccountName = sourceAccountName;
    }

    /**
     * @return the transactionSequenceNumber
     */
    public int getTransactionSequenceNumber() {
        return transactionSequenceNumber;
    }

    /**
     * @param transactionSequenceNumber the transactionSequenceNumber to set
     */
    public void setTransactionSequenceNumber(int transactionSequenceNumber) {
        this.transactionSequenceNumber = transactionSequenceNumber;
    }

    /**
     * @return the userReference
     */
    public String getUserReference() {
        return userReference;
    }

    /**
     * @param userReference the userReference to set
     */
    public void setUserReference(String userReference) {
        this.userReference = userReference;
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();        
        buff.append(EFTFileUtil.numberToString(recordId, 2));
        buff.append(EFTFileUtil.numberToString(sourceBranchCode, 6));
        buff.append(EFTFileUtil.numberToString(sourceAccountNumber, 11));
        buff.append(EFTFileUtil.numberToString(userCode, 4));
        buff.append(EFTFileUtil.numberToString(transactionSequenceNumber, 6));
        buff.append(EFTFileUtil.numberToString(destinationBrancCode, 6));
        buff.append(EFTFileUtil.numberToString(destinationAccountNumber, 11));
        buff.append(EFTFileUtil.numberToString(accountType, 1));
        buff.append(EFTFileUtil.numberToString(amount, 11));
        buff.append("YYMMDD");
        buff.append(EFTFileUtil.numberToString(entryClass, 2));
        buff.append(EFTFileUtil.numberToString(0, 4)); //Filler
        buff.append(EFTFileUtil.ensureLength(userReference, ' ', 30, EFTFileUtil.LEFT_JUSTIFY));
        buff.append(EFTFileUtil.ensureLength(sourceAccountName, ' ', 30, EFTFileUtil.LEFT_JUSTIFY));
        buff.append(EFTFileUtil.ensureLength(" ", ' ', 50, EFTFileUtil.LEFT_JUSTIFY));
        return buff.toString();
    }
}
