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
 * Represents the EFT transaction
 *
 * @author Bongani Hlope &lt;bonganih@bankserv.co.za&gt;
 */
public class EFTTransactionDTO {
    /** Possible account types */
    public final static int ACCOUNT_TYPE_CURRENT        =   1;
    public final static int ACCOUNT_TYPE_SAVINGS        =   2;
    public final static int ACCOUNT_TYPE_TRANSMISSION   =   3;
    public final static int ACCOUNT_TYPE_BOND           =   4;
    public final static int ACCOUNT_TYPE_SHARE          =   6;

    /** Possible entry class*/
    public final static int ENTRY_CLASS_CREDIT          =   88;
    public final static int ENTRY_CLASS_DEBIT           =   44;

    /** Possible record id's*/
    public final static int RECORD_ID_CREDIT            =   10;
    public final static int RECORD_ID_DEBIT             =   50;

    private long amount;
    private int taxCode;
    private int recordId;
    private int userCode;
    private int entryClass;
    private int accountType;
    private Date actionDate;
    private String shortName;
    private int sourceBranchCode;
    private String userReference;
    private long sourceAccountNumber;
    private int destinationBrancCode;
    private String sourceAccountName;
    private int destinationInstitution;
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
     * @return the taxCode
     */
    public int getTaxCode() {
        return taxCode;
    }

    /**
     * @param taxCode the taxCode to set
     */
    public void setTaxCode(int taxCode) {
        this.taxCode = taxCode;
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
     * @return the destinationInstitution
     */
    public int getDestinationInstitution() {
        return destinationInstitution;
    }

    /**
     * @param destinationInstitution the destinationInstitution to set
     */
    public void setDestinationInstitution(int destinationInstitution) {
        this.destinationInstitution = destinationInstitution;
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

    /**
     * @return the shortName
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName the shortName to set
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
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
        buff.append(EFTFileUtil.numberToString(taxCode, 1));
        buff.append(EFTFileUtil.numberToString(0, 3)); //Filler
        buff.append(EFTFileUtil.ensureLength(shortName, ' ', 10, EFTFileUtil.LEFT_JUSTIFY));
        buff.append(EFTFileUtil.ensureLength(userReference, ' ', 20, EFTFileUtil.LEFT_JUSTIFY));
        buff.append(EFTFileUtil.ensureLength(sourceAccountName, ' ', 30, EFTFileUtil.LEFT_JUSTIFY).toUpperCase());
        buff.append(EFTFileUtil.ensureLength(" ", '0', 20, EFTFileUtil.LEFT_JUSTIFY));
        buff.append(EFTFileUtil.ensureLength(" ", ' ', 16, EFTFileUtil.LEFT_JUSTIFY));
        buff.append(EFTFileUtil.numberToString(destinationInstitution, 2));
        buff.append(EFTFileUtil.ensureLength(" ", ' ', 12, EFTFileUtil.LEFT_JUSTIFY));
        return buff.toString();
    }

}
