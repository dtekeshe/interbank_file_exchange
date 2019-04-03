package com.bsva.dmcs.fileloadv02.billing;

import com.bsva.dmcs.fileloadv02.dto.MastercardPDSDTO;
import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.dmcs.fileloadv02.util.StringUtils;
import com.bsva.dmcs.reportv02.util.Justification;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.bsva.dmcs.fileloadv02.util.StringUtils.parseInt;
import static com.bsva.dmcs.fileloadv02.util.StringUtils.substring;
import static com.bsva.dmcs.reportv02.util.StringUtils.format;

/**
 * TODO Document
 */
public class MastercardPDSConstructor {

    /**
     * PDS Number 146 constructor
     * as specified on page 540 of the IP Manual
     *
     * @param txnSeqNumber
     * @param isDebitTxn
     * @return
     */
    public static MastercardPDSDTO pds146(Long txnSeqNumber, boolean isDebitTxn, Double txnFeeAmount) {

        // 019014800471020165001M
        // 0620146036002900710000000000059710000000000059
        // 062 0146 036 00 29 00 710 000000000059 710 000000000059

        StringBuilder pdsData = new StringBuilder();

        // PDS 146 sub fields

        // sub field 1, positions 1 - 2, fee type code,
        //              '00' - transaction interchange fee
        pdsData.append("00");

        // sub field 2, positions 3 - 4, fee processing code,
        //              '19' debit, '29' credit transaction
        pdsData.append(isDebitTxn ? "29" : "19");

        // sub field 3, positions 5 - 6, fee settlement indicator
        //              '00' - settlement doesn't apply
        //              '01' - settlement data exist in PDS 0159
        pdsData.append("00");

        // sub field 4, positions 7 - 9, currency code for transaction fee
        pdsData.append("710");

        // sub field 5, positions 10 - 21, transaction fee amount, format n012
        pdsData.append( format( txnFeeAmount, 12, '0', Justification.RIGHT) );

        // sub field 6, positions 22 - 25, currency code for reconciliation
        pdsData.append("710");

        // sub field 7, positions, 25 - 36, reconcialiation fee, format n012
        pdsData.append( format( txnFeeAmount, 12, '0', Justification.RIGHT) );

        Integer pdsLen = pdsData.toString().length();
        MastercardPDSDTO pds
                = new MastercardPDSDTO(
                        txnSeqNumber, 146, pdsLen, pdsData.toString());

        return pds;
    }

    private static Long abs(Long txnFeeAmount) {

        return Math.abs(txnFeeAmount);
    }

    public static void combine(FileDetailDTO tcr0, List<MastercardPDSDTO> pdsList) {

        String input = tcr0.getInput();

        Collections.sort(pdsList, new Comparator<MastercardPDSDTO>() {
            @Override
            public int compare(MastercardPDSDTO o1, MastercardPDSDTO o2) {
                return o1.getPdsNumber().compareTo(o2.getPdsNumber());
            }
        });

        String pdsPayload = "";

        for (MastercardPDSDTO pds : pdsList) {
            pdsPayload += format(pds.getPdsNumber(), 4, '0', Justification.RIGHT);
            pdsPayload += format(pds.getPdsLen(), 3, '0', Justification.RIGHT);
            pdsPayload += format(pds.getPdsData(), pds.getPdsLen(), ' ', Justification.LEFT);
        }

        String result = input.substring(0, 815) +
                        format(pdsPayload.length(), 3, '0', Justification.RIGHT) +
                        format(pdsPayload, 250, ' ', Justification.LEFT) +
                        input.substring(1068);

        tcr0.setInput(result);
    }
}
