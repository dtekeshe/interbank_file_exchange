package com.bsva.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author SimphiweT
 */
@Embeddable
public class CsvSarbBillingViewPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "RATE_DESCRIPTOR")
    private String rateDescriptor;

    public String getRateDescriptor() {
        return rateDescriptor;
    }

    public void setRateDescriptor(String rateDescriptor) {
        this.rateDescriptor = rateDescriptor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((rateDescriptor == null) ? 0 : rateDescriptor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CsvSarbBillingViewPK other = (CsvSarbBillingViewPK) obj;
        if (!Objects.equals(this.rateDescriptor, other.rateDescriptor)) {
            return false;
        }
        return true;
    }
}
