package com.bsva.entities.v02.params;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * TODO Document
 */
@Embeddable
public class DirectoryKey implements Serializable {

    @Column (name = "HOST_NAME")
    private String hostName;

    @Column (name = "DIRECTORY_NAME")
    private String directoryName;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectoryKey that = (DirectoryKey) o;

        if (hostName != null ? !hostName.equals(that.hostName) : that.hostName != null) return false;
        return !(directoryName != null ? !directoryName.equals(that.directoryName) : that.directoryName != null);

    }

    @Override
    public int hashCode() {
        int result = hostName != null ? hostName.hashCode() : 0;
        result = 31 * result + (directoryName != null ? directoryName.hashCode() : 0);
        return result;
    }
}
