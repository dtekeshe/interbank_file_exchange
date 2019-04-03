package com.bsva.entities.v02.startofday;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

/**
 * Number of default output file per sub service.
 * This is used to check if default output file generation was successful.
 *
 * TODO More documentation
 */
@Entity
@DynamicUpdate
public class DefaultOutputFileCountEntity {

    @EmbeddedId
    private SubServiceKey id;
    @Column(name = "DEFAULT_COUNT")
    private Integer defaultCount;

    public SubServiceKey getId() {
        return id;
    }

    public void setId(SubServiceKey id) {
        this.id = id;
    }

    public Integer getDefaultCount() {
        return defaultCount;
    }

    public void setDefaultCount(Integer defaultCount) {
        this.defaultCount = defaultCount;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((defaultCount == null) ? 0 : defaultCount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		DefaultOutputFileCountEntity other = (DefaultOutputFileCountEntity) obj;
		if (defaultCount == null) {
			if (other.defaultCount != null)
				return false;
		} else if (!defaultCount.equals(other.defaultCount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DefaultOutputFileCountEntity [id=");
		builder.append(id);
		builder.append(", defaultCount=");
		builder.append(defaultCount);
		builder.append("]");
		return builder.toString();
	}
}
