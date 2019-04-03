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
 * User trailer
 *
 * @author Bongani Hlope &lt;bonganih@bankserv.co.za&gt;
 */
public class UserTrailerDTO {
    private int recordId;
    private int userCode;
    private long hashTotal;
    private long totalDebit;
    private long totalCredit;
    private int numberOfContra;
    private int numberOfDebits;
    private int numberOfCredits;
    private Date lastActionDate;
    private Date firstActionDate;
    private int lastSequenceNumber;
    private int firstSequenceNumber;

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
     * @return the hashTotal
     */
    public long getHashTotal() {
        return hashTotal;
    }

    /**
     * @param hashTotal the hashTotal to set
     */
    public void setHashTotal(long hashTotal) {
        this.hashTotal = hashTotal;
    }

    /**
     * @return the totalCredit
     */
    public long getTotalCredit() {
        return totalCredit;
    }

    /**
     * @param totalCredit the totalCredit to set
     */
    public void setTotalCredit(long totalCredit) {
        this.totalCredit = totalCredit;
    }

    /**
     * @return the totalDebit
     */
    public long getTotalDebit() {
        return totalDebit;
    }

    /**
     * @param totalDebit the totalDebit to set
     */
    public void setTotalDebit(long totalDebit) {
        this.totalDebit = totalDebit;
    }

    /**
     * @return the numberOfContra
     */
    public int getNumberOfContra() {
        return numberOfContra;
    }

    /**
     * @param numberOfContra the numberOfContra to set
     */
    public void setNumberOfContra(int numberOfContra) {
        this.numberOfContra = numberOfContra;
    }

    /**
     * @return the numberOfDebits
     */
    public int getNumberOfDebits() {
        return numberOfDebits;
    }

    /**
     * @param numberOfDebits the numberOfDebits to set
     */
    public void setNumberOfDebits(int numberOfDebits) {
        this.numberOfDebits = numberOfDebits;
    }

    /**
     * @return the numberOfCredits
     */
    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    /**
     * @param numberOfCredits the numberOfCredits to set
     */
    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    /**
     * @return the lastActionDate
     */
    public Date getLastActionDate() {
        return lastActionDate;
    }

    /**
     * @param lastActionDate the lastActionDate to set
     */
    public void setLastActionDate(Date lastActionDate) {
        this.lastActionDate = lastActionDate;
    }

    /**
     * @return the firstActionDate
     */
    public Date getFirstActionDate() {
        return firstActionDate;
    }

    /**
     * @param firstActionDate the firstActionDate to set
     */
    public void setFirstActionDate(Date firstActionDate) {
        this.firstActionDate = firstActionDate;
    }

    /**
     * @return the lastSequenceNumber
     */
    public int getLastSequenceNumber() {
        return lastSequenceNumber;
    }

    /**
     * @param lastSequenceNumber the lastSequenceNumber to set
     */
    public void setLastSequenceNumber(int lastSequenceNumber) {
        this.lastSequenceNumber = lastSequenceNumber;
    }

    /**
     * @return the firstSequenceNumber
     */
    public int getFirstSequenceNumber() {
        return firstSequenceNumber;
    }

    /**
     * @param firstSequenceNumber the firstSequenceNumber to set
     */
    public void setFirstSequenceNumber(int firstSequenceNumber) {
        this.firstSequenceNumber = firstSequenceNumber;
    }

    @Override
    public String toString() {        
        StringBuilder buff = new StringBuilder();
        buff.append(EFTFileUtil.numberToString(recordId, 2));
        buff.append(EFTFileUtil.numberToString(userCode, 4));
        buff.append(EFTFileUtil.numberToString(firstSequenceNumber, 6));
        buff.append(EFTFileUtil.numberToString(lastSequenceNumber, 6));
        buff.append("YYMMDD");
        buff.append("YYMMDD");
        buff.append(EFTFileUtil.numberToString(numberOfDebits, 6));
        buff.append(EFTFileUtil.numberToString(numberOfCredits, 6));
        buff.append(EFTFileUtil.numberToString(numberOfContra, 6));
        buff.append(EFTFileUtil.numberToString(totalDebit, 12));
        buff.append(EFTFileUtil.numberToString(totalCredit, 12));
        buff.append(EFTFileUtil.numberToString(hashTotal, 12));
        buff.append(EFTFileUtil.ensureLength(" ", ' ', 96, EFTFileUtil.LEFT_JUSTIFY));
        return buff.toString();
    }
}
