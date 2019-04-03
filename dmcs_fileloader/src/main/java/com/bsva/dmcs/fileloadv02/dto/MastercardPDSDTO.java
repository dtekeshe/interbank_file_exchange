package com.bsva.dmcs.fileloadv02.dto;

import com.bsva.dmcs.reportv02.util.Justification;

import static com.bsva.dmcs.reportv02.util.StringUtils.format;

/**
 * TODO Document
 */
public class MastercardPDSDTO {

    private final Long txnSeqNumber;
    private final Integer pdsNumber;
    private final Integer pdsLen;
    private final String pdsData;
    private String pdsString;

    public MastercardPDSDTO(Long txnSeqNumber, Integer pdsNumber, Integer pdsLen, String pdsData) {
        this.txnSeqNumber = txnSeqNumber;
        this.pdsNumber = pdsNumber;
        this.pdsLen = pdsLen;
        this.pdsData = pdsData;
    }

    public Long getTxnSeqNumber() {
        return txnSeqNumber;
    }

    public Integer getPdsNumber() {
        return pdsNumber;
    }

    public Integer getPdsLen() {
        return pdsLen;
    }

    public String getPdsData() {
        return pdsData;
    }

    public String getPdsString() {

        String result = format( pdsNumber, 4, '0', Justification.RIGHT) +
                        format( pdsLen, 3, '0', Justification.RIGHT) +
                        pdsData;

        return result;
    }
}
