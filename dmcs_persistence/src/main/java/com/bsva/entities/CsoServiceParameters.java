/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSO_SERVICE_PARAMETERS")
@NamedQueries({
    @NamedQuery(name = "CsoServiceParameters.findAll", query = "SELECT c FROM CsoServiceParameters c"),
    @NamedQuery(name = "CsoServiceParameters.findByProcessDate", query = "SELECT c FROM CsoServiceParameters c WHERE c.csoServiceParametersPK.processDate = :processDate"),
    @NamedQuery(name = "CsoServiceParameters.findByService", query = "SELECT c FROM CsoServiceParameters c WHERE c.csoServiceParametersPK.service = :service"),
    @NamedQuery(name = "CsoServiceParameters.findBySubService", query = "SELECT c FROM CsoServiceParameters c WHERE c.csoServiceParametersPK.subService = :subService"),
    @NamedQuery(name = "CsoServiceParameters.findByProcessActiveInd", query = "SELECT c FROM CsoServiceParameters c WHERE c.processActiveInd = :processActiveInd"),
    @NamedQuery(name = "CsoServiceParameters.findByInwardStatus", query = "SELECT c FROM CsoServiceParameters c WHERE c.inwardStatus = :inwardStatus"),
    @NamedQuery(name = "CsoServiceParameters.findByOutwardStatus", query = "SELECT c FROM CsoServiceParameters c WHERE c.outwardStatus = :outwardStatus"),
    @NamedQuery(name = "CsoServiceParameters.findByInputRequestClose", query = "SELECT c FROM CsoServiceParameters c WHERE c.inputRequestClose = :inputRequestClose")})
@DynamicUpdate
public class CsoServiceParameters implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsoServiceParametersPK csoServiceParametersPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PROCESS_ACTIVE_IND")
    private String processActiveInd;
    @Size(max = 1)
    @Column(name = "INWARD_STATUS")
    private String inwardStatus;
    @Size(max = 1)
    @Column(name = "OUTWARD_STATUS")
    private String outwardStatus;
    @Size(max = 1)
    @Column(name = "INPUT_REQUEST_CLOSE")
    private String inputRequestClose;

    public CsoServiceParameters() {
    }

    public CsoServiceParameters(CsoServiceParametersPK csoServiceParametersPK) {
        this.csoServiceParametersPK = csoServiceParametersPK;
    }

    public CsoServiceParameters(CsoServiceParametersPK csoServiceParametersPK, String processActiveInd) {
        this.csoServiceParametersPK = csoServiceParametersPK;
        this.processActiveInd = processActiveInd;
    }

    public CsoServiceParameters(Date processDate, String service, String subService) {
        this.csoServiceParametersPK = new CsoServiceParametersPK(processDate, service, subService);
    }

    public CsoServiceParametersPK getCsoServiceParametersPK() {
        return csoServiceParametersPK;
    }

    public void setCsoServiceParametersPK(CsoServiceParametersPK csoServiceParametersPK) {
        this.csoServiceParametersPK = csoServiceParametersPK;
    }

    public String getProcessActiveInd() {
        return processActiveInd;
    }

    public void setProcessActiveInd(String processActiveInd) {
        this.processActiveInd = processActiveInd;
    }

    public String getInwardStatus() {
        return inwardStatus;
    }

    public void setInwardStatus(String inwardStatus) {
        this.inwardStatus = inwardStatus;
    }

    public String getOutwardStatus() {
        return outwardStatus;
    }

    public void setOutwardStatus(String outwardStatus) {
        this.outwardStatus = outwardStatus;
    }

    public String getInputRequestClose() {
        return inputRequestClose;
    }

    public void setInputRequestClose(String inputRequestClose) {
        this.inputRequestClose = inputRequestClose;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csoServiceParametersPK != null ? csoServiceParametersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CsoServiceParameters)) {
            return false;
        }
        CsoServiceParameters other = (CsoServiceParameters) object;
        if ((this.csoServiceParametersPK == null && other.csoServiceParametersPK != null) || (this.csoServiceParametersPK != null && !this.csoServiceParametersPK.equals(other.csoServiceParametersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsoServiceParameters[ csoServiceParametersPK=" + csoServiceParametersPK + " ]";
    }
    
}
