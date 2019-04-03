package com.bsva.entities.v02.startofday;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * TODO Document
 */
@Entity
public class SeqNumberEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
    private final SeqNumberKey id;
    private Integer seqNumber;

    public SeqNumberEntity(SeqNumberKey id, Integer seqNumber) {
        this.id = id;
        this.seqNumber = seqNumber;
    }

    public SeqNumberKey getId() {
        return id;
    }

    public Integer getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(Integer seqNumber) {
		this.seqNumber = seqNumber;
	}

	public void incrementSeqNumber() {
        if (seqNumber == null) {
            seqNumber = 0;
        }
        seqNumber = new Integer(seqNumber.intValue() + 1);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((seqNumber == null) ? 0 : seqNumber.hashCode());
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
		SeqNumberEntity other = (SeqNumberEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		if (seqNumber == null) {
			if (other.seqNumber != null)
				return false;
		}
		else if (!seqNumber.equals(other.seqNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append(seqNumber);
		return builder.toString();
	}
}
