package com.bsva.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "DEL_DELIVERY_FILES_CCC")
@NamedQueries({
    @NamedQuery(name = "DelDeliveryFilesCcc.findAll", query = "SELECT d FROM DelDeliveryFilesCcc d"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByPosition", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.delDeliveryFilesCccPK.position = :position"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByQueueFileName", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.delDeliveryFilesCccPK.queueFileName = :queueFileName"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByPrdDate", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.prdDate = :prdDate"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByMember", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.member = :member"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByUserDest", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.userDest = :userDest"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByApplication", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.application = :application"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findBySubApplication", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.subApplication = :subApplication"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByFilename", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.delDeliveryFilesCccPK.filename = :filename"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByLastFile", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.lastFile = :lastFile"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByXmitInd", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.xmitInd = :xmitInd"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByProgramFrom", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.programFrom = :programFrom"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByTimeCreated", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.timeCreated = :timeCreated"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByOutputFormat", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.outputFormat = :outputFormat"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByBackupFormat", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.backupFormat = :backupFormat"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByCreateTrailer", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.createTrailer = :createTrailer"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByNoOfRecords", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.noOfRecords = :noOfRecords"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByNoOfDebits", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.noOfDebits = :noOfDebits"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByNoOfCredits", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.noOfCredits = :noOfCredits"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByValueDebits", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.valueDebits = :valueDebits"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByValueCredits", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.valueCredits = :valueCredits"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByHashTotal", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.hashTotal = :hashTotal"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByRecLength", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.recLength = :recLength"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByBlockFactor", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.blockFactor = :blockFactor"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByDeliveryStatus", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.deliveryStatus = :deliveryStatus"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByDeliveryTime", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.deliveryTime = :deliveryTime"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByWrittenToAxd", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.writtenToAxd = :writtenToAxd"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByRejectReason", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.rejectReason = :rejectReason"),
    @NamedQuery(name = "DelDeliveryFilesCcc.findByReportName", query = "SELECT d FROM DelDeliveryFilesCcc d WHERE d.reportName = :reportName")})
