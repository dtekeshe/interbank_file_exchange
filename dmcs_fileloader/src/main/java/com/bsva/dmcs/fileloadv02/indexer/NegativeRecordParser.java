package com.bsva.dmcs.fileloadv02.indexer;

import com.bsva.dmcs.fileloadv02.dto.MemberInfoDTO;
import com.bsva.dmcs.fileloadv02.dto.NegativeRecordDTO;
import com.bsva.dmcs.fileloadv02.model.MemberInfoBean;

import static com.bsva.dmcs.fileloadv02.util.StringUtils.parseInt;
import static com.bsva.dmcs.fileloadv02.util.StringUtils.substring;

/**
 * TODO Document
 */
public class NegativeRecordParser {

    private final MemberInfoBean memberInfoBean;

    public NegativeRecordParser(MemberInfoBean memberInfoBean) {
        this.memberInfoBean = memberInfoBean;
    }

    public NegativeRecordDTO parse(Integer fileRefNumber, String line) {

        /*
                              ( Integer fileRefNumber,
                              String transactionCode,
                              String destBinNumber,
                              String sourceBinNumber,
                              Integer transactionType,
                              Integer authCentre,
                              String negativeAccNumber,
                              String responseCode,
                              Integer purgeDate,
                              String regionCode,
                              String cardHolderName,
                              Integer acquirer) {
         */
        NegativeRecordDTO negativeRecord =
                new NegativeRecordDTO(
                        fileRefNumber,
                        substring(line,0,  2),  // transactionCode
                        substring(line,2,  8),  // destBinNumber
                        substring(line,8,  14), // sourceBinNumber
                        parseInt(line, 14, 15), // transactionType
                        parseInt(line, 15, 19), // authCentre
                        substring(line, 19, 35), // negativeAccNumber
                        substring(line, 35, 37), // responseCode
                        parseInt(line, 37, 41), // purgeDate
                        substring(line, 41, 50), // regionCode
                        substring(line, 50, 121), // cardHolderName
                        getAcquirerBankCode(parseInt(line,8,  14)) // acquirer bank code
                                                                    // from sourceBinNumber
                );

        return negativeRecord;
    }

    private Integer getAcquirerBankCode(Integer sourceBinNumber) {
        MemberInfoDTO acquiringMember = memberInfoBean.getMemberByBin(sourceBinNumber);
        return acquiringMember != null ? acquiringMember.getBankCode() : 0;
    }
}
