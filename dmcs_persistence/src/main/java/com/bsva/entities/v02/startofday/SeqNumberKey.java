package com.bsva.entities.v02.startofday;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * TODO Document
 */
@Embeddable
public class SeqNumberKey implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String filenamePrefix;
    private final String destDistCode;

    public SeqNumberKey(String filenamePrefix, String destDistCode) {
        this.filenamePrefix = filenamePrefix;
        this.destDistCode = destDistCode;
    }

    public String getFilenamePrefix() {
        return filenamePrefix;
    }

    public String getDestDistCode() {
        return destDistCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeqNumberKey that = (SeqNumberKey) o;

        if (filenamePrefix != null ? !filenamePrefix.equals(that.filenamePrefix) : that.filenamePrefix != null)
            return false;
        return !(destDistCode != null ? !destDistCode.equals(that.destDistCode) : that.destDistCode != null);

    }

    @Override
    public int hashCode() {
        int result = filenamePrefix != null ? filenamePrefix.hashCode() : 0;
        result = 31 * result + (destDistCode != null ? destDistCode.hashCode() : 0);
        return result;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SeqNumberKey [filenamePrefix=");
		builder.append(filenamePrefix);
		builder.append(", destDistCode=");
		builder.append(destDistCode);
		builder.append("]");
		return builder.toString();
	}
}
