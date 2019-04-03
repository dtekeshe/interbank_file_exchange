
package com.bsva.dcms.commons.util;

import com.bsva.dcms.commons.dto.CsoFleetBillingDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SimphiweT
 */
public class FleetBillingDTO {
    
    
    private Map<String, List<CsoFleetBillingDTO>> billingMap = new HashMap<>();

    public Map<String, List<CsoFleetBillingDTO>> getBillingMap() {
        return billingMap;
    }

    public void setBillingMap(Map<String, List<CsoFleetBillingDTO>> billingMap) {
        this.billingMap = billingMap;
    }
    
    
    
}
