/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */

package za.co.bsv.util.eft.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import za.co.bsv.util.eft.util.EFTFileUtil;

/**
 * Installation trailer
 *
 * @author Bongani Hlope &lt;bonganih@bankserv.co.za&gt;
 */
public class InstallationTrailerDTO {
    private int recordId;
    private Date purgeDate;
    private String service;
    private int blockCount;
    private int recordCount;
    private int blockLength;
    private int recordLength;
    private int volumeNumber;
    private Date creationDate;
    private int sourceIdentifier;
    private String generationNumber;
    private String tapeSerialNumber;
    private int destinationIdentifier;
    private int userHeaderTrailerCount;

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
     * @return the blockCount
     */
    public int getBlockCount() {
        return blockCount;
    }

    /**
     * @param blockCount the blockCount to set
     */
    public void setBlockCount(int blockCount) {
        this.blockCount = blockCount;
    }

    /**
     * @return the recordCount
     */
    public int getRecordCount() {
        return recordCount;
    }

    /**
     * @param recordCount the recordCount to set
     */
    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    /**
     * @return the blockLength
     */
    public int getBlockLength() {
        return blockLength;
    }

    /**
     * @param blockLength the blockLength to set
     */
    public void setBlockLength(int blockLength) {
        this.blockLength = blockLength;
    }

    /**
     * @return the recordLength
     */
    public int getRecordLength() {
        return recordLength;
    }

    /**
     * @param recordLength the recordLength to set
     */
    public void setRecordLength(int recordLength) {
        this.recordLength = recordLength;
    }

    /**
     * @return the volumeNumber
     */
    public int getVolumeNumber() {
        return volumeNumber;
    }

    /**
     * @param volumeNumber the volumeNumber to set
     */
    public void setVolumeNumber(int volumeNumber) {
        this.volumeNumber = volumeNumber;
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
     * @return the sourceIdentifier
     */
    public int getSourceIdentifier() {
        return sourceIdentifier;
    }

    /**
     * @param sourceIdentifier the sourceIdentifier to set
     */
    public void setSourceIdentifier(int sourceIdentifier) {
        this.sourceIdentifier = sourceIdentifier;
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

    /**
     * @return the tapeSerialNumber
     */
    public String getTapeSerialNumber() {
        return tapeSerialNumber;
    }

    /**
     * @param tapeSerialNumber the tapeSerialNumber to set
     */
    public void setTapeSerialNumber(String tapeSerialNumber) {
        this.tapeSerialNumber = tapeSerialNumber;
    }

    /**
     * @return the destinationIdentifier
     */
    public int getDestinationIdentifier() {
        return destinationIdentifier;
    }

    /**
     * @param destinationIdentifier the destinationIdentifier to set
     */
    public void setDestinationIdentifier(int destinationIdentifier) {
        this.destinationIdentifier = destinationIdentifier;
    }

    /**
     * @return the userHeaderTrailerCount
     */
    public int getUserHeaderTrailerCount() {
        return userHeaderTrailerCount;
    }

    /**
     * @param userHeaderTrailerCount the userHeaderTrailerCount to set
     */
    public void setUserHeaderTrailerCount(int userHeaderTrailerCount) {
        this.userHeaderTrailerCount = userHeaderTrailerCount;
    }

    @Override
    public String toString() {        
        StringBuilder buff = new StringBuilder();

        buff.append(EFTFileUtil.numberToString(recordId, 2));
        buff.append(EFTFileUtil.numberToString(volumeNumber, 4));
        buff.append(tapeSerialNumber);
        buff.append(EFTFileUtil.numberToString(sourceIdentifier, 4));
        buff.append(EFTFileUtil.numberToString(destinationIdentifier, 4));
        buff.append("YYMMDD");
        buff.append("YYMMDT");
        buff.append(generationNumber);
        buff.append(EFTFileUtil.numberToString(blockLength, 4));
        buff.append(EFTFileUtil.numberToString(recordLength, 4));
        buff.append(service);
        buff.append(EFTFileUtil.numberToString(blockCount, 6));
        buff.append(EFTFileUtil.numberToString(recordCount, 6));
        buff.append(EFTFileUtil.numberToString(userHeaderTrailerCount, 6));

        buff.append(EFTFileUtil.ensureLength(" ", ' ', 106, EFTFileUtil.LEFT_JUSTIFY));
        return buff.toString();
    }
}
