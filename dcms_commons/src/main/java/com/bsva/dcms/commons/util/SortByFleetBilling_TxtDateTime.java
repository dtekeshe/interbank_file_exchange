package com.bsva.dcms.commons.util;

import com.bsva.dcms.commons.dto.CsoFleetBillingDTO;
import java.util.Comparator;

/**
 *
 * @author SimphiweT
 */
public class SortByFleetBilling_TxtDateTime implements Comparator<CsoFleetBillingDTO> {

    @Override
    public int compare(CsoFleetBillingDTO o1, CsoFleetBillingDTO o2) {
        
        CsoFleetBillingDTO billingDTO1 = (CsoFleetBillingDTO) o1;
        CsoFleetBillingDTO billingDTO2 = (CsoFleetBillingDTO) o2;
        return (int) (billingDTO1.getTxDateTime() - billingDTO2.getTxDateTime());
        
    }
    
}
