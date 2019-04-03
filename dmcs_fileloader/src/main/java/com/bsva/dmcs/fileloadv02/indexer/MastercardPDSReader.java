package com.bsva.dmcs.fileloadv02.indexer;

import com.bsva.dmcs.fileloadv02.dto.MastercardPDSDTO;

import java.util.ArrayList;
import java.util.List;

import static com.bsva.dmcs.fileloadv02.util.StringUtils.parseInt;
import static com.bsva.dmcs.fileloadv02.util.StringUtils.substring;

/**
 * TODO Document
 */
public class MastercardPDSReader {

    public static List<MastercardPDSDTO> read(Long txnSeqNumber, String line){

        // String line = "0580023003CT60052003211014800471020158012          MD0165001M";
        // line = "05000511CARDMASTERCARD111111000001010000000111010000101000010111100001111000000000001000000010000000000000000000001100000000000000000000000000000000001240165359243009924475   000000000000035000000000035000000000035000000000000000000000000000000000000000000017022315071711170000000000000000000000000160050SS51110002000000792200000000000000000000000000000000000000000237522100705400000002810500000000000001100000001264                                                                                                                         404584  0000000    00000000289201479I COMPUTICKET WEB     \\                         \\VICTORY PARK \\0000      ZA ZAF                                                                                                                                                                   0580023003CT60052003211014800471020158012          MD0165001M                                                                                                                                                                                                710710710                0000000000000000000                    000                                                                                                                                                                                                                                                               000                                           016          0223                   0000000000000000511000                                                                                                    0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   11000000014121100000001264000000000000                0000000000000000                         000000000000000000000000                                                                                          000            000                                           000                                           000                                           000                                           CCB0003D";
        List<MastercardPDSDTO> pdsList = new ArrayList<>();

        try {
            Integer lineLen = line.length();
            if (lineLen < 818) {
                System.out.println("INVALID LINE.");
                return pdsList;
            }

            Integer pdsPayloadLen = parseInt(substring(line, 815, 818));
            String pdsPayload = substring(line, 818, 818 + pdsPayloadLen);

            int idx = 0;
            while (idx < pdsPayloadLen) {

                try {
                    Integer pdsNumber = parseInt(substring(pdsPayload, idx, idx + 4));
                    Integer pdsLen = parseInt(substring(pdsPayload, idx + 4, idx + 4 + 3));
                    String pdsData = substring(pdsPayload, idx + 4 + 3, idx + 4 + 3 + pdsLen);

                    idx = idx + 4 + 3 + pdsLen;

                    if (pdsNumber.intValue() == 146) {
                        // Skip billing PDS. Will construct one
                        continue;
                    }
                    pdsList.add(
                            new MastercardPDSDTO(txnSeqNumber, pdsNumber, pdsLen, pdsData));
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println(line);
            e.printStackTrace();
        }
        return pdsList;
    }
}