@DynamicUpdate
public class DelDeliveryFilesCcc implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DelDeliveryFilesCccPK delDeliveryFilesCccPK;
    @Column(name = "PRD_DATE")
    private Integer prdDate;
    @Column(name = "MEMBER")
    private Short member;
    @Column(name = "USER_DEST")
    private Short userDest;
    @Size(max = 4)
    @Column(name = "APPLICATION")
    private String application;
    @Size(max = 10)
    @Column(name = "SUB_APPLICATION")
    private String subApplication;
    @Size(max = 1)
    @Column(name = "LAST_FILE")
    private String lastFile;
    @Size(max = 1)
    @Column(name = "XMIT_IND")
    private String xmitInd;
    @Size(max = 10)
    @Column(name = "PROGRAM_FROM")
    private String programFrom;
    @Column(name = "TIME_CREATED")
    private Integer timeCreated;
    @Size(max = 4)
    @Column(name = "OUTPUT_FORMAT")
    private String outputFormat;
    @Size(max = 4)
    @Column(name = "BACKUP_FORMAT")
    private String backupFormat;
    @Size(max = 1)
    @Column(name = "CREATE_TRAILER")
    private String createTrailer;
    @Column(name = "NO_OF_RECORDS")
    private Integer noOfRecords;
    @Column(name = "NO_OF_DEBITS")
    private Integer noOfDebits;
    @Column(name = "NO_OF_CREDITS")
    private Integer noOfCredits;
    @Column(name = "VALUE_DEBITS")
    private BigDecimal valueDebits;
    @Column(name = "VALUE_CREDITS")
    private BigDecimal valueCredits;
    @Column(name = "HASH_TOTAL")
    private Long hashTotal;
    @Column(name = "REC_LENGTH")
    private Short recLength;
    @Column(name = "BLOCK_FACTOR")
    private Short blockFactor;
    @Size(max = 1)
    @Column(name = "DELIVERY_STATUS")
    private String deliveryStatus;
    @Column(name = "DELIVERY_TIME")
    private Integer deliveryTime;
    @Size(max = 1)
    @Column(name = "WRITTEN_TO_AXD")
    private String writtenToAxd;
    @Size(max = 24)
    @Column(name = "REJECT_REASON")
    private String rejectReason;
    @Size(max = 24)
    @Column(name = "REPORT_NAME")
    private String reportName;

    public DelDeliveryFilesCcc() {
    }

    public DelDeliveryFilesCcc(DelDeliveryFilesCccPK delDeliveryFilesCccPK) {
        this.delDeliveryFilesCccPK = delDeliveryFilesCccPK;
    }

    public DelDeliveryFilesCcc(int position, String queueFileName, String filename) {
        this.delDeliveryFilesCccPK = new DelDeliveryFilesCccPK(position, queueFileName, filename);
    }

    public DelDeliveryFilesCccPK getDelDeliveryFilesCccPK() {
        return delDeliveryFilesCccPK;
    }

    public void setDelDeliveryFilesCccPK(DelDeliveryFilesCccPK delDeliveryFilesCccPK) {
        this.delDeliveryFilesCccPK = delDeliveryFilesCccPK;
    }

    public Integer getPrdDate() {
        return prdDate;
    }

    public void setPrdDate(Integer prdDate) {
        this.prdDate = prdDate;
    }

    public Short getMember() {
        return member;
    }

    public void setMember(Short member) {
        this.member = member;
    }

    public Short getUserDest() {
        return userDest;
    }

    public void setUserDest(Short userDest) {
        this.userDest = userDest;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getSubApplication() {
        return subApplication;
    }

    public void setSubApplication(String subApplication) {
        this.subApplication = subApplication;
    }

    public String getLastFile() {
        return lastFile;
    }

    public void setLastFile(String lastFile) {
        this.lastFile = lastFile;
    }

    public String getXmitInd() {
        return xmitInd;
    }

    public void setXmitInd(String xmitInd) {
        this.xmitInd = xmitInd;
    }

    public String getProgramFrom() {
        return programFrom;
    }

    public void setProgramFrom(String programFrom) {
        this.programFrom = programFrom;
    }

    public Integer getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Integer timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getBackupFormat() {
        return backupFormat;
    }

    public void setBackupFormat(String backupFormat) {
        this.backupFormat = backupFormat;
    }

    public String getCreateTrailer() {
        return createTrailer;
    }

    public void setCreateTrailer(String createTrailer) {
        this.createTrailer = createTrailer;
    }

    public Integer getNoOfRecords() {
        return noOfRecords;
    }

    public void setNoOfRecords(Integer noOfRecords) {
        this.noOfRecords = noOfRecords;
    }

    public Integer getNoOfDebits() {
        return noOfDebits;
    }

    public void setNoOfDebits(Integer noOfDebits) {
        this.noOfDebits = noOfDebits;
    }

    public Integer getNoOfCredits() {
        return noOfCredits;
    }

    public void setNoOfCredits(Integer noOfCredits) {
        this.noOfCredits = noOfCredits;
    }

    public BigDecimal getValueDebits() {
        return valueDebits;
    }

    public void setValueDebits(BigDecimal valueDebits) {
        this.valueDebits = valueDebits;
    }

    public BigDecimal getValueCredits() {
        return valueCredits;
    }

    public void setValueCredits(BigDecimal valueCredits) {
        this.valueCredits = valueCredits;
    }

    public Long getHashTotal() {
        return hashTotal;
    }

    public void setHashTotal(Long hashTotal) {
        this.hashTotal = hashTotal;
    }

    public Short getRecLength() {
        return recLength;
    }

    public void setRecLength(Short recLength) {
        this.recLength = recLength;
    }

    public Short getBlockFactor() {
        return blockFactor;
    }

    public void setBlockFactor(Short blockFactor) {
        this.blockFactor = blockFactor;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getWrittenToAxd() {
        return writtenToAxd;
    }

    public void setWrittenToAxd(String writtenToAxd) {
        this.writtenToAxd = writtenToAxd;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (delDeliveryFilesCccPK != null ? delDeliveryFilesCccPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DelDeliveryFilesCcc)) {
            return false;
        }
        DelDeliveryFilesCcc other = (DelDeliveryFilesCcc) object;
        if ((this.delDeliveryFilesCccPK == null && other.delDeliveryFilesCccPK != null) || (this.delDeliveryFilesCccPK != null && !this.delDeliveryFilesCccPK.equals(other.delDeliveryFilesCccPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.DelDeliveryFilesCcc[ delDeliveryFilesCccPK=" + delDeliveryFilesCccPK + " ]";
    }
    
}
