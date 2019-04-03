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
@Table(name = "CSO_SPOLOG")
@NamedQueries({
    @NamedQuery(name = "CsoSpolog.findAll", query = "SELECT c FROM CsoSpolog c")
    , @NamedQuery(name = "CsoSpolog.findByProcessNameSeq", query = "SELECT c FROM CsoSpolog c WHERE c.processNameSeq = :processNameSeq")
    , @NamedQuery(name = "CsoSpolog.findByMessageSeq", query = "SELECT c FROM CsoSpolog c WHERE c.messageSeq = :messageSeq")
    , @NamedQuery(name = "CsoSpolog.findByProcessName", query = "SELECT c FROM CsoSpolog c WHERE c.processName = :processName")
    , @NamedQuery(name = "CsoSpolog.findByMessage", query = "SELECT c FROM CsoSpolog c WHERE c.message = :message")
    , @NamedQuery(name = "CsoSpolog.findByVersion", query = "SELECT c FROM CsoSpolog c WHERE c.version = :version")})
@DynamicUpdate
public class CsoSpolog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROCESS_NAME_SEQ")
   // @Temporal(TemporalType.TIMESTAMP)
    private long processNameSeq;
    @Column(name = "MESSAGE_SEQ")
    //@Temporal(TemporalType.TIMESTAMP)
    private long messageSeq;
    @Size(max = 255)
    @Column(name = "PROCESS_NAME")
    private String processName;
    @Size(max = 255)
    @Column(name = "MESSAGE")
    private String message;
    @Size(max = 30)
    @Column(name = "VERSION")
    private String version;

    public CsoSpolog() {
    }

    public CsoSpolog(long processNameSeq) {
        this.processNameSeq = processNameSeq;
    }

    public long getProcessNameSeq() {
        return processNameSeq;
    }

    public void setProcessNameSeq(long processNameSeq) {
        this.processNameSeq = processNameSeq;
    }

    public long getMessageSeq() {
        return messageSeq;
    }

    public void setMessageSeq(long messageSeq) {
        this.messageSeq = messageSeq;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getMessage() {
        return message;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + (int) (messageSeq ^ (messageSeq >>> 32));
		result = prime * result + ((processName == null) ? 0 : processName.hashCode());
		result = prime * result + (int) (processNameSeq ^ (processNameSeq >>> 32));
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CsoSpolog other = (CsoSpolog) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (messageSeq != other.messageSeq)
			return false;
		if (processName == null) {
			if (other.processName != null)
				return false;
		} else if (!processName.equals(other.processName))
			return false;
		if (processNameSeq != other.processNameSeq)
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	public void setMessage(String message) {
        this.message = message;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

  
    @Override
    public String toString() {
        return "com.bsva.entities.CsoSpolog[ processNameSeq=" + processNameSeq + " ]";
    }
    
}
