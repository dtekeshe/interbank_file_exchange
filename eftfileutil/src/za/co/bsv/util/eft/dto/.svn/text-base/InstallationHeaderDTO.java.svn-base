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
 * EFT file installation header
 *
 * @author Bongani Hlope &lt;bonganih@bankserv.co.za&gt;
 */
public class InstallationHeaderDTO {
    private int recordId;
    private Date purgeDate;
    private String service;
    private int blockLength;
    private int recordLength;
    private int volumeNumber;
    private Date creationDate;
    private int sourceIdentifier;
    private String generationNumber;
    private String tapeSerialNumber;
    private int destinationIdentifier;

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

    @Override
    public String toString() {        
        StringBuilder buff = new StringBuilder();

        buff.append(EFTFileUtil.numberToString(recordId, 2));
        buff.append(EFTFileUtil.numberToString(volumeNumber, 4));
        buff.append(EFTFileUtil.ensureLength(tapeSerialNumber, ' ', 8, EFTFileUtil.LEFT_JUSTIFY));
        buff.append(EFTFileUtil.numberToString(sourceIdentifier, 4));
        buff.append(EFTFileUtil.numberToString(destinationIdentifier, 4));
        buff.append("YYMMDD");
        buff.append("YYMMDT");
        buff.append(EFTFileUtil.ensureLength(generationNumber, ' ', 4, EFTFileUtil.LEFT_JUSTIFY));
        buff.append(EFTFileUtil.numberToString(blockLength, 4));
        buff.append(EFTFileUtil.numberToString(recordLength, 4));
        buff.append(EFTFileUtil.ensureLength(service, ' ', 10, EFTFileUtil.LEFT_JUSTIFY));
        buff.append(EFTFileUtil.ensureLength(" ", ' ', 124, EFTFileUtil.LEFT_JUSTIFY));
        return buff.toString();
    }
}
