package com.bsva.dmcs.fileloadv02.billing;

import com.bsva.dmcs.fileloadv02.dto.Service;
import com.bsva.dmcs.fileloadv02.dto.SubService;
import com.bsva.dmcs.fileloadv02.model.BillingData;
import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.dmcs.fileloadv02.model.TerminalInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * TODO Document
 */
@SuppressWarnings("unused")
public class DeferredBilateralBillingCalculator extends BillingCalculator {

    private final Service service;
    private final SubService subService;
    private final BigDecimal vatRate;

    public DeferredBilateralBillingCalculator( Service service,
                                               SubService subService,
                                               BigDecimal vatRate) {
        this.service = service;
        this.subService = subService;
        this.vatRate = vatRate;
    }

    @Override
    public void bill(List<FileDetailDTO> records) {

        // defaults
        FileDetailDTO financialRecord = records.get(0);
        // default terminal
        TerminalInfo defaultTermial = new TerminalInfo();
        financialRecord.setTerminalInfo(defaultTermial);
        // default billing data
        BillingData billingData = new BillingData();
        financialRecord.setBillingData(billingData);
    }
}
