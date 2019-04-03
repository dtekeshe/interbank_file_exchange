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
 * User header
 *
 * @author Bongani Hlope &lt;bonganih@bankserv.co.za&gt;
 */
public class UserHeaderDTO {
    private int recordId;
    private int userCode;
    private Date purgeDate;
    private String service;
    private Date creationDate;
    private Date lastActionDate;
    private Date firstActionDate;
    private int firstSequenceNumber;
    private String generationNumber;

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
     * @return the purgeDate
     */
    public Date getPurgeDate() {
        return purgeDate;
    }

    /**
     * @param purgeDate the purgeDate to set
     */
    public void setPurgeDate(Date purgeDate) {
        this.purgeDate = purgeDate;
    }

    /**
     * @return the service
     */
    public String getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    /**
     * @return the generationNumber
     */
    public String getGenerationNumber() {
        return generationNumber;
    }

    /**
     * @param generationNumber the generationNumber to set
     */
    public void setGenerationNumber(String generationNumber) {
        this.generationNumber = generationNumber;
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();

        buff.append(EFTFileUtil.numberToString(recordId, 2));
        buff.append(EFTFileUtil.numberToString(userCode, 4));
        buff.append("YYMMDD");
        buff.append("YYMMDT");
        buff.append("YYMMDD");
        buff.append("YYMMDD");
        buff.append(EFTFileUtil.numberToString(firstSequenceNumber, 6));
        buff.append(EFTFileUtil.ensureLength(generationNumber, ' ', 4, EFTFileUtil.LEFT_JUSTIFY));
        buff.append(EFTFileUtil.ensureLength(service, ' ', 10, EFTFileUtil.LEFT_JUSTIFY));
        buff.append(EFTFileUtil.ensureLength(" ", ' ', 130, EFTFileUtil.LEFT_JUSTIFY));
        return buff.toString();
    }
}
