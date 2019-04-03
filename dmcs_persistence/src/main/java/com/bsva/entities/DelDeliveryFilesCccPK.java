package com.bsva.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AugustineA
 */
@Embeddable
public class DelDeliveryFilesCccPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "POSITION")
    private int position;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "QUEUE_FILE_NAME")
    private String queueFileName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FILENAME")
    private String filename;

    public DelDeliveryFilesCccPK() {
    }

    public DelDeliveryFilesCccPK(int position, String queueFileName, String filename) {
        this.position = position;
        this.queueFileName = queueFileName;
        this.filename = filename;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getQueueFileName() {
        return queueFileName;
    }

    public void setQueueFileName(String queueFileName) {
        this.queueFileName = queueFileName;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) position;
        hash += (queueFileName != null ? queueFileName.hashCode() : 0);
        hash += (filename != null ? filename.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DelDeliveryFilesCccPK)) {
            return false;
        }
        DelDeliveryFilesCccPK other = (DelDeliveryFilesCccPK) object;
        if (this.position != other.position) {
            return false;
        }
        if ((this.queueFileName == null && other.queueFileName != null) || (this.queueFileName != null && !this.queueFileName.equals(other.queueFileName))) {
            return false;
        }
        if ((this.filename == null && other.filename != null) || (this.filename != null && !this.filename.equals(other.filename))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.DelDeliveryFilesCccPK[ position=" + position + ", queueFileName=" + queueFileName + ", filename=" + filename + " ]";
    }
    
}
