package com.bsva.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSO_SYSTEM_PARAMETERS")
@NamedQueries({
    @NamedQuery(name = "CsoSystemParameters.findAll", query = "SELECT c FROM CsoSystemParameters c"),
    @NamedQuery(name = "CsoSystemParameters.findByProcessDate", query = "SELECT c FROM CsoSystemParameters c WHERE c.processDate = :processDate"),
    @NamedQuery(name = "CsoSystemParameters.findByProcessActiveInd", query = "SELECT c FROM CsoSystemParameters c WHERE c.processActiveInd = :processActiveInd"),
    @NamedQuery(name = "CsoSystemParameters.findByLiveTestCode", query = "SELECT c FROM CsoSystemParameters c WHERE c.liveTestCode = :liveTestCode"),
    @NamedQuery(name = "CsoSystemParameters.findByCisDownloadInd", query = "SELECT c FROM CsoSystemParameters c WHERE c.cisDownloadInd = :cisDownloadInd"),
    @NamedQuery(name = "CsoSystemParameters.findByEodDone", query = "SELECT c FROM CsoSystemParameters c WHERE c.eodDone = :eodDone"),
    @NamedQuery(name = "CsoSystemParameters.findByRunBatch", query = "SELECT c FROM CsoSystemParameters c WHERE c.runBatch = :runBatch"),
    @NamedQuery(name = "CsoSystemParameters.findByUnixSodDone", query = "SELECT c FROM CsoSystemParameters c WHERE c.unixSodDone = :unixSodDone"),
    @NamedQuery(name = "CsoSystemParameters.findByCccoreInterval", query = "SELECT c FROM CsoSystemParameters c WHERE c.cccoreInterval = :cccoreInterval"),
    @NamedQuery(name = "CsoSystemParameters.findByNextOutputDate", query = "SELECT c FROM CsoSystemParameters c WHERE c.nextOutputDate = :nextOutputDate")})
@DynamicUpdate
public class CsoSystemParameters implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROCESS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date processDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PROCESS_ACTIVE_IND")
    private String processActiveInd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "LIVE_TEST_CODE")
    private String liveTestCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CIS_DOWNLOAD_IND")
    private String cisDownloadInd;
    @Size(max = 1)
    @Column(name = "EOD_DONE")
    private String eodDone;
    @Size(max = 1)
    @Column(name = "RUN_BATCH")
    private String runBatch;
    @Size(max = 1)
    @Column(name = "UNIX_SOD_DONE")
    private String unixSodDone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CCCORE_INTERVAL")
    private short cccoreInterval;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NEXT_OUTPUT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextOutputDate;

    public CsoSystemParameters() {
    }

    public CsoSystemParameters(Date nextOutputDate) {
        this.nextOutputDate = nextOutputDate;
    }

    public CsoSystemParameters(Date nextOutputDate, Date processDate, String processActiveInd, String liveTestCode, String cisDownloadInd, short cccoreInterval) {
        this.nextOutputDate = nextOutputDate;
        this.processDate = processDate;
        this.processActiveInd = processActiveInd;
        this.liveTestCode = liveTestCode;
        this.cisDownloadInd = cisDownloadInd;
        this.cccoreInterval = cccoreInterval;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getProcessActiveInd() {
        return processActiveInd;
    }

    public void setProcessActiveInd(String processActiveInd) {
        this.processActiveInd = processActiveInd;
    }

    public String getLiveTestCode() {
        return liveTestCode;
    }

    public void setLiveTestCode(String liveTestCode) {
        this.liveTestCode = liveTestCode;
    }

    public String getCisDownloadInd() {
        return cisDownloadInd;
    }

    public void setCisDownloadInd(String cisDownloadInd) {
        this.cisDownloadInd = cisDownloadInd;
    }

    public String getEodDone() {
        return eodDone;
    }

    public void setEodDone(String eodDone) {
        this.eodDone = eodDone;
    }

    public String getRunBatch() {
        return runBatch;
    }

    public void setRunBatch(String runBatch) {
        this.runBatch = runBatch;
    }

    public String getUnixSodDone() {
        return unixSodDone;
    }

    public void setUnixSodDone(String unixSodDone) {
        this.unixSodDone = unixSodDone;
    }

    public short getCccoreInterval() {
        return cccoreInterval;
    }

    public void setCccoreInterval(short cccoreInterval) {
        this.cccoreInterval = cccoreInterval;
    }

    public Date getNextOutputDate() {
        return nextOutputDate;
    }

    public void setNextOutputDate(Date nextOutputDate) {
        this.nextOutputDate = nextOutputDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nextOutputDate != null ? nextOutputDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsoSystemParameters)) {
            return false;
        }
        CsoSystemParameters other = (CsoSystemParameters) object;
        if ((this.nextOutputDate == null && other.nextOutputDate != null) || (this.nextOutputDate != null && !this.nextOutputDate.equals(other.nextOutputDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoSystemParameters[ nextOutputDate=" + nextOutputDate + " ]";
    }
    
}
