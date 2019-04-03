package com.bsva.dao.v02.settlement;

import com.bsva.dao.AbstractDao;
import com.bsva.dto.AcquirerCode;
import com.bsva.dto.IssuerCode;
import com.bsva.dto.StatementDTO;
import com.bsva.entities.v02.settlement.CCR002DataEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class CCR002DataDAO extends AbstractDao<CCR002DataEntity, Void> {

    private final static String CCR002_DATA_SQL =
            "  SELECT ISSUER_CODE, MEMBER_NO AS FULL_BANK_CODE, ISSUER_MEMBER, ACQUIRER_CODE, ACQUIRER_MEMBER,      " +
                    "         SUM(BILLING_FEE) AS INTERCHANGE_FEES                                                  " +
                    "     FROM CSV_CCR00X_DATA_VIEW V                                                               " +
                    "     JOIN CSF_MEMBERS M                                                                        " +
                    "       ON (V.ISSUER_CODE = M.BANK_CODE)                                                        " +
                    "    GROUP BY ISSUER_CODE, MEMBER_NO, ISSUER_MEMBER, ACQUIRER_CODE, ACQUIRER_MEMBER             ";

    public Map<IssuerCode, Map<AcquirerCode, StatementDTO>> ccr002Data() {

        // execute
        List<CCR002DataEntity> entities = list(CCR002_DATA_SQL, CCR002DataEntity.class);

        Map<IssuerCode, Map<AcquirerCode, StatementDTO>> ccr002Data = new HashMap<>();

        // prepare result
        for (CCR002DataEntity entity : entities) {

            IssuerCode issuerCode = new IssuerCode(entity.getId().getIssuerCode());
            issuerCode.setFullBankCode(entity.getFullBankCode());
            issuerCode.setBankName(entity.getIssuerMember());

            AcquirerCode acquirerCode = new AcquirerCode(entity.getId().getAcquirerCode());

            // --- OFF US ------------------------------------------------------------------------------------
            // get data for this issuer
            Map<AcquirerCode, StatementDTO> issuerData = ccr002Data.get(issuerCode);
            if (issuerData == null) {
                issuerData = new HashMap<>();
                ccr002Data.put(issuerCode, issuerData);
            }

            // get acquirer data for this issuer
            StatementDTO statementDTO = issuerData.get(acquirerCode.getAcquirerCode());
            if (statementDTO != null) {
                statementDTO = new StatementDTO();
                issuerData.put(acquirerCode, statementDTO);
            }

            statementDTO.addIssuingInterchangeFee(entity.getInterchangeFee());

            // --- ON US --------------------------------------------------------------------------------------
            // get data for this issuer
            Map<AcquirerCode, StatementDTO> acquirerData
                    = ccr002Data.get(new IssuerCode(acquirerCode.getAcquirerCode()));

            if (acquirerData == null) {
                issuerData = new HashMap<>();
                ccr002Data.put(new IssuerCode(acquirerCode.getAcquirerCode()), acquirerData);
            }

            // get acquirer data for this issuer
            statementDTO = issuerData.get(new AcquirerCode(issuerCode.getIssuerCode()));
            if (statementDTO != null) {
                statementDTO = new StatementDTO();
                issuerData.put(new AcquirerCode(issuerCode.getIssuerCode()), statementDTO);
            }

            statementDTO.addAcquiringInterchangeFee(entity.getInterchangeFee());
        }

        return ccr002Data;
    }
}
