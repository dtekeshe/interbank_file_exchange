package com.bsva.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;

/**
 *
 * @author SimphiweT
 */
public class CsfCardRateLookupViewPK implements Serializable {


    @Column(name = "SERVICE")
    private String service;

    public CsfCardRateLookupViewPK() {
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((service == null) ? 0 : service.hashCode());
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
        final CsfCardRateLookupViewPK other = (CsfCardRateLookupViewPK) obj;
        if (!Objects.equals(this.service, other.service)) {
            return false;
        }
        return true;
    }
    
}
